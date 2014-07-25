package com.example.randomthought;

import java.util.Calendar;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

    private PendingIntent pendingIntent;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);		
		Log.d("debugN", "Mainassssssssssss activity");  

		   // Set the alarm to start at 8:30 a.m.
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTimeInMillis(System.currentTimeMillis());
	      
	      Time time = new Time();
	      time.setToNow();
	      
//			Random r = new Random();
//			int randHour = r.nextInt((time.hour + 3) - time.hour) + time.hour;
//			while (randHour == time.hour)
//			{
//				randHour = r.nextInt((time.hour + 2) - time.hour) + time.hour;
//			}
//			
//				int randMinutes = r.nextInt(10 - 6) + 6;
//
//
//			
//			Log.d("debugN", "Rado time: " + randHour + ":" + randMinutes);
	      
	      calendar.set(Calendar.HOUR_OF_DAY, time.hour);
	      calendar.set(Calendar.MINUTE, time.minute);
		
	      Intent myIntent = new Intent(MainActivity.this, QuestionsReceiver.class);
	      pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent,0);
	     
	      Log.d("debugN", "Calling reciever");
	      AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
	      
	      //Long time = new GregorianCalendar().getTimeInMillis()+10000;
	      
	      // setRepeating() lets you specify a precise custom interval--in this case,
	      // 20 minutes.
	      alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pendingIntent);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
