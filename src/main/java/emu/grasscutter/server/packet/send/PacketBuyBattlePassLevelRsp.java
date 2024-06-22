package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import messages.battle_pass.BuyBattlePassLevelRsp;

public class PacketBuyBattlePassLevelRsp extends BaseTypedPacket<BuyBattlePassLevelRsp> {

	public PacketBuyBattlePassLevelRsp(int buyLevel) {
		super(new BuyBattlePassLevelRsp(buyLevel));
	}
}
