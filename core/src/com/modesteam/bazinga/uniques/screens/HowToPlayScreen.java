package com.modesteam.bazinga.uniques.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;
import com.modesteam.bazinga.entities.text.LineTextEntity;
import com.modesteam.bazinga.entities.text.ParagraphEntity;
import com.modesteam.bazinga.entities.text.TextEntity;
import com.modesteam.bazinga.uniques.Bazinga;
import com.modesteam.bazinga.uniques.InputHandle;
import com.modesteam.bazinga.uniques.measures.Measure;

public class HowToPlayScreen implements Screen {
	Array<TextEntity> texts;
	Bazinga game;
	private OrthographicCamera camera;

	public HowToPlayScreen(Bazinga game) {

		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, Measure.getScreenWidth(), Measure.getScreenHeight());

		texts = new Array<TextEntity>();
		texts.add(new ParagraphEntity("Bazinga is similar to Jo-Ken-Po, or Rock-Scissor-Paper.",
				Measure.getProportionalY((1f / 2f)), ScreenType.MAIN_MENU));
		texts.add(new LineTextEntity("Back to Main Menu",
				Measure.getProportionalY((1f / 10f)), ScreenType.MAIN_MENU));
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

		for (TextEntity text : texts) {

			text.draw(game);
		}

		InputHandle.handleTextEntities(texts, game);

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
