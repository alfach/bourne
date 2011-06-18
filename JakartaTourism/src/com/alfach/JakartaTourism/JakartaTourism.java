package com.alfach.JakartaTourism;


import com.alfach.JakartaTourism.R.drawable;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class JakartaTourism extends Activity {
    /** Called when the activity is first created. */
        
    	private static final int MENU_ABOUT = Menu.FIRST;
    	private static final int MENU_SEARCH = Menu.FIRST + 1;
    	
    	private static class EfficientAdapter extends BaseAdapter {
    	private LayoutInflater mInflater;

    	public EfficientAdapter(Context context) {
    	mInflater = LayoutInflater.from(context);
    	}
    	
    	public int getCount() {
    		 return INDEX.length;
    		 }

    		 public Object getItem(int position) {
    		 return position;
    		 }

    		 public long getItemId(int position) {
    		 return position;
    		 }

    		 public View getView(int position, View convertView, ViewGroup parent) {
    		 ViewHolder holder;
    		 if (convertView == null) {
    		 convertView = mInflater.inflate(R.layout.listview, null);
    		 holder = new ViewHolder();
    		 holder.text = (TextView) convertView
    		 .findViewById(R.id.TextView01);
    		 holder.text2 = (TextView) convertView
    		 .findViewById(R.id.TextView02);
    		 holder.text3 = (TextView) convertView
    		 .findViewById(R.id.TextView03);

    		 convertView.setTag(holder);
    		 } else {
    		 holder = (ViewHolder) convertView.getTag();
    		 }

    		 holder.text.setText(INDEX[position]);
    		 holder.text2.setText(PLACES[position]);
    		 
    		     		 
    		 convertView.setBackgroundColor((position & 1) == 1 ? Color.TRANSPARENT : Color.TRANSPARENT);
    		 return convertView;
    		 }

    		 static class ViewHolder {
    		 TextView text;
    		 TextView text2;
    		 TextView text3;
    		 }
    		 }
        /** Called when the activity is first created. */
    	 @Override  
    	    public void onCreate(Bundle savedInstanceState) 
    	    {
    	        super.onCreate(savedInstanceState); 
    	       requestWindowFeature(Window.FEATURE_NO_TITLE);
    	        
    	        setContentView(R.layout.main);
    	        ListView l1 = (ListView) findViewById(R.id.ListView01);
    	        
    	        ColorDrawable divcolor = new ColorDrawable(Color.WHITE);
    	        l1.setDivider(divcolor);
    	        l1.setDividerHeight(2);
    	        l1.setAdapter(new EfficientAdapter(this));
    	        
    	        l1.setOnItemClickListener(new OnItemClickListener() {

    	        	@Override
    	        	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
    	        	long arg3) {
    	        	Toast.makeText(getBaseContext(), " "+PLACES[arg2], Toast.LENGTH_LONG).show();
    	        	Intent intent = new Intent(JakartaTourism.this,
    		        		ContentTourism.class);
    		            intent.putExtra("idPlaces", arg2+1);
    		        		startActivity(intent);
    	        	}
    	        });
    	    }    	 	 	

    	    static final String[] INDEX = new String[] {
    		    "1", 
    		    "2", 
    		    "3", 
    		    "4", 
    		    "5",
    		    "6", 
    		    "7", 
    		    "8", 
    		    "9", 
    		    "10",
    		    "11",
    		    "12",
    		    "13",
    		    "14"
    		    
    		  };
    	static final String[] PLACES = new String[] {
    	"Kebun Binatang Ragunan",
    	"Gedung Djoeang 45",
    	"Monumen Nasional (Monas)",
    	"Taman Mini Indonesia Indah (TMII)",
    	"Taman Impian Jaya Ancol (Ancol)",
    	"Museum Bahari",
    	"Museum Fatahillah (Sejarah Jakarta)",
    	"Museum Gajah (Museum Nasional)",
    	"Museum Satria Mandala",
    	"Museum Sumpah Pemuda",
    	"Museum Tekstil",
    	"Museum Taman Prasasti",
    	"Museum Seni Rupa dan Keramik",
    	"Pulau Seribu"
    	
    	};
    	
    	@Override

    	  public boolean onCreateOptionsMenu(Menu menu) {
    		
    	    menu.add(0,MENU_ABOUT,0,"About").setIcon(android.R.drawable.ic_menu_info_details);
    	    menu.add(0,MENU_SEARCH,0,"Quit").setIcon(android.R.drawable.ic_menu_close_clear_cancel);
    	    return super.onCreateOptionsMenu(menu);
    	  }
    	
    	 /* Handles item selections */
    	  public boolean onOptionsItemSelected(MenuItem item) {
    		  
    	     switch (item.getItemId()) {
    	     case MENU_ABOUT:
     	    	//set up dialog
     	          Dialog dialog = new Dialog(JakartaTourism.this);
     	          dialog.setContentView(R.layout.aboutdialog);
     	          dialog.setTitle("JakartaTourism 1.0 Beta");
     	          dialog.setCancelable(true);
     	          //there are a lot of settings, for dialog, check them all out!

     	          //set up text
     	          TextView text = (TextView) dialog.findViewById(R.id.TextView01);
     	          CharSequence aboutText = Html.fromHtml("" +
     	          		"Aplikasi ini menampilkan daftar tempat wisata yang tersedia di Jakarta (beta). Berisi informasi, foto dan lokasi tempat wisata yang dipilih. Selain itu juga menampilkan rute dari tempat Anda menuju ke tempat wisata menggunakan google maps. " +
     	          		"<br><br>Aplkasi ini mendeteksi lokasi Anda melalui <i>network provider</i> dan rute yang ditampilkan merupakan <i>driving direction</i> (kendaraan umum / mobil)." +
     	          		"<br><br> Dikembangkan oleh <b>(Achmad Fachrie) - 2011</b>" +		     		
     	   		"<br>email : <font size=2sp>a.fachrie@alfach.com</font>" +
     	   		"<br>web : <font size=2sp><a href=http://alfach.com>http://alfach.com</a></p>");
     	          text.setText(aboutText);

     	          //set up image view
     	        //  ImageView img = (ImageView) dialog.findViewById(R.id.ImageView01);
     	        //  img.setImageResource(R.drawable.about);

     	          //set up button
     	        //  Button button = (Button) dialog.findViewById(R.id.Button01);
     	        //  button.setOnClickListener(new OnClickListener() {
     	        //  public void onClick(View v) {
     	        //          dismiss();
     	        //      }
     	        //  });
     	          //now that the dialog is set up, it's time to show it    
     	          dialog.show();		   	      	     return true;
    	  case MENU_SEARCH:
    		  //Intent intent = new Intent(HaditsArbain.this,FormList.class);
    	      //startActivity(intent);
    		  JakartaTourism.this.finish();
    		  return true;
    	   }
    	   return false;
    	   
    	}	  
    }