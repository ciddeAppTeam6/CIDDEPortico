package edu.pitt.cidde.portico;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CiddeHowToActivity extends ListActivity {
	String[] values;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Set the "button" labels
		values = new String[] { "How to use this app",
				"How to set up a projector", "How to set up a powerpoint" };
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

		if (position == 1) {
			howToBundle.putExtra("intType", 1250);
			startActivity(howToBundle);
		}

		if (position == 2) {
			howToBundle.putExtra("intType", 1252);
			startActivity(howToBundle);
		}
	}
} // class CiddeHowToActivity

