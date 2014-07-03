package com.example.viewstudy;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button b1;

	EditText edName;
	CheckBox ch;
	RadioButton radioMale;
	RatingBar rb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b1 = (Button) findViewById(R.id.button1);
		edName = (EditText) findViewById(R.id.edName);
		ch = (CheckBox) findViewById(R.id.checkBox1);
		rb = (RatingBar) findViewById(R.id.ratingBar1);
		radioMale = (RadioButton) findViewById(R.id.radioMale);

		b1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getBaseContext(), "Button id Clciked",
						Toast.LENGTH_SHORT).show();
			}
		});

		edName.setOnFocusChangeListener(new OnFocusChangeListener() {
			@Override
			public void onFocusChange(View v, boolean hasFocus) {

				if (hasFocus == true) {
					if (edName.getText().equals("Please enter name")) {
						edName.setTextColor(Color.BLACK);
						edName.setText("");
					}
				} else {
					String name = edName.getText().toString();
					if (name.equals("")) {
						edName.setTextColor(Color.RED);
						edName.setText("Please enter name");
					}
				}

			}
		});

		ch.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {

				String status = (isChecked == true ? "Checked" : "Unchecked");
				Toast.makeText(getBaseContext(), "Conditions " + status,
						Toast.LENGTH_SHORT).show();

			}
		});
		radioMale.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				String status = (isChecked == true ? "Male" : "Not Male");
				Toast.makeText(getBaseContext(), "Conditions " + status,
						Toast.LENGTH_SHORT).show();

			}
		});

		rb.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {

			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {

				Toast.makeText(getBaseContext(),
						"Rating " + rating + " ,frmUser " + fromUser,
						Toast.LENGTH_SHORT).show();

			}
		});

	}
}
