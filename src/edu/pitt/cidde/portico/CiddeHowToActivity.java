package edu.pitt.cidde.portico;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class CiddeHowToActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cidde_how_to);
		
		tempSetUpActivity();
		tempInitActionButtons();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_cidde_how_to, menu);
		return true;
	}


	private void tempSetUpActivity()
	{
		// SET THE TEXT OF btnDoHowTo, etc...
		; // ?
		
	} // setUpActivity()
	
	private void tempInitActionButtons()
	{ // temporary stub for this activity to activiate the how to pageveewr
		// Go load up the viewpager
		((Button) findViewById(R.id.btnStub2)).setOnClickListener(new Button.OnClickListener() {
				@Override
				public void onClick(View v) {
					// LOGIG TO SAVE LOAD HERE (GO OPEN OTEHR ACTIVITY)
					// open up other view - but COPY DATA
					// first (should we save this screen?)
					//Log.d("DEBUG", "LetterGenie.btnSaveLoad");

					// Start up the new screen
					Intent viewPagerBundle = new Intent(
							edu.pitt.cidde.portico.CiddeHowToActivity.this,
							edu.pitt.cidde.portico.ViewPagerActivity.class);

					// Pass in the URL to the xml document to read
					String xmlDocToRead = "www.cidde.pitt.edu/cidde_app/howtos/12345_HowTo_set_up_a_projector.xml";
					viewPagerBundle.putExtra("urlOrPath", xmlDocToRead);
					viewPagerBundle.putExtra("pathType", 1);
					startActivity(viewPagerBundle); // go start child activity - no result needed
					//startActivityForResult(viewPagerBundle, 0);  // start child activity, result needed
							// 0 is the request code (to determine which activity returned, if more than one)
					//Log.d("DEBUG", "CiddeHowToActivity.tempInitActionButtons");
				}
		});

		
		
		
	} // tempInitActionButtons()
	
	
} // class CiddeHowToActivity

