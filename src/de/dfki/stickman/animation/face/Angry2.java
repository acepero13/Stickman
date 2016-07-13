/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.animation.face;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;
import de.dfki.stickman.body.LeftEyebrow;

import java.util.ArrayList;

/**
 * An angry facial movement is created in this class.
 * The face moves from the default state to the angry state, and then comes back to the default state.
 * 
 * @author Patrick Gebhard
 */
public class Angry2 extends Animation {
/**
 * 
 * @param sm Stickman
 * @param duration Control the speed of the movement from one emotion state to another emotion state.
 * @param block block or not the others movements, when one movement is not finished.
 */
	public Angry2(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}
	/**
	 * This method creates the angry facial movement.
	 */
	@Override
	public void playAnimation() {
		// angry
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "ANGRY"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "ANGRY"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "ANGRY"));
		mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkle, "shape", "ANGRY"));   ///Add by Robbie
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "ANGRY"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftFoot, "rotate", -40));
//                mAnimationPart.add(new AnimationContent(mStickman.mRightForeLeg, "rotate", -20));
mAnimationPart.add(new AnimationContent(mStickman.mRightFoot, "rotate", 40));
//		playAnimationPart(20);
		playAnimationPart(mDuration);
		
		pauseAnimation(1200);

		// no angry
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "ANGRYEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "ANGRYEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "ANGRYEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mFaceWrinkle, "shape", "ANGRYEND"));   ///Add by Robbie
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "ANGRYEND"));
//		mAnimationPart.add(new AnimationContent(mStickman.mRightUpperLeg, "rotate", -10));
//                mAnimationPart.add(new AnimationContent(mStickman.mRightForeLeg, "rotate", 20));
mAnimationPart.add(new AnimationContent(mStickman.mRightFoot, "rotate", -40));
		playAnimationPart(20);
	}
}
