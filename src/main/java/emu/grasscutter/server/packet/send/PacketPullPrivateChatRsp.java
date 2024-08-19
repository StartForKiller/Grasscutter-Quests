package emu.grasscutter.server.packet.send;

import java.util.ArrayList;
import java.util.List;

import emu.grasscutter.net.packet.BaseTypedPacket;
import emu.grasscutter.net.proto.RetcodeOuterClass.Retcode;
import org.anime_game_servers.multi_proto.gi.messages.community.chat.ChatInfo;
import org.anime_game_servers.multi_proto.gi.messages.community.chat.PullPrivateChatRsp;

public class PacketPullPrivateChatRsp extends BaseTypedPacket<PullPrivateChatRsp> {

    public PacketPullPrivateChatRsp(List<ChatInfo> history) {
        super(new PullPrivateChatRsp());

        if (history == null) {
            proto.setRetCode(Retcode.RET_FAIL_VALUE);
        }
        else {
            proto.setChatInfo(new ArrayList<>(history));
        }
    }
}
