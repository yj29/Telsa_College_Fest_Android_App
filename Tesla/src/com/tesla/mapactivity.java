package com.tesla;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.renderscript.Element;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class mapactivity extends MapActivity{
	   private mapactivity _activity;
	    double lat=18.51871;
		double lon=73.815807;
		double lat1=18.49664;
		double lon1=73.831726;
		 List<Overlay> mOverlays;
		 GeoPoint g=new GeoPoint((int)(lat*1E6),(int)(lon*1E6));
			GeoPoint g1=new GeoPoint((int)(lat1*1E6), (int)(lon1*1E6));
	@Override
	protected void onCreate(Bundle arg0) {
		// TODO Auto-generated method stub
		
		super.onCreate(arg0);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.map_viewer);
		
		
		MapView mapv=(MapView) findViewById(R.id.mapview);
		mapv.setBuiltInZoomControls(true);
		MapController mc=mapv.getController();
		
		
		List<Overlay> mapOverlays = mapv.getOverlays();
		Drawable srcdrawable = this.getResources().getDrawable(R.drawable.ic_launcher);
		 CustomizedOverlay srcitemizedOverlay = new CustomizedOverlay(srcdrawable);
		 OverlayItem srcoverlayitem = new OverlayItem(g, "Hello!", "This is your Location.");
		 
		 Drawable destdrawable = this.getResources().getDrawable(R.drawable.ic_launcher);
         CustomizedOverlay  destitemizedOverlay = new CustomizedOverlay( destdrawable );
         OverlayItem destoverlayitem = new OverlayItem(g1, "Hello!", "This is dest Location.");
         srcitemizedOverlay.addOverlay(srcoverlayitem);
         destitemizedOverlay.addOverlay(destoverlayitem);
         mapOverlays.add(srcitemizedOverlay);
         mapOverlays.add(destitemizedOverlay);
        //connectAsyncTask _connectAsyncTask = new connectAsyncTask();
       //  _connectAsyncTask.execute(); 
		
		mc.setZoom(15);
		mc.animateTo(g);
		mapv.invalidate();
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	/*private class connectAsyncTask extends AsyncTask<Void, Void, Void>{
        private ProgressDialog progressDialog;
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            progressDialog = new ProgressDialog(_activity);
            progressDialog.setMessage("Fetching route, Please wait...");
            progressDialog.setIndeterminate(true);
            progressDialog.show();
        }
        @Override
        protected Void doInBackground(Void... params) {
            // TODO Auto-generated method stub
            fetchData();
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);          
            if(doc!=null){
                Overlay ol = new MyOverLay(_activity,g,g,1);
                mOverlays.add(ol);
                NodeList _nodelist = doc.getElementsByTagName("status");
                Node node1 = _nodelist.item(0);
                String _status1  = node1.getChildNodes().item(0).getNodeValue();
                if(_status1.equalsIgnoreCase("OK")){
                    NodeList _nodelist_path = doc.getElementsByTagName("overview_polyline");
                    Node node_path = _nodelist_path.item(0);
                    Element _status_path = (Element)node_path;
                    NodeList _nodelist_destination_path = ((Document) _status_path).getElementsByTagName("points");
                    Node _nodelist_dest = _nodelist_destination_path.item(0);
                    String _path  = _nodelist_dest.getChildNodes().item(0).getNodeValue();
                    List<GeoPoint> _geopoints = decodePoly(_path);
                    GeoPoint gp1;
                    GeoPoint gp2;
                    gp2 = _geopoints.get(0);
                    Log.d("_geopoints","::"+_geopoints.size());
                    for(int i=1;i<_geopoints.size();i++) // the last one would be crash
                    {

                        gp1 = gp2;
                        gp2 = _geopoints.get(i);
                        Overlay ol1 = new MyOverLay(gp1,gp2,2,Color.BLUE);
                        mOverlays.add(ol1);
                    }
                    Overlay ol2 = new MyOverLay(_activity,g1,g1,3);
                    mOverlays.add(ol2);

                    progressDialog.dismiss();
                }else{
                    showAlert("Unable to find the route");
                }

                Overlay ol2 = new MyOverLay(_activity,g1,g1,3);
                mOverlays.add(ol2);
                progressDialog.dismiss();
                
                MapController mapView = null;
				mapView.scrollBy(-1,-1);
                mapView.scrollBy(1,1);
            }else{
                showAlert("Unable to find the route");
            }

        }

    }
    Document doc = null;
    private void fetchData()
    {
        StringBuilder urlString = new StringBuilder();
        urlString.append("http://maps.google.com/maps/api/directions/xml?origin=");
        urlString.append( Double.toString((double)g.getLatitudeE6()/1.0E6 ));
        urlString.append(",");
        urlString.append( Double.toString((double)g.getLongitudeE6()/1.0E6 ));
        urlString.append("&destination=");//to
        urlString.append( Double.toString((double)g1.getLatitudeE6()/1.0E6 ));
        urlString.append(",");
        urlString.append( Double.toString((double)g1.getLongitudeE6()/1.0E6 ));
        urlString.append("&sensor=true&mode=driving");   
        Log.d("url","::"+urlString.toString());
        HttpURLConnection urlConnection= null;
        URL url = null;
        try
        {
            url = new URL(urlString.toString());
            urlConnection=(HttpURLConnection)url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            urlConnection.connect();
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = (Document) db.parse(urlConnection.getInputStream());//Util.XMLfromString(response);
        }catch (MalformedURLException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ParserConfigurationException e){
            e.printStackTrace();
        }
        catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private List<GeoPoint> decodePoly(String encoded) {

        List<GeoPoint> poly = new ArrayList<GeoPoint>();
        int index = 0, len = encoded.length();
        int lat = 0, lng = 0;

        while (index < len) {
            int b, shift = 0, result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlat = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lat += dlat;

            shift = 0;
            result = 0;
            do {
                b = encoded.charAt(index++) - 63;
                result |= (b & 0x1f) << shift;
                shift += 5;
            } while (b >= 0x20);
            int dlng = ((result & 1) != 0 ? ~(result >> 1) : (result >> 1));
            lng += dlng;

            GeoPoint p = new GeoPoint((int) (((double) lat / 1E5) * 1E6),
                    (int) (((double) lng / 1E5) * 1E6));
            poly.add(p);
        }

        return poly;
    }
    private void showAlert(String message){
        AlertDialog.Builder alert = new AlertDialog.Builder(_activity);
        alert.setTitle("Error");
        alert.setCancelable(false);
        alert.setMessage(message);
        alert.setPositiveButton("Ok",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub

            }
        });
        alert.show();
    }
    private Drawable getDrawable(String fileName){
        return Drawable.createFromStream(_activity.getClass().getClassLoader().getResourceAsStream(fileName), "pin");
    }
	
	
	*/
	
	
}
