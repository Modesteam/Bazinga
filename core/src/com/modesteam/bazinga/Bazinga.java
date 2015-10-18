package com.modesteam.bazinga;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class Bazinga extends ApplicationAdapter {
	private SpriteBatch batch;
	private Skin skin;
	private Stage stage;

	@Override
	public void create () {
		batch = new SpriteBatch();
		skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		stage = new Stage();

		final TextButton button = new TextButton("Start a Game!", skin, "default");
		button.setWidth(Gdx.graphics.getWidth());
		button.setHeight(Gdx.graphics.getHeight()/15);
		button.setPosition(0, Gdx.graphics.getHeight()/4);
		button.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				button.setText("Pressed: Start a Game!");
			}
		});

		final TextButton instructionButton = new TextButton("How To Play?", skin, "default");
		instructionButton.setWidth(Gdx.graphics.getWidth());
		instructionButton.setHeight(Gdx.graphics.getHeight()/15);
		instructionButton.setPosition(0,
				button.getY() - instructionButton.getHeight());
		instructionButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				instructionButton.setText("Pressed: How To Play?");
			}
		});

		stage.addActor(button);
		stage.addActor(instructionButton);

		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void dispose() {
		batch.dispose();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		stage.draw();
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		// Nothing
	}

	@Override
	public void pause() {
		// Nothing
	}

	@Override
	public void resume() {
		// Nothing
	}
}
