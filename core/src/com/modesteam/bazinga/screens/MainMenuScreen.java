package com.modesteam.bazinga.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.modesteam.bazinga.Bazinga;
import com.modesteam.bazinga.measures.Measure;

public class MainMenuScreen implements Screen {

	private final Bazinga game;
	private OrthographicCamera camera;


	public MainMenuScreen(final Bazinga game) {

		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, Measure.getScreenWidth(true), Measure.getScreenHeight(true));
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



		camera.update();
		game.getBatch().setProjectionMatrix(camera.combined);

		game.getBatch().begin();


		game.getFont().draw(game.getBatch(), "Start the Game!", Gdx.graphics.getWidth()*(1f/2f), Gdx.graphics.getHeight()*(5f/8f), 1, 1, false);

		game.getBatch().end();


		if (Gdx.input.isTouched()) {

			game.setScreen(new GameScreen(game));
			dispose();
		}
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {

	}
}
