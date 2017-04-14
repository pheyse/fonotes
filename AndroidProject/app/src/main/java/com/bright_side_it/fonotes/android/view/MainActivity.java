package com.bright_side_it.fonotes.android.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.bright_side_it.fonotes.android.base.AndroidPlatform;
import com.bright_side_it.fonotes.android.base.FonotesAndroidBase;
import com.bright_side_it.fonotes.android.service.WebServerService;

import generated.fliesenui.core.FLUIAndroidWebView;

public class MainActivity extends AppCompatActivity {

	private AndroidPlatform platform = null;
	private FLUIAndroidWebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		platform = new AndroidPlatform(this);
		try{
			super.onCreate(savedInstanceState);
			getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
			getSupportActionBar().hide();
			webView = new FLUIAndroidWebView(this);
			webView.onCreate(this, FonotesAndroidBase.createScreenManager(this, platform, null, true));
			setContentView(webView);
		} catch (Throwable t){
			handleError(t);
		}
	}

	@Override
	protected void onResume() {
		try {
			super.onResume();
			if (WebServerService.isWebServerRunning()) {
				startActivity(new Intent(this, WebServerActivity.class));
				finish();
				return;
			}
			if (!PermissionsActivity.arePermissionsGranted(this)) {
				startActivity(new Intent(this, PermissionsActivity.class));
				finish();
				return;
			}
		} catch (Throwable t){
			handleError(t);
		}
	}

	private void handleError(Throwable t) {
		Log.e("Fonotes", "Error: " + t, t);
		if (platform != null){
			platform.handleError(new Exception("General error occured in main activity", t));
		}
	}

	@Override
	public void onBackPressed() {
		if (webView != null){
			webView.fireEventOnBackPressed();
		}
	}
}
