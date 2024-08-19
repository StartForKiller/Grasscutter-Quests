package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import org.anime_game_servers.multi_proto.gi.messages.npc.NpcTalkRsp;

public class PacketNpcTalkRsp extends BaseTypedPacket<NpcTalkRsp> {
    public PacketNpcTalkRsp(int npcEntityId, int curTalkId, int entityId) {
        super(new NpcTalkRsp(npcEntityId));

        proto.setCurTalkId(curTalkId);
        proto.setEntityId(entityId);
    }
}
