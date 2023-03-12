package com.topup.shop;

import android.Manifest;
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
import android.content.pm.PackageManager;
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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.shimmer.*;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.rejowan.cutetoast.*;
import com.thecode.aestheticdialogs.*;
import java.io.*;
import java.io.File;
import java.io.InputStream;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class AddPaymentActivity extends AppCompatActivity {
	
	public final int REQ_CD_PICK = 101;
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private double s_length = 0;
	private String cc = "";
	private double n_length = 0;
	private double n_coin = 0;
	private double saved_coin = 0;
	private HashMap<String, Object> map = new HashMap<>();
	private String getKey = "";
	private boolean image_pick = false;
	private String imagePath = "";
	private String imageName = "";
	private String fontName = "";
	private String typeace = "";
	
	private ArrayList<String> ck = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> Im = new ArrayList<>();
	
	private LinearLayout linear6;
	private LinearLayout linear8;
	private LinearLayout bottom_bar;
	private ScrollView vscroll2;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private TextView method;
	private LinearLayout linear_payment;
	private LinearLayout linear_amount;
	private TextView textview17;
	private ImageView imageview5;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private RadioButton radiobutton1;
	private TextView pay1;
	private RadioButton radiobutton2;
	private TextView pay2;
	private RadioButton radiobutton3;
	private TextView pay3;
	private TextView textview13;
	private LinearLayout linear16;
	private LinearLayout linear15;
	private TextView textview23;
	private TextView textview20;
	private LinearLayout l_email;
	private LinearLayout edit_text_add;
	private CheckBox checkbox1;
	private LinearLayout linear_add_button2;
	private LinearLayout add_button;
	private TextView textview18;
	private TextView textview22;
	private TextView textview_balance;
	private TextView textview15;
	private TextView amount;
	private ImageView imageview_email;
	private EditText edittext_email;
	private ImageView imageview6;
	private TextView textview19;
	private TextView textview24;
	private TextView textview14;
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
	private DatabaseReference add_money = _firebase.getReference("add_money");
	private ChildEventListener _add_money_child_listener;
	private SharedPreferences coin;
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
	
	private SharedPreferences Auth;
	private DatabaseReference app_info = _firebase.getReference("app_info");
	private ChildEventListener _app_info_child_listener;
	private SharedPreferences on;
	private Intent pick = new Intent(Intent.ACTION_GET_CONTENT);
	private StorageReference transection = _firebase_storage.getReference("transection");
	private OnCompleteListener<Uri> _transection_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _transection_download_success_listener;
	private OnSuccessListener _transection_delete_success_listener;
	private OnProgressListener _transection_upload_progress_listener;
	private OnProgressListener _transection_download_progress_listener;
	private OnFailureListener _transection_failure_listener;
	
	private DatabaseReference home = _firebase.getReference("home");
	private ChildEventListener _home_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.add_payment);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear6 = findViewById(R.id.linear6);
		linear8 = findViewById(R.id.linear8);
		bottom_bar = findViewById(R.id.bottom_bar);
		vscroll2 = findViewById(R.id.vscroll2);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		method = findViewById(R.id.method);
		linear_payment = findViewById(R.id.linear_payment);
		linear_amount = findViewById(R.id.linear_amount);
		textview17 = findViewById(R.id.textview17);
		imageview5 = findViewById(R.id.imageview5);
		linear12 = findViewById(R.id.linear12);
		linear13 = findViewById(R.id.linear13);
		linear14 = findViewById(R.id.linear14);
		radiobutton1 = findViewById(R.id.radiobutton1);
		pay1 = findViewById(R.id.pay1);
		radiobutton2 = findViewById(R.id.radiobutton2);
		pay2 = findViewById(R.id.pay2);
		radiobutton3 = findViewById(R.id.radiobutton3);
		pay3 = findViewById(R.id.pay3);
		textview13 = findViewById(R.id.textview13);
		linear16 = findViewById(R.id.linear16);
		linear15 = findViewById(R.id.linear15);
		textview23 = findViewById(R.id.textview23);
		textview20 = findViewById(R.id.textview20);
		l_email = findViewById(R.id.l_email);
		edit_text_add = findViewById(R.id.edit_text_add);
		checkbox1 = findViewById(R.id.checkbox1);
		linear_add_button2 = findViewById(R.id.linear_add_button2);
		add_button = findViewById(R.id.add_button);
		textview18 = findViewById(R.id.textview18);
		textview22 = findViewById(R.id.textview22);
		textview_balance = findViewById(R.id.textview_balance);
		textview15 = findViewById(R.id.textview15);
		amount = findViewById(R.id.amount);
		imageview_email = findViewById(R.id.imageview_email);
		edittext_email = findViewById(R.id.edittext_email);
		imageview6 = findViewById(R.id.imageview6);
		textview19 = findViewById(R.id.textview19);
		textview24 = findViewById(R.id.textview24);
		textview14 = findViewById(R.id.textview14);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		imageview2 = findViewById(R.id.imageview2);
		textview6 = findViewById(R.id.textview6);
		imageview3 = findViewById(R.id.imageview3);
		textview7 = findViewById(R.id.textview7);
		imageview4 = findViewById(R.id.imageview4);
		textview8 = findViewById(R.id.textview8);
		coin = getSharedPreferences("coin", Activity.MODE_PRIVATE);
		d = new AlertDialog.Builder(this);
		auth = FirebaseAuth.getInstance();
		Auth = getSharedPreferences("Auth", Activity.MODE_PRIVATE);
		on = getSharedPreferences("on", Activity.MODE_PRIVATE);
		pick.setType("image/*");
		pick.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
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
				radiobutton2.setChecked(false);
				radiobutton1.setChecked(false);
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", pay3.getText().toString()));
				SketchwareUtil.showMessage(getApplicationContext(), "Selected and Copied");
			}
		});
		
		edit_text_add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_clickAnimation(edit_text_add);
				startActivityForResult(pick, REQ_CD_PICK);
			}
		});
		
		checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					_TransitionManager(linear_amount, 300);
					l_email.setVisibility(View.VISIBLE);
					linear_add_button2.setVisibility(View.VISIBLE);
					add_button.setVisibility(View.GONE);
					edit_text_add.setVisibility(View.GONE);
				}
				else {
					_TransitionManager(linear_amount, 300);
					l_email.setVisibility(View.GONE);
					linear_add_button2.setVisibility(View.GONE);
					add_button.setVisibility(View.VISIBLE);
					edit_text_add.setVisibility(View.VISIBLE);
				}
			}
		});
		
		linear_add_button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_clickAnimation(linear_add_button2);
				d.setTitle("Confrim Request? ");
				d.setIcon(R.drawable.image_6);
				d.setMessage("are you sure to confrim order request? ");
				d.setPositiveButton("Order", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						if (!method.getText().toString().equals("Payment Method")) {
							if (!edittext_email.getText().toString().equals("")) {
								getKey = add_money.push().getKey();
								map = new HashMap<>();
								map.put("Auth", Auth.getString("Auth", ""));
								map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
								map.put("Number", edittext_email.getText().toString());
								map.put("Method", method.getText().toString());
								map.put("Amount", amount.getText().toString());
								map.put("Balance", textview_balance.getText().toString());
								map.put("Time", new SimpleDateFormat("dd:MM:yyyy hh:mm:ss").format(cal.getTime()));
								map.put("Tittle", "ADD MONEY");
								map.put("Progress", "Processing...");
								map.put("image", "https://firebasestorage.googleapis.com/v0/b/topuppointbdemon.appspot.com/o/icon%2Fkisspng-gemstone-blue-diamond-ring-5d340a89cfa611.8140731915636916578505.pngkisspng-gemstone-blue-diamond-ring-5d340a89cfa611.8140731915636916578505.png?alt=media&token=50442055-b30a-401d-a62d-40e4a09c69cf");
								map.put("Gmail", FirebaseAuth.getInstance().getCurrentUser().getEmail());
								map.put("Key", getKey);
								add_money.child(getKey).updateChildren(map);
								map.clear();
								amount.setText("00");
								edittext_email.setText("");
								SketchwareUtil.showMessage(getApplicationContext(), "Add money request success");
								i.setClass(getApplicationContext(), SuccessorderActivity.class);
								startActivity(i);
							}
							else {
								
							}
						}
						else {
							SketchwareUtil.showMessage(getApplicationContext(), "Select Payment method");
						}
					}
				});
				d.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.create().show();
			}
		});
		
		add_button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_clickAnimation(add_button);
				if (!method.getText().toString().equals("Payment Method")) {
					if (image_pick) {
						_Prog_Dialogue_show(true, "", "Uploading Screenshots.....");
						transection.child(imageName.concat(imageName)).putFile(Uri.fromFile(new File(imagePath))).addOnFailureListener(_transection_failure_listener).addOnProgressListener(_transection_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
							@Override
							public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
								return transection.child(imageName.concat(imageName)).getDownloadUrl();
							}}).addOnCompleteListener(_transection_upload_success_listener);
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "please choose an image");
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Select Payment method");
				}
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
		
		_add_money_child_listener = new ChildEventListener() {
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
		add_money.addChildEventListener(_add_money_child_listener);
		
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
		
		_transection_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_transection_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_transection_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				getKey = add_money.push().getKey();
				map = new HashMap<>();
				map.put("Auth", Auth.getString("Auth", ""));
				map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
				map.put("Number", "not available");
				map.put("Method", method.getText().toString());
				map.put("Amount", amount.getText().toString());
				map.put("Balance", textview_balance.getText().toString());
				map.put("Time", new SimpleDateFormat("dd:MM:yyyy hh:mm:ss").format(cal.getTime()));
				map.put("Tittle", "ADD MONEY");
				map.put("image", _downloadUrl);
				map.put("Progress", "Processing...");
				map.put("Gmail", FirebaseAuth.getInstance().getCurrentUser().getEmail());
				map.put("Key", getKey);
				add_money.child(getKey).updateChildren(map);
				map.clear();
				_Prog_Dialogue_show(false, "Success", "");
				SketchwareUtil.showMessage(getApplicationContext(), "Add money request success");
				amount.setText("00");
				i.setClass(getApplicationContext(), SuccessorderActivity.class);
				startActivity(i);
			}
		};
		
		_transection_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_transection_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_transection_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
		
		_home_child_listener = new ChildEventListener() {
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
		home.addChildEventListener(_home_child_listener);
		
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
		amount.setText(getIntent().getStringExtra("amount"));
		bottom_bar.setElevation((float)10);
		bottom_bar.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFFFFFFFF));
		linear10.setElevation((float)10);
		linear10.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)45, 0xFFFFFFFF));
		linear_payment.setElevation((float)10);
		linear_payment.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
		linear_amount.setElevation((float)10);
		linear_amount.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFFFFFFFF));
		textview18.setVisibility(View.GONE);
		if (on.getString("on", "").equals("Closed")) {
			add_button.setVisibility(View.GONE);
			textview18.setVisibility(View.VISIBLE);
			checkbox1.setVisibility(View.GONE);
		}
		if (!coin.getString("saved", "").equals("")) {
			textview_balance.setText("".concat(coin.getString("saved", "")));
		}
		imageview6.setColorFilter(0xFFFFFFFF, PorterDuff.Mode.MULTIPLY);
		imageview_email.setColorFilter(0xFF424242, PorterDuff.Mode.MULTIPLY);
		_oncreate();
		l_email.setVisibility(View.GONE);
		linear_add_button2.setVisibility(View.GONE);
		_changeActivityFont("unionxsoftsans_bold");
		_rippleRoundStroke(l_email, "#EEEEEE", "#EEEEEE", 20, 1, "#222222");
		_rippleRoundStroke(linear_add_button2, "#2196F3", "#BBFEFB", 45, 0, "#ffffff");
		_rippleRoundStroke(add_button, "#2196F3", "#BBFEFB", 45, 0, "#ffffff");
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_PICK:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				image_pick = true;
				imagePath = _filePath.get((int)(0));
				imageName = Uri.parse(imagePath).getLastPathSegment();
				imageName = Uri.parse(imagePath).getLastPathSegment();
				imageName = Uri.parse(imagePath).getLastPathSegment();
				imageview6.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(imagePath, 1024, 1024));
			}
			else {
				
			}
			break;
			default:
			break;
		}
	}
	
	public void _Prog_Dialogue_show(final boolean _ifShow, final String _title, final String _message) {
		if (_ifShow) {
			if (prog == null){
				prog = new ProgressDialog(this);
				prog.setMax(100);
				prog.setIndeterminate(true);
				prog.setCancelable(false);
				prog.setCanceledOnTouchOutside(false);
			}
			prog.setMessage(_message);
			prog.show();
		}
		else {
			if (prog != null){
				prog.dismiss();
			}
		}
	}
	private ProgressDialog prog;
	{
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
	
	
	public void _oncreate() {
		_rippleRoundStroke(add_button, "#2196F3", "#BBDEFB", 35, 0, "#ffffff");
		_rippleRoundStroke(linear_add_button2, "#2196F3", "#BBDEFB", 35, 0, "#ffffff");
		_rippleRoundStroke(edit_text_add, "#FFFB5626", "#FFAB91", 25, 0, "#ffffff");
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
	
	
	public void _TransitionManager(final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
	
	public void _clickAnimation(final View _view) {
		ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
		fade_in.setDuration(300);
		fade_in.setFillAfter(true);
		_view.startAnimation(fade_in);
	}
	
}