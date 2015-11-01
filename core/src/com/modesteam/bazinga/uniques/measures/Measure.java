package com.modesteam.bazinga.uniques.measures;

import com.badlogic.gdx.Gdx;

import static java.lang.Math.round;

public abstract class Measure {
	private static final float MINIMUM_HEIGHT = 320f;
	private static final float MINIMUM_WIDTH = 240f;
	private static final float FONT_SIZE_RATIO = 18f;

	private static float screenWidth;
	private static float screenHeight;

	private static float centerScreenX;
	private static float centerScreenY;

	private static int fontSize;

	public static void generateStandardValues() {

		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();

		centerScreenX = screenWidth/2f;
		centerScreenY = screenHeight/2f;

		fontSize = round(screenHeight / FONT_SIZE_RATIO);
	}

	public static float getScreenWidth() {

		return screenWidth;
	}

	public static float getScreenHeight() {

		return screenHeight;
	}

	public static float getCenterScreenX() {

		return centerScreenX;
	}

	public static float getProportionalY(float ratio) {

		return screenHeight * ratio;
	}

	public static float getProportionalX(float ratio) {

		return screenWidth * ratio;
	}

	public static int getFontSize() {

		return fontSize;
	}
}
