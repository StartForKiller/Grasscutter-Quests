package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import messages.battle.EvtAvatarStandUpNotify;

public class PacketEvtAvatarStandUpNotify extends BaseTypedPacket<EvtAvatarStandUpNotify> {

    public PacketEvtAvatarStandUpNotify(EvtAvatarStandUpNotify notify) {
        super(new EvtAvatarStandUpNotify(notify.getDirection(), notify.getEntityId(), notify.getPerformId(), notify.getChairId()));
    }
}
