package emu.grasscutter.game.activity.aster;

import emu.grasscutter.data.GameData;
import emu.grasscutter.game.activity.ActivityConfigItem;
import emu.grasscutter.game.activity.ActivityHandler;
import emu.grasscutter.game.activity.GameActivity;
import emu.grasscutter.game.activity.PlayerActivityData;
import emu.grasscutter.game.props.ActivityType;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.server.packet.send.*;
import lombok.val;
import org.anime_game_servers.multi_proto.gi.messages.activity.ActivityInfo;
import org.anime_game_servers.multi_proto.gi.messages.activity.aster.*;
import org.anime_game_servers.multi_proto.gi.messages.general.Vector;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@GameActivity(ActivityType.NEW_ACTIVITY_ASTER)
public class AsterActivityHandler extends ActivityHandler {

    @Override
    public void onInitPlayerActivityData(PlayerActivityData playerActivityData) {
        /*var musicGamePlayerData = MusicGamePlayerData.create();

        playerActivityData.setDetail(musicGamePlayerData);*/
    }

    @Override
    public void onProtoBuild(PlayerActivityData playerActivityData, ActivityInfo activityInfo) {
        val asterLittle = new AsterLittleDetailInfo();
        asterLittle.setOpen(true);
        asterLittle.setBeginTime(activityInfo.getFirstDayStartTime());
        asterLittle.setStageBeginTime(activityInfo.getFirstDayStartTime());
        asterLittle.setStageId(1);
        asterLittle.setStageState(AsterLittleStageState.ASTER_LITTLE_STAGE_STARTED);

        playerActivityData.getPlayer().sendPacket(new PacketAsterLittleInfoNotify(asterLittle));

        val asterMiddle = new AsterMidDetailInfo();
        asterMiddle.setOpen(true);
        asterMiddle.setBeginTime(activityInfo.getFirstDayStartTime());
        val asterMiddleCamp = new AsterMidCampInfo(1, new Vector(1538.519f,335.521f,-2113.576f));

        playerActivityData.getPlayer().sendPacket(new PacketAsterMidCampInfoNotify(asterMiddleCamp));
        asterMiddle.setCampList(List.of(asterMiddleCamp));

        playerActivityData.getPlayer().sendPacket(new PacketAsterMidInfoNotify(asterMiddle));

        val asterLarge = new AsterLargeDetailInfo();
        asterLarge.setOpen(true);
        asterLarge.setBeginTime(activityInfo.getFirstDayStartTime());

        playerActivityData.getPlayer().sendPacket(new PacketAsterLargeInfoNotify(asterLarge));

        val asterProgressDetailInfo = new AsterProgressDetailInfo();
        asterProgressDetailInfo.setCount(1);
        asterProgressDetailInfo.setLastAutoAddTime(activityInfo.getFirstDayStartTime());
        playerActivityData.getPlayer().sendPacket(new PacketAsterProgressInfoNotify(asterProgressDetailInfo));

        val asterInfo = new AsterActivityDetailInfo(asterLittle, asterMiddle, asterLarge, asterProgressDetailInfo);
        asterInfo.setContentClosed(false);
        asterInfo.setContentCloseTime(asterInfo.getContentCloseTime());
        asterInfo.setSpecialRewardTaken(false);
        asterInfo.setAsterToken(50); //109
        asterInfo.setAsterCredit(60); //110
        playerActivityData.getPlayer().sendPacket(new PacketAsterMiscInfoNotify(50, 60));

        activityInfo.setDetail(new ActivityInfo.Detail.AsterInfo(asterInfo));
        activityInfo.setActivityCoinMap(Map.of(109, 1, 110, 1));
    }


    @Override
    public void onLoadScene(Scene scene, Player player, ActivityConfigItem activityInfo) {
        if(scene.getId() != 3){
            return;
        }
        val groups = List.of(302001001,
            302001002,
            302001003,
            302001004,
            302001005,
            302001006,
            302001007,
            302001008,
            302001009,
            302001010,
            302001011,
            302001012,
            302001013,
            302001014,
            302001015,
            302001016,
            302001017,
            302001018,
            302001019,
            302001041,
            302001042,
            302001043,
            302001144,
            302001901,
            302001902,
            302001903,
            302001904);
        groups.forEach(scene::loadDynamicGroup);
    }
}
