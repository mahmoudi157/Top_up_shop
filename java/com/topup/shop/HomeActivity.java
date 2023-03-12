package com.topup.shop;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
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
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.facebook.shimmer.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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

public class HomeActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private DrawerLayout _drawer;
	private String cc = "";
	private double saved_coin = 0;
	private double n_coin = 0;
	private double s_length = 0;
	private double n_length = 0;
	private String whtasapp_link = "";
	private double Profile_id = 0;
	private String titl = "";
	private String ms = "";
	private HashMap<String, Object> m = new HashMap<>();
	private String ban = "";
	private String balance = "";
	private String store_status = "";
	private String video_link = "";
	private String fontName = "";
	private String typeace = "";
	
	private ArrayList<String> ck = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> Im = new ArrayList<>();
	
	private LinearLayout linear_main1;
	private LinearLayout linear_main2;
	private LinearLayout bottom_bar;
	private LinearLayout linear1;
	private LinearLayout top_bar;
	private TextView textview_notice2;
	private TextView textview10;
	private LinearLayout linear_main_products;
	private LinearLayout Shimmerlay1;
	private ImageView imageview10;
	private ImageView imageview1;
	private LinearLayout shop_open_linear;
	private ImageView imageview11;
	private LinearLayout linear14;
	private ImageView imageview8;
	private TextView textview1;
	private TextView textview_shop;
	private TextView textview3;
	private TextView textview2;
	private ImageView image_wallet;
	private LinearLayout products_linear;
	private LinearLayout products1;
	private LinearLayout products2;
	private ImageView p1;
	private TextView n1;
	private ImageView p2;
	private TextView n2;
	private LinearLayout linear2;
	private LinearLayout linear37;
	private ShimmerFrameLayout linear7;
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
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_linear4;
	private LinearLayout _drawer_linear3;
	private LinearLayout _drawer_linear2;
	private LinearLayout _drawer_linear_exit;
	private ImageView _drawer_imageview1;
	private LinearLayout _drawer_linear5;
	private ImageView _drawer_close;
	private TextView _drawer_textview8;
	private LinearLayout _drawer_linear_addmoney;
	private LinearLayout _drawer_linear_profile;
	private LinearLayout _drawer_linear_order;
	private LinearLayout _drawer_linear_support;
	private LinearLayout _drawer_linear_about;
	private LinearLayout _drawer_linear_aboutapp;
	private ImageView _drawer_home_img;
	private TextView _drawer_textview1;
	private ImageView _drawer_support_img;
	private TextView _drawer_textview4;
	private ImageView _drawer_rate_img;
	private TextView _drawer_textview6;
	private ImageView _drawer_other_img;
	private TextView _drawer_textview5;
	private ImageView _drawer_about_img;
	private TextView _drawer_textview3;
	private ImageView _drawer_aboutapp_img;
	private TextView _drawer_textview2;
	private ImageView _drawer_exit_img;
	private TextView _drawer_textview7;
	
	private Intent i = new Intent();
	private AlertDialog.Builder d;
	private SharedPreferences coin;
	private TimerTask t;
	private SharedPreferences on;
	private SharedPreferences Auth;
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> _auth_create_user_listener;
	private OnCompleteListener<AuthResult> _auth_sign_in_listener;
	private OnCompleteListener<Void> _auth_reset_password_listener;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	
	private DatabaseReference home = _firebase.getReference("home");
	private ChildEventListener _home_child_listener;
	private DatabaseReference phome = _firebase.getReference("phome");
	private ChildEventListener _phome_child_listener;
	private DatabaseReference app_info = _firebase.getReference("app_info");
	private ChildEventListener _app_info_child_listener;
	private SharedPreferences sp2;
	private Intent web = new Intent();
	private DatabaseReference notification = _firebase.getReference("notification");
	private ChildEventListener _notification_child_listener;
	private RequestNetwork network;
	private RequestNetwork.RequestListener _network_request_listener;
	private TimerTask timer;
	private DatabaseReference user = _firebase.getReference("user");
	private ChildEventListener _user_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(HomeActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		linear_main1 = findViewById(R.id.linear_main1);
		linear_main2 = findViewById(R.id.linear_main2);
		bottom_bar = findViewById(R.id.bottom_bar);
		linear1 = findViewById(R.id.linear1);
		top_bar = findViewById(R.id.top_bar);
		textview_notice2 = findViewById(R.id.textview_notice2);
		textview10 = findViewById(R.id.textview10);
		linear_main_products = findViewById(R.id.linear_main_products);
		Shimmerlay1 = findViewById(R.id.Shimmerlay1);
		imageview10 = findViewById(R.id.imageview10);
		imageview1 = findViewById(R.id.imageview1);
		shop_open_linear = findViewById(R.id.shop_open_linear);
		imageview11 = findViewById(R.id.imageview11);
		linear14 = findViewById(R.id.linear14);
		imageview8 = findViewById(R.id.imageview8);
		textview1 = findViewById(R.id.textview1);
		textview_shop = findViewById(R.id.textview_shop);
		textview3 = findViewById(R.id.textview3);
		textview2 = findViewById(R.id.textview2);
		image_wallet = findViewById(R.id.image_wallet);
		products_linear = findViewById(R.id.products_linear);
		products1 = findViewById(R.id.products1);
		products2 = findViewById(R.id.products2);
		p1 = findViewById(R.id.p1);
		n1 = findViewById(R.id.n1);
		p2 = findViewById(R.id.p2);
		n2 = findViewById(R.id.n2);
		linear2 = findViewById(R.id.linear2);
		linear37 = findViewById(R.id.linear37);
		linear7 = findViewById(R.id.linear7);
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
		_drawer_linear1 = _nav_view.findViewById(R.id.linear1);
		_drawer_linear4 = _nav_view.findViewById(R.id.linear4);
		_drawer_linear3 = _nav_view.findViewById(R.id.linear3);
		_drawer_linear2 = _nav_view.findViewById(R.id.linear2);
		_drawer_linear_exit = _nav_view.findViewById(R.id.linear_exit);
		_drawer_imageview1 = _nav_view.findViewById(R.id.imageview1);
		_drawer_linear5 = _nav_view.findViewById(R.id.linear5);
		_drawer_close = _nav_view.findViewById(R.id.close);
		_drawer_textview8 = _nav_view.findViewById(R.id.textview8);
		_drawer_linear_addmoney = _nav_view.findViewById(R.id.linear_addmoney);
		_drawer_linear_profile = _nav_view.findViewById(R.id.linear_profile);
		_drawer_linear_order = _nav_view.findViewById(R.id.linear_order);
		_drawer_linear_support = _nav_view.findViewById(R.id.linear_support);
		_drawer_linear_about = _nav_view.findViewById(R.id.linear_about);
		_drawer_linear_aboutapp = _nav_view.findViewById(R.id.linear_aboutapp);
		_drawer_home_img = _nav_view.findViewById(R.id.home_img);
		_drawer_textview1 = _nav_view.findViewById(R.id.textview1);
		_drawer_support_img = _nav_view.findViewById(R.id.support_img);
		_drawer_textview4 = _nav_view.findViewById(R.id.textview4);
		_drawer_rate_img = _nav_view.findViewById(R.id.rate_img);
		_drawer_textview6 = _nav_view.findViewById(R.id.textview6);
		_drawer_other_img = _nav_view.findViewById(R.id.other_img);
		_drawer_textview5 = _nav_view.findViewById(R.id.textview5);
		_drawer_about_img = _nav_view.findViewById(R.id.about_img);
		_drawer_textview3 = _nav_view.findViewById(R.id.textview3);
		_drawer_aboutapp_img = _nav_view.findViewById(R.id.aboutapp_img);
		_drawer_textview2 = _nav_view.findViewById(R.id.textview2);
		_drawer_exit_img = _nav_view.findViewById(R.id.exit_img);
		_drawer_textview7 = _nav_view.findViewById(R.id.textview7);
		d = new AlertDialog.Builder(this);
		coin = getSharedPreferences("coin", Activity.MODE_PRIVATE);
		on = getSharedPreferences("on", Activity.MODE_PRIVATE);
		Auth = getSharedPreferences("Auth", Activity.MODE_PRIVATE);
		auth = FirebaseAuth.getInstance();
		sp2 = getSharedPreferences("sp2", Activity.MODE_PRIVATE);
		network = new RequestNetwork(this);
		
		textview10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse(video_link));
				startActivity(i);
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.openDrawer(GravityCompat.START);
			}
		});
		
		image_wallet.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AddMoneyActivity.class);
				startActivity(i);
			}
		});
		
		products1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_clickAnimation(products1);
				i.setClass(getApplicationContext(), ProductsPage1Activity.class);
				startActivity(i);
			}
		});
		
		products2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_clickAnimation(products2);
				i.setClass(getApplicationContext(), Product2page1Activity.class);
				startActivity(i);
			}
		});
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), HomeActivity.class);
				startActivity(i);
				SketchwareUtil.showMessage(getApplicationContext(), "Already in home page");
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
				if (_childKey.equals("image")) {
					if (_childValue.containsKey("imagehome1")) {
						Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("imagehome1").toString())).into(p1);
					}
					if (_childValue.containsKey("imagehome2")) {
						Glide.with(getApplicationContext()).load(Uri.parse(_childValue.get("imagehome2").toString())).into(p2);
					}
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
				if (_childValue.containsKey("nhome1")) {
					n1.setText(_childValue.get("nhome1").toString());
				}
				if (_childValue.containsKey("nhome2")) {
					n2.setText(_childValue.get("nhome2").toString());
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
		
		_app_info_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("notice")) {
					textview_shop.setText(_childValue.get("notice").toString());
					on.edit().putString("on", _childValue.get("notice").toString()).commit();
				}
				if (_childValue.containsKey("notice2")) {
					textview_notice2.setText(_childValue.get("notice2").toString());
				}
				if (_childValue.containsKey("whtasapp_link")) {
					whtasapp_link = _childValue.get("whtasapp_link").toString();
				}
				if (_childValue.containsKey("video_link")) {
					video_link = _childValue.get("video_link").toString();
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("notice")) {
					textview_shop.setText(_childValue.get("notice").toString());
					on.edit().putString("on", _childValue.get("notice").toString()).commit();
				}
				if (_childValue.get("notice").toString().equals("Closed")) {
					textview1.setTextColor(0xFFF44336);
					textview_shop.setTextColor(0xFFF44336);
					textview_notice2.setTextColor(0xFFF44336);
					imageview8.setColorFilter(0xFFF44336, PorterDuff.Mode.MULTIPLY);
				}
				if (_childValue.get("notice").toString().equals("Open")) {
					textview1.setTextColor(0xFF4CAF50);
					textview_shop.setTextColor(0xFF4CAF50);
					textview_notice2.setTextColor(0xFF4CAF50);
					imageview8.setColorFilter(0xFF4CAF50, PorterDuff.Mode.MULTIPLY);
				}
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
		app_info.addChildEventListener(_app_info_child_listener);
		
		_notification_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.get("uid").toString().equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					titl = _childValue.get("title").toString();
					ms = _childValue.get("message").toString();
					_set_Notification(titl, ms);
				}
				else {
					if (_childValue.get("uid").toString().equals("All")) {
						titl = _childValue.get("title").toString();
						ms = _childValue.get("message").toString();
						_set_Notification(titl, ms);
					}
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
		notification.addChildEventListener(_notification_child_listener);
		
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
				SketchwareUtil.showMessage(getApplicationContext(), "Network Error , Couldn't connect to server.");
			}
		};
		
		_user_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					if (_childValue.get("ban").toString().equals("true")) {
						i.setClass(getApplicationContext(), BanActivity.class);
						startActivity(i);
					}
					if (_childValue.containsKey("balance")) {
						balance = _childValue.get("balance").toString();
						coin.edit().putString("saved", balance).commit();
						textview2.setText(balance);
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
					if (_childValue.containsKey("balance")) {
						balance = _childValue.get("balance").toString();
						coin.edit().putString("saved", balance).commit();
						textview2.setText(balance);
					}
				}
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
		user.addChildEventListener(_user_child_listener);
		
		_drawer_linear_exit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				d.setTitle("Exit");
				d.setMessage("Are you sure want to be exit.");
				d.setIcon(R.drawable.close);
				d.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						finishAffinity();
					}
				});
				d.setNegativeButton("No", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.create().show();
			}
		});
		
		_drawer_close.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_linear_addmoney.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AddMoneyActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_linear_profile.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ProfileActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_linear_order.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), MyOrderActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_linear_support.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Profile_id = 9;
				_ProfileAction();
			}
		});
		
		_drawer_linear_about.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AboutActivity.class);
				startActivity(i);
			}
		});
		
		_drawer_linear_aboutapp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				FirebaseAuth.getInstance().signOut();
				SketchwareUtil.showMessage(getApplicationContext(), "Successfully Logged Out");
				i.setClass(getApplicationContext(), LoginActivity.class);
				startActivity(i);
			}
		});
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean _success = task.isSuccessful();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				
			}
		};
		
		_auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> _param1) {
				final boolean _success = _param1.isSuccessful();
				
			}
		};
	}
	
	private void initializeLogic() {
		linear_main_products.setVisibility(View.GONE);
		linear_main_products.setElevation((float)10);
		linear_main_products.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
		Shimmerlay1.setElevation((float)10);
		Shimmerlay1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
		bottom_bar.setElevation((float)10);
		bottom_bar.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFFFFFFFF));
		top_bar.setElevation((float)10);
		top_bar.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
		shop_open_linear.setElevation((float)10);
		shop_open_linear.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFFFFFFFF));
		_Drawer_Ui();
		_OnCreate();
		textview_shop.setText(on.getString("on", ""));
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						on.edit().putString("on", textview_shop.getText().toString()).commit();
						if (on.getString("on", "").equals("Closed")) {
							textview1.setTextColor(0xFFF44336);
							textview_shop.setTextColor(0xFFF44336);
							textview_notice2.setTextColor(0xFFF44336);
							imageview8.setColorFilter(0xFFF44336, PorterDuff.Mode.MULTIPLY);
							AestheticDialog.showFlashDialog(HomeActivity.this, "Can't Order's now", "Shop will be reopen Soon", AestheticDialog.ERROR);
						}
						else {
							AestheticDialog.showFlashDialog(HomeActivity.this, "Shop is Open", "We are Accepting new Order's", AestheticDialog.SUCCESS);
						}
					}
				});
			}
		};
		_timer.schedule(t, (int)(2500));
		network.startRequestNetwork(RequestNetworkController.GET, "https://google.com/", "a", _network_request_listener);
		_changeActivityFont("unionxsoftsans_bold");
		timer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_TransitionManager(linear1, 300);
						Shimmerlay1.setVisibility(View.GONE);
						linear_main_products.setVisibility(View.VISIBLE);
					}
				});
			}
		};
		_timer.schedule(timer, (int)(SketchwareUtil.getRandom((int)(100), (int)(2000))));
	}
	
	@Override
	public void onBackPressed() {
		if (_drawer.isDrawerOpen(GravityCompat.START)) {
			_drawer.closeDrawer(GravityCompat.START);
		}
		else {
			d.setTitle("Quiet Now?");
			d.setMessage("Are you sure want to be exit");
			d.setIcon(R.drawable.image_4);
			d.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					finishAffinity();
				}
			});
			d.setNegativeButton("no", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface _dialog, int _which) {
					
				}
			});
			d.create().show();
		}
	}
	public void _Drawer_Ui() {
		final LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view); _nav_view.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
		_RadiusGradient4(_drawer_linear1, "#ffffff", "#ffffff", 0, 100, 100, 0, 0, "#ffffff");
		//close
		_ICC(_drawer_close, "#615CB7", "#757575");
		_RippleEffects("#e0e0e0", _drawer_close);
		//Home
		_ICC(_drawer_home_img, "#ffffff", "#f5f5f5");
		_RippleEffects("#e0e0e0", _drawer_home_img);
		_rippleRoundStroke(_drawer_linear_order, "#696BE6", "#f5f5f5", 15, 0, "#ffffff");
		//About app
		_ICC(_drawer_aboutapp_img, "#CBD0DA", "#615CB7");
		_RippleEffects("#e0e0e0", _drawer_aboutapp_img);
		_rippleRoundStroke(_drawer_linear_aboutapp, "#f5f5f5", "#e0e0e0", 15, 0, "#ffffff");
		//About us
		_ICC(_drawer_about_img, "#CBD0DA", "#615CB7");
		_RippleEffects("#e0e0e0", _drawer_about_img);
		_rippleRoundStroke(_drawer_linear_about, "#f5f5f5", "#e0e0e0", 15, 0, "#ffffff");
		//Dontate
		_ICC(_drawer_support_img, "#CBD0DA", "#615CB7");
		_RippleEffects("#e0e0e0", _drawer_support_img);
		_rippleRoundStroke(_drawer_linear_support, "#f5f5f5", "#e0e0e0", 15, 0, "#ffffff");
		//Other
		_ICC(_drawer_other_img, "#CBD0DA", "#615CB7");
		_RippleEffects("#e0e0e0", _drawer_other_img);
		_rippleRoundStroke(_drawer_linear_support, "#f5f5f5", "#e0e0e0", 15, 0, "#ffffff");
		//Rate
		_ICC(_drawer_rate_img, "#CBD0DA", "#615CB7");
		_RippleEffects("#e0e0e0", _drawer_rate_img);
		_rippleRoundStroke(_drawer_linear_profile, "#f5f5f5", "#e0e0e0", 15, 0, "#ffffff");
		//Exit
		_ICC(_drawer_exit_img, "#CBD0DA", "#615CB7");
		_RippleEffects("#e0e0e0", _drawer_exit_img);
		_exit(_drawer_linear_exit, "#696BE6", "#f5f5f5", 0, 0, "#ffffff");
	}
	
	
	public void _OnCreate() {
		_NavStatusBarColor("#FFFFFF", "#FFFFFF");
		_toolbar.setVisibility(View.GONE);
		_RippleEffects("#e0e0e0", linear3);
		_RippleEffects("#e0e0e0", linear4);
		_RippleEffects("#e0e0e0", linear5);
		_rippleRoundStroke(linear3, "#f5f5f5", "#e0e0e0", 15, 0, "#ffffff");
		_rippleRoundStroke(linear4, "#f5f5f5", "#e0e0e0", 15, 0, "#ffffff");
		_rippleRoundStroke(linear5, "#f5f5f5", "#e0e0e0", 15, 0, "#ffffff");
		_rippleRoundStroke(products1, "#f5f5f5", "#e0e0e0", 15, 0, "#ffffff");
		_rippleRoundStroke(products2, "#f5f5f5", "#e0e0e0", 15, 0, "#ffffff");
	}
	
	
	public void _exit(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		
		
		
		GG.setCornerRadii(new float[] { 0, 0, 100, 100, 100, 100, 0, 0 }); //LeftTop, //RightTop, //RightBottom, //LeftBottom,
		
		
		
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _RadiusGradient4(final View _view, final String _color1, final String _color2, final double _lt, final double _rt, final double _rb, final double _lb, final double _border, final String _color3) {
		int[] colors = { Color.parseColor(_color1), Color.parseColor(_color2) }; android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, colors);
		gd.setCornerRadii(new float[]{(int)_lt,(int)_lt,(int)_rt,(int)_rt,(int)_rb,(int)_rb,(int)_lb,(int)_lb});
		gd.setStroke((int) _border, Color.parseColor(_color3));
		_view.setBackground(gd);
	}
	
	
	public void _ICC(final ImageView _img, final String _c1, final String _c2) {
		_img.setImageTintList(new android.content.res.ColorStateList(new int[][] {{-android.R.attr.state_pressed},{android.R.attr.state_pressed}},new int[]{Color.parseColor(_c1), Color.parseColor(_c2)}));
	}
	
	
	public void _RippleEffects(final String _color, final View _view) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)});
		android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null);
		_view.setBackground(ripdr);
	}
	
	
	public void _NavStatusBarColor(final String _color1, final String _color2) {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);	w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(Color.parseColor("#" + _color1.replace("#", "")));	w.setNavigationBarColor(Color.parseColor("#" + _color2.replace("#", "")));
		}
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
	
	
	public void _ProfileAction() {
		if (Profile_id == 9) {
			web.setAction(Intent.ACTION_VIEW);
			web.setData(Uri.parse(whtasapp_link));
			startActivity(web);
		}
	}
	
	
	public void _set_Notification(final String _Title, final String _Message) {
		/*
Developer :- mohammed atta channel
Powered by :- Gopal
*/
		
		final Context context = getApplicationContext();
		
		
		NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		Intent intent = new Intent(this, MainActivity.class); 
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); 
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0); 
		androidx.core.app.NotificationCompat.Builder builder; 
		
		    int notificationId = 1;
		    String channelId = "channel-01";
		    String channelName = "Channel Name";
		    int importance = NotificationManager.IMPORTANCE_HIGH;
		
		    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
			        NotificationChannel mChannel = new NotificationChannel(
			                channelId, channelName, importance);
			        notificationManager.createNotificationChannel(mChannel);
			    }
		
		  
		 androidx.core.app.NotificationCompat.Builder mBuilder = new androidx.core.app.NotificationCompat.Builder(context, channelId)
		            .setSmallIcon(R.drawable.icon)
		            .setContentTitle(_Title)
		            .setContentText(_Message)
		            .setAutoCancel(true)
		            .setOngoing(false)
		            .setContentIntent(pendingIntent);
		    TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
		    stackBuilder.addNextIntent(intent);
		    PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
		            0,
		            PendingIntent.FLAG_UPDATE_CURRENT
		    );
		    mBuilder.setContentIntent(resultPendingIntent);
		
		    notificationManager.notify(notificationId, mBuilder.build());
		
	}
	
	
	public void _TransitionManager(final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
	
	public void _telegramLoaderDialog(final boolean _visibility) {
		if (_visibility) {
			if (coreprog == null){
				coreprog = new ProgressDialog(this);
				coreprog.setCancelable(false);
				coreprog.setCanceledOnTouchOutside(false);
				
				coreprog.requestWindowFeature(Window.FEATURE_NO_TITLE);  coreprog.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
				
			}
			coreprog.show();
			coreprog.setContentView(R.layout.loading);
			
			
			LinearLayout linear2 = (LinearLayout)coreprog.findViewById(R.id.linear2);
			
			LinearLayout background = (LinearLayout)coreprog.findViewById(R.id.background);
			
			LinearLayout layout_progress = (LinearLayout)coreprog.findViewById(R.id.layout_progress);
			
			
			
			RadialProgressView progress = new RadialProgressView(this);
			layout_progress.addView(progress);
		}
		else {
			if (coreprog != null){
				coreprog.dismiss();
			}
		}
	}
	private ProgressDialog coreprog;
	{
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