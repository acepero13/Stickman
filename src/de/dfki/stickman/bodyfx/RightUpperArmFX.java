/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.bodyfx;

import de.dfki.stickman.body.*;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.transform.Affine;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class RightUpperArmFX extends BodyPartFX {

    RightShoulderFX mRightShoulderFX;
    int mArmLength = 70;
    Dimension mSize = new Dimension(mArmLength, mArmLength);

    Point mStart;
    Point mEnd;

    Path mArm;

    public RightUpperArmFX(RightShoulderFX shoulder) 
    {
        mRightShoulderFX = shoulder;

        mDefaultRotation = 35;
        mRotation = mDefaultRotation;
        mToDegree = mDefaultRotation;
        mRotationStep = 0.0f;

        init();

        calculate(0);
    }

    public Point getRightUpperArmEndPosition() 
    {
        return (mArm != null) ? new Point((int) mArm.boundsInParentProperty().get().getMinX(), (int) mArm.boundsInParentProperty().get().getMaxY()) : new Point(0, 0);
        //return (mArm != null) ? new Point((int) mArm.getCurrentPoint().getX(), (int) mArm.getCurrentPoint().getY()) : new Point(0, 0);
    }

    @Override
    public void calculate(int step) 
    {
        mStart = mRightShoulderFX.getRightShoulderEndPosition();
        mEnd = new Point(mStart.x, mStart.y + mArmLength);

        mArm = new Path();
        mArm.getElements().add(new MoveTo(mStart.x, mStart.y + 2));
        mArm.getElements().add(new QuadCurveTo(mStart.x - 5, (mStart.y + mEnd.y) / 2, mEnd.x, mEnd.y));

        Affine af = new Affine();
        af.appendRotation(mRotation, mStart.x, mStart.y);
        mArm.getTransforms().add(af);
//        AffineTransform t = new AffineTransform();
//        t.rotate(Math.toRadians(mRotation), mStart.x, mStart.y);
//        mArm.transform(t);
        this.getChildren().add(mArm);
    }

    @Override
    public void update() 
    {
        Color currentColor = Color.rgb(80, 80, 80);
        // draw outlines
        if (mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) 
        {
            if (mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) //Added by Robbie
            {
                int fadeFactor = mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
                if (fadeFactor <= 24) 
                {
                    fadeFactor = 0;
                }
                currentColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
                //g2.setColor(new Color(80, 80, 80, fadeFactor));
            } 
            else 
            {
                int fadeFactor = (20 - mRightShoulderFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 12;
                if (fadeFactor >= 216) 
                {
                    fadeFactor = 255;
                }
                currentColor = Color.rgb(80,80,80, (fadeFactor*100/255)/100f);
                //g2.setColor(new Color(80, 80, 80, fadeFactor));
            }
        }

        mArm.setStroke(currentColor);
        mArm.setStrokeWidth(3);
        mArm.setStrokeLineCap(StrokeLineCap.ROUND);
        mArm.setStrokeLineJoin(StrokeLineJoin.ROUND);
//        g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
//
//        g2.draw(mArm);
    }
}
