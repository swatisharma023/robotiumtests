package com.adventure.testapp;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText username = null;
	private EditText password = null;
	private Button login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		username = (EditText) findViewById(R.id.emailId);
		password = (EditText) findViewById(R.id.userPassword);
		login = (Button) findViewById(R.id.signIn);
		final Context context = this;

		login.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				if (username.getText().toString().equals("admin")
						&& password.getText().toString().equals("admin")) {
					Toast.makeText(getApplicationContext(), "Redirecting...",
							Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(context, SecondActivity.class);
					startActivity(intent);
				} else {
					Toast.makeText(getApplicationContext(), "Wrong Credentials",
							Toast.LENGTH_SHORT).show();
				}
				

			}

		});
	}

	public void login(View view) {
		
		
		login = (Button) findViewById(R.id.signIn);

		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;

	}
}
