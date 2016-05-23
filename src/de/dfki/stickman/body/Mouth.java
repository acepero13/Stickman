package de.dfki.stickman.body;

import de.dfki.stickman.Stickman;
import de.dfki.stickman.animationlogic.Animator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.geom.GeneralPath;

/**
 *
 * @author Patrick Gebhard
 *
 */
public class Mouth extends BodyPart {

	public static enum SHAPE {

		DEFAULT, SMILE, SAD, ANGRY, SURPRISED, HAPPY, DISGUSTED, CONTEMPT, EXCITED, EMBARRASSED, O, FEAR, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, ELEVEN, TWELVE, THIRTEEN, FOURTEEN,NINETEEN, TWENTY
	};

	Head mHead;

	public Mouth.SHAPE mShape = Mouth.SHAPE.DEFAULT;

	public Mouth(Head head) {
		mHead = head;
		mLength = 20;
		mSize = new Dimension(mLength * 2, 5);
		mDefaultRotationPoint = mHead.mDefaultRotationPoint;
		mColor = new Color(mHead.mStickman.mType == Stickman.TYPE.FEMALE ? 64 : 32, 0, 0, 128);

		init();
	}

	@Override
	public void setShape(String s) {
		Mouth.SHAPE shape = Mouth.SHAPE.valueOf(s);
		mShape = (shape != null) ? shape : Mouth.SHAPE.DEFAULT;
	}

	@Override
	public void resetShape() {
		mShape = Mouth.SHAPE.DEFAULT;
	}

	@Override
	public void createShape() {
//		mStart:middle
//		mEnd:right side
		mStart = mHead.getMouthPostion();
		mEnd = new Point(mStart.x + mLength / 2, mStart.y);

		double movement;

		clearDrawObjects();
		GeneralPath gp = new GeneralPath();

		switch (mShape) {
			case DEFAULT:
				gp.moveTo(mStart.x - mLength / 2, mStart.y);
				gp.quadTo(mStart.x, mStart.y + 1, mEnd.x, mEnd.y);
				break;

			case SMILE:
				movement = mLength / 2 + (Animator.sMAX_ANIM_STEPS - mShapeAnimationStep) / 3;

				gp.moveTo(mStart.x - mLength / 2 - movement, mStart.y - mLength / 2 - movement / 4 + 5);
				gp.quadTo(mStart.x, mStart.y + movement, mEnd.x + movement, mStart.y - mLength / 2 - movement / 4 + 5);
				break;

			case SAD:
				movement = mLength / 2 + (Animator.sMAX_ANIM_STEPS - mShapeAnimationStep) / 2;

				gp.moveTo(mStart.x - mLength / 2 - movement / 2, mStart.y - mLength / 2 + movement / 2);
				gp.quadTo(mStart.x, mStart.y - movement, mEnd.x + movement / 2, mStart.y - mLength / 2 + movement / 2);
				break;

			case ANGRY:
				gp.moveTo(mStart.x - mLength / 2, mStart.y);
				gp.quadTo(mStart.x, mStart.y - mLength / 2, mEnd.x, mStart.y);
				//gp.quadTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2, mStart.y);
				break;
			
			case SURPRISED:
				
//				First option
//				gp.moveTo(mStart.x - mLength / 2+2, mStart.y);
//				gp.quadTo(mStart.x, mStart.y - mLength / 2-6, mEnd.x-2, mStart.y);
//				gp.quadTo(mStart.x, mStart.y + mLength / 2+6, mStart.x - mLength / 2+2, mStart.y);
				
//				Second option
				gp.moveTo(mStart.x - mLength / 2, mStart.y);
				gp.quadTo(mStart.x-mLength / 4-4, mStart.y - mLength / 4-6, mStart.x, mStart.y - mLength / 2-2);
				gp.quadTo(mStart.x+mLength / 4+4, mStart.y - mLength / 4-6, mEnd.x, mStart.y);
				gp.quadTo(mStart.x+mLength / 4+4, mStart.y + mLength / 4+6, mStart.x, mStart.y + mLength / 2+2);
				gp.quadTo(mStart.x-mLength / 4-4, mStart.y + mLength / 4+6, mStart.x - mLength / 2, mStart.y);
				
				break;
				
			case HAPPY:
				movement = mLength / 2 + (Animator.sMAX_ANIM_STEPS - mShapeAnimationStep) / 3;

				gp.moveTo(mStart.x - mLength / 2 - movement+4, mStart.y - mLength / 2 - movement / 4 + 5);
				gp.quadTo(mStart.x, mStart.y + movement, mEnd.x + movement-4, mStart.y - mLength / 2 - movement / 4 + 5);
				gp.lineTo(mStart.x - mLength / 2 - movement+4, mStart.y - mLength / 2 - movement / 4 + 5);
				break;	
				
			case DISGUSTED:
				movement = mLength / 2 + (Animator.sMAX_ANIM_STEPS - mShapeAnimationStep) / 3;
				
//				First option
//				gp.moveTo(mStart.x-mLength, mStart.y);
//				gp.quadTo(mStart.x-mLength*4/5, mStart.y-10 , mStart.x-mLength*3/5, mStart.y);
//				gp.quadTo(mStart.x-mLength*2/5, mStart.y+10 , mStart.x-mLength/5, mStart.y);
//				gp.quadTo(mStart.x, mStart.y-10 ,mStart.x+mLength/5, mStart.y);
//				gp.quadTo(mStart.x+mLength*2/5, mStart.y+10 ,mStart.x+mLength*3/5, mEnd.y);
//				gp.quadTo(mStart.x+mLength*4/5, mStart.y-10 ,mStart.x+mLength, mEnd.y);
				
//				Second option
				gp.moveTo(mStart.x-mLength, mStart.y);
				gp.quadTo(mStart.x-mLength*2/3, mStart.y-6 , mStart.x-mLength/3, mStart.y);
				gp.quadTo(mStart.x, mStart.y+6 , mStart.x+mLength/3, mStart.y);
				gp.quadTo(mStart.x+mLength*2/3, mStart.y-6 ,mStart.x+mLength, mEnd.y);
				break;	
		
			case CONTEMPT:
				gp.moveTo(mStart.x - mLength / 2, mStart.y);
				
//				Fitst option
//				gp.quadTo(mStart.x, mStart.y + 1, mEnd.x+10, mEnd.y-10);
//				gp.quadTo(mStart.x, mStart.y + 7, mStart.x - mLength / 2, mStart.y);
					
//				Second option
//				gp.quadTo(mStart.x+5, mStart.y + 1, mEnd.x+10, mEnd.y-10);
//				gp.quadTo(mStart.x+15, mStart.y + 6, mStart.x - mLength / 2, mStart.y);
				
//				Third option
				gp.quadTo(mStart.x, mStart.y -15, mEnd.x+10, mEnd.y-10);
				
				break;	
				
			case FEAR:
				gp.moveTo(mStart.x - mLength / 2-5, mStart.y);
				gp.quadTo(mStart.x, mStart.y - 10, mEnd.x+5, mEnd.y);
				gp.quadTo(mStart.x, mStart.y -1, mStart.x - mLength / 2-5, mStart.y);
				break;	
				
			case EXCITED:
				movement = mLength / 2 + (Animator.sMAX_ANIM_STEPS - mShapeAnimationStep) / 3;

				gp.moveTo(mStart.x - mLength / 2 - movement, mStart.y - mLength / 2 - movement / 4 + 5);
				gp.quadTo(mStart.x, mStart.y + movement, mEnd.x + movement, mStart.y - mLength / 2 - movement / 4 + 5);
				gp.lineTo(mStart.x - mLength / 2 - movement, mStart.y - mLength / 2 - movement / 4 + 5);
				
//				teeth
				gp.moveTo(mStart.x - mLength / 2 - movement+15, mStart.y - mLength / 2 - movement / 4 + 5);
				gp.lineTo(mStart.x - mLength / 2 - movement+15, mStart.y - mLength / 2 - movement / 4 + 15);
				gp.moveTo(mStart.x - mLength / 2 - movement+25, mStart.y - mLength / 2 - movement / 4 + 5);
				gp.lineTo(mStart.x - mLength / 2 - movement+25, mStart.y - mLength / 2 - movement / 4 + 15);			
				gp.moveTo(mEnd.x + movement-15, mStart.y - mLength / 2 - movement / 4 + 5);
				gp.lineTo(mEnd.x + movement-15, mStart.y - mLength / 2 - movement / 4 + 15);				
				gp.moveTo(mStart.x - mLength / 2 - movement+8, mStart.y - mLength / 2 - movement / 4 + 11);
				gp.lineTo(mStart.x - mLength / 2 - movement+45, mStart.y - mLength / 2 - movement / 4 + 11);
				
				break;	
				
			case EMBARRASSED:
				gp.moveTo(mStart.x+8, mStart.y+1);
				gp.quadTo((mStart.x+8+mEnd.x+7)/2, mStart.y, mEnd.x+7, mEnd.y+1);
//				gp.lineTo(mEnd.x+7, mEnd.y+1);
				break;
				
			case O:
				gp.moveTo(mStart.x - mLength / 2, mStart.y);
				gp.quadTo(mStart.x, mStart.y - mLength / 2, mEnd.x, mStart.y);
				gp.quadTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2, mStart.y);
				break;
                                
            case ONE:
			case SIX:
			case FOURTEEN:
			case NINETEEN:
				gp.moveTo(mStart.x - mLength / 2, mStart.y);
				gp.quadTo(mStart.x, mStart.y - mLength / 5, mEnd.x, mStart.y);
				gp.quadTo(mStart.x, mStart.y + mLength / 5, mStart.x - mLength / 2, mStart.y);
				break;

			case TWO:
				gp.moveTo(mStart.x - mLength / 2.8, mStart.y);
				gp.quadTo(mStart.x, mStart.y - mLength / 1.6, mEnd.x - mLength / 6, mStart.y);
				gp.quadTo(mStart.x, mStart.y + mLength / 1.6, mStart.x - mLength / 2.8, mStart.y);
				break;


			case THREE:
			case TWENTY:
				gp.moveTo(mStart.x - mLength / 2.8, mStart.y);
				gp.quadTo(mStart.x, mStart.y - mLength / 2.5, mEnd.x - mLength / 6, mStart.y);
				gp.quadTo(mStart.x, mStart.y + mLength / 2.5, mStart.x - mLength / 2.8, mStart.y);
				break;

			case FOUR:
				gp.moveTo(mStart.x - mLength / 2, mStart.y);
				gp.quadTo(mStart.x, mStart.y - 3, mEnd.x, mStart.y);
				gp.quadTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2, mStart.y);
				break;



			case FIVE:
			case EIGHT:
				gp.moveTo(mStart.x - mLength / 2.8, mStart.y);
				gp.quadTo(mStart.x, mStart.y - mLength / 2, mEnd.x - mLength / 6, mStart.y);
				gp.quadTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2.8, mStart.y);
				break;

			case SEVEN:
				gp.moveTo(mStart.x - mLength / 3, mStart.y);
				gp.quadTo(mStart.x, mStart.y -  3, mEnd.x - mLength / 5, mStart.y);
				gp.quadTo(mStart.x, mStart.y + 3, mStart.x - mLength / 3, mStart.y);
				break;


			case NINE:
				gp.moveTo(mStart.x - mLength / 3, mStart.y);
				gp.quadTo(mStart.x, mStart.y - mLength / 2.8, mEnd.x - mLength / 5, mStart.y);
				gp.quadTo(mStart.x, mStart.y + mLength / 1.6, mStart.x - mLength / 3, mStart.y);
				break;

			case TEN:
				gp.moveTo(mStart.x - mLength / 2.8, mStart.y);
				gp.quadTo(mStart.x, mStart.y - mLength / 2.8, mEnd.x - mLength / 6, mStart.y);
				gp.quadTo(mStart.x, mStart.y + mLength / 2, mStart.x - mLength / 2.8, mStart.y);
				break;

		
		}

		addToDrawObjects(gp);
	}
}