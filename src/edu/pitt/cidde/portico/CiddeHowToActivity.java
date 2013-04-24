package edu.pitt.cidde.portico;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CiddeHowToActivity extends ListActivity {
	
	String[] values;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Set the "button" labels
		values = new String[] { "Navigate this app",
				"Set up a projector", "Set up a powerpoint" };
		values = getResources().getStringArray(R.array.how_to_options);

		// Define the array adapter
		this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_row,
				R.id.label, values));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent howToBundle = new Intent(
				edu.pitt.cidde.portico.CiddeHowToActivity.this,
				edu.pitt.cidde.portico.ViewPagerActivity.class);

		if (position == 0)
		{
			howToBundle.putExtra("intType", 1253);
			startActivity(howToBundle);
		}
		else if (position == 1) 
		{
			howToBundle.putExtra("intType", 1250);
			startActivity(howToBundle);
		}

		else if (position == 2) 
		{
			howToBundle.putExtra("intType", 1252);
			startActivity(howToBundle);
		}
		
		else if (position == 3)
		{
			howToBundle.putExtra("intType", 1254);
			startActivity(howToBundle);
		}
		
		else if (position == 4)
		{
			howToBundle.putExtra("intType", 1255);
			startActivity(howToBundle);
		}
		
		else if (position == 5)
		{
			howToBundle.putExtra("intType", 1256);
			startActivity(howToBundle);
		}
		
		else if (position == 6)
		{
			howToBundle.putExtra("intType", 1257);
			startActivity(howToBundle);
		}
		
		else if (position == 7)
		{
			howToBundle.putExtra("intType", 1258);
			startActivity(howToBundle);
		}
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater()
				.inflate(R.menu.activity_cidde_main, menu);
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
} // class CiddeHowToActivity

