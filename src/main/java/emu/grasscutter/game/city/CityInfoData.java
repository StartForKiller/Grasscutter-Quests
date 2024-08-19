package emu.grasscutter.game.city;

import org.anime_game_servers.multi_proto.gi.messages.scene.CityInfo;
import dev.morphia.annotations.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
public class CityInfoData {
    @Getter @Setter private int cityId;

    @Getter @Setter
    private int level = 1; // level of the city (include level SotS, level Frostbearing Trees, etc.)

    @Getter @Setter private int numCrystal = 0; // number of crystals in the city

    public CityInfoData(int cityId) {
        this.cityId = cityId;
    }

    public CityInfo toProto() {
        return new CityInfo(cityId, numCrystal, level);
    }
}