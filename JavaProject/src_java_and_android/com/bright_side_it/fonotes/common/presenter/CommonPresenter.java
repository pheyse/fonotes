package com.bright_side_it.fonotes.common.presenter;

import com.bright_side_it.fonotes.common.base.Platform;

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
