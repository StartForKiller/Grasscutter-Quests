package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import org.anime_game_servers.multi_proto.gi.messages.activity.aster.AsterLittleDetailInfo;
import org.anime_game_servers.multi_proto.gi.messages.activity.aster.AsterLittleInfoNotify;
import org.anime_game_servers.multi_proto.gi.messages.activity.aster.AsterMidCampInfo;
import org.anime_game_servers.multi_proto.gi.messages.activity.aster.AsterMidCampInfoNotify;

public class PacketAsterMidCampInfoNotify extends BaseTypedPacket<AsterMidCampInfoNotify> {

	public PacketAsterMidCampInfoNotify(AsterMidCampInfo activityInfo) {
		super(new AsterMidCampInfoNotify(activityInfo));
	}
}
