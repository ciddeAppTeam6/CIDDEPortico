package edu.pitt.cidde.portico;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

// MAIN
public class CiddeBrowseRooms extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_browse_rooms);

		final Button button113 = (Button) findViewById(R.id.czech_button);
		button113.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 113);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button116 = (Button) findViewById(R.id.italian_button);
		button116.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 116);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button119 = (Button) findViewById(R.id.german_button);
		button119.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 119);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button121 = (Button) findViewById(R.id.hungarian_button);
		button121.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 121);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button126 = (Button) findViewById(R.id.polish_button);
		button126.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 126);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button127 = (Button) findViewById(R.id.irish_button);
		button127.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 127);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button129 = (Button) findViewById(R.id.lith_button);
		button129.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 129);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button130 = (Button) findViewById(R.id.romanian_button);
		button130.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 130);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button135 = (Button) findViewById(R.id.swedish_button);
		button135.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 135);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button136 = (Button) findViewById(R.id.chinese_button);
		button136.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 136);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button137 = (Button) findViewById(R.id.greek_button);
		button137.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 137);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button139 = (Button) findViewById(R.id.scottish_button);
		button139.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 139);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button142 = (Button) findViewById(R.id.yugoslav_button);
		button142.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 142);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button144 = (Button) findViewById(R.id.english_button);
		button144.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 144);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button149 = (Button) findViewById(R.id.french_button);
		button149.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 149);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button151 = (Button) findViewById(R.id.norwegian_button);
		button151.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 151);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button153 = (Button) findViewById(R.id.russian_button);
		button153.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 153);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button160 = (Button) findViewById(R.id.syria_button);
		button160.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 160);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button314 = (Button) findViewById(R.id.austrian_button);
		button314.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 314);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button317 = (Button) findViewById(R.id.jap_button);
		button317.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 317);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button319 = (Button) findViewById(R.id.armenian_button);
		button319.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 319);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button327 = (Button) findViewById(R.id.india_button);
		button327.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 327);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button328 = (Button) findViewById(R.id.early_am_button);
		button328.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 328);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button330 = (Button) findViewById(R.id.africa_button);
		button330.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 330);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button337 = (Button) findViewById(R.id.israel_button);
		button337.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 337);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button341 = (Button) findViewById(R.id.ukranian_button);
		button341.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 341);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button

		final Button button342 = (Button) findViewById(R.id.welsh_button);
		button342.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {

				// DETERMINE ROOM
				Bundle extras = new Bundle();
				extras.putInt("room", 342);

				Intent classroomIntent = new Intent(
						edu.pitt.cidde.portico.CiddeBrowseRooms.this,
						edu.pitt.cidde.portico.ClassRoomInfoActivity.class);

				classroomIntent.putExtras(extras);

				startActivity(classroomIntent);
			}
		}); // end of button
	}// end onCreate method

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_cidde_main, menu);
		return true;
	}// end onCreateOptionsMenu method

	// when a button in the options menu is clicked
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// main menu intent
		Intent mainIntent = new Intent(this, CiddeMainActivity.class);
		startActivity(mainIntent);
		return true;
	} // end of onOptionsItemSelected

}// end DummyBrowseActivity class
