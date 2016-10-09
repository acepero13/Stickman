package de.dfki.test;

import de.dfki.common.CommonStageStickmanNetworkControllerDecorator;
import de.dfki.common.StageStickmanController;
import de.dfki.stickman.stagecontroller.StageController;
import de.dfki.stickman.stagecontroller.decorators.StageStickmanFullScreenDecorator;
import de.dfki.stickmanfx.stagecontroller.StageStickmanControllerFX;
import de.dfki.stickmanfx.stagecontroller.decorators.StageStickmanFullScreenControllerFXDecorator;
import de.dfki.stickmanfx.stagecontroller.decorators.StageStickmanNetworkControllerDecoratorFX;
import javafx.scene.input.MouseButton;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by alvaro on 9/13/16.
 */
public class testStickmanFX {
    public static void main(String[] args) {
       // StageStickmanController stickmanStage = new StageStickmanFullScreenControllerFXDecorator(stage);


        StageStickmanController stickmanStage = new StageStickmanControllerFX(0,500, true);
        stickmanStage.addStickman("Martin");
        stickmanStage.addStickman("Sarah");
        //((StageStickmanControllerFX)stickmanStage2).launchStickmanConfiguration();
        stickmanStage.launchStickmanStage(true);

        StageStickmanController stickmanStage2 = new StageStickmanControllerFX(950, 0, false);
        stickmanStage2.addStickman("Anna");
        stickmanStage2.addStickman("Bob");
        //((StageStickmanControllerFX)stickmanStage2).launchStickmanConfiguration();
        stickmanStage2.launchStickmanStage(true);
        BufferedImage bufferedImage = null;

    }
}