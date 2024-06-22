package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.net.packet.BaseTypedPacket;
import messages.battle.EvtAvatarLockChairReq;
import messages.battle.EvtAvatarLockChairRsp;

public class PacketEvtAvatarLockChairRsp extends BaseTypedPacket<EvtAvatarLockChairRsp> {
    public PacketEvtAvatarLockChairRsp(int clientSequence, EntityAvatar entityAvatar, EvtAvatarLockChairReq lockChairReq) {
        super(new EvtAvatarLockChairRsp(lockChairReq.getChairId(),
            entityAvatar.getId(),lockChairReq.getPosition()));
    }
}
