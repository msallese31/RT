package com.example.randomthought;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.example.randomthought.thoughtendpoint.Thoughtendpoint;
import com.example.randomthought.thoughtendpoint.model.Thought;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson.JacksonFactory;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class EnterThoughts extends Activity {
    private PendingIntent pendingIntent;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.enter_thoughts);		
		Log.d("debugN", "Mainassssssssssss activity");  
		


		   // Set the alarm to start at 8:30 a.m.
	      Calendar calendar = Calendar.getInstance();
	      calendar.setTimeInMillis(System.currentTimeMillis());
	      
	      Time time = new Time();
	      time.setToNow();
	      
			Random r = new Random();
			int randHour = r.nextInt((time.hour + 3) - time.hour) + time.hour;
			while (randHour == time.hour)
			{
				randHour = r.nextInt((time.hour + 2) - time.hour) + time.hour;
			}
			
				int randMinutes = r.nextInt(60 - 1) + 1;


			
			Log.d("debugN", "Next alarm time: " + randHour + ":" + randMinutes);
	      
	      calendar.set(Calendar.HOUR_OF_DAY, randHour);
	      calendar.set(Calendar.MINUTE, randMinutes);
		
	      Intent myIntent = new Intent(EnterThoughts.this, QuestionsReceiver.class);
	      pendingIntent = PendingIntent.getBroadcast(EnterThoughts.this, 0, myIntent,0);
	     
	      Log.d("debugN", "Calling reciever");
	      AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
	      
	      //Long time = new GregorianCalendar().getTimeInMillis()+10000;
	      
	      // setRepeating() lets you specify a precise custom interval--in this case,
	      // 20 minutes.
	      alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pendingIntent);
		
	}
	
	public void saveData(View view) {
		new EndpointsTask().execute(getApplicationContext());
	 }
	
	public class EndpointsTask extends AsyncTask<Context, Integer, Long> {
        protected Long doInBackground(Context... contexts) {

               Thoughtendpoint.Builder endpointBuilder = new Thoughtendpoint.Builder(
              AndroidHttp.newCompatibleTransport(),
              new JacksonFactory(),
              new HttpRequestInitializer() {
              public void initialize(HttpRequest httpRequest) { }
              });
      Thoughtendpoint endpoint = CloudEndpointUtils.updateBuilder(
      endpointBuilder).build();
      try {
    	  EditText enterThoughtET = (EditText) findViewById(R.id.editTextEnterThought);
    	  String thought = enterThoughtET.getText().toString();
          Thought thoughtToEnter = new Thought().setThought(thought);
          String thoughtID = new Date().toString();
          thoughtToEnter.setId(thoughtID);
   
          Thought result = endpoint.insertThought(thoughtToEnter).execute();
      } catch (IOException e) {
        e.printStackTrace();
      }
          return (long) 0;
        }
    }
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
