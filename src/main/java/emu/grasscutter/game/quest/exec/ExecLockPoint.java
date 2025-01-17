package emu.grasscutter.game.quest.exec;

import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValueExec;
import emu.grasscutter.game.quest.enums.QuestExec;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;
import emu.grasscutter.data.common.quest.SubQuestData.QuestExecParam;

@QuestValueExec(QuestExec.QUEST_EXEC_LOCK_POINT)
public class ExecLockPoint extends QuestExecHandler {
    @Override
    public boolean execute(GameQuest quest, QuestExecParam condition, String... paramStr) {
        // Lock the trans point for the player.
        int sceneId = Integer.parseInt(paramStr[0]);
        int pointId = Integer.parseInt(paramStr[1]);

        // Done.
        return quest.getOwner().getProgressManager().lockTransPoint(sceneId, pointId);
    }
}
