package com.modesteam.bazinga.uniques;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.modesteam.bazinga.uniques.measures.Measure;
import com.modesteam.bazinga.uniques.screens.MainMenuScreen;
import com.modesteam.bazinga.uniques.screens.ScreenHandler;
import com.modesteam.bazinga.uniques.screens.ScreenType;

public class Bazinga extends Game {

	private SpriteBatch batch;
	private ScreenHandler screenHandler;

	public void create() {

		Gdx.input.setCatchBackKey(true);
		generateStandardMeasureValues();
		generateStandardAssets();
		batch = new SpriteBatch();
		screenHandler = new ScreenHandler(this);
		this.setScreen(screenHandler.get(ScreenType.MAIN_MENU, this));
	}

	public void render() {

		super.render();
	}

	public void dispose() {

		batch.dispose();
		com.modesteam.bazinga.uniques.Font.dispose();
	}

	private void generateStandardMeasureValues() {

		Measure.generateStandardValues();
	}

	private void generateStandardAssets() {

		com.modesteam.bazinga.uniques.Font.generateStandardValues();
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public ScreenHandler getScreenHandler() {
		return screenHandler;
	}
}