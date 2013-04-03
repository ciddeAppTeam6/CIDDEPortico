package edu.pitt.cidde.portico;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

// MAIN
public class CiddeBrowseRooms extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browse_rooms);

		final Button button1 = (Button) findViewById(R.id.room1);
		button1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent howToIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);
				startActivity(howToIntent);

			}
		});

		final Button button2 = (Button) findViewById(R.id.room2);
		button2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent howToIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);
				startActivity(howToIntent);

			}
		});

		final Button button3 = (Button) findViewById(R.id.room3);
		button3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				Intent howToIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);
				startActivity(howToIntent);

			}
		});
	}// end onCreate method

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_cidde_main, menu);
		return true;
	}// end onCreateOptionsMenu method

}// end DummyBrowseActivity class
