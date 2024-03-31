package emu.grasscutter.game.activity.fleurfair;

import emu.grasscutter.game.activity.ActivityHandler;
import emu.grasscutter.game.activity.GameActivity;
import emu.grasscutter.game.activity.PlayerActivityData;
import emu.grasscutter.game.props.ActivityType;
import emu.grasscutter.utils.JsonUtils;
import lombok.val;
import messages.activity.ActivityInfo;
import messages.activity.fleur_fair.FleurFairActivityDetailInfo;

import java.util.Date;

import java.util.stream.Collectors;

@GameActivity(ActivityType.NEW_ACTIVITY_FLEUR_FAIR)
public class FleurFairActivityHandler extends ActivityHandler {

    @Override
    public void onProtoBuild(PlayerActivityData playerActivityData, ActivityInfo activityInfo) {
        val now = new Date();

        var playerData = getFleurFairPlayerData(playerActivityData);

        val info = new FleurFairActivityDetailInfo();
        info.setChapterInfoList(
            playerData.getChapters().values().stream()
                .map(FleurFairPlayerData.FleurFairChapterData::toProto).toList()
        );

        info.setMinigameInfoMap(
            playerData.getMinigames().values().stream()
                .collect(Collectors.toMap(FleurFairPlayerData.FleurFairMinigameData::getMinigameId, FleurFairPlayerData.FleurFairMinigameData::toProto))
        );

        info.setDungeonSectionInfoMap(
            playerData.getDungeons().values().stream()
                .collect(Collectors.toMap(FleurFairPlayerData.FleurFairDungeonData::getDungeonId, FleurFairPlayerData.FleurFairDungeonData::toProto))
        );

        info.setDungeonUnlocked(true);
        info.setContentCloseTime((int)now.getTime()+120*3600000);
        info.setContentClosed(false);
        info.setObtainedToken(0);

        activityInfo.setDetail(new ActivityInfo.Detail.FleurFairInfo(info));
        activityInfo.setStarting(true);
    }

    public FleurFairPlayerData getFleurFairPlayerData(PlayerActivityData playerActivityData) {
        if (playerActivityData.getDetail() == null || playerActivityData.getDetail().isBlank()) {
            onInitPlayerActivityData(playerActivityData);
            playerActivityData.save();
        }

        return JsonUtils.decode(playerActivityData.getDetail(), FleurFairPlayerData.class);
    }

    @Override
    public void onInitPlayerActivityData(PlayerActivityData playerActivityData) {
        var fleurFairPlayerData = FleurFairPlayerData.create();

        playerActivityData.setDetail(fleurFairPlayerData);
    }

    //GetAllSceneGalleryInfoReq -> TODO:Photo gallery

}
