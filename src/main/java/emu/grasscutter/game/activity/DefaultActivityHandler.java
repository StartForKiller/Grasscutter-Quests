package emu.grasscutter.game.activity;

import emu.grasscutter.game.props.ActivityType;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.world.Scene;
import messages.activity.ActivityInfo;

@GameActivity(ActivityType.NONE)
public class DefaultActivityHandler extends ActivityHandler{
    @Override
    public void onProtoBuild(PlayerActivityData playerActivityData, ActivityInfo activityInfo) {

    }

    @Override
    public void onInitPlayerActivityData(PlayerActivityData playerActivityData) {

    }

    @Override
    public void onLoadScene(Scene scene, Player player, ActivityConfigItem activityInfo) {

    }
}
