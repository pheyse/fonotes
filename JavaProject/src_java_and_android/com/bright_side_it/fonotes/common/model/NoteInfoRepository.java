package com.bright_side_it.fonotes.common.model;

import java.util.Map;

public class NoteInfoRepository {
	private Map<String, NoteInfo> noteInfos;

	public Map<String, NoteInfo> getNoteInfos() {
		return noteInfos;
	}

	public void setNoteInfos(Map<String, NoteInfo> noteInfos) {
		this.noteInfos = noteInfos;
	}
	
}
