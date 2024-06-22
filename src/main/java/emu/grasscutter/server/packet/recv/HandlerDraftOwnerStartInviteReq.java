package emu.grasscutter.server.packet.recv;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.net.packet.TypedPacketHandler;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketDraftOwnerStartInviteRsp;
import messages.gallery.draft.DraftInviteFailInfo;
import messages.gallery.draft.DraftInviteFailReason;
import messages.gallery.draft.DraftOwnerStartInviteReq;

public class HandlerDraftOwnerStartInviteReq extends TypedPacketHandler<DraftOwnerStartInviteReq> {

    @Override
    public void handle(GameSession session, byte[] header, DraftOwnerStartInviteReq payload) throws Exception {
        Grasscutter.getLogger().error("DraftOwnerStartInviteReq not implemented (" + payload.getDraftId() + ")");

        if(!session.getPlayer().getPlayerDraftManager().startInvite(payload.getDraftId())) {
            session.getPlayer().sendPacket(
                new PacketDraftOwnerStartInviteRsp(
                    payload.getDraftId(),
                    0,
                    0,
                    new DraftInviteFailInfo(DraftInviteFailReason.DRAFT_INVITE_FAIL_ACTIVITY_NOT_OPEN, session.getPlayer().getUid())
                )
            );
        } else {
            session.getPlayer().sendPacket(new PacketDraftOwnerStartInviteRsp(payload.getDraftId()));
        }
    }

}
