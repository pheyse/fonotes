package de.bright_side.fonotes.common.logic;

import java.net.URLDecoder;
import java.net.URLEncoder;

import de.bright_side.fonotes.common.model.NoteInfo;

public class DirNamesLogic {
	private static final String ENCODING = "UTF-8";
	private static final int COLOR_LENGTH = 6;
	
	protected String toFilename(String text) throws Exception{
		String result = URLEncoder.encode(text.replace("+", "\t"), ENCODING);
		result = result.replace("*", "%2A");
		result = result.replace(".", "%2E");
		result = result.replace("+", " ");
		return result;
	}
	
	protected String toText(String filename) throws Exception{
		String result = filename.replace(" ", "+");
		result = URLDecoder.decode(result, ENCODING);
		result = result.replace("\t", "+");
		return result;
	}
	
	public String toFilename(NoteInfo noteInfo) throws Exception{
		if (noteInfo.getColor().length() != COLOR_LENGTH){
			throw new Exception("Wrong color length: " + noteInfo.getColor().length());
		}
		return toFilename(noteInfo.getName() + noteInfo.getColor());
	}
	
	public NoteInfo toNoteInfo(String filename) throws Exception{
		NoteInfo result = new NoteInfo();
		String text = toText(filename);
		result.setName(text.substring(0, text.length() - COLOR_LENGTH));
		result.setColor(text.substring(text.length() - COLOR_LENGTH));
		return result;
	}
	
	
}
