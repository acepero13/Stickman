/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.animation.gesture;

import de.dfki.stickman.animation.head.*;
import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animation;
import de.dfki.stickman.animationlogic.AnimationContent;
import java.util.ArrayList;

/**
 *
 * @author Beka Aptsiauri
 *
 */
public class StartMeditation extends Animation
{

	public StartMeditation(Stickman sm, int duration, boolean block)
	{
		super(sm, duration, block);
	}

	@Override
	public void playAnimation()
	{
            int rotationsUnit = 10;
                
            // start Meditation
            mAnimationPart = new ArrayList<>();
            mAnimationPart.add(new AnimationContent(mStickman.mRightUpperLeg, "rotate", rotationsUnit*6));
            mAnimationPart.add(new AnimationContent(mStickman.mRightForeLeg, "rotate", -rotationsUnit*8));
            mAnimationPart.add(new AnimationContent(mStickman.mRightFoot, "rotate", -rotationsUnit*8));
                        
            mAnimationPart.add(new AnimationContent(mStickman.mLeftUpperLeg, "rotate", -rotationsUnit*6));
            mAnimationPart.add(new AnimationContent(mStickman.mLeftForeLeg, "rotate", rotationsUnit*8));
            mAnimationPart.add(new AnimationContent(mStickman.mLeftFoot, "rotate", rotationsUnit*8));
                        
            mAnimationPart.add(new AnimationContent(mStickman.mRightUpperArm, "rotate", rotationsUnit*5));
            mAnimationPart.add(new AnimationContent(mStickman.mRightForeArm, "rotate", -rotationsUnit*19));
            mAnimationPart.add(new AnimationContent(mStickman.mRightHand, "rotate", -rotationsUnit*20));
                        
            mAnimationPart.add(new AnimationContent(mStickman.mLeftUpperArm, "rotate", -rotationsUnit*5));
            mAnimationPart.add(new AnimationContent(mStickman.mLeftForeArm, "rotate", rotationsUnit*19));
            mAnimationPart.add(new AnimationContent(mStickman.mLeftHand, "rotate", rotationsUnit*20));
                        
            mAnimationPart.add(new AnimationContent(mStickman.mMouth, "shape", "O"));
                        
            mAnimationPart.add(new AnimationContent(mStickman.mRightEye, "shape", "BLINK"));
            mAnimationPart.add(new AnimationContent(mStickman.mLeftEye, "shape", "BLINK"));
			
            playAnimationPart(mDuration);
            pauseAnimation(1200);
	}
}