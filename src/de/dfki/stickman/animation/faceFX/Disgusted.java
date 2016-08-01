/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.animation.faceFX;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;
import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Disgusted extends Animation {
	
	public Disgusted() {
		mAnimType = ANIMTYPE.EmotionExpression;
	}

	public Disgusted(Stickman sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		// disgusted
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "DISGUSTED"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "DISGUSTED"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "DISGUSTED"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "DISGUSTED"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "DISGUSTED"));
//		playAnimationPart(20);
		playAnimationPart(mDuration);

		pauseAnimation(1200);

		// no disgusted
		mAnimationPart = new ArrayList<>();
		mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "DISGUSTEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "DISGUSTEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mLeftEyebrow, "shape", "DISGUSTEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "DISGUSTEDEND"));
		mAnimationPart.add(new AnimationContent(mStickman.mRightEyebrow, "shape", "DISGUSTEDEND"));
		playAnimationPart(20);
	}
}
