package com.team_one.modesteam.bazinga;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.logging.Logger;

import model.Game;

public class GameActivity extends Activity {

    Game game;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }

}
