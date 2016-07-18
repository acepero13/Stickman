/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dfki.stickman.body;

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
 * @author Beka Aptsiauri
 *
 */
public class RightForeLeg extends BodyPart {

	RightUpperLeg mUpperLeg;
	int mLegLength = 90;
	Dimension mSize = new Dimension(10, mLegLength);

	Point mStart;
	Point mEnd;

	GeneralPath mLeg;

	public RightForeLeg(RightUpperLeg leg) {
		mUpperLeg = leg;

		mDefaultRotation = -2;
		mRotation = mDefaultRotation;
		mToDegree = mDefaultRotation;

		init();

		calculate(0);
	}

	public Point getLegStartPosition() 
        {
		return (mLeg != null) ? new Point((int) mLeg.getCurrentPoint().getX(), (int) mLeg.getCurrentPoint().getY()) : new Point(0, 0);
	}

	@Override
	public void calculate(int step) {
		mStart = mUpperLeg.getRightUpperLegEndPosition();
		mEnd = new Point(mStart.x, mStart.y + mLegLength);

		mLeg = new GeneralPath();
		mLeg.moveTo(mStart.x, mStart.y + 2);
		mLeg.quadTo(mStart.x - 2, (mStart.y + mEnd.y) / 2, mEnd.x, mEnd.y);

		AffineTransform t = new AffineTransform();
		t.rotate(Math.toRadians(mRotation), mStart.x, mStart.y);
		mLeg.transform(t);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// draw outlines
		g2.setColor(new Color(80, 80, 80));
		
		if(mUpperLeg.mBody.mNeck.mHead.mStickman.setCharacterInvisible == true)
		{
			if(mUpperLeg.mBody.mNeck.mHead.mStickman.fadeControler==true)             //Added by Robbie
			{
				int fadeFactor = mUpperLeg.mBody.mNeck.mHead.mStickman.mMouth.mShapeAnimationStep*12;
				if(fadeFactor<=24) fadeFactor=0;
				g2.setColor(new Color(80, 80, 80,fadeFactor));
			}
			else
			{
				int fadeFactor = (20-mUpperLeg.mBody.mNeck.mHead.mStickman.mMouth.mShapeAnimationStep)*12;
				if(fadeFactor >= 216) fadeFactor=255;
				g2.setColor(new Color(80, 80, 80,fadeFactor));
			}
		}
	
		g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));

		g2.draw(mLeg);
	}
}