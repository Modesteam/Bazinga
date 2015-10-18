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
    public void create() {
        batch = new SpriteBatch();
        skin = new Skin(Gdx.files.internal("data/uiskin.json"));
        stage = new Stage();

        final TextButton startButton = new TextButton("Start a Game!", skin, "default");
        startButton.getLabel().setFontScale(Gdx.graphics.getWidth() / 240,
                Gdx.graphics.getHeight() / 320);
        startButton.setWidth(Gdx.graphics.getWidth());
        startButton.setHeight(Gdx.graphics.getHeight() / 15);
        startButton.setPosition(0, Gdx.graphics.getHeight() / 4);
        startButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                startButton.setText("Pressed: Start a Game!");
            }
        });

        final TextButton instructionButton = new TextButton("How To Play?", skin, "default");
        instructionButton.getLabel().setFontScale(Gdx.graphics.getWidth() / 240,
                Gdx.graphics.getHeight() / 320);
        instructionButton.setWidth(Gdx.graphics.getWidth());
        instructionButton.setHeight(Gdx.graphics.getHeight() / 15);
        instructionButton.setPosition(0,
                startButton.getY() - instructionButton.getHeight());
        instructionButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                instructionButton.setText("Pressed: How To Play?");
            }
        });

        final TextButton exitButton = new TextButton("Exit The Game", skin, "default");
        exitButton.getLabel().setFontScale(Gdx.graphics.getWidth() / 240,
                Gdx.graphics.getHeight() / 320);
        exitButton.setWidth(Gdx.graphics.getWidth());
        exitButton.setHeight(Gdx.graphics.getHeight() / 15);
        exitButton.setPosition(0,
                instructionButton.getY() - exitButton.getHeight());
        exitButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                exitButton.setText("Pressed: Exit The Game");
            }
        });

        stage.addActor(startButton);
        stage.addActor(instructionButton);
        stage.addActor(exitButton);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

    @Override
    public void render() {
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
