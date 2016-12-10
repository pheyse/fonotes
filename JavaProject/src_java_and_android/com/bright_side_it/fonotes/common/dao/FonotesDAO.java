package com.bright_side_it.fonotes.common.dao;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import com.bright_side_it.fonotes.common.base.FileUtil;
import com.bright_side_it.fonotes.common.base.Platform;
import com.bright_side_it.fonotes.common.logic.DirNamesLogic;
import com.bright_side_it.fonotes.common.model.NoteInfo;

public class FonotesDAO {
	private static final SimpleDateFormat HISTORY_TIME_FORMAT = new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss");
	private Platform platform;

	public FonotesDAO(Platform platform){
		this.platform = platform;
	}
	
	private File makeSureItExists(File dir) throws Exception{
		if (!dir.exists()){
			dir.mkdirs();
		}
		if (!dir.exists()){
			throw new Exception("Directory '" + dir.getAbsolutePath() + "' does not exist and could not be created");
		}
		return dir;
	}
	
	private File getNotesDir() throws Exception{
		return makeSureItExists(new File(platform.getApplicationDataDir(), "notes"));
	}
	
	private File getContentFile(File noteDir) {
		return new File(noteDir, "content.txt");
	}
	
	private File getAutoSaveFile(File noteDir) {
		return new File(noteDir, "autosave.txt");
	}
	
	public File findNoteDirByNoteNameOptional(String noteName) throws Exception {
		DirNamesLogic dirNamesLogic = new DirNamesLogic();
		File dir = getNotesDir();
		for (File i: dir.listFiles()){
			NoteInfo noteInfo = dirNamesLogic.toNoteInfo(i.getName());
			if (noteInfo.getName().equals(noteName)){
				return i;
			}
		}
		return null;
	}
	
	public File findNoteDirByNoteNameRequired(String noteName) throws Exception {
		File result = findNoteDirByNoteNameOptional(noteName);
		if (result == null){
			throw new Exception("Could not find note directory for note with name '" + noteName + "'");
		}
		return result;
	}
	
	public List<NoteInfo> readNoteInfos() throws Exception{
		DirNamesLogic dirNamesLogic = new DirNamesLogic();
		List<NoteInfo> result = new ArrayList<>();
		File dir = getNotesDir();
		List<File> noteDirs = Arrays.asList(dir.listFiles());
		Collections.sort(noteDirs);
		for (File i: noteDirs){
			if (getContentFile(i).exists()){ //: if a note was deleted, the content file is deleted, but the note dir which contains the history is kept
				result.add(dirNamesLogic.toNoteInfo(i.getName()));
			}
		}
		return result;
	}
	
	public String readNoteContent(String noteName) throws Exception{
		File noteDir = findNoteDirByNoteNameRequired(noteName);
		File contentFile = getContentFile(noteDir);
		return FileUtil.readFile(contentFile); 
	}
	
	public void setNoteName(String oldNoteName, String newNoteName) throws Exception{
		DirNamesLogic dirNamesLogic = new DirNamesLogic();
		File oldNoteDir = findNoteDirByNoteNameRequired(oldNoteName);
		NoteInfo noteInfo = dirNamesLogic.toNoteInfo(oldNoteDir.getName());
		File newNoteDir = findNoteDirByNoteNameOptional(newNoteName);
		if ((newNoteDir != null) && (newNoteDir.exists())){
			throw new Exception("There already is a note with name '" + newNoteName + "'");
		}
		noteInfo.setName(newNoteName);
		oldNoteDir.renameTo(new File(oldNoteDir.getParentFile(), dirNamesLogic.toFilename(noteInfo)));
	}
	
	public void setNoteColor(String noteName, String color) throws Exception{
		DirNamesLogic dirNamesLogic = new DirNamesLogic();
		File oldNoteDir = findNoteDirByNoteNameRequired(noteName);
		NoteInfo noteInfo = dirNamesLogic.toNoteInfo(oldNoteDir.getName());
		noteInfo.setColor(color);
		oldNoteDir.renameTo(new File(oldNoteDir.getParentFile(), dirNamesLogic.toFilename(noteInfo)));
	}
	
	public void deleteNote(String noteName) throws Exception{
		//: if a note was deleted, the content file is deleted, but the note dir which contains the history is kept
		File noteDir = findNoteDirByNoteNameRequired(noteName);
		File contentFile = getContentFile(noteDir);
		String oldContent = FileUtil.readFile(contentFile);
		File historyFile = createHistoryFile(noteDir);
		FileUtil.writeFile(historyFile, oldContent);
		contentFile.delete();
		if (contentFile.exists()){
			throw new Exception("Could not delete note content file '" + contentFile.getAbsolutePath() + "'");
		}
		removeAutoSaveText(noteName);
	}

	public void setNoteContent(String noteName, String content) throws Exception{
		File noteDir = findNoteDirByNoteNameRequired(noteName);
		File contentFile = getContentFile(noteDir);
		String oldContent = FileUtil.readFile(contentFile);
		File historyFile = createHistoryFile(noteDir);
		FileUtil.writeFile(historyFile, oldContent);
		FileUtil.writeFile(contentFile, content);
	}

	private File createHistoryFile(File noteDir) throws Exception {
		File historyDir = getHistoryDir(noteDir);
		return new File(historyDir, "hist-" + HISTORY_TIME_FORMAT.format(new Date()) + ".txt");
	}

	private File getHistoryDir(File noteDir) throws Exception {
		return makeSureItExists(new File(noteDir, "history"));
	}
	
	public void createNewNote(NoteInfo noteInfo, String noteContent) throws Exception{
		if (doesNoteExist(noteInfo.getName())){
			throw new Exception("Note wth name '" + noteInfo.getName() + "' already exists");
		}
		DirNamesLogic dirNamesLogic = new DirNamesLogic();
		File dir = getNotesDir();
		File noteDir = new File(dir, dirNamesLogic.toFilename(noteInfo));
		makeSureItExists(noteDir);
		File file = getContentFile(noteDir);
		FileUtil.writeFile(file, noteContent);
	}
	
	public boolean doesNoteExist(String noteName) throws Exception{
		File noteDir = findNoteDirByNoteNameOptional(noteName);
		if (noteDir == null){
			return false;
		}
		File contentFile = getContentFile(noteDir);
		return contentFile.exists();
	}
	
	public NoteInfo readNoteInfoOptional(String noteName) throws Exception{
		File noteDir = findNoteDirByNoteNameOptional(noteName);
		if (noteDir == null){
			return null;
		}
		DirNamesLogic dirNamesLogic = new DirNamesLogic();
		return dirNamesLogic.toNoteInfo(noteDir.getName());
	}
	
	/**
	 * 
	 * @return null if there is no auto save text
	 */
	public String getAutoSaveText(String noteName) throws Exception{
		File noteDir = findNoteDirByNoteNameRequired(noteName);
		File autosaveFile = getAutoSaveFile(noteDir);
		if (!autosaveFile.exists()){
			return null;
		}
		return FileUtil.readFile(autosaveFile);
	}
	
	public void setAutoSaveText(String noteName, String text) throws Exception{
		File noteDir = findNoteDirByNoteNameRequired(noteName);
		File autosaveFile = getAutoSaveFile(noteDir);
		FileUtil.writeFile(autosaveFile, text);
	}
	
	public void removeAutoSaveText(String noteName) throws Exception{
		File noteDir = findNoteDirByNoteNameRequired(noteName);
		File autosaveFile = getAutoSaveFile(noteDir);
		if (!autosaveFile.exists()){
			return;
		}
		autosaveFile.delete();
		if (autosaveFile.exists()){
			throw new Exception("Could not delete file '" + autosaveFile.getAbsolutePath() + "'");
		}
	}
	
	
	
	
	
}
