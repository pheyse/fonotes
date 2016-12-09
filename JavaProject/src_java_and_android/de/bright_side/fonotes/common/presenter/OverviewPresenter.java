package de.bright_side.fonotes.common.presenter;

import java.util.ArrayList;
import java.util.List;

import de.bright_side.fonotes.common.base.Platform;
import de.bright_side.fonotes.common.dao.FonotesDAO;
import de.bright_side.fonotes.common.logic.ColorLogic;
import de.bright_side.fonotes.common.model.NoteInfo;
import generated.fliesenui.core.FLUIClientPropertiesDTO;
import generated.fliesenui.dto.DetailsParameterDTOBuilder;
import generated.fliesenui.dto.OverviewItemDTO;
import generated.fliesenui.dto.OverviewItemDTOBuilder;
import generated.fliesenui.dto.OverviewListDTO;
import generated.fliesenui.dto.OverviewParameterDTO;
import generated.fliesenui.screen.OverviewListener;
import generated.fliesenui.screen.OverviewReply;

public class OverviewPresenter implements OverviewListener{
	private FonotesDAO dao;
	private String password;
	private CommonPresenter commonPresenter;
	private Platform platform;
	private boolean androidApp;
	
	public OverviewPresenter(Platform platform, String password, boolean androidApp){
		this.platform = platform;
		this.password = password;
		this.androidApp = androidApp;
		commonPresenter = new CommonPresenter(platform);
		dao = new FonotesDAO(platform);
	}

	@Override
	public void onInputDialogResult(OverviewReply reply, String referenceID, String dialogResult) {
		if ((dialogResult == null) || (dialogResult.isEmpty())){
			return;
		}
		if (!verifyPassword(reply, referenceID)){
			return;
		}
		String newNoteName = dialogResult.trim();
		try{
			if (dao.doesNoteExist(newNoteName)){
				reply.showInputDialog(referenceID, "New Note", "A note with the name '" + dialogResult + "' already exists. Please choose a different name", "name", newNoteName, "Create", "Cancel");
				return;
			}
		} catch (Exception e){
			commonPresenter.handleError(reply, "Could not check if note exists", e);
			return;
		}
		if (dialogResult.trim().isEmpty()){
			reply.showInputDialog(referenceID, "New Note", "The note name may not be empty. Please choose a different name", "name", "My note", "Create", "Cancel");			
			return;
		}
		if (dialogResult.contains("\n") || dialogResult.contains("\r") || dialogResult.contains("\t")){
			reply.showInputDialog(referenceID, "New Note", "The note name may not contains new lines or tabs. Please choose a different name", "name", newNoteName, "Create", "Cancel");			
			return;
		}
		try{
			NoteInfo noteInfo = new NoteInfo();
			noteInfo.setName(dialogResult);
			noteInfo.setColor(ColorLogic.DEFAULT_COLOR);
			dao.createNewNote(noteInfo, "");
			openNote(reply, noteInfo.getName(), referenceID);
		} catch (Exception e){
			commonPresenter.handleError(reply, "Could not create note", e);
			return;
		}
	}

	private void openNote(OverviewReply reply, String noteName, String password) {
		reply.openScreenDetails(DetailsParameterDTOBuilder.construct(noteName, password));
	}

	private void updateView(OverviewReply reply) {
		try{
			reply.setItemsDTO(toItemsDTO(dao.readNoteInfos()));
		} catch (Exception e){
			commonPresenter.handleError(reply, "Could not read notes", e);
		}
	}

	@Override
	public void onConfirmDialogResult(OverviewReply reply, String referenceID, boolean confirmed) {
	}

	@Override
	public void onNotesTableRowClicked(OverviewReply reply, String rowID, OverviewParameterDTO parameter) {
		if (!verifyParameterPassword(reply, parameter)){
			return;
		}
		if ((rowID == null) || (rowID.isEmpty())){
			newNote(reply, parameter);
			return;
		}
		openNote(reply, rowID, parameter.getPassword());
	}

	private void newNote(OverviewReply reply, OverviewParameterDTO parameter) {
		reply.showInputDialog(parameter.getPassword(), "New Note", "", "name", "My note", "Create", "Cancel");		
	}

	@Override
	public void onLoaded(OverviewReply reply, FLUIClientPropertiesDTO clientProperties, OverviewParameterDTO parameter) {
		if (!verifyParameterPassword(reply, parameter)){
			return;
		}
		if (androidApp){
			reply.setStartWebServerButtonVisible(true);
		}
		updateView(reply);
	}
	
	private OverviewListDTO toItemsDTO(List<NoteInfo> noteInfos) {
		OverviewListDTO result = new OverviewListDTO();
		List<OverviewItemDTO> items = new ArrayList<>();
		result.setItems(items);
		items.add(OverviewItemDTOBuilder.construct("", "+ Add note", "#ffffff"));
		for (NoteInfo i: noteInfos){
			items.add(OverviewItemDTOBuilder.construct(i.getName(), "   " + i.getName(), "#" + i.getColor()));
		}
		if (noteInfos.size() > 4){
			items.add(OverviewItemDTOBuilder.construct("", "+ Add note", "#ffffff"));
		}
		return result;
	}

	private boolean verifyParameterPassword(OverviewReply reply, OverviewParameterDTO parameter){
		if (password == null){
			return true;
		}
		if ((parameter != null) && (parameter.getPassword() == null)){
			platform.log("Required password = >>" + password + "<<, givenPassword = >>" + parameter.getPassword() + "<<");
		} else {
			platform.log("Required password = >>" + password + "<< but no given password");
		}
		if ((parameter == null) || (parameter.getPassword() == null) || (!parameter.getPassword().equals(password))){
			reply.openScreenLogin();
			return false;
		}
		return true;
	}
	
	private boolean verifyPassword(OverviewReply reply, String givenPassword){
		if (password == null){
			return true;
		}
		platform.log("Required password = >>" + password + "<<, givenPassword = >>" + givenPassword + "<<");
		if ((givenPassword == null) || (!givenPassword.equals(password))){
			reply.openScreenLogin();
			return false;
		}
		return true;
	}

	@Override
	public void onStartWebServerButtonClicked(OverviewReply reply) {
		platform.startWebServer();
	}

	@Override
	public void onAboutButtonClicked(OverviewReply reply, OverviewParameterDTO parameter) {
		reply.openScreenAbout(parameter);
	}
	

}
