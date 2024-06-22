package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import messages.activity.ActivityTakeWatcherRewardRsp;

public class PacketActivityTakeWatcherRewardRsp extends BaseTypedPacket<ActivityTakeWatcherRewardRsp> {

	public PacketActivityTakeWatcherRewardRsp(int activityId, int watcherId) {
		super(new ActivityTakeWatcherRewardRsp(activityId, watcherId));
	}

}
