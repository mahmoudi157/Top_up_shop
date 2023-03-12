package com.topup.shop;

import android.content.BroadcastReceiver;
import android.content.Context.*;
import android.content.Intent;

import android.text.*;

import android.content.*;

public class StartOnBoot extends BroadcastReceiver {

    @Override
    public void onReceive(Context myContext, Intent myIntent) {
        
        if (Intent.ACTION_BOOT_COMPLETED.equals(myIntent.getAction())) {
            Intent serviceIntent = new Intent(myContext, notiservice.class);
            myContext.startService(serviceIntent);
        }
        
    }
}