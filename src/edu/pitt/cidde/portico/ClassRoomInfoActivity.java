package edu.pitt.cidde.portico;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

// MAIN
public class ClassRoomInfoActivity extends Activity {

	private Button report_problem_classroom_button;
	private Button order_classroom_button;
	private Button more_button;

	// On Create
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// DETERMINE ROOM
		Bundle extras = this.getIntent().getExtras();

		switch (extras.getInt("room")) {

		case 113:
			setContentView(R.layout.czech_info);
			break;
		case 116:
			setContentView(R.layout.italian_info);
			break;
		case 119:
			setContentView(R.layout.german_info);
			break;
		case 121:
			setContentView(R.layout.hungarian_info);
			break;
		case 126:
			setContentView(R.layout.polish_info);
			break;
		case 127:
			setContentView(R.layout.irish_info);
			break;
		case 129:
			setContentView(R.layout.lithuanian_info);
			break;
		case 130:
			setContentView(R.layout.romanian_info);
			break;
		case 135:
			setContentView(R.layout.swedish_info);
			break;
		case 136:
			setContentView(R.layout.chinese_info);
			break;
		case 137:
			setContentView(R.layout.greek_info);
			break;
		case 139:
			setContentView(R.layout.scottish_info);
			break;
		case 142:
			setContentView(R.layout.yugoslav_info);
			break;
		case 144:
			setContentView(R.layout.english_info);
			break;
		case 149:
			setContentView(R.layout.french_info);
			break;			
		case 151:
			setContentView(R.layout.norwegian_info);
			break;
		case 153:
			setContentView(R.layout.russian_info);
			break;
		case 160:
			setContentView(R.layout.syria_info);
			break;
		case 314:
			setContentView(R.layout.austrian_info);
			break;
		case 317:
			setContentView(R.layout.jap_info);
			break;
		case 319:
			setContentView(R.layout.armenian_info);
			break;
		case 327:
			setContentView(R.layout.indian_info);
			break;
		case 328:
			setContentView(R.layout.early_am_info);
			break;
		case 330:
			setContentView(R.layout.african_info);
			break;
		case 337:
			setContentView(R.layout.israel_info);
			break;
		case 341:
			setContentView(R.layout.ukranian_info);
			break;
		case 342:
			setContentView(R.layout.welsh_info);
			break;
		} // end of switch

		// Report Button
		report_problem_classroom_button = (Button) findViewById(R.id.report_problem_classroom_button);
		report_problem_classroom_button
				.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						startActivity(new Intent(
								Intent.ACTION_VIEW,
								Uri.parse("https://pitt.wufoo.com/forms/cidde-classroom-technology-problem-report-form/")));
					} // end of listener method
				}); // end of anon listener class

		// Order Button
		order_classroom_button = (Button) findViewById(R.id.order_classroom_button);
		order_classroom_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.cidde.pitt.edu/-35")));
			} // end of listener method
		}); // end of anon listener class

		// More Button
		more_button = (Button) findViewById(R.id.more_button);
		more_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.pitt.edu/~natrooms/")));
			} // end of listener method
		}); // end of anon listener class
		
	} // end of on create

	// Options Menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_cidde_main, menu);
		return true;
	}

} // end of class (activity)
