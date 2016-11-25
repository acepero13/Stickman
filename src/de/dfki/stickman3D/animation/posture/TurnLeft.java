/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.posture;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent;
import de.dfki.stickman3D.animationlogic.Animation;

import java.util.ArrayList;
import javafx.application.Platform;

/**
 * An angry facial movement is created in this class. The face moves from the
 * default state to the angry state, and then comes back to the default state.
 *
 * @author Beka Aptsiauri
 */
public class TurnLeft extends Animation {

	/**
	 *
	 * @param sm
	 *            Stickman
	 * @param duration
	 *            Control the speed of the movement from one emotion state to
	 *            another emotion state.
	 * @param block
	 *            block or not the others movements, when one movement is not
	 *            finished.
	 */

	public TurnLeft() {
		mAnimType = ANIMTYPE.ON;
	}

	public TurnLeft(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	/**
	 * This method creates the angry facial movement.
	 */
	@Override
	public void playAnimation() {
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "yrotate", -20));
		playAnimationPart(100);

		if (mStickmanFX.mType == Stickman3D.TYPE.MALE) {
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "yrotate", -40));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mUpperBody, "yrotate", -60));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "yrotate", -20));
			playAnimationPart(500);
		} else {
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "yrotate", -70));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mUpperBody, "yrotate", -60));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "yrotate", -20));
			playAnimationPart(500);
		}

		pauseAnimation(1000);

		if (mStickmanFX.mType == Stickman3D.TYPE.MALE) {
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "yrotate", 40));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mUpperBody, "yrotate", 60));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "yrotate", 40));
			playAnimationPart(500);
		} else {
			mAnimationPartFX = new ArrayList<>();
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftWrist, "yrotate", 70));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mUpperBody, "yrotate", 60));
			mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "yrotate", 40));
			playAnimationPart(500);
		}

		StickmanStageController.currentRadioButton.setSelected(false);
	}
}