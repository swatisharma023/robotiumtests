package com.adventure.testapp.test;

import android.test.ActivityInstrumentationTestCase2;

import com.adventure.testapp.MainActivity;
import com.jayway.android.robotium.solo.Solo;

public class BaseTestActivity extends ActivityInstrumentationTestCase2 {
	protected Solo solo;
	public BaseTestActivity() {
		super(MainActivity.class);
	}
	@Override
	public void setUp() throws Exception {
	super.setUp();
	solo = new Solo(getInstrumentation(), getActivity());
	}
	
	@Override
	public void tearDown() throws Exception{
	solo.finishOpenedActivities();
	}	

}
