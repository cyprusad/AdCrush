package com.swas.clashofads;

import android.os.Bundle;
import android.app.Activity;
import android.util.TypedValue;
import android.view.Menu;
import android.view.ViewGroup.LayoutParams;
import android.location.Location;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMInterstitial;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMBroadcastReceiver;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.RequestListener.RequestListenerImpl;
import com.swas.clashofads.LocationValet.ILocationValetListener;

public class MainActivity extends Activity {
	
	LocationValet locationValet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		MMSDK.initialize(this);
		locationValet = new LocationValet(this, new ILocationValetListener()
        {
            public void onBetterLocationFound(Location userLocation)
            {
                MMRequest.setUserLocation(userLocation);
            }
        });
		
		//Find the ad view for reference
		MMAdView adViewFromXml = (MMAdView) findViewById(R.id.adView);

		//MMRequest object
		MMRequest request = new MMRequest();
		
		//Add metadata here.
		
		//Add the MMRequest object to your MMAdView.
		adViewFromXml.setMMRequest(request);

		adViewFromXml.getAd();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
    protected void onResume()
    {
        if(!locationValet.startAquire(true))
        {
            Toast.makeText(this, "Unable to start acquiring location, do you have the permissions declared?", Toast.LENGTH_LONG).show();

            // Manifest.permission.ACCESS_FINE_LOCATION
            // Manifest.permission.ACCESS_COARSE_LOCATION
        }
        super.onResume();
    }
	
	@Override
    protected void onPause()
    {
        locationValet.stopAquire();
        super.onPause();
    }

}
