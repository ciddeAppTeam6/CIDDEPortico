package edu.pitt.cidde.portico;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

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



public class ViewPagerActivity  extends FragmentActivity {
	//int msgFromChildArray[]; // holds OUTGOING data from child activity back to parent
	int msgFromChildReturnType; // The RETURN type going back to the parent
						// 1 = normal return to parent (i.e. just return to parent activity)
						// 2 = return to HOME activity (will require parent to return with another intent)
						// 3 = exit program  
						// 4 = ??
   
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
   ViewPager mViewPager;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_view_pager);

      
      Log.i("DEBUG","onCreate-1");
      // Create the adapter that will return a fragment for each of the three
      // primary sections of the app.
      mSectionsPagerAdapter = new SectionsPagerAdapter(
            getSupportFragmentManager());

      Log.i("DEBUG","onCreate-2");
      // Set up the ViewPager with the sections adapter.
      mViewPager = (ViewPager) findViewById(R.id.pager);
      mViewPager.setAdapter(mSectionsPagerAdapter);
      Log.i("DEBUG","onCreate-3");

   }

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      // Inflate the menu; this adds items to the action bar if it is present.
      getMenuInflater().inflate(R.menu.activity_view_pager, menu);
      Log.i("DEBUG","onCreateOptionsMenu");
      return true;
   }

   public boolean onOptionsItemSelected(MenuItem item) {
       switch (item.getItemId()) {
       case R.id.return_home: // return to HOME SCREEN
    	   msgFromChildReturnType = 2; 
    	   // RETURN TO THE MAIN VIEW after (after intent)
    	   Intent intent=new Intent(); // create intent
    	   intent.putExtra("intReturnType", msgFromChildReturnType); // lob on the return data 
    	   setResult(RESULT_OK, intent); 
    	   finish(); 
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
       }
   }
   
   /**
    * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
    * one of the sections/tabs/pages.
    */
   public class SectionsPagerAdapter extends FragmentPagerAdapter {

      public SectionsPagerAdapter(FragmentManager fm) {
         super(fm);
         Log.i("DEBUG","SEctionsPagerAdapter");
      }

      @Override
      public Fragment getItem(int position) {
         // getItem is called to instantiate the fragment for the given page.
         // Return a DummySectionFragment (defined as a static inner class
         // below) with the page number as its lone argument.
            Log.i("DEBUG","getItem-1");
         Fragment fragment = new DummySectionFragment();
         Bundle args = new Bundle();
            Log.i("DEBUG","getItem-2");
         args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, position + 1);
         fragment.setArguments(args);
            Log.i("DEBUG","getItem-3");
         return fragment;
      }

      @Override
      public int getCount() {
         // Show 3 total pages.
         //Log.i("DEBUG","getcount");
         return 4;
      }

      @Override
      public CharSequence getPageTitle(int position) {
         Log.i("DEBUG","getPagetitle");
         switch (position) {
         
         case 0:
            Log.i("DEBUG","switch case 0");
            //return FUTURE: extract out the page title #1 from the future XML file
            return "Step 1";
         case 1:
            Log.i("DEBUG","switch case 1");
            //return FUTURE: extract out the page title #2 from the future XML file
            return "Step 2";
         case 2:
            Log.i("DEBUG","switch case 2");
            //return FUTURE: extract out the page title #3 from the future XML file
            return "Step 3";
         case 3:
            Log.i("DEBUG","switch case 3");
            //return FUTURE: extract out the page title #4 from the future XML file
            return "Step 4";          
         }
         return null;
      }
   } // SectionsPagerAdapter


   /**
    * A dummy fragment representing a section of the app, but that simply
    * displays dummy text.
    */
   public static class DummySectionFragment extends Fragment {
      /**
       * The fragment argument representing the section number for this
       * fragment.
       */
      public static final String ARG_SECTION_NUMBER = "section_number";

      public DummySectionFragment() {
         Log.i("DEBUG","dummySecitonFragment");
      }

     
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
            //llInner.setBackgroundColor(Color.rgb(255,128,128));
            llInner.setPadding(10, 5, 10, 5);
            //llInner.setBackgroundResource(R.layout.view_pager_background);
            llInner.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
               // parmas=width, height, weight... i.e. LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1f
            
          
            
            // NOW FILL IT... (TEMPORARY prototype)
            // -----------
            TextView textview;
            Button button;
            ImageView imgView;
            textview = new TextView(getActivity());
            textview.setText("HOW TO: Connect a PC to the Projector");
            textview.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            llInner.addView(textview);

            switch (getArguments().getInt(ARG_SECTION_NUMBER))
            {
               case 1:
                   imgView=new ImageView(getActivity());
                   imgView.setImageResource(R.drawable.vga_cable);
                   imgView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(0.7 * container.getMeasuredWidth())));
                   //imgView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                   llInner.addView(imgView);

                   textview = new TextView(getActivity());
                   textview.setText("Locate the VGA cable.  It is the one that has 15 pins");
                   textview.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                   llInner.addView(textview);                  
                  break;
                  
               case 2:
                   imgView=new ImageView(getActivity());
                   imgView.setImageResource(R.drawable.laptop_vga_connection);
                   imgView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(0.7 * container.getMeasuredWidth())));
                   //imgView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                   llInner.addView(imgView);

                   textview = new TextView(getActivity());
                   textview.setText("Plug one end of the cable into the back of your PC");
                   textview.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                   llInner.addView(textview);
                   break;
                   
               case 3:
                   imgView=new ImageView(getActivity());
                   imgView.setImageResource(R.drawable.vga_inputs);
                   imgView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(0.7 * container.getMeasuredWidth())));
                   //imgView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                   llInner.addView(imgView);

                   textview = new TextView(getActivity());
                   textview.setText("Plug the other end of the cable into the audio video PC1 port in the cabinet");
                   textview.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                   llInner.addView(textview);
                  break;

               case 4:
                   imgView=new ImageView(getActivity());
                   imgView.setImageResource(R.drawable.equip_rack);
                   imgView.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, (int)(0.7 * container.getMeasuredWidth())));
                   //imgView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                   llInner.addView(imgView);

                   textview = new TextView(getActivity());
                   textview.setText("Press the ON button on the video cabinet, then press the COMPUTER button");
                   textview.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
                   llInner.addView(textview);


                   button = new Button(getActivity());
                   button.setText("(example button stub NOT CONNECTED)");
                   llInner.addView(button);
                   
 
                  break;
               default:
                  break;
            }
  
            
            ScrollView scroller = new ScrollView(getActivity());
            scroller.addView(llInner);
            scroller.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

            //ScrollerView scroller = (ScrollView)findViewById(R.id.scroll_view);
            scroller.setOverScrollMode(ScrollView.OVER_SCROLL_IF_CONTENT_SCROLLS);
            
            Log.i("DEBUG","onCreateView fixh4");
         
            // method 0: USE THE LINEARLAYOUT
            // --------------------------------
            LinearLayout llOuter;
            llOuter = new LinearLayout(getActivity());
            llOuter.setOrientation(LinearLayout.VERTICAL);
            llOuter.setBackgroundColor(Color.rgb(255,128,128));
            llOuter.setPadding(10, 5, 10, 5);
            llOuter.setBackgroundResource(R.layout.view_pager_background);
            llOuter.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
               // parmas=width, height, weight... i.e. LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1f
    
         
            llOuter.addView(scroller);
         
         return llOuter; // return the linear layout contained in a scrollview

         
      } // onCreateView()
            
   } // DummySectionFragment
      
}
