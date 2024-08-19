package emu.grasscutter.game.ability.actions;

import com.google.protobuf.ByteString;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.binout.AbilityModifier.AbilityModifierAction;
import emu.grasscutter.game.ability.Ability;
import emu.grasscutter.game.entity.EntityAvatar;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.player.Player;

import lombok.val;

@AbilityAction(AbilityModifierAction.Type.ServerLuaCall)
public class AbilityServerLuaCall extends AbilityActionHandler {

    @Override
    public boolean execute(Ability ability, AbilityModifierAction action, byte[] abilityData, GameEntity target) {
        switch(action.luaCallType) {
            case CurGalleryControlGroup:
                {
                    Player player;
                    if(target instanceof EntityAvatar) {
                        player = ((EntityAvatar)target).getPlayer();
                    } else {
                        Grasscutter.getLogger().error("ServerLuaCall: Unimplemented type of target {}", action.luaCallType, target.getEntityType());
                        return false;
                    }

                    int currentGallery = player.getCurrentGallery();
                    if(currentGallery == 0)
                        return false;

                    val gallery = player.getScene().getGalleries().get(currentGallery);
                    if(gallery == null) {
                        Grasscutter.getLogger().error("Gallery {} not found on scene", currentGallery);
                        return false;
                    }

                    return gallery.handleControlGroupLuaCall(action.funcName, ability.getOwner().getId(), player.getUid(), (int)action.param1, (int)action.param2, (int)action.param3);
                }
            default:
                Grasscutter.getLogger().error("ServerLuaCall: luaCallType {} not implemented", action.luaCallType);
                return false;
        }
    }

}
