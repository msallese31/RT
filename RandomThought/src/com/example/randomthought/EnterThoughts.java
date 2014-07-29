package com.example.randomthought;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import com.example.randomthought.thoughtendpoint.Thoughtendpoint;
import com.example.randomthought.thoughtendpoint.model.Thought;
import com.google.android.gms.common.AccountPicker;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson.JacksonFactory;

import android.accounts.AccountManager;
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
    static final int REQUEST_CODE = 1;
    String accountName = "";

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.enter_thoughts);		
		Log.d("debugN", "EnterThoughts activity");  
		
		  //Sign into google account
	      Intent intent = AccountPicker.newChooseAccountIntent(null, null, new String[]{"com.google"},
	    	         false, null, null, null, null);
	      startActivityForResult(intent, REQUEST_CODE);
		


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
    	  //Link edittext in view
    	  EditText enterThoughtET = (EditText) findViewById(R.id.editTextEnterThought);
    	  //Set thought variable to the edittext's value
    	  String thought = enterThoughtET.getText().toString();
    	  //Create a thought and set it to the variable thought
          Thought thoughtToEnter = new Thought().setThought(thought);
          //Set accountName of thought
          thoughtToEnter.setAccountName(accountName);
          
          DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
          Date dateForID = new Date();
          String IDDate = dateFormat.format(dateForID).toString();
          thoughtToEnter.setId(IDDate);
          
          Thought result = endpoint.insertThought(thoughtToEnter).execute();
      } catch (IOException e) {
        e.printStackTrace();
      }
          return (long) 0;
        }
    }
	
	 protected void onActivityResult(final int requestCode, final int resultCode,
	         final Intent data) {
	     if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
	         accountName = data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
	         Log.d("debugN", "Account name: " + accountName);
	   }
	 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
