package com.dhobs.cowsbulls;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class History extends ListActivity {
	static Tracker t;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		t = ((MyApplication) getApplication())
				.getTracker(MyApplication.TrackerName.APP_TRACKER);
		Bundle b = this.getIntent().getExtras();
		String guesses[] = b.getStringArray("guess");
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, guesses));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.close, menu);
		return super.onCreateOptionsMenu(menu);
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
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.close:
			finish();
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
