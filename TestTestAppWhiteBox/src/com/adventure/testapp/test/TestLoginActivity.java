package com.adventure.testapp.test;

import android.widget.EditText;

import com.adventure.testapp.R;

public class TestLoginActivity extends BaseTestActivity {
	
	public void testlogin(String email, String password, String text){
		EditText emailEditText = (EditText) solo.getView(R.id.emailId);
		solo.clearEditText(emailEditText);
		solo.enterText(emailEditText, email);
		
		//Enter password
		EditText passwordEditText = (EditText) solo.getView(R.id.userPassword);
		solo.clearEditText(passwordEditText);
		solo.enterText(passwordEditText, password);
		
		//Click on Login Button
		solo.clickOnButton("SignIn");
		assertTrue(solo.waitForText(text));
	}
	public void testValidLogin(){
		testlogin("admin","admin","Redirecting...");		
		
	}
	public void testLoginWithWrongPassword(){
		testlogin("admin","abcdef","Wrong Credentials");
		
	}
	public void testLoginWithWrongUsername(){
			testlogin("abcdef","admin","Wrong Credentials");
	}
	public void testLoginWithBlankCredentials(){
		testlogin("","","Wrong Credentials");
}
}
