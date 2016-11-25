package de.dfki.stickman3D.mimic.util;

import javafx.scene.shape.Polygon;

public class MouthFEAR {

	public static Polygon modifyUpperLip(Polygon currentUpperLipMesh, float step, String sign) {

		int sig;

		if (sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;

		float xMovement0;
		float xMovement1;
		float xMovement2;
		float yMovement2;
		float yMovement3;
		float yMovement5;
		float yMovement7;
		float xMovement8;
		float yMovement8;
		float xMovement9;
		float xMovement10;
		float xMovement11;
		float xMovement12;
		float yMovement12;
		float yMovement13;
		float yMovement14;
		float yMovement15;
		float yMovement16;
		float yMovement17;
		float xMovement18;

		xMovement0 = sig * (20 - step) * 0.0105f;
		xMovement1 = sig * (20 - step) * 0.0105f;
		xMovement2 = sig * (20 - step) * 0.0105f;
		yMovement2 = sig * (20 - step) * 0.0052f;
		yMovement3 = sig * (20 - step) * 0.0052f;
		yMovement5 = sig * (20 - step) * 0.0052f;
		yMovement7 = sig * (20 - step) * 0.0052f;
		xMovement8 = sig * (20 - step) * 0.0105f;
		yMovement8 = sig * (20 - step) * 0.0052f;
		xMovement9 = sig * (20 - step) * 0.0158f;
		xMovement10 = sig * (20 - step) * 0.0158f;
		xMovement11 = sig * (20 - step) * 0.0158f;
		xMovement12 = sig * (20 - step) * 0.0105f;
		yMovement12 = sig * (20 - step) * 0.0052f;
		yMovement13 = sig * (20 - step) * 0.0105f;
		yMovement14 = sig * (20 - step) * 0.0105f;
		yMovement15 = sig * (20 - step) * 0.0052f;
		yMovement16 = sig * (20 - step) * 0.0052f;
		yMovement17 = sig * (20 - step) * 0.0052f;
		xMovement18 = sig * (20 - step) * 0.0105f;

		currentUpperLipMesh.getPoints().set(0, currentUpperLipMesh.getPoints().get(0) - xMovement0);
		currentUpperLipMesh.getPoints().set(2, currentUpperLipMesh.getPoints().get(2) - xMovement1);
		currentUpperLipMesh.getPoints().set(4, currentUpperLipMesh.getPoints().get(4) - xMovement2);
		currentUpperLipMesh.getPoints().set(5, currentUpperLipMesh.getPoints().get(5) + yMovement2);
		currentUpperLipMesh.getPoints().set(7, currentUpperLipMesh.getPoints().get(7) + yMovement3);
		currentUpperLipMesh.getPoints().set(11, currentUpperLipMesh.getPoints().get(11) - yMovement5);
		currentUpperLipMesh.getPoints().set(15, currentUpperLipMesh.getPoints().get(15) + yMovement7);
		currentUpperLipMesh.getPoints().set(16, currentUpperLipMesh.getPoints().get(16) + xMovement8);
		currentUpperLipMesh.getPoints().set(17, currentUpperLipMesh.getPoints().get(17) + yMovement8);
		currentUpperLipMesh.getPoints().set(18, currentUpperLipMesh.getPoints().get(18) + xMovement9);
		currentUpperLipMesh.getPoints().set(20, currentUpperLipMesh.getPoints().get(20) + xMovement10);
		currentUpperLipMesh.getPoints().set(22, currentUpperLipMesh.getPoints().get(22) + xMovement11);
		currentUpperLipMesh.getPoints().set(24, currentUpperLipMesh.getPoints().get(24) + xMovement12);
		currentUpperLipMesh.getPoints().set(25, currentUpperLipMesh.getPoints().get(25) - yMovement12);
		currentUpperLipMesh.getPoints().set(27, currentUpperLipMesh.getPoints().get(27) - yMovement13);
		currentUpperLipMesh.getPoints().set(29, currentUpperLipMesh.getPoints().get(29) - yMovement14);
		currentUpperLipMesh.getPoints().set(31, currentUpperLipMesh.getPoints().get(31) - yMovement15);
		currentUpperLipMesh.getPoints().set(33, currentUpperLipMesh.getPoints().get(33) - yMovement16);
		currentUpperLipMesh.getPoints().set(35, currentUpperLipMesh.getPoints().get(35) - yMovement17);
		currentUpperLipMesh.getPoints().set(36, currentUpperLipMesh.getPoints().get(36) - xMovement18);

		return currentUpperLipMesh;
	}

	public static Polygon modifyDownLip(Polygon currentDownLipMesh, float step, String sign) {
		int sig;

		if (sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;

		float xMovement0;
		float xMovement19;
		float xMovement18;
		float yMovement16;
		float yMovement15;
		float yMovement14;
		float yMovement13;
		float xMovement12;
		float yMovement12;
		float xMovement11;
		float xMovement10;
		float xMovement9;
		float xMovement8;
		float yMovement8;
		float yMovement7;
		float yMovement6;
		float yMovement5;
		float yMovement4;
		float yMovement3;
		float xMovement2;
		float yMovement2;
		float xMovement1;

		xMovement0 = sig * (20 - step) * 0.0105f;
		xMovement19 = sig * (20 - step) * 0.0105f;
		xMovement18 = sig * (20 - step) * 0.0105f;
		yMovement16 = sig * (20 - step) * 0.0052f;
		yMovement15 = sig * (20 - step) * 0.0052f;
		yMovement14 = sig * (20 - step) * 0.0052f;
		yMovement13 = sig * (20 - step) * 0.0052f;
		xMovement12 = sig * (20 - step) * 0.0105f;
		yMovement12 = sig * (20 - step) * 0.0052f;
		xMovement11 = sig * (20 - step) * 0.0158f;
		xMovement10 = sig * (20 - step) * 0.0158f;
		xMovement9 = sig * (20 - step) * 0.0158f;
		xMovement8 = sig * (20 - step) * 0.0105f;
		yMovement8 = sig * (20 - step) * 0.0052f;
		yMovement7 = sig * (20 - step) * 0.0052f;
		yMovement6 = sig * (20 - step) * 0.0052f;
		yMovement5 = sig * (20 - step) * 0.0052f;
		yMovement4 = sig * (20 - step) * 0.0052f;
		yMovement3 = sig * (20 - step) * 0.0052f;
		xMovement2 = sig * (20 - step) * 0.0105f;
		yMovement2 = sig * (20 - step) * 0.0052f;
		xMovement1 = sig * (20 - step) * 0.0105f;

		currentDownLipMesh.getPoints().set(0, currentDownLipMesh.getPoints().get(0) - xMovement0);
		currentDownLipMesh.getPoints().set(38, currentDownLipMesh.getPoints().get(38) - xMovement19);
		currentDownLipMesh.getPoints().set(36, currentDownLipMesh.getPoints().get(36) - xMovement18);
		currentDownLipMesh.getPoints().set(33, currentDownLipMesh.getPoints().get(33) + yMovement16);
		currentDownLipMesh.getPoints().set(31, currentDownLipMesh.getPoints().get(31) + yMovement15);
		currentDownLipMesh.getPoints().set(29, currentDownLipMesh.getPoints().get(29) + yMovement14);
		currentDownLipMesh.getPoints().set(27, currentDownLipMesh.getPoints().get(27) + yMovement13);
		currentDownLipMesh.getPoints().set(24, currentDownLipMesh.getPoints().get(24) + xMovement12);
		currentDownLipMesh.getPoints().set(25, currentDownLipMesh.getPoints().get(25) + yMovement12);
		currentDownLipMesh.getPoints().set(22, currentDownLipMesh.getPoints().get(22) + xMovement11);
		currentDownLipMesh.getPoints().set(20, currentDownLipMesh.getPoints().get(20) + xMovement10);
		currentDownLipMesh.getPoints().set(18, currentDownLipMesh.getPoints().get(18) + xMovement9);
		currentDownLipMesh.getPoints().set(16, currentDownLipMesh.getPoints().get(16) + xMovement8);
		currentDownLipMesh.getPoints().set(17, currentDownLipMesh.getPoints().get(17) - yMovement8);
		currentDownLipMesh.getPoints().set(15, currentDownLipMesh.getPoints().get(15) - yMovement7);
		currentDownLipMesh.getPoints().set(13, currentDownLipMesh.getPoints().get(13) - yMovement6);
		currentDownLipMesh.getPoints().set(11, currentDownLipMesh.getPoints().get(11) - yMovement5);
		currentDownLipMesh.getPoints().set(9, currentDownLipMesh.getPoints().get(9) - yMovement4);
		currentDownLipMesh.getPoints().set(7, currentDownLipMesh.getPoints().get(7) - yMovement3);
		currentDownLipMesh.getPoints().set(4, currentDownLipMesh.getPoints().get(4) - xMovement2);
		currentDownLipMesh.getPoints().set(5, currentDownLipMesh.getPoints().get(5) - yMovement2);
		currentDownLipMesh.getPoints().set(2, currentDownLipMesh.getPoints().get(2) - xMovement1);

		return currentDownLipMesh;
	}

}
