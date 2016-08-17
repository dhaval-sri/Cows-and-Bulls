package com.dhobs.cowsbulls;

import java.util.Random;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class Cvp extends Activity implements OnSeekBarChangeListener {
	private int on = 0;
	private int k = 2;
	private int y;
	private String date;
	private String word;
	TextView sbtv;
	static Tracker t;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.cvp);
		loadP();
		loadGame();
		t = ((MyApplication) getApplication())
				.getTracker(MyApplication.TrackerName.APP_TRACKER);
		final Intent cvp1 = new Intent(this, Cvpgame.class);
		final Intent cvp2 = new Intent(this, Cvpgame2.class);
		cvp1.putExtra("word", word);
		cvp2.putExtra("word", word);
		if (date != "0") {
			AlertDialog.Builder al = new AlertDialog.Builder(Cvp.this);
			al.setMessage("You have a saved game of " + date
					+ ". Do you want to continue?");
			al.setTitle("Saved Game");
			al.setCancelable(false);
			al.setIcon(R.drawable.ic_launcher);
			al.setPositiveButton(R.string.yes,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							dialog.cancel();
							if (y != 11)
								startActivity(cvp1);
							else
								startActivity(cvp2);
							finish();
						}
					});
			al.setNegativeButton("No, delete previous data",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							dialog.cancel();
							clearP();
						}
					});
			AlertDialog al1 = al.create();
			al1.show();
		}
		sbtv = (TextView) findViewById(R.id.seek_tv);
		Typeface stainy = Typeface.createFromAsset(this.getAssets(),
				"fonts/stainy.ttf");
		sbtv.setTypeface(stainy);
		TextView tv = (TextView) findViewById(R.id.cvpheading);
		Typeface tf = Typeface.createFromAsset(getAssets(),
				"fonts/game_thick.otf");
		tv.setTypeface(tf);
		final String c[] = { "crop", "plus", "done", "fort", "lamb", "chop",
				"trip", "bay", "day", "hay", "may", "pay", "ray", "say", "way",
				"fray", "gray", "play", "pray", "stray", "bake", "cake",
				"fake", "lake", "make", "take", "ate", "date", "fate", "gate",
				"hate", "late", "mate", "rate", "age", "cage", "page", "rage",
				"damp", "lamp", "stamp", "bow", "how", "now", "cow", "tie",
				"pie", "lie", "die", "bike", "dike", "hike", "like", "pike",
				"bye", "cry", "dry", "fry", "try", "toe", "hoe", "paw", "raw",
				"saw", "cat", "cow", "bird", "dog", "duck", "frog", "lion",
				"rest", "west", "hide", "ride", "wide", "bump", "dump", "hump",
				"lump", "point", "girl", "boy", "his", "her", "mine", "ours",
				"they", "them", "him", "her", "it", "bowl", "fork", "home",
				"lawn", "pond", "tram", "plane", "truck", "raw" };
		Button play = (Button) findViewById(R.id.button1);
		SeekBar sk = (SeekBar) findViewById(R.id.seeks);
		sk.setOnSeekBarChangeListener(this);
		sk.setMax(300);
		sk.setProgress(k * 100);
		Switch sw = (Switch) findViewById(R.id.switch2);
		AdView ad = (AdView) findViewById(R.id.ad);
		AdRequest adRequest = new AdRequest.Builder().build();
		ad.loadAd(adRequest);
		sw.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				if (isChecked) {
					on = 1;
				} else {
					on = 0;
				}
			}
		});

		play.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Random r = new Random();
				int rand = r.nextInt(101);
				word = c[rand].toString();
				while (!(k == word.length())) {
					r = new Random();
					rand = r.nextInt(101);
					word = c[rand].toString();
				}
				cvp1.putExtra("word", word);
				cvp2.putExtra("word", word);
				saveP(k);
				if (on == 0) {
					startActivity(cvp1);
				} else {
					startActivity(cvp2);
				}
				finish();
			}
		});
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress,
			boolean fromUser) {
		k = progress / 100 + 2;
		sbtv.setText("Length of word:" + k);
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {
		sbtv.setText("Length of word:" + k);
	}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {
		sbtv.setText("Length of word:" + k);
	}

	private void saveP(int k) {
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		Editor edit = sp.edit();
		edit.putInt("k", k);
		edit.commit();
	}

	private void loadP() {
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		k = sp.getInt("k", 2);
	}

	private void clearP() {
		SharedPreferences sp = this.getSharedPreferences("SaveGame",
				Context.MODE_PRIVATE);
		Editor e = sp.edit();
		e.clear();
		e.commit();
	}

	private void loadGame() {
		SharedPreferences sp = this.getSharedPreferences("SaveGame",
				Context.MODE_PRIVATE);
		date = sp.getString("date", "0");
		y = sp.getInt("y", 11);
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