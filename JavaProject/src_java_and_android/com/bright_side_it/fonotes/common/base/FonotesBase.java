package com.bright_side_it.fonotes.common.base;

import com.bright_side_it.fonotes.common.presenter.AboutPresenter;
import com.bright_side_it.fonotes.common.presenter.DetailsPresenter;
import com.bright_side_it.fonotes.common.presenter.LoginPresenter;
import com.bright_side_it.fonotes.common.presenter.OverviewPresenter;

import generated.fliesenui.core.FLUIScreenManagerInterface;

public class FonotesBase {
	public static void setAllPresenters(FLUIScreenManagerInterface screenManager, Platform platform, String password, boolean androidApp){
		screenManager.setLoginPresenter(new LoginPresenter(platform, password));
		screenManager.setOverviewPresenter(new OverviewPresenter(platform, password, androidApp));
		screenManager.setDetailsPresenter(new DetailsPresenter(platform, password));
		screenManager.setAboutPresenter(new AboutPresenter());
	}
}
