package edu.pitt.cidde.portico;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class CiddeMainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cidde_main);
		
		
		// LOGIC HERE for CIDDE GridView
		GridView gridview = (GridView) findViewById(R.id.gridview);
	    gridview.setAdapter(new MainImageAdapter(this));

	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            switch (position) // determine what TYPE of brick will go here
	            {
	                case 0:
	                	Toast.makeText(CiddeMainActivity.this,
	                			"Scan QR Code", Toast.LENGTH_SHORT).show();
	                    break;
	                case 1:
	                	Toast.makeText(CiddeMainActivity.this,
	                			"Browse Equipment & Rooms", Toast.LENGTH_SHORT).show();
	                    break;
	                case 2:
	                	Toast.makeText(CiddeMainActivity.this,
	                			"I Need Help!", Toast.LENGTH_SHORT).show();
	                    break;
	                case 3:
	                	Toast.makeText(CiddeMainActivity.this,
	                			"Submit Bug Report!", Toast.LENGTH_SHORT).show();
	                    break;
	                case 4:
	                	Toast.makeText(CiddeMainActivity.this,
	                			"How To...", Toast.LENGTH_SHORT).show();
	                    break;
	                case 5:
	                	Toast.makeText(CiddeMainActivity.this,
	                			"Order From Web..", Toast.LENGTH_SHORT).show();
	                    break;
	                default:
	                	Toast.makeText(CiddeMainActivity.this,
	                			"????", Toast.LENGTH_SHORT).show();
	            } // switch
	        }
	    });		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // onCreate()

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_cidde_main, menu);
		return true;
	}

}
