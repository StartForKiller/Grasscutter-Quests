package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import messages.battle.EvtEntityRenderersChangedNotify;

public class PacketEvtEntityRenderersChangedNotify extends BaseTypedPacket<EvtEntityRenderersChangedNotify> {

	public PacketEvtEntityRenderersChangedNotify(EvtEntityRenderersChangedNotify req) {
		super(req, true);
	}
}
