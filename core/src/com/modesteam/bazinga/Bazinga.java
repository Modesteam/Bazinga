package com.modesteam.bazinga;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.modesteam.bazinga.measures.Measure;
import com.modesteam.bazinga.screens.MainMenuScreen;


public class Bazinga extends Game {

	private FreeTypeFontGenerator generator;
	private FreeTypeFontGenerator.FreeTypeFontParameter parameter;
	private SpriteBatch batch;
	private BitmapFont font;
	private static GlyphLayout glyphLayout;

	public void create() {
		generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/BPmono.ttf"));
		parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		batch = new SpriteBatch();
		glyphLayout = new GlyphLayout();

		parameter.size = Measure.getFontSize(true);
		font = generator.generateFont(parameter);
		font.setColor(Color.WHITE);
		generator.dispose();
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

	public GlyphLayout getGlyphLayout() {
		return glyphLayout;
	}
}