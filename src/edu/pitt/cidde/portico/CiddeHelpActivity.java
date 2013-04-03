package edu.pitt.cidde.portico;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class CiddeHelpActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cidde_help);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_cidde_help, menu);
		return true;
	}

	// Called when the user clicks the Let's Troubleshoot button
	public void troubleshoot(View view) {
		// Do something in response to button
		Intent troubleshootIntent = new Intent(this,
				CiddeTroubleshootActivity.class);

		startActivity(troubleshootIntent);
	}
}
