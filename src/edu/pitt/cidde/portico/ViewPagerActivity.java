package edu.pitt.cidde.portico;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

// ******NOTE!****** IF THE FOLLOWING IMPORTS (FROM ABOVE) ARE GIVING YOU ERRORS...
// 		import android.support.v4.app.Fragment;
// 		import android.support.v4.app.FragmentActivity;
// 		import android.support.v4.app.FragmentManager;
// 		import android.support.v4.app.FragmentPagerAdapter;
// 		import android.support.v4.view.ViewPager;
// Try the following (in the SDK manager):
//  Window>Android SDK manager>Extras>"android support library"
//                             Tools>(all tools - specifically the platform tools)   
//	(then select and download/install these SDKs into eclipse)
// ...at the very least, the platform tools may be needed. 
// In addition, as of writing this, I had the following API's installed:
//   API 7, 8, 10, and part of 17 (only the "sdk platform" and the "ARM EABI v7a System Image" sections) 
// Dave B.

// do: add logic to direct intent info to fragment
//     add to fragment to support 2nd screen
//     add logic or at least PREP logic to send intent data to your activity
//     adjust naming conventions, add some comments and do some cleanup (basic only)

public class ViewPagerActivity extends FragmentActivity {
	// int msgFromChildArray[]; // holds OUTGOING data from child activity back
	// to parent

	// INCOMING INTENT data from parent. These will be populated during the
	// onCreate
	// -------------------------------------------------------------------------------
	private static int parentIntentViewType;
			// 0 = (no intent passed)
			// 1 = display a URL (must also use parentIntentViewURL to supply the URL)
			// 2 = (unused)
			// 3 = (unused)
			// ...
			// 101 = display the "How to connect a PC to a projector" tutorial
			// 102 = display the "how to use this app" tutorial
	private static String parentIntentViewURL; // IF (parentIntentViewType == 1) then
									// this
			// must contain the URL/web address of the XML document to display,
			// in the following format:
			// "www.pitt.edu/someDirectory/someSubDirecory/displayThisDoc.xml"
		
			// OUTGOING RETURN RESULT data from child back to parent. These will be
			// populated
			// when the activity ends, and returns to parent

	
	int msgFromChildReturnType; // The RETURN type going back to the parent
			// 1 = normal return to parent (i.e. just return to parent activity)
			// 2 = return to HOME activity (will require parent to return with another
			// intent)
			// 3 = exit program [MAY NOT NEED THIS] [do not use - user may wish to return to page
			//		they were viewing previously)
			// 4 = ??

	// >>>> OLD >> REMOVE WHEN DONE>>>>
	// String msgFromParentURLtoShow[]; // holds INCOMING URL to be shown letter
	// data from parent activity
	// int msgFromChildLetterData[]; // holds OUTGOING data from child activity
	// back to parent
	// int userLetterData[]; // REMOVE WHEN DONE
	// <<<<<<<

	private static final boolean DOING_OZ_PROTOTYPE = false;// set to TRUE to force
						// wizard of oz prootype.  Set to FALSE if we want to
						// run normally via loading XML files
	
	
	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	SectionsPagerAdapter mSectionsPagerAdapter;

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager; // This will be used to host the various section
							// contents
	// =============================================================================
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_pager);

		// set the TITLE of the screen - for wizard of oz testing only
		setTitleColor(Color.parseColor("#a0a0a0")); /// this sets the TITLE color for the activity
		setTitle("How to connec a PC to the Projector");
	    View title = getWindow().findViewById(android.R.id.title);
        View titleBar = (View) title.getParent();
        titleBar.setBackgroundColor(Color.parseColor("#202020"));
		
				
				
		// Load up the intent data passed in from the parent activity
		parentIntentViewType = getIntent().getIntExtra("intViewType", 0); // formerly intLetterData
		parentIntentViewURL = getIntent().getStringExtra("strViewURL"); // new
		//parentIntentViewType = 102; /// FORCE DISPLAY OF HOW TO SET UP ???
		
		// force portrait orientation.  Do this for now as...
		// 1) it is a quick fix to get around the lost image issue with changing to landscape and/or
		// 2) In the FUTURE, it will be difficult for CIDDE to contend with creating XML pages
		//    that would support two orientations.  By forcing it to portrait, it eliminates this issue.
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // only accept portrait
		// alternately, add the following to the manifiest for this activity to lock portrait:
		//		android:screenOrientation="portrait"
		//		android:configChanges="orientation|keyboardHidden" 
     
	
		
		
		
		// Log.i("DEBUG","onCreate-1");

		// Create the adapter that returns the fragment for each of the pages
		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

		// Log.i("DEBUG","onCreate-2");

		// Set up the ViewPager with the sections adapter.
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		mViewPager.setOffscreenPageLimit(0);

		// Log.i("DEBUG","onCreate-3");

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_view_pager, menu);
		// Log.i("DEBUG","onCreateOptionsMenu");
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.return_home: // return to HOME SCREEN
			//msgFromChildReturnType = 2;
			// RETURN TO THE MAIN VIEW after (after intent)
			
			Bundle bundle = new Bundle();
			bundle.putInt("intReturnAction", 2);
			Log.d("DEBUG", "sending back... 2");
			Intent mIntent = new Intent();
			mIntent.putExtras(bundle);
			setResult(RESULT_OK, mIntent);
			finish();
			
			//Intent intent = new Intent(); // create intent
			//intent.putExtra("intReturnAction", 2); // msgFromChildReturnType);
						// add on the return data

			//setResult(RESULT_OK, intent);
			//finish();
			return true;
			
			
		case R.id.search_equipment: // search for equipment
			// [ go search equipment here ]
			return true;
		case R.id.scan_qr_code: // scan QR code
			// [ go scan qr code here ]
			return true;
		case R.id.app_help: // get help with app
			// [ go view the help pages ]
			return true;
		default:
			return super.onOptionsItemSelected(item);
		} // switch()
	} // onOptionsItemSelected()

	
	// ================================================================================
	// PURPOSE: Return a fragment corresponding to one of the
	// Sections/tabs/pages
	// (A {@link FragmentPagerAdapter} that will return a fragment for one of
	// the sections, tabs or pages.)
	// ================================================================================
	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
					Log.i("DEBUG", "SEctionsPagerAdapter");
		}

		@Override
		public Fragment getItem(int position) {
			// getItem is called to instantiate the fragment for the given page.
			// Return a OzPrototypeViewPagerFragment1 (defined as a static inner
			// class below) with the page number as its lone argument.

			Bundle args = new Bundle();
			
			// If we are doing the OZ prototype, then we have a copule of special
			// hard-coded pages built in.  Do those...
			// otherwise, run the standard XML viewr...
			Fragment fragment;
			if (DOING_OZ_PROTOTYPE == true){
				if (parentIntentViewType == 101)	// 101 = display the "How to connect a PC to a projector" tutorial
				{
					fragment = new OzPrototypeViewPagerFragment1();
					args.putInt(OzPrototypeViewPagerFragment1.ARG_SECTION_NUMBER, position + 1);
				} else if (parentIntentViewType == 102) // 102 = display the "how to use this app" tutorial
				{
					fragment = new OzPrototypeViewPagerFragment2();
					args.putInt(OzPrototypeViewPagerFragment2.ARG_SECTION_NUMBER, position + 1);
				} else // just do the other one...
				{
					fragment = new ViewPagerXMLfragment();
					args.putInt(ViewPagerXMLfragment.ARG_SECTION_NUMBER, position + 1);
				}
			} else // RUN NORMALLY
			{
				fragment = new OzPrototypeViewPagerFragment1();
				args.putInt(OzPrototypeViewPagerFragment1.ARG_SECTION_NUMBER, position + 1);
			}
			
			fragment.setArguments(args);
			return fragment;
		}

		//  DETERMINE THE NUMBE OF PAGES WE ARE TO DISLAY
		// ---------------------------------------------
		@Override
		public int getCount() {
			// Show 3 total pages.
			// Log.i("DEBUG","getcount");
			//  return 4; <<< <was this previously
			
			int whatPageCnt = 1; // default to 1
			
			if (DOING_OZ_PROTOTYPE == true)
				if (parentIntentViewType == 101)	// 101 = display the "How to connect a PC to a projector" tutorial
					whatPageCnt = 4; // the # of pages this needs
				else if (parentIntentViewType == 102) // 102 = display the "how to use this app" tutorial
					whatPageCnt = 7;
				else // just do the other one...
					whatPageCnt = 7;

			else // RUN NORMALLY
				whatPageCnt = 4;
	
			return whatPageCnt;
			
		} // getCount()
		
		
		@Override
		public CharSequence getPageTitle(int position) {
			

			// THE FOLLOIWNG IS FOR WIZARD OF OZ TESTING >>>ONLY<<<!!!!!
			// AFTER COMPLETE, these values will instead be dynmacially loaded via xml
			// (yes, this is NASTY but it is temporary....)
			if (DOING_OZ_PROTOTYPE == true)
			{
				if (parentIntentViewType == 101)	// 101 = display the "How to connect a PC to a projector" tutorial
				{
					Log.i("DEBUG", "getPagetitle");
					switch (position) {
					case 0:
						return "Step 1";
					case 1:
						return "Step 2";
					case 2:
						return "Step 3";
					case 3:
						return "Step 4";
					}
					return "Who Knows?"; // return null;			
				}
				else if (parentIntentViewType == 102) // 102 = display the "how to use this app" tutorial
				{
					Log.i("DEBUG", "getPagetitle");
					switch (position) {
					case 0:
						return "Start Here";
					case 1:
						return "Page 1";
					case 2:
						return "Page 2";
					case 3:
						return "Page 3";
					case 4:
						return "Page 4";
					case 5:
						return "Page 5";
					case 6:
						return "End of Tutorial";					
					}
					return "Who Knows?"; // return null;				
				} 
				else // just do the other one...
				{
					Log.i("DEBUG", "getPagetitle");
					switch (position) {
					case 0:
						return "Step 1";
					case 1:
						return "Step 2";
					case 2:
						return "Step 3";
					case 3:
						return "Step 4";
					case 4:
						return "Step 5";
					case 5:
						return "Step 6";						
					}
					return "Who Knows?"; // return null;				
				}
			}
			else // RUN NORMALLY
			{
				Log.i("DEBUG", "getPagetitle");
				switch (position) {
				case 0:
					return "Step 1";
				case 1:
					return "Step 2";
				case 2:
					return "Step 3";
				case 3:
					return "Step 4";					
				}
				return "Who Knows?"; // return null;			
			} // CharSequence()
		}
	} // Class SectionsPagerAdapter()

	
	// ================================================================================
	// PURPOSE: This is the core fragment for this activity that displays the
	// "content" from the XML documents.
	// ================================================================================
	public static class ViewPagerXMLfragment extends Fragment {
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public ViewPagerXMLfragment() {
			Log.i("DEBUG", "OzPrototypeViewPagerFragment1");
		}

		// @Override
		// public void onSaveInstanceState(final Bundle outState) {
		// // super.onSaveInstanceState(outState);
		// }

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			
			// do not waste time to make a view if it will not be displayed
			if (container == null) { return null; }

			// Set up the layout
			// -----------------
			LinearLayout llInner;
			llInner = new LinearLayout(getActivity());
			llInner.setOrientation(LinearLayout.VERTICAL);
			// llInner.setBackgroundColor(Color.rgb(255,128,128));
			llInner.setPadding(10, 5, 10, 5);
			// llInner.setBackgroundResource(R.layout.view_pager_background);
			llInner.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			// parmas=width, height, weight... i.e. LayoutParams.MATCH_PARENT,
			// LayoutParams.MATCH_PARENT, 1f

			// NOW FILL IT... 
			// -----------
			TextView textview;
			textview = new TextView(getActivity());
			textview.setText("HOW TO: Connect a PC to the Projector");
			textview.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			llInner.addView(textview);

			int whatPage = getArguments().getInt(ARG_SECTION_NUMBER) % 2;
	
			switch (whatPage) {
			case 0:
				textview = new TextView(getActivity());
				textview.setText("EVEN NUMBERED PAGE of future XML viewer");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);

				break;
			case 1:
				textview = new TextView(getActivity());
				textview.setText("ODD NUMBERED PAGE of future XML viewer");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);
				break;
			default:
				textview = new TextView(getActivity());
				textview.setText("what page is this? of future XML viewer");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);
				break;

			} // work the various pages
			

			// ------------------------
			// REMOVE THE FOLLOIWNG AFTER DEBUG... >>>> 
			String miscText;		
			miscText = 
				"PLEASE READ: FOR OUR WIZZARD OF OZ TESTING... " + 
			" IF YOU WANT the viewpager to display the pages for " + 
			" \"HOW TO plug a VGA cable into a projector\", you MUST add the following to your intent: " +
			" 			yourIntentObject.putExtra(\"intViewType\", 101);   Or,  if  you want " + 
			" to display the HOW TO USE THIS APP instructions, then instead add : " + 
			" 			yourIntentObject.putExtra(\"intViewType\", 102);   -Dave-";
			
			textview = new TextView(getActivity());
			textview.setText(miscText);
			textview.setTextColor(Color.RED);
			textview.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			llInner.addView(textview);
			// <<<<REMOVE AFTER DEBUG
			// ------------------------
			
			
			ScrollView scroller = new ScrollView(getActivity());
			scroller.addView(llInner);
			scroller.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

			scroller.setOverScrollMode(ScrollView.OVER_SCROLL_IF_CONTENT_SCROLLS);

			// Encapsulate in a linear layout
			LinearLayout llOuter;
			llOuter = new LinearLayout(getActivity());
			llOuter.setOrientation(LinearLayout.VERTICAL);
			llOuter.setBackgroundColor(Color.rgb(255, 128, 128));
			llOuter.setPadding(10, 5, 10, 5);
			llOuter.setBackgroundResource(R.layout.view_pager_background);
			llOuter.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			// parmas=width, height, weight... i.e. LayoutParams.MATCH_PARENT,
			// LayoutParams.MATCH_PARENT, 1f

			llOuter.addView(scroller);

			return llOuter; // return the linear layout contained in a
							// scrollview
		} // onCreateView()		
	} // CLASS ViewPagerXMLfragment()
	
	

	// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
	// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
	// THE FOLLOWING IS FOR WIZARD-OF-OZ PROTOTYPING ONLY.  IT WILL EVENTUALLY BE
	// LOADED FROM AN XML DOCUMENT FROM A SERVER
	// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
	// * * * *   DISPLAY HOW TO CONNECT A PC TO A PROJECTOR PAGES  * * * * * * * * * 
	// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 	
	// ================================================================================
	// PURPOSE: This is the core fragment for this activity that displays the
	// "content" from the XML documents.
	// ================================================================================
	public static class OzPrototypeViewPagerFragment1 extends Fragment { 
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public OzPrototypeViewPagerFragment1() {
			Log.i("DEBUG", "OzPrototypeViewPagerFragment1");
		}

		// @Override
		// public void onSaveInstanceState(final Bundle outState) {
		// // super.onSaveInstanceState(outState);
		// }

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			// ------------------------
			// do not waste time to make a view if it will not be displayed
			if (container == null) {
				return null;
			}

			// method 0: USE THE LINEARLAYOUT
			// --------------------------------
			LinearLayout llInner;
			llInner = new LinearLayout(getActivity());
			llInner.setOrientation(LinearLayout.VERTICAL);
			// llInner.setBackgroundColor(Color.rgb(255,128,128));
			llInner.setPadding(10, 5, 10, 5);
			// llInner.setBackgroundResource(R.layout.view_pager_background);
			llInner.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			// parmas=width, height, weight... i.e. LayoutParams.MATCH_PARENT,
			// LayoutParams.MATCH_PARENT, 1f

			// NOW FILL IT... (TEMPORARY prototype)
			// -----------
			TextView textview;
			Button button;
			ImageView imgView;
			//textview = new TextView(getActivity());
			//textview.setText("HOW TO: Connect a PC to the Projector");
			//textview.setLayoutParams(new LinearLayout.LayoutParams(
			//			LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			//llInner.addView(textview);

			switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
			case 1:
				imgView = new ImageView(getActivity());
				imgView.setImageResource(R.drawable.vga_cable);
				imgView.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, (int) (0.7 * container
								.getMeasuredWidth())));
				// imgView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				llInner.addView(imgView);

				textview = new TextView(getActivity());
				textview.setText("Locate the VGA cable.  It is the one that has 15 pins.");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);
				break;

			case 2:
				imgView = new ImageView(getActivity());
				imgView.setImageResource(R.drawable.laptop_vga_connection);
				imgView.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, (int) (0.7 * container
								.getMeasuredWidth())));
				// imgView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				llInner.addView(imgView);

				textview = new TextView(getActivity());
				textview.setText("Plug one end of the cable into the back of your PC");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);
				break;

			case 3:
				imgView = new ImageView(getActivity());
				imgView.setImageResource(R.drawable.vga_inputs);
				imgView.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, (int) (0.7 * container
								.getMeasuredWidth())));
				// imgView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				llInner.addView(imgView);

				textview = new TextView(getActivity());
				textview.setText("Plug the other end of the cable into the audio video PC1 port in the cabinet");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);
				break;

			case 4:
				imgView = new ImageView(getActivity());
				imgView.setImageResource(R.drawable.equip_rack);
				imgView.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, (int) (0.7 * container
								.getMeasuredWidth())));
				// imgView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				llInner.addView(imgView);

				textview = new TextView(getActivity());
				textview.setText("Press the ON button on the video cabinet, then press the COMPUTER button");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);

				break;

			default:
				break;
			}

			ScrollView scroller = new ScrollView(getActivity());
			scroller.addView(llInner);
			scroller.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

			// ScrollerView scroller =
			// (ScrollView)findViewById(R.id.scroll_view);
			scroller.setOverScrollMode(ScrollView.OVER_SCROLL_IF_CONTENT_SCROLLS);

			Log.i("DEBUG", "onCreateView fixh4");

			// method 0: USE THE LINEARLAYOUT
			// --------------------------------
			LinearLayout llOuter;
			llOuter = new LinearLayout(getActivity());
			llOuter.setOrientation(LinearLayout.VERTICAL);
			llOuter.setBackgroundColor(Color.rgb(255, 128, 128));
			llOuter.setPadding(10, 5, 10, 5);
			llOuter.setBackgroundResource(R.layout.view_pager_background);
			llOuter.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			// parmas=width, height, weight... i.e. LayoutParams.MATCH_PARENT,
			// LayoutParams.MATCH_PARENT, 1f

			llOuter.addView(scroller);

			return llOuter; // return the linear layout contained in a
							// scrollview

		} // onCreateView()
		
	} // CLASS OzPrototypeViewPagerFragment1

	// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
	// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
	// THE FOLLOWING IS FOR WIZARD-OF-OZ PROTOTYPING ONLY.  IT WILL EVENTUALLY BE
	// LOADED FROM AN XML DOCUMENT FROM A SERVER
	// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 
	// * * * *   DISPLAY HOW TO CONNECT A PC TO A PROJECTOR PAGES  * * * * * * * * * 
	// * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * 	
	// ================================================================================
	// PURPOSE: This is the core fragment for this activity that displays the
	// "content" from the XML documents.
	// ================================================================================
	public static class OzPrototypeViewPagerFragment2 extends Fragment { 
		/**
		 * The fragment argument representing the section number for this
		 * fragment.
		 */
		public static final String ARG_SECTION_NUMBER = "section_number";

		public OzPrototypeViewPagerFragment2() {
			Log.i("DEBUG", "OzPrototypeViewPagerFragment1");
		}

		// @Override
		// public void onSaveInstanceState(final Bundle outState) {
		// // super.onSaveInstanceState(outState);
		// }

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {

			// ------------------------
			// do not waste time to make a view if it will not be displayed
			if (container == null) {
				return null;
			}

			// method 0: USE THE LINEARLAYOUT
			// --------------------------------
			LinearLayout llInner;
			llInner = new LinearLayout(getActivity());
			llInner.setOrientation(LinearLayout.VERTICAL);
			// llInner.setBackgroundColor(Color.rgb(255,128,128));
			llInner.setPadding(10, 5, 10, 5);
			// llInner.setBackgroundResource(R.layout.view_pager_background);
			llInner.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			// parmas=width, height, weight... i.e. LayoutParams.MATCH_PARENT,
			// LayoutParams.MATCH_PARENT, 1f

			// NOW FILL IT... (TEMPORARY prototype)
			// -----------
			TextView textview;
			Button button;
			ImageView imgView;
			textview = new TextView(getActivity());
			
			if (getArguments().getInt(ARG_SECTION_NUMBER) == 1)
				textview.setText("WELCOME to CIDDE Help");
			else
				textview.setText("HOW TO: Use this App");
			textview.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			llInner.addView(textview);

			
			
			
			switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
			case 1:
				textview = new TextView(getActivity());
				textview.setText("Use these buttons to scan a QR code, or to find " + 
				" information about equipment and rooms:");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);

				// button
				button = new Button(getActivity());
				button.setText("What is a QR code?");
				button.setVisibility(View.VISIBLE);
				button.setBackgroundColor(Color.TRANSPARENT);
				button.setTextColor(getResources().getColor(R.drawable.link_looking_button_color));
				button.setOnClickListener(new OnClickListener()
				{   
				    @Override
				    public void onClick(View v)
				    {
				    	Activity activity = getActivity();
						Toast.makeText(activity,
								"A QR code is like a bar code. They look like this...", Toast.LENGTH_SHORT).show();
				    }
				});					
				
				imgView = new ImageView(getActivity());
				imgView.setImageResource(R.drawable.no_image_big_x);
				imgView.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, (int) (0.35 * container
								.getMeasuredWidth())));
				// imgView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				llInner.addView(imgView);

				
				imgView = new ImageView(getActivity());
				imgView.setImageResource(R.drawable.no_image_big_x);
				imgView.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, (int) (0.45 * container
								.getMeasuredWidth())));
				// imgView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				llInner.addView(imgView);
				

				
				textview = new TextView(getActivity());
				textview.setText(" \\/ you can scroll down to navigate too... \\/");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);
		
				textview = new TextView(getActivity());
				textview.setText("1...");
				textview.setTextSize(TypedValue.COMPLEX_UNIT_SP,24);
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);				

				textview = new TextView(getActivity());
				textview.setText("2...");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				textview.setTextSize(TypedValue.COMPLEX_UNIT_SP,34);
				llInner.addView(textview);
				
				textview = new TextView(getActivity());
				textview.setText("3...");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				textview.setTextSize(TypedValue.COMPLEX_UNIT_SP,54);
				llInner.addView(textview);
				
				textview = new TextView(getActivity());
				textview.setText("4...");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				textview.setTextSize(TypedValue.COMPLEX_UNIT_SP,84);
				llInner.addView(textview);
				
				
				
				imgView = new ImageView(getActivity());
				imgView.setImageResource(R.drawable.no_image_big_x);
				imgView.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, (int) (0.7 * container
								.getMeasuredWidth())));
				imgView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				//imgView.setGravity(Gravity.CENTER);
				llInner.addView(imgView);
				/*
				 LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(width, height);
					layoutParams.gravity=Gravity.CENTER;
					ImageIcons[i].setLayoutParams(layoutParams);
				 * 				
				 */
				
				textview = new TextView(getActivity());
				textview.setText("<-- (or swipe sidewals to navigate) -->");
				textview.setTypeface(Typeface.DEFAULT_BOLD);
				textview.setGravity(Gravity.CENTER);
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);
				
				break;

			case 2:
				textview = new TextView(getActivity());
				textview.setText("Information Screens:");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);
				
				imgView = new ImageView(getActivity());
				imgView.setImageResource(R.drawable.no_image_big_x);
				imgView.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, (int) (0.7 * container
								.getMeasuredWidth())));
				// imgView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				llInner.addView(imgView);

				textview = new TextView(getActivity());
				textview.setText("Equipment information screens tell you about the specifics of that " + 
						"piece of equipment.   You can als find helpful info on how to use it, " + 
						"as well as submit any bugs you may find.");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);
				
				// TEMP HACKS TO EXPERIMNET WITH HTML IN TEXVIEW... >>>>>>>>>>>>>
				textview = new TextView(getActivity());
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				//textview.setText("<ul><li><code>&lt;b></code> for <b>bold</b> text.</li>" + 
				//		  "<li><code>&lt;i></code> for <i>italic</i> text.</li>" + 
					//	  "<li><code>&lt;u></code> for <u>underline</u> text.</li></ul>");
				textview.setText(Html.fromHtml("<ul><li><code>&lt;b></code> for <b>bold</b> text.</li>" + 
						  "<li><code>&lt;i></code> for <i>italic</i> text.</li>" + 
						  "<li><code>&lt;u></code> for <u>underline</u> text.</li></ul>"));
				llInner.addView(textview);
				
				textview = new TextView(getActivity());
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				textview.setText(Html.fromHtml("<dl><dt>Coffee</dt><dd>- black hot drink</dd><dt>Milk</dt><dd>- white cold drink</dd></dl>"));
				llInner.addView(textview);
				
				textview = new TextView(getActivity());
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				textview.setText(Html.fromHtml("<ol><li>Coffee</li><li>Milk</li></ol>"));
				llInner.addView(textview);

				textview = new TextView(getActivity());
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				textview.setText(Html.fromHtml("This <b>is</b> <i>all</i> <sub>in</sub> <u><sup>one</sup></u> <a href=\"http://google.com\">TextView</a>."));
				textview.setMovementMethod(LinkMovementMethod.getInstance()); /// now make the link CLICKABLE
				
				llInner.addView(textview);
				
				// textview.myPhone = (TextView) findViewById(R.id.my_web_site);
				textview = new TextView(getActivity());
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				textview.setText("412-555-1212");
				Linkify.addLinks(textview, Linkify.PHONE_NUMBERS);
				llInner.addView(textview);
				
				
				
				// (Html.fromHtml(
				/// <<<<<<<<<<<<<
				
				
				break;

			case 3:
				textview = new TextView(getActivity());
				textview.setText("Information Screens:");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);
				
				imgView = new ImageView(getActivity());
				imgView.setImageResource(R.drawable.no_image_big_x);
				imgView.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, (int) (0.7 * container
								.getMeasuredWidth())));
				// imgView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				llInner.addView(imgView);

				textview = new TextView(getActivity());
				textview.setText("Classroom information screens tell you about a specific classroom, " +
						"including the equipment available, and how many seats there are in " +
						"the class, in addition to reporting nay problems.");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);
				break;

			case 4:
				textview = new TextView(getActivity());
				textview.setText("Help Directory:");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);
				
				imgView = new ImageView(getActivity());
				imgView.setImageResource(R.drawable.no_image_big_x);
				imgView.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, (int) (0.7 * container
								.getMeasuredWidth())));
				// imgView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				llInner.addView(imgView);

				textview = new TextView(getActivity());
				textview.setText("The help directory lists useful contact information, as well as informative links.");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);
				break;
				
			case 5:
				textview = new TextView(getActivity());
				textview.setText("Submitting Bug Reports:");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);
				
				imgView = new ImageView(getActivity());
				imgView.setImageResource(R.drawable.no_image_big_x);
				imgView.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, (int) (0.7 * container
								.getMeasuredWidth())));
				// imgView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				llInner.addView(imgView);

				textview = new TextView(getActivity());
				textview.setText("The Submit Bug Report button allows you to notify CIDDE about faulty equipment");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);
				break;

			case 6:
				textview = new TextView(getActivity());
				textview.setText("Submitting Bug Reports:");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);


				textview = new TextView(getActivity());
				textview.setText("The faulty equipment information can be entered by browisng or by scanning a QR code here...");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);

				
				imgView = new ImageView(getActivity());
				imgView.setImageResource(R.drawable.no_image_big_x);
				imgView.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, (int) (0.35 * container
								.getMeasuredWidth())));
				// imgView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				llInner.addView(imgView);

				textview = new TextView(getActivity());
				textview.setText("Bug reporting informatoin can be entered in here...");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);

				
				imgView = new ImageView(getActivity());
				imgView.setImageResource(R.drawable.no_image_big_x);
				imgView.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, (int) (0.35 * container
								.getMeasuredWidth())));
				// imgView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				llInner.addView(imgView);
				
				break;

			case 7:
				textview = new TextView(getActivity());
				textview.setText("How To Tutorials:");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);
				
				imgView = new ImageView(getActivity());
				imgView.setImageResource(R.drawable.no_image_big_x);
				imgView.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, (int) (0.7 * container
								.getMeasuredWidth())));
				// imgView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
				llInner.addView(imgView);

				textview = new TextView(getActivity());
				textview.setText("The How To stores any useful tutorials which cover a whide variety of subjects");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);
				

				
				textview = new TextView(getActivity());
				textview.setText("<<End of Tutorial>>");
				textview.setLayoutParams(new LinearLayout.LayoutParams(
						LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
				llInner.addView(textview);
				
				
				
				// button
				button = new Button(getActivity());
				button.setText("Lets Go!");
				button.setVisibility(View.VISIBLE);
				//button.setBackgroundColor(Color.TRANSPARENT);
				//button.setTextColor(getResources().getColor(R.drawable.link_looking_button_color));
				button.setOnClickListener(new OnClickListener()
				{   
				    @Override
				    public void onClick(View v)
				    {
				    	Activity activity = getActivity();
						Toast.makeText(activity,
								"Send intent to return to MAIN", Toast.LENGTH_SHORT).show();
				    }
				});	
							
				break;

			default:
				break;
			}

			ScrollView scroller = new ScrollView(getActivity());
			scroller.addView(llInner);
			scroller.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
			scroller.setScrollbarFadingEnabled(false);
			// ScrollerView scroller =
			// (ScrollView)findViewById(R.id.scroll_view);
			scroller.setOverScrollMode(ScrollView.OVER_SCROLL_IF_CONTENT_SCROLLS);

			
			Log.i("DEBUG", "onCreateView fixh4");

			// method 0: USE THE LINEARLAYOUT
			// --------------------------------
			LinearLayout llOuter;
			llOuter = new LinearLayout(getActivity());
			llOuter.setOrientation(LinearLayout.VERTICAL);
			llOuter.setBackgroundColor(Color.rgb(255, 128, 128));
			llOuter.setPadding(10, 5, 10, 5);
			llOuter.setBackgroundResource(R.layout.view_pager_background);
			llOuter.setLayoutParams(new LinearLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			// parmas=width, height, weight... i.e. LayoutParams.MATCH_PARENT,
			// LayoutParams.MATCH_PARENT, 1f

			llOuter.addView(scroller);

			return llOuter; // return the linear layout contained in a
							// scrollview

		} // onCreateView()
		
	} // CLASS OzPrototypeViewPagerFragment2

	
	
} // CLASS ViewPagerActivity



// NOTE: ADD METHODS HERE later to simplify...
// instead of using "llInner.addView(textview);" we want to instead just say 
// "writeText("bla bla", bold, font, );
// "placeImage("bla bla bla, " ); etc...
