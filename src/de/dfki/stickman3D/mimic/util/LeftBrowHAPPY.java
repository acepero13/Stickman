package de.dfki.stickman3D.mimic.util;

import de.dfki.stickman3D.animationlogic.Animator;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.TriangleMesh;

public class LeftBrowHAPPY {

	public static Polygon getANGRY(Polygon currentPolygon, float step, String sign) {
		int sig;

		if (sign.equalsIgnoreCase("PLUS"))
			sig = 1;
		else
			sig = -1;

		currentPolygon.getPoints().set(1, currentPolygon.getPoints().get(1) - (sig * 0.210));
		currentPolygon.getPoints().set(3, currentPolygon.getPoints().get(3) - (sig * 0.105));
		currentPolygon.getPoints().set(5, currentPolygon.getPoints().get(5) - (sig * 0.052));
		currentPolygon.getPoints().set(7, currentPolygon.getPoints().get(7) - (sig * 0.052));
		currentPolygon.getPoints().set(11, currentPolygon.getPoints().get(11) + (sig * 0.105));
		currentPolygon.getPoints().set(21, currentPolygon.getPoints().get(21) + (sig * 0.105));
		currentPolygon.getPoints().set(25, currentPolygon.getPoints().get(25) - (sig * 0.052));
		currentPolygon.getPoints().set(27, currentPolygon.getPoints().get(27) - (sig * 0.052));

		return currentPolygon;
	}

}