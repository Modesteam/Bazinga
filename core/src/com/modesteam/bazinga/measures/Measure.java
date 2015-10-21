package com.modesteam.bazinga.measures;

import com.badlogic.gdx.Gdx;
import com.modesteam.bazinga.Bazinga;

public abstract class Measure {
	private static int lastButtonX=0;
	private static int lastButtonY=0;
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

	public static int getFontSize(){
		float screenHeight = Gdx.graphics.getHeight();
		return (int)screenHeight/27;
	}

	public static int getPositionTextXWithDecrement(){
		double position;
		if(lastButtonX == 0) {
			position = ((Gdx.graphics.getWidth() / 2) - (1/8 * (Gdx.graphics.getWidth())));
		}
		else{
			position = lastButtonX - (1/8 * (Gdx.graphics.getWidth()));
		}
		lastButtonX = (int)position;
		return lastButtonX;
	}
	public static int getPositionTextX(){
		int position = ((Gdx.graphics.getWidth() / 2));
		lastButtonX = position;
		return position;
	}

	public static int getPositionTextYWithDecrement(){
		double position;
		if(lastButtonY == 0) {
			position = ((Gdx.graphics.getHeight() / 2) - (1/8*(Gdx.graphics.getHeight())));
		}
		else{
			position = lastButtonY - (1/8 * (Gdx.graphics.getWidth()));
		}
		lastButtonY = (int)position;
		return lastButtonY;
	}

	public static int getPositionTextY(){
		int position = ((Gdx.graphics.getHeight() / 2) );
		lastButtonY = position;
		return position;
	}
}
