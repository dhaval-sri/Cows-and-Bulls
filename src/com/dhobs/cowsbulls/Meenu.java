package com.dhobs.cowsbulls;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

public class Meenu extends Activity {

	static Tracker t;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final MediaPlayer s_button;
		t = ((MyApplication) getApplication())
				.getTracker(MyApplication.TrackerName.APP_TRACKER);
		TextView tv = (TextView) findViewById(R.id.heading);
		Typeface tf = Typeface.createFromAsset(this.getAssets(),
				"fonts/cursive.ttf");
		tv.setTypeface(tf);
		AdView ad = (AdView) findViewById(R.id.ad);
		AdRequest adRequest = new AdRequest.Builder().addTestDevice(
				"128E3317264CB405").build();
		ad.loadAd(adRequest);
		s_button = MediaPlayer.create(this, R.raw.button);
		Button play = (Button) findViewById(R.id.play);
		play.getBackground().setAlpha(215);
		play.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				s_button.start();
				startActivity(new Intent("com.dhobs.cowsbulls.GAME_MODE"));
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.settings:
			startActivity(new Intent("com.dhobs.cowsbulls.SETTINGS"));
			return true;
		case R.id.exit:
			finish();
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	@Override
	protected void onStart() {
		super.onStart();
		GoogleAnalytics.getInstance(this).reportActivityStart(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		GoogleAnalytics.getInstance(this).reportActivityStop(this);
	}
}
