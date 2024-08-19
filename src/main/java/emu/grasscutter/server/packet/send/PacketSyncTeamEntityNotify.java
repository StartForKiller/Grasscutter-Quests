package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BaseTypedPacket;
import lombok.val;
import org.anime_game_servers.multi_proto.gi.messages.general.ability.AbilitySyncStateInfo;
import org.anime_game_servers.multi_proto.gi.messages.team.SyncTeamEntityNotify;
import org.anime_game_servers.multi_proto.gi.messages.team.TeamEntityInfo;
import org.anime_game_servers.multi_proto.gi.messages.general.ability.AbilityAppliedAbility;
import org.anime_game_servers.multi_proto.gi.messages.general.ability.AbilityString;

import java.util.ArrayList;
import java.util.List;

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

					val abilityString = new AbilityString();
					abilityString.setType(new AbilityString.Type.Str(a.getData().abilityName));

					val ability = new AbilityAppliedAbility();
					ability.setAbilityName(abilityString);
					ability.setInstancedAbilityId(i + 1);

					abilities.add(ability);
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
