package com.topup.shop;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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

public class MyOrderActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	
	private LinearLayout linear6;
	private LinearLayout linear8;
	private LinearLayout bottom_bar;
	private LinearLayout linear14;
	private TextView textview10;
	private ListView listview2;
	private LinearLayout linear_shimmer;
	private ImageView imageview7;
	private LinearLayout linear29;
	private LinearLayout linear31;
	private LinearLayout linear33;
	private LinearLayout linear35;
	private LinearLayout linear37;
	private ShimmerFrameLayout linear27;
	private ShimmerFrameLayout linear32;
	private ShimmerFrameLayout linear34;
	private ShimmerFrameLayout linear36;
	private ShimmerFrameLayout linear38;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private ImageView imageview2;
	private TextView textview6;
	private ImageView imageview3;
	private TextView textview7;
	private ImageView imageview4;
	private TextView textview8;
	
	private DatabaseReference order = _firebase.getReference("order");
	private ChildEventListener _order_child_listener;
	private SharedPreferences Auth;
	private Intent i = new Intent();
	private TimerTask t;
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	private TimerTask timer;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.my_order);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear6 = findViewById(R.id.linear6);
		linear8 = findViewById(R.id.linear8);
		bottom_bar = findViewById(R.id.bottom_bar);
		linear14 = findViewById(R.id.linear14);
		textview10 = findViewById(R.id.textview10);
		listview2 = findViewById(R.id.listview2);
		linear_shimmer = findViewById(R.id.linear_shimmer);
		imageview7 = findViewById(R.id.imageview7);
		linear29 = findViewById(R.id.linear29);
		linear31 = findViewById(R.id.linear31);
		linear33 = findViewById(R.id.linear33);
		linear35 = findViewById(R.id.linear35);
		linear37 = findViewById(R.id.linear37);
		linear27 = findViewById(R.id.linear27);
		linear32 = findViewById(R.id.linear32);
		linear34 = findViewById(R.id.linear34);
		linear36 = findViewById(R.id.linear36);
		linear38 = findViewById(R.id.linear38);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		imageview2 = findViewById(R.id.imageview2);
		textview6 = findViewById(R.id.textview6);
		imageview3 = findViewById(R.id.imageview3);
		textview7 = findViewById(R.id.textview7);
		imageview4 = findViewById(R.id.imageview4);
		textview8 = findViewById(R.id.textview8);
		Auth = getSharedPreferences("Auth", Activity.MODE_PRIVATE);
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
		
		_order_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				listmap.add((int)0, _childValue);
				listview2.setAdapter(new Listview2Adapter(listmap));
				((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
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
		order.addChildEventListener(_order_child_listener);
		
		_network_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				timer = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_TransitionManager(linear6, 300);
								linear_shimmer.setVisibility(View.GONE);
								listview2.setVisibility(View.VISIBLE);
							}
						});
					}
				};
				_timer.schedule(timer, (int)(SketchwareUtil.getRandom((int)(1000), (int)(3000))));
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.showMessage(getApplicationContext(), _message);
				SketchwareUtil.showMessage(getApplicationContext(), "Network Error");
			}
		};
	}
	
	private void initializeLogic() {
		bottom_bar.setElevation((float)10);
		bottom_bar.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFFFFFFFF));
		linear14.setElevation((float)10);
		linear14.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFFFFFFFF));
		network.startRequestNetwork(RequestNetworkController.GET, "https://google.com/", "a", _network_request_listener);
		listview2.setVisibility(View.GONE);
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
	
	public class Listview2Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview2Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.order, null);
			}
			
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final LinearLayout linear9 = _view.findViewById(R.id.linear9);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final LinearLayout linear10 = _view.findViewById(R.id.linear10);
			final TextView textview7 = _view.findViewById(R.id.textview7);
			final TextView textview_key = _view.findViewById(R.id.textview_key);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			final TextView products = _view.findViewById(R.id.products);
			final TextView price = _view.findViewById(R.id.price);
			final TextView status = _view.findViewById(R.id.status);
			final TextView time = _view.findViewById(R.id.time);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			final TextView transection = _view.findViewById(R.id.transection);
			final TextView textview8 = _view.findViewById(R.id.textview8);
			final TextView textview_note = _view.findViewById(R.id.textview_note);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);
			
			if (listmap.get((int)_position).get("Auth").toString().equals(Auth.getString("Auth", ""))) {
				linear4.setVisibility(View.VISIBLE);
			}
			else {
				linear4.setVisibility(View.GONE);
			}
			if (_data.get((int)_position).containsKey("Time")) {
				time.setText("".concat(_data.get((int)_position).get("Time").toString()));
			}
			if (_data.get((int)_position).containsKey("amount")) {
				price.setText("₹".concat(_data.get((int)_position).get("amount").toString()));
			}
			if (_data.get((int)_position).containsKey("Progress")) {
				status.setText("(".concat(_data.get((int)_position).get("Progress").toString().concat(")")));
			}
			if (_data.get((int)_position).containsKey("iteam")) {
				products.setText("".concat(_data.get((int)_position).get("iteam").toString()));
			}
			if (_data.get((int)_position).containsKey("Key")) {
				textview_key.setText("".concat(_data.get((int)_position).get("Key").toString()));
			}
			if (_data.get((int)_position).containsKey("note")) {
				textview_note.setText("".concat(_data.get((int)_position).get("note").toString()));
			}
			if (_data.get((int)_position).containsKey("payment")) {
				transection.setText("".concat(_data.get((int)_position).get("payment").toString()));
			}
			if (status.getText().toString().equals("(Success)")) {
				status.setTextColor(0xFF009688);
			}
			if (status.getText().toString().equals("(Failed)")) {
				status.setTextColor(0xFFF44336);
			}
			if (status.getText().toString().equals("(Refunded)")) {
				status.setTextColor(0xFFFFEB3B);
			}
			linear4.setElevation((float)10);
			linear4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFFFFFFFF));
			imageview1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", textview_key.getText().toString()));
					SketchwareUtil.showMessage(getApplicationContext(), "Copied");
				}
			});
			imageview2.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", textview_note.getText().toString()));
					SketchwareUtil.showMessage(getApplicationContext(), "Copied");
				}
			});
			
			return _view;
		}
	}
}