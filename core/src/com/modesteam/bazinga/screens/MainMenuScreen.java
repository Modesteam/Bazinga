package com.modesteam.bazinga.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.modesteam.bazinga.Bazinga;
import com.modesteam.bazinga.entities.TextEntity;
import com.modesteam.bazinga.measures.Measure;
import com.modesteam.bazinga.measures.RectangleCollider;

public class MainMenuScreen implements Screen {

	private final Bazinga game;
	private OrthographicCamera camera;
	private Sprite logoSprite;
	private TextEntity startText;
	private TextEntity instructionsText;
	private TextEntity exitText;

	public MainMenuScreen(final Bazinga game) {

		this.game = game;

		startText = new TextEntity();
		startText.setText("Start the game!");
		startText.setPosition(Measure.getCenterScreenX(false), Measure.getProportionalY(3f, 8f, false));
		startText.setSize(Measure.getScreenWidth(false), Measure.getProportionalY(1f, 8f, false));

		instructionsText = new TextEntity();
		instructionsText.setText("How To Play?");
		instructionsText.setPosition(Measure.getCenterScreenX(false), Measure.getProportionalY(1f, 4f, false));
		instructionsText.setSize(Measure.getScreenWidth(false), Measure.getProportionalY(1f, 8f, false));

		exitText = new TextEntity();
		exitText.setText("Exit the game!");
		exitText.setPosition(Measure.getCenterScreenX(false), Measure.getProportionalY(1f, 8f, false));
		exitText.setSize(Measure.getScreenWidth(false), Measure.getProportionalY(1f, 8f, false));

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

		startText.draw(game);
		instructionsText.draw(game);
		exitText.draw(game);

		game.getBatch().end();

		if (Gdx.input.isTouched()) {

			if(RectangleCollider.areCollided(Gdx.input.getX(),
					Gdx.input.getY(), startText.getRect())) {

				game.setScreen(new GameScreen(game));
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