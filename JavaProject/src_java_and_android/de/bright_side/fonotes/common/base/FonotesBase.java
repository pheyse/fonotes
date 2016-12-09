package de.bright_side.fonotes.common.base;

import de.bright_side.fonotes.common.presenter.AboutPresenter;
import de.bright_side.fonotes.common.presenter.DetailsPresenter;
import de.bright_side.fonotes.common.presenter.LoginPresenter;
import de.bright_side.fonotes.common.presenter.OverviewPresenter;
import generated.fliesenui.core.FLUIScreenManagerInterface;

public class FonotesBase {
	public static void setAllPresenters(FLUIScreenManagerInterface screenManager, Platform platform, String password, boolean androidApp){
		screenManager.setLoginPresenter(new LoginPresenter(platform, password));
		screenManager.setOverviewPresenter(new OverviewPresenter(platform, password, androidApp));
		screenManager.setDetailsPresenter(new DetailsPresenter(platform, password));
		screenManager.setAboutPresenter(new AboutPresenter());
	}
}
