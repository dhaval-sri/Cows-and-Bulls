package com.dhobs.cowsbulls;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class game_mode extends Activity {

	static Tracker t;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.game_mode);
		t = ((MyApplication) getApplication())
				.getTracker(MyApplication.TrackerName.APP_TRACKER);
		final MediaPlayer s_button = MediaPlayer.create(this, R.raw.button);
		Button cvp = (Button) findViewById(R.id.button1p);
		Typeface italic = Typeface.createFromAsset(this.getAssets(),
				"fonts/Roboto-Italic.ttf");
		TextView gm = (TextView) findViewById(R.id.gm);
		gm.setTypeface(italic);
		cvp.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				s_button.start();
				Intent CVP = new Intent("com.dhobs.cowsbulls.CVP");
				startActivity(CVP);
			}
		});
		AdView ad = (AdView) findViewById(R.id.ad);
		AdRequest adRequest = new AdRequest.Builder().build();
		ad.loadAd(adRequest);
		Button pvp = (Button) findViewById(R.id.button2p);
		pvp.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				s_button.start();
				Intent PVP = new Intent("com.dhobs.cowsbulls.PVP");
				startActivity(PVP);
			}
		});
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
		finish();
	}
}
