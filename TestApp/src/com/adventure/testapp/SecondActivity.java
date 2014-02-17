package com.adventure.testapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class SecondActivity extends Activity {
	List<Map<String, String>> cityList = new ArrayList<Map<String, String>>();

	private void initList() {
		cityList.add(createCity("city", "Cupertino"));
		cityList.add(createCity("city", "Emeryville"));
		cityList.add(createCity("city", "Fremont"));
		cityList.add(createCity("city", "Los Altos"));
		cityList.add(createCity("city", "Los Gatos"));
		cityList.add(createCity("city", "Milpitas"));
		cityList.add(createCity("city", "Oakland"));
		cityList.add(createCity("city", "Palo Alto"));
		cityList.add(createCity("city", "San Jose"));
		cityList.add(createCity("city", "Santa Clara"));
		cityList.add(createCity("city", "Sunnyvale"));

	}

	private HashMap<String, String> createCity(String key, String name) {
		HashMap<String, String> city = new HashMap<String, String>();
		city.put(key, name);
		return city;
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_2);

		initList();
		ListView lv = (ListView) findViewById(R.id.cityList);

		SimpleAdapter simpleAdpt = new SimpleAdapter(this, cityList,
				android.R.layout.simple_list_item_1, new String[] { "city" },
				new int[] { android.R.id.text1 });
		lv.setAdapter(simpleAdpt);
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			public void onItemClick(AdapterView<?> parentAdapter, View view,
					int position,

					long id) {
				final TextView clickedView = (TextView) view;

				// We know the View is a TextView so we can cast it
				Builder builder = new AlertDialog.Builder(SecondActivity.this);
				builder.setTitle("Confirm");
				builder.setMessage("Do you want to continue with "+ clickedView.getText()+"?");
				builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
						intent.putExtra("city", clickedView.getText());
						startActivity(intent);
						
					}
				});
				builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						
					}
				});
				AlertDialog alertDialog =builder.create(); 
				alertDialog.show();
				
			}

		});

	}

}
