package com.modesteam.bazinga.measures;

import com.badlogic.gdx.Gdx;

public abstract class Measure {

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
}
