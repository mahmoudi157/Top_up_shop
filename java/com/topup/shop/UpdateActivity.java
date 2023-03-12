package com.topup.shop;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import java.text.DecimalFormat;
import java.util.*;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class UpdateActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String returnSize = "";
	
	private LinearLayout linear1;
	private ImageView imageview1;
	private TextView textview5;
	private TextView textview3;
	private LinearLayout linear2;
	private Button button1;
	private TextView textview6;
	private TextView textview8;
	private TextView textview7;
	
	private DatabaseReference update = _firebase.getReference("update");
	private ChildEventListener _update_child_listener;
	private Intent download = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.update);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		imageview1 = findViewById(R.id.imageview1);
		textview5 = findViewById(R.id.textview5);
		textview3 = findViewById(R.id.textview3);
		linear2 = findViewById(R.id.linear2);
		button1 = findViewById(R.id.button1);
		textview6 = findViewById(R.id.textview6);
		textview8 = findViewById(R.id.textview8);
		textview7 = findViewById(R.id.textview7);
		
		textview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				download.setClass(getApplicationContext(), HomeActivity.class);
				startActivity(download);
			}
		});
		
		_update_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childKey.equals("app")) {
					button1.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
							download.setClass(getApplicationContext(), DownloadActivity.class);
							download.putExtra("url", _childValue.get("url").toString());
							startActivity(download);
						}
					});
				}
				if (_childValue.containsKey("whatsnew")) {
					textview3.setText(_childValue.get("whatsnew").toString());
				}
				if (_childValue.containsKey("size")) {
					textview7.setText(_childValue.get("size").toString());
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
		update.addChildEventListener(_update_child_listener);
	}
	
	private void initializeLogic() {
	}
	
	public void _convertSize(final double _size) {
		if (_size < 1000) {
			returnSize = String.valueOf((long)(_size)).concat(" B");
		}
		else {
			if (_size < 1000000) {
				returnSize = new DecimalFormat("0.00").format(_size / 1000).concat(" KB");
			}
			else {
				if (_size < 1000000000) {
					returnSize = new DecimalFormat("0.00").format(_size / 1000000).concat(" MB");
				}
				else {
					returnSize = new DecimalFormat("0.00").format(_size / 1000000000).concat(" GB");
				}
			}
		}
	}
	
}