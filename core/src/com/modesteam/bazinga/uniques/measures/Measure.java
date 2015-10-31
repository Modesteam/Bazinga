package com.modesteam.bazinga.uniques.measures;

import com.badlogic.gdx.Gdx;

import static com.badlogic.gdx.math.MathUtils.ceil;
import static java.lang.Math.round;

public abstract class Measure {
	private static final float MINIMUM_HEIGHT = 320;
	private static final float MINIMUM_WIDTH = 240;

	private static float screenWidth;
	private static float screenHeight;

	private static float centerScreenX;
	private static float centerScreenY;

	public static void generateStandardValues() {

		screenWidth = Gdx.graphics.getWidth();
		screenHeight = Gdx.graphics.getHeight();

		centerScreenX = screenWidth/2f;
		centerScreenY = screenHeight/2f;
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

		float proportionalY = screenHeight * ratio;

		return proportionalY;
	}


	public static int getFontSize() {
		int fontSize = round(screenHeight / 18f);

		return fontSize;
	}
}
