package com.example.randomthought;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.randomthought.EnterThoughts.EndpointsTask;
import com.example.randomthought.thoughtendpoint.Thoughtendpoint;
import com.example.randomthought.thoughtendpoint.model.Thought;
import com.google.android.gms.common.AccountPicker;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.json.jackson.JacksonFactory;

public class MainActivity extends Activity {
	
    private PendingIntent pendingIntent;
    String accountName = "";
    static final int REQUEST_CODE = 1;

    

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);	
		
		  //Sign into google account
	      Intent intent = AccountPicker.newChooseAccountIntent(null, null, new String[]{"com.google"},
	    	         false, null, null, null, null);
	      startActivityForResult(intent, REQUEST_CODE);

		
		  Log.d("debugN", "Main activity");  

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
		
	      //Create intent to call the question reciever class
	      Intent myIntent = new Intent(MainActivity.this, QuestionsReceiver.class);
	      pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent,0);
	     
	      //Set time for intent to be called
	      Log.d("debugN", "Calling reciever");
	      AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
	      alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),pendingIntent);	
	}
	
	public void getData() {
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
    	  //Link listview in view
    	  TextView test = (TextView) findViewById(R.id.textView2);
    	  //Create a thought and set it to the variable thought
          Thought result = endpoint.getThought(accountName).execute();
          String thoughtToGet = result.getThought();
          Log.d("debugN", "thought: " + thoughtToGet);
          
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
	         getData();
	   }
	 }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
