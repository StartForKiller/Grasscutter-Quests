package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import lombok.val;
import messages.battle.AiSyncInfo;
import messages.battle.EntityAiSyncNotify;

public class PacketEntityAiSyncNotify extends BaseTypedPacket<EntityAiSyncNotify> {

	public PacketEntityAiSyncNotify(EntityAiSyncNotify notify) {
		super(new EntityAiSyncNotify(), true);

        val aiInfo = notify.getLocalAvatarAlertedMonsterList().stream()
            .map(monsterId -> new AiSyncInfo(monsterId,true))
            .toList();
		proto.setInfoList(aiInfo);
	}
}
