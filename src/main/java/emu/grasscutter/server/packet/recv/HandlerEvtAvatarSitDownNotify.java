package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.TypedPacketHandler;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketEvtAvatarSitDownNotify;
import messages.battle.EvtAvatarSitDownNotify;

public class HandlerEvtAvatarSitDownNotify extends TypedPacketHandler<EvtAvatarSitDownNotify> {

    @Override
    public void handle(GameSession session, byte[] header, EvtAvatarSitDownNotify notify) throws Exception {

        session.getPlayer().getScene().broadcastPacket(new PacketEvtAvatarSitDownNotify(notify));
    }

}

