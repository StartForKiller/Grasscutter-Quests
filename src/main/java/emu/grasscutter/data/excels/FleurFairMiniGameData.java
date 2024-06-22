package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.val;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@ResourceType(name = "FleurFairMiniGameExcelConfigData.json")
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FleurFairMiniGameData extends GameResource {
    int id;
    FleurFairMiniGameType miniGameType;
    Long descTextMapHash;
    int galleryId;
    int configId;
    int openDay;
    int questId;
    Long rewardRankLowTextMapHash;
    Long rewardRankMiddleTextMapHash;
    Long rewardRankHighTextMapHash;
    List<Integer> watcherIdList;
    List<Integer> avatarIdList;
    List<Integer> avatarScore;
    List<Integer> tipsIdList;
    Long tipsDescTextMapHash;
    List<Float> pos;

    @Override
    public int getId() {
        return id;
    }

    public enum FleurFairMiniGameType {
        FLEUR_FAIR_MINI_GAME_BALLOON,
        FLEUR_FAIR_MINI_GAME_FALL,
        FLEUR_FAIR_MINI_GAME_MUSIC
    }
}
