package com.adcrush;

import com.mopub.mobileads.MoPubView;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
	
	private MoPubView moPubView1;
	private MoPubView moPubView2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ad_crush_application);
		
		moPubView1 = (MoPubView) findViewById(R.id.adview1);
		moPubView1.setAdUnitId("7f1d6bc44c7b44cc92d97b3829498daf"); // Enter your Ad Unit ID from www.mopub.com
		moPubView1.loadAd();
		
		moPubView2 = (MoPubView) findViewById(R.id.adview2);
		moPubView2.setAdUnitId("20a9c46810d04c5fb6af55ebc8a995d1"); // Enter your Ad Unit ID from www.mopub.com
		moPubView2.loadAd();
	}
	
	@Override
	protected void onDestroy() {
		moPubView1.destroy();
		moPubView2.destroy(); 
	    super.onDestroy(); 
	}
}
