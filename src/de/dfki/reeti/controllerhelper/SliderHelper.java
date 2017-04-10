/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.controllerhelper;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.ReetiStageController;
import java.awt.Point;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Slider;
import javafx.scene.transform.Rotate;

/**
 *
 * @author EmpaT
 */
public class SliderHelper {

    final static int HEADSTARTPOSITION = 50;

    public static void handleHeadSlider(ReetiStageController controller, Slider slider, String achse) {
        slider.setMin(0);
        slider.setMax(100);
        slider.setValue(50);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            Reeti reeti = controller.currentReeti;
            double newValue = new_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                controller.currentReeti.mHead.mXRotation = (-(newValue- 50) * 40) / 100;
                controller.headXRotationField.setText(Integer.toString((int) newValue));
            } else if (achse.equalsIgnoreCase("Y")) {
                controller.currentReeti.mHead.mYRotation = -(newValue- 50);
                controller.headYRotationField.setText(Integer.toString((int) newValue));
            } else {
                controller.currentReeti.mHead.mZRotation =  ((newValue- 50) * 40) / 100;
                controller.headZRotationField.setText(Integer.toString((int) newValue));
            }
            controller.currentReeti.mHead.calculate(0);
        });
    }

    public static void handleLeftEyeXSlider(ReetiStageController controller) {
        controller.leftEyeXSlider.setMin(0);
        controller.leftEyeXSlider.setMax(100);
        controller.leftEyeXSlider.setValue(50);
        controller.leftEyeXSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            Reeti reeti = controller.currentReeti;
            double newValue = new_val.doubleValue();
            controller.currentReeti.mLeftEye.mXRotation = (-(newValue- 50) * 90) / 100;
            controller.leftEyeXRotationField.setText(Integer.toString((int) newValue));
            controller.currentReeti.mLeftEye.calculate(0);
        });
    }

    public static void handleLeftEyeYSlider(ReetiStageController controller) {
        controller.leftEyeYSlider.setMin(0);
        controller.leftEyeYSlider.setMax(100);
        controller.leftEyeYSlider.setValue(50);
        controller.leftEyeYSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            Reeti reeti = controller.currentReeti;
            double newValue = new_val.doubleValue();
            controller.currentReeti.mLeftEye.mYRotation = (-(newValue- 50) * 90) / 100;
            controller.leftEyeYRotationField.setText(Integer.toString((int) newValue));
            controller.currentReeti.mLeftEye.calculate(0);
        });
    }

    public static void handleCameraSlider(ReetiStageController controller, Slider slider, String achse) {
        slider.setMin(-180);
        slider.setMax(180);
        slider.setValue(0);
        slider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {

            double newValue = new_val.doubleValue();
            double oldValue = old_val.doubleValue();
            if (achse.equalsIgnoreCase("X")) {
                double xRotateFactor = newValue - oldValue;
                Point pivot = controller.currentReeti.mBody.getUpperBodyPosition();
                Rotate rx = new Rotate(xRotateFactor, pivot.x, pivot.y, 1505, Rotate.X_AXIS);
                controller.getStage3D().getCamera().getTransforms().addAll(rx);
            } else if (achse.equalsIgnoreCase("Y")) {
                double yRotateFactor = newValue - oldValue;
                Point pivot = controller.currentReeti.mBody.getUpperBodyPosition();
                Rotate ry = new Rotate(yRotateFactor, pivot.x, pivot.y, 1505, Rotate.Y_AXIS);
                controller.getStage3D().getCamera().getTransforms().addAll(ry);
            } else {
                double zRotateFactor = newValue - oldValue;
                Point pivot = controller.currentReeti.mBody.getUpperBodyPosition();
                Rotate rz = new Rotate(zRotateFactor, pivot.x, pivot.y, 1505, Rotate.Z_AXIS);
                controller.getStage3D().getCamera().getTransforms().addAll(rz);
            }
        });
    }
}
