package com.modesteam.bazinga.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;
import com.modesteam.bazinga.Bazinga;
import com.modesteam.bazinga.entities.TextEntity;
import com.modesteam.bazinga.measures.Measure;
import com.modesteam.bazinga.measures.RectangleCollider;

public class MainMenuScreen implements Screen {

	private final Bazinga game;
	private OrthographicCamera camera;
	private Sprite logoSprite;
	private Array<TextEntity> texts;

	public MainMenuScreen(final Bazinga game) {

		this.game = game;

		texts = new Array<TextEntity>();
		texts.add(new TextEntity("Start the game", 3f, 8f, game, new GameScreen(game)));
		texts.add(new TextEntity("How to Play?", 1f, 4f, game, new HowToPlayScreen(game)));
		texts.add(new TextEntity("Exit the game!", 1f, 8f, game, new ExitScreen()));

		camera = new OrthographicCamera();
		camera.setToOrtho(false, Measure.getScreenWidth(true), Measure.getScreenHeight(true));
		Texture logoTexture = new Texture(Gdx.files.internal("bazinga.png"));
		logoSprite = new Sprite(logoTexture);
		logoSprite.getTexture().setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
		logoSprite.setSize(Measure.getScreenWidth(true), Measure.getProportionalY(5f, 8f, true));
		logoSprite.setPosition(0, Measure.getProportionalY(3f, 8f, false));
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

		game.getBatch().end();

		if (Gdx.input.isTouched()) {

			float x = Gdx.input.getX();
			float y = Gdx.input.getY();

			for (TextEntity text : texts) {
				if (RectangleCollider.areCollided(x, y, text.getBoundingBox())) {

					game.setScreen(text.getScreen());
				}
			}
		}

		dispose();
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