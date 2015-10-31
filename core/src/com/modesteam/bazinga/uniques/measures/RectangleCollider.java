package com.modesteam.bazinga.uniques.measures;

import com.badlogic.gdx.math.Rectangle;

public abstract class RectangleCollider {

	public static boolean areCollided(float x, float y, Rectangle rect) {

		boolean pointOverlapsXAxis = (rect.x <= x && rect.x + rect.width >= x);
		boolean pointOverlapsYAxis = (rect.y <= y && rect.y + rect.height >= y);

		boolean areCollided = (pointOverlapsXAxis && pointOverlapsYAxis);

		return areCollided;
	}
}
