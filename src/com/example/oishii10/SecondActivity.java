package com.example.oishii10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_activity);

		Intent intent = getIntent();
		String name = intent.getExtras().getString("Name");
		
		TextView text = (TextView) findViewById(R.id.textView2);
		text.setText(name);
	}

}
