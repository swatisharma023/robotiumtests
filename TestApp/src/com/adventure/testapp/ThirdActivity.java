package com.adventure.testapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.ToggleButton;
import android.view.View.OnClickListener;


public class ThirdActivity extends Activity {
	private String cityName;
	private Button submitButton;
	private RadioGroup radioGroup;
	private RadioButton radioButton;
	private CheckBox ckFood;
	private CheckBox ckElect;
	private CheckBox ckTravel;
	private CheckBox ckMovies;
	private ToggleButton toggleSMS;
	private Switch emailSwitch;
	private RatingBar overAllRating;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);
		Intent intent = getIntent();
		if(intent != null){
			cityName = intent.getExtras().getString("city");
		}
		submitButton = (Button) findViewById(R.id.close);
		radioGroup = (RadioGroup) findViewById(R.id.radioCity);
		
		ckFood = (CheckBox) findViewById(R.id.chkFood);
		ckElect = (CheckBox) findViewById(R.id.chkElect);
		ckTravel = (CheckBox) findViewById(R.id.chkTravel);
		ckMovies = (CheckBox) findViewById(R.id.chkMovies);
		
		toggleSMS = (ToggleButton) findViewById(R.id.toggleSMS);
		emailSwitch = (Switch)findViewById(R.id.switchEmail);
		overAllRating = (RatingBar) findViewById(R.id.ratingOverall);
		
		submitButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int chckRadioId = radioGroup.getCheckedRadioButtonId();
				radioButton = (RadioButton)findViewById(chckRadioId);
				final StringBuilder intrstStr = new StringBuilder();
				
				if(ckMovies.isChecked()){
					intrstStr.append(ckMovies.getText()+" ");
				}
				if(ckElect.isChecked()){
					intrstStr.append(ckElect.getText()+" ");
				}
				if(ckFood.isChecked()){
					intrstStr.append(ckFood.getText()+" ");
				}
				if(ckTravel.isChecked()){
					intrstStr.append(ckTravel.getText()+" ");
				}
				Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
				intent.putExtra("city", cityName);
				intent.putExtra("intersts", intrstStr.toString());
				intent.putExtra("qol", radioButton.getText());
				intent.putExtra("smsAlerts", toggleSMS.isChecked());
				intent.putExtra("emails", emailSwitch.isChecked());
				intent.putExtra("rating", overAllRating.getRating());
				
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.third, menu);
		return true;
	}

}
