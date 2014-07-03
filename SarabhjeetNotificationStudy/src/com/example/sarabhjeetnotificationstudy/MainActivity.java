package com.example.sarabhjeetnotificationstudy;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	NotificationManager nfmgr;

	Notification nf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		nfmgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		nf = new Notification(R.drawable.ic_launcher, "Meeting in 5 Mins",
				System.currentTimeMillis());

		// Intent i = new Intent(Intent.ACTION_VIEW);
		// i.setData(Uri.parse("tel:13212312"));

		Intent i = new Intent(getBaseContext(), SecondActivity.class);

		PendingIntent pi = PendingIntent.getActivity(getBaseContext(), 1, i, 0);

		nf.setLatestEventInfo(getBaseContext(), "Urgent Meeting",
				"Obama is waiting  for you", pi);

	}

	public void generateNotif(View v) {
		nfmgr.notify(1, nf);

	}

}
