package com.modesteam.bazinga.Stages;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class BazingaStage {

    protected Stage stage;
    private Skin skin;
    private final String DEFAULT_STYLE_NAME = "default";

    public BazingaStage() {
        skin = new Skin(Gdx.files.internal("data/uiskin.json"));
        stage = new Stage();
    }

    protected TextButton createButton(final String buttonText, float initialYHeightFraction) {
        TextButton button = createStandardButton(buttonText);
        button.setPosition(0, Gdx.graphics.getHeight() / initialYHeightFraction);
        button = createStandardListener(button, buttonText);
        return button;
    }

    protected TextButton createButton(String buttonText, TextButton previousButton) {
        TextButton button = createStandardButton(buttonText);
        button.setPosition(0, previousButton.getY() - button.getHeight());
        button = createStandardListener(button, buttonText);
        return button;
    }

    private TextButton createStandardButton(final String buttonText) {
        final TextButton button = new TextButton(buttonText, skin, DEFAULT_STYLE_NAME);
        button.getLabel().setFontScale(Gdx.graphics.getHeight() / 320f);
        button.setWidth(Gdx.graphics.getWidth());
        button.setHeight(Gdx.graphics.getHeight() / 15);
        return button;
    }

    private TextButton createStandardListener(TextButton button, final String buttonText) {
        final TextButton buttonWithListener = button;
        buttonWithListener.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                buttonWithListener.setText("Pressed: " +  buttonText);
            }
        });
        return buttonWithListener;
    }

    public Stage getStage() {
        return stage;
    }
}
