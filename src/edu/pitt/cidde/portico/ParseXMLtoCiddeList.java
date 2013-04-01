package edu.pitt.cidde.portico;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.util.Log;

public class ParseXMLtoCiddeList {

	private String xmlToParse;
	private List<String> listTitles;
	private List<String> listUrls;

	
	// CONSTRUCTOR(S)
	// ==============
	public ParseXMLtoCiddeList(String xmlToParse) 
	{
		this.xmlToParse = xmlToParse; // note the string we want to parse (i.e. from a raw XML file...)
	}
	
	
	// Return title list as an array
	// =============================
	public String[] getTitleList()
	{
		Log.i("DEBUG","titles" + listTitles.size());
		
		return listTitles.toArray(new String[listTitles.size()]);
	}

	
	// Return title list's corresponding url string array
	// ==================================================
	public String[] getUrlList()
	{
		Log.i("DEBUG","titles" + listUrls.size());
		return listUrls.toArray(new String[listUrls.size()]);
	}
	
	
	// Parse the xmlToParse string into listTitles and listUrls
	// ========================================================
	public boolean ParseXML() //throws XmlPullParserException, IOException
	{
		boolean status = true;
		
		XmlPullParserFactory factory;
		try {
			factory = XmlPullParserFactory.newInstance();
			factory.setNamespaceAware(true);
			XmlPullParser xpp = factory.newPullParser(); // thows XmlPullParserException
	
			// prep to parse string
			// --------------------
			xpp.setInput(new StringReader(xmlToParse)); // thows XmlPullParserException
			int eventType = xpp.getEventType(); 	// thows XmlPullParserException
		
			listTitles = new ArrayList<String>();
			listUrls = new ArrayList<String>();
			// from: http://developer.android.com/reference/org/xmlpull/v1/XmlPullParser.html
			
			int state = 0;	// 0 = off, 1= next text will be a list title (CSTITLE),  2=next text will be a URL (CSURL)  
			
			// parse out the tags until we reach the end of the document
			// ---------------------------------------------------------
			while (eventType != XmlPullParser.END_DOCUMENT) // until no more events are available
			{
				// START DOCUMENT
				// --------------
				if (eventType == XmlPullParser.START_DOCUMENT)  // An XML Start tag was read
				{
					Log.i("DEBUG","START_DOCUMENT");
					state = 0;
				}
				
				
				// START TAG
				// ---------
				else if (eventType == XmlPullParser.START_TAG) // An XML Start tag was read
				{
					if (xpp.getName().toUpperCase(Locale.getDefault()).equals("CCTITLE"))
						state = 1;
					else if (xpp.getName().toUpperCase(Locale.getDefault()).equals("CCURL"))
						state = 2;
					else state = 0; // reset the state - all other cases 
					//Log.i("DEBUG","Start_tag=<" + xpp.getName() + ">") ;
				} // Got a START tag
				
				// TEXT
				// ----
				else if (eventType == XmlPullParser.TEXT) // Text content was read; the text content can be retrieved using the getText() method. (when in validating mode next() will not report ignorable whitespace, use nextToken() instead) 
				{ 
					if (state == 1) listTitles.add(xpp.getText()); //add the title
					if (state == 2) listUrls.add(xpp.getText()); // add the urls
					state = 0; // only one text allowed
					// Log.i("DEBUG","Text=[" + xpp.getText() + "]");
				} // got TEXT
				
				// END TAG
				// -------
				else if (eventType == XmlPullParser.END_TAG)
				{
					Log.i("DEBUG","End_tag=<" + xpp.getName() + ">"); // an end tag was read
					state = 0; // All end tagas reset the state
				}
				
				
				// go read the next parsing event
				// ------------------------------
				eventType = xpp.next(); // thows XmlPullParserException, IOException
			}  // loop until the end of the xml file
			Log.i("DEBUG","END_DOCUMENT");

			
		} catch (XmlPullParserException e) {
			e.printStackTrace();
			status = false;
		}  // thows XmlPullParserException
		catch (IOException e) {
			e.printStackTrace();
			status = false;
		}

		// return SUCCESS or FAILURE (if failure, then listTitles andlistUrl's are not valid)
		// ----------------------------------------------------------------------------------
 		return status; // true=success, false=failure
	} // pullParser
} // ParseXMLtoCiddeList


