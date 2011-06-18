package com.alfach.JakartaTourism;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageAdapter5 extends BaseAdapter {

	private Context context;
	private int itemBackground;
	
	Integer[] imageIDs = {
			R.drawable.ancol1,
			R.drawable.ancol2,
			R.drawable.ancol3
	};
	
	public ImageAdapter5(Context c) {
		// TODO Auto-generated constructor stub
		context = c;
		TypedArray a = c.obtainStyledAttributes(R.styleable.Gallery1);
		itemBackground = a.getResourceId(
			R.styleable.Gallery1_android_galleryItemBackground, 0);
		a.recycle();
	}	
	
	public int getCount() {
		// TODO Auto-generated method stub
		return imageIDs.length;
		
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ImageView imageView = new ImageView(context);
		imageView.setImageResource(imageIDs[position]);
		imageView.setScaleType(ImageView.ScaleType.FIT_XY);
		imageView.setLayoutParams(new Gallery.LayoutParams(150,120));
		imageView.setBackgroundResource(itemBackground);
		return imageView;
	}        	
}
