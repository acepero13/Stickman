package de.dfki.stickmanfx.stagecontroller;

import de.dfki.common.*;
import de.dfki.stickman.Stickman;
import de.dfki.stickmanfx.StickmanFX;

/**
 * Created by alvaro on 9/19/16.
 */
public class StickmansOnStageFX extends CommonStickmansOnStage{
    public StickmansOnStageFX(StageStickman stageStickman) {
        super(stageStickman);
    }

    public StickmansOnStageFX(StageStickman stickmanStageFX, StageStickmanController controllerFX) {
        super(stickmanStageFX, controllerFX);
    }

    @Override
    protected void addStickmanToStage(String name, boolean fullScreen, Stickman.TYPE gender) {
        if (fullScreen) {
            CommonStickman stickman = new StickmanFX(name, gender, stickmanStage.getFullScreenScale(), stickmanStage.getFullScreenDimension());
            putFullStickmanOnStage(name, stickman);
        }else{
            CommonStickman stickman = new StickmanFX(name, gender, DEFAULT_SCALE);
            putFullStickmanOnStage(name, stickman);
        }
    }

    @Override
    protected void addStickmanToStage(String name, boolean fullScreen, Stickman.TYPE gender, boolean onlyFace) {
        if (fullScreen) {
            CommonStickman stickman = new StickmanFX(name, gender, stickmanStage.getFullScreenScale(), stickmanStage.getFullScreenDimension(), onlyFace);
            putFullStickmanOnStage(name, stickman);
        }else{
            float scale = DEFAULT_SCALE;
            if(onlyFace){
                scale = 1.0f;
            }
            CommonStickman stickman = new StickmanFX(name, gender, scale, onlyFace);
            putFullStickmanOnStage(name, stickman);
        }
    }
}