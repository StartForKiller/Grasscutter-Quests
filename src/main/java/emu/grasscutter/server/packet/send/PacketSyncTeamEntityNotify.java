package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BaseTypedPacket;
import lombok.val;
import messages.general.ability.AbilitySyncStateInfo;
import messages.team.SyncTeamEntityNotify;
import messages.team.TeamEntityInfo;

import java.util.ArrayList;

public class PacketSyncTeamEntityNotify extends BaseTypedPacket<SyncTeamEntityNotify> {

	public PacketSyncTeamEntityNotify(Player player) {
		super(new SyncTeamEntityNotify(player.getSceneId()));

		if (player.getWorld().isMultiplayer()) {
            val infoList = new ArrayList<TeamEntityInfo>();
			for (Player p : player.getWorld().getPlayers()) {
				// Skip if same player
				if (player == p) {
					continue;
				}

				List<AbilityAppliedAbility> abilities = new ArrayList<>();
				val entity = p.getTeamManager().getEntity();
				val entityAbilities = entity.getInstancedAbilities();
				for(int i = 0; i < entityAbilities.size(); i++) {
					//TODO: Override map and more
					val a = entityAbilities.get(i);
					abilities.add(AbilityAppliedAbility.newBuilder()
						.setAbilityName(AbilityString.newBuilder().setStr(a.getData().abilityName).build())
						.setInstancedAbilityId(i + 1)
						.build()
					);
				}

				// Set info
				val info = new TeamEntityInfo();
                info.setTeamEntityId(p.getTeamManager().getEntity().getId());
                info.setAuthorityPeerId(p.getPeerId());
                info.setTeamAbilityInfo(new AbilitySyncStateInfo());

                infoList.add(info);
			}
            proto.setTeamEntityInfoList(infoList);
		}
	}
}
