package com.bright_side_it.fonotes.common.presenter;

import java.sql.Savepoint;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


import com.bright_side_it.fonotes.common.base.Platform;
import com.bright_side_it.fonotes.common.base.TextAndCursorPos;
import com.bright_side_it.fonotes.common.base.TextUtil;
import com.bright_side_it.fonotes.common.dao.FonotesDAO;
import com.bright_side_it.fonotes.common.logic.ColorLogic;
import com.bright_side_it.fonotes.common.model.NoteInfo;

import generated.fliesenui.core.BrightMarkdown;
import generated.fliesenui.core.FLUIClientPropertiesDTO;
import generated.fliesenui.core.FLUIKeyEvent;
import generated.fliesenui.core.FLUIKeyEvent.KeyType;
import generated.fliesenui.core.FLUIMarkdownFormatting;
import generated.fliesenui.core.FLUIUtil;
import generated.fliesenui.core.KeyModifier;
import generated.fliesenui.core.TextHighlighting;
import generated.fliesenui.dto.DetailsParameterDTO;
import generated.fliesenui.dto.DetailsParameterDTOBuilder;
import generated.fliesenui.dto.EditStateDTO;
import generated.fliesenui.dto.EditStateDTOBuilder;
import generated.fliesenui.dto.IdAndLabelListDTOBuilder;
import generated.fliesenui.dto.OverviewParameterDTOBuilder;
import generated.fliesenui.screen.DetailsListener;
import generated.fliesenui.screen.DetailsReply;

/*
  text area to do:
	  
	  set background color
	  XML:
	     -  pass parameter (in general and) on save 
	     OK set height --> put a scroll area around it (maybe just use logic of IDE...)
	     OK disable syntax highlighting
	     OK show/hide line numbers
 */

public class DetailsPresenter implements DetailsListener{
	private FonotesDAO dao;
	private String password;
	private ColorLogic colorLogic = new ColorLogic();
	private CommonPresenter commonPresenter;
	
	public DetailsPresenter(Platform platform, String password){
		this.password = password;
		commonPresenter = new CommonPresenter(platform);
		dao = new FonotesDAO(platform);
	}

	@Override
	public void onLoaded(DetailsReply reply, FLUIClientPropertiesDTO clientProperties, DetailsParameterDTO parameter) {
		if (!verifyParameterPassword(reply, parameter)){
			return;
		}
		NoteInfo noteInfo;
		String content;
		String autoSaveText = null;
		try {
			noteInfo = dao.readNoteInfoOptional(parameter.getNoteName());
			content = dao.readNoteContent(parameter.getNoteName());
			autoSaveText = dao.getAutoSaveText(parameter.getNoteName());
		} catch (Exception e) {
			commonPresenter.handleError(reply, "Could not read note with name '" + parameter.getNoteName() + "'", e);
			return;
		}
		
		reply.setButtonBarVisible(true);
		reply.setColorBarVisible(true);
		reply.setBackButtonVisible(true);
		reply.setColorsDTO(IdAndLabelListDTOBuilder.construct(colorLogic.getColorIDsAndLabels()));
		reply.setNoteNameLabelText(noteInfo.getName());
		reply.setColorSelectBoxSelectedID(noteInfo.getColorID());
		setNoteViewText(reply, content);
		reply.setEditStateDTO(EditStateDTOBuilder.construct(content, false));
		reply.setNoteViewBackgroundColor("#" + colorLogic.getColorHexSoftFromColorID(noteInfo.getColorID()));
//		reply.setEditNoteTextAreaBackgroundColor("#" + colorLogic.getColorHexSoftFromColorID(noteInfo.getColorID()));
		if ((autoSaveText != null) && (!autoSaveText.isEmpty())){
			startEdit(reply, parameter, autoSaveText);
			reply.setEditNoteInfoLabelText("Auto-saved text recovered");
		} else if (content.isEmpty()){
			//: open the edit window, because there is nothing to "view" anyway
			onEditTextButtonClicked(reply, parameter);
		}
	}

    private void setNoteViewText(DetailsReply reply, String text){
	    if (text == null){
            reply.setNoteViewText("");
	        return;
        }
        try{
            int deepestHeading = new BrightMarkdown().getDeepestHeading(text);
            FLUIMarkdownFormatting formatting = new FLUIMarkdownFormatting();
            Map<Integer, Integer> fontSizesMap = new TreeMap<>();
            formatting.setHeadingLevelToFontSizeInMM(fontSizesMap);
            int fontSize = 4;
            for (int i = deepestHeading; i >= 0; i --){
                fontSizesMap.put(i, fontSize);
                fontSize = (int)Math.max(fontSize * 1.2, fontSize + 2);
            }
            reply.setNoteViewText(text, formatting);
        } catch (Exception e){
            commonPresenter.handleError(reply, "Could not read markdown text", e);
            return;
        }


    }

    @Override
	public void onInputDialogResult(DetailsReply reply, String referenceID, String dialogResult) {
		if ((dialogResult == null) || (dialogResult.isEmpty())){
			return;
		}
		String[] items = referenceID.split("\n");
		if (items.length != 2){
			reply.setErrorDialog("Unecpected data", "Unecpected data");
			return;
		}
		String password = items[0];
		String noteName = items[1];
		if (dialogResult.equals(noteName)){
			return;
		}
		if (!verifyPassword(reply, password)){
			return;
		}
		if ((dialogResult == null) || (dialogResult.trim().isEmpty())){
			reply.showInputDialog(password + "\n" + noteName, "Rename note", "The note name may not be empty", "Name", noteName, "Rename", "Cancel");
			return;
		}
		if (dialogResult.contains("\n") || dialogResult.contains("\r") || dialogResult.contains("\t")){
			reply.showInputDialog(password + "\n" + noteName, "Rename note", "The note name may not contain line breaks or tabs", "Name", noteName, "Rename", "Cancel");
			return;
		}
		String newNoteName = dialogResult.trim();
		try{
			if (dao.doesNoteExist(newNoteName)){
				reply.showInputDialog(password + "\n" + noteName, "Rename note", "There already is another note with this name", "Name", newNoteName, "Rename", "Cancel");
				return;
			}
		} catch (Exception e){
			commonPresenter.handleError(reply, "Could not check if note exists", e);
			return;
		}
		
		try{
			dao.setNoteName(noteName, newNoteName);
		} catch (Exception e){
			commonPresenter.handleError(reply, "Could not rename note", e);
			return;
		}
		reply.setParameterDTO(DetailsParameterDTOBuilder.construct(newNoteName, password));
		reply.setNoteNameLabelText(dialogResult.trim());
	}

	private boolean verifyParameterPassword(DetailsReply reply, DetailsParameterDTO parameter){
		if (password == null){
			return true;
		}
		if ((parameter == null) || (parameter.getPassword() == null) || (!parameter.getPassword().equals(password))){
			reply.openScreenLogin();
			return false;
		}
		return true;
	}
	
	private boolean verifyPassword(DetailsReply reply, String givenPassword){
		if (password == null){
			return true;
		}
		if ((givenPassword == null) || (!givenPassword.equals(password))){
			reply.openScreenLogin();
			return false;
		}
		return true;
	}


	@Override
	public void onEditNameButtonClicked(DetailsReply reply, DetailsParameterDTO parameter) {
		if (!verifyParameterPassword(reply, parameter)){
			return;
		}
		reply.showInputDialog(parameter.getPassword() + "\n" + parameter.getNoteName(), "Rename note", "Set new note name", "Name", parameter.getNoteName(), "Rename", "Cancel");
	}
	
	private void startEdit(DetailsReply reply, DetailsParameterDTO parameter, String initialText){
		reply.setAutosaveTimerActive(true);
		reply.setEditStateDTO(EditStateDTOBuilder.construct(initialText, true));
		reply.setEditNotePanelVisible(true);
		reply.setViewNotePanelVisible(false);
		reply.setButtonBarVisible(false);
		reply.setColorBarVisible(false);
		reply.setBackButtonVisible(false);
		reply.setEditNoteTextAreaText(initialText);
	}

	@Override
	public void onEditTextButtonClicked(DetailsReply reply, DetailsParameterDTO parameter) {
		if (!verifyParameterPassword(reply, parameter)){
			return;
		}
		String content;
		try{
			content = dao.readNoteContent(parameter.getNoteName());
		} catch (Exception e){
			commonPresenter.handleError(reply, "Could not read not content", e);
			return;
		}
		reply.setEditNoteInfoLabelText(" ");
		startEdit(reply, parameter, content);
	}
	
	@Override
	public void onCancelEditNoteTextButtonClicked(DetailsReply reply, DetailsParameterDTO parameter) {
		if (!verifyParameterPassword(reply, parameter)){
			return;
		}
		reply.setEditNotePanelVisible(false);
		reply.setEditStateDTO(EditStateDTOBuilder.construct("", false));
		reply.setAutosaveTimerActive(false);
		reply.setViewNotePanelVisible(true);
		reply.setButtonBarVisible(true);
		reply.setColorBarVisible(true);
		reply.setBackButtonVisible(true);

		try {
			dao.removeAutoSaveText(parameter.getNoteName());
		} catch (Exception e) {
			commonPresenter.handleError(reply, "Could remove auto-save text", e);
			return;
		}
	}

	@Override
	public void onColorSelectBoxChanged(DetailsReply reply, String itemID, DetailsParameterDTO parameter) {
		if (!verifyParameterPassword(reply, parameter)){
			return;
		}
		if ((itemID == null) || (itemID.isEmpty())){
			return;
		}
		try{
			dao.setNoteColorID(parameter.getNoteName(), itemID);
		} catch (Exception e){
			commonPresenter.handleError(reply, "Could not update note color", e);
			return;
		}
		
		reply.setNoteViewBackgroundColor("#" + new ColorLogic().getColorHexSoftFromColorID(itemID));
//		reply.setEditNoteTextAreaBackgroundColor("#" + new ColorLogic().getColorHexSoftFromColorID(itemID));
	}
	
	@Override
	public void onDeleteButtonClicked(DetailsReply reply, DetailsParameterDTO parameter) {
		if (!verifyParameterPassword(reply, parameter)){
			return;
		}
		reply.showConfirmDialog(parameter.getPassword() + "\n" + parameter.getNoteName(), "Delete note", "Do you really want to delete this note?", "Delete", "Cancel");
	}

	@Override
	public void onConfirmDialogResult(DetailsReply reply, String referenceID, boolean confirmed) {
		if (!confirmed){
			return;
		}
		String[] items = referenceID.split("\n");
		if (items.length != 2){
			reply.setErrorDialog("Unecpected data", "Unecpected data");
			return;
		}
		String password = items[0];
		String noteName = items[1];
		if (!verifyPassword(reply, password)){
			return;
		}
		
		try{
			dao.deleteNote(noteName);
		} catch (Exception e){
			commonPresenter.handleError(reply, "Could not delete note", e);
			return;
		}
		reply.openScreenOverview(OverviewParameterDTOBuilder.construct(password));
	}

	@Override
	public void onSaveNoteTextButtonClicked(DetailsReply reply, DetailsParameterDTO parameter, String editNoteTextAreaText){
		if (!verifyParameterPassword(reply, parameter)){
			return;
		}
		String content = editNoteTextAreaText;
		try{
			dao.setNoteContent(parameter.getNoteName(), content);
			dao.removeAutoSaveText(parameter.getNoteName());
		} catch (Exception e){
			commonPresenter.handleError(reply, "Could not update note text", e);
			return;
		}
		reply.setEditStateDTO(EditStateDTOBuilder.construct(content, false));
		reply.setAutosaveTimerActive(false);
		setNoteViewText(reply, editNoteTextAreaText);
		reply.setEditNotePanelVisible(false);
		reply.setViewNotePanelVisible(true);
		reply.setButtonBarVisible(true);
		reply.setColorBarVisible(true);
		reply.setBackButtonVisible(true);
	}

	@Override
	public void onBackButtonClicked(DetailsReply reply, DetailsParameterDTO parameter) {
		if (!verifyParameterPassword(reply, parameter)){
			return;
		}
		reply.openScreenOverview(OverviewParameterDTOBuilder.construct(parameter.getPassword()));
	}

	@Override
	public void onAutosaveTimer(DetailsReply reply, DetailsParameterDTO parameter, String editNoteTextAreaText, EditStateDTO editState) {
		log("onAutosaveTimer");
		if (!verifyParameterPassword(reply, parameter)){
			return;
		}
		if (editNoteTextAreaText.equals(editState.getText())){
//			log("aute save not necessary");
			return;
		}
		try{
			dao.setAutoSaveText(parameter.getNoteName(), editNoteTextAreaText);
//			log("auto save text written");
		} catch (Exception e){
			commonPresenter.handleError(reply, "Could not set auto save text", e);
			return;
		}
		reply.setEditNoteInfoLabelText("Auto-saved: " + new Date());
		reply.setEditStateDTO(EditStateDTOBuilder.construct(editNoteTextAreaText, editState.getInEditMode()));
	}

	private void log(String message) {
		System.out.println("DetailsPresenter> " + message);
	}

	@Override
	public void onListChooserResult(DetailsReply reply, String referenceID, List<String> selectedIDs) {
	}

	@Override
	public void onBackPressed(DetailsReply reply, DetailsParameterDTO parameter) {
		onBackButtonClicked(reply, parameter);
	}

	/*
	@Override
	public void onEditNoteTextAreaKeyEvent(DetailsReply reply, FLUIKeyEvent keyEvent, DetailsParameterDTO parameter) {
		log("onEditNoteTextAreaKeyEvent>event = '" + keyEvent);
	
		TextAndCursorPos result = null;
		TextAndCursorPos textAndCursorPos = new TextAndCursorPos(keyEvent.getEditorText(), keyEvent.getLine(), keyEvent.getPosInLine());
		if (FLUIUtil.matchesKeyEvent(keyEvent, 'D', true, true, false)){
			log("onEditNoteTextAreaKeyEvent>event = copy line");
			result = TextUtil.copyLineDown(textAndCursorPos);
		} else if (FLUIUtil.matchesKeyEvent(keyEvent, KeyType.CURSOR_DOWN, true, false, true)){
			log("onEditNoteTextAreaKeyEvent>event = copy line down");
			result = TextUtil.copyLineDown(textAndCursorPos);
		} else if (FLUIUtil.matchesKeyEvent(keyEvent, KeyType.CURSOR_UP, true, false, true)){
			log("onEditNoteTextAreaKeyEvent>event = copy line up");
			result = TextUtil.copyLineUp(textAndCursorPos);
		} else if (FLUIUtil.matchesKeyEvent(keyEvent, KeyType.CURSOR_DOWN, false, false, true)){
			log("onEditNoteTextAreaKeyEvent>event = move line down");
			result = TextUtil.moveLineDown(textAndCursorPos);
		} else if (FLUIUtil.matchesKeyEvent(keyEvent, KeyType.CURSOR_UP, false, false, true)){
			log("onEditNoteTextAreaKeyEvent>event = move line up");
			result = TextUtil.moveLineUp(textAndCursorPos);
		} else if (FLUIUtil.matchesKeyEvent(keyEvent, 'S', true, false, false)){
			log("onEditNoteTextAreaKeyEvent>event = save");
			onSaveNoteTextButtonClicked(reply, parameter, keyEvent.getEditorText());
		}
		if (result != null){
			reply.setEditNoteTextAreaText(result.getText());
			reply.setEditNoteTextAreaCursorPos(result.getLine(), result.getPosInLine());
		}
	}
	*/
	
}
