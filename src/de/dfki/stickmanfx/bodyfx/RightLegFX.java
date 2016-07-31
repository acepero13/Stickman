/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickman.body.*;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class RightLegFX extends BodyPartFX {

    BodyFX mBodyFX;

    public RightLegFX(BodyFX body) 
    {
        mBodyFX = body;
        mLength = 150;
        mSize = new Dimension(10, mLength);
        mColor = Color.rgb(80, 80, 80);

        init();
    }

    @Override
    public void createShape() 
    {
        mStart = mBodyFX.getRightLegStartPostion();
        mEnd = new Point(mStart.x, mStart.y + mLength);

        clearDrawObjects();

        if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) 
        {
            if (mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) //Added by Robbie
            {
                int fadeFactor = mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
                if (fadeFactor <= 24) 
                {
                    fadeFactor = 0;
                }
                mColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
            } 
            else 
            {
                int fadeFactor = (20 - mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 12;
                if (fadeFactor >= 216) 
                {
                    fadeFactor = 255;
                }
                mColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
            }
        }

        Path gp = new Path();
        gp.getElements().add(new MoveTo(mStart.x, mStart.y + 2));
        gp.getElements().add(new QuadCurveTo(mStart.x - 5, (mStart.y + mEnd.y) / 2, mEnd.x, mEnd.y));
        this.getChildren().add(gp);
        addToDrawObjects(gp);

        gp = new Path();
        gp.getElements().add(new MoveTo(mEnd.x - 5, mEnd.y + 4));
        gp.getElements().add(new QuadCurveTo(mEnd.x, mEnd.y + 2, mEnd.x + 5, mEnd.y + 4));
        this.getChildren().add(gp);
        addToDrawObjects(gp);
    }
}