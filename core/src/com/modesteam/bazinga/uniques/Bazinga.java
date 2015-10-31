package com.modesteam.bazinga.uniques;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.modesteam.bazinga.uniques.measures.Measure;
import com.modesteam.bazinga.uniques.screens.MainMenuScreen;


public class Bazinga extends Game {

	private SpriteBatch batch;

	public void create() {

		generateStandardMeasureValues();
		generateStandardAssets();
		batch = new SpriteBatch();

		this.setScreen(new MainMenuScreen(this));
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
}