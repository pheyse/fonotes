package com.bright_side_it.fonotes.android.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import com.bright_side_it.fonotes.android.base.AndroidPlatform;
import com.bright_side_it.fonotes.android.base.FonotesAndroidBase;
import com.bright_side_it.fonotes.android.service.WebServerService;

import generated.fliesenui.core.FLUIAndroidDisplayActivity;
import generated.fliesenui.core.FLUIScreenManagerAndroid;

public class MainActivity extends FLUIAndroidDisplayActivity {
	private AndroidPlatform platform = new AndroidPlatform(this);

	@Override
	protected void fluiOnCreate(Bundle savedInstanceState) {
	}

	@Override
	protected FLUIScreenManagerAndroid fluiCreateScreenManager() {
		return FonotesAndroidBase.createScreenManager(this, platform, null, true);
	}

	@Override
	protected void fluiOnResume() throws Throwable{
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
	}

	@Override
	protected void fluiOnError(Throwable throwable) {
		Log.e("Fonotes", "Error: " + throwable, throwable);
		if (platform != null){
			platform.handleError(new Exception("General error occured in main activity", throwable));
		}
	}

}
