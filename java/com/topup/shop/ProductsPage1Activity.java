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
import com.bumptech.glide.Glide;
import com.facebook.shimmer.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.rejowan.cutetoast.*;
import com.thecode.aestheticdialogs.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class ProductsPage1Activity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String fontName = "";
	private String typeace = "";
	
	private LinearLayout linear6;
	private LinearLayout linear8;
	private LinearLayout bottom_bar;
	private ScrollView vscroll2;
	private LinearLayout linear12;
	private LinearLayout linear_top_bar;
	private TextView textview11;
	private LinearLayout linear_products;
	private LinearLayout linearshimmer_main;
	private ImageView imageview10;
	private ImageView imageview6;
	private LinearLayout linear30;
	private LinearLayout linear15;
	private LinearLayout products1;
	private LinearLayout products2;
	private ImageView spi1;
	private TextView sn1;
	private ImageView spi2;
	private TextView sn2;
	private LinearLayout peoducts3;
	private LinearLayout peoducts4;
	private ImageView spi3;
	private TextView sn3;
	private ImageView spi4;
	private TextView sn4;
	private LinearLayout linear_shimmer;
	private LinearLayout linear41;
	private LinearLayout linear19;
	private LinearLayout linear2;
	private LinearLayout linear42;
	private ShimmerFrameLayout linear7;
	private ShimmerFrameLayout linear18;
	private LinearLayout linear20;
	private LinearLayout linear21;
	private ShimmerFrameLayout linear22;
	private ShimmerFrameLayout linear23;
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
	private DatabaseReference home = _firebase.getReference("home");
	private ChildEventListener _home_child_listener;
	private DatabaseReference phome = _firebase.getReference("phome");
	private ChildEventListener _phome_child_listener;
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	private TimerTask timer;
	private SharedPreferences im;
	private SharedPreferences c;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.products_page1);
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
		linearshimmer_main = findViewById(R.id.linearshimmer_main);
		imageview10 = findViewById(R.id.imageview10);
		imageview6 = findViewById(R.id.imageview6);
		linear30 = findViewById(R.id.linear30);
		linear15 = findViewById(R.id.linear15);
		products1 = findViewById(R.id.products1);
		products2 = findViewById(R.id.products2);
		spi1 = findViewById(R.id.spi1);
		sn1 = findViewById(R.id.sn1);
		spi2 = findViewById(R.id.spi2);
		sn2 = findViewById(R.id.sn2);
		peoducts3 = findViewById(R.id.peoducts3);
		peoducts4 = findViewById(R.id.peoducts4);
		spi3 = findViewById(R.id.spi3);
		sn3 = findViewById(R.id.sn3);
		spi4 = findViewById(R.id.spi4);
		sn4 = findViewById(R.id.sn4);
		linear_shimmer = findViewById(R.id.linear_shimmer);
		linear41 = findViewById(R.id.linear41);
		linear19 = findViewById(R.id.linear19);
		linear2 = findViewById(R.id.linear2);
		linear42 = findViewById(R.id.linear42);
		linear7 = findViewById(R.id.linear7);
		linear18 = findViewById(R.id.linear18);
		linear20 = findViewById(R.id.linear20);
		linear21 = findViewById(R.id.linear21);
		linear22 = findViewById(R.id.linear22);
		linear23 = findViewById(R.id.linear23);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		imageview2 = findViewById(R.id.imageview2);
		textview6 = findViewById(R.id.textview6);
		imageview3 = findViewById(R.id.imageview3);
		textview7 = findViewById(R.id.textview7);
		imageview4 = findViewById(R.id.imageview4);
		textview8 = findViewById(R.id.textview8);
		network = new RequestNetwork(this);
		im = getSharedPreferences("im", Activity.MODE_PRIVATE);
		c = getSharedPreferences("c", Activity.MODE_PRIVATE);
		
		products1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_clickAnimation(products1);
				i.setClass(getApplicationContext(), Product1Page1Activity.class);
				startActivity(i);
			}
		});
		
		products2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_clickAnimation(products2);
				i.setClass(getApplicationContext(), Product1Page2Activity.class);
				startActivity(i);
			}
		});
		
		peoducts3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_clickAnimation(peoducts3);
				i.setClass(getApplicationContext(), Product1Page3Activity.class);
				startActivity(i);
			}
		});
		
		peoducts4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_clickAnimation(peoducts4);
				i.setClass(getApplicationContext(), Product1Page4Activity.class);
				startActivity(i);
			}
		});
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), HomeActivity.class);
				startActivity(i);
			}
		});
		
		linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), MyOrderActivity.class);
				startActivity(i);
			}
		});
		
		linear5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ProfileActivity.class);
				startActivity(i);
			}
		});
		
		_home_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("image1")) {
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("image1").toString())).into(spi1);
				}
				if (_childValue.containsKey("image2")) {
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("image2").toString())).into(spi2);
				}
				if (_childValue.containsKey("image3")) {
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("image3").toString())).into(spi3);
				}
				if (_childValue.containsKey("image4")) {
					Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("image4").toString())).into(spi4);
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		home.addChildEventListener(_home_child_listener);
		
		_phome_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("n1")) {
					sn1.setText(_childValue.get("n1").toString());
				}
				if (_childValue.containsKey("n2")) {
					sn2.setText(_childValue.get("n2").toString());
				}
				if (_childValue.containsKey("n3")) {
					sn3.setText(_childValue.get("n3").toString());
				}
				if (_childValue.containsKey("n4")) {
					sn4.setText(_childValue.get("n4").toString());
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		phome.addChildEventListener(_phome_child_listener);
		
		_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				SketchwareUtil.showMessage(getApplicationContext(), "Loading success");
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.showMessage(getApplicationContext(), "Network error couldn't connect to server");
			}
		};
	}
	
	private void initializeLogic() {
		linear_top_bar.setElevation((float)10);
		linear_top_bar.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFFFFFFFF));
		bottom_bar.setElevation((float)10);
		bottom_bar.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFFFFFFFF));
		linear_products.setElevation((float)25);
		linear_products.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
		network.startRequestNetwork(RequestNetworkController.GET, "https://google.com/", "a", _network_request_listener);
		linear_products.setVisibility(View.GONE);
		linearshimmer_main.setElevation((float)25);
		linearshimmer_main.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
		_rippleRoundStroke(products1, "#f5f5f5", "#BDBDBD", 15, 1, "#ffffff");
		_rippleRoundStroke(products2, "#f5f5f5", "#BDBDBD", 15, 1, "#ffffff");
		_rippleRoundStroke(peoducts3, "#f5f5f5", "#BDBDBD", 15, 1, "#ffffff");
		_rippleRoundStroke(peoducts4, "#f5f5f5", "#BDBDBD", 15, 1, "#ffffff");
		_changeActivityFont("unionxsoftsans_bold");
		c.edit().putString("c", "uid/ing").commit();
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_TransitionManager(linear6, 300);
						linearshimmer_main.setVisibility(View.GONE);
						linear_products.setVisibility(View.VISIBLE);
					}
				});
			}
		};
		_timer.schedule(timer, (int)(SketchwareUtil.getRandom((int)(500), (int)(2500))));
	}
	
	public void _TransitionManager(final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
	
	public void _RippleEffects(final String _color, final View _view) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)});
		android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null);
		_view.setBackground(ripdr);
	}
	
	
	public void _rippleRoundStroke(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _changeActivityFont(final String _fontname) {
		fontName = "fonts/".concat(_fontname.concat(".ttf"));
		overrideFonts(this,getWindow().getDecorView()); 
	} 
	private void overrideFonts(final android.content.Context context, final View v) {
		
		try {
			Typeface 
			typeace = Typeface.createFromAsset(getAssets(), fontName);;
			if ((v instanceof ViewGroup)) {
				ViewGroup vg = (ViewGroup) v;
				for (int i = 0;
				i < vg.getChildCount();
				i++) {
					View child = vg.getChildAt(i);
					overrideFonts(context, child);
				}
			}
			else {
				if ((v instanceof TextView)) {
					((TextView) v).setTypeface(typeace);
				}
				else {
					if ((v instanceof EditText )) {
						((EditText) v).setTypeface(typeace);
					}
					else {
						if ((v instanceof Button)) {
							((Button) v).setTypeface(typeace);
						}
					}
				}
			}
		}
		catch(Exception e)
		
		{
			SketchwareUtil.showMessage(getApplicationContext(), "Error Loading Font");
		};
	}
	
	
	public void _clickAnimation(final View _view) {
		ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
		fade_in.setDuration(300);
		fade_in.setFillAfter(true);
		_view.startAnimation(fade_in);
	}
	
}