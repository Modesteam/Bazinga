package com.modesteam.bazinga;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.modesteam.bazinga.screens.MainMenuScreen;


public class Bazinga extends Game {

	private SpriteBatch batch;
	private BitmapFont font;

	public void create() {

		batch = new SpriteBatch();

		//Use LibGDX's default Arial font.
		font = new BitmapFont();

		this.setScreen(new MainMenuScreen(this));
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