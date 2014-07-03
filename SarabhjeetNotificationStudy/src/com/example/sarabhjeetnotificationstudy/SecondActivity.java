package com.example.sarabhjeetnotificationstudy;

import android.os.Bundle;
import android.app.Activity;
import android.app.NotificationManager;
import android.view.Menu;

public class SecondActivity extends Activity {

	NotificationManager nfmgr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		nfmgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		nfmgr.cancel(1);

	}

}
