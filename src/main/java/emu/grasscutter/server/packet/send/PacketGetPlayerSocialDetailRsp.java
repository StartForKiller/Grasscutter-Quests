package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import org.anime_game_servers.multi_proto.gi.messages.community.player_presentation.GetPlayerSocialDetailRsp;
import org.anime_game_servers.multi_proto.gi.messages.community.player_presentation.SocialDetail;

public class PacketGetPlayerSocialDetailRsp extends BaseTypedPacket<GetPlayerSocialDetailRsp> {

	public PacketGetPlayerSocialDetailRsp(SocialDetail detail) {
		super(new GetPlayerSocialDetailRsp());

		if (detail != null) {
			proto.setDetailData(detail);
		} else {
			proto.setRetCode(RetcodeOuterClass.Retcode.RET_SVR_ERROR_VALUE);
		}
	}
}
