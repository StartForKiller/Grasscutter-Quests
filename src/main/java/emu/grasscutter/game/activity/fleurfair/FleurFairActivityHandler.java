package emu.grasscutter.game.activity.fleurfair;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.game.activity.ActivityConfigItem;
import emu.grasscutter.game.activity.ActivityHandler;
import emu.grasscutter.game.activity.GameActivity;
import emu.grasscutter.game.activity.PlayerActivityData;
import emu.grasscutter.game.activity.fleurfair.FleurFairPlayerData.FleurFairMinigameData;
import emu.grasscutter.game.gallery.BalloonGallery;
import emu.grasscutter.game.gallery.BaseGallery;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActivityType;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.server.packet.send.PacketFleurFairBalloonSettleNotify;
import emu.grasscutter.utils.JsonUtils;
import lombok.val;
import messages.activity.ActivityInfo;
import messages.activity.fleur_fair.FleurFairActivityDetailInfo;
import messages.activity.fleur_fair.FleurFairBalloonSettleInfo;
import messages.gallery.BalloonSettleInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@GameActivity(ActivityType.NEW_ACTIVITY_FLEUR_FAIR)
public class FleurFairActivityHandler extends ActivityHandler {

    @Override
    public void onProtoBuild(PlayerActivityData playerActivityData, ActivityInfo activityInfo) {
        val now = new Date();

        val playerData = getFleurFairPlayerData(playerActivityData);

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

    public FleurFairMinigameData getMinigameDataFromGalleryId(int galleryId, FleurFairPlayerData playerData) {
        Optional<FleurFairMinigameData> minigame = playerData.getMinigames().values().stream().filter(m -> {
            val data = GameData.getFleurFairMiniGameDataMap().get(m.getMinigameId());
            if(data == null) return false;

            return data.getConfigId() == galleryId;
        }).findFirst();

        if(minigame.isPresent()) return minigame.get();

        return null;
    }

    public void loadGalleries(Scene scene, FleurFairPlayerData playerData) {
        //TODO: Check if is open

        for(val minigame : playerData.getMinigames().values()) {
            val data = GameData.getFleurFairMiniGameDataMap().get(minigame.getMinigameId());
            if(data == null) {
                //TODO: Print error
                continue;
            }

            if(scene.getGalleries().containsKey(data.getConfigId())) { //I know it's strange but they swapped it
                //TODO: Print already inserted
                continue;
            }

            val galleryData = GameData.getGalleryDataMap().get(data.getConfigId());
            if(galleryData == null) {
                //TODO: Print error
                continue;
            }

            BaseGallery baseGallery = null;
            switch(minigame.getType()) { //TODO: Add more types
                case FLEUR_FAIR_MINI_GAME_BALLOON:
                    val gallery = new BalloonGallery(scene, galleryData);
                    baseGallery = (BaseGallery)gallery;
            }

            if(baseGallery != null)
                baseGallery.load();
        }
    }

    @Override
    public void onLoadScene(Scene scene, Player player, ActivityConfigItem activityInfo) {
        val data = PlayerActivityData.getByPlayer(player, activityInfo.getActivityId());
        val playerData = getFleurFairPlayerData(data);

        loadGalleries(scene, playerData);
    }

    @Override
    public void onBalloonSettleNotify(int galleryId, List<BalloonSettleInfo> infos, ActivityConfigItem activityInfo) {
        List<FleurFairBalloonSettleInfo> infosToSend = new ArrayList<>();

        int minigameId = 0;
        for (BalloonSettleInfo info : infos) {
            val player = Grasscutter.getGameServer().getPlayerByUid(info.getUid(), true);
            if(player == null) continue;

            val data = PlayerActivityData.getByPlayer(player, activityInfo.getActivityId());
            val playerData = getFleurFairPlayerData(data);

            val minigame = getMinigameDataFromGalleryId(galleryId, playerData);
            if(minigame == null) return;
            minigameId = minigame.getMinigameId();

            boolean isRecord = false;
            if(minigame.getMaxScore() < info.getFinalScore()) {
                minigame.setMaxScore(info.getFinalScore());
                isRecord = true;
            }

            val newInfo = new FleurFairBalloonSettleInfo();
            newInfo.setNewRecord(isRecord);
            newInfo.setSettleInfo(info);
            infosToSend.add(newInfo);

            data.setDetail(playerData);
        }

        for (BalloonSettleInfo info : infos) {
            val player = Grasscutter.getGameServer().getPlayerByUid(info.getUid(), true);
            if(player == null) continue;

            player.sendPacket(new PacketFleurFairBalloonSettleNotify(minigameId, infosToSend));
        }
    }

    //GetAllSceneGalleryInfoReq -> TODO:Photo gallery

}
