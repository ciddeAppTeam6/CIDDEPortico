package edu.pitt.cidde.portico;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CiddeTroubleshootActivity extends ListActivity 
{
	String[] options;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);

		//	Set the "button" labels
		options = getResources().getStringArray(R.array.troubleshoot_options);
		
//		Assign adapter to list view
		this.setListAdapter(new ArrayAdapter<String>(this, R.layout.list_row, R.id.label, options));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) 
	{
		super.onListItemClick(l, v, position, id);
		
		Intent troubleshootBundle = new Intent(edu.pitt.cidde.portico.CiddeTroubleshootActivity.this, edu.pitt.cidde.portico.ViewPagerActivity.class);
		troubleshootBundle.putExtra("intType", 1251);
		 
		if (position==0)
			startActivity(troubleshootBundle);
	}
}
