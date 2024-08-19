package emu.grasscutter.game.gallery;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.excels.GalleryData;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.scripts.lua_engine.GroupEventLuaContext;
import emu.grasscutter.server.packet.send.PacketGalleryBalloonScoreNotify;
import emu.grasscutter.server.packet.send.PacketGalleryBalloonShotNotify;
import emu.grasscutter.utils.Utils;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.val;

import java.util.Map;
import java.util.stream.Collectors;

import org.anime_game_servers.lua.engine.LuaTable;
import org.anime_game_servers.multi_proto.gi.messages.gallery.SceneGalleryInfo;
import org.anime_game_servers.multi_proto.gi.messages.gallery.balloon.BalloonPlayerInfo;
import org.anime_game_servers.multi_proto.gi.messages.gallery.balloon.BalloonSettleInfo;
import org.anime_game_servers.multi_proto.gi.messages.gallery.balloon.SceneGalleryBalloonInfo;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class BalloonGallery extends BaseGallery {
    @Getter private BalloonGalleryParam params;

    @Getter private Map<Integer, BalloonPlayerData> playerData;

    public BalloonGallery(Scene scene, GalleryData config) {
        super(scene, config);

        playerData = new HashMap<>();
        params = new BalloonGalleryParam(config.getParam());
    }

    @Override
    public void onStop() {
        List<BalloonSettleInfo> infos = new ArrayList<>();
        playerData.forEach((uid, data) -> {
            val p = Grasscutter.getGameServer().getPlayerByUid(uid);
            if(p != null) {
                BalloonSettleInfo info = new BalloonSettleInfo();
                info.setPlayerInfo(p.getOnlinePlayerInfo());
                info.setUid(uid);
                info.setFinalScore(data.getScore());
                info.setMaxCombo(20); //TODO
                info.setShootCount(data.getShootCount());
                infos.add(info);
            }
        });

        //TODO: Multiplayer
        getScene().getWorld().getOwner().getActivityManager().onBalloonSettleNotify(getConfig().getId(), infos);
    }

    public BalloonPlayerData getPlayerData(int uid) {
        if(!playerData.containsKey(uid))
            playerData.put(uid, new BalloonPlayerData());

        return playerData.get(uid);
    }

    public void notifyScore() {
        getScene().broadcastPacket(new PacketGalleryBalloonScoreNotify(
            getConfig().getId(),
            playerData.entrySet().stream().collect(
                Collectors.toMap(
                    value -> value.getKey(),
                    value -> value.getValue().getScore())
                )
            )
        );
    }

    @Override
    public void onProtoGenerate(SceneGalleryInfo info) {
        var balloonInfo = new SceneGalleryBalloonInfo();
        int uid = getScene().getWorld().getOwner().getUid();

        balloonInfo.setScenePlayerBalloonInfoMap(playerData.entrySet().stream()
            .map(e -> new BalloonPlayerInfo(e.getKey(), 0, 0, e.getValue().getScore()))
            .collect(Collectors.toMap(value -> value.getUid(), value -> value)
        ));
        balloonInfo.setEndTime(getEndTime());
    }

    @Override
    public boolean updatePlayerScore(GroupEventLuaContext context, LuaTable table) {
        int triggerGadgetId = table.getInt("trigger_gadget_id");
        val data = getPlayerData(context.getUid());

        Grasscutter.getLogger().info("BalloonShot: uid {}, gadgetId {}", context.getUid(), triggerGadgetId);

        val triggerScore = params.gadgetScoreMap.get(triggerGadgetId);
        if(triggerScore != null) {
            int score = data.getScore();

            int newScore = Math.max(score + triggerScore, 0);
            data.setScore(newScore);
            data.setShootCount(data.getShootCount() + 1);

            val player = Grasscutter.getGameServer().getPlayerByUid(context.getUid());
            Grasscutter.getLogger().info("GalleryBalloonShotNotify: uid {}, gadgetId {}, newScore {}, sourceEntity {}", context.getUid(), triggerGadgetId, newScore, context.getSourceEntityId());
            if(player != null)
                player.sendPacket(
                    new PacketGalleryBalloonShotNotify(getConfig().getId(), newScore - score, 0, 0, newScore, context.getSourceEntityId())
                );
            else {
                Grasscutter.getLogger().error("BalloonShot: uid {} not found", context.getUid());
            }

            notifyScore();
        }
        return true;
    }

    @Data
    public class BalloonGalleryParam {
        private Map<Integer, Integer> gadgetScoreMap;
        private int comboDuration;
        private Map<Integer, Double> comboRatioMap;

        public BalloonGalleryParam(List<String> params) {
            if(params.size() < 3) return;

            gadgetScoreMap = Utils.parseIntIntMapString(params.get(0));
            comboDuration = Integer.parseInt(params.get(1));
            comboRatioMap = Utils.parseIntDoubleMapString(params.get(0));
        }
    }

    public class BalloonPlayerData {
        @Getter @Setter private int score;
        @Getter @Setter private int shootCount;
    }

}
