package de.dfki.stickman.body;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animator;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.GeneralPath;
import static de.dfki.stickman.animationlogic.util.Interpolator.linear;
import java.awt.BasicStroke;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class LeftEye extends BodyPart {

	public static enum SHAPE {

		DEFAULT, BLINK, LOOKLEFT, LOOKRIGHT, ANGRY, SURPRISED, HAPPY, DISGUSTED, LOVED, CONTEMPT, EXCITED, EMBARRASSED
	};

	Head mHead;
	int adjustFactor = 3; // Used to adjust the movement of the eye
	public LeftEye.SHAPE mShape = LeftEye.SHAPE.DEFAULT;

	public LeftEye(Head head) {
		mHead = head;
		mLength = 5;
		mDefaultRotationPoint = mHead.mDefaultRotationPoint;
		mColor = new Color(mHead.mStickman.mType == Stickman.TYPE.FEMALE ? 22 : 0,
		  mHead.mStickman.mType == Stickman.TYPE.FEMALE ? 40 : 0,
		  mHead.mStickman.mType == Stickman.TYPE.FEMALE ? 65 : 0, 144);
		mStroke = new BasicStroke(2.5f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);

		init();
	}

	@Override
	public void setShape(String s) {
		SHAPE shape = SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = LeftEye.SHAPE.DEFAULT;
	}

	@Override
	public void createShape() {
//		mStart: right side
//		mEnd:left side
		mStart = mHead.getLeftEyePostion();
		mEnd = new Point(mStart.x - mLength, mStart.y);

		double movement;
		
		clearDrawObjects();
		GeneralPath gp = new GeneralPath();

		switch (mShape) {
			case DEFAULT:
				gp = new GeneralPath();
				gp.moveTo(mStart.x, mStart.y);
				gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x, mEnd.y);
				break;

			case BLINK:
				gp = new GeneralPath();
				gp.moveTo(mStart.x, mStart.y);
				gp.lineTo(mEnd.x, mEnd.y);
				break;
				
			case LOOKLEFT:
				gp = new GeneralPath();
				gp.moveTo(mStart.x, mStart.y);
				gp.quadTo(linear((mStart.x + mEnd.x) / 2, mStart.x, mShapeAnimationStep), mStart.y - 3, mEnd.x, mEnd.y);
				break;
				
			case LOOKRIGHT:
				gp = new GeneralPath();
				gp.moveTo(mStart.x, mStart.y);
				gp.quadTo(linear((mStart.x + mEnd.x) / 2, mEnd.x, mShapeAnimationStep), mStart.y - 3, mEnd.x, mEnd.y);
				break;
				
			case ANGRY:
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;
				
				gp.moveTo(mStart.x - movement/10, mStart.y);
				gp.quadTo((mStart.x - movement/10 + mEnd.x - movement/8) / 2, mStart.y - movement/6, mEnd.x - movement/8, mEnd.y);
				gp.quadTo((mStart.x - movement/10 + mEnd.x - movement/8) / 2, mStart.y + movement/6, mStart.x - movement/10, mStart.y);

				break;
			
			case SURPRISED:
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;
				
				gp.moveTo(mStart.x + movement/10, mStart.y);
				gp.quadTo((mStart.x + movement/10 + mEnd.x-movement/10)/2, mStart.y - movement/2, mEnd.x-movement/10, mStart.y);
				gp.quadTo((mStart.x + movement/10 + mEnd.x-movement/10)/2, mStart.y + movement/2, mStart.x+movement/10, mStart.y);
				break;
				
			case HAPPY:
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;
								
				gp.moveTo(mStart.x + movement/10, mStart.y);
				gp.quadTo((mStart.x + movement/10 + mEnd.x - movement/10)/2, mStart.y - 3, mEnd.x - movement/10, mEnd.y);
				break;	
				
			case DISGUSTED:
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;
				
				gp.moveTo(mStart.x + movement/4, mStart.y - movement/4);
				gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement/8, mEnd.x - movement/8, mEnd.y + movement/8);
				gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3 + movement/4, mStart.x + movement/4, mStart.y + movement/8);				
				break;
			
			case LOVED:
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;
				
				double xMovement = movement/10*6;
				double yMovement1 = movement/10*6;
				double yMovement2 = movement/10*3;
				
				gp.moveTo(mStart.x, mStart.y);
				gp.quadTo(mStart.x - xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1);
				gp.moveTo(mStart.x, mStart.y);
				gp.quadTo(mStart.x + xMovement, mEnd.y - yMovement2, mStart.x, mEnd.y + yMovement1);
				break;		
				
			case CONTEMPT:
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;
				
				gp.moveTo(mStart.x, mStart.y);
				gp.quadTo((mStart.x + mEnd.x)/2, mStart.y - movement/10, mEnd.x, mStart.y);
				gp.quadTo((mStart.x + mEnd.x)/2, mStart.y + movement/10, mStart.x, mStart.y);
				break;
				
			case EXCITED:
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;
				
				gp.moveTo(mStart.x + movement/10, mStart.y);
				gp.quadTo((mStart.x + mEnd.x) / 2, mStart.y - 3, mEnd.x - movement/10, mEnd.y);
				break;
				
			case EMBARRASSED:
				movement = Animator.sMAX_ANIM_STEPS - mShapeAnimationStep;
				
				gp.moveTo(mStart.x + movement/2, mStart.y + movement/5*2);
				gp.quadTo((mStart.x + movement/2 + mEnd.x + movement/2) / 2, mStart.y - 4 + movement/2, mEnd.x + movement/2, mEnd.y + movement/5*2);			
				break;
				
		}

		addToDrawObjects(gp);
	}
}
