package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.List;

@ResourceType(name = "DraftExcelConfigData.json")
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DraftData extends GameResource {
    int id;
    List<TransferConfig> transferConfig;
    int sceneId;
    DraftExecType exec;
    int param;
    boolean enableMp;
    boolean isNeedAllAgree;
    int confirmCountDown;
    int minPlayerCount;
    boolean isNeedTwiceConfirm;
    int twiceConfirmCountDown;
    DraftExecSubType JNMHNOOLAPH = DraftExecSubType.DRAFT_EXEC_SUB_NONE;

    @Override
    public int getId() {
        return id;
    }

    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class TransferConfig {
        int groupId;
        int configId;
    }

    public enum DraftExecType {
        DRAFT_EXEC_GALLERY,
        DRAFT_EXEC_HIDE_AND_SEEK,
        DRAFT_EXEC_CHAR_AMUSEMENT
    }

    public enum DraftExecSubType {
        DRAFT_EXEC_SUB_NONE,
        DRAFT_EXEC_SUB_ISLAND_PARTY
    }
}
