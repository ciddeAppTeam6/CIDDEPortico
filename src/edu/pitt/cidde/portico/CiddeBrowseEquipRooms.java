package edu.pitt.cidde.portico;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

// MAIN
public class CiddeBrowseEquipRooms extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browse_equip_class);

		final Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent howToIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseEquipRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);
				startActivity(howToIntent);

			}
		});

		final Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent howToIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseEquipRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);
				startActivity(howToIntent);

			}
		});

		final Button button3 = (Button) findViewById(R.id.button3);
		button3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent howToIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseEquipRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);
				startActivity(howToIntent);

			}
		});

		final Button button4 = (Button) findViewById(R.id.button4);
		button4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent howToIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseEquipRooms.this,
						edu.pitt.cidde.portico.EquipmentInfoActivity.class);
				startActivity(howToIntent);

			}
		});

		final Button button5 = (Button) findViewById(R.id.button5);
		button5.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent howToIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseEquipRooms.this,
						edu.pitt.cidde.portico.EquipmentInfoActivity.class);
				startActivity(howToIntent);

			}
		});

	}// end onCreate method

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dummy_browse, menu);
		return true;
	}// end onCreateOptionsMenu method

}// end DummyBrowseActivity class
