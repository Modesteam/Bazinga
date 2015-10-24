package com.modesteam.bazinga.measures;

import com.badlogic.gdx.math.Rectangle;

public abstract class RectangleCollider {

	public static boolean areCollided(float x, float y, Rectangle rect) {

		float correctY = Measure.getScreenHeight(false) - y;
		float correctRectX = rect.x - (rect.width/2);

		boolean areCollided = false;

		if (x > rect.x && x < rect.x + rect.width
				&& correctY < rect.y && correctY > rect.y - rect.height) {

			areCollided = true;
		}

		System.out.println("[X,X,X+H]: " + x + "|" + rect.x + "|" + (rect.x+rect.height) + "|| [Y,Y,Y+W]: "
				+ correctY + "|" + rect.y + "|" + (rect.y - rect.height) + "|" + areCollided);

		return areCollided;
	}
}
