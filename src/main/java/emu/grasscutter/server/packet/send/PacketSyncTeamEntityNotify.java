package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AbilitySyncStateInfoOuterClass.AbilitySyncStateInfo;
import emu.grasscutter.net.proto.SyncTeamEntityNotifyOuterClass.SyncTeamEntityNotify;
import emu.grasscutter.net.proto.TeamEntityInfoOuterClass.TeamEntityInfo;
import lombok.val;
import emu.grasscutter.net.proto.AbilityAppliedAbilityOuterClass.AbilityAppliedAbility;
import emu.grasscutter.net.proto.AbilityStringOuterClass.AbilityString;

import java.util.*;

public class PacketSyncTeamEntityNotify extends BasePacket {

	public PacketSyncTeamEntityNotify(Player player) {
		super(PacketOpcodes.SyncTeamEntityNotify);

		SyncTeamEntityNotify.Builder proto = SyncTeamEntityNotify.newBuilder()
				.setSceneId(player.getSceneId());

		if (player.getWorld().isMultiplayer()) {
			for (Player p : player.getWorld().getPlayers()) {
				// Skip if same player
				if (player == p) {
					continue;
				}

				// Set info
				TeamEntityInfo info = TeamEntityInfo.newBuilder()
						.setTeamEntityId(p.getTeamManager().getEntity().getId())
						.setAuthorityPeerId(p.getPeerId())
						.setTeamAbilityInfo(AbilitySyncStateInfo.newBuilder())
						.build();

				proto.addTeamEntityInfoList(info);
			}
		}

		this.setData(proto);
	}

	public PacketSyncTeamEntityNotify(Player player, boolean ability) {
		super(PacketOpcodes.SyncTeamEntityNotify);

		SyncTeamEntityNotify.Builder proto = SyncTeamEntityNotify.newBuilder()
				.setSceneId(player.getSceneId());

		if (player.getWorld().isMultiplayer() || ability) {
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
				TeamEntityInfo info = TeamEntityInfo.newBuilder()
						.setTeamEntityId(entity.getId())
						.setAuthorityPeerId(p.getPeerId())
						.setTeamAbilityInfo(AbilitySyncStateInfo.newBuilder()
							.setIsInited(true)
							.addAllAppliedAbilities(abilities))
						.build();

				proto.addTeamEntityInfoList(info);
			}
		}

		this.setData(proto);
	}
}
