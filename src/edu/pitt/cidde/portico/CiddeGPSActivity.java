package edu.pitt.cidde.portico;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class CiddeGPSActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gps);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_cidde_main, menu);
		return true;
	}

}
