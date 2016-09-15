/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickmanfx.bodyfx;

import de.dfki.stickman.body.*;
import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimatorFX;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import java.net.URL;

import com.interactivemesh.jfx.importer.col.ColModelImporter;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

/**
 *
 * @author Beka
 *
 */
public class LeftForeLegFX extends BodyPartFX {

    LeftUpperLegFX mUpperLegFX;
    int mLegLength;
    Dimension mSize = new Dimension(10, mLegLength);
    
	Group leftForeLeg;

    public LeftForeLegFX(LeftUpperLegFX leftUpperLegFX) 
    {
    	mUpperLegFX = leftUpperLegFX;
        mDefaultRotation = -2;
		mRotation = mDefaultRotation;
		mToDegree = mDefaultRotation;
		mColor = Color.rgb(80, 80, 80);
		
		leftForeLeg = (Group) mUpperLegFX.lefttUpperLeg.getChildren().get(2);

        init();
        
        calculate(0);
    }
    
    public void calculate(int step)
    {
		Rotate rx = new Rotate(mRotation, Rotate.X_AXIS);
		Rotate ry = new Rotate(mYRotation, Rotate.Y_AXIS);
		Rotate rz = new Rotate(mZRotation, Rotate.Z_AXIS);
		
		Translate translate = (Translate) leftForeLeg.getTransforms().get(0);
		Scale scale = (Scale) leftForeLeg.getTransforms().get(4);
		leftForeLeg.getTransforms().clear();
		leftForeLeg.getTransforms().addAll(translate, rx, ry, rz, scale);

//    	this.update();
    }
    
    @Override
	public void update() 
	{
    	if (mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == false) 
    		mColorRecorder = mColor;
    	if (mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.setCharacterInvisible == true) 
        {
            if (mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.fadeControler == true) //Added by Robbie
            {
                int fadeFactor = mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep * 12;
                if (fadeFactor <= 24) 
                {
                    fadeFactor = 0;
                }
                mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                //mColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
            } 
            else 
            {
                int fadeFactor = (20 - mUpperLegFX.mBodyFX.mNeckFX.mHeadFX.mStickmanFX.mMouthFX.mShapeAnimationStep) * 12;
                if (fadeFactor >= 216) 
                {
                	mColor = mColorRecorder;
                }
                else
                	mColor = new Color(mColor.getRed(), mColor.getGreen(), mColor.getBlue(), (fadeFactor * 100 / 255) / 100f);
                //mColor = Color.rgb(80, 80, 80, (fadeFactor*100/255)/100f);
            }
        }
    	
	}
}
