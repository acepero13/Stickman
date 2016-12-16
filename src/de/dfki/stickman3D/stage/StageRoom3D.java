package de.dfki.stickman3D.stage;

import de.dfki.common.commonFX3D.StageRoomImpl;
import de.dfki.common.commonFX3D.ApplicationLauncherImpl;
import de.dfki.stickman3D.ApplicationLauncher3D;

import java.io.IOException;

/**
 * Created by alvaro on 9/12/16.
 */
public class StageRoom3D extends StageRoomImpl {

    public StageRoom3D() {
        getStickmanStageInstance();
        createNewStickmanStage(0, 0, true);
    }

    public StageRoom3D(int x, int y) {
        getStickmanStageInstance();
        createNewStickmanStage(x, y, true);
    }

    public StageRoom3D(int x, int y, boolean decoration) {
        getStickmanStageInstance();
        createNewStickmanStage(x, y, decoration);
    }

    @Override
    public void sendTimeMarkInformation(String timemark) {

    }

    @Override
    public void sendAnimationUpdate(String state, String id) {

    }

    protected void getStickmanStageInstance() {
        applicationFXLauncher = new ApplicationLauncher3D();
        if (ApplicationLauncherImpl.isRunning()) {
            stickmanStageFX = StickmanStage3D.getInstance();
        } else {
            applicationFXLauncher.launchStickmanAndWait();
        }
    }

    protected void createNewStickmanStage(int x, int y, boolean decoration) {
        stickmanStageFX = StickmanStage3D.getInstance();
        try {
            stageIdentifier = getStickmanStage().createNewStage(x, y, decoration);
            init(stageIdentifier);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init(String stageIdentifier) {

        commonStickmansOnStage = new StickmansOnStage3D(getStickmanStage(), this, stageIdentifier);
        getStickmanStage().setStickamnsOnStage(getCommonStickmansOnStage(), stageIdentifier);
        getStickmanStage().setStickamnsOnStage(getCommonStickmansOnStage(), CONFIG_STAGE);
    }
}