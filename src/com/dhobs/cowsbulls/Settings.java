package com.dhobs.cowsbulls;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.Toast;

public class Settings extends ListActivity {

	String[] settings = { "", "Select background", "Autosave" };
	String[] back = { "Black", "Green" };
	String[] auto = { "Yes", "No" };
	int x = 0, a = 0;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		t = ((MyApplication) getApplication())
				.getTracker(MyApplication.TrackerName.APP_TRACKER);
		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, settings));
	}

	private void saveP(int x) {
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		Editor edit = sp.edit();
		edit.putInt("b", x);
		edit.putInt("auto", a);
		edit.commit();
		Toast.makeText(this, "Done!", Toast.LENGTH_LONG).show();
	}

	private void loadP() {
		SharedPreferences sp = PreferenceManager
				.getDefaultSharedPreferences(this);
		x = sp.getInt("b", 0);
		a = sp.getInt("auto", 0);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		switch (position) {
		case 1:
			AlertDialog.Builder alert = new AlertDialog.Builder(this);
			final NumberPicker np = new NumberPicker(this);
			np.setMinValue(0);
			np.setMaxValue(1);
			np.setDisplayedValues(back);
			np.setWrapSelectorWheel(false);
			loadP();
			np.setValue(x);
			alert.setView(np);
			np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
				@Override
				public void onValueChange(NumberPicker picker, int oldVal,
						int newVal) {
					x = newVal;
				}
			});
			alert.setPositiveButton("Ok",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog,
								int whichButton) {
							saveP(x);
							dialog.dismiss();
							np.setValue(x);
						}
					});
			alert.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							dialog.cancel();
						}
					});
			alert.show();
			break;
		case 2:
			AlertDialog.Builder alert2 = new AlertDialog.Builder(this);
			final NumberPicker np2 = new NumberPicker(this);
			np2.setMinValue(0);
			np2.setMaxValue(1);
			np2.setDisplayedValues(auto);
			np2.setWrapSelectorWheel(false);
			loadP();
			np2.setValue(a);
			alert2.setView(np2);
			np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
				@Override
				public void onValueChange(NumberPicker picker, int oldVal,
						int newVal) {
					a = newVal;
				}
			});
			alert2.setPositiveButton("Ok",
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog,
								int whichButton) {
							saveP(x);
							dialog.dismiss();
							np2.setValue(a);
						}
					});
			alert2.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							dialog.cancel();
						}
					});
			alert2.show();
			break;
		}
	}

}
