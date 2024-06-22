package emu.grasscutter.game.entity.interfaces;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.binout.config.fields.ConfigAbilityData;
import emu.grasscutter.game.entity.GameEntity;
import lombok.val;

public interface ConfigAbilityDataAbilityEntity extends BaseAbilityEntity<ConfigAbilityData> {
    @Override
    default void initAbilities() {
        val abilityData = getAbilityData();
        if (abilityData == null || abilityData.isEmpty()) return;

        val abilityManager = getAbilityTargetManager();

        for (val entityAbilityData : abilityData) {
            val data = GameData.getAbilityData(entityAbilityData.getAbilityName());
            if (data != null) {
                abilityManager.addAbilityToEntity((GameEntity) this, data);
            } else {
                Grasscutter.getLogger().error("Ability {} not found", entityAbilityData.getAbilityName());
            }
        }
    }
}
