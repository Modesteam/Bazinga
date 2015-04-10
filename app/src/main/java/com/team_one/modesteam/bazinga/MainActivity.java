package com.team_one.modesteam.bazinga;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about) {
			Intent intent = new Intent();
			intent.setClass(this, AboutActivity.class);
			startActivity(intent);
            return true;
        }
		else if(id == R.id.action_rules) {
			Intent intent = new Intent();
			intent.setClass(this, RulesActivity.class);
			startActivity(intent);
			return true;
		}

        return super.onOptionsItemSelected(item);
    }

	public void showGameActivity(View view) {
		Intent intent = new Intent();
		intent.setClass(this, GameActivity.class);
		startActivity(intent);
	}
}
