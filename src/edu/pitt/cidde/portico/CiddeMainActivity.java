package edu.pitt.cidde.portico;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class CiddeMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cidde_main);

		// set the TITLE bar color for screen - wizard of oz testing only
		setTitleColor(Color.parseColor("#a0a0a0")); // / this sets the TITLE
													// color for the activity
		View title = getWindow().findViewById(android.R.id.title);
		View titleBar = (View) title.getParent();
		titleBar.setBackgroundColor(Color.parseColor("#202020"));
		
		// LOGIC HERE for CIDDE GridView
		GridView gridview = (GridView) findViewById(R.id.gridview);
		gridview.setAdapter(new MainImageAdapter(this));

		gridview.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				switch (position) // determine what TYPE of brick will go here
				{
				case 0:
					doIntentSCanQR();
					break;
				case 1:
					doIntentBrwsEquipRoom();
					break;
				case 2:
					doIntentNeedHelp();
					break;
				case 3:
					doIntentBugReport();
					break;
				case 4:
					doIntentHowTo();
					break;
				case 5:
					doIntentOrderWeb();
					break;
				default:
					Toast.makeText(CiddeMainActivity.this, "?unknown option?",
							Toast.LENGTH_SHORT).show();
				} // switch (item click position)
			}
		});

	} // onCreate()

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_cidde_main, menu);
		return true;
	}

	// Send intent to activate the other activities of the app
	// =======================================================

	// Scan QR code (0)
	// ------------
	private void doIntentSCanQR() {
		Toast.makeText(CiddeMainActivity.this, "Scan QR Code",
				Toast.LENGTH_SHORT).show();
	}

	// Browse equipment (1)
	// ----------------
	private void doIntentBrwsEquipRoom() {
		Toast.makeText(CiddeMainActivity.this, "Browse Equipment & Rooms",
				Toast.LENGTH_SHORT).show();
	} // doIntentBrwsEquipRoom

	// "I need help" (2)
	// -------------
	private void doIntentNeedHelp() {
		// Toast.makeText(CiddeMainActivity.this,
		// "I Need Help!", Toast.LENGTH_SHORT).show();

		// Start up the new screen
		Intent howToIntent = new Intent(
				edu.pitt.cidde.portico.CiddeMainActivity.this,
				edu.pitt.cidde.portico.CiddeHelpActivity.class);

		startActivity(howToIntent);

	} // doIntentNeedHelp

	// Submit bug report (3)
	// -----------------
	private void doIntentBugReport() {
		//Toast.makeText(CiddeMainActivity.this, "Submit Bug Report!",
		//		Toast.LENGTH_SHORT).show();
				
		startActivity(new Intent(Intent.ACTION_VIEW,
			Uri.parse("https://pitt.wufoo.com/forms/cidde-classroom-technology-problem-report-form/")));
	} // doIntentBugReport

	// How To.... (4)
	// ----------
	private void doIntentHowTo() {
		// Toast.makeText(CiddeMainActivity.this,
		// "How To...", Toast.LENGTH_SHORT).show();

		// Start up the new screen
		Intent howToIntent = new Intent(
				edu.pitt.cidde.portico.CiddeMainActivity.this,
				edu.pitt.cidde.portico.CiddeHowToActivity.class);

		// go grab any data to pass with the intent
		// int[] intActivityData = 123;

		// Attach the data to the intent and start the child activity
		// howToIntent.putExtra("intLetterData", intActivityData); // do not use
		// resources for this
		// startActivityForResult(howToIntent, 4); // start child activity, if
		// result needed
		startActivity(howToIntent); // start child activity, result needed
		// 4 is the request code (to determine which activity returned, if more
		// than one)
		// Log.d("DEBUG", "CiddeHowToActivty-doIntentHowTo COMNPLETE");

	} // doIntentHowTo

	// order from web (5)
	// --------------
	private void doIntentOrderWeb() {
		Toast.makeText(CiddeMainActivity.this, "Order From Web..",
				Toast.LENGTH_SHORT).show();
	} // doIntentOrderWeb

	// Return from intent results
	// ==========================
	/*
	 * @Override protected void onActivityResult(int requestCode, int
	 * resultCode, Intent data) { super.onActivityResult(requestCode,
	 * resultCode, data);
	 * 
	 * // If new data was returned, then load it up. int[]
	 * msgFromChildLetterData; // holds INCOMING letter data from child activity
	 * msgFromChildLetterData = data.getExtras().getIntArray("intLetterData");
	 * // do not use resource for this if((msgFromChildLetterData != null) &&
	 * (msgFromChildLetterData[0] != -1)) // so long as valid data came back
	 * letterView.setIntLetterDataData(msgFromChildLetterData); }
	 */

}
