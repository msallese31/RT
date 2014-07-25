package com.example.randomthought;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

public class NotificationService extends IntentService {
	

	
	public NotificationService() {
		super("NotificationService");
		Log.d("debugN", "Service started");
	}

	  /**
	   * The IntentService calls this method from the default worker thread with
	   * the intent that started the service. When this method returns, IntentService
	   * stops the service, as appropriate.
	   */
	
	
	@Override
	protected void onHandleIntent(Intent arg0)
	{
		Log.d("debugN", "onHandleIntent got called");
		
		long[] x = {0, 1000, 0, 1000};
		
		NotificationCompat.Builder mBuilder =
		        new NotificationCompat.Builder(this)
		        .setSmallIcon(R.drawable.ic_stat_qmark)
		        .setContentTitle("What're you thinking about?")
		        .setContentText("Tap on the notification and put in what was on your mind")
		        .setAutoCancel(true)
		        .setVibrate(x)
		        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
		
		NotificationCompat.InboxStyle inboxStyle =
		        new NotificationCompat.InboxStyle();
//		String[] events = new String[6];
//		events[0] = "Previous thoughts:";
//		events[1] = "Money";
//		events[2] = "Sex";
//		events[3] = "School";
//		events[4] = "Sports";
//		events[5] = "Money";
		// Sets a title for the Inbox style big view
//		inboxStyle.setBigContentTitle("What're you thinking about?");
//		inboxStyle.setSummaryText("Tap on the notification and put in what was on your mind");
		// Moves events into the big view
//		for (int i=0; i < events.length; i++) {
//			
//		    inboxStyle.addLine(events[i]);
//		}
		// Moves the big view style object into the notification object.
//		mBuilder.setStyle(inboxStyle);
		
		// Creates an explicit intent for an Activity in your app
		Intent resultIntent = new Intent(this, EnterThoughts.class);

		// The stack builder object will contain an artificial back stack for the
		// started Activity.
		// This ensures that navigating backward from the Activity leads out of
		// your application to the Home screen.
		TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
		// Adds the back stack for the Intent (but not the Intent itself)
		stackBuilder.addParentStack(EnterThoughts.class);
		// Adds the Intent that starts the Activity to the top of the stack
		stackBuilder.addNextIntent(resultIntent);
		PendingIntent resultPendingIntent =
		        stackBuilder.getPendingIntent(
		            0,
		            PendingIntent.FLAG_UPDATE_CURRENT
		        );
		mBuilder.setContentIntent(resultPendingIntent);
		NotificationManager mNotificationManager =
		    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
		int mId = 0;
		 //mId allows you to update the notification later on.
		mNotificationManager.notify(mId, mBuilder.build());	
		
		stopSelf();	

	}

}
