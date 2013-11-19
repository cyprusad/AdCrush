package com.adcrush;

import android.app.Application;

import com.parse.Parse;

public class AdCrushApplication extends Application {

	@Override
	public void onCreate() {
		Parse.initialize(this, "nYzAZ8kdEz723uJrPF5GNPtDPi7ArZ4sMPOW2EM9",
				"HX2KqG6QDlnqmHy2fEjgUFRHMIk4hMUCLS4ykXNY");
	}
}
