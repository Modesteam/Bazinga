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
import com.modesteam.bazinga.Stages.BazingaStage;
import com.modesteam.bazinga.Stages.Main.MainStage;

public class Bazinga extends ApplicationAdapter {
    private SpriteBatch batch;
    private BazingaStage bazingaStage;

    @Override
    public void create() {
        batch = new SpriteBatch();
        bazingaStage = new MainStage();
        Gdx.input.setInputProcessor(bazingaStage.getStage());
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
        bazingaStage.getStage().draw();
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
