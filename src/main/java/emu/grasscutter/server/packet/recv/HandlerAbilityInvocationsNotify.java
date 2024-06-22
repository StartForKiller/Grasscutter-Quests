package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.TypedPacketHandler;
import emu.grasscutter.server.game.GameSession;
import lombok.val;
import messages.ability.AbilityInvocationsNotify;

public class HandlerAbilityInvocationsNotify extends TypedPacketHandler<AbilityInvocationsNotify> {

	@Override
	public void handle(GameSession session, byte[] header, AbilityInvocationsNotify notif) throws Exception {
		Player player = session.getPlayer();
		for (val entry : notif.getInvokes()) {
			player.getAbilityManager().onAbilityInvoke(entry);
			player.getAbilityInvokeHandler().addEntry(entry.getForwardType(), entry);
		}
	}

}
