package com.bright_side_it.fonotes.common.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.bright_side_it.fonotes.common.model.NoteInfo;
import com.bright_side_it.fonotes.common.model.Settings.SortType;

public class NoteLogic {

	public List<NoteInfo> filterColors(List<NoteInfo> noteInfos, List<String> includedColorIDs) {
		if ((includedColorIDs == null) || (includedColorIDs.isEmpty())){
			return noteInfos;
		}
		Set<String> colorIDsSet = new HashSet<String>(includedColorIDs);
		List<NoteInfo> result = new ArrayList<NoteInfo>();
		for (NoteInfo i: noteInfos){
			if (colorIDsSet.contains(i.getColorID())){
				result.add(i);
			}
		}
		
		return result;
	}
	
	private class SortableNote implements Comparable<SortableNote>{
		private NoteInfo noteInfo;
		private String sortValue;

		@Override
		public int compareTo(SortableNote other) {
			if (other == null){
				return 1;
			}
			if (sortValue == null){
				if (other.sortValue == null){
					return 0;
				} else {
					return -1;
				}
			}
			return sortValue.compareTo(other.sortValue);
		}
	}

	public List<NoteInfo> sort(List<NoteInfo> noteInfos, SortType sortType) throws Exception{
		List<SortableNote> sortableNotes = new ArrayList<SortableNote>();
		
		for (NoteInfo i: noteInfos){
			SortableNote sortableNote = new SortableNote();
			sortableNote.noteInfo = i;
			if ((sortType == null) || (sortType == SortType.NAME_DESC)){
				sortableNote.sortValue = i.getName();
			} else if (sortType == SortType.COLOR){
				sortableNote.sortValue = i.getColorID();
			} else if (sortType == SortType.CREATION_TIME_ASC){
				sortableNote.sortValue = String.format("%020d", i.getCreationTime());
			} else if (sortType == SortType.CREATION_TIME_DESC){
				sortableNote.sortValue = String.format("%020d", Long.MAX_VALUE - i.getCreationTime());
			} else if (sortType == SortType.LAST_EDIT_TIME_ASC){
				sortableNote.sortValue = String.format("%020d", i.getLastEditTime());
			} else if (sortType == SortType.LAST_EDIT_TIME_DESC){
				sortableNote.sortValue = String.format("%020d", Long.MAX_VALUE - i.getLastEditTime());
			} else {
				throw new Exception("Unknown sort type: " + i);
			}
			sortableNotes.add(sortableNote);
		}
		
		Collections.sort(sortableNotes);
		List<NoteInfo> result = new ArrayList<NoteInfo>();
		for (SortableNote i: sortableNotes){
			result.add(i.noteInfo);
		}
		
		return result;
	}
	
}
