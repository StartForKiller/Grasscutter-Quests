package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;

import java.util.List;
import java.util.stream.Collectors;

import org.anime_game_servers.multi_proto.gi.messages.activity.fleur_fair.FleurFairBalloonSettleInfo;
import org.anime_game_servers.multi_proto.gi.messages.activity.fleur_fair.FleurFairBalloonSettleNotify;

public class PacketFleurFairBalloonSettleNotify extends BaseTypedPacket<FleurFairBalloonSettleNotify> {

    public PacketFleurFairBalloonSettleNotify(int minigameId, List<FleurFairBalloonSettleInfo> infos) {
        super(new FleurFairBalloonSettleNotify());
        proto.setMinigameId(minigameId);
        proto.setSettleInfoMap(infos.stream().collect(Collectors.toMap(i -> i.getSettleInfo().getUid(), i -> i)));
    }

}
