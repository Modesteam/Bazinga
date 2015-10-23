package com.modesteam.bazinga.measures;

import com.badlogic.gdx.Gdx;

import static com.badlogic.gdx.math.MathUtils.ceil;

public abstract class Measure {
	private static int lastButtonX = 0;
	private static int lastButtonY = 0;
	private static final float MINIMUM_HEIGHT = 320;
	private static final float MINIMUM_WIDTH = 240;

	public static float getScreenWidth(Boolean verbose) {

		float screenWidth = Gdx.graphics.getWidth();

		if (verbose) {
			System.out.println("WIDTH: " + screenWidth);
		}

		return screenWidth;
	}

	public static float getScreenHeight(Boolean verbose) {

		float screenHeight = Gdx.graphics.getHeight();

		if (verbose) {
			System.out.println("HEIGHT: " + screenHeight);
		}

		return screenHeight;
	}

	public static float getCenterScreenX(Boolean verbose) {

		float centerScreenX = getScreenWidth(false) / 2f;

		if (verbose) {
			System.out.println("Center X: " + centerScreenX);
		}

		return centerScreenX;
	}

	public static float getProportionalY(float denominator, float numerator, Boolean verbose) {

		float proportionalY = getScreenHeight(false) * denominator / numerator;

		if (verbose) {
			System.out.println("Proportional Y: " + proportionalY);
		}

		return proportionalY;
	}


	public static float getScreenScaleX(Boolean verbose) {

		float screenScaleX = getScreenWidth(false) / MINIMUM_WIDTH;

		if (verbose) {
			System.out.println("SCALE X: " + screenScaleX);
		}

		return screenScaleX;
	}

	public static float getScreenScaleY(Boolean verbose) {

		float screenScaleY = getScreenHeight(false) / MINIMUM_HEIGHT;

		if (verbose) {
			System.out.println("SCALE Y: " + screenScaleY);
		}

		return screenScaleY;
	}

	public static int getFontSize(Boolean verbose) {
		int fontSize = ceil(getScreenHeight(false) / 18f);

		if (verbose) {
			System.out.println("FONT SIZE: " + fontSize);
		}

		return fontSize;
	}
}
