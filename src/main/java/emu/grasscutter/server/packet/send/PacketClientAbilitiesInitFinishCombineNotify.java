package emu.grasscutter.server.packet.send;

import java.util.List;

import emu.grasscutter.net.packet.BaseTypedPacket;
import messages.ability.ClientAbilitiesInitFinishCombineNotify;
import messages.ability.EntityAbilityInvokeEntry;

public class PacketClientAbilitiesInitFinishCombineNotify extends BaseTypedPacket<ClientAbilitiesInitFinishCombineNotify> {

	public PacketClientAbilitiesInitFinishCombineNotify(List<EntityAbilityInvokeEntry> entries) {
		super(new ClientAbilitiesInitFinishCombineNotify(entries), true);

	}
}
