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
public class EquipmentInfoActivity extends Activity {

	// Variables
	private Button report_problem_equip_button;
	private Button howto_setup_equip_button;
	private Button order_equip_button;

	// On Create
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_equipment_info);

		// Report Button
		report_problem_equip_button = (Button) findViewById(R.id.report_problem_equip_button);
		report_problem_equip_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(
						Intent.ACTION_VIEW,
						Uri.parse("https://pitt.wufoo.com/forms/cidde-classroom-technology-problem-report-form/")));
			} // end of listener method
		}); // end of anon listener class

		// How To Button
		howto_setup_equip_button = (Button) findViewById(R.id.howto_setup_equip_button);
		howto_setup_equip_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent equipHowTo = new Intent(EquipmentInfoActivity.this, ViewPagerActivity.class);
				equipHowTo.putExtra("intType", 1250);
				startActivity(equipHowTo);
			} // end of listener method
		}); // end of anon listener class

		// Order Button
		order_equip_button = (Button) findViewById(R.id.order_equip_button);
		order_equip_button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(Intent.ACTION_VIEW, Uri
						.parse("http://www.cidde.pitt.edu/-35")));
			} // end of listener method
		}); // end of anon listener class
	} // end of on create

	// Options Menu
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_equipment_info, menu);
		return true;
	} // end of on create options

} // end of class (activity)
