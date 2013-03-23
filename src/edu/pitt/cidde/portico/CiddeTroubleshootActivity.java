package edu.pitt.cidde.portico;

import android.app.ListActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CiddeTroubleshootActivity extends ListActivity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		//	Set the "button" labels
		String[] values = new String[] {"Powerpoint", "etc.."};
		
//		Define the array adapter
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
		
//		Assign adapter to list view
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_cidde_troubleshoot, menu);
		return true;
	}

}
