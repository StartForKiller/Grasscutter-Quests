package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.TypedPacketHandler;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketActivityTakeWatcherRewardRsp;
import messages.activity.ActivityTakeWatcherRewardReq;

import java.util.Optional;

public class HandlerActivityTakeWatcherRewardReq extends TypedPacketHandler<ActivityTakeWatcherRewardReq> {

	@Override
	public void handle(GameSession session, byte[] header, ActivityTakeWatcherRewardReq req) throws Exception {
		Optional.ofNullable(session.getPlayer().getActivityManager().getPlayerActivityDataMap().get(req.getActivityId()))
            .ifPresent(x -> x.takeWatcherReward(req.getWatcherId()));

        session.send(new PacketActivityTakeWatcherRewardRsp(req.getActivityId(), req.getWatcherId()));
	}

}
