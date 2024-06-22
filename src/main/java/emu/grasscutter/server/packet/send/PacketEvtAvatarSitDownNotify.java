package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import messages.battle.EvtAvatarSitDownNotify;

public class PacketEvtAvatarSitDownNotify extends BaseTypedPacket<EvtAvatarSitDownNotify> {

    public PacketEvtAvatarSitDownNotify(EvtAvatarSitDownNotify notify) {
        super(new EvtAvatarSitDownNotify(notify.getEntityId(), notify.getPosition(), notify.getChairId()));
    }
}
