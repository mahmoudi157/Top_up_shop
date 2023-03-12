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

public class PaymentUidActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String getKey = "";
	private HashMap<String, Object> map = new HashMap<>();
	private HashMap<String, Object> m = new HashMap<>();
	private String fontName = "";
	private String typeace = "";
	
	private LinearLayout linear6;
	private LinearLayout linear8;
	private LinearLayout bottom_bar;
	private ScrollView vscroll2;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private LinearLayout linear24;
	private LinearLayout linear25;
	private TextView products_name;
	private TextView account_type;
	private LinearLayout liner_account;
	private LinearLayout l_number;
	private LinearLayout linear_payment;
	private LinearLayout l_lastnumber;
	private CheckBox checkbox1;
	private TextView method;
	private Button button2;
	private Button button1;
	private TextView textview20;
	private ImageView imageview7;
	private ImageView imageview6;
	private TextView textview16;
	private TextView textview19;
	private TextView main_balance;
	private TextView textview18;
	private TextView Price;
	private LinearLayout linear23;
	private LinearLayout l_email;
	private LinearLayout l_password;
	private LinearLayout l_backup;
	private TextView textview12;
	private RadioButton radiobutton1;
	private RadioButton radiobutton2;
	private RadioButton radiobutton3;
	private ImageView imageview_email;
	private EditText edittext_email;
	private ImageView imageview_password;
	private EditText edittext_password;
	private ImageView imageview_recovery;
	private EditText edittext_backup;
	private ImageView imageview_call;
	private EditText edittext_number;
	private LinearLayout linear26;
	private LinearLayout linear27;
	private LinearLayout linear14;
	private RadioButton radiobutton4;
	private TextView pay1;
	private RadioButton radiobutton5;
	private TextView pay2;
	private RadioButton radiobutton6;
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
	
	private SharedPreferences f;
	private SharedPreferences coin;
	private SharedPreferences Auth;
	private Calendar cal = Calendar.getInstance();
	private DatabaseReference order = _firebase.getReference("order");
	private ChildEventListener _order_child_listener;
	private AlertDialog.Builder d;
	private Intent i = new Intent();
	private SharedPreferences on;
	private DatabaseReference user = _firebase.getReference("user");
	private ChildEventListener _user_child_listener;
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
	
	private DatabaseReference app_info = _firebase.getReference("app_info");
	private ChildEventListener _app_info_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.payment_uid);
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
		linear24 = findViewById(R.id.linear24);
		linear25 = findViewById(R.id.linear25);
		products_name = findViewById(R.id.products_name);
		account_type = findViewById(R.id.account_type);
		liner_account = findViewById(R.id.liner_account);
		l_number = findViewById(R.id.l_number);
		linear_payment = findViewById(R.id.linear_payment);
		l_lastnumber = findViewById(R.id.l_lastnumber);
		checkbox1 = findViewById(R.id.checkbox1);
		method = findViewById(R.id.method);
		button2 = findViewById(R.id.button2);
		button1 = findViewById(R.id.button1);
		textview20 = findViewById(R.id.textview20);
		imageview7 = findViewById(R.id.imageview7);
		imageview6 = findViewById(R.id.imageview6);
		textview16 = findViewById(R.id.textview16);
		textview19 = findViewById(R.id.textview19);
		main_balance = findViewById(R.id.main_balance);
		textview18 = findViewById(R.id.textview18);
		Price = findViewById(R.id.Price);
		linear23 = findViewById(R.id.linear23);
		l_email = findViewById(R.id.l_email);
		l_password = findViewById(R.id.l_password);
		l_backup = findViewById(R.id.l_backup);
		textview12 = findViewById(R.id.textview12);
		radiobutton1 = findViewById(R.id.radiobutton1);
		radiobutton2 = findViewById(R.id.radiobutton2);
		radiobutton3 = findViewById(R.id.radiobutton3);
		imageview_email = findViewById(R.id.imageview_email);
		edittext_email = findViewById(R.id.edittext_email);
		imageview_password = findViewById(R.id.imageview_password);
		edittext_password = findViewById(R.id.edittext_password);
		imageview_recovery = findViewById(R.id.imageview_recovery);
		edittext_backup = findViewById(R.id.edittext_backup);
		imageview_call = findViewById(R.id.imageview_call);
		edittext_number = findViewById(R.id.edittext_number);
		linear26 = findViewById(R.id.linear26);
		linear27 = findViewById(R.id.linear27);
		linear14 = findViewById(R.id.linear14);
		radiobutton4 = findViewById(R.id.radiobutton4);
		pay1 = findViewById(R.id.pay1);
		radiobutton5 = findViewById(R.id.radiobutton5);
		pay2 = findViewById(R.id.pay2);
		radiobutton6 = findViewById(R.id.radiobutton6);
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
		on = getSharedPreferences("on", Activity.MODE_PRIVATE);
		auth = FirebaseAuth.getInstance();
		
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
				if (account_type.getText().toString().equals("Account Type")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Select Account Type");
				}
				else {
					if (method.getText().toString().equals("Bkash/Nogod/Rocket")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Select Payment Method");
					}
					else {
						if (!edittext_number.getText().toString().equals("")) {
							if (!edittext_email.getText().toString().equals("")) {
								if (!edittext_password.getText().toString().equals("")) {
									if (!edittext_lastNumber.getText().toString().equals("")) {
										if (10 < edittext_number.getText().toString().length()) {
											d.setTitle("CONFIRMED ORDER");
											d.setIcon(R.drawable.image_6);
											d.setMessage("Do you want to place an order? \n\n".concat(account_type.getText().toString().concat("Account ").concat(edittext_email.getText().toString().concat("\n\n Password : ".concat(edittext_password.getText().toString())))));
											d.setPositiveButton("YES, CONFIRM", new DialogInterface.OnClickListener() {
												@Override
												public void onClick(DialogInterface _dialog, int _which) {
													_clickAnimation(button2);
													cal = Calendar.getInstance();
													getKey = order.push().getKey();
													map = new HashMap<>();
													map.put("Number", edittext_number.getText().toString());
													map.put("Gmail", edittext_email.getText().toString());
													map.put("Time", new SimpleDateFormat("dd:MM:yyyy hh:mm:ss").format(cal.getTime()));
													map.put("password", edittext_password.getText().toString());
													map.put("Backup", edittext_backup.getText().toString());
													map.put("Type", account_type.getText().toString());
													map.put("iteam", products_name.getText().toString());
													map.put("amount", Price.getText().toString());
													map.put("user_mail", FirebaseAuth.getInstance().getCurrentUser().getEmail());
													map.put("Progress", "Processing");
													map.put("category", "ingame");
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
											((EditText)edittext_number).setError("Minimum 11 Digits Number");
										}
									}
									else {
										((EditText)edittext_password).setError("Please enter Payment last Number");
									}
								}
								else {
									((EditText)edittext_password).setError("Please enter your Password");
								}
							}
							else {
								((EditText)edittext_email).setError("Please enter your account email or number");
							}
						}
						else {
							((EditText)edittext_number).setError("Please enter Contact number ");
						}
					}
				}
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_clickAnimation(button1);
				if (account_type.getText().toString().equals("Account Type")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Select Account Type");
				}
				else {
					if (!edittext_number.getText().toString().equals("")) {
						if (!edittext_email.getText().toString().equals("")) {
							if (!edittext_password.getText().toString().equals("")) {
								if (Double.parseDouble(main_balance.getText().toString()) > (Double.parseDouble(Price.getText().toString()) - 1)) {
									if (10 < edittext_number.getText().toString().length()) {
										d.setTitle("CONFIRMED ORDER");
										d.setIcon(R.drawable.image_6);
										d.setMessage("Do you want to place an order?\n".concat(account_type.getText().toString().concat("Account").concat(edittext_email.getText().toString().concat("\n Password : ".concat(edittext_password.getText().toString())))));
										d.setPositiveButton("YES, CONFIRM", new DialogInterface.OnClickListener() {
											@Override
											public void onClick(DialogInterface _dialog, int _which) {
												_clickAnimation(button1);
												main_balance.setText(String.valueOf((long)(Double.parseDouble(main_balance.getText().toString()) - Double.parseDouble(Price.getText().toString()))));
												coin.edit().putString("saved", main_balance.getText().toString()).commit();
												cal = Calendar.getInstance();
												getKey = order.push().getKey();
												map = new HashMap<>();
												map.put("Number", edittext_number.getText().toString());
												map.put("Gmail", edittext_email.getText().toString());
												map.put("Time", new SimpleDateFormat("dd:MM:yyyy hh:mm:ss").format(cal.getTime()));
												map.put("password", edittext_password.getText().toString());
												map.put("Backup", edittext_backup.getText().toString());
												map.put("Type", account_type.getText().toString());
												map.put("iteam", products_name.getText().toString());
												map.put("amount", Price.getText().toString());
												map.put("user_mail", FirebaseAuth.getInstance().getCurrentUser().getEmail());
												map.put("Progress", "Processing");
												map.put("category", "ingame");
												map.put("last", "wallet");
												map.put("payment", "Wallet");
												map.put("Auth", Auth.getString("Auth", ""));
												map.put("Key", getKey);
												map.put("balance", main_balance.getText().toString());
												order.child(getKey).updateChildren(map);
												map.clear();
												m = new HashMap<>();
												m.put("balance", main_balance.getText().toString());
												user.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(m);
												m.clear();
												edittext_password.setText("");
												edittext_backup.setText("");
												edittext_number.setText("");
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
										((EditText)edittext_number).setError("Minimum 11 Digits Number");
									}
								}
								else {
									SketchwareUtil.showMessage(getApplicationContext(), "Insufficient balance, please add money first");
									i.setClass(getApplicationContext(), AddMoneyActivity.class);
									startActivity(i);
								}
							}
							else {
								((EditText)edittext_password).setError("Please enter your Password");
							}
						}
						else {
							((EditText)edittext_email).setError("Please enter your account email or number");
						}
					}
					else {
						((EditText)edittext_number).setError("Please enter Contact number ");
					}
				}
			}
		});
		
		radiobutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				account_type.setText(radiobutton1.getText().toString());
				radiobutton2.setChecked(false);
				radiobutton3.setChecked(false);
				edittext_email.setHint("Gmail address");
				_TransitionManager(liner_account, 300);
				l_backup.setVisibility(View.VISIBLE);
			}
		});
		
		radiobutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				account_type.setText(radiobutton2.getText().toString());
				radiobutton1.setChecked(false);
				radiobutton3.setChecked(false);
				edittext_email.setHint("Facebook Number/Gmail");
				_TransitionManager(liner_account, 300);
				l_backup.setVisibility(View.GONE);
			}
		});
		
		radiobutton3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				account_type.setText(radiobutton3.getText().toString());
				radiobutton2.setChecked(false);
				radiobutton1.setChecked(false);
				edittext_email.setHint("VK Adress");
				_TransitionManager(liner_account, 300);
				l_backup.setVisibility(View.GONE);
			}
		});
		
		radiobutton4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				method.setText(radiobutton4.getText().toString());
				radiobutton5.setChecked(false);
				radiobutton6.setChecked(false);
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", pay1.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Selected and Copied");
			}
		});
		
		radiobutton5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				method.setText(radiobutton5.getText().toString());
				radiobutton4.setChecked(false);
				radiobutton6.setChecked(false);
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", pay2.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Selected and Copied");
			}
		});
		
		radiobutton6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				method.setText(radiobutton6.getText().toString());
				radiobutton4.setChecked(false);
				radiobutton5.setChecked(false);
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
		if (!coin.getString("saved", "").equals("")) {
			main_balance.setText("".concat(coin.getString("saved", "")));
		}
		products_name.setText(getIntent().getStringExtra("name"));
		Price.setText(getIntent().getStringExtra("price"));
		liner_account.setElevation((float)10);
		liner_account.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)25, 0xFFE0E0E0));
		linear_payment.setElevation((float)10);
		linear_payment.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFEEEEEE));
		bottom_bar.setElevation((float)10);
		bottom_bar.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFFFFFFFF));
		linear13.setElevation((float)10);
		linear13.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFFFFFFFF));
		textview20.setVisibility(View.GONE);
		l_backup.setVisibility(View.GONE);
		linear_payment.setVisibility(View.GONE);
		method.setVisibility(View.GONE);
		button2.setVisibility(View.GONE);
		l_lastnumber.setVisibility(View.GONE);
		if (on.getString("on", "").equals("Closed")) {
			button1.setVisibility(View.GONE);
			checkbox1.setVisibility(View.GONE);
			textview20.setVisibility(View.VISIBLE);
		}
		_changeActivityFont("unionxsoftsans_bold");
		_rippleRoundStroke(button1, "#2196F3", "#BBFEFB", 45, 0, "#ffffff");
		_rippleRoundStroke(button2, "#2196F3", "#BBFEFB", 45, 0, "#ffffff");
		_rippleRoundStroke(l_email, "#EEEEEE", "#EEEEEE", 20, 1, "#222222");
		_rippleRoundStroke(l_password, "#EEEEEE", "#EEEEEE", 20, 1, "#222222");
		_rippleRoundStroke(l_backup, "#EEEEEE", "#EEEEEE", 20, 1, "#222222");
		_rippleRoundStroke(l_number, "#EEEEEE", "#EEEEEE", 20, 1, "#222222");
		_rippleRoundStroke(l_lastnumber, "#EEEEEE", "#EEEEEE", 20, 1, "#222222");
		imageview_email.setColorFilter(0xFF424242, PorterDuff.Mode.MULTIPLY);
		imageview_password.setColorFilter(0xFF424242, PorterDuff.Mode.MULTIPLY);
		imageview_recovery.setColorFilter(0xFF424242, PorterDuff.Mode.MULTIPLY);
		imageview_call.setColorFilter(0xFF424242, PorterDuff.Mode.MULTIPLY);
		imageview8.setColorFilter(0xFF424242, PorterDuff.Mode.MULTIPLY);
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