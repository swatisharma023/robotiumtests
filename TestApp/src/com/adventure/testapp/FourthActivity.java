package com.adventure.testapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.widget.TextView;

public class FourthActivity extends Activity {
	private TextView interests;
	private TextView qol;
	private TextView sms;
	private TextView email;
	private TextView rating;
	private TextView city;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_fourth);
		Intent intent = getIntent();
		interests = (TextView)findViewById(R.id.textViewInt);
		qol = (TextView)findViewById(R.id.textViewQOL);
		sms = (TextView)findViewById(R.id.textViewSMS);
		email = (TextView)findViewById(R.id.textViewEmail);
		rating = (TextView)findViewById(R.id.textViewRating);
		city = (TextView)findViewById(R.id.textViewCity);
		
		if(intent != null){
			city.setText(intent.getExtras().getString("city"));
			qol.setText(intent.getExtras().getString("qol"));
			interests.setText(intent.getExtras().getString("intersts"));
			sms.setText(intent.getExtras().getBoolean("smsAlerts") ? "Yes" : "No");
			email.setText(intent.getExtras().getBoolean("emails")? "Yes" : "No");
			rating.setText(""+intent.getExtras().getFloat("rating"));
			
		}
	}

}
