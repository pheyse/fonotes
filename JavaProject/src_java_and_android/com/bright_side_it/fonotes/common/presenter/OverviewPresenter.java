package com.bright_side_it.fonotes.common.presenter;

import generated.fliesenui.core.FLUIClientPropertiesDTO;
import generated.fliesenui.core.IDLabelList;
import generated.fliesenui.dto.DetailsParameterDTOBuilder;
import generated.fliesenui.dto.IdAndLabelDTO;
import generated.fliesenui.dto.OverviewItemDTO;
import generated.fliesenui.dto.OverviewItemDTOBuilder;
import generated.fliesenui.dto.OverviewListDTO;
import generated.fliesenui.dto.OverviewParameterDTO;
import generated.fliesenui.screen.OverviewListener;
import generated.fliesenui.screen.OverviewReply;

import java.util.ArrayList;
import java.util.List;

import com.bright_side_it.fonotes.common.base.Platform;
import com.bright_side_it.fonotes.common.dao.FonotesDAO;
import com.bright_side_it.fonotes.common.logic.ColorLogic;
import com.bright_side_it.fonotes.common.logic.NoteLogic;
import com.bright_side_it.fonotes.common.model.NoteInfo;
import com.bright_side_it.fonotes.common.model.NoteInfoRepository;
import com.bright_side_it.fonotes.common.model.Settings;
import com.bright_side_it.fonotes.common.model.Settings.SortType;
import com.google.gson.Gson;

public class OverviewPresenter implements OverviewListener{
	private static final String ID_ABOUT = "about";
	private static final String ID_MARKDOWN_HELP = "markdownHelp";
	private static final String ID_FILTER_COLOR = "fiterColor";
	private static final String ID_SORT = "sort";
	private static final String ID_START_WEB_SERVER = "startWebServer";
	private static final String ID_SEARCH_TITLE = "searchTitle";
	private static final String ID_CONVERT_OLD_COLORS = "convertOldColors";
	
	private enum ActionType{MENU, FILTER_COLORS, SORT_ORDER, SEARCH_NOTE}
	
	
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
			noteInfo.setColorID(ColorLogic.DEFAULT_COLOR_ID);
			noteInfo.setCreationTime(platform.getCurrentTimeMillis());
			noteInfo.setLastEditTime(noteInfo.getCreationTime());
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

	private void updateView(OverviewReply reply, Settings settings) {
		try{
			List<NoteInfo> noteInfos = dao.readNoteInfos();
			NoteLogic noteLogic = new NoteLogic();
			noteInfos = noteLogic.filterColors(noteInfos, settings.getIncludedColorIDs());
			noteInfos = noteLogic.sort(noteInfos, settings.getSortType());
			reply.setItemsDTO(toItemsDTO(noteInfos));
			
			reply.setSortInfoTextText(getSortInfoText(settings.getSortType()));
			if ((settings.getIncludedColorIDs() != null) && (!settings.getIncludedColorIDs().isEmpty())){
				reply.setColorFilterInfoTextText(getColorFilterText(settings.getIncludedColorIDs()));
				reply.setColorFilterInfoBarVisible(true);
			} else {
				reply.setColorFilterInfoBarVisible(false);
			}
		} catch (Exception e){
			commonPresenter.handleError(reply, "Could not read notes", e);
		}
	}

	private String getColorFilterText(List<String> includedColorIDs) {
		String result = "shown colors: ";
		ColorLogic colorLogic = new ColorLogic();
		boolean first = true;
		for (String colorID: includedColorIDs){
			if (first){
				first = false;
			} else {
				result += ", ";
			}
			result += colorLogic.getColorLabel(colorID);
		}
		return result;
	}

	private String getSortInfoText(SortType sortType) {
		String prefix = "sorted by: ";
		if ((sortType == null) || (sortType == SortType.NAME_DESC)){
			return prefix + "title";
		} else if (sortType == SortType.COLOR){
			return prefix + "color";
		} else if (sortType == SortType.CREATION_TIME_ASC){
			return prefix + "creation time";
		} else if (sortType == SortType.CREATION_TIME_DESC){
			return prefix + "creation time (descending)";
		} else if (sortType == SortType.LAST_EDIT_TIME_DESC){
			return prefix + "last edit time";
		} else if (sortType == SortType.LAST_EDIT_TIME_ASC){
			return prefix + "last edit time (ascending)";
		} else if (sortType == SortType.CREATION_TIME_DESC){
			return prefix + "last edit time (descending)";
		}
		return prefix + "?";
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
		Settings settings;
		try {
			settings = dao.readSettings();
		} catch (Exception e) {
			commonPresenter.handleError(reply, "Could not update settings", e);
			return;
		}

		updateView(reply, settings);
	}
	
	private OverviewListDTO toItemsDTO(List<NoteInfo> noteInfos) {
		OverviewListDTO result = new OverviewListDTO();
		List<OverviewItemDTO> items = new ArrayList<>();
		result.setItems(items);
		items.add(OverviewItemDTOBuilder.construct("", "+ Add note", "#ffffff"));
		ColorLogic colorLogic = new ColorLogic();
		for (NoteInfo i: noteInfos){
			String colorHex = "#" + colorLogic.getColorHexStrongFromColorID(i.getColorID());
			items.add(OverviewItemDTOBuilder.construct(i.getName(), "   " + i.getName(), colorHex));
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
	public void onListChooserResult(OverviewReply reply, String referenceID, List<String> selectedIDs) {
		if ((selectedIDs == null) || (referenceID == null)){
			return;
		}
		
		ListChooserReference reference = new Gson().fromJson(referenceID, ListChooserReference.class);
		if (!verifyParameterPassword(reply, reference.getParameter())){
			return;
		}
		ActionType action = ActionType.valueOf(reference.getAction());

		if (action == ActionType.MENU){
			if (selectedIDs.isEmpty()){
				return;
			}
			String selection = selectedIDs.get(0);
			if (ID_START_WEB_SERVER.equals(selection)){
				platform.startWebServer();
			} else if (ID_ABOUT.equals(selection)){
				reply.openScreenAbout(reference.getParameter());
			} else if (ID_MARKDOWN_HELP.equals(selection)){
				reply.openScreenMarkdownHelp(reference.getParameter());
			} else if (ID_FILTER_COLOR.equals(selection)){
				showChooseColorFilter(reply, reference.getParameter());
			} else if (ID_SEARCH_TITLE.equals(selection)){
				showSearchTitle(reply, reference.getParameter());
			} else if (ID_SORT.equals(selection)){
				showSortOptions(reply, reference.getParameter());
			} else if (ID_CONVERT_OLD_COLORS.equals(selection)){
				convertOldColorsToNew(reply, reference.getParameter());
			}
		} else if (action == ActionType.FILTER_COLORS){
			Settings settings;
			try {
				settings = dao.readSettings();
				if ((selectedIDs.isEmpty()) || (selectedIDs.size() == ColorLogic.NUMBER_OF_COLORS)){
					settings.setIncludedColorIDs(null);
				} else {
					settings.setIncludedColorIDs(selectedIDs);
				}
				dao.writeSettings(settings);
			} catch (Exception e) {
				commonPresenter.handleError(reply, "Could not update settings", e);
				return;
			}

			updateView(reply, settings);
		} else if (action == ActionType.SORT_ORDER){
			if ((selectedIDs == null) || (selectedIDs.size() != 1)){
				return;
			}
			Settings settings;
			try {
				settings = dao.readSettings();
				settings.setSortType(SortType.valueOf(selectedIDs.get(0)));
				dao.writeSettings(settings);
			} catch (Exception e) {
				commonPresenter.handleError(reply, "Could not update settings", e);
				return;
			}

			updateView(reply, settings);
		} else if (action == ActionType.SEARCH_NOTE){
			if ((selectedIDs == null) || (selectedIDs.size() != 1)){
				return;
			}
			openNote(reply, selectedIDs.get(0), reference.getParameter().getPassword());
		} else {
			commonPresenter.handleError(reply, "Unknwon action: " + action, new Exception());
		}
	}

	private void convertOldColorsToNew(OverviewReply reply, OverviewParameterDTO parameter) {
		try{
			dao.convertOldColorsToNew();
			updateView(reply, dao.readSettings());
		} catch (Exception e) {
			commonPresenter.handleError(reply, "Could not convert old colors to new", e);
			return;
		}
	}

	private void showSearchTitle(OverviewReply reply, OverviewParameterDTO parameter) {
		IDLabelList items = new IDLabelList();

		List<NoteInfo> notesList;
		try{
			NoteInfoRepository notesRepository;
			notesRepository = dao.readNoteInfoRepository();
			notesList = new ArrayList<NoteInfo>(notesRepository.getNoteInfos().values()); 
			notesList = new NoteLogic().sort(notesList, SortType.NAME_DESC);
		} catch (Exception e) {
			commonPresenter.handleError(reply, "Could not read and sort notes", e);
			return;
		}
		
		for (NoteInfo i: notesList){
			items.addItem(i.getName(), i.getName());
		}
		
		ListChooserReference reference = new ListChooserReference();
		reference.setAction(ActionType.SEARCH_NOTE.toString());
		reference.setParameter(parameter);
		reply.showListChooser(new Gson().toJson(reference), false, true, "Search notes", items, null);
	}

	private void showSortOptions(OverviewReply reply, OverviewParameterDTO parameter) {
		IDLabelList items = new IDLabelList();
		
		items.addItem(SortType.NAME_DESC.toString(), "Name");
		items.addItem(SortType.COLOR.toString(), "Color");
		items.addItem(SortType.LAST_EDIT_TIME_DESC.toString(), "Edit time");
		items.addItem(SortType.LAST_EDIT_TIME_ASC.toString(), "Edit time (earliest first)");
		items.addItem(SortType.CREATION_TIME_ASC.toString(), "Creation time (earliest first)");
		items.addItem(SortType.CREATION_TIME_DESC.toString(), "Creation time (latest first)");
		
		ListChooserReference reference = new ListChooserReference();
		reference.setAction(ActionType.SORT_ORDER.toString());
		reference.setParameter(parameter);
		reply.showListChooser(new Gson().toJson(reference), false, false, "Menu", items, null);
	}

	private void showChooseColorFilter(OverviewReply reply, OverviewParameterDTO parameter) {
		IDLabelList items = new IDLabelList();
		for (IdAndLabelDTO i: new ColorLogic().getColorIDsAndLabels()){
			items.addItem(i.getId(), i.getLabel());
		}
		
		ListChooserReference reference = new ListChooserReference();
		reference.setAction(ActionType.FILTER_COLORS.toString());
		reference.setParameter(parameter);
		
		Settings settings;
		try {
			settings = dao.readSettings();
		} catch (Exception e) {
			commonPresenter.handleError(reply, "Could not read settings", e);
			return;
		}
		
		reply.showListChooser(new Gson().toJson(reference), true, false, "Select displayed colors", items, settings.getIncludedColorIDs());
	}

	@Override
	public void onMenuButtonClicked(OverviewReply reply, OverviewParameterDTO parameter) {
		IDLabelList items = new IDLabelList();
		items.addItem(ID_FILTER_COLOR, "Filter Color");
		items.addItem(ID_SORT, "Sort");
		items.addItem(ID_SEARCH_TITLE, "Search title");
		if (androidApp){
			items.addItem(ID_START_WEB_SERVER, "Start Web Server");
		}
		items.addItem(ID_CONVERT_OLD_COLORS, "Special: Convert old colors to new");
		items.addItem(ID_MARKDOWN_HELP, "Markdown help");
		items.addItem(ID_ABOUT, "About");

		ListChooserReference reference = new ListChooserReference();
		reference.setAction(ActionType.MENU.toString());
		reference.setParameter(parameter);
		reply.showListChooser(new Gson().toJson(reference), false, false, "Menu", items, null);
	}

	private class ListChooserReference{
		String action;
		OverviewParameterDTO parameter;
		
		public String getAction() {
			return action;
		}
		public void setAction(String action) {
			this.action = action;
		}
		public OverviewParameterDTO getParameter() {
			return parameter;
		}
		public void setParameter(OverviewParameterDTO parameter) {
			this.parameter = parameter;
		}
	}

}
