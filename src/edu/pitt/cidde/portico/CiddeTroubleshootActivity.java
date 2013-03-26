package edu.pitt.cidde.portico;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CiddeTroubleshootActivity extends ListActivity 
{
	String[] values;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		//	Set the "button" labels
		values = new String[] {"Powerpoint", "etc.."};
		
//		Define the array adapter
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
		
//		Assign adapter to list view
		setListAdapter(adapter);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) 
	{
		super.onListItemClick(l, v, position, id);
		
		Intent troubleshootBundle = new Intent(edu.pitt.cidde.portico.CiddeTroubleshootActivity.this, edu.pitt.cidde.portico.ViewPagerActivity.class);
		troubleshootBundle.putExtra("pathType", position/* * 200*/);
		 
		startActivity(troubleshootBundle);
	}
}
