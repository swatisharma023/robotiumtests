package com.adventure.testapp.test;

import java.util.ArrayList;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.adventure.testapp.R;
import com.adventure.testapp.SecondActivity;
import com.adventure.testapp.ThirdActivity;
import com.adventure.testapp.helper.ActivityHelper;



public class TestSecondActivity extends BaseTestActivity {
	
	@Override
	public void setUp() throws Exception {
	super.setUp();
	ActivityHelper.goToSecondActivity(solo);
	solo.waitForView(R.id.cityList);
	}
	
	public void testSelectCity(String cityName, boolean confirm) {
		ListView l = solo.getCurrentViews(ListView.class).get(0);
		solo.waitForText("Select City");

		for (int i = 0; i < l.getChildCount(); i++) {
			TextView vw = (TextView) l.getChildAt(i);
			String city = vw.getText().toString();
			//System.out.println("<<<" + city);
			
			if (city.equals(cityName)) {
				solo.clickInList(i + 1);
				assertTrue(solo.waitForDialogToOpen());
				if (confirm) {
					solo.clickOnText("Yes");
					solo.assertCurrentActivity("", ThirdActivity.class);
					break;
				} else {
					solo.clickOnText("No");
					solo.assertCurrentActivity("", SecondActivity.class);
					break;
				}
			}
		}
	}
	public void testSelectFremont(){
		testSelectCity("Fremont", false);
	}
	public void testSelectAnotherCity(){
		testSelectCity("Milpitas", false);
		testSelectCity("Palo Alto", true);
	}
	
		
		
}
			