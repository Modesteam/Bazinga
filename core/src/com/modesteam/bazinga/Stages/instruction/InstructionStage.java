package com.modesteam.bazinga.Stages.instruction;

import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.modesteam.bazinga.Stages.BazingaStage;

public class InstructionStage extends BazingaStage {
    private TextButton returnButton;
    public InstructionStage(){
        super();
        returnButton = createButton("Return to main menu",20f);
        stage.addActor(returnButton);
    }
}
