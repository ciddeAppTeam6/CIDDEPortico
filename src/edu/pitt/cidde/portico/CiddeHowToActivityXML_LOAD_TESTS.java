package edu.pitt.cidde.portico;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CiddeHowToActivityXML_LOAD_TESTS  extends ListActivity implements XMLfileAsStringLoaderINT<String>
{
	String[] values;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		
		//	Set the "button" labels
		values = new String[] {"How to use this app", "How to set up a projector",
				"How to set up a powerpoint", "How to add an XML file to this app"};
		
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
		
		Intent howToBundle = new Intent(edu.pitt.cidde.portico.CiddeHowToActivityXML_LOAD_TESTS.this, edu.pitt.cidde.portico.ViewPagerActivity.class);
		
		if (position==0) { ; }
		if (position==1)
		{
			howToBundle.putExtra("intType", 1250);
			startActivity(howToBundle);
		}
		if (position==2)
		{
			howToBundle.putExtra("intType", 1252);
			startActivity(howToBundle);
		}
		
// =======================================================================
// >>>> XML LOADER EXAMPLE >>>>>>> below here...
// ========================================================================
		if (position==3) // read in an XML document form the server
		{
			// [[[ SHOW AND/OR CREATE PROGRESS BAR HERE]]]
			//new XMLfileToStringLoader(this, new CiddeHowToActivity()).execute("http://ciddeapp.x10.mx/test.xml");
			new XMLfileToStringLoader(this, new CiddeHowToActivityXML_LOAD_TESTS()).execute("http://ciddeapp.x10.mx/LISThowTo.xml");
		}
	
	} // onListItemClick
	
	
	// PROCESS the results of retrieved XML document
	// =============================================
	@Override
	public void onFinishedDownload(String result) // This gets run after return of an XML document
	{
		String[] titles = null;
		String[] urls = null;
		if (null != result)
		{
			Log.i("DEBUG", "http OUTPUT= " + result);

			// parse the document now...
			ParseXMLtoCiddeList xParse = new ParseXMLtoCiddeList(result); // prep the parsre <<<<DO FOR PROD
			if (xParse.ParseXML()) // parse went OK, so we can extract out the lists
			{	
				titles = xParse.getTitleList(); // go parse the xml list to the arrays
				urls = xParse.getUrlList();
				Log.i("DEBUG", "parse complete");
			}
			else
			{   // parse did not go ok, so do something to handle the failure
				Log.i("DEBUG", "failed final parse of xml file");
			}
		}
		else // nothing returned form xml web query.
			Log.i("DEBUG", "failed-no data returned from web query");
		
		// [[[AT THIS POINT titles[] contains the list titles, and [urls] contains the urls they point to]]]
		
		Log.i("DEBUG", "xml Processing complete");
		
		// [[[ HIDE PROGRESS BAR HERE ]]]
	} // onFinishedDownload()
	
	
	// PROCESS any progress bar updates  
	// =================================
	@Override
	public void onProgressUpdate(Integer[] progress)
	{
		// progress is a # from 0 to 100 (i.e. 100%) to signify how much progresss has been made
		// while downloading the XML file.  NOTE: the value of progress, right now, is currently
		// invalid (work in progress)

		// [[[ UPDATE PROGRESS BAR HERE ]]]
		
		Log.i("DEBUG", "PROGRESS = " + progress[0]); // use this for a progress bar
	} // onProgressUpdate()
}
