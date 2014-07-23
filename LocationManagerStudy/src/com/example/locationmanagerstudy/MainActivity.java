package com.example.locationmanagerstudy;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	TextView tvLat, tvLong, tvAdd;

	LocationManager locmgr;
	LocationListener locLis;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tvLat = (TextView) findViewById(R.id.textView1);
		tvLong = (TextView) findViewById(R.id.textView2);
		tvAdd = (TextView) findViewById(R.id.textView3);

		locmgr = (LocationManager) getSystemService(LOCATION_SERVICE);
		locLis = new LocationListener() {

			@Override
			public void onLocationChanged(Location location) {

				double lati = location.getLatitude();
				double longi = location.getLongitude();

				tvLat.setText("Lat : " + lati);
				tvLong.setText("Long : " + longi);

				Toast.makeText(getBaseContext(),
						"Lat : " + lati + " ,Long : " + longi,
						Toast.LENGTH_SHORT).show();

				String locationAddress = "";

				try {
					Geocoder gc = new Geocoder(getBaseContext());
					List<Address> addrresList = gc.getFromLocation(lati, longi,
							5);

					for (Address ad : addrresList) {
						for (int i = 0; i < ad.getMaxAddressLineIndex(); i++) {
							locationAddress += ad.getAddressLine(i);
						}

					}

					tvAdd.setText("Address : " + locationAddress);

					Toast.makeText(getBaseContext(), "Add " + locationAddress,
							Toast.LENGTH_SHORT).show();

				} catch (IOException e) {
					Toast.makeText(getBaseContext(),
							"No Internet " + e.getMessage(), Toast.LENGTH_SHORT)
							.show();
					e.printStackTrace();
				}

			}

			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {

				switch (status) {
				case LocationProvider.AVAILABLE:

					Toast.makeText(getBaseContext(),
							provider + " is available.", Toast.LENGTH_SHORT)
							.show();
					break;
				case LocationProvider.OUT_OF_SERVICE:

					Toast.makeText(getBaseContext(),
							provider + " is out of service.",
							Toast.LENGTH_SHORT).show();
					break;

				case LocationProvider.TEMPORARILY_UNAVAILABLE:

					Toast.makeText(getBaseContext(),
							provider + " is temporarily unavailabe.",
							Toast.LENGTH_SHORT).show();
					break;

				default:
					break;
				}
			}

			@Override
			public void onProviderEnabled(String provider) {
				Toast.makeText(getBaseContext(), provider + "  enabled.",
						Toast.LENGTH_SHORT).show();

			}

			@Override
			public void onProviderDisabled(String provider) {
				Toast.makeText(getBaseContext(), provider + " is disabled",
						Toast.LENGTH_SHORT).show();

			}

		};

	}

	@Override
	protected void onResume() {
		locmgr.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0,
				locLis);
		super.onResume();
	}

	@Override
	protected void onPause() {
		locmgr.removeUpdates(locLis);
		super.onPause();
	}
}
