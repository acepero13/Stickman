/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.animation.headfx;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickmanfx.animationlogic.AnimationContentFX;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;

import java.util.ArrayList;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Nod extends AnimationFX {

	public Nod(StickmanFX sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		int translationUnit = 3;

		// head down
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "translate", translationUnit));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "translate", translationUnit));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "translate", translationUnit));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "translate", translationUnit));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "translate", translationUnit));
		
		if(mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "translate", translationUnit));
		else
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "translate", translationUnit));
		
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "translate", translationUnit));
		playAnimationPart(200);

		// head up
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyebrowFX, "translate", -translationUnit));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mRightEyeFX, "translate", -translationUnit));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyebrowFX, "translate", -translationUnit));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mLeftEyeFX, "translate", -translationUnit));
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mHeadFX, "translate", -translationUnit));
		
		if(mStickmanFX.mType == StickmanFX.TYPE.MALE)
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMaleHairFX, "translate", -translationUnit));
		else
			mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mFemaleHairFX, "translate", -translationUnit));
		
		mAnimationPartFX.add(new AnimationContentFX(mStickmanFX.mMouthFX, "translate", -translationUnit));

		playAnimationPart(200);
	}
}