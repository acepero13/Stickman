/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.face;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.animationlogic.AnimationContent;
import de.dfki.stickman3D.animationlogic.Animation;

import java.util.ArrayList;
import javafx.application.Platform;

/**
 *
 * @author Beka
 *
 */
public class EmbarrassedStart extends Animation {

	public EmbarrassedStart(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {

		// embarrassed
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mMouthFX, "shape", "EMBARRASSED"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyeFX, "shape", "EMBARRASSED"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mLeftEyebrowFX, "shape", "EMBARRASSED"));
		// mAnimationPartFX.add(new AnimationContent(mStickmanFX.mFaceWrinkle,
		// "shape", "EMBARRASSED")); ///Add by Robbie
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyeFX, "shape", "EMBARRASSED"));
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mRightEyebrowFX, "shape", "EMBARRASSED"));
		playAnimationPart(mDuration);

		pauseAnimation(10);
	}
}