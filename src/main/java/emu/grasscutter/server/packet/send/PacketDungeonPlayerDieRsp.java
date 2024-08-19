package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import emu.grasscutter.net.proto.RetcodeOuterClass.Retcode;
import org.anime_game_servers.multi_proto.gi.messages.dungeon.DungeonPlayerDieRsp;

public class PacketDungeonPlayerDieRsp extends BaseTypedPacket<DungeonPlayerDieRsp> {
    public PacketDungeonPlayerDieRsp(Retcode retcode) {
        super(new DungeonPlayerDieRsp());
        proto.setRetcode(retcode.getNumber());
    }
}
