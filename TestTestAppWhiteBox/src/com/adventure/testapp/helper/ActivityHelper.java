package com.adventure.testapp.helper;

import android.widget.EditText;

import com.adventure.testapp.R;
import com.adventure.testapp.SecondActivity;
import com.jayway.android.robotium.solo.Solo;

public class ActivityHelper {
	
	public static void goToSecondActivity(Solo solo){
		String email = "admin";
		String password = "admin";
		
		EditText emailEditText = (EditText) solo.getView(R.id.emailId);
		solo.clearEditText(emailEditText);
		solo.enterText(emailEditText, email);
		
		//Enter password
		EditText passwordEditText = (EditText) solo.getView(R.id.userPassword);
		solo.clearEditText(passwordEditText);
		solo.enterText(passwordEditText, password);
		
		//Click on Login Button
		solo.clickOnButton("SignIn");
		solo.waitForActivity(SecondActivity.class);
	}
	
	

}
