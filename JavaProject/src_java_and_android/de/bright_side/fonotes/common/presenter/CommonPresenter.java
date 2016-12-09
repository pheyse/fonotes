package de.bright_side.fonotes.common.presenter;

import de.bright_side.fonotes.common.base.Platform;
import generated.fliesenui.screen.CommonSharedReply;

public class CommonPresenter {

	private Platform platform;

	public CommonPresenter(Platform platform) {
		this.platform = platform;
	}

	public void handleError(CommonSharedReply reply, String message, Exception e) {
		reply.setErrorDialog("Error", message);
		platform.handleError(e);
	}

}
