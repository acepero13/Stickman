/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman3D.animation.head;

import java.util.ArrayList;

import de.dfki.stickman3D.Stickman3D;
import de.dfki.stickman3D.StickmanStageController;
import de.dfki.stickman3D.animationlogic.AnimationContent;
import de.dfki.stickman3D.animationlogic.Animation;

/**
 *
 * @author Beka
 *
 */
public class TiltLeftBack extends Animation {

	public TiltLeftBack() {
		mAnimType = ANIMTYPE.ON;
	}

	public TiltLeftBack(Stickman3D sm, int duration, boolean block) {
		super(sm, duration, block);
	}

	@Override
	public void playAnimation() {
		mAnimationPartFX = new ArrayList<>();
		mAnimationPartFX.add(new AnimationContent(mStickmanFX.mHeadFX, "zrotate", -10));
		playAnimationPart(200);

		StickmanStageController.currentRadioButton.setSelected(false);
	}
}
