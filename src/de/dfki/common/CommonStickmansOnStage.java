package de.dfki.common;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.util.Names;
import de.dfki.stickmanfx.StickmanFX;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by alvaro on 9/12/16.
 * Manage Stickman on the Stage
 */
public abstract class CommonStickmansOnStage {
    public static final float DEFAULT_SCALE = 0.8f;
    private Map<String, CommonStickman> sStickmansOnStage = new HashMap<>();
    protected StageStickman stickmanStage;
    private StageStickmanController stageStickmanController;
    public CommonStickmansOnStage(StageStickman stageStickman){
        stickmanStage = stageStickman;
    }

    public CommonStickmansOnStage(StageStickman stickmanStageFX, StageStickmanController controllerFX) {
        stickmanStage = stickmanStageFX;
        stageStickmanController = controllerFX;
    }

    public void setStageStickmanController(StageStickmanController controllerFX){
        stageStickmanController = controllerFX;
    }

    public void addStickman(String name, boolean fullScreen) {
        Stickman.TYPE gender = null;
        if (Names.sFemaleNames.contains(name.toLowerCase())) {
            gender = Stickman.TYPE.FEMALE;
        }
        if (Names.sMaleNames.contains(name.toLowerCase())) {
            gender = (gender == null) ? Stickman.TYPE.MALE : gender;
        }
        addStickman(name, gender, fullScreen);
    }

    public  void addStickman(String name, Stickman.TYPE gender, boolean fullScreen) {
        if (!sStickmansOnStage.containsKey(name.toLowerCase())) {
            addStickmanToStage(name, fullScreen, gender);
        }
    }

    public  void showStickmanNameFX(boolean show) {
        for (CommonStickman s : sStickmansOnStage.values()) {
            s.setShowName(show);
        }
    }

    protected abstract void addStickmanToStage(String name, boolean fullScreen, Stickman.TYPE gender);

    public CommonStickman getStickman(String name) {
        if (sStickmansOnStage.containsKey(name.toLowerCase())) {
            return sStickmansOnStage.get(name.toLowerCase());
        }
        throw new NullPointerException("No stickman with name " + name);

    }

    public void clearStage(){
        Set<String> deleteStickman = new HashSet<>();
        sStickmansOnStage.keySet().stream().map((s) -> {
            deleteStickman.add(s);
            return s;
        }).forEach((s) -> {
            getStickman(s).endAnimationScheduler();
        });

    }

    protected void putFullStickmanOnStage(String name, CommonStickman stickman) {
        sStickmansOnStage.put(name.toLowerCase(),stickman );
        stickman.setStickmanStageController(stageStickmanController);
    }

    public Set<String> getStickmanNames(){
        return sStickmansOnStage.keySet();
    }

    public StickmanFX getStickmanByKey(String key){
        return (StickmanFX) sStickmansOnStage.get(key);
    }
}
