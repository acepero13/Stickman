package de.dfki.stickmanfx;

import de.dfki.action.sequence.WordTimeMarkSequence;
import de.dfki.stickman.animationlogic.listener.AnimationListener;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.logging.ConsoleHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import de.dfki.stickmanfx.animation.environmentfx.IdleBehavior;
import de.dfki.stickmanfx.animation.environmentfx.SimplexNoise;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import de.dfki.stickmanfx.animationlogic.AnimationLoaderFX;
import de.dfki.stickmanfx.animationlogic.AnimationSchedulerFX;
import de.dfki.stickmanfx.animationlogic.EventAnimationFX;
import de.dfki.stickmanfx.bodyfx.BodyFX;
import de.dfki.stickmanfx.bodyfx.BombeFX;
import de.dfki.stickmanfx.bodyfx.FaceWrinkleFX;
import de.dfki.stickmanfx.bodyfx.FemaleHairFX;
import de.dfki.stickmanfx.bodyfx.HeadFX;
import de.dfki.stickmanfx.bodyfx.LeftEyeFX;
import de.dfki.stickmanfx.bodyfx.LeftEyebrowFX;
import de.dfki.stickmanfx.bodyfx.LeftFinger1;
import de.dfki.stickmanfx.bodyfx.LeftFinger2;
import de.dfki.stickmanfx.bodyfx.LeftFinger3;
import de.dfki.stickmanfx.bodyfx.LeftFinger4;
import de.dfki.stickmanfx.bodyfx.LeftFinger5;
import de.dfki.stickmanfx.bodyfx.LeftFootFX;
import de.dfki.stickmanfx.bodyfx.LeftForeArmFX;
import de.dfki.stickmanfx.bodyfx.LeftForeLegFX;
import de.dfki.stickmanfx.bodyfx.LeftShoulderFX;
import de.dfki.stickmanfx.bodyfx.LeftUpperArmFX;
import de.dfki.stickmanfx.bodyfx.LeftUpperLegFX;
import de.dfki.stickmanfx.bodyfx.LeftWrist;
import de.dfki.stickmanfx.bodyfx.MaleHairFX;
import de.dfki.stickmanfx.bodyfx.MouthFX;
import de.dfki.stickmanfx.bodyfx.NeckFX;
import de.dfki.stickmanfx.bodyfx.RightEyeFX;
import de.dfki.stickmanfx.bodyfx.RightEyebrowFX;
import de.dfki.stickmanfx.bodyfx.RightFinger1;
import de.dfki.stickmanfx.bodyfx.RightFinger2;
import de.dfki.stickmanfx.bodyfx.RightFinger3;
import de.dfki.stickmanfx.bodyfx.RightFinger4;
import de.dfki.stickmanfx.bodyfx.RightFinger5;
import de.dfki.stickmanfx.bodyfx.RightFootFX;
import de.dfki.stickmanfx.bodyfx.RightForeArmFX;
import de.dfki.stickmanfx.bodyfx.RightForeLegFX;
import de.dfki.stickmanfx.bodyfx.RightShoulderFX;
import de.dfki.stickmanfx.bodyfx.RightUpperArmFX;
import de.dfki.stickmanfx.bodyfx.RightUpperLegFX;
import de.dfki.stickmanfx.bodyfx.RightWrist;
import de.dfki.stickmanfx.bodyfx.StarsFX;
import de.dfki.stickmanfx.bodyfx.ThinkFX;
import de.dfki.stickmanfx.environmentfx.SpeechBubbleFX;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;

/**
 *
 * @author Beka Aptsiauri
 *
 *         This work is inspired by the stickmans drawn by Sarah Johnson
 *         (www.sarah-johnson.com) in the Valentine music video from Kina
 *         Grannis shot by Ross Ching in 2012
 *
 */
public class StickmanFX extends Pane {
	// general stuff
	public static enum ORIENTATION {
		FRONT, LEFT, RIGHT
	};

	public static enum TYPE {
		FEMALE, MALE
	};

	static public final Color sFOREGROUND = Color.rgb(188, 188, 188, (128 * 100 / 255) / 100f);
	public TYPE mType = TYPE.FEMALE;
	public String mName = "Stickman";
	public ORIENTATION mOrientation = ORIENTATION.FRONT;
	public float mScale = 1.0f;
	public boolean mShowBackground = true;
	public boolean mShowStage = true;
	public boolean mShowName = true;
	public float mGeneralXTranslation = 0;
	public float mGeneralYTranslation = 0;
	private Label nameLabel = new Label();

	// public static Dimension mDefaultSize = new Dimension(400, 400); // 400
	public static Dimension mDefaultSize = new Dimension(300, 800); // 400
	public static Dimension mSize = new Dimension(mDefaultSize);
	FontMetrics mFontMetrics;
	Font mFont;

	public double leaveSpeed = 0; // Added by Robbie, to control the speed of
									// leaving
	public boolean starShowControler = false; // Added by Robbie, to control the
												// star appear or not
	public boolean starShowC = false; // Added by Robbie, star with character
										// appear at the same time or not
	public boolean fadeControler = false; // Added by Robbie, to control the
											// character to fade out or fade in.
											// true: Fade out
	public boolean setCharacterInvisible = false; // Added by Robbie, to control
													// the character to fade
													// out.
	// True: visible False:invisible
	public double mWobble = 0;
	public Boolean mIdleRun = false; // the shared variable to decide the while
										// loop in IdleBehavior break or not
//	public IdleBehavior mIdleBehavior;
//	public SimplexNoise simplexNoise; // Perlin noise

	// amimation stuff
	public Semaphore mAnimationLaunchControl = new Semaphore(1);
	public AnimationSchedulerFX mAnimationSchedulerFX;
	private final List<AnimationListener> mAnimationListeners = new CopyOnWriteArrayList<AnimationListener>();

	// body parts
	public HeadFX mHeadFX;
	public MaleHairFX mMaleHairFX;
	public FemaleHairFX mFemaleHairFX;
	public LeftEyebrowFX mLeftEyebrowFX;
	public LeftEyeFX mLeftEyeFX;
	public RightEyebrowFX mRightEyebrowFX;
	public RightEyeFX mRightEyeFX;
	public MouthFX mMouthFX;
	public NeckFX mNeckFX;
	public FaceWrinkleFX mFaceWrinkleFX; // added by Robbie FaceWrinkle
	public BodyFX mBodyFX;
	public LeftShoulderFX mLeftShoulderFX;
	public LeftUpperArmFX mLeftUpperArmFX;
	public LeftForeArmFX mLeftForeArmFX;
	public LeftWrist mLeftWrist;
	public LeftFinger1 mLeftFinger1;
	public LeftFinger2 mLeftFinger2;
	public LeftFinger3 mLeftFinger3;
	public LeftFinger4 mLeftFinger4;
	public LeftFinger5 mLeftFinger5;
	
	public RightShoulderFX mRightShoulderFX;
	public RightUpperArmFX mRightUpperArmFX;
	public RightForeArmFX mRightForeArmFX;
	public RightWrist mRightWrist;
	public RightFinger1 mRightFinger1;
	public RightFinger2 mRightFinger2;
	public RightFinger3 mRightFinger3;
	public RightFinger4 mRightFinger4;
	public RightFinger5 mRightFinger5;
	
	// public LeftLegFX mLeftLegFX;
	public LeftUpperLegFX mLeftUpperLegFX;
	public LeftForeLegFX mLeftForeLegFX;
	public LeftFootFX mLeftFootFX;
	public StarsFX mStarsFX; // added by Robbie Create Say bye or hi
	// public RightLegFX mRightLegFX;
	public RightUpperLegFX mRightUpperLegFX;
	public RightForeLegFX mRightForeLegFX;
	public RightFootFX mRightFootFX;
	public ThinkFX mThinkFX;
	public BombeFX mBombeFX;
	// environment
	public SpeechBubbleFX mSpeechBubbleFX;

	// logging
	public final Logger mLogger = Logger.getAnonymousLogger();
	// id
	private long mID = 0;

	public StickmanFX(String name, TYPE gender, float scale, Dimension size) {
		mSize = size;
		mScale = scale;

		mName = name;
		mType = gender;

		mHeadFX = new HeadFX(this);
		mMaleHairFX = new MaleHairFX(this);
		mFemaleHairFX = new FemaleHairFX(this);
		mLeftEyebrowFX = new LeftEyebrowFX(mHeadFX);
		mLeftEyeFX = new LeftEyeFX(mHeadFX);
		mRightEyebrowFX = new RightEyebrowFX(mHeadFX);
		mRightEyeFX = new RightEyeFX(mHeadFX);
		mMouthFX = new MouthFX(mHeadFX);
		mFaceWrinkleFX = new FaceWrinkleFX(mHeadFX); /// added by Robbie
		mNeckFX = new NeckFX(mHeadFX);
		mBodyFX = new BodyFX(mNeckFX);
		mLeftShoulderFX = new LeftShoulderFX(mBodyFX);
		mLeftUpperArmFX = new LeftUpperArmFX(mBodyFX);
		mLeftForeArmFX = new LeftForeArmFX(mLeftUpperArmFX);
		mLeftWrist = new LeftWrist(mLeftForeArmFX);
		mLeftFinger1 = new LeftFinger1(mLeftWrist);
		mLeftFinger2 = new LeftFinger2(mLeftWrist);
		mLeftFinger3 = new LeftFinger3(mLeftWrist);
		mLeftFinger4 = new LeftFinger4(mLeftWrist);
		mLeftFinger5 = new LeftFinger5(mLeftWrist);
		
		mRightShoulderFX = new RightShoulderFX(mBodyFX);
		mRightUpperArmFX = new RightUpperArmFX(mBodyFX);
		mRightForeArmFX = new RightForeArmFX(mRightUpperArmFX);
		mRightWrist = new RightWrist(mRightForeArmFX);
		mRightFinger1 = new RightFinger1(mRightWrist);
		mRightFinger2 = new RightFinger2(mRightWrist);
		mRightFinger3 = new RightFinger3(mRightWrist);
		mRightFinger4 = new RightFinger4(mRightWrist);
		mRightFinger5 = new RightFinger5(mRightWrist);
		
		// mLeftLegFX = new LeftLegFX(mBodyFX);
		mLeftUpperLegFX = new LeftUpperLegFX(mBodyFX);
		mLeftForeLegFX = new LeftForeLegFX(mLeftUpperLegFX);
		mLeftFootFX = new LeftFootFX(mLeftForeLegFX);
		mStarsFX = new StarsFX(mBodyFX); /// added by Robbie
		// mRightLegFX = new RightLegFX(mBodyFX);
		mRightUpperLegFX = new RightUpperLegFX(mBodyFX);
		mRightForeLegFX = new RightForeLegFX(mRightUpperLegFX);
		mRightFootFX = new RightFootFX(mRightForeLegFX);
		mThinkFX = new ThinkFX(mHeadFX);
		mBombeFX = new BombeFX(mHeadFX);

		mSpeechBubbleFX = new SpeechBubbleFX(mHeadFX);
		init();
		this.addAllParts();
		update();
	}

	public StickmanFX(String name, TYPE gender, float scale) {
		mScale = scale;

		mName = name;
		mType = gender;

		mHeadFX = new HeadFX(this);
		mMaleHairFX = new MaleHairFX(this);
		mFemaleHairFX = new FemaleHairFX(this);
		mLeftEyebrowFX = new LeftEyebrowFX(mHeadFX);
		mLeftEyeFX = new LeftEyeFX(mHeadFX);
		mRightEyebrowFX = new RightEyebrowFX(mHeadFX);
		mRightEyeFX = new RightEyeFX(mHeadFX);
		mMouthFX = new MouthFX(mHeadFX);
		mFaceWrinkleFX = new FaceWrinkleFX(mHeadFX); /// added by Robbie
		mNeckFX = new NeckFX(mHeadFX);
		mBodyFX = new BodyFX(mNeckFX);
		mLeftShoulderFX = new LeftShoulderFX(mBodyFX);
		mLeftUpperArmFX = new LeftUpperArmFX(mBodyFX);
		mLeftForeArmFX = new LeftForeArmFX(mLeftUpperArmFX);
		mLeftWrist = new LeftWrist(mLeftForeArmFX);
		mLeftFinger1 = new LeftFinger1(mLeftWrist);
		mLeftFinger2 = new LeftFinger2(mLeftWrist);
		mLeftFinger3 = new LeftFinger3(mLeftWrist);
		mLeftFinger4 = new LeftFinger4(mLeftWrist);
		mLeftFinger5 = new LeftFinger5(mLeftWrist);
		
		mRightShoulderFX = new RightShoulderFX(mBodyFX);
		mRightUpperArmFX = new RightUpperArmFX(mBodyFX);
		mRightForeArmFX = new RightForeArmFX(mRightUpperArmFX);
		mRightWrist = new RightWrist(mRightForeArmFX);
		mRightFinger1 = new RightFinger1(mRightWrist);
		mRightFinger2 = new RightFinger2(mRightWrist);
		mRightFinger3 = new RightFinger3(mRightWrist);
		mRightFinger4 = new RightFinger4(mRightWrist);
		mRightFinger5 = new RightFinger5(mRightWrist);
		
		// mLeftLegFX = new LeftLegFX(mBodyFX);
		mLeftUpperLegFX = new LeftUpperLegFX(mBodyFX);
		mLeftForeLegFX = new LeftForeLegFX(mLeftUpperLegFX);
		mLeftFootFX = new LeftFootFX(mLeftForeLegFX);
		mStarsFX = new StarsFX(mBodyFX); /// added by Robbie
		// mRightLegFX = new RightLegFX(mBodyFX);
		mRightUpperLegFX = new RightUpperLegFX(mBodyFX);
		mRightForeLegFX = new RightForeLegFX(mRightUpperLegFX);
		mRightFootFX = new RightFootFX(mRightForeLegFX);
		mThinkFX = new ThinkFX(mHeadFX);
		mBombeFX = new BombeFX(mHeadFX);

		mSpeechBubbleFX = new SpeechBubbleFX(mHeadFX);
		init();
		this.addAllParts();
		update();
	}

	public StickmanFX(String name, TYPE gender) {
		mName = name;
		mType = gender;

		mHeadFX = new HeadFX(this);
		mMaleHairFX = new MaleHairFX(this);
		mFemaleHairFX = new FemaleHairFX(this);
		mLeftEyebrowFX = new LeftEyebrowFX(mHeadFX);
		mLeftEyeFX = new LeftEyeFX(mHeadFX);
		mRightEyebrowFX = new RightEyebrowFX(mHeadFX);
		mRightEyeFX = new RightEyeFX(mHeadFX);
		mMouthFX = new MouthFX(mHeadFX);
		mFaceWrinkleFX = new FaceWrinkleFX(mHeadFX); /// added by Robbie
		mNeckFX = new NeckFX(mHeadFX);
		mBodyFX = new BodyFX(mNeckFX);
		mLeftShoulderFX = new LeftShoulderFX(mBodyFX);
		mLeftUpperArmFX = new LeftUpperArmFX(mBodyFX);
		mLeftForeArmFX = new LeftForeArmFX(mLeftUpperArmFX);
		mLeftWrist = new LeftWrist(mLeftForeArmFX);
		mLeftFinger1 = new LeftFinger1(mLeftWrist);
		mLeftFinger2 = new LeftFinger2(mLeftWrist);
		mLeftFinger3 = new LeftFinger3(mLeftWrist);
		mLeftFinger4 = new LeftFinger4(mLeftWrist);
		mLeftFinger5 = new LeftFinger5(mLeftWrist);
		
		mRightShoulderFX = new RightShoulderFX(mBodyFX);
		mRightUpperArmFX = new RightUpperArmFX(mBodyFX);
		mRightForeArmFX = new RightForeArmFX(mRightUpperArmFX);
		mRightWrist = new RightWrist(mRightForeArmFX);
		mRightFinger1 = new RightFinger1(mRightWrist);
		mRightFinger2 = new RightFinger2(mRightWrist);
		mRightFinger3 = new RightFinger3(mRightWrist);
		mRightFinger4 = new RightFinger4(mRightWrist);
		mRightFinger5 = new RightFinger5(mRightWrist);
		
		// mLeftLegFX = new LeftLegFX(mBodyFX);
		mLeftUpperLegFX = new LeftUpperLegFX(mBodyFX);
		mLeftForeLegFX = new LeftForeLegFX(mLeftUpperLegFX);
		mLeftFootFX = new LeftFootFX(mLeftForeLegFX);
		mStarsFX = new StarsFX(mBodyFX); /// added by Robbie
		// mRightLegFX = new RightLegFX(mBodyFX);
		mRightUpperLegFX = new RightUpperLegFX(mBodyFX);
		mRightForeLegFX = new RightForeLegFX(mRightUpperLegFX);
		mRightFootFX = new RightFootFX(mRightForeLegFX);
		mThinkFX = new ThinkFX(mHeadFX);
		mBombeFX = new BombeFX(mHeadFX);

		mSpeechBubbleFX = new SpeechBubbleFX(mHeadFX);
		init();
		this.addAllParts();
		update();
	}

	private void init() {
		this.setPrefHeight(mSize.height);
		this.setPrefWidth(mSize.width);
		this.setMinHeight(mSize.height);
		this.setMinWidth(mSize.width);
		// this.setStyle("-fx-border-color: black");

		// font stuff
		Map<TextAttribute, Object> map = new HashMap<>();
		map.put(TextAttribute.KERNING, TextAttribute.KERNING_ON);
		map.put(TextAttribute.FAMILY, Font.SANS_SERIF);
		// map.put(TextAttribute.POSTURE, TextAttribute.POSTURE_OBLIQUE);
		map.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_DEMIBOLD);
		map.put(TextAttribute.SIZE, 14);

		// mFont = Font.getFont(map);
		// mFontMetrics = getFontMetrics(mFont);
		// setFont(mFont);

		ConsoleHandler ch = new ConsoleHandler();
		ch.setFormatter(new StickmanLogFormatter());

		mLogger.addHandler(ch);
		mLogger.setUseParentHandlers(false);

		mAnimationSchedulerFX = new AnimationSchedulerFX(this);
		mAnimationSchedulerFX.start();

//		simplexNoise = new SimplexNoise(8, 0.1, (int) (Math.random() * 100));
//		mIdleBehavior = new IdleBehavior(this, simplexNoise);
		
		if(mShowName)
		{
//			nameLabel.toFront();
//			nameLabel.setTranslateY(mRightForeLegFX.getLegStartPosition().getY()*21/20);
			nameLabel.setText(mName);
		}
	
	}

	public void addListener(AnimationListener al) {
		mAnimationListeners.add(al);
	}

	public void removeListener(AnimationListener al) {
		synchronized (mAnimationListeners) {
			if (mAnimationListeners.contains(al)) {
				mAnimationListeners.remove(al);
			}
		}
	}

	public void notifyListeners(String animationId) {
		synchronized (mAnimationListeners) {
			mAnimationListeners.stream().forEach((al) -> {
				al.update(animationId);
			});
		}
	}

	public String getID() {
		return (new StringBuffer()).append(mName).append(" Animation ").append(mID++).toString();
	}

	// @Override
	// public String getName() {
	// return mName;
	// }

	// Sets the orientation of the character, allowed values are: LEFT, RIGHT,
	// FRONT
	public void setOrientation(String orientation) {
		if (orientation.equalsIgnoreCase(ORIENTATION.LEFT.toString())) {
			mOrientation = ORIENTATION.LEFT;
		} else if (orientation.equalsIgnoreCase(ORIENTATION.RIGHT.toString())) {
			mOrientation = ORIENTATION.RIGHT;
		} else {
			mOrientation = ORIENTATION.FRONT;
		}
	}

	public AnimationFX doEventFeedbackAnimation(String name, int duration, WordTimeMarkSequence wts, boolean block) {
		EventAnimationFX a = AnimationLoaderFX.getInstance().loadEventAnimation(this, name, duration, block);

		a.setParameter(wts);

		try {
			mAnimationLaunchControl.acquire();
			a.start();
		} catch (InterruptedException ex) {
			mLogger.severe(ex.getMessage());
		}

		return a;
	}

	public AnimationFX doAnimation(String name, int duration, boolean block) {
		return doAnimation(name, duration, "", block);
	}

	public AnimationFX doAnimation(String name, Object param, boolean block) {
		return doAnimation(name, -1, param, block);
	}

	public AnimationFX doAnimation(String name, boolean block) {
		return doAnimation(name, -1, "", block);
	}

	public AnimationFX doAnimation(String name, int duration, Object param, boolean block) {
		AnimationFX a = AnimationLoaderFX.getInstance().loadAnimation(this, name, duration, block);

		a.setParameter(param); // this is for now only used by the Speech Bubble

		try {
			mAnimationLaunchControl.acquire();
			// Platform.runLater(() ->
			// a.start());/////////////////////////////////////////////////
			a.start();
		} catch (InterruptedException ex) {
			mLogger.severe(ex.getMessage());
		}

		return a;
	}

	public void playAnimation(AnimationFX a) {
		try {
			mAnimationLaunchControl.acquire();
			a.start();
		} catch (InterruptedException ex) {
			mLogger.severe(ex.getMessage());
		}
	}

	// Control IdleBehavior start(mStart == true) or not(mStart == false).

	private static boolean isAnimationTimerStartet = false;

	public void update() {
		Color currColor = sFOREGROUND;
		int width = new Float(mSize.width).intValue();
		int height = new Float(mSize.height).intValue();

		// draw everthing in the middle and scaled
		Affine af = new Affine();
		mGeneralXTranslation = mSize.width / 2 - mHeadFX.mSize.width * mScale;
		// mGeneralYTranslation = (float)
		// (Screen.getPrimary().getVisualBounds().getHeight() - 477 * mScale);
		// mGeneralYTranslation = (float)
		// (Screen.getPrimary().getVisualBounds().getHeight() - 700 * mScale);
		// change Screen.getPrimary().getVisualBounds().getHeight() to
		// mSize.height to avoid the location changed after update. by Robbie
		mGeneralYTranslation = (float) (mSize.height - 700 * mScale);

		af.appendTranslation(mGeneralXTranslation, mGeneralYTranslation);
		af.appendScale(mScale, mScale);
		af.appendTranslation(0, leaveSpeed); // Added by Robbie, GoDown
		this.getTransforms().clear();
		this.getTransforms().add(af);

		// Out put perlin noise
//		implimentPerlinNoise(mWobble, (mBodyFX.getRightLegStartPostion().x + mBodyFX.getLeftLegStartPostion().x) / 2,
//				mBodyFX.getRightLegStartPostion().y + mLeftUpperLegFX.mLength + mLeftForeLegFX.mLength);

		updateAll();
	}

	private static class StickmanLogFormatter extends Formatter {

		@Override
		public String format(LogRecord record) {
			return ((new StringBuffer()).append(record.getLevel()).append(": ").append(record.getMessage())
					.append("\n")).toString();
		}
	}

	private void addAllParts() {
	
		this.getChildren().addAll(mNeckFX, mHeadFX,
				mBodyFX, mLeftShoulderFX, /*mLeftUpperArmFX, mLeftForeArmFX, mLeftHandFX,*/ mRightShoulderFX,
				mRightUpperArmFX, /*mRightForeArmFX, mRightHandFX, /* mLeftLegFX, */ mLeftUpperLegFX, mLeftForeLegFX,
				mLeftFootFX, /* mRightLegFX, */ mRightUpperLegFX, mRightForeLegFX, mRightFootFX, mFaceWrinkleFX,
				mStarsFX, mSpeechBubbleFX, mThinkFX, mBombeFX ,nameLabel);
		
	}

	private void updateAll() {
		// draw body parts
		if (starShowControler == true) {
			mStarsFX.update(); // Added by Robbie, to show stars or words here.
		} else {
			if (starShowC == true)
				mStarsFX.update();
//			mHeadFX.update();

//			if (this.mType == StickmanFX.TYPE.MALE)
//				mMaleHairFX.update();
//			else
//				mFemaleHairFX.update();
//			mLeftEyebrowFX.update();
//			mLeftEyeFX.update();
//			mRightEyebrowFX.update();
//			mFaceWrinkleFX.update(); // added by Robbie
//			mRightEyeFX.update();
//			mMouthFX.update();
//			mNeckFX.update();
			// BodyFX is not BodyPartFX Classe
//			mBodyFX.update();
//			mLeftShoulderFX.update();
//			mLeftUpperArmFX.update();
//			mLeftForeArmFX.update();
//			mLeftHandFX.update();
//			mRightShoulderFX.update();
//			mRightUpperArmFX.update();
//			mRightForeArmFX.update();
//			mRightHandFX.update();
			// mLeftLegFX.update();
//			mLeftUpperLegFX.update();
//			mLeftForeLegFX.update();
//			mLeftFootFX.update();
			// mRightLegFX.update();
//			mRightUpperLegFX.update();
//			mRightForeLegFX.update();
//			mRightFootFX.update();

			// mSpeechBubbleFX.update();

			if (starShowC == true)
				mStarsFX.update(); // Added by Robbie, to show stars or words
									// here.
		}

		// draw environment
		// mSpeechBubble.update(g);
	}

//	private void implimentPerlinNoise(double mWobble, int x, int y) {
//		if (starShowControler == true) {
//			mStarsFX.rotatePerlinNoise(mWobble, x, y); // Added by Robbie, to
//														// show stars or words
//														// here
//		} else {
//			if (starShowC == true)
//				mStarsFX.rotatePerlinNoise(mWobble, x, y);
//			mHeadFX.rotatePerlinNoise(mWobble, x, y);
//
//			if (this.mType == StickmanFX.TYPE.MALE)
//				mMaleHairFX.rotatePerlinNoise(mWobble, x, y);
//			else
//				mFemaleHairFX.rotatePerlinNoise(mWobble, x, y);
//			mLeftEyebrowFX.rotatePerlinNoise(mWobble, x, y);
//			mLeftEyeFX.rotatePerlinNoise(mWobble, x, y);
//			mRightEyebrowFX.rotatePerlinNoise(mWobble, x, y);
//			mFaceWrinkleFX.rotatePerlinNoise(mWobble, x, y); // added by Robbie
//			mRightEyeFX.rotatePerlinNoise(mWobble, x, y);
//			mMouthFX.rotatePerlinNoise(mWobble, x, y);
//			mNeckFX.rotatePerlinNoise(mWobble, x, y);
//			// BodyFX is not BodyPartFX Classe
//			mBodyFX.rotatePerlinNoise(mWobble, x, y);
//			mLeftShoulderFX.rotatePerlinNoise(mWobble, x, y);
//			mLeftUpperArmFX.rotatePerlinNoise(mWobble, x, y);
//			mLeftForeArmFX.rotatePerlinNoise(mWobble, x, y);
//			mRightShoulderFX.rotatePerlinNoise(mWobble, x, y);
//			mRightUpperArmFX.rotatePerlinNoise(mWobble, x, y);
//			mRightForeArmFX.rotatePerlinNoise(mWobble, x, y);
//			// mLeftLegFX.update();
//			mLeftUpperLegFX.rotatePerlinNoise(mWobble, x, y);
//			mLeftForeLegFX.rotatePerlinNoise(mWobble, x, y);
//			mLeftFootFX.rotatePerlinNoise(mWobble, x, y);
//			// mRightLegFX.update();
//			mRightUpperLegFX.rotatePerlinNoise(mWobble, x, y);
//			mRightForeLegFX.rotatePerlinNoise(mWobble, x, y);
//			mRightFootFX.rotatePerlinNoise(mWobble, x, y);
//
//			if (starShowC == true)
//				mStarsFX.rotatePerlinNoise(mWobble, x, y); // Added by Robbie,
//															// to show stars or
//															// words here.
//		}
//	}
	
	public void hideAllPartsWithout(Pane p)
	{
		this.getChildren().forEach(child -> 
		{
			if(! child.equals(p))
			{
				child.setVisible(false);
			}
		});
	}
	
	public void showAllParts()
	{
		this.getChildren().forEach(child -> 
		{
			child.setVisible(true);
		});
	}
}
