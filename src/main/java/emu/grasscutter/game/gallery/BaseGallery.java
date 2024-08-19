package emu.grasscutter.game.gallery;

import org.anime_game_servers.gi_lua.models.ScriptArgs;
import org.anime_game_servers.gi_lua.models.constants.EventType;
import org.anime_game_servers.gi_lua.models.constants.GalleryStopReason;
import org.anime_game_servers.lua.engine.LuaTable;
import org.anime_game_servers.lua.engine.LuaValue;
import org.anime_game_servers.multi_proto.gi.messages.gallery.GalleryStageType;
import org.anime_game_servers.multi_proto.gi.messages.gallery.SceneGalleryInfo;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.excels.GalleryData;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.scripts.lua_engine.GroupEventLuaContext;
import emu.grasscutter.server.packet.send.PacketAbilityChangeNotify;
import emu.grasscutter.server.packet.send.PacketGalleryPreStartNotify;
import emu.grasscutter.server.packet.send.PacketGalleryStartNotify;
import emu.grasscutter.server.packet.send.PacketGalleryStopNotify;
import emu.grasscutter.server.packet.send.PacketSceneGalleryInfoNotify;
import emu.grasscutter.server.packet.send.PacketSyncTeamEntityNotify;
import lombok.Getter;
import lombok.val;

import java.util.ArrayList;

public abstract class BaseGallery {
    @Getter private final Scene scene;
    @Getter private final GalleryData config;

    @Getter private int startTime;
    @Getter private int endTime;
    @Getter private GalleryStageType stage = GalleryStageType.GALLERY_NONE;

    //TODO: On multiplayer store the players here

    public abstract void onProtoGenerate(SceneGalleryInfo info);
    public abstract void onStop();

    public BaseGallery(Scene scene, GalleryData config) {
        this.scene = scene;
        this.config = config;

        this.scene.getGalleries().putIfAbsent(config.getId(), this);
    }

    public void load() {
        this.scene.loadDynamicGroup(config.getControlGroupId());
        this.scene.loadDynamicGroup(config.getRevivePointGroupId());
    }

    public void notifyInfo() {
        var info = new SceneGalleryInfo();
        info.setGalleryId(config.getId());
        info.setStartTime(startTime);
        info.setEndTime(endTime);
        info.setStage(stage);
        info.setPreStartEndTime(startTime); //TODO
        info.setProgressInfoList(new ArrayList<>()); //TODO
        info.setPlayerCount(1); //TODO
        info.setOwnerUid(scene.getWorld().getOwner().getUid());

        onProtoGenerate(info);

        scene.broadcastPacket(new PacketSceneGalleryInfoNotify(info));
    }

    private boolean startTimed(int duration) {
        int endTime = scene.getSceneTimeSeconds() + duration;

        //Add timer here
        Grasscutter.getGameServer().getScheduler().scheduleDelayedTask(() -> {
            this.start();
        }, duration);

        stage = GalleryStageType.GALLERY_PRESTART;

        //TODO: Send event here
        //scene.getScriptManager().callEvent(new ScriptArgs(config.getControlGroupId(), EventType.EVENT_GALLERY_PRE_START, config.getId()));

        //Send notify here
        scene.broadcastPacket(new PacketGalleryPreStartNotify(config.getId(), endTime));

        return true;
    }

    public boolean initStart() {
        if(scene.getWorld().isMultiplayer()) return false; //TODO

        //TODO: Check if current gallery is stopped
        scene.getWorld().getOwner().setCurrentGallery(config.getId());

        if(config.isEnableSinglePrepare() && config.getSinglePrepareTime() != 0)
            return startTimed(config.getSinglePrepareTime());

        return start();
    }

    public boolean stop(boolean isInterrupt, GalleryStopReason reason) {
        scene.getWorld().getOwner().getTeamManager().removeAbilityFromAvatars("SceneObj_Dynamic_WindFlora_ShootBalloon");

        val args = new ScriptArgs(config.getControlGroupId(), EventType.EVENT_GALLERY_STOP, config.getId(), isInterrupt ? 1 : 0);
        args.setParam3(reason.getValue());
        scene.getScriptManager().callEvent(args);

        scene.broadcastPacket(new PacketGalleryStopNotify(config.getId()));

        onStop();

        return true;
    }

    public boolean start() {
        //Check if team is locked
        //Check if trial avatar is used
        if(scene.getWorld().isMultiplayer()) return false; //TODO

        stage = GalleryStageType.GALLERY_START;

        int startTime = scene.getSceneTimeSeconds();
        int endTime = startTime + config.getDuration();

        //Add timer here
        Grasscutter.getGameServer().getScheduler().scheduleDelayedTask(() -> {
            this.stop(false, GalleryStopReason.GALLERY_STOP_TIMEUP);
        }, config.getDuration());

        //TODO
        scene.getWorld().getOwner().getTeamManager().addAbilityToAvatars("SceneObj_Dynamic_WindFlora_ShootBalloon");

        scene.getScriptManager().callEvent(new ScriptArgs(config.getControlGroupId(), EventType.EVENT_GALLERY_START, config.getId()));

        scene.broadcastPacket(new PacketGalleryStartNotify(config.getId(), startTime, endTime, scene.getWorld().getOwner().getUid()));
        notifyInfo();

        return true;
    }

    public boolean isStarted() {
        return stage == GalleryStageType.GALLERY_NONE;
    }

    public boolean handleControlGroupLuaCall(String name, int sourceEntityId, int uid, int param1, int param2, int param3) {
        Grasscutter.getLogger().debug("ControlGroupLuaCall on gallery {}, {}: {} {} {}", config.getId(), name, param1, param2, param3);

        val args = new ScriptArgs(config.getControlGroupId(), EventType.EVENT_NONE);
        args.setParam1(param1);
        args.setParam2(param2);
        args.setParam3(param3);
        args.setUid(uid);
        args.setSourceEntityId(sourceEntityId);
        val ret = getScene().getScriptManager().callScriptFunc(name, config.getControlGroupId(), args);
        return ret.asInteger() == 0;
    }

    public boolean updatePlayerScore(GroupEventLuaContext context, LuaTable table) {
        return true;
    }
}
