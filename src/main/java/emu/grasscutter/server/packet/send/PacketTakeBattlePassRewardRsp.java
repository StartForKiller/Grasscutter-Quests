package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.net.packet.BaseTypedPacket;
import messages.battle_pass.BattlePassRewardTakeOption;
import messages.battle_pass.TakeBattlePassRewardRsp;

import java.util.List;

public class PacketTakeBattlePassRewardRsp extends BaseTypedPacket<TakeBattlePassRewardRsp> {
    public PacketTakeBattlePassRewardRsp(List<BattlePassRewardTakeOption> takeOptionList, List<GameItem> rewardItems) {
        super(new TakeBattlePassRewardRsp());

        proto.setTakeOptionList(takeOptionList);
        proto.setItemList(rewardItems.stream().map(GameItem::toItemParam).toList());
    }
}
