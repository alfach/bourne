package com.alfach.JakartaTourism;

import java.io.InputStream;


import com.google.android.maps.GeoPoint;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class ContentTourism extends Activity {
	
	
	
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        
        setContentView(R.layout.contentview);
        
        Bundle extras = getIntent().getExtras();
        final int idPlaces = extras.getInt("idPlaces");
        
        Button rute = (Button)findViewById(R.id.rute);
        rute.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(ContentTourism.this,
		        		MapRoute.class);
		            intent.putExtra("idPlaces", idPlaces);
		        	startActivity(intent);
			}
		});
        
        LocationManager locationManager;
        String context = Context.LOCATION_SERVICE;
        locationManager = (LocationManager)getSystemService(context);
        
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        String provider = locationManager.getBestProvider(criteria, true);
        //String provider = LocationManager.GPS_PROVIDER;
        Location location = locationManager.getLastKnownLocation(provider);                                     
                        
        updateWithNewLocation(location, idPlaces);    
                                                                   
    }

	private void updateWithNewLocation(Location location, int idPlaces) {
		// TODO Auto-generated method stub
		 String latLongString;
		  TextView myLocationText; 		 
		  myLocationText = (TextView)findViewById(R.id.lokasi);	
		  TextView title = (TextView)findViewById(R.id.title);
	        Gallery gallery = (Gallery)findViewById(R.id.gallery1);        
	        TextView isi = (TextView)findViewById(R.id.isi);
	        TextView alamat = (TextView)findViewById(R.id.alamat);
	        
	    //  Update the map location.
			   double lat = location.getLatitude();
			   double lng = location.getLongitude();
			  
			    Location locationA = new Location("point A");

			    locationA.setLatitude(lat);
			    locationA.setLongitude(lng);
			    
			    Location locationDest = new Location("point B");
		
			    if(idPlaces==1){
		        	gallery.setAdapter(new ImageAdapter(this));
		        	CharSequence titleHtml = 
		        	Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;<b>Kebun Binatang Ragunan</b>");
		        	CharSequence isiHtml = 
		            	Html.fromHtml("<hr><b>Tentang</b><br>" +
		            			"Kebun Binatang Ragunan adalah sebuah kebun binatang" +
		            			" yang terletak di daerah Ragunan, Pasar Minggu, Jakarta Selatan" +
		            			", Indonesoia. Kebun binatang seluas 140 hektar ini didirikan pada " +
		            			" tahun 1864. Di dalamnya, terdapat berbagai koleksi yang terdiri dari " +
		            			" 295 spesies dan 4040 spesimen");
		        	CharSequence alamatHtml = Html.fromHtml("<hr><br><b>Alamat / Kontak</b>" +
		        			    " <br>Jalan Harsono RM No 1, Kel. Ragunan 12550, Kec. Ps Minggu, Jakarta Selatan Indonesia " +
		        			    " <br>+62 21 7806975, 78847144, 78847108, 78847105 fax. +62 21 7805280");
		        	//-6306090,106820536(lat,lon)
		        	title.setText(titleHtml);  
		        	isi.setText(isiHtml);
		        	alamat.setText(alamatHtml);
		        	
		        	double destToLat = -6306090;
					  double destToLon = 106820536;
					  
					  locationDest.setLatitude(destToLat);
			  		  locationDest.setLongitude(destToLon);
		        	
		        }else
		        	if(idPlaces==2){
		        		gallery.setAdapter(new ImageAdapter2(this));
		        		CharSequence titleHtml = 
		                	Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;<b>Gedung Djoeang 45</b>");
		                	CharSequence isiHtml = 
		                    	Html.fromHtml("<hr><b>Tentang</b><br>" +	                    				                    		
		                    			"Di museum ini dapat dilihat jejak " +
		                    			"perjuangan kemerdekaan RI dengan koleksi benda-benda " +
		                    			"peninggalan para pejuang Indonesia. " +	                    			
		                    			"Selain itu ada pula koleksi foto-foto dokumentasi dan lukisan " +
		                    			"yang menggambarkan perjuangan sekitar tahun 1945-1950-an. " +
		                    			"Beberapa tokoh perjuangan ditampilkan pula dalam bentuk patung-patung dada.");
		                	CharSequence alamatHtml = Html.fromHtml("<hr><br><b>Alamat</b><br>Jalan Menteng Raya 31, Kelurahan Kebon Sirih, Kecamatan Menteng, Jakarta Pusat <br>Telp. (021) 390-9148, Fax (021) 392-3185. <br>Email: museumjoangjakarta@yahoo.co.id");
		            
		                	title.setText(titleHtml);  
		                	isi.setText(isiHtml);
		                	alamat.setText(alamatHtml);
		        }else
		        	if(idPlaces==3){
		        		gallery.setAdapter(new ImageAdapter3(this));
		        		CharSequence titleHtml = 
		                	Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;<b>Monumen Nasional (Monas)</b>");
		                	CharSequence isiHtml = 
		                    	Html.fromHtml("<hr><b>Tentang</b><br>" +
		                    			"Monumen Nasional atau yang populer disingkat dengan Monas atau Tugu Monas adalah" +
		                    			" monumen peringatan setinggi 132 meter (433 kaki) yang didirikan untuk mengenang" +
		                    			" perlawanan dan perjuangan rakyat Indonesia untuk merebut kemerdekaan dari pemerintahan" +
		                    			" kolonial Hindia Belanda. <br><br>" +                    			
		                    			" Tugu ini di mahkotai lidah api yang dilapisi lembaran emas yang melambangkan semangat perjuangan" +
		                    			" yang menyala-nyala.");
		                	CharSequence alamatHtml = Html.fromHtml("<hr><br><b>Alamat</b><br>Jl. Silang Monas, Jakarta Pusat, Telp: 021-70649354");
		            
		                	title.setText(titleHtml);  
		                	isi.setText(isiHtml);
		                	alamat.setText(alamatHtml);
		                	//-6175036,106827192(lat,lon)
		                	
		                  double destToLat = -6175036;
		  				  double destToLon = 106827192;
		  				  
		  				  locationDest.setLatitude(destToLat);
		  		  		  locationDest.setLongitude(destToLon);
		        }else
		        	if(idPlaces==4){        		
		        		gallery.setAdapter(new ImageAdapter4(this));		
		        		CharSequence titleHtml = 
		                	Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;<b>Taman Mini Indonesia Indah (TMII)</b>");
		                	CharSequence isiHtml = 
		                    	Html.fromHtml("<hr><b>Tentang</b><br>" +
		                    			"Taman Mini Indonesia Indah (TMII) " +
		                    			"merupakan suatu kawasan taman wisata " +
		                    			"bertema budaya Indonesia. " +	                    			
		                    			" Taman ini merupakan rangkuman kebudayaan bangsa Indonesia, " +
		                    			" yang ditampilkan " +
		                    			"dalam anjungan daerah berarsitektur tradisional, " +
		                    			"serta menampilkan aneka busana, tarian dan tradisi daerah. " +
		                    			"<br><br>Disamping itu, di tengah-tengah TMII terdapat sebuah danau yang " +
		                    			"menggambarkan miniatur kepulauan Indonesia di tengahnya, " +
		                    			"kereta gantung, berbagai museum, dan Teater IMAX Keong Mas " +
		                    			"dan Teater Tanah Airku).");
		                	CharSequence alamatHtml = Html.fromHtml("<hr><br><b>Alamat</b><br>Jl Raya TMII Jakarta 13810, Telp: (021)8409214");
		            
		                	title.setText(titleHtml);  
		                	isi.setText(isiHtml);
		                	alamat.setText(alamatHtml);
		        }else
		        	if(idPlaces==5){
		        		gallery.setAdapter(new ImageAdapter5(this));
		        		CharSequence titleHtml = 
		                	Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;<b>Ancol</b>");
		                	CharSequence isiHtml = 
		                    	Html.fromHtml("<hr><b>Tentang</b><br>" +
		                    			"Taman Impian Jaya Ancol " +
		                    			"merupakan sebuah objek wisata di " +
		                    			"Jakarta Utara. " +
		                    			"Sebagai komunitas pembaharuan kehidupan " +
		                    			"masyarakat yang menjadi kebanggaan bangsa. " +
		                    			"Senantiasa menciptakan lingkungan sosial " +
		                    			"yang lebih baik melalui sajian hiburan " +
		                    			"berkualitas yang berunsur seni, budaya " +
		                    			"dan pengetahuan, dalam rangka mewujudkan " +
		                    			"komunitas 'Life Re-Creation' yang menjadi " +
		                    			"kebanggaan bangsa.");
		                	CharSequence alamatHtml = Html.fromHtml("<hr><br><b>Alamat</b>" +
		                			"Jl. Lodan Timur No. 7 Jakarta 14430. Telp. (021) 641 0080, http://www.ancol.com/");
		            
		                	title.setText(titleHtml);  
		                	isi.setText(isiHtml);
		                	alamat.setText(alamatHtml);
		                	//-6122551,106831414
		                	
		                	double destToLat = -6122551;
		  				  double destToLon = 106831414;
		  				  
		  				  locationDest.setLatitude(destToLat);
		  		  		  locationDest.setLongitude(destToLon);
		        }else
		        	if(idPlaces==6){
		        		gallery.setAdapter(new ImageAdapter6(this));
		        		CharSequence titleHtml = 
		                	Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;<b>Museum Bahari</b>");
		                	CharSequence isiHtml = 
		                    	Html.fromHtml("<hr><b>Tentang</b><br>" +
		                    			"Di ujung Utara Ibukota Jakarta, " +
		                    			"tepatnya pada kawasan kuno pelabuhan Sunda Kelapa, " +
		                    			"berdirilah Museum Maritim (Museum Bahari) " +
		                    			"yang memamerkan berbagai benda peninggalan VOC  " +
		                    			"Belanda pada zaman dahulu dalam bentuk model " +
		                    			"atau replica kecil, photo, lukisan serta berbagai " +
		                    			"model perahu tradisional, perahu asli, alat navigasi, " +
		                    			"kepelabuhan serta benda lainnya yang berhubungan " +
		                    			"dengan kebaharian Indonesia. ");
		                	CharSequence alamatHtml = Html.fromHtml("<hr><br><b>Alamat</b><br>Jl. Pasar Ikan" +
		                			" Kota 14440, Indonesia. Telp : 021 6693406");
		            
		                	title.setText(titleHtml);  
		                	isi.setText(isiHtml);
		                	alamat.setText(alamatHtml);
		        }else
		        	if(idPlaces==7){
		        		gallery.setAdapter(new ImageAdapter7(this));
		        		CharSequence titleHtml = 
		                	Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;<b>Museum Fatahillah</b>");
		                	CharSequence isiHtml = 
		                    	Html.fromHtml("<hr><b>Tentang</b><br>" +
		                    			"Museum Fatahillah yang juga dikenal sebagai Museum Sejarah Jakarta " +
		                    			"atau Museum Batavia. " +	                    			
		                    			"Gedung ini dulu adalah sebuah Balai Kota (bahasa Belanda: Stadhuis) " +
		                    			". Bangunan itu menyerupai Istana Dam di Amsterdam, " +
		                    			"terdiri atas bangunan utama dengan dua sayap di bagian timur dan barat serta bangunan sanding yang digunakan sebagai kantor, ruang pengadilan, " +
		                    			"dan ruang-ruang bawah tanah yang dipakai sebagai penjara.");
		                	CharSequence alamatHtml = Html.fromHtml("<hr><br><b>Alamat</b><br>Jl. Taman Fatahillah No. 1-2 Jakarta Barat <br>" +
		                			"Telp (62-21) 6929101, 6901483 <br>" +
		                			"Fax. (62-21) 6902387<br>" +
		                			"email: musejak@indosat.net.id");
		            
		                	title.setText(titleHtml);  
		                	isi.setText(isiHtml);
		                	alamat.setText(alamatHtml);
		        }else
		        	if(idPlaces==8){
		        		gallery.setAdapter(new ImageAdapter8(this));
		        		CharSequence titleHtml = 
		                	Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;<b>Museum Gajah (Museum Nasional)</b>");
		                	CharSequence isiHtml = 
		                    	Html.fromHtml("<hr><b>Tentang</b><br>" +
		                    			"Museum Nasional Republik Indonesia atau Museum Gajah, " +
		                    			"adalah adalah salah satu wujud " +
		                    			"pengaruh Eropa, terutama semangat Abad Pencerahan, " +
		                    			"yang muncul pada sekitar abad 18. " +	                    			
		                    			"Museum Nasional dikenal sebagai Museum Gajah sejak dihadiahkannya patung gajah " +
		                    			"perunggu oleh Raja Chulalongkorn dari Thailand pada 1871. " +
		                    			"Tetapi pada 28 Mei 1979, namanya resmi menjadi Museum Nasional Republik Indonesia. " +	                    			
		                    			"Pada tahun 2006 jumlah koleksinya sudah melebihi 140.000 buah, " +
		                    			"tapi baru sepertiganya saja yang dapat diperlihatkan kepada khalayak.");
		                	CharSequence alamatHtml = Html.fromHtml("<hr><br><b>Alamat</b><br> Jl. Merdeka Barat No. 12, Jakarta Pusat");
		            
		                	title.setText(titleHtml);  
		                	isi.setText(isiHtml);
		                	alamat.setText(alamatHtml);
		        }else
		        	if(idPlaces==9){
		        		gallery.setAdapter(new ImageAdapter9(this));
		        		CharSequence titleHtml = 
		                	Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;<b>Monumen Satria Mandala</b>");
		                	CharSequence isiHtml = 
		                    	Html.fromHtml("<hr><b>Tentang</b><br>" +
		                    			"Museum Satria Mandala adalah museum sejarah perjuangan " +
		                    			"Tentara Nasional Indonesia yang didalamnya dapat ditemui berbagai koleksi " +
		                    			"peralatan perang di Indonesia, " +
		                    			"dari masa lampau sampai modern seperti koleksi ranjau, " +
		                    			"rudal, torpedo, tank, meriam bahkan helikopter " +
		                    			"dan pesawat terbang " +
		                    			"(satu diantaranya adalah pesawat Cureng " +
		                    			"yang pernah diterbangkan oleh " +
		                    			"Marsekal Udara Agustinus Adi Sucipto)." +
		                    			"Selain itu museum ini juga menyimpan berbagai " +
		                    			"berbagai benda bersejarah yang berkaitan dengan " +
		                    			"TNI seperti aneka senjata berat maupun ringan, " +
		                    			"atribut ketentaraan, panji-panji dan " +
		                    			"lambang-lambang di lingkungan TNI.");
		                	CharSequence alamatHtml = Html.fromHtml("<hr><br><b>Alamat</b><br>Jl. Jend. Gatot Subroto No. 14, Jakarta Selatan");
		            
		                	title.setText(titleHtml);  
		                	isi.setText(isiHtml);
		                	alamat.setText(alamatHtml);
		        }else
		        	if(idPlaces==10){
		        		gallery.setAdapter(new ImageAdapter10(this));
		        		CharSequence titleHtml = 
		                	Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;<b>Museum Sumpah Pemuda</b>");
		                	CharSequence isiHtml = 
		                    	Html.fromHtml("<hr><b>Tentang</b><br>" +
		                    			"Museum Sumpah Pemuda adalah museum khusus " +
		                    			"sejarah yang berada dibawah Kementerian " +
		                    			"Kebudayaan dan Pariwisata. " +
		                    			"Museum Sumpah Pemuda merupakan satu-satunya " +
		                    			"museum yang mengumpulkan dan menyajikan " +
		                    			" aspek yang berhubungan dengan sejarah sumpah pemuda.");
		                	CharSequence alamatHtml = Html.fromHtml("<hr><br><b>Alamat</b><br>Jl. Kramat Raya, Jakarta Pusat. Telp: 021-3103217");
		            
		                	title.setText(titleHtml);  
		                	isi.setText(isiHtml);
		                	alamat.setText(alamatHtml);
		        }else
		        	if(idPlaces==11){
		        		gallery.setAdapter(new ImageAdapter11(this));
		        		CharSequence titleHtml = 
		                	Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;<b>Museum Tekstil</b>");
		                	CharSequence isiHtml = 
		                    	Html.fromHtml("<hr><b>Tentang</b><br>" +
		                    			" Museum tekstil terbesar di Indonesia, museum ini mempunyai koleksi-koleksi yang terhitung banyak, yakni sekitar 1.000 buah. Keistimewaan museum ini terletak pada koleksi-koleksinya yang kebanyakan merupakan koleksi tekstil tradisional Indonesia. Koleksi-koleksi tersebut dikelompokkan dalam empat bagian, yakni koleksi kain tenun, koleksi kain batik, koleksi peralatan, dan koleksi campuran. Wisatawan yang berkunjung ke museum ini dapat menyaksikan aneka kain batik bermotif geometris sederhana hingga yang bermotif rumit, seperti batik Yogyakarta, Solo, Pekalongan, Cirebon, Palembang, Madura, dan Riau.");
		                	CharSequence alamatHtml = Html.fromHtml("<hr><br><b>Alamat</b><br>Jl. Aipda Ks Tubun, Jakarta Pusat");
		            
		                	title.setText(titleHtml);  
		                	isi.setText(isiHtml);
		                	alamat.setText(alamatHtml);
		        }else
		        	if(idPlaces==12){
		        		gallery.setAdapter(new ImageAdapter12(this));
		        		CharSequence titleHtml = 
		                	Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;<b>Taman Prasati</b>");
		                	CharSequence isiHtml = 
		                    	Html.fromHtml("<hr><b>Tentang</b><br>" +
		                    			"Museum Taman Prasasti adalah sebuah museum " +
		                    			"cagar budaya peninggalan masa " +
		                    			"kolonial Belanda yang berada " +
		                    			"di Jalan Tanah Abang No. 1, Jakarta Pusat. " +
		                    			"Museum ini memiliki koleksi prasasti nisan " +
		                    			"kuno serta miniatur makam khas dari 27 " +
		                    			"propinsi di Indonesia, beserta koleksi " +
		                    			"kereta jenazah antik. " +
		                    			"Museum seluas 1,2 ha ini merupakan museum terbuka " +
		                    			"yang menampilkan karya seni dari masa lampau " +
		                    			"tentang kecanggihan para pematung, pemahat, " +
		                    			"kaligrafer dan sastrawan yang menyatu.");
		                	CharSequence alamatHtml = Html.fromHtml("<hr><br><b>Alamat</b><br>Jalan Tanah Abang 1, Jakarta");
		            
		                	title.setText(titleHtml);  
		                	isi.setText(isiHtml);
		                	alamat.setText(alamatHtml);
		        }else
		        	if(idPlaces==13){
		        		gallery.setAdapter(new ImageAdapter13(this));
		        		CharSequence titleHtml = 
		                	Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;<b>Museum Seni Rupa dan Keramik</b>");
		                	CharSequence isiHtml = 
		                    	Html.fromHtml("<hr><b>Tentang</b><br>" +
		                    			"Museum Seni Rupa dan Keramik memiliki sekitar 400 koleksi karya seni rupa di antaranya patung, totem dari kayu, sketsa, dan batik lukis. Wisatawan yang berkunjung ke museum ini dapat melihat koleksi andalan yang sangat penting bagi sejarah seni rupa Indonesia, antara lain lukisan berjudul 'Bupati Cianjur', karya Raden Saleh, lukisan 'Ibu Menyusui' karya Dullah, lukisan 'Laskar Tritura' Karya S. Sudjojono, lukisan berjudul “Pengantin Cianjur” karya Hendra Gunawan, dan lukisan 'Potret Diri' karya Affandi.");
		                	CharSequence alamatHtml = Html.fromHtml("<hr><br><b>Alamat</b><br>Jl. Pos Kota, Kota, Jakarta Barat");
		            
		                	title.setText(titleHtml);  
		                	isi.setText(isiHtml);
		                	alamat.setText(alamatHtml);
		        }else
		        	if(idPlaces==14){
		        		gallery.setAdapter(new ImageAdapter14(this));
		        		CharSequence titleHtml = 
		                	Html.fromHtml("&nbsp;&nbsp;&nbsp;&nbsp;<b>Pulau Seribu</b>");
		                	CharSequence isiHtml = 
		                    	Html.fromHtml("<hr><b>Tentang</b><br>" +
		                    			"Kepulauan Seribu ditetapkan menjadi Taman Nasional Laut " +	                    			
		                    			"yang dikelola oleh Balai Taman Nasional Laut Kepulauan Seribu, " +
		                    			"Departemen Kehutanan. Luas wilayah 107.489 hektare dengan sekitar 44 buah " +
		                    			"pulau termasuk ke dalam taman nasional. Pulau-pulau yang terdapat di " +
		                    			"Kawasan Taman Nasional Kepulauan Seribu merupakan tempat ideal untuk snorkeling, " +
		                    			"berenang, atau menyelam. Kepulauan Seribu mempunyai pulau yang ditunjuk " +
		                    			"sebagai pulau suaka alam seperti P. Rambut dan P. Onrust yang ditunjuk sebagai " +
		                    			"pulau cagar budaya.");
		                	CharSequence alamatHtml = Html.fromHtml("<hr><br><b>Alamat</b><br>Pulau Seribu, Bidadari, Pantara, Kotok, Putri, Ayer, Sepa, Jl. Lodan Timur No.7 Marina Ancol Jakarta 14430 Telp : (021) 68274005 / (021)80889671");
		            
		                	title.setText(titleHtml);  
		                	isi.setText(isiHtml);
		                	alamat.setText(alamatHtml);
		        }         		            		    		    		    		  
			  
			  double distance = locationA.distanceTo(locationDest);  
			  
  		      double distanceKM = (distance * 0.001);							 	    		   		    		    		   		     	    		
		//  myLocationText.setText("Jarak (sekitar):\n" + distanceKM);
	
	}
}