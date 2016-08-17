package com.dhobs.cowsbulls;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;

public class Main extends Activity {
	MediaPlayer logoMusic;
	static Tracker t;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setContentView(R.layout.splash);
		t = ((MyApplication) getApplication())
				.getTracker(MyApplication.TrackerName.APP_TRACKER);
		TextView tech = (TextView) findViewById(R.id.technicavoyage);
		Typeface style = Typeface.createFromAsset(this.getAssets(),
				"fonts/backslash.ttf");
		tech.setTypeface(style);

		logoMusic = MediaPlayer.create(this, R.raw.cow);
		logoMusic.start();

		Thread logoTimer = new Thread() {
			public void run() {
				try {
					sleep(3000);
					Intent menuintent = new Intent("com.dhobs.cowsbulls.MEENU");
					startActivity(menuintent);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					finish();
				}
			}
		};
		logoTimer.start();
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

	@Override
	protected void onPause() {
		super.onPause();
		logoMusic.stop();
	}

}
