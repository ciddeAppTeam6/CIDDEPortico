package edu.pitt.cidde.portico;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CiddeHelpActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cidde_help);

		Button emergencyButton;
		Button generalButton;
		Button requestsButton;
		Button scheduleButton;
		Button recordingButton;
		Button lateButton;
		Button otherButton;

		Button etcButton;
		Button facultyHelpButton;
		Button gabeButton;
		Button ashleyButton;
		Button adawgButton;
		Button willButton;
		Button bettyButton;
		Button blaineButton;

		// Blaine button
		blaineButton = (Button) findViewById(R.id.blaine_button);
		blaineButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String number = getString(R.string.blaine_string);
				startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(number)));
			} // end of listener method
		}); // end of anon listener class

		// Betty button
		bettyButton = (Button) findViewById(R.id.betty_button);
		bettyButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String number = getString(R.string.betty_string);
				startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(number)));
			} // end of listener method
		}); // end of anon listener class

		// Will button
		willButton = (Button) findViewById(R.id.will_button);
		willButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String number = getString(R.string.will_string);
				startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(number)));
			} // end of listener method
		}); // end of anon listener class

		// A dawg button
		adawgButton = (Button) findViewById(R.id.adawg_button);
		adawgButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String number = getString(R.string.adawg_string);
				startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(number)));
			} // end of listener method
		}); // end of anon listener class

		// Ashley button
		ashleyButton = (Button) findViewById(R.id.ashley_button);
		ashleyButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String number = getString(R.string.ashley_string);
				startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(number)));
			} // end of listener method
		}); // end of anon listener class

		// Gabe button
		gabeButton = (Button) findViewById(R.id.gabe_button);
		gabeButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String number = getString(R.string.gabe_string);
				startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(number)));
			} // end of listener method
		}); // end of anon listener class

		// Faculty button
		facultyHelpButton = (Button) findViewById(R.id.faculty_help_button);
		facultyHelpButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String number = getString(R.string.faculty_help_string);
				startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(number)));
			} // end of listener method
		}); // end of anon listener class

		// ETC button
		etcButton = (Button) findViewById(R.id.etc_button);
		etcButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String number = getString(R.string.etc_string);
				startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(number)));
			} // end of listener method
		}); // end of anon listener class

		// Other button
		otherButton = (Button) findViewById(R.id.other_button);
		otherButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String number = getString(R.string.other_string);
				startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(number)));
			} // end of listener method
		}); // end of anon listener class

		// Late button
		lateButton = (Button) findViewById(R.id.late_button);
		lateButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String number = getString(R.string.late_string);
				startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(number)));
			} // end of listener method
		}); // end of anon listener class

		// Recording button
		recordingButton = (Button) findViewById(R.id.recording_button);
		recordingButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String number = getString(R.string.recording_string);
				startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(number)));
			} // end of listener method
		}); // end of anon listener class

		// Schedule button
		scheduleButton = (Button) findViewById(R.id.schedule_button);
		scheduleButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String number = getString(R.string.schedule_string);
				startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(number)));
			} // end of listener method
		}); // end of anon listener class

		// Requests button
		requestsButton = (Button) findViewById(R.id.requests_button);
		requestsButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String number = getString(R.string.requests_string);
				startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(number)));
			} // end of listener method
		}); // end of anon listener class

		// General button
		generalButton = (Button) findViewById(R.id.general_button);
		generalButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String number = getString(R.string.main_string);
				startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(number)));
			} // end of listener method
		}); // end of anon listener class

		// Emergency button
		emergencyButton = (Button) findViewById(R.id.emergency_button);
		emergencyButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String number = getString(R.string.emergency_string);
				startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse(number)));
			} // end of listener method
		}); // end of anon listener class

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
