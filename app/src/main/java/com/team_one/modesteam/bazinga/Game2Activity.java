package com.team_one.modesteam.bazinga;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import javax.xml.transform.Result;


public class Game2Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game2);
    }

    public void showResultActivity(View view) {
        Intent intent2 = new Intent();
        intent2.setClass(this, ResultActivity.class);
        startActivity(intent2);
    }
}
