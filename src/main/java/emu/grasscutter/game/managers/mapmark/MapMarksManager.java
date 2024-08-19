package emu.grasscutter.game.managers.mapmark;

import emu.grasscutter.config.Configuration;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import org.anime_game_servers.multi_proto.gi.messages.scene.map.MapMarkPointType;
import org.anime_game_servers.multi_proto.gi.messages.scene.map.MarkMapReq;
import org.anime_game_servers.multi_proto.gi.messages.scene.map.Operation;
import emu.grasscutter.server.event.player.PlayerTeleportEvent.TeleportType;
import emu.grasscutter.server.packet.send.PacketMarkMapRsp;
import emu.grasscutter.server.packet.send.PacketSceneEntityAppearNotify;
import emu.grasscutter.utils.Position;

import java.util.Map;

public class MapMarksManager extends BasePlayerManager {
    public static final int mapMarkMaxCount = 150;

    public MapMarksManager(Player player) {
        super(player);
    }

    public Map<String, MapMark> getMapMarks() {
        return this.getPlayer().getMapMarks();
    }

    public void handleMapMarkReq(MarkMapReq req) {
        Operation op = req.getOp();
        switch (op) {
            case ADD -> {
                MapMark createMark = new MapMark(req.getMark());
                // keep teleporting functionality on fishhook mark.
                if (Configuration.GAME_OPTIONS.fishhookTeleport && createMark.getMapMarkPointType() == MapMarkPointType.FISH_POOL) {
                    this.teleport(player, createMark);
                    return;
                }
                this.addMapMark(createMark);
            }
            case MOD -> {
                MapMark oldMark = new MapMark(req.getOld());
                this.removeMapMark(oldMark.getPosition());
                MapMark newMark = new MapMark(req.getMark());
                this.addMapMark(newMark);
            }
            case DEL -> {
                MapMark deleteMark = new MapMark(req.getMark());
                this.removeMapMark(deleteMark.getPosition());
            }
        }
        if (op != Operation.GET) {
            this.save();
        }
        player.getSession().send(new PacketMarkMapRsp(this.getMapMarks()));
    }

    public String getMapMarkKey(Position position) {
        return "x" + (int)position.getX()+ "z" + (int)position.getZ();
    }

    public void removeMapMark(Position position) {
        this.getMapMarks().remove(this.getMapMarkKey(position));
    }

    public void addMapMark(MapMark mapMark) {
        if (this.getMapMarks().size() < mapMarkMaxCount) {
            this.getMapMarks().put(this.getMapMarkKey(mapMark.getPosition()), mapMark);
        }
    }

    private void teleport(Player player, MapMark mapMark) {
        float y;
        try {
            y = Float.parseFloat(mapMark.getName());
        } catch (Exception e) {
            y = 300;
        }

        Position pos = mapMark.getPosition();
        player.getWorld().transferPlayerToScene(player, mapMark.getSceneId(), TeleportType.MAP, new Position(pos.getX(), y, pos.getZ()), null);
        player.getScene().broadcastPacket(new PacketSceneEntityAppearNotify(player));
    }
}
