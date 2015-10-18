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

		final TextButton button = new TextButton("Click me", skin, "default");

		button.setWidth(Gdx.graphics.getWidth()/5);
		button.setHeight(Gdx.graphics.getHeight()/10);
		button.setPosition(Gdx.graphics.getWidth()/2 - Gdx.graphics.getWidth()/10, Gdx.graphics.getHeight()/2 - Gdx.graphics.getHeight()/20);

		button.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				button.setText("You clicked the button");
			}
		});

		stage.addActor(button);

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
