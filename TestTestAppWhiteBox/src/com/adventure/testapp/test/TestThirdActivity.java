package com.adventure.testapp.test;

import android.widget.TextView;

import com.adventure.testapp.FourthActivity;
import com.adventure.testapp.R;
import com.adventure.testapp.helper.ActivityHelper;
import com.jayway.android.robotium.solo.Solo;

public class TestThirdActivity extends BaseTestActivity{
	
	
	
	@Override
	public void setUp() throws Exception {
		super.setUp();
		ActivityHelper.goToThirdActivity(solo);
		solo.waitForText("Tell us your interests");
	}

	public void testSelectOptions() {

		// Select checkbox Movies
		solo.clickOnCheckBox(0);
		// Select checkbox Food
		solo.clickOnCheckBox(2);
		// check the Status of checkbox 'Movies'
		boolean actual1 = solo.isCheckBoxChecked(0);
		assertEquals("Movies is not Selected", true, actual1);
		// check the Status of checkbox 'Food'
		boolean actual2 = solo.isCheckBoxChecked(2);
		assertEquals("Food is not Selected", true, actual2);
		// Select a radiobutton
		solo.clickOnRadioButton(0);
		boolean actual = solo.isRadioButtonChecked("Awesome");
		// Select a togglebutton
		boolean search = solo.searchToggleButton("OFF");
		 assertEquals("Toggle Button not found",true, search);
		 solo.clickOnToggleButton("OFF");
		// Select the rating
		solo.setProgressBar(0, 6);
		// Click on submit feedback button
		solo.clickOnButton("Submit Feedback");
		// wait for the next activity to appear
		solo.waitForActivity("FourthActivity.class");
		solo.assertCurrentActivity("Fourth Acivity", FourthActivity.class);
		//Test the values on the fourth activity
		TextView textView = (TextView) solo.getView(R.id.textViewCity);
		// Validate the text on the TextView City
		assertEquals("Selected city is not displayed", "Cupertino", textView
				.getText().toString());
		TextView textViewQOL = (TextView) solo.getView(R.id.textViewQOL);
		// Validate the text on the TextView City
		assertEquals("Selected value for QOL is not displayed", "Awesome", textViewQOL
				.getText().toString());
		TextView textViewSMS = (TextView) solo.getView(R.id.textViewSMS);
		// Validate the text on the TextView City
		assertEquals("Selected value for SMS is not displayed", "Yes", textViewSMS
				.getText().toString());
		TextView textViewRating = (TextView) solo.getView(R.id.textViewRating);
		// Validate the text on the TextView City
		assertEquals("Selected value for Rating is not displayed", "3.0", textViewRating
				.getText().toString());
		
	}
}
