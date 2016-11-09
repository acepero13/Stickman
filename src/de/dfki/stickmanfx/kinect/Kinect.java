package de.dfki.stickmanfx.kinect;


import de.dfki.stickmanfx.StickmanFX;
import de.dfki.stickmanfx.animationlogic.AnimationFX;
import edu.ufl.digitalworlds.j4k.J4KSDK;
import edu.ufl.digitalworlds.j4k.Skeleton;
 
public class Kinect extends AnimationFX
{
   StickmanFX currentStickman;
   
  class SkeletonTracker extends J4KSDK 
  {
    @Override
    public void onSkeletonFrameEvent( boolean[] skeletonTracked, float[] positions,
                                      float[] orientations, byte[] jointStatus ) 
    {
      int skeletonId = 0;
      while ( !skeletonTracked[ skeletonId ] )
        skeletonId++;
 
      Skeleton skeleton = Skeleton.getSkeleton( skeletonId, skeletonTracked, positions,
                                                orientations, jointStatus, this );
 
//      BOX.SETROTATE( (INT) SKELETON.GETBODYORIENTATION() );  // REDUCE "NOISE" WITH (INT)
//      TEXT.SETTEXT( "" + (INT) SKELETON.GETBODYORIENTATION() );
//      TExt.setRotate( (int) skeleton.getBodyOrientation() );
//      currentStickman.mUpperBody.setRotationAxis(Rotate.Y_AXIS);
//      currentStickman.mUpperBody.setRotate((int)skeleton.getBodyOrientation());
      System.out.println((int) skeleton.getBodyOrientation());
      currentStickman.mUpperBody.mYRotation = (int) skeleton.getBodyOrientation();
      currentStickman.mUpperBody.calculate(0);
//      mAnimationPartFX = new ArrayList<>();
//      mAnimationPartFX.add(new AnimationContentFX(currentStickman.mUpperBody, "yrotate", (int) skeleton.getBodyOrientation()));
//      playAnimationPart(5);
    }
     
    @Override
    public void onColorFrameEvent( byte[] colorData ) { }
 
    @Override
    public void onDepthFrameEvent( short[] depthFrame, byte[] playerIndex, float[] xyz, float[] uv ) { }
  }
 
  public Kinect(StickmanFX currentStickman) 
  {
	this.currentStickman = currentStickman;
    new SkeletonTracker().start( J4KSDK.SKELETON );
  }
}
