package com.modesteam.bazinga.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.modesteam.bazinga.Bazinga;
import com.modesteam.bazinga.measures.Measure;

public class MainMenuScreen implements Screen {

	private final Bazinga game;
	private OrthographicCamera camera;
	private Sprite logoSprite;

	public MainMenuScreen(final Bazinga game) {

		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, Measure.getScreenWidth(true), Measure.getScreenHeight(true));
		Texture logoTexture = new Texture(Gdx.files.internal("bazinga.png"));
		logoSprite = new Sprite(logoTexture);
		logoSprite.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		logoSprite.setSize(Measure.getScreenWidth(true), Measure.getProportionalY(5f, 8f, true));
		logoSprite.setPosition(0,Measure.getProportionalY(3f, 8f, false));
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
		logoSprite.draw(game.getBatch());
		game.getFont().draw(game.getBatch(), "Start the Game!", Measure.getCenterScreenX(false),
				Measure.getProportionalY(3f, 8f, false), 1, 1, false);
		game.getFont().draw(game.getBatch(), "How To Play?", Measure.getCenterScreenX(false),
				Measure.getProportionalY(1f, 4f, false), 1, 1, false);
		game.getFont().draw(game.getBatch(), "Exit The Game", Measure.getCenterScreenX(false),
				Measure.getProportionalY(1f, 8f, false), 1, 1, false);
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
