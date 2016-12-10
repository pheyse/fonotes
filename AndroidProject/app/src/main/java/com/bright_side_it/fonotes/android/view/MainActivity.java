package com.bright_side_it.fonotes.android.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.bright_side_it.fonotes.android.base.FonotesAndroidBase;
import com.bright_side_it.fonotes.android.service.WebServerService;

import generated.fliesenui.core.FLUIAndroidWebView;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
		getSupportActionBar().hide();
//		getActionBar().hide();
		FLUIAndroidWebView webView = new FLUIAndroidWebView(this);
		webView.onCreate(this, FonotesAndroidBase.createScreenManager(this, null, true));
		setContentView(webView);
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (WebServerService.isWebServerRunning()){
			startActivity(new Intent(this, WebServerActivity.class));
			finish();
			return;
		}
		if (!PermissionsActivity.arePermissionsGranted(this)) {
			startActivity(new Intent(this, PermissionsActivity.class));
			finish();
			return;
		}
	}

}
