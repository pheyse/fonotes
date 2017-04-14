package com.bright_side_it.fonotes.common.model;

import java.util.List;

public class Settings {
	public enum SortType{NAME_DESC, LAST_EDIT_TIME_DESC, LAST_EDIT_TIME_ASC, CREATION_TIME_DESC, CREATION_TIME_ASC, COLOR}
	private SortType sortType;
	private List<String> includedColorIDs;
	
	public SortType getSortType() {
		return sortType;
	}
	public void setSortType(SortType sortType) {
		this.sortType = sortType;
	}
	public List<String> getIncludedColorIDs() {
		return includedColorIDs;
	}
	public void setIncludedColorIDs(List<String> includedColorIDs) {
		this.includedColorIDs = includedColorIDs;
	}
	
}
