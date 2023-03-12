package com.topup.shop;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class Product1Page1Activity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	
	private LinearLayout linear6;
	private LinearLayout linear8;
	private LinearLayout bottom_bar;
	private LinearLayout linear14;
	private GridView gridview1;
	private LinearLayout shimmer_layer1;
	private ImageView imageview7;
	private LinearLayout linear37;
	private LinearLayout Shimmerlay1;
	private LinearLayout linear50;
	private LinearLayout linear55;
	private LinearLayout linear38;
	private LinearLayout linear39;
	private ShimmerFrameLayout linear40;
	private ShimmerFrameLayout linear41;
	private LinearLayout linear2;
	private LinearLayout linear34;
	private ShimmerFrameLayout linear7;
	private ShimmerFrameLayout linear36;
	private LinearLayout linear51;
	private LinearLayout linear52;
	private ShimmerFrameLayout linear53;
	private ShimmerFrameLayout linear54;
	private LinearLayout linear56;
	private LinearLayout linear57;
	private ShimmerFrameLayout linear58;
	private ShimmerFrameLayout linear59;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private ImageView imageview2;
	private TextView textview6;
	private ImageView imageview3;
	private TextView textview7;
	private ImageView imageview4;
	private TextView textview8;
	
	private DatabaseReference products1 = _firebase.getReference("product1page1");
	private ChildEventListener _products1_child_listener;
	private Intent i = new Intent();
	private TimerTask t;
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	private TimerTask timer;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.product1_page1);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear6 = findViewById(R.id.linear6);
		linear8 = findViewById(R.id.linear8);
		bottom_bar = findViewById(R.id.bottom_bar);
		linear14 = findViewById(R.id.linear14);
		gridview1 = findViewById(R.id.gridview1);
		shimmer_layer1 = findViewById(R.id.shimmer_layer1);
		imageview7 = findViewById(R.id.imageview7);
		linear37 = findViewById(R.id.linear37);
		Shimmerlay1 = findViewById(R.id.Shimmerlay1);
		linear50 = findViewById(R.id.linear50);
		linear55 = findViewById(R.id.linear55);
		linear38 = findViewById(R.id.linear38);
		linear39 = findViewById(R.id.linear39);
		linear40 = findViewById(R.id.linear40);
		linear41 = findViewById(R.id.linear41);
		linear2 = findViewById(R.id.linear2);
		linear34 = findViewById(R.id.linear34);
		linear7 = findViewById(R.id.linear7);
		linear36 = findViewById(R.id.linear36);
		linear51 = findViewById(R.id.linear51);
		linear52 = findViewById(R.id.linear52);
		linear53 = findViewById(R.id.linear53);
		linear54 = findViewById(R.id.linear54);
		linear56 = findViewById(R.id.linear56);
		linear57 = findViewById(R.id.linear57);
		linear58 = findViewById(R.id.linear58);
		linear59 = findViewById(R.id.linear59);
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
		
		_products1_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				products1.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						gridview1.setAdapter(new Gridview1Adapter(listmap));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
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
		products1.addChildEventListener(_products1_child_listener);
		
		_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				SketchwareUtil.showMessage(getApplicationContext(), "Loading Success");
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.showMessage(getApplicationContext(), _message);
				SketchwareUtil.showMessage(getApplicationContext(), "Network Error , Couldn't connect to server.");
			}
		};
	}
	
	private void initializeLogic() {
		bottom_bar.setElevation((float)10);
		bottom_bar.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFFFFFFFF));
		linear14.setElevation((float)10);
		linear14.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFFFFFFFF));
		_RippleEffects("#e0e0e0", linear3);
		_RippleEffects("#e0e0e0", linear4);
		_RippleEffects("#e0e0e0", linear5);
		_rippleRoundStroke(linear3, "#f5f5f5", "#e0e0e0", 15, 0, "#ffffff");
		_rippleRoundStroke(linear4, "#f5f5f5", "#e0e0e0", 15, 0, "#ffffff");
		_rippleRoundStroke(linear5, "#f5f5f5", "#e0e0e0", 15, 0, "#ffffff");
		network.startRequestNetwork(RequestNetworkController.GET, "https://google.com/", "a", _network_request_listener);
		gridview1.setVisibility(View.GONE);
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_TransitionManager(linear6, 300);
						shimmer_layer1.setVisibility(View.GONE);
						gridview1.setVisibility(View.VISIBLE);
					}
				});
			}
		};
		_timer.schedule(timer, (int)(SketchwareUtil.getRandom((int)(100), (int)(1500))));
	}
	
	public void _clickAnimation(final View _view) {
		ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
		fade_in.setDuration(300);
		fade_in.setFillAfter(true);
		_view.startAnimation(fade_in);
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
	
	
	public void _UptimeLoadingDialog(final boolean _visibility) {
		if (_visibility) {
			if (UptimeLoadingDialog== null){
					UptimeLoadingDialog = new ProgressDialog(this);
					UptimeLoadingDialog.setCancelable(false);
					UptimeLoadingDialog.setCanceledOnTouchOutside(false);
					
					UptimeLoadingDialog.requestWindowFeature(Window.FEATURE_NO_TITLE); 
					UptimeLoadingDialog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
					
			}
			UptimeLoadingDialog.show();
			UptimeLoadingDialog.setContentView(R.layout.loading);
			
			LinearLayout loading_bar_layout = (LinearLayout)UptimeLoadingDialog.findViewById(R.id.loading_bar_layout);
			
			
			loading_bar_layout.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)100, 0xFFFFFFFF));
		}
		else {
			if (UptimeLoadingDialog != null){
				UptimeLoadingDialog.dismiss();
			}
		}
	}
	private ProgressDialog UptimeLoadingDialog;
	{
	}
	
	
	public void _TransitionManager(final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
	public class Gridview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Gridview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.product2, null);
			}
			
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final TextView amount = _view.findViewById(R.id.amount);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final TextView Category = _view.findViewById(R.id.Category);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final TextView Price = _view.findViewById(R.id.Price);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView Category2 = _view.findViewById(R.id.Category2);
			
			if (_data.get((int)_position).containsKey("price")) {
				Price.setText("৳".concat(_data.get((int)_position).get("price").toString()));
			}
			if (_data.get((int)_position).containsKey("price")) {
				textview2.setText(_data.get((int)_position).get("price").toString());
			}
			if (_data.get((int)_position).containsKey("category")) {
				Category.setText(_data.get((int)_position).get("category").toString());
			}
			if (_data.get((int)_position).containsKey("category2")) {
				Category2.setText(_data.get((int)_position).get("category2").toString());
			}
			if (_data.get((int)_position).containsKey("name")) {
				amount.setText(_data.get((int)_position).get("name").toString());
			}
			if (_data.get((int)_position).containsKey("image")) {
				Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("image").toString())).into(imageview1);
			}
			linear4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFF7BDB53));
			amount.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/emon.ttf"), 1);
			Price.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/emon.ttf"), 1);
			Category2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/emon.ttf"), 1);
			linear2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					if (Category.getText().toString().contains("uid")) {
						_clickAnimation(linear2);
						i.putExtra("name", amount.getText().toString());
						i.putExtra("price", textview2.getText().toString());
						i.setClass(getApplicationContext(), PaymentIngameActivity.class);
						startActivity(i);
					}
					if (Category.getText().toString().contains("ing")) {
						_clickAnimation(linear2);
						i.putExtra("name", amount.getText().toString());
						i.putExtra("price", textview2.getText().toString());
						i.setClass(getApplicationContext(), PaymentUidActivity.class);
						startActivity(i);
					}
					if (Category.getText().toString().contains("out")) {
						_clickAnimation(linear2);
						AestheticDialog.showFlashDialog(Product1Page1Activity.this, "STOCK OUT", "This products is currently out of stock", AestheticDialog.ERROR);
					}
				}
			});
			linear2.setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View _view) {
					_clickAnimation(linear2);
					return true;
				}
			});
			
			return _view;
		}
	}
}