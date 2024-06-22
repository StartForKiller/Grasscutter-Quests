package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BaseTypedPacket;
import messages.battle_pass.BattlePassCurScheduleUpdateNotify;

public class PacketBattlePassCurScheduleUpdateNotify extends BaseTypedPacket<BattlePassCurScheduleUpdateNotify> {

    public PacketBattlePassCurScheduleUpdateNotify(Player player) {
        super(new BattlePassCurScheduleUpdateNotify());

        proto.setHaveCurSchedule(true);
        proto.setCurSchedule(player.getBattlePassManager().getScheduleProto());
    }
}
