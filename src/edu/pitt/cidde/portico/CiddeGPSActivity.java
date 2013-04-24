package edu.pitt.cidde.portico;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

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

	// when a button in the options menu is clicked
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// main menu intent
		Intent mainIntent = new Intent(this, CiddeMainActivity.class);
		startActivity(mainIntent);
		return true;
	} // end of onOptionsItemSelected
	
}
