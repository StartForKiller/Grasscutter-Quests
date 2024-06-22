package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.TypedPacketHandler;
import emu.grasscutter.server.game.GameSession;
import messages.battle_pass.TakeBattlePassRewardReq;

public class HandlerTakeBattlePassRewardReq extends TypedPacketHandler<TakeBattlePassRewardReq> {
    @Override
    public void handle(GameSession session, byte[] header, TakeBattlePassRewardReq req) throws Exception {
        session.getPlayer().getBattlePassManager().takeReward(req.getTakeOptionList());
    }
}
