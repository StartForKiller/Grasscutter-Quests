package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.TypedPacketHandler;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketTakeBattlePassMissionPointRsp;
import messages.battle_pass.TakeBattlePassMissionPointReq;

public class HandlerTakeBattlePassMissionPointReq extends TypedPacketHandler<TakeBattlePassMissionPointReq> {

    @Override
    public void handle(GameSession session, byte[] header, TakeBattlePassMissionPointReq req) throws Exception {
        session.getPlayer().getBattlePassManager().takeMissionPoint(req.getMissionIdList());

        session.send(new PacketTakeBattlePassMissionPointRsp());
    }
}
