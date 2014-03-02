package com.adventure.testapp.helper;

import android.widget.EditText;
import android.widget.ListView;

import com.adventure.testapp.FourthActivity;
import com.adventure.testapp.R;
import com.adventure.testapp.SecondActivity;
import com.adventure.testapp.ThirdActivity;
import com.adventure.testapp.test.TestThirdActivity;
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
	public static void goToThirdActivity(Solo solo){
		goToSecondActivity(solo);
		solo.waitForView(R.id.cityList);
		ListView l = solo.getCurrentViews(ListView.class).get(0);
		solo.waitForText("Select City");
		solo.clickInList(1);
		solo.waitForDialogToOpen();
		solo.clickOnText("Yes");
		solo.waitForActivity(ThirdActivity.class);
		solo.assertCurrentActivity("This is third Activity", ThirdActivity.class);
	
	}
	
}
