package com.topup.shop;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
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
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
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
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class PaymentIngameActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private String getKey = "";
	private HashMap<String, Object> m = new HashMap<>();
	private HashMap<String, Object> mm = new HashMap<>();
	private String total = "";
	private String social = "";
	private String fontName = "";
	private String typeace = "";
	
	private LinearLayout linear6;
	private LinearLayout linear8;
	private LinearLayout bottom_bar;
	private ScrollView vscroll2;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private LinearLayout linear15;
	private LinearLayout linear16;
	private TextView products_name;
	private LinearLayout linear17;
	private LinearLayout linear_topup;
	private TextView textview_category;
	private ImageView imageview7;
	private ImageView imageview6;
	private TextView textview9;
	private TextView main_balance;
	private TextView textview10;
	private TextView price;
	private TextView textview_requirement;
	private TextView textview13;
	private TextView textview15;
	private TextView textview12;
	private TextView textview16;
	private LinearLayout l_player_id;
	private LinearLayout l_gameName;
	private LinearLayout l_number;
	private LinearLayout linear_payment;
	private LinearLayout l_lastnumber;
	private CheckBox checkbox1;
	private TextView method;
	private Button button2;
	private Button button1;
	private TextView textview11;
	private ImageView imageview_playerID;
	private EditText edittext_playerid;
	private ImageView imageview_gamename;
	private EditText edittext_gamename;
	private ImageView imageview_number;
	private EditText edittext_email;
	private LinearLayout linear18;
	private LinearLayout linear19;
	private LinearLayout linear14;
	private RadioButton radiobutton1;
	private TextView pay1;
	private RadioButton radiobutton2;
	private TextView pay2;
	private RadioButton radiobutton3;
	private TextView pay3;
	private ImageView imageview8;
	private EditText edittext_lastNumber;
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
	private SharedPreferences f;
	private SharedPreferences coin;
	private DatabaseReference order = _firebase.getReference("order");
	private ChildEventListener _order_child_listener;
	private SharedPreferences Auth;
	private AlertDialog.Builder d;
	private Calendar cal = Calendar.getInstance();
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
	
	private SharedPreferences on;
	private DatabaseReference user = _firebase.getReference("user");
	private ChildEventListener _user_child_listener;
	private SharedPreferences c;
	private DatabaseReference app_info = _firebase.getReference("app_info");
	private ChildEventListener _app_info_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.payment_ingame);
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
		linear13 = findViewById(R.id.linear13);
		linear15 = findViewById(R.id.linear15);
		linear16 = findViewById(R.id.linear16);
		products_name = findViewById(R.id.products_name);
		linear17 = findViewById(R.id.linear17);
		linear_topup = findViewById(R.id.linear_topup);
		textview_category = findViewById(R.id.textview_category);
		imageview7 = findViewById(R.id.imageview7);
		imageview6 = findViewById(R.id.imageview6);
		textview9 = findViewById(R.id.textview9);
		main_balance = findViewById(R.id.main_balance);
		textview10 = findViewById(R.id.textview10);
		price = findViewById(R.id.price);
		textview_requirement = findViewById(R.id.textview_requirement);
		textview13 = findViewById(R.id.textview13);
		textview15 = findViewById(R.id.textview15);
		textview12 = findViewById(R.id.textview12);
		textview16 = findViewById(R.id.textview16);
		l_player_id = findViewById(R.id.l_player_id);
		l_gameName = findViewById(R.id.l_gameName);
		l_number = findViewById(R.id.l_number);
		linear_payment = findViewById(R.id.linear_payment);
		l_lastnumber = findViewById(R.id.l_lastnumber);
		checkbox1 = findViewById(R.id.checkbox1);
		method = findViewById(R.id.method);
		button2 = findViewById(R.id.button2);
		button1 = findViewById(R.id.button1);
		textview11 = findViewById(R.id.textview11);
		imageview_playerID = findViewById(R.id.imageview_playerID);
		edittext_playerid = findViewById(R.id.edittext_playerid);
		imageview_gamename = findViewById(R.id.imageview_gamename);
		edittext_gamename = findViewById(R.id.edittext_gamename);
		imageview_number = findViewById(R.id.imageview_number);
		edittext_email = findViewById(R.id.edittext_email);
		linear18 = findViewById(R.id.linear18);
		linear19 = findViewById(R.id.linear19);
		linear14 = findViewById(R.id.linear14);
		radiobutton1 = findViewById(R.id.radiobutton1);
		pay1 = findViewById(R.id.pay1);
		radiobutton2 = findViewById(R.id.radiobutton2);
		pay2 = findViewById(R.id.pay2);
		radiobutton3 = findViewById(R.id.radiobutton3);
		pay3 = findViewById(R.id.pay3);
		imageview8 = findViewById(R.id.imageview8);
		edittext_lastNumber = findViewById(R.id.edittext_lastNumber);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		imageview2 = findViewById(R.id.imageview2);
		textview6 = findViewById(R.id.textview6);
		imageview3 = findViewById(R.id.imageview3);
		textview7 = findViewById(R.id.textview7);
		imageview4 = findViewById(R.id.imageview4);
		textview8 = findViewById(R.id.textview8);
		f = getSharedPreferences("f", Activity.MODE_PRIVATE);
		coin = getSharedPreferences("coin", Activity.MODE_PRIVATE);
		Auth = getSharedPreferences("Auth", Activity.MODE_PRIVATE);
		d = new AlertDialog.Builder(this);
		auth = FirebaseAuth.getInstance();
		on = getSharedPreferences("on", Activity.MODE_PRIVATE);
		c = getSharedPreferences("c", Activity.MODE_PRIVATE);
		
		checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					_TransitionManager(linear12, 300);
					linear_payment.setVisibility(View.VISIBLE);
					method.setVisibility(View.VISIBLE);
					button2.setVisibility(View.VISIBLE);
					l_lastnumber.setVisibility(View.VISIBLE);
					button1.setVisibility(View.GONE);
				}
				else {
					_TransitionManager(linear12, 300);
					linear_payment.setVisibility(View.GONE);
					method.setVisibility(View.GONE);
					button2.setVisibility(View.GONE);
					l_lastnumber.setVisibility(View.GONE);
					button1.setVisibility(View.VISIBLE);
				}
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_clickAnimation(button2);
				if (method.getText().toString().equals("Bkash/Nogod/Rocket")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Select Payment Method");
				}
				else {
					if (!edittext_playerid.getText().toString().equals("")) {
						if (!edittext_lastNumber.getText().toString().equals("")) {
							if (edittext_email.getText().toString().length() > 10) {
								d.setTitle("CONFIRMED ORDER");
								d.setIcon(R.drawable.image_6);
								d.setMessage("Do you want to place an order? \n".concat(products_name.getText().toString().concat(" Diamond and \n\n UID ").concat(edittext_playerid.getText().toString().concat("\n Game Name : ".concat(edittext_gamename.getText().toString())))));
								d.setPositiveButton("YES, CONFIRM", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										_clickAnimation(button2);
										cal = Calendar.getInstance();
										getKey = order.push().getKey();
										map = new HashMap<>();
										map.put("Number", edittext_email.getText().toString());
										map.put("Gmail", edittext_playerid.getText().toString());
										map.put("Time", new SimpleDateFormat("dd:MM:yyyy hh:mm:ss").format(cal.getTime()));
										map.put("password", edittext_gamename.getText().toString());
										map.put("iteam", products_name.getText().toString());
										map.put("amount", price.getText().toString());
										map.put("user_mail", FirebaseAuth.getInstance().getCurrentUser().getEmail());
										map.put("Progress", "Processing");
										map.put("category", textview_category.getText().toString());
										map.put("payment", method.getText().toString());
										map.put("last", edittext_lastNumber.getText().toString());
										map.put("Auth", Auth.getString("Auth", ""));
										map.put("Key", getKey);
										map.put("balance", main_balance.getText().toString());
										order.child(getKey).updateChildren(map);
										map.clear();
										SketchwareUtil.showMessage(getApplicationContext(), "Order Success");
										i.setClass(getApplicationContext(), SuccessorderActivity.class);
										startActivity(i);
									}
								});
								d.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface _dialog, int _which) {
										
									}
								});
								d.create().show();
							}
							else {
								((EditText)edittext_email).setError("Minimum 11 Digits Number");
							}
						}
						else {
							((EditText)edittext_playerid).setError("Please enter Payment last Number");
						}
					}
					else {
						((EditText)edittext_playerid).setError("Please enter Details...");
					}
				}
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_clickAnimation(button1);
				if (!edittext_playerid.getText().toString().equals("")) {
					if (Double.parseDouble(main_balance.getText().toString()) > (Double.parseDouble(price.getText().toString()) - 1)) {
						if (edittext_email.getText().toString().length() > 10) {
							d.setTitle("CONFIRMED ORDER");
							d.setIcon(R.drawable.image_6);
							d.setMessage("Do you want to place an order?\n".concat(products_name.getText().toString().concat("Diamond and /n UID ").concat(edittext_playerid.getText().toString().concat("\n Game Name : ".concat(edittext_gamename.getText().toString())))));
							d.setPositiveButton("YES, CONFIRM", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									_clickAnimation(button1);
									main_balance.setText(String.valueOf((long)(Double.parseDouble(main_balance.getText().toString()) - Double.parseDouble(price.getText().toString()))));
									coin.edit().putString("saved", main_balance.getText().toString()).commit();
									cal = Calendar.getInstance();
									getKey = order.push().getKey();
									map = new HashMap<>();
									map.put("Number", edittext_email.getText().toString());
									map.put("Gmail", edittext_playerid.getText().toString());
									map.put("Time", new SimpleDateFormat("dd:MM:yyyy hh:mm:ss").format(cal.getTime()));
									map.put("password", edittext_gamename.getText().toString());
									map.put("iteam", products_name.getText().toString());
									map.put("amount", price.getText().toString());
									map.put("user_mail", FirebaseAuth.getInstance().getCurrentUser().getEmail());
									map.put("Progress", "Processing");
									map.put("category", textview_category.getText().toString());
									map.put("payment", "Wallet");
									map.put("last", "Wallet");
									map.put("Auth", Auth.getString("Auth", ""));
									map.put("Key", getKey);
									map.put("balance", main_balance.getText().toString());
									order.child(getKey).updateChildren(map);
									map.clear();
									m = new HashMap<>();
									m.put("balance", main_balance.getText().toString());
									user.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(m);
									m.clear();
									edittext_playerid.setText("");
									edittext_gamename.setText("");
									edittext_email.setText("");
									SketchwareUtil.showMessage(getApplicationContext(), "Order Success");
									i.setClass(getApplicationContext(), SuccessorderActivity.class);
									startActivity(i);
								}
							});
							d.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface _dialog, int _which) {
									
								}
							});
							d.create().show();
						}
						else {
							((EditText)edittext_email).setError("Minimum 11 Digits Number");
						}
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Insufficient balance, please add money first");
						i.setClass(getApplicationContext(), AddMoneyActivity.class);
						startActivity(i);
					}
				}
				else {
					((EditText)edittext_playerid).setError("Please enter Details...");
				}
			}
		});
		
		radiobutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				method.setText(radiobutton1.getText().toString());
				radiobutton2.setChecked(false);
				radiobutton3.setChecked(false);
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", pay1.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Selected and Copied");
			}
		});
		
		radiobutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				method.setText(radiobutton2.getText().toString());
				radiobutton1.setChecked(false);
				radiobutton3.setChecked(false);
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", pay2.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Selected and Copied");
			}
		});
		
		radiobutton3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				method.setText(radiobutton3.getText().toString());
				radiobutton1.setChecked(false);
				radiobutton2.setChecked(false);
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", pay3.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Selected and Copied");
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
		
		_order_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		
		_user_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		user.addChildEventListener(_user_child_listener);
		
		_app_info_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("pay1")) {
					pay1.setText(_childValue.get("pay1").toString());
				}
				if (_childValue.containsKey("pay2")) {
					pay2.setText(_childValue.get("pay2").toString());
				}
				if (_childValue.containsKey("pay3")) {
					pay3.setText(_childValue.get("pay3").toString());
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
		app_info.addChildEventListener(_app_info_child_listener);
		
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
		linear17.setVisibility(View.GONE);
		linear_payment.setVisibility(View.GONE);
		button2.setVisibility(View.GONE);
		l_lastnumber.setVisibility(View.GONE);
		method.setVisibility(View.GONE);
		linear13.setElevation((float)10);
		linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFFFFFFFF));
		bottom_bar.setElevation((float)10);
		bottom_bar.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFFFFFFFF));
		linear_topup.setElevation((float)10);
		linear_topup.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFFFFFFFF));
		linear_payment.setElevation((float)10);
		linear_payment.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
		products_name.setText(getIntent().getStringExtra("name"));
		price.setText(getIntent().getStringExtra("price"));
		if (!coin.getString("saved", "").equals("")) {
			main_balance.setText("".concat(coin.getString("saved", "")));
		}
		textview11.setVisibility(View.GONE);
		if (on.getString("on", "").equals("Closed")) {
			button1.setVisibility(View.GONE);
			checkbox1.setVisibility(View.GONE);
			textview11.setVisibility(View.VISIBLE);
		}
		_changeActivityFont("unionxsoftsans_bold");
		imageview_playerID.setColorFilter(0xFF424242, PorterDuff.Mode.MULTIPLY);
		imageview_gamename.setColorFilter(0xFF424242, PorterDuff.Mode.MULTIPLY);
		imageview_number.setColorFilter(0xFF424242, PorterDuff.Mode.MULTIPLY);
		imageview8.setColorFilter(0xFF424242, PorterDuff.Mode.MULTIPLY);
		_rippleRoundStroke(button2, "#2196F3", "#BBDEFB", 45, 0, "#ffffff");
		_rippleRoundStroke(button1, "#2196F3", "#BBDEFB", 45, 0, "#ffffff");
		_rippleRoundStroke(l_player_id, "#EEEEEE", "#EEEEEE", 20, 1, "#222222");
		_rippleRoundStroke(l_lastnumber, "#EEEEEE", "#EEEEEE", 20, 1, "#222222");
		_rippleRoundStroke(l_gameName, "#EEEEEE", "#EEEEEE", 20, 1, "#222222");
		_rippleRoundStroke(l_number, "#EEEEEE", "#EEEEEE", 20, 1, "#222222");
		social = c.getString("c", "");
		if (social.equals("social")) {
			edittext_playerid.setHint("Enter you Link");
			textview_category.setText("social");
			l_gameName.setVisibility(View.GONE);
			linear17.setVisibility(View.VISIBLE);
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
	
	
	public void _TransitionManager(final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
}