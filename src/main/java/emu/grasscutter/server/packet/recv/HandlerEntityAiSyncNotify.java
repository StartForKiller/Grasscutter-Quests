package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.packet.TypedPacketHandler;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketEntityAiSyncNotify;
import messages.battle.EntityAiSyncNotify;

@Opcodes(PacketOpcodes.EntityAiSyncNotify)
public class HandlerEntityAiSyncNotify extends TypedPacketHandler<EntityAiSyncNotify> {

	@Override
	public void handle(GameSession session, byte[] header, EntityAiSyncNotify notify) throws Exception {
		if (!notify.getLocalAvatarAlertedMonsterList().isEmpty()) {
			session.getPlayer().getScene().broadcastPacket(new PacketEntityAiSyncNotify(notify));
		}
	}

}
