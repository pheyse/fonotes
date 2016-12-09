package de.bright_side.fonotes.android.base;

import android.content.Context;

import de.bright_side.fonotes.common.base.FonotesBase;
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
