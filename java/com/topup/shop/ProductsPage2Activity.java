package com.topup.shop;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.shimmer.*;
import com.google.firebase.FirebaseApp;
import com.rejowan.cutetoast.*;
import com.thecode.aestheticdialogs.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class ProductsPage2Activity extends AppCompatActivity {
	
	private LinearLayout linear6;
	private LinearLayout linear8;
	private LinearLayout bottom_bar;
	private ScrollView vscroll2;
	private LinearLayout linear12;
	private LinearLayout linear_top_bar;
	private TextView textview11;
	private LinearLayout linear_products;
	private ImageView imageview10;
	private ImageView imageview6;
	private LinearLayout linear10;
	private LinearLayout linear15;
	private LinearLayout products1;
	private LinearLayout products2;
	private ImageView imageview5;
	private TextView textview4;
	private ImageView imageview7;
	private TextView textview5;
	private LinearLayout linear16;
	private LinearLayout linear17;
	private ImageView imageview8;
	private TextView textview9;
	private ImageView imageview9;
	private TextView textview10;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private ImageView imageview2;
	private TextView textview6;
	private ImageView imageview3;
	private TextView textview7;
	private ImageView imageview4;
	private TextView textview8;
	
	private Intent i = new Intent();
	private SharedPreferences c;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.products_page2);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear6 = findViewById(R.id.linear6);
		linear8 = findViewById(R.id.linear8);
		bottom_bar = findViewById(R.id.bottom_bar);
		vscroll2 = findViewById(R.id.vscroll2);
		linear12 = findViewById(R.id.linear12);
		linear_top_bar = findViewById(R.id.linear_top_bar);
		textview11 = findViewById(R.id.textview11);
		linear_products = findViewById(R.id.linear_products);
		imageview10 = findViewById(R.id.imageview10);
		imageview6 = findViewById(R.id.imageview6);
		linear10 = findViewById(R.id.linear10);
		linear15 = findViewById(R.id.linear15);
		products1 = findViewById(R.id.products1);
		products2 = findViewById(R.id.products2);
		imageview5 = findViewById(R.id.imageview5);
		textview4 = findViewById(R.id.textview4);
		imageview7 = findViewById(R.id.imageview7);
		textview5 = findViewById(R.id.textview5);
		linear16 = findViewById(R.id.linear16);
		linear17 = findViewById(R.id.linear17);
		imageview8 = findViewById(R.id.imageview8);
		textview9 = findViewById(R.id.textview9);
		imageview9 = findViewById(R.id.imageview9);
		textview10 = findViewById(R.id.textview10);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		imageview2 = findViewById(R.id.imageview2);
		textview6 = findViewById(R.id.textview6);
		imageview3 = findViewById(R.id.imageview3);
		textview7 = findViewById(R.id.textview7);
		imageview4 = findViewById(R.id.imageview4);
		textview8 = findViewById(R.id.textview8);
		c = getSharedPreferences("c", Activity.MODE_PRIVATE);
		
		products1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				c.edit().putString("c", "other").commit();
				i.setClass(getApplicationContext(), Product2page1Activity.class);
				startActivity(i);
			}
		});
		
		products2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				c.edit().putString("c", "social").commit();
				i.setClass(getApplicationContext(), Product2page1Activity.class);
				startActivity(i);
			}
		});
	}
	
	private void initializeLogic() {
		linear_top_bar.setElevation((float)10);
		linear_top_bar.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFFFFFFFF));
		bottom_bar.setElevation((float)10);
		bottom_bar.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFFFFFFFF));
		linear_products.setElevation((float)25);
		linear_products.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
	}
	
}