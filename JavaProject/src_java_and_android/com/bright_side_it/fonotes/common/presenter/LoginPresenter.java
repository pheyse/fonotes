package com.bright_side_it.fonotes.common.presenter;

import java.util.List;

import com.bright_side_it.fonotes.common.base.Platform;

import generated.fliesenui.core.FLUIClientPropertiesDTO;
import generated.fliesenui.dto.OverviewParameterDTOBuilder;
import generated.fliesenui.screen.LoginListener;
import generated.fliesenui.screen.LoginReply;

public class LoginPresenter implements LoginListener {
	private String password;

	public LoginPresenter(Platform platform, String password){
		this.password = password;
	}

	@Override
	public void onLoaded(LoginReply reply, FLUIClientPropertiesDTO clientProperties) {
		if (password == null){
			reply.openScreenOverview(OverviewParameterDTOBuilder.construct(null));
		}
	}

	@Override
	public void onInputDialogResult(LoginReply reply, String referenceID, String dialogResult) {
	}

	@Override
	public void onConfirmDialogResult(LoginReply reply, String referenceID, boolean confirmed) {
	}

	@Override
	public void onLoginButtonClicked(LoginReply reply, String passwordTextFieldText) {
		if ((password == null) || (password.equals(passwordTextFieldText))){
			reply.openScreenOverview(OverviewParameterDTOBuilder.construct(passwordTextFieldText));
			return;
		}
		reply.setErrorDialog("Wrong password", "This password is not correct");
	}

	@Override
	public void onListChooserResult(LoginReply reply, String referenceID, List<String> selectedIDs) {
	}

}
