package emu.grasscutter.game.quest.exec;

import emu.grasscutter.game.quest.GameQuest;
import emu.grasscutter.game.quest.QuestValueExec;
import emu.grasscutter.game.quest.enums.QuestExec;
import emu.grasscutter.game.quest.handlers.QuestExecHandler;
import emu.grasscutter.data.common.quest.SubQuestData.QuestExecParam;

import java.util.Arrays;

@QuestValueExec(QuestExec.QUEST_EXEC_ADD_QUEST_PROGRESS)
public class ExecAddQuestProgress extends QuestExecHandler {
    @Override
    public boolean execute(GameQuest quest, QuestExecParam condition, String... paramStr) {
        var param = Arrays.stream(paramStr)
            .filter(i -> !i.isBlank())
            .mapToInt(Integer::parseInt)
            .toArray();

        quest.getOwner().getProgressManager().addQuestProgress(param[0], param[1]);

        return true;
    }
}
