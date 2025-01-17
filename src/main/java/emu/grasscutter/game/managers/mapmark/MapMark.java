package emu.grasscutter.game.managers.mapmark;

import dev.morphia.annotations.Entity;
import org.anime_game_servers.multi_proto.gi.messages.scene.map.MapMarkFromType;
import org.anime_game_servers.multi_proto.gi.messages.scene.map.MapMarkPoint;
import org.anime_game_servers.multi_proto.gi.messages.scene.map.MapMarkPointType;
import emu.grasscutter.utils.Position;

@Entity
public class MapMark {
    private int sceneId;
    private String name;
    private Position position;
    private MapMarkPointType mapMarkPointType;
    private int monsterId;
    private MapMarkFromType mapMarkFromType;
    private int questId;

    @Deprecated // Morhpia
    public MapMark() {
        this.mapMarkPointType = MapMarkPointType.MONSTER;
        this.mapMarkFromType = MapMarkFromType.MAP_MARK_FROM_TYPE_MONSTER;
    }

    public MapMark(MapMarkPoint mapMarkPoint) {
        this.sceneId = mapMarkPoint.getSceneId();
        this.name = mapMarkPoint.getName();
        this.position = new Position(mapMarkPoint.getPos());
        this.mapMarkPointType = mapMarkPoint.getPointType();
        this.monsterId = mapMarkPoint.getMonsterId();
        this.mapMarkFromType = mapMarkPoint.getFromType();
        this.questId = mapMarkPoint.getQuestId();
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public String getName() {
        return this.name;
    }

    public Position getPosition() {
        return this.position;
    }

    public MapMarkPointType getMapMarkPointType() {
        return this.mapMarkPointType;
    }

    public int getMonsterId() {
        return this.monsterId;
    }

    public MapMarkFromType getMapMarkFromType() {
        return this.mapMarkFromType;
    }

    public int getQuestId() {
        return this.questId;
    }
}
