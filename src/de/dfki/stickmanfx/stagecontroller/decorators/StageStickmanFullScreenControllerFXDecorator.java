package de.dfki.stickmanfx.stagecontroller.decorators;

import de.dfki.common.StageStickmanController;

/**
 * Created by alvaro on 9/17/16.
 */
public class StageStickmanFullScreenControllerFXDecorator extends StageStickmanDecorator {

    public StageStickmanFullScreenControllerFXDecorator(StageStickmanController wrappedController){
        super(wrappedController);
    }

    @Override
    public void addStickman(String name){
        setFullScreen(true);
        super.addStickman(name);
    }

    @Override
    public void launchStickmanStage(boolean show){
        controllerFX.getStickmanStage().setStageFullScreen(controllerFX.getStageIdentifier());
        super.launchStickmanStage(show);
    }

    @Override
    public void launchStickmanStage(boolean show, String filepath){
        controllerFX.getStickmanStage().setStageFullScreen(controllerFX.getStageIdentifier());
        super.launchStickmanStage(show, filepath);
    }

}
