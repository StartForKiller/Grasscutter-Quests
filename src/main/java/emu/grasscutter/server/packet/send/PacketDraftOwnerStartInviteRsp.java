package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BaseTypedPacket;
import messages.gallery.draft.DraftInviteFailInfo;
import messages.gallery.draft.DraftOwnerStartInviteRsp;

import java.util.List;

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
