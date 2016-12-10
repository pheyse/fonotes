package com.bright_side_it.fonotes.android.base;

import android.content.Context;

import com.bright_side_it.fonotes.common.base.FonotesBase;

import generated.fliesenui.core.FLUIScreenManagerAndroid;

/**
 * Created by me on 08.12.2016.
 */

public class FonotesAndroidBase {
	public static FLUIScreenManagerAndroid createScreenManager(Context context, String password, boolean androidApp) {
		FLUIScreenManagerAndroid screenManager = FLUIScreenManagerAndroid.createSimpleInstance(context);
		AndroidPlatform platform = new AndroidPlatform(context);
		FonotesBase.setAllPresenters(screenManager, platform, password, androidApp);
		return screenManager;
	}

}
