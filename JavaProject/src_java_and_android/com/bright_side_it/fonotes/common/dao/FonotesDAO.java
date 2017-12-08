package com.bright_side_it.fonotes.common.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

import com.bright_side_it.filesystemfacade.facade.FSFFile;
import com.bright_side_it.fonotes.common.base.FileUtil;
import com.bright_side_it.fonotes.common.base.MarkdownFormattingUtil;
import com.bright_side_it.fonotes.common.base.Platform;
import com.bright_side_it.fonotes.common.logic.ColorLogic;
import com.bright_side_it.fonotes.common.logic.DirNamesLogic;
import com.bright_side_it.fonotes.common.model.NoteInfo;
import com.bright_side_it.fonotes.common.model.NoteInfoRepository;
import com.bright_side_it.fonotes.common.model.Settings;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import generated.fliesenui.core.BrightMarkdown;
import generated.fliesenui.core.FLUIMarkdownFormatting;

public class FonotesDAO {
	private static final SimpleDateFormat HISTORY_TIME_FORMAT = new SimpleDateFormat("yyyy_MM_dd__HH_mm_ss");
	private Platform platform;

	public FonotesDAO(Platform platform){
		this.platform = platform;
	}
	
	private FSFFile makeSureItExists(FSFFile dir) throws Exception{
		if (!dir.exists()){
			dir.mkdirs();
		}
		if (!dir.exists()){
			throw new Exception("Directory '" + dir.getAbsolutePath() + "' does not exist and could not be created");
		}
		return dir;
	}

	private FSFFile getNotesDir() throws Exception{
		return makeSureItExists(platform.getApplicationDataFSFDir().getChild("notes"));
	}

	private FSFFile getExportDir() throws Exception{
		return makeSureItExists(platform.getApplicationDataFSFDir().getChild("export"));
	}

	private FSFFile getSettigsFile() throws Exception{
		return makeSureItExists(platform.getApplicationDataFSFDir()).getChild("settings.json");
	}

	private FSFFile getNoteInfoRepositoryFile() throws Exception {
		return makeSureItExists(platform.getApplicationDataFSFDir()).getChild("noteInfoRepository.json");
	}
	
	private FSFFile getContentFile(FSFFile noteDir) {
		return noteDir.getChild("content.txt");
	}
	
	private FSFFile getAutoSaveFile(FSFFile noteDir) {
		return noteDir.getChild("autosave.txt");
	}
	
	private FSFFile getNoteInfoFile(FSFFile noteDir) {
		return noteDir.getChild("noteInfo.json");
	}
	
	public FSFFile findNoteDirByNoteNameOptional(String noteName) throws Exception {
		DirNamesLogic dirNamesLogic = new DirNamesLogic();
		FSFFile dir = getNotesDir();
		String requestedDirNoteName = dirNamesLogic.toFilename(noteName);
		for (FSFFile i: dir.listFiles()){
			if (requestedDirNoteName.equals(i.getName())){
				return i;
			}
		}
		return null;
	}

	public FSFFile findNoteDirByNoteNameRequired(String noteName) throws Exception {
		FSFFile result = findNoteDirByNoteNameOptional(noteName);
		if (result == null){
			throw new Exception("Could not find note directory for note with name '" + noteName + "'");
		}
		return result;
	}

	private NoteInfo readNoteInfoFromNoteDir(FSFFile noteDir) throws Exception {
		FSFFile file = getNoteInfoFile(noteDir);
		if (!file.exists()){
			return null;
		}
		String json = FileUtil.readFile(file);
		return new Gson().fromJson(json, NoteInfo.class);
	}

	private void writeNoteInfoToNoteDir(FSFFile noteDir, NoteInfo noteInfo) throws Exception {
		FSFFile file = getNoteInfoFile(noteDir);
		String json = new Gson().toJson(noteInfo);
		FileUtil.writeFile(file, json);
	}
	
	private NoteInfo rebuildNoteInfo(FSFFile noteDir) throws Exception{
		FSFFile file = getNoteInfoFile(noteDir);
		file.delete();
		FSFFile contentFile = getContentFile(noteDir);
		NoteInfo noteInfo = new NoteInfo();
		noteInfo.setColorID(ColorLogic.DEFAULT_COLOR_ID);
		noteInfo.setName(new DirNamesLogic().filenameToText(noteDir.getName()));
		noteInfo.setCreationTime(noteDir.getTimeLastModified());
		noteInfo.setLastEditTime(contentFile.getTimeLastModified());
		String json = new Gson().toJson(noteInfo);
		FileUtil.writeFile(file, json);
		return noteInfo;
	}
	
	/**
	 * if the note info repository is broken or missing, it can be rebuild from the information stored in each note dir
	 * @return 
	 * @throws Exception
	 */
	private NoteInfoRepository rebuildNoteInfoRepository() throws Exception{
		NoteInfoRepository result = new NoteInfoRepository();
		result.setNoteInfos(new TreeMap<String, NoteInfo>());
		FSFFile dir = getNotesDir();
		List<FSFFile> noteDirs = dir.listFiles();
		Collections.sort(noteDirs);
		for (FSFFile i: noteDirs){
			if (getContentFile(i).exists()){ //: if a note was deleted, the content file is deleted, but the note dir which contains the history is kept
				NoteInfo noteInfo = readNoteInfoFromNoteDir(i);
				if (noteInfo == null){
					noteInfo = rebuildNoteInfo(i);
				}
				result.getNoteInfos().put(noteInfo.getName(), noteInfo);
			}
		}
		String json = new GsonBuilder().setPrettyPrinting().create().toJson(result);
		FSFFile file = getNoteInfoRepositoryFile();
		FileUtil.writeFile(file, json);
		return result;
	}

	public NoteInfoRepository readNoteInfoRepository() throws Exception{
		FSFFile file = getNoteInfoRepositoryFile();
		NoteInfoRepository repository = null;
		try{
			if (file.exists()){
				String json = FileUtil.readFile(file);
				repository = new Gson().fromJson(json, NoteInfoRepository.class);
			} else {
				repository = rebuildNoteInfoRepository();
			}
		} catch (Exception e){
			repository = rebuildNoteInfoRepository();
		}
		return repository;
	}

	public void writeNoteInfoRepository(NoteInfoRepository repository) throws Exception{
		String json = new Gson().toJson(repository);
		FileUtil.writeFile(getNoteInfoRepositoryFile(), json);
	}
	
	public List<NoteInfo> readNoteInfos() throws Exception{
		NoteInfoRepository result = readNoteInfoRepository();
		return new ArrayList<NoteInfo>(result.getNoteInfos().values());
	}
	
	public String readNoteContent(String noteName) throws Exception{
		FSFFile noteDir = findNoteDirByNoteNameRequired(noteName);
		FSFFile contentFile = getContentFile(noteDir);
		return FileUtil.readFile(contentFile); 
	}
	
	public void setNoteName(String oldNoteName, String newNoteName) throws Exception{
		FSFFile newNoteDir = findNoteDirByNoteNameOptional(newNoteName);
		if ((newNoteDir != null) && (newNoteDir.exists())){
			throw new Exception("There already is a note with name '" + newNoteName + "'");
		}
		DirNamesLogic dirNamesLogic = new DirNamesLogic();
		
		NoteInfoRepository repository = readNoteInfoRepository();
		FSFFile oldNoteDir = findNoteDirByNoteNameRequired(oldNoteName);
		NoteInfo noteInfo = readNoteInfoFromNoteDir(oldNoteDir);
		noteInfo.setName(newNoteName);
		noteInfo.setLastEditTime(platform.getCurrentTimeMillis());
		newNoteDir = getNotesDir().getChild(dirNamesLogic.toFilename(noteInfo));
		repository.getNoteInfos().remove(oldNoteName);
		repository.getNoteInfos().put(newNoteName, noteInfo);

		//: persist changes:
		oldNoteDir.rename(newNoteDir.getName());
		writeNoteInfoToNoteDir(newNoteDir, noteInfo);
		writeNoteInfoRepository(repository);
	}
	
	
	public void setNoteColorID(String noteName, String colorName) throws Exception{
		FSFFile noteDir = findNoteDirByNoteNameRequired(noteName);
		NoteInfoRepository repository = readNoteInfoRepository();
		NoteInfo noteInfo = readNoteInfoFromNoteDir(noteDir);
		
		noteInfo.setColorID(colorName);
		repository.getNoteInfos().put(noteName, noteInfo);

		//: persist changes:
		writeNoteInfoToNoteDir(noteDir, noteInfo);
		writeNoteInfoRepository(repository);
	}
	
	public void deleteNote(String noteName) throws Exception{
		//: if a note was deleted, the content file is deleted, but the note dir which contains the history is kept
		FSFFile noteDir = findNoteDirByNoteNameRequired(noteName);
		NoteInfoRepository repository = readNoteInfoRepository();
		repository.getNoteInfos().remove(noteName);
		FSFFile contentFile = getContentFile(noteDir);
		String oldContent = FileUtil.readFile(contentFile);
		FSFFile historyFile = createHistoryFile(noteDir);
		FileUtil.writeFile(historyFile, oldContent);
		contentFile.delete();
		if (contentFile.exists()){
			throw new Exception("Could not delete note content file '" + contentFile.getAbsolutePath() + "'");
		}
		removeAutoSaveText(noteName);
		writeNoteInfoRepository(repository);
	}

	public void setNoteContent(String noteName, String content) throws Exception{
		NoteInfoRepository repository = readNoteInfoRepository();
		FSFFile noteDir = findNoteDirByNoteNameRequired(noteName);
		NoteInfo noteInfo = readNoteInfoFromNoteDir(noteDir);
		
		noteInfo.setLastEditTime(platform.getCurrentTimeMillis());
		repository.getNoteInfos().put(noteName, noteInfo);
		
		FSFFile contentFile = getContentFile(noteDir);
		String oldContent = FileUtil.readFile(contentFile);
		FSFFile historyFile = createHistoryFile(noteDir);

		FileUtil.writeFile(historyFile, oldContent);
		FileUtil.writeFile(contentFile, content);
		writeNoteInfoToNoteDir(noteDir, noteInfo);
		writeNoteInfoRepository(repository);
	}

	private FSFFile createHistoryFile(FSFFile noteDir) throws Exception {
		FSFFile historyDir = getHistoryDir(noteDir);
		return historyDir.getChild("hist-" + HISTORY_TIME_FORMAT.format(new Date()) + ".txt");
	}

	private FSFFile getHistoryDir(FSFFile noteDir) throws Exception {
		return makeSureItExists(noteDir.getChild("history"));
	}
	
	public void createNewNote(NoteInfo noteInfo, String noteContent) throws Exception{
		NoteInfoRepository repository = readNoteInfoRepository();
		repository.getNoteInfos().put(noteInfo.getName(), noteInfo);
		if (doesNoteExist(noteInfo.getName())){
			throw new Exception("Note wth name '" + noteInfo.getName() + "' already exists");
		}
		
		DirNamesLogic dirNamesLogic = new DirNamesLogic();
		FSFFile dir = getNotesDir();
		FSFFile noteDir = dir.getChild(dirNamesLogic.toFilename(noteInfo));
		makeSureItExists(noteDir);
		FSFFile file = getContentFile(noteDir);
		FileUtil.writeFile(file, noteContent);

		writeNoteInfoToNoteDir(noteDir, noteInfo);
		writeNoteInfoRepository(repository);
	}
	
	public boolean doesNoteExist(String noteName) throws Exception{
		FSFFile noteDir = findNoteDirByNoteNameOptional(noteName);
		if (noteDir == null){
			return false;
		}
		FSFFile contentFile = getContentFile(noteDir);
		return contentFile.exists();
	}
	
	public NoteInfo readNoteInfoOptional(String noteName) throws Exception{
		FSFFile noteDir = findNoteDirByNoteNameOptional(noteName);
		if (noteDir == null){
			return null;
		}
		return readNoteInfoFromNoteDir(noteDir);
	}
	
	/**
	 * 
	 * @return null if there is no auto save text
	 */
	public String getAutoSaveText(String noteName) throws Exception{
		FSFFile noteDir = findNoteDirByNoteNameRequired(noteName);
		FSFFile autosaveFile = getAutoSaveFile(noteDir);
		if (!autosaveFile.exists()){
			return null;
		}
		return FileUtil.readFile(autosaveFile);
	}
	
	public void setAutoSaveText(String noteName, String text) throws Exception{
		FSFFile noteDir = findNoteDirByNoteNameRequired(noteName);
		FSFFile autosaveFile = getAutoSaveFile(noteDir);
		FileUtil.writeFile(autosaveFile, text);
	}
	
	public void removeAutoSaveText(String noteName) throws Exception{
		FSFFile noteDir = findNoteDirByNoteNameRequired(noteName);
		FSFFile autosaveFile = getAutoSaveFile(noteDir);
		if (!autosaveFile.exists()){
			return;
		}
		autosaveFile.delete();
		if (autosaveFile.exists()){
			throw new Exception("Could not delete file '" + autosaveFile.getAbsolutePath() + "'");
		}
	}

	public Settings readSettings() throws Exception{
		FSFFile file = getSettigsFile();
		if (!file.exists()){
			return new Settings();
		}
		String json = FileUtil.readFile(file);
		return new Gson().fromJson(json, Settings.class);
	}
	
	public void writeSettings(Settings settings) throws Exception{
		FSFFile file = getSettigsFile();
		String json = new Gson().toJson(settings);
		FileUtil.writeFile(file, json);
	}


	public void convertOldColorsToNew() throws Exception {
		//: 1. read all noteInfos
		List<NoteInfo> noteInfos = readNoteInfos();
		//: 2. create map of all colors (or find problem)
		Map<String, String> noteNameToNewColorMap = new TreeMap<String, String>();
		for (NoteInfo i: noteInfos){
			noteNameToNewColorMap.put(i.getName(), new ColorLogic().mapOldColorToNew(i.getName().substring(i.getName().length() - 6)));
		}
		
		//: 3. set all new colors
		for (Entry<String, String> i: noteNameToNewColorMap.entrySet()){
			setNoteColorID(i.getKey(), i.getValue());
		}
		//: 4. rename all notes
		for (Entry<String, String> i: noteNameToNewColorMap.entrySet()){
			String relevantFilenamePart = i.getKey().substring(0, i.getKey().length() - 6);
			setNoteName(i.getKey(), new DirNamesLogic().filenameToText(relevantFilenamePart));
		}
	}


    /**
     *
     * @param noteName
     * @return path to which the note as been exported to
     */
    public String exportNoteAsHTML(String noteName) throws Exception{
        String text = readNoteContent(noteName);

        FLUIMarkdownFormatting formatting = MarkdownFormattingUtil.createMarkdownFormatting(text);
        BrightMarkdown brightMarkdown = new BrightMarkdown();
        MarkdownFormattingUtil.apply(brightMarkdown, formatting);
        String html = brightMarkdown.createHTML(text);

        FSFFile file = getExportDir().getChild("note.html");
        FileUtil.writeFile(file, html);

        return file.getAbsolutePath();
    }
}
