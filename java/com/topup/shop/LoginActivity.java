package com.topup.shop;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
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
import com.airbnb.lottie.*;
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
import java.util.*;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class LoginActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private boolean login_mode = false;
	private HashMap<String, Object> map = new HashMap<>();
	private String login = "";
	private String fontName = "";
	private String typeace = "";
	
	private ScrollView vscroll1;
	private LinearLayout linear_main;
	private TextView tx_title;
	private TextView tx_subtitle;
	private LinearLayout linear6;
	private LinearLayout l_email;
	private LinearLayout l_number;
	private LinearLayout l_pass;
	private LinearLayout l_create_account;
	private LinearLayout l_login_btn;
	private LinearLayout div2;
	private LottieAnimationView lottie1;
	private ImageView imageview_email;
	private EditText edittext_email;
	private ImageView imageview_call;
	private EditText edittext_number;
	private ImageView im_pass;
	private EditText tx_password;
	private ImageView im_forget_pass;
	private TextView textview1;
	private TextView button_text;
	private LinearLayout div3;
	private TextView tx_inf2;
	private LinearLayout div4;
	
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
	private SharedPreferences f;
	private Intent intt = new Intent();
	private DatabaseReference user = _firebase.getReference("user");
	private ChildEventListener _user_child_listener;
	private Intent i = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.login);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		linear_main = findViewById(R.id.linear_main);
		tx_title = findViewById(R.id.tx_title);
		tx_subtitle = findViewById(R.id.tx_subtitle);
		linear6 = findViewById(R.id.linear6);
		l_email = findViewById(R.id.l_email);
		l_number = findViewById(R.id.l_number);
		l_pass = findViewById(R.id.l_pass);
		l_create_account = findViewById(R.id.l_create_account);
		l_login_btn = findViewById(R.id.l_login_btn);
		div2 = findViewById(R.id.div2);
		lottie1 = findViewById(R.id.lottie1);
		imageview_email = findViewById(R.id.imageview_email);
		edittext_email = findViewById(R.id.edittext_email);
		imageview_call = findViewById(R.id.imageview_call);
		edittext_number = findViewById(R.id.edittext_number);
		im_pass = findViewById(R.id.im_pass);
		tx_password = findViewById(R.id.tx_password);
		im_forget_pass = findViewById(R.id.im_forget_pass);
		textview1 = findViewById(R.id.textview1);
		button_text = findViewById(R.id.button_text);
		div3 = findViewById(R.id.div3);
		tx_inf2 = findViewById(R.id.tx_inf2);
		div4 = findViewById(R.id.div4);
		auth = FirebaseAuth.getInstance();
		Auth = getSharedPreferences("Auth", Activity.MODE_PRIVATE);
		f = getSharedPreferences("f", Activity.MODE_PRIVATE);
		
		l_create_account.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext_email.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Enter your email");
				}
				else {
					if (edittext_number.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Enter your Number");
					}
					else {
						if (tx_password.getText().toString().equals("")) {
							SketchwareUtil.showMessage(getApplicationContext(), "Enter your password");
						}
						else {
							auth.createUserWithEmailAndPassword(edittext_email.getText().toString(), tx_password.getText().toString()).addOnCompleteListener(LoginActivity.this, _auth_create_user_listener);
							_telegramLoaderDialog(true);
							SketchwareUtil.showMessage(getApplicationContext(), "Account Creating... please wait a moment");
						}
					}
				}
				_clickAnimation(l_create_account);
			}
		});
		
		l_login_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext_email.getText().toString().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Enter your email");
				}
				else {
					if (tx_password.getText().toString().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Enter your password");
					}
					else {
						auth.signInWithEmailAndPassword(edittext_email.getText().toString(), tx_password.getText().toString()).addOnCompleteListener(LoginActivity.this, _auth_sign_in_listener);
						_telegramLoaderDialog(true);
						SketchwareUtil.showMessage(getApplicationContext(), "Loging in... please wait a moment");
					}
				}
				_clickAnimation(l_login_btn);
			}
		});
		
		div2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (login_mode) {
					_Mode(false);
				}
				else {
					_Mode(true);
				}
			}
		});
		
		im_forget_pass.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Try to use hard password");
			}
		});
		
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
				if (_success) {
					_telegramLoaderDialog(false);
					Auth.edit().putString("Auth", FirebaseAuth.getInstance().getCurrentUser().getUid()).commit();
					f.edit().putString("number", edittext_number.getText().toString()).commit();
					f.edit().putString("email", edittext_email.getText().toString()).commit();
					f.edit().putString("password", tx_password.getText().toString()).commit();
					intt.setClass(getApplicationContext(), SignupActivity.class);
					startActivity(intt);
					SketchwareUtil.showMessage(getApplicationContext(), "Account created success");
				}
				else {
					_telegramLoaderDialog(false);
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
				}
			}
		};
		
		_auth_sign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> _param1) {
				final boolean _success = _param1.isSuccessful();
				final String _errorMessage = _param1.getException() != null ? _param1.getException().getMessage() : "";
				if (_success) {
					_telegramLoaderDialog(false);
					Auth.edit().putString("Auth", FirebaseAuth.getInstance().getCurrentUser().getUid()).commit();
					map.put("email", edittext_email.getText().toString());
					map.put("password", tx_password.getText().toString());
					map.put("uid", FirebaseAuth.getInstance().getCurrentUser().getUid());
					user.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).updateChildren(map);
					map.clear();
					intt.setClass(getApplicationContext(), HomeActivity.class);
					startActivity(intt);
					SketchwareUtil.showMessage(getApplicationContext(), "Logged in successful");
					finish();
				}
				else {
					_telegramLoaderDialog(false);
					SketchwareUtil.showMessage(getApplicationContext(), _errorMessage);
				}
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
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		getWindow().setStatusBarColor(0xFFFFFFFF);
		tx_title.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lexend_deca.ttf"), 1);
		tx_subtitle.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lexend_deca.ttf"), 0);
		tx_password.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lexend_deca.ttf"), 0);
		edittext_email.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lexend_deca.ttf"), 0);
		edittext_number.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lexend_deca.ttf"), 0);
		button_text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lexend_deca.ttf"), 0);
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lexend_deca.ttf"), 0);
		tx_inf2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/lexend_deca.ttf"), 0);
		_rippleRoundStroke(l_login_btn, "#2196F3", "#2196F3", 100, 0, "#2196F3");
		_rippleRoundStroke(l_create_account, "#2196F3", "#2196F3", 100, 0, "#2196F3");
		_rippleRoundStroke(l_pass, "#EEEEEE", "#EEEEEE", 20, 1, "#222222");
		_rippleRoundStroke(l_email, "#EEEEEE", "#EEEEEE", 20, 1, "#222222");
		_rippleRoundStroke(l_number, "#EEEEEE", "#EEEEEE", 20, 1, "#222222");
		im_pass.setColorFilter(0xFF424242, PorterDuff.Mode.MULTIPLY);
		imageview_email.setColorFilter(0xFF424242, PorterDuff.Mode.MULTIPLY);
		imageview_call.setColorFilter(0xFF424242, PorterDuff.Mode.MULTIPLY);
		im_forget_pass.setColorFilter(0xFF424242, PorterDuff.Mode.MULTIPLY);
		l_login_btn.setVisibility(View.GONE);
		lottie1.setAnimation("107800-login-leady.json");
		lottie1.setRepeatCount((int)-1);
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
	
	
	public void _Mode(final boolean _login) {
		login_mode = _login;
		_TransitionManager(linear_main, 200);
		if (_login) {
			tx_title.setText("Welcome here");
			tx_subtitle.setText("Let's create your account using your details");
			tx_inf2.setText("Already have an account? Click to Login");
			l_number.setVisibility(View.VISIBLE);
			l_login_btn.setVisibility(View.GONE);
			l_create_account.setVisibility(View.VISIBLE);
		}
		else {
			tx_title.setText("Welcome back");
			tx_subtitle.setText("Let's login with your email & password to continue");
			tx_inf2.setText("Don't have an account?Click here to Create Now");
			l_number.setVisibility(View.GONE);
			l_login_btn.setVisibility(View.VISIBLE);
			l_create_account.setVisibility(View.GONE);
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
	
	
	public void _clickAnimation(final View _view) {
		ScaleAnimation fade_in = new ScaleAnimation(0.9f, 1f, 0.9f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.7f);
		fade_in.setDuration(300);
		fade_in.setFillAfter(true);
		_view.startAnimation(fade_in);
	}
	
	
	public void _clickAnim(final View _view) {
		_clickAnimation(_view);
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
	
}