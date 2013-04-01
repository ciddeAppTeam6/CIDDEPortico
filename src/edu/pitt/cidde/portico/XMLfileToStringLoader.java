package edu.pitt.cidde.portico;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


// ===================================
// ASYNC TASK to downlaod the XML file
// ===================================
public class XMLfileToStringLoader extends AsyncTask<String, Integer, String> {
	// format: android.os.AsyncTask<Params, Progress, Result> 

	private static final String TAG = "XMLfileToStringLoader";
	
	
	boolean bUrlConvertPassed;
    private Context context;
    private XMLfileAsStringLoaderINT<String> listener;
	
	
	// CONSTRUCTOR(S)
	// ==============
    public XMLfileToStringLoader(Context ctx, XMLfileAsStringLoaderINT<String> listener)
    {
        this.context = ctx;
        this.listener = listener;
    }
	
	// Exectue before task start
	// =========================
    @Override
    protected void onPreExecute()
    {
        super.onPreExecute();
    }

    // Run immediately after onPreExecute, and run in background
    // =========================================================
	@Override    
    protected String doInBackground(String... strUrl) // Var. corresponds to: AsyncTask<URL, ????, ????> 
    { 
    	Log.i("DEBUG", "doInBackground");

    	// prep the URL so we can open a connection with it
    	// ------------------------------------------------
        //String urlStr = "http://ciddeapp.x10.mx/test.xml"; // debug
        URL url;
        URI uri;
		URL xmlUrl = null;
		try
		{
			//url = new URL(urlStr); // debug
			url = new URL(strUrl[0]);
			try
			{
				uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), 
						url.getPort(), url.getPath(), url.getQuery(), url.getRef());
				xmlUrl = uri.toURL(); // <<< sending this for the http request
			}
			catch (URISyntaxException e)
			{
				e.printStackTrace();
				Log.i("DEBUG", "URISyntaxException = " + e.getMessage());
				bUrlConvertPassed = false;
			}
		}
		catch (MalformedURLException e1)
		{
			e1.printStackTrace();
			Log.i("DEBUG", "MalformedURLException = " + e1.getMessage());
			bUrlConvertPassed = false;
		}
    	    	
    	
		// Open the URL and load in the remote file into the string
		// --------------------------------------------------------
        StringBuilder builtString = new StringBuilder();
        try {
            Log.i("DEBUG", "Runing url: ");
            URLConnection conexion = xmlUrl.openConnection();
            conexion.connect();
            int lenghtOfFile = conexion.getContentLength();
            publishProgress(lenghtOfFile); // initiate update of any progressbar(s)
            Log.i("DEBUG", "size of xml file: "+ lenghtOfFile);
            InputStream inData = new BufferedInputStream(xmlUrl.openStream(), 512);

            BufferedReader reader = new BufferedReader(new InputStreamReader(inData));
            String oneLine = null;
            
            while ((oneLine = reader.readLine()) != null)
            {
                builtString.append(oneLine);
                publishProgress(builtString.length());
            }

            inData.close();

        }
        catch (Exception e)
        {
        	Log.i("DEBUG", "exceptin " + e.toString());
        }
    	
    	// publishProgress(123);  // provide update of progress
        Log.i("DEBUG", "parsed xml file: "+ builtString.toString());
        
        return builtString.toString();
    } // doInBackground

    
    // Progress updates
    // ================
    protected void onProgressUpdate(Integer... progress) // Var. corresponds to: AsyncTask<????, Integer,????>
    {   // called when publishProgress() is called (Above).
    	listener.onProgressUpdate(progress); // send a call to the parent listener
    }

    // Finished
    // ========
	@Override
    protected void onPostExecute(String result) // Var. corresponds to: AsyncTask<????,????,String>
    { 
    	super.onPostExecute(result);
    	
        // Processing is complete 
    	Log.i("DEBUG", "yupAlldonea");        	
    	listener.onFinishedDownload(result); // send a call to parent listener - done
    }
} // CLASS: XMLfileToStringLoader()
