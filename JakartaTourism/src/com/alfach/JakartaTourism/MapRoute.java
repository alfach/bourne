package com.alfach.JakartaTourism;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomControls;


import com.google.android.maps.GeoPoint;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

import com.alfach.JakartaTourism.BalloonItemizedOverlay;

public class MapRoute extends MapActivity 
{    		

    private MapView mapView;
    private MapController mc;
    GeoPoint p;
    private Road mRoad;
    
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);                
        setContentView(R.layout.map);
        //ProgressDialog dialog = ProgressDialog.show(MapRoute.this, "",
        //		        		"Please wait... create route ", true);
        
        
        mapView = (MapView) findViewById(R.id.mapview1);                						
        TextView title = (TextView)findViewById(R.id.title);
        title.setText("    Rute Peta"); 
        ZoomControls zoomControls = (ZoomControls) findViewById(R.id.zoom);         
        mapView.displayZoomControls(true);        
        mc = mapView.getController();
        
        zoomControls.setOnZoomInClickListener(new View.OnClickListener() {         
            public void onClick(View v) {
                    mc.zoomIn();
            }
    });
    zoomControls.setOnZoomOutClickListener(new View.OnClickListener() {         
            public void onClick(View v) {
                    mc.zoomOut();
            }
    });
        
        mc = mapView.getController();
        
        String coordinates[] = {"-6.2051", "106.8472"}; //default jakarta
        double lat = Double.parseDouble(coordinates[0]);
        double lng = Double.parseDouble(coordinates[1]);
 
        p = new GeoPoint(
           (int) (lat * 1E6), 
            (int) (lng * 1E6));
        
        
 
        mc.animateTo(p);
        mc.setCenter(p);
        mc.setZoom(15); 
       // mapView.invalidate();
        
        LocationManager lm = (LocationManager)
        getSystemService(Context.LOCATION_SERVICE);
    MyLocationListener locationListener = new MyLocationListener();
    lm.requestLocationUpdates(
            LocationManager.NETWORK_PROVIDER,
            0,
            0,
            locationListener);
    
}
    
    class InterestingLocations extends BalloonItemizedOverlay<OverlayItem> { 
        private List<OverlayItem> locations = new ArrayList<OverlayItem>(); 
        private Drawable marker; 
        private Context c;
        
        public InterestingLocations(Drawable marker, MapView mapView, int idPlaces) 
        { 
            super(marker, mapView); 
            this.marker=marker; 
            // create locations of interest 
            
            if(idPlaces==1){
                GeoPoint ragunan = new  
    GeoPoint((int)(-6.306090*1000000),(int)(106.820536*1000000));
                
                locations.add(new OverlayItem(ragunan ,  
                "Kebun Binatang Ragunan", "Kebun Binatang Ragunan"));
                }else if(idPlaces==2){
                GeoPoint joang = new  
    GeoPoint((int)(-6.186137*1000000),(int)(106.836564*1000000));
                
                locations.add(new OverlayItem(joang ,  
          		"Gedung Joang 45", "Gedung Joang 45")); 

                
                }else if(idPlaces==3){
               GeoPoint monas = new  
    GeoPoint((int)(-6.175036*1000000),(int)(106.827192*1000000));
               
               locations.add(new OverlayItem(monas ,  
               		"Monas", "Monumen Nasional"));
               
                }else if(idPlaces==4){
               GeoPoint tmii = new  
    GeoPoint((int)(-6.302222*1000000),(int)(106.902778*1000000));
               
               locations.add(new OverlayItem(tmii ,  
               		"TMII", "Taman Mini Indonesia Indah"));
                }else if(idPlaces==5){
               GeoPoint ancol = new  
    GeoPoint((int)(-6.122551*1000000),(int)(106.831414*1000000));
               
               locations.add(new OverlayItem(ancol ,  
               		"Ancol", "Taman Impian Jaya Ancol"));
               
                }else if(idPlaces==6){
               GeoPoint bahari = new  
    GeoPoint((int)(-6.127488*1000000),(int)(106.808447*1000000));
               
               locations.add(new OverlayItem(bahari ,  
               		"Museum Bahari", "Museum Bahari"));
               
                }else if(idPlaces==7){
               GeoPoint fatahillah = new  
    GeoPoint((int)(-6.135200*1000000),(int)(106.813324*1000000));
               
               locations.add(new OverlayItem(fatahillah ,  
               		"Museum Fatahillah", "Museum Fatahillah"));
               
                }else if(idPlaces==8){
               GeoPoint m_gajah = new  
    GeoPoint((int)(-6.176369*1000000),(int)(106.822329*1000000));
               
               locations.add(new OverlayItem(m_gajah ,  
               		"Museum Gajah", "Museum Gajah"));
               
                }else if(idPlaces==9){
               GeoPoint s_mandala = new  
    GeoPoint((int)(-6.231377*1000000),(int)(106.818695*1000000));
               
               locations.add(new OverlayItem(s_mandala ,  
               		"Museum Satria Mandala", "Museum Satria Mandala"));
               
                }else if(idPlaces==10){
               GeoPoint s_pemuda = new  
    GeoPoint((int)(-6.183815*1000000),(int)(106.843117*1000000));
               
               locations.add(new OverlayItem(s_pemuda ,  
               		"Museum Sumpah Pemuda", "Museum Sumpah Pemuda"));
               
                }else if(idPlaces==11){
               GeoPoint m_tekstil = new  
    GeoPoint((int)(-6.188385*1000000),(int)(106.809645*1000000));
               
               locations.add(new OverlayItem(m_tekstil ,  
               		"Museum Tekstil", "Museum Tekstil"));
               
                }else if(idPlaces==12){
               GeoPoint t_prasasti = new  
    GeoPoint((int)(-6.171779*1000000),(int)(106.819711*1000000));
               
               locations.add(new OverlayItem(t_prasasti ,  
               		"Taman Prasasti", "Taman Prasasti"));
               
                }else if(idPlaces==13){
               GeoPoint m_keramik = new  
    GeoPoint((int)(-6.134371*1000000),(int)(106.814193*1000000));
               
               locations.add(new OverlayItem(m_keramik ,  
               		"Museum Seni Rupa dan Keramik", "Museum Seni Rupa dan Keramik"));
               
                }else if(idPlaces==14){
               GeoPoint p_seribu = new  
    GeoPoint((int)(-5.833165*1000000),(int)(106.601715*1000000));
               
               locations.add(new OverlayItem(p_seribu ,  
               		"Kepulauan Seribu", "Kepulauan Seribu"));           
                }else if(idPlaces==99){
            
            GeoPoint ragunan = new  
GeoPoint((int)(-6.306090*1000000),(int)(106.820536*1000000)); 
            GeoPoint joang = new  
GeoPoint((int)(-6.186137*1000000),(int)(106.836564*1000000)); 
           GeoPoint monas = new  
GeoPoint((int)(-6.175036*1000000),(int)(106.827192*1000000));
           GeoPoint tmii = new  
GeoPoint((int)(-6.302222*1000000),(int)(106.902778*1000000));
           GeoPoint ancol = new  
GeoPoint((int)(-6.122551*1000000),(int)(106.831414*1000000));
           GeoPoint bahari = new  
GeoPoint((int)(-6.127488*1000000),(int)(106.808447*1000000));
           GeoPoint fatahillah = new  
GeoPoint((int)(-6.135200*1000000),(int)(106.813324*1000000));
           GeoPoint m_gajah = new  
GeoPoint((int)(-6.176369*1000000),(int)(106.822329*1000000));
           GeoPoint s_mandala = new  
GeoPoint((int)(-6.231377*1000000),(int)(106.818695*1000000));
           GeoPoint s_pemuda = new  
GeoPoint((int)(-6.183815*1000000),(int)(106.843117*1000000));
           GeoPoint m_tekstil = new  
GeoPoint((int)(-6.188385*1000000),(int)(106.809645*1000000));
           GeoPoint t_prasasti = new  
GeoPoint((int)(-6.171779*1000000),(int)(106.819711*1000000));
           GeoPoint m_keramik = new  
GeoPoint((int)(-6.134371*1000000),(int)(106.814193*1000000));
           GeoPoint p_seribu = new  
GeoPoint((int)(-5.833165*1000000),(int)(106.601715*1000000));
 
           
            locations.add(new OverlayItem(ragunan ,  
"Kebun Binatang Ragunan", "Kebun Binatang Ragunan")); 
            locations.add(new OverlayItem(joang ,  
"Gedung Joang 45", "Gedung Joang 45")); 
            locations.add(new OverlayItem(monas ,  
            		"Monas", "Monas"));
            locations.add(new OverlayItem(tmii ,  
            		"TMII", "TMII"));
            locations.add(new OverlayItem(ancol ,  
            		"Ancol", "Ancol"));
            locations.add(new OverlayItem(bahari ,  
            		"Museum Bahari", "Museum Bahari"));
            locations.add(new OverlayItem(fatahillah ,  
            		"Museum Fatahillah", "Museum Fatahillah"));
            locations.add(new OverlayItem(m_gajah ,  
            		"Museum Gajah", "Museum Gajah"));
            locations.add(new OverlayItem(s_mandala ,  
            		"Museum Satria Mandala", "Museum Satria Mandala"));
            locations.add(new OverlayItem(s_pemuda ,  
            		"Museum Sumpah Pemuda", "Museum Sumpah Pemuda"));
            locations.add(new OverlayItem(m_tekstil ,  
            		"Museum Tekstil", "Museum Tekstil"));
            locations.add(new OverlayItem(t_prasasti ,  
            		"Taman Prasasti", "Taman Prasasti"));
            locations.add(new OverlayItem(m_keramik ,  
            		"Museum Seni Rupa dan Keramik", "Museum Seni Rupa dan Keramik"));
            locations.add(new OverlayItem(p_seribu ,  
            		"Kepulauan Seribu", "Kepulauan Seribu"));
                }
            populate(); 
        } 
 
        @Override 
        public void draw(Canvas canvas, MapView mapView, boolean shadow) { 
            super.draw(canvas, mapView, shadow); 
 
            boundCenterBottom(marker); 
        } 
 
        @Override 
        protected OverlayItem createItem(int i) { 
            return locations.get(i); 
        } 
 
        @Override 
        public int size() { 
            return locations.size(); 
        } 
 
    } 
    
    private class MyLocationListener implements LocationListener
    {    	    	
		   
	    String url;
	    
	    Bundle extras = getIntent().getExtras();
        int idPlaces = extras.getInt("idPlaces");
	    
        @Override
        public void onLocationChanged(Location loc) {
        	/*
            if (loc != null) {
                Toast.makeText(getBaseContext(),
                    "Location changed : Lat: " +  loc.getLatitude() + 
                    " Lng: " + loc.getLongitude(),
                    Toast.LENGTH_SHORT).show();
            }
            */
            p = new GeoPoint(
                    (int) (loc.getLatitude() * 1E6),
                    (int) (loc.getLongitude() * 1E6));
            mc.animateTo(p);
            mc.setZoom(18);
            
            double lat = loc.getLatitude();
		    double lng = loc.getLongitude(); 		    		  
		    
	        if(idPlaces==1){ //ragunan
	        	double latTo = -6.306090;
	        	double lngTo = 106.820536;
		    url = RoadProvider.getUrl(lat, lng, latTo,lngTo);			   		    	     	   
	     	    
		        }else if(idPlaces==2){ //45
		        	double latTo = -6.186137;
		        	double lngTo = 106.836564;
		        
		        	url = RoadProvider.getUrl(lat, lng, latTo,lngTo);		    
		     	
		        	
		        }else if(idPlaces==3){ //monas
		        	double latTo = -6.175036;
		        	double lngTo = 106.827192;
		        
		        	url = RoadProvider.getUrl(lat, lng, latTo,lngTo);		    
		     	
		        	
		        }else if(idPlaces==4){ //tmii
		        	double latTo = -6.302222;
		        	double lngTo = 106.902778;
		        
		        	url = RoadProvider.getUrl(lat, lng, latTo,lngTo);		    
		     	
		        	
		        }else if(idPlaces==5){ //ancol
		        	
		        	double latTo = -6.122551;
		        	double lngTo = 106.831414;
		        
		        	url = RoadProvider.getUrl(lat, lng, latTo,lngTo);		    		     	
		        	
		        }else if(idPlaces==6){ //bahari
		        	
		        	double latTo = -6.127488;
		        	double lngTo = 106.808447;
		        
		        	url = RoadProvider.getUrl(lat, lng, latTo,lngTo);		    		     	
		        	
		        }else if(idPlaces==7){ //fatahillah
		        	
		        	double latTo = -6.135200;
		        	double lngTo = 106.813324;
		        
		        	url = RoadProvider.getUrl(lat, lng, latTo,lngTo);		    		     	
		        	
		        }else if(idPlaces==8){ //museum gajah
		        	
		        	double latTo = -6.176369;
		        	double lngTo = 106.822329;
		        
		        	url = RoadProvider.getUrl(lat, lng, latTo,lngTo);		    		     	
		        	
		        }else if(idPlaces==9){ //satria mandala
		        	
		        	double latTo = -6.231377;
		        	double lngTo = 106.818695;
		        
		        	url = RoadProvider.getUrl(lat, lng, latTo,lngTo);		    		     	
		        	
		        }else if(idPlaces==10){ //sumpah pemuda
		        	
		        	double latTo = -6.183815;
		        	double lngTo = 106.843117;
		        
		        	url = RoadProvider.getUrl(lat, lng, latTo,lngTo);		    		     	
		        	
		        }else if(idPlaces==11){ //tekstil
		        	
		        	double latTo = -6.188385;
		        	double lngTo = 106.809645;
		        
		        	url = RoadProvider.getUrl(lat, lng, latTo,lngTo);		    		     	
		        	
		        }else if(idPlaces==12){ //taman prasasti
		        	
		        	double latTo = -6.171779;
		        	double lngTo = 106.819711;
		        
		        	url = RoadProvider.getUrl(lat, lng, latTo,lngTo);		    		     	
		        	
		        }else if(idPlaces==13){ //seni rupa
		        	
		        	double latTo = -6.134371;
		        	double lngTo = 106.814193;
		        
		        	url = RoadProvider.getUrl(lat, lng, latTo,lngTo);		    		     	
		        	
		        }else if(idPlaces==14){ //p.seribu
		        	
		        	double latTo = -5.833165;
		        	double lngTo = 106.601715;
		        
		        	url = RoadProvider.getUrl(lat, lng, latTo,lngTo);		    		     	
		        	
		        }
	        
	        
		    
	        final ProgressDialog dialog = ProgressDialog.show(MapRoute.this, "",
	        		        		"Please wait... creating your route ", true);
	        new Thread() {
	        	public void run() {
	                try{
	        
	        InputStream is = getConnection(url);
     	    mRoad = RoadProvider.getRoute(is);
     	    mHandler.sendEmptyMessage(0);
	                } catch (Exception e) { }

	                // When grabbing data is finish: Dismiss your Dialog 
	                dialog.dismiss();
	            }
	       }.start();
        }
        
        Handler mHandler = new Handler() {
            public void handleMessage(android.os.Message msg) {
    	 //  TextView textView = (TextView) findViewById(R.id.description);
    	//   textView.setText(mRoad.mName + " " + mRoad.mDescription);
    	   MapOverlay mapOverlay = new MapOverlay(mRoad, mapView, idPlaces);
    	   List<Overlay> listOfOverlays = mapView.getOverlays();
    	   listOfOverlays.clear();
    	   listOfOverlays.add(mapOverlay);
    	   
    	   Drawable marker=getResources().getDrawable(R.drawable.jaktour);  
           marker.setBounds(0, 0, marker.getIntrinsicWidth(),  
                                         marker.getIntrinsicHeight()); 
            
           InterestingLocations tourPlaces = new InterestingLocations(marker, mapView, idPlaces); 
           mapView.getOverlays().add(tourPlaces);
    	   
    	   mapView.displayZoomControls(true);
    	   mapView.invalidate();
            };
        };
            
            private InputStream getConnection(String url) {
  	       	  InputStream is = null;
  	       	  try {
  	       	   URLConnection conn = new URL(url).openConnection();
  	       	   is = conn.getInputStream();
  	       	  } catch (MalformedURLException e) {
  	       	   e.printStackTrace();
  	       	  } catch (IOException e) {
  	       	   e.printStackTrace();
  	       	  }
  	       	  return is;
  	       	 }

		@Override
		public void onProviderDisabled(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onProviderEnabled(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			// TODO Auto-generated method stub
			
		}
        
    }

	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
    
    class MapOverlay extends com.google.android.maps.Overlay {
        Road mRoad;
        ArrayList<GeoPoint> mPoints;
        GeoPoint moveTo;

        public MapOverlay(Road road, MapView mv, int idPlaces) {
                mRoad = road;
                if (road.mRoute.length > 0) {
                        mPoints = new ArrayList<GeoPoint>();
                        for (int i = 0; i < road.mRoute.length; i++) {
                                mPoints.add(new GeoPoint((int) (road.mRoute[i][1] * 1000000),
                                                (int) (road.mRoute[i][0] * 1000000)));
                        }
                        int moveToLat = (mPoints.get(0).getLatitudeE6() + (mPoints.get(
                                        mPoints.size() - 1).getLatitudeE6() - mPoints.get(0)
                                        .getLatitudeE6()) / 2);
                        int moveToLong = (mPoints.get(0).getLongitudeE6() + (mPoints.get(
                                        mPoints.size() - 1).getLongitudeE6() - mPoints.get(0)
                                        .getLongitudeE6()) / 2);
                            if(idPlaces==1){ //ragunan            	        	
            	        	
            	        	moveTo = new GeoPoint(
                                    (int) (-6.306090 * 1E6), 
                                    (int) (106.820536 * 1E6));
              		    	     	   
            	     	    
            		        }else if(idPlaces==2){ //45            		        	
            		        	
            		        	moveTo = new GeoPoint(
                                        (int) (-6.186137 * 1E6), 
                                        (int) (106.836564 * 1E6));
            		        		        		     	            		        	
            		        }else if(idPlaces==3){ //monas            		        	
            		        		        		     	
            		        	moveTo = new GeoPoint(
                                        (int) (-6.175036 * 1E6), 
                                        (int) (106.827192 * 1E6));
            		        	
            		        }else if(idPlaces==4){ //tmii
            		        
            		        	moveTo = new GeoPoint(
                                        (int) (-6.302222 * 1E6), 
                                        (int) (106.902778 * 1E6));

            		        	
            		        }else if(idPlaces==5){ //ancol
            		        	            		        	
            		        	moveTo = new GeoPoint(
                                        (int) (-6.122551 * 1E6), 
                                        (int) (106.831414 * 1E6));
            		        		        
            		        	
            		        }else if(idPlaces==6){ //bahari            		        	            		        	
            		        	
            		        	moveTo = new GeoPoint(
                                        (int) (-6.127488 * 1E6), 
                                        (int) (106.808447 * 1E6));
            		        		        
            		        	
            		        }else if(idPlaces==7){ //fatahillah            		        	            		        
            		        	
            		        	moveTo = new GeoPoint(
                                        (int) (-6.135200 * 1E6), 
                                        (int) (106.813324 * 1E6));
            		        		        
            		        	
            		        }else if(idPlaces==8){ //museum gajah            		        	
            		        	
            		        	moveTo = new GeoPoint(
                                        (int) (-6.176369 * 1E6), 
                                        (int) (106.822329 * 1E6));
            		        		        
            		        	
            		        }else if(idPlaces==9){ //satria mandala            		        	            		        	  
            		        	
            		        	moveTo = new GeoPoint(
                                        (int) (-6.231377 * 1E6), 
                                        (int) (106.818695 * 1E6));
            		        	
            		        }else if(idPlaces==10){ //sumpah pemuda            		        	            		        	
            		        	
            		        	moveTo = new GeoPoint(
                                        (int) (-6.183815 * 1E6), 
                                        (int) (106.843117 * 1E6));
            		        		        
            		        	
            		        }else if(idPlaces==11){ //tekstil            		        	            		        			  
            		        	
            		        	moveTo = new GeoPoint(
                                        (int) (-6.188385 * 1E6), 
                                        (int) (106.809645 * 1E6));
            		        	
            		        }else if(idPlaces==12){ //taman prasasti            		        	            		        
            		        	
            		        	moveTo = new GeoPoint(
                                        (int) (-6.171779 * 1E6), 
                                        (int) (106.819711 * 1E6));
            		        	
            		        }else if(idPlaces==13){ //seni rupa            		        	
            		        	
            		        	moveTo = new GeoPoint(
                                        (int) (-6.134371 * 1E6), 
                                        (int) (106.814193 * 1E6));
            		        		        
            		        	
            		        }else if(idPlaces==14){ //p.seribu
            		        	
            		        	 moveTo = new GeoPoint(
                                        (int) (-5.833165 * 1E6), 
                                        (int) (106.601715 * 1E6));		        		        
            		        	
            		        }
                        
                        //GeoPoint moveTo = new GeoPoint(moveToLat, moveToLong);                                                

                        MapController mapController = mv.getController();
                        mapController.animateTo(moveTo);
                        mapController.setZoom(14);
                }
        }

       // @Override
        public boolean draw(Canvas canvas, MapView mv, boolean shadow, long when) {
                super.draw(canvas, mv, shadow);
                drawPath(mv, canvas);
                
                
                
                return true;
        }

        public void drawPath(MapView mv, Canvas canvas) {
                int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
                Paint paint = new Paint();
                paint.setColor(Color.rgb(238, 124, 93));
                paint.setStyle(Paint.Style.STROKE);
                paint.setStrokeWidth(3);
                for (int i = 0; i < mPoints.size(); i++) {
                        Point point = new Point();
                        mv.getProjection().toPixels(mPoints.get(i), point);
                        x2 = point.x;
                        y2 = point.y;
                        if (i > 0) {
                                canvas.drawLine(x1, y1, x2, y2, paint);
                        }
                        x1 = x2;
                        y1 = y2;
                }
        }
    }

