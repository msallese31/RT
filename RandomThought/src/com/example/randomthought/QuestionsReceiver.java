package com.example.randomthought;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class QuestionsReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent)
    {
    	Log.d("debugN", "Receiver called");
       Intent service1 = new Intent(context, NotificationService.class);
       Log.d("debugN", "Starting service");
       context.startService(service1);
        
    }   

}
