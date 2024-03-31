package emu.grasscutter.data.excels;

import java.util.List;

import com.mongodb.lang.Nullable;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import lombok.Getter;

@ResourceType(name = "GalleryExcelConfigData.json")
@Getter
public class GalleryData extends GameResource {
    private int id;
    private GalleryType type;
    private List<String> param;
    private boolean canInterruptByClient = false;
    private List<Integer> groupId;
    @Nullable
    private Integer PLKEOGPGHPE;
    private String abilityGroup;
    private List<String> abilityGroupList;
    private String limitRegion;
    private List<Float> centerPosList;
    private int duration;
    private int nameTextMapHash;
    private int descTextMapHash;
    private int galleryNameTextMapHash;
    private int galleryMSGTextMapHash;
    private String pic;
    private int targetTextMapHash;
    private String startAudioValues;
    private String endAudioValues;
    private List<String> selectableAbilityGroups;
    private List<String> IHMGLIOMJDG;
    private List<String> GMOHFAMHPLF;
    private boolean EIPLLGKELGE = false;

    private boolean isEnableSinglePrepare = false;
    private int singlePrepareTime;
    private int sceneId;
    private int controlGroupId;
    private int revivePointGroupId;
    private int revivePointConfigId;

    @Override
	public int getId() {
		return this.id;
	}

    public enum GalleryType {
        GALLERY_TYPE_NONE(0),
        GALLERY_TYPE_BALLOON(1),
        GALLERY_TYPE_FALL(2),
        GALLERY_TYPE_ARENA_CHALLENGE(3),
        GALLERY_TYPE_CATCH_FLOWER(4),
        GALLERY_TYPE_FADEOUT_FLOOR(5),
        GALLERY_TYPE_AVOID_RAYS(6),
        GALLERY_TYPE_BROKEN_FLOOR(7),
        GALLERY_TYPE_BULLET_GAME(8),
        GALLERY_TYPE_AVOID_BUBBLES(9),
        GALLERY_TYPE_REMEMBER_ROAD(10),
        GALLERY_TYPE_MIST_TRIAL(11),
        GALLERY_TYPE_HIDE_AND_SEEK(12),
        GALLERY_TYPE_BUOYANT_COMBAT(13),
        GALLERY_TYPE_BOUNCE_CONJURING(14),
        GALLERY_TYPE_HANDBALL(15),
        GALLERY_TYPE_SUMO_COMBAT(16),
        GALLERY_TYPE_FISH(17),
        GALLERY_TYPE_DIG_COMBAT(18),
        GALLERY_TYPE_TRIATHLON(19),
        GALLERY_TYPE_HOME_RACING(20),
        GALLERY_TYPE_SALVAGE_PREVENT(21),
        GALLERY_TYPE_SALVAGE_ESCORT(22),
        GALLERY_TYPE_HOME_BALLOON(23),
        GALLERY_TYPE_CRYSTAL_LINK(24),
        GALLERY_TYPE_PHOTO(25),
        GALLERY_TYPE_SWORD_WAY(26),
        GALLERY_TYPE_LUMINANCE_STONE_CHALLENGE(27),
        GALLERY_TYPE_HOME_SEEK_FURNITURE(28),
        GALLERY_TYPE_MP_BLOCK(29),
        GALLERY_TYPE_ISLAND_PARTY_RAFT(30),
        GALLERY_TYPE_ISLAND_PARTY_SAIL(31),
        GALLERY_TYPE_ISLAND_PARTY_DOWN_HILL(32),
        GALLERY_TYPE_SUMMER_TIME_V2_BOAT_RACE(33),
        GALLERY_TYPE_GRAVEN_INNOCENCE_RACE(34),
        GALLERY_TYPE_INSTABLE_SPRAY(35),
        GALLERY_TYPE_MUQADAS_POTION(36),
        GALLERY_TYPE_TREASURE_SEELIE(37),
        GALLERY_TYPE_VINTAGE_HUNTING(38),
        GALLERY_TYPE_WIND_FIELD(39),
        GALLERY_TYPE_FUNGUS_FIGHTING_TRAINING(40),
        GALLERY_TYPE_FUNGUS_FIGHTING_CAPTURE(41),
        GALLERY_TYPE_CHAR_AMUSE_SPIN_BALL(42),
        GALLERY_TYPE_CHAR_AMUSE_PILLAR(43),
        GALLERY_TYPE_CHAR_AMUSE_RUN_ON_WATER(44),
        GALLERY_TYPE_CHAR_AMUSE_BASE_BALL(45),
        GALLERY_TYPE_CHAR_AMUSE_FOOT_BALL(46),
        GALLERY_TYPE_CHAR_AMUSE_BRICK_WALL(47),
        GALLERY_TYPE_CHAR_AMUSE_BATTLE(48),
        GALLERY_TYPE_EFFIGY_CHALLENGE_V2(49),
        GALLERY_TYPE_BRICK_BREAKER(50),
        GALLERY_TYPE_COIN_COLLECT(51),
        GALLERY_TYPE_ELECTROHERCULES_BATTLE(52),
        GALLERY_TYPE_LANV3_BOAT_GAME_SINGLE(53),
        GALLERY_TYPE_LANV3_BOAT_GAME_MULTI(54),
        GALLERY_TYPE_TEAM_CHAIN(55),
        GALLERY_TYPE_DUEL_HEART(56),
        GALLERY_TYPE_LANV3_RACE(57);

        private final int value;
        private GalleryType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
