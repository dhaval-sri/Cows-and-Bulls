package com.dhobs.cowsbulls;

import java.util.HashMap;

import android.app.Application;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;

public class MyApplication extends Application {
	// The following line should be changed to include the correct property id.
	private static final String PROPERTY_ID = "UA-52180168-2";

	// Logging TAG
	@SuppressWarnings("unused")
	private static final String TAG = "Cows and Bulls";

	public static int GENERAL_TRACKER = 0;

	public enum TrackerName {
		APP_TRACKER, // Tracker used only in this app.
		GLOBAL_TRACKER, // Tracker used by all the apps from a company. eg:
						// roll-up tracking.
	}

	HashMap<TrackerName, Tracker> mTrackers = new HashMap<TrackerName, Tracker>();

	public MyApplication() {
		super();
	}

	synchronized Tracker getTracker(TrackerName trackerId) {
		if (!mTrackers.containsKey(trackerId)) {

			GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
			Tracker t = (trackerId == TrackerName.APP_TRACKER) ? analytics
					.newTracker(R.xml.app_tracker) : analytics
					.newTracker(PROPERTY_ID);
			mTrackers.put(trackerId, t);

		}
		return mTrackers.get(trackerId);
	}
}