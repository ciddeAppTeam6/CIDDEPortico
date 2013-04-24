package edu.pitt.cidde.portico;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class CiddeMainActivity extends Activity {

	LinearLayout orderLayout;
	LinearLayout browseLayout;
	LinearLayout contactLayout;
	LinearLayout howtoLayout;
	LinearLayout qrLayout;
	LinearLayout gpsLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cidde_main);

		// Order button
		orderLayout = (LinearLayout) findViewById(R.id.orderLayout);
		orderLayout.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.cidde.pitt.edu/-35")));
			} // end of listener method
		}); // end of anon listener class

		// Browse button
		browseLayout = (LinearLayout) findViewById(R.id.browseLayout);
		browseLayout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent howToIntent = new Intent(CiddeMainActivity.this,
						CiddeBrowseRooms.class);
				startActivity(howToIntent);

			}
		});

		// Contact button
		contactLayout = (LinearLayout) findViewById(R.id.contactLayout);
		contactLayout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent howToIntent = new Intent(CiddeMainActivity.this,
						CiddeHelpActivity.class);
				startActivity(howToIntent);

			}
		});

		// How To button
		howtoLayout = (LinearLayout) findViewById(R.id.howtoLayout);
		howtoLayout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent howToIntent = new Intent(CiddeMainActivity.this,
						CiddeHowToActivity.class);
				startActivity(howToIntent);

			}
		});

		// QR button
		qrLayout = (LinearLayout) findViewById(R.id.qrLayout);
		qrLayout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent howToIntent = new Intent(CiddeMainActivity.this,
						CiddeScanQRcodeActivity.class);
				startActivity(howToIntent);

			}
		});
		
		// GPS button
		gpsLayout = (LinearLayout) findViewById(R.id.gpsLayout);
		gpsLayout.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent howToIntent = new Intent(CiddeMainActivity.this,
						CiddeGPSActivity.class);
				startActivity(howToIntent);

			}
		});

	}// onCreate()

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
