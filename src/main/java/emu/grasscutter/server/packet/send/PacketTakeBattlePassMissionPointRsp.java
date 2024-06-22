package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import messages.battle_pass.TakeBattlePassMissionPointRsp;

public class PacketTakeBattlePassMissionPointRsp extends BaseTypedPacket<TakeBattlePassMissionPointRsp> {
    public PacketTakeBattlePassMissionPointRsp() {
        super(new TakeBattlePassMissionPointRsp()); // TODO also send missions?
    }
}
