package com.modesteam.bazinga.measures;

import com.badlogic.gdx.math.Rectangle;

public abstract class RectangleCollider {

	public static boolean areCollided(float x, float y, Rectangle rect) {

		float correctY = Measure.getScreenHeight(false) - y;
		float correctRectX = rect.x - (rect.width/2);

		boolean areCollided = false;

		if (correctRectX <= x && correctRectX + rect.width >= x &&
				rect.y - rect.height <= correctY && rect.y >= correctY) {
			areCollided = true;
		}

		return areCollided;
	}
}
