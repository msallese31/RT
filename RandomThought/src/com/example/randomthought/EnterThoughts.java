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
		Log.d("debugN", "EnterThoughts activity");  
		


		   // Initialize the calendar
	      Calendar calendar = Calendar.getInstance();
	      //Not sure if this line is needed --- will test in future
	      calendar.setTimeInMillis(System.currentTimeMillis());
	      
	      //Get the current time which is used to generate the random time
	      Time time = new Time();
	      time.setToNow();
	      
	      	//Get the random hour
			Random r = new Random();
			int randHour = r.nextInt((time.hour + 3) - time.hour) + time.hour;
			
			//If the hour is the same as the current hour, get a new random hour
			while (randHour == time.hour)
			{
				randHour = r.nextInt((time.hour + 2) - time.hour) + time.hour;
			}
			
		  //Get the random minutes between 0-59
		  int randMinutes = r.nextInt(60 - 1) + 1;

		  //Set the next alarm
		  Log.d("debugN", "Next alarm time: " + randHour + ":" + randMinutes);
	      calendar.set(Calendar.HOUR_OF_DAY, 10);
	      calendar.set(Calendar.MINUTE, time.minute + 1);
		
	      Intent myIntent = new Intent(EnterThoughts.this, QuestionsReceiver.class);
	      pendingIntent = PendingIntent.getBroadcast(EnterThoughts.this, 0, myIntent,0);
	     
	      Log.d("debugN", "Calling reciever");
	      AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
	      
	      alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pendingIntent);
		
	}
	
	public void saveData(View view) {
		new EndpointsTask().execute(getApplicationContext());
		finish();
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
