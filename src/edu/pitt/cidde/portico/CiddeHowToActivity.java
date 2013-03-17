package edu.pitt.cidde.portico;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class CiddeHowToActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cidde_how_to);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_cidde_how_to, menu);
		return true;
	}

	
}
