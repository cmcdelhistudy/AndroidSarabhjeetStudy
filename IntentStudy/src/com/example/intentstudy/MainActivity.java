package com.example.intentstudy;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewDebug.IntToString;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText edName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		edName = (EditText) findViewById(R.id.editText1);
	}

	public void doSomething(View v) {

		// Intent i = new Intent(Intent.ACTION_VIEW);
		// //i.setData(Uri.parse("http://www.facebook.com"));
		// i.setData(Uri.parse("geo:12.45656,89.4565"));
		// startActivity(i);

		// Intent i = new Intent(Intent.ACTION_DIAL);
		// i.setData(Uri.parse("tel:43434234"));
		// startActivity(i);

		// Intent i = new Intent(Intent.ACTION_CALL);
		// i.setData(Uri.parse("tel:43434234"));
		// startActivity(i);

		String uname = edName.getText().toString();

		Intent i = new Intent(getBaseContext(), SecondActivity.class);

		i.putExtra("USERNAME", uname);
		i.putExtra("PI", 3.14);
		i.putExtra("ISMARRIED", false);

		Bundle bag1 = new Bundle();
		bag1.putString("COMICS", "Tintin");

		Bundle bag2 = new Bundle();
		bag2.putInt("AGE", 12);

		i.putExtra("vip", bag1);
		i.putExtra("carlton", bag2);

		// startActivity(i);
		startActivityForResult(i, 2);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent i) {

		if (requestCode == 2) {

			if (resultCode == RESULT_OK) {

				String str = i.getStringExtra("NAME");

				Toast.makeText(getBaseContext(), str + " . . .the BOSS",
						Toast.LENGTH_LONG).show();

			}
		}

		super.onActivityResult(requestCode, resultCode, i);
	}
}
