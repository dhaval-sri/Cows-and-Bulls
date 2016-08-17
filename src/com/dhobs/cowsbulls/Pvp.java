package com.dhobs.cowsbulls;

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
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class Pvp extends Activity {
	private int on = 0;
	private int y;
	private String date, n1, n2;
	static Tracker t;

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

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.pvp);
		t = ((MyApplication) getApplication())
				.getTracker(MyApplication.TrackerName.APP_TRACKER);
		loadGame();
		final Intent pass = new Intent(this, Play_pvp.class);
		final Intent pass_word = new Intent(this, Game.class);
		final Intent pass_word2 = new Intent(this, Game2.class);
		pass_word.putExtra("name2", n2);
		pass_word.putExtra("name1", n1);
		pass_word2.putExtra("name2", n2);
		pass_word2.putExtra("name1", n1);
		if (y != 11)
			on = 0;
		else
			on = 1;

		if (date != "0") {
			AlertDialog.Builder al = new AlertDialog.Builder(Pvp.this);
			al.setMessage("You have a saved game of " + date
					+ ". Do you want to continue?");
			al.setTitle("Saved Game");
			al.setCancelable(false);
			al.setIcon(R.drawable.ic_launcher);
			al.setPositiveButton(R.string.yes,
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							dialog.cancel();
							if (on == 0)
								startActivity(pass_word);
							else
								startActivity(pass_word2);
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
		final MediaPlayer s_button = MediaPlayer.create(this, R.raw.button);
		TextView tv = (TextView) findViewById(R.id.pvpheading);
		Typeface tf = Typeface.createFromAsset(this.getAssets(),
				"fonts/game_thick.otf");
		tv.setTypeface(tf);
		final TextView name = (TextView) findViewById(R.id.asknamep1);
		Typeface stainy = Typeface.createFromAsset(this.getAssets(),
				"fonts/stainy.ttf");
		name.setTypeface(stainy);
		final TextView name2 = (TextView) findViewById(R.id.asknamep2);
		name2.setTypeface(stainy);
		final EditText namep1 = (EditText) findViewById(R.id.namep1);
		final EditText namep2 = (EditText) findViewById(R.id.namep2);
		AdView ad = (AdView) findViewById(R.id.ad);
		AdRequest adRequest = new AdRequest.Builder().build();
		ad.loadAd(adRequest);

		Button submit = (Button) findViewById(R.id.submit);
		Switch sw = (Switch) findViewById(R.id.switch1);
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

		submit.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				s_button.start();
				n1 = namep1.getText().toString();
				n2 = namep2.getText().toString();
				n1 = n1.trim();
				n2 = n2.trim();
				int len_n1 = n1.length();
				int len_n2 = n2.length();
				if (len_n1 == 0 || len_n2 == 0) {
					AlertDialog.Builder al = new AlertDialog.Builder(Pvp.this);
					al.setTitle("RULE VIOLATION");
					al.setIcon(R.drawable.ic_launcher);
					al.setMessage("Name field cannot be left empty.");
					al.setNeutralButton(R.string.ok,
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();
								}
							});
					AlertDialog al1 = al.create();
					al1.show();
				} else {
					pass.putExtra("n1", n1);
					pass.putExtra("n2", n2);
					pass.putExtra("sw", on);
					startActivity(pass);
					finish();
				}
			}
		});
	}

	private void clearP() {
		SharedPreferences sp = this.getSharedPreferences("SaveGamePVP",
				Context.MODE_PRIVATE);
		Editor e = sp.edit();
		e.clear();
		e.commit();
	}

	private void loadGame() {
		SharedPreferences sp = this.getSharedPreferences("SaveGamePVP",
				Context.MODE_PRIVATE);
		date = sp.getString("date", "0");
		y = sp.getInt("y", 11);
		n1 = sp.getString("name1", "Player1");
		n2 = sp.getString("name2", "Player2");
	}

}
