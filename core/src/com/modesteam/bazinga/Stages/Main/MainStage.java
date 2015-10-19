package com.modesteam.bazinga.Stages.Main;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.modesteam.bazinga.Stages.BazingaStage;

public class MainStage extends BazingaStage {

    protected TextButton startButton;
    protected TextButton instructionButton;
    protected TextButton exitButton;

    public MainStage() {
        super();
        startButton = createButton("Start a Game!", 4f);
        instructionButton = createButton("How To Play?", startButton);
        exitButton = createButton("Exit The Game.", instructionButton);
        stage.addActor(startButton);
        stage.addActor(instructionButton);
        stage.addActor(exitButton);
    }

}