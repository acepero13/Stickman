/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.body;

import de.dfki.stickman.Stickman;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class LeftShoulder extends BodyPart {

	Body mBody;

	int mShoulderLength;
	Dimension mSize = new Dimension(mShoulderLength, mShoulderLength);

	Point mStart;
	Point mEnd;

	GeneralPath mShoulder;

	public LeftShoulder(Body body) {
		mBody = body;
                if(mBody.mNeck.mHead.mStickman.mType == Stickman.TYPE.FEMALE)
                    mShoulderLength = 15;
                else
                    mShoulderLength = 30;
		mDefaultRotation = -70;
		mRotation = mDefaultRotation;
		mToDegree = mDefaultRotation;
		mRotationStep = 0.0f;

		init();

		calculate(0);
	}

	public Point getLeftShoulderEndPosition() {
		return (mShoulder != null) ? new Point((int) mShoulder.getCurrentPoint().getX() + 1, (int) mShoulder.getCurrentPoint().getY()) : new Point(0, 0);
	}

	@Override
	public void calculate(int step) {
		mStart = mBody.getLeftArmStartPostion();
		mEnd = new Point(mStart.x, mStart.y + mShoulderLength);

		mShoulder = new GeneralPath();
		mShoulder.moveTo(mStart.x, mStart.y + 2);
		mShoulder.quadTo(mStart.x, (mStart.y + mEnd.y) / 2, mEnd.x, mEnd.y);

		AffineTransform t = new AffineTransform();
		t.rotate(Math.toRadians(mRotation), mStart.x, mStart.y);
		
		mShoulder.transform(t);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		//create();
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		if(mBody.mNeck.mHead.mStickman.mType == Stickman.TYPE.FEMALE) //Added by Beka
                {
                    //new Color(242, 227, 217, 200)
                    g2.setColor(new Color(242, 227, 217, 0));
                    
                }
                else
                {
                    g2.setColor(mBody.mMaleColor.darker());
                }
		
		if(mBody.mNeck.mHead.mStickman.setCharacterInvisible == true)
		{
			if(mBody.mNeck.mHead.mStickman.fadeControler==true)             //Added by Robbie
			{
				int fadeFactor = mBody.mNeck.mHead.mStickman.mMouth.mShapeAnimationStep*12;
				if(fadeFactor<=24) fadeFactor=0;
				g2.setColor(new Color(80, 80, 80,fadeFactor));
			}
			else
			{
				int fadeFactor = (20-mBody.mNeck.mHead.mStickman.mMouth.mShapeAnimationStep)*12;
				if(fadeFactor >= 216) fadeFactor=255;
				g2.setColor(new Color(80, 80, 80,fadeFactor));
			}
		}
		
		g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

		g2.draw(mShoulder);
	}
}
