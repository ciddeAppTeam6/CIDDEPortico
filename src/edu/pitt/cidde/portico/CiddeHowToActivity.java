package edu.pitt.cidde.portico;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CiddeHowToActivity extends ListActivity
{
	String[] values;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		//	Set the "button" labels
		values = new String[] {"How to use this app", "How to set up a projector"};
		
//		Define the array adapter
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
		
//		Assign adapter to list view
		setListAdapter(adapter);
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) 
	{
		super.onListItemClick(l, v, position, id);
		String usersChoice = values[position];
		
		Intent howToBundle = new Intent(edu.pitt.cidde.portico.CiddeHowToActivity.this, edu.pitt.cidde.portico.ViewPagerActivity.class);
		/*String xmlDocToRead = "www.cidde.pitt.edu/cidde_app/howtos/12345_HowTo_set_up_a_projector.xml";
		howToBundle.putExtra("urlOrPath", xmlDocToRead);
		howToBundle.putExtra("pathType", position);*/
		
		if (position==1)
		{
			howToBundle.putExtra("intType", 1250);
			startActivity(howToBundle);
		}
		
		 
		
	}
} // class CiddeHowToActivity

