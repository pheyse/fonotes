package com.bright_side_it.fonotes.common.presenter;

import java.util.List;

import generated.fliesenui.core.BrightMarkdown;
import generated.fliesenui.core.FLUIClientPropertiesDTO;
import generated.fliesenui.dto.OverviewParameterDTO;
import generated.fliesenui.screen.AboutListener;
import generated.fliesenui.screen.AboutReply;
import generated.fliesenui.screen.MarkdownHelpListener;
import generated.fliesenui.screen.MarkdownHelpReply;

public class MarkdownHelpPresenter implements MarkdownHelpListener {
	@Override
	public void onLoaded(MarkdownHelpReply reply, FLUIClientPropertiesDTO clientProperties, OverviewParameterDTO parameter) {
		reply.setMarkdownHelpTextText(new BrightMarkdown().getDocumentationAsMarkdown());
	}

	@Override
	public void onInputDialogResult(MarkdownHelpReply reply, String referenceID, String dialogResult) {
	}

	@Override
	public void onConfirmDialogResult(MarkdownHelpReply reply, String referenceID, boolean confirmed) {
	}

	@Override
	public void onListChooserResult(MarkdownHelpReply reply, String referenceID, List<String> selectedIDs) {
	}

	@Override
	public void onBackButtonClicked(MarkdownHelpReply reply, OverviewParameterDTO parameter) {
		reply.openScreenOverview(parameter);
	}

	@Override
	public void onBackPressed(MarkdownHelpReply reply, OverviewParameterDTO parameter) {
		reply.openScreenOverview(parameter);
	}
}
