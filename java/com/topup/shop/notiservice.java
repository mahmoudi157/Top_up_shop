package com.topup.shop;
import androidx.annotation.*;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import java.util.ArrayList;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import java.util.HashMap;

import android.content.Intent;  
import android.os.PowerManager;  
import android.net.Uri;  
import android.os.Build;  
import android.provider.Settings;


public class notiservice extends Service {
private static final String TAG = "ExampleJobService";
private boolean jobCancelled = false;
private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
private String FireMessage = "";
private String FireTitle = "";
private int num = 0;
private int num1 = 0;
private ArrayList<String> Data = new ArrayList<>();
private Timer _timer = new Timer();
private TimerTask t;
private RequestNetwork r;
private RequestNetwork.RequestListener _r_request_listener;
private DatabaseReference Database = _firebase.getReference("chat_path");
private ChildEventListener _Database_child_listener;
private ChildEventListener _data_child_listener;
public IBinder onBind(Intent arg0) {
return null;}



public void onCreate() {
 _CreateChannel();
com.google.firebase.FirebaseApp.initializeApp(this);
_Database_child_listener = new ChildEventListener() {
	
	
	
@Override
public void onChildAdded(DataSnapshot _param1, String _param2) {
GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
final String _childKey = _param1.getKey();
final HashMap<String, Object> _childValue = _param1.getValue(_ind);

//SketchwareUtil.showMessage(getApplicationContext(), "Child Added");

//Create Notification Here
if (num1 == 0) {
	num1++;
}
else {
	//Do What U Want
	
	FireMessage = _childValue.get("text").toString();
    FireTitle = _childValue.get("name").toString();
	Intent intent = new Intent(notiservice.this, MainActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
    PendingIntent pendingIntent = PendingIntent.getActivity(notiservice.this, 0, intent, 0);
	intent.putExtra("value", FireMessage);
    androidx.core.app.NotificationCompat.Builder builder = new androidx.core.app.NotificationCompat.Builder(notiservice.this, "id 1")
   .setSmallIcon(R.drawable.notif)
   .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
   .setContentTitle(FireTitle)
   .setContentText(FireMessage)
    .setPriority(androidx.core.app.NotificationCompat.PRIORITY_DEFAULT)
   .setContentIntent(pendingIntent)
   .setAutoCancel(true);
    androidx.core.app.NotificationManagerCompat notificationManager = androidx.core.app.NotificationManagerCompat.from(notiservice.this);
    notificationManager.notify(num, builder.build());
    num++;
}

}

@Override
public void onChildChanged(DataSnapshot _param1, String _param2) {
GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
final String _childKey = _param1.getKey();
final HashMap<String, Object> _childValue = _param1.getValue(_ind);

//Create Notification

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
Database.addChildEventListener(_Database_child_listener);
}
private void _CreateChannel () {
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
CharSequence name = "Background Services";
String description = "Notification channel";
int importance = NotificationManager.IMPORTANCE_DEFAULT;
NotificationChannel channel = new NotificationChannel("id 1", name, importance);
channel.setDescription(description);
NotificationManager notificationManager = getSystemService(NotificationManager.class);
notificationManager.createNotificationChannel(channel);
}
}
}