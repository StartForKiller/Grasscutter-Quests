package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.net.packet.TypedPacketHandler;
import emu.grasscutter.net.proto.PacketHeadOuterClass.PacketHead;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketEvtAvatarLockChairRsp;
import org.anime_game_servers.multi_proto.gi.messages.battle.event.EvtAvatarLockChairReq;

public class HandlerEvtAvatarLockChairReq extends TypedPacketHandler<EvtAvatarLockChairReq> {

    @Override
    public void handle(GameSession session, byte[] header, EvtAvatarLockChairReq req) throws Exception {
        PacketHead head = PacketHead.parseFrom(header);

        EntityAvatar entityAvatar = session.getPlayer().getTeamManager().getCurrentAvatarEntity();

        session.send(new PacketEvtAvatarLockChairRsp(head.getClientSequenceId(), entityAvatar, req));
    }

}
