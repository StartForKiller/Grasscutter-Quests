package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import messages.activity.fleur_fair.FleurFairBalloonSettleInfo;
import messages.activity.fleur_fair.FleurFairBalloonSettleNotify;

import java.util.List;
import java.util.stream.Collectors;

public class PacketFleurFairBalloonSettleNotify extends BaseTypedPacket<FleurFairBalloonSettleNotify> {

    public PacketFleurFairBalloonSettleNotify(int minigameId, List<FleurFairBalloonSettleInfo> infos) {
        super(new FleurFairBalloonSettleNotify());
        proto.setMinigameId(minigameId);
        proto.setSettleInfoMap(infos.stream().collect(Collectors.toMap(i -> i.getSettleInfo().getUid(), i -> i)));
    }

}
