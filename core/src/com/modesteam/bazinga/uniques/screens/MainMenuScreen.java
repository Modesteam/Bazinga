package com.modesteam.bazinga.uniques.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;
import com.modesteam.bazinga.entities.text.LineTextEntity;
import com.modesteam.bazinga.entities.text.TextEntity;
import com.modesteam.bazinga.uniques.Bazinga;
import com.modesteam.bazinga.uniques.InputHandler;
import com.modesteam.bazinga.uniques.measures.Measure;

public class MainMenuScreen implements Screen {

	private final Bazinga game;
	private OrthographicCamera camera;
	private Sprite logoSprite;
	private Array<TextEntity> texts;

	public MainMenuScreen(final Bazinga game) {

		this.game = game;

		camera = new OrthographicCamera();
		camera.setToOrtho(false, Measure.getScreenWidth(), Measure.getScreenHeight());
		Texture logoTexture = new Texture(Gdx.files.internal("bazinga.png"));

		texts = new Array<TextEntity>();
		texts.add(new LineTextEntity("Start the game", Measure.getProportionalY(3f / 8f), ScreenType.GAME_SCREEN));
		texts.add(new LineTextEntity("How to Play?", Measure.getProportionalY(1f / 4f), ScreenType.HOW_TO_PLAY));
		texts.add(new LineTextEntity("Exit the game!", Measure.getProportionalY(1f / 8f), ScreenType.EXIT_SCREEN));

		logoSprite = new Sprite(logoTexture);
		logoSprite.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		logoSprite.setSize(Measure.getScreenWidth(), Measure.getProportionalY((5f / 8f)));
		logoSprite.setPosition(0, Measure.getProportionalY((3f / 8f)));
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

		for (TextEntity text : texts) {

			text.draw(game);
		}

		InputHandler.handleKeyCommand(Input.Keys.BACK, ScreenType.EXIT_SCREEN, game, delta);
		InputHandler.handleTextEntities(texts, game, delta);

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