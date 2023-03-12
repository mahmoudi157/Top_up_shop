package com.topup.shop;

import android.Manifest;
import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.pm.PackageManager;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.*;
import com.facebook.shimmer.*;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.rejowan.cutetoast.*;
import com.thecode.aestheticdialogs.*;
import java.io.*;
import java.io.File;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class DownloadActivity extends AppCompatActivity {
	
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private String this_version = "";
	
	private LinearLayout linear1;
	private TextView textview2;
	private TextView textview4;
	private LinearLayout linear3;
	private LinearLayout linear5;
	private ProgressBar progressbar1;
	private LinearLayout linear9;
	private LottieAnimationView lottie1;
	private TextView textview5;
	private LinearLayout linear6;
	private LinearLayout linear8;
	private TextView percentage;
	private TextView textview3;
	
	private StorageReference apk = _firebase_storage.getReference("inapp");
	private OnCompleteListener<Uri> _apk_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _apk_download_success_listener;
	private OnSuccessListener _apk_delete_success_listener;
	private OnProgressListener _apk_upload_progress_listener;
	private OnProgressListener _apk_download_progress_listener;
	private OnFailureListener _apk_failure_listener;
	
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.download);
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
		linear1 = findViewById(R.id.linear1);
		textview2 = findViewById(R.id.textview2);
		textview4 = findViewById(R.id.textview4);
		linear3 = findViewById(R.id.linear3);
		linear5 = findViewById(R.id.linear5);
		progressbar1 = findViewById(R.id.progressbar1);
		linear9 = findViewById(R.id.linear9);
		lottie1 = findViewById(R.id.lottie1);
		textview5 = findViewById(R.id.textview5);
		linear6 = findViewById(R.id.linear6);
		linear8 = findViewById(R.id.linear8);
		percentage = findViewById(R.id.percentage);
		textview3 = findViewById(R.id.textview3);
		
		_apk_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_apk_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				progressbar1.setProgress((int)_progressValue);
				percentage.setText(String.valueOf((long)(_progressValue)).concat("%"));
			}
		};
		
		_apk_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				
			}
		};
		
		_apk_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				_install("/Download/update.apk");
			}
		};
		
		_apk_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_apk_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				SketchwareUtil.showMessage(getApplicationContext(), _message);
			}
		};
	}
	
	private void initializeLogic() {
		lottie1.setAnimation("28455-download-icon.json");
		lottie1.setRepeatCount((int)-1);
		_SetRadiusToView(progressbar1, 30, "#90CAF9");
		this_version = "1.0";
		_firebase_storage.getReferenceFromUrl(getIntent().getStringExtra("url")).getFile(new File(FileUtil.getPublicDir(Environment.DIRECTORY_DOWNLOADS).concat("/update.apk"))).addOnSuccessListener(_apk_download_success_listener).addOnFailureListener(_apk_failure_listener).addOnProgressListener(_apk_download_progress_listener);
		SketchwareUtil.showMessage(getApplicationContext(), FileUtil.getPublicDir(Environment.DIRECTORY_DOWNLOADS).concat("/update.apk"));
	}
	
	public void _install(final String _apk) {
		String PATH = Environment.getExternalStorageDirectory() + _apk; java.io.File file = new java.io.File(PATH); if(file.exists()) { 	 Intent intent = new Intent(Intent.ACTION_VIEW); 	 intent.setDataAndType(uriFromFile(getApplicationContext(), new java.io.File(PATH)), "application/vnd.android.package-archive"); 	 intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); 	 intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION); 	 try { 		 getApplicationContext().startActivity(intent); 		 } catch (ActivityNotFoundException e) { 		 e.printStackTrace(); 		 Log.e("TAG", "Error in opening the file!"); 		 } 	 }else{ 	 Toast.makeText(getApplicationContext(),"installing",Toast.LENGTH_LONG).show(); 	 } } Uri uriFromFile(Context context, java.io.File file) { if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) { 	 return androidx.core.content.FileProvider.getUriForFile(context,context.getApplicationContext().getPackageName() + ".provider", file); 	 } else { 	 return Uri.fromFile(file); 	 }
	}
	
	
	public void _SetRadiusToView(final View _view, final double _radius, final String _Colour) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(); gd.setColor(Color.parseColor(_Colour)); gd.setCornerRadius((int)_radius); _view.setBackground(gd);
	}
	
}