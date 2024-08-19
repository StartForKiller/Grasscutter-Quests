package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import org.anime_game_servers.multi_proto.gi.messages.activity.user_generated_content.CheckUgcStateRsp;

public class PacketCheckUgcStateRsp extends BaseTypedPacket<CheckUgcStateRsp> {

	public PacketCheckUgcStateRsp(RetcodeOuterClass.Retcode ret) {
		super(new CheckUgcStateRsp(ret.getNumber()));
	}

}
