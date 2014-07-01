package com.example.intentstudy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {

	TextView tv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		tv = (TextView) findViewById(R.id.textView1);

		Intent obtainedIntent = getIntent();

		String obtainedUserName = obtainedIntent.getStringExtra("USERNAME");
		double obtainedPiValue = obtainedIntent.getDoubleExtra("PI", 0.0);
		boolean isMarried = obtainedIntent.getBooleanExtra("ISMARRIED", false);

		Bundle obtainedBag1 = obtainedIntent.getBundleExtra("vip");
		String obtainedComics = obtainedBag1.getString("COMICS");

		Bundle obtainedBag2 = obtainedIntent.getBundleExtra("carlton");
		int age = obtainedBag2.getInt("AGE");

		tv.setText("Hi," + obtainedUserName);

		Toast.makeText(getBaseContext(), "PI " + obtainedPiValue,
				Toast.LENGTH_LONG).show();

		Toast.makeText(getBaseContext(), "is Married " + isMarried,
				Toast.LENGTH_LONG).show();

		Toast.makeText(getBaseContext(), "Comics : " + obtainedComics,
				Toast.LENGTH_LONG).show();

		Toast.makeText(getBaseContext(), "Age " + age, Toast.LENGTH_LONG)
				.show();

	}

	public void goBack(View v) {

		Intent returningIntent = new Intent();
		returningIntent.putExtra("NAME", "RAJNIKANTH");

		setResult(RESULT_OK, returningIntent);
		
		finish();
	}
}
