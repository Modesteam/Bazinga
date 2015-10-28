package com.modesteam.bazinga.measures;

import com.badlogic.gdx.math.Rectangle;

public abstract class RectangleCollider {

	public static boolean areCollided(float x, float y, Rectangle rect) {

		float correctY = Measure.getScreenHeight(false) - y;

		boolean areCollided = false;

		if (rect.x <= x && rect.x + rect.width >= x &&
				rect.y - rect.height <= correctY && rect.y >= correctY) {
			areCollided = true;
		}

		return areCollided;
	}
}
