package emu.grasscutter.game.activity.fleurfair;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.val;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.FleurFairMiniGameData.FleurFairMiniGameType;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder(builderMethodName = "of")
public class FleurFairPlayerData {
    Map<Integer, FleurFairChapterData> chapters;
    Map<Integer, FleurFairMinigameData> minigames;
    Map<Integer, FleurFairDungeonData> dungeons;

    public static FleurFairPlayerData create() {
        val now = new Date();

        Map<Integer, FleurFairChapterData> _chapters = new HashMap<>();
        _chapters.put(1, FleurFairChapterData.create(1, (int)now.getTime()-3600000));
        _chapters.put(2, FleurFairChapterData.create(2, (int)now.getTime()+24*3600000));
        _chapters.put(3, FleurFairChapterData.create(3, (int)now.getTime()+48*3600000));
        _chapters.put(4, FleurFairChapterData.create(4, (int)now.getTime()+96*3600000));

        Map<Integer, FleurFairMinigameData> _minigames = new HashMap<>();
        GameData.getFleurFairMiniGameDataMap().forEach((k, v) -> {
            _minigames.put(k, FleurFairMinigameData.create(k, (int)now.getTime()-3600000, v.getMiniGameType()));
        });
        //_minigames.put(1001, FleurFairMinigameData.create(1001, (int)now.getTime()-3600000, FleurFairMinigameType.BALLOON));
        //_minigames.put(1002, FleurFairMinigameData.create(1002, (int)now.getTime()-3600000, FleurFairMinigameType.BALLOON));
        //_minigames.put(1003, FleurFairMinigameData.create(1003, (int)now.getTime()-3600000, FleurFairMinigameType.BALLOON));
        //_minigames.put(1004, FleurFairMinigameData.create(1004, (int)now.getTime()-3600000, FleurFairMinigameType.BALLOON));
        //_minigames.put(2001, FleurFairMinigameData.create(2001, (int)now.getTime()-3600000, FleurFairMinigameType.FALL));
        //_minigames.put(2002, FleurFairMinigameData.create(2002, (int)now.getTime()-3600000, FleurFairMinigameType.FALL));
        //_minigames.put(2003, FleurFairMinigameData.create(2003, (int)now.getTime()-3600000, FleurFairMinigameType.FALL));
        //_minigames.put(2004, FleurFairMinigameData.create(2004, (int)now.getTime()-3600000, FleurFairMinigameType.FALL));
        //_minigames.put(3001, FleurFairMinigameData.create(3001, (int)now.getTime()-3600000, FleurFairMinigameType.MUSIC));
        //_minigames.put(3002, FleurFairMinigameData.create(3002, (int)now.getTime()-3600000, FleurFairMinigameType.MUSIC));
        //_minigames.put(3003, FleurFairMinigameData.create(3003, (int)now.getTime()-3600000, FleurFairMinigameType.MUSIC));
        //_minigames.put(3004, FleurFairMinigameData.create(3004, (int)now.getTime()-3600000, FleurFairMinigameType.MUSIC));

        Map<Integer, FleurFairDungeonData> _dungeons = new HashMap<>();
        _dungeons.put(20031, FleurFairDungeonData.create(20031, (int)now.getTime()-3600000, 1));
        _dungeons.put(20032, FleurFairDungeonData.create(20032, (int)now.getTime()-3600000, 2));
        _dungeons.put(20033, FleurFairDungeonData.create(20033, (int)now.getTime()-3600000, 3));
        _dungeons.put(20034, FleurFairDungeonData.create(20034, (int)now.getTime()-3600000, 4));

        return FleurFairPlayerData.of()
            .chapters(_chapters)
            .minigames(_minigames)
            .dungeons(_dungeons)
            .build();
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Builder(builderMethodName = "of")
    public static class FleurFairChapterData {
        int chapterId;
        int openTime;

        public static FleurFairChapterData create(int id, int openTime) {
            return FleurFairChapterData.of()
                .chapterId(id)
                .openTime(openTime)
                .build();
        }

        public messages.activity.fleur_fair.FleurFairChapterInfo toProto() {
            return new messages.activity.fleur_fair.FleurFairChapterInfo(
                chapterId,
                openTime
            );
        }
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Builder(builderMethodName = "of")
    public static class FleurFairMinigameData {
        int minigameId;
        int openTime;
        FleurFairMiniGameType type;
        int maxScore;

        public static FleurFairMinigameData create(int id, int openTime, FleurFairMiniGameType type) {
            return FleurFairMinigameData.of()
                .minigameId(id)
                .openTime(openTime)
                .type(type)
                .maxScore(0)
                .build();
        }

        public messages.activity.fleur_fair.FleurFairMinigameInfo toProto() {
            switch (type) {
                case FLEUR_FAIR_MINI_GAME_BALLOON:
                    return new messages.activity.fleur_fair.FleurFairMinigameInfo(
                        true, //TODO: Check from openTime if this is true
                        minigameId,
                        openTime,
                        new messages.activity.fleur_fair.FleurFairMinigameInfo.Detail.BalloonInfo(new messages.activity.fleur_fair.FleurFairBalloonInfo(maxScore))
                    );
                case FLEUR_FAIR_MINI_GAME_FALL:
                    return new messages.activity.fleur_fair.FleurFairMinigameInfo(
                        true,
                        minigameId,
                        openTime,
                        new messages.activity.fleur_fair.FleurFairMinigameInfo.Detail.FallInfo(new messages.activity.fleur_fair.FleurFairFallInfo(maxScore))
                    );
                //TODO: Add proper music
                case FLEUR_FAIR_MINI_GAME_MUSIC:
                default:
                    return new messages.activity.fleur_fair.FleurFairMinigameInfo(
                        true,
                        minigameId,
                        openTime,
                        new messages.activity.fleur_fair.FleurFairMinigameInfo.Detail.MusicInfo(new messages.activity.fleur_fair.FleurFairMusicGameInfo())
                    );
            }
        }
    }

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    @Builder(builderMethodName = "of")
    public static class FleurFairDungeonData {
        int dungeonId;
        int openTime;
        int sectionId;

        public static FleurFairDungeonData create(int dungeonId, int openTime, int sectionId) {
            return FleurFairDungeonData.of()
                .dungeonId(dungeonId)
                .openTime(openTime)
                .sectionId(sectionId)
                .build();
        }

        public messages.activity.fleur_fair.FleurFairDungeonSectionInfo toProto() {
            return new messages.activity.fleur_fair.FleurFairDungeonSectionInfo(
                true,
                openTime,
                sectionId
            );
        }
    }

}
