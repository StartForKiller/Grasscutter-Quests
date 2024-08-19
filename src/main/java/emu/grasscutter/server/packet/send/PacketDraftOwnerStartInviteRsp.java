package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;

import java.util.List;

import org.anime_game_servers.multi_proto.gi.messages.gallery.draft.DraftInviteFailInfo;
import org.anime_game_servers.multi_proto.gi.messages.gallery.draft.DraftOwnerStartInviteRsp;

public class PacketDraftOwnerStartInviteRsp extends BaseTypedPacket<DraftOwnerStartInviteRsp> {

    public PacketDraftOwnerStartInviteRsp(int draftId) {
        super(new DraftOwnerStartInviteRsp());

        proto.setDraftId(draftId);
    }

    public PacketDraftOwnerStartInviteRsp(int draftId, int retcode, int wrongUid, List<DraftInviteFailInfo> infoList) {
        super(new DraftOwnerStartInviteRsp());

        proto.setDraftId(draftId);
        proto.setWrongUid(wrongUid);
        proto.setRetcode(retcode);
        proto.setInviteFailInfoList(infoList);
    }

    public PacketDraftOwnerStartInviteRsp(int draftId, int retcode, int wrongUid, DraftInviteFailInfo info) {
        this(draftId, retcode, wrongUid, List.of(info));
    }

}
