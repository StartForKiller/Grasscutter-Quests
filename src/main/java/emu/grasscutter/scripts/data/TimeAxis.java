package emu.grasscutter.scripts.data;

import lombok.Data;

import static org.anime_game_servers.gi_lua.models.constants.EventType.EVENT_TIME_AXIS_PASS;

import java.util.List;

import org.anime_game_servers.gi_lua.models.ScriptArgs;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.scripts.SceneScriptManager;

@Data
public class TimeAxis {
    private String name;
    private List<Integer> timerValues;
    private int currentIndex = 0;
    private boolean isLoop;
    private int currentTask;

    public TimeAxis(String name, List<Integer> timerValues, boolean isLoop) {
        this.name = name;
        this.timerValues = timerValues;
        this.isLoop = isLoop;
    }

    public int getNextTimerDelay() {
        if(currentIndex >= timerValues.size()) {
            if(isLoop)
                currentIndex = 0;
            else
                return 0;
        }

        return timerValues.get(currentIndex++);
    }

    public boolean isTimeAxisFinished() {
        if(isLoop) return false;
        return currentIndex >= timerValues.size();
    }

    public boolean start(SceneScriptManager scriptManager, int groupID) {
        int firstDelay = getNextTimerDelay();
        if(firstDelay == 0) {
            Grasscutter.getLogger().error("Time Axis started with delay of zero");
            return false;
        }

        currentTask = Grasscutter.getGameServer().getScheduler().scheduleDelayedTask(() -> {
            scriptManager.callEvent(new ScriptArgs(groupID, EVENT_TIME_AXIS_PASS).setEventSource(name).setParam1(currentIndex));
            endTask(scriptManager, groupID);
        }, (int)firstDelay);

        return true;
    }

    public void endTask(SceneScriptManager scriptManager, int groupID) {
        if(isTimeAxisFinished()) {
            scriptManager.cancelGroupTimeAxis(groupID, name);
            return;
        }

        int nextDelay = getNextTimerDelay();

        currentTask = Grasscutter.getGameServer().getScheduler().scheduleDelayedTask(() -> {
            scriptManager.callEvent(new ScriptArgs(groupID, EVENT_TIME_AXIS_PASS).setEventSource(name).setParam1(currentIndex));
            endTask(scriptManager, groupID);
        }, (int)nextDelay);
    }

    public void cancel() {
        Grasscutter.getGameServer().getScheduler().cancelTask(currentTask);
    }
}
