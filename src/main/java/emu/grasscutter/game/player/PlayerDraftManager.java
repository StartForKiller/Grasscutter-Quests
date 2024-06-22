package emu.grasscutter.game.player;

import java.util.Map;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.DraftData;
import emu.grasscutter.server.event.player.PlayerTeleportEvent.TeleportType;
import emu.grasscutter.utils.Position;
import lombok.val;

import java.util.HashMap;

public class PlayerDraftManager extends BasePlayerManager {

    //TODO
    public Map<Integer, Integer> draftStatus;

    private Map<Integer, Integer> getDraftStatus() {
        if (draftStatus == null) {
            draftStatus = new HashMap<>();
        }
        return draftStatus;
    }

    public PlayerDraftManager(Player player) {
        super(player);
    }

    private boolean executeDraft(DraftData data) {
        switch(data.getExec()) {
            case DRAFT_EXEC_GALLERY:
                {
                    val gallery = player.getScene().getGalleries().get(data.getParam());
                    if(gallery != null && !gallery.isStarted())
                        return true;
                    else
                        return true;
                }
        }

        return false;
    }

    private boolean transferAndFinishDraft(DraftData data) {
        //TODO: Multiplayer
        if(player.isInMultiplayer()) return false;

        val transferConfig = data.getTransferConfig().get(0);
        if(transferConfig == null) return false;
        val group = player.getScene().getScriptManager().getGroupById(transferConfig.getGroupId());
        if(group == null) return false; //Something should be very bad if we reached here

        val point = group.getPoints().get(transferConfig.getConfigId());
        if(point == null) {
            return false;
        }
        Position position = new Position(point.getPos().getX(), point.getPos().getY(), point.getPos().getZ());
        Position rotation = new Position(point.getRot().getX(), point.getRot().getY(), point.getRot().getZ());

        //Transfer player to point position
        if(!player.getWorld().transferPlayerToScene(player, data.getSceneId(), TeleportType.DRAFT, position, rotation)) return false;

        val gallery = player.getScene().getGalleries().get(data.getParam());
        return gallery.initStart();
    }

    public boolean startInvite(int draftId) {
        if(getDraftStatus().containsKey(draftId)) return false;

        val data = GameData.getDraftDataMap().get(draftId);
        if(data == null) {
            //TODO: Fail log
            return false;
        }

        //TODO: multiplayer
        if((!data.isEnableMp() && player.isInMultiplayer()) || player.isInMultiplayer()) return false;
        //TODO: Improve

        //On singleplayer we skip basically all params, inmediate start
        if(!executeDraft(data)) return false;

        return transferAndFinishDraft(data);
    }

}
