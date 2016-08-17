package com.dhobs.cowsbulls;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Locale;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Play_pvp extends Activity {
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
		setContentView(R.layout.play_pvp);
		t = ((MyApplication) getApplication())
				.getTracker(MyApplication.TrackerName.APP_TRACKER);
		Intent p = getIntent();
		final String name2 = p.getExtras().getString("n2");
		final MediaPlayer s_button = MediaPlayer.create(this, R.raw.button);
		final String name1 = p.getExtras().getString("n1");
		final int sw = p.getExtras().getInt("sw");
		TextView displayname1 = (TextView) findViewById(R.id.textView1);
		Typeface stainy = Typeface.createFromAsset(this.getAssets(),
				"fonts/stainy.ttf");
		displayname1.setTypeface(stainy);
		final EditText w = (EditText) findViewById(R.id.word);
		final Intent pass_word = new Intent(this, Game.class);
		final Intent pass_word2 = new Intent(this, Game2.class);
		displayname1.setText(name1 + ", enter the word to be guessed:");
		Button next = (Button) findViewById(R.id.next);
		final TextView promt = (TextView) findViewById(R.id.textView2);
		AdView ad = (AdView) findViewById(R.id.ad);
		AdRequest adRequest = new AdRequest.Builder().build();
		ad.loadAd(adRequest);
		next.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				s_button.start();
				String word = w.getText().toString().trim();
				String W = word.toUpperCase(Locale.US);
				int good = checkword(W);
				if (good == 0) {
					int n = W.length();
					if (n == 0 || n == 1) {
						promt.setText("Enter at least 2 leters.");
					} else {
						int flag = 0;
						char[] words = W.toCharArray();
						for (int i = 0; i < n; i++) { // Checking if the letters
														// are
														// repeated.
							for (int j = 0; j < n; j++) {
								if (i == j)
									continue;
								if (words[i] == words[j] && flag == 0)
									flag = 1;
							}
						}
						if (flag == 0) {
							pass_word.putExtra("name2", name2);
							pass_word.putExtra("word", W);
							pass_word.putExtra("name1", name1);
							pass_word2.putExtra("name2", name2);
							pass_word2.putExtra("word", W);
							pass_word2.putExtra("name1", name1);
							if (sw == 0) {
								startActivity(pass_word);
							} else {
								startActivity(pass_word2);
							}
							finish();
						} else {
							AlertDialog.Builder al = new AlertDialog.Builder(
									Play_pvp.this);
							al.setTitle("RULE VIOLATION");
							al.setIcon(R.drawable.ic_launcher);
							al.setMessage("There should be no repitions of the letters in the word.");
							al.setNeutralButton(R.string.ok,
									new DialogInterface.OnClickListener() {
										public void onClick(
												DialogInterface dialog,
												int which) {
											dialog.cancel();
										}
									});
							AlertDialog al1 = al.create();
							al1.show();
						}
					}
				} else {
					AlertDialog.Builder al = new AlertDialog.Builder(
							Play_pvp.this);
					al.setMessage("Word does not exist in dictionary.");
					al.setTitle("Invalid word");
					al.setIcon(R.drawable.ic_launcher);
					al.setPositiveButton("OK",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int which) {
									dialog.dismiss();
								}
							});
					AlertDialog al1 = al.create();
					al1.show();
				}
			}
		});
	}

	public int checkword(String word) {
		try {
			Resources res = getResources();
			InputStream in = res.openRawResource(R.raw.dictionary);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String line = br.readLine();
			while (line != null) {
				if (line.equalsIgnoreCase(word)) {
					return 0;
				}
				line = br.readLine();
			}
		} catch (IOException e) {
		}
		return 1;
	}

}