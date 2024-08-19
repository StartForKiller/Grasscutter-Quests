package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import emu.grasscutter.net.proto.RetcodeOuterClass.Retcode;
import org.anime_game_servers.multi_proto.gi.messages.activity.user_generated_content.GetUgcReq;
import org.anime_game_servers.multi_proto.gi.messages.activity.user_generated_content.GetUgcRsp;
import org.anime_game_servers.multi_proto.gi.messages.activity.user_generated_content.music_game.UgcMusicBriefInfo;
import org.anime_game_servers.multi_proto.gi.messages.activity.user_generated_content.music_game.UgcMusicRecord;

public class PacketGetUgcRsp extends BaseTypedPacket<GetUgcRsp> {

    public PacketGetUgcRsp(UgcMusicBriefInfo briefInfo, UgcMusicRecord musicRecord, GetUgcReq req) {
        super(new GetUgcRsp(briefInfo.getUgcGuid(),
            req.getUgcType(),
            req.getUgcRecordUsage(),
            new GetUgcRsp.Record.MusicRecord(musicRecord),
            new GetUgcRsp.Brief.MusicBriefInfo(briefInfo)));
    }
    public PacketGetUgcRsp(Retcode errorCode, GetUgcReq req) {
        super( new GetUgcRsp(req.getUgcGuid(),
            req.getUgcType(),
            req.getUgcRecordUsage()));

        proto.setRetcode(errorCode.getNumber());
    }
}
