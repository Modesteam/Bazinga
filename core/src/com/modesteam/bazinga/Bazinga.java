package com.modesteam.bazinga;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.modesteam.bazinga.measures.Measure;
import com.modesteam.bazinga.screens.MainMenuScreen;


public class Bazinga extends Game {

	private FreeTypeFontGenerator generator;
	private FreeTypeFontGenerator.FreeTypeFontParameter parameter;
	private SpriteBatch batch;
	private BitmapFont font;


	public void create() {
		generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/BPmono.ttf"));
		parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		batch = new SpriteBatch();

		//Use LibGDX's default Arial font.

		this.setScreen(new MainMenuScreen(this));

		parameter.size = (int) Measure.getFontSize();
		font = generator.generateFont(parameter); // font size 12 pixels
		generator.dispose(); // don't forget to dispose to avoid memory leaks!
	}

	public void render() {

		super.render();
	}

	public void dispose() {

		batch.dispose();
		font.dispose();
	}

	public SpriteBatch getBatch() {
		return batch;
	}

	public BitmapFont getFont() {
		return font;
	}
}