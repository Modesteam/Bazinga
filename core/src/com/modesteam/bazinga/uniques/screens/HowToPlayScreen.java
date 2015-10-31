package com.modesteam.bazinga.uniques.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.modesteam.bazinga.uniques.Bazinga;
import com.modesteam.bazinga.entities.TextEntity;
import com.modesteam.bazinga.uniques.measures.Measure;

public class HowToPlayScreen implements Screen {
	TextEntity instructions;
	Bazinga game;
	private OrthographicCamera camera;

	public HowToPlayScreen(Bazinga game) {

		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, Measure.getScreenWidth(), Measure.getScreenHeight());

		instructions = new TextEntity("Bazinga is similar to Jo-Ken-Po, or Rock-Scissor-Paper.",
				(3f/8f), new GameScreen(game));
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

		instructions.draw(game);

		game.getBatch().end();
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
