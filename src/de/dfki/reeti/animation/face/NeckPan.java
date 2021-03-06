/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.reeti.animation.face;

import de.dfki.reeti.Reeti;
import de.dfki.reeti.animationlogic.AnimationReeti;
import de.dfki.reeti.animationlogic.AnimationContentReeti;

import java.util.ArrayList;

/**
 *
 * @author Beka
 *
 */
public class NeckPan extends AnimationReeti {

    
    int rot;

    public NeckPan(Reeti sm, int duration, int pos, boolean block) {
        super(sm, duration, pos, block);
        this.rot = pos;
    }

    @Override
    public void playAnimation() {
        
        mAnimationPart = new ArrayList<>();
        mAnimationPart.add(new AnimationContentReeti(mReeti.mHead, "rotate", rot));
        playAnimationPart(mDuration);
        
    }
}
