package de.bright_side.fonotes.common.logic;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import de.bright_side.fonotes.common.model.NoteInfo;

public class DirNamesLogicTest {
	private static Set<Character> ALLOWED_CHARS = createAllowedChars();

	private static Set<Character> createAllowedChars() {
		Set<Character> result = new HashSet<>();
		for (char i = 'a'; i <= 'z'; i++){
			result.add(i);
		}
		for (char i = 'A'; i <= 'Z'; i++){
			result.add(i);
		}
		for (char i = '0'; i <= '9'; i++){
			result.add(i);
		}
		result.add('%');
		result.add(' ');
		return result;
	}

	private void verifyAllowedChars(String string) throws Exception {
		for (char i: string.toCharArray()){
			if (!ALLOWED_CHARS.contains(i)){
				throw new Exception("Found illigal char '" + i + "' in string '" + string + "'");
			}
		}
	}


	@Test
	public void test_text_simple() throws Exception{
		DirNamesLogic logic = new DirNamesLogic();
		String originalName = "hello";
		String encodedName = logic.toFilename(originalName);
		verifyAllowedChars(encodedName);
		System.out.println("test_simple: encodedName = '" + encodedName + "'");
		String decodedName = logic.toText(encodedName);
		assertEquals(originalName, decodedName);
	}


	@Test
	public void test_text_plus() throws Exception{
		DirNamesLogic logic = new DirNamesLogic();
		String originalName = "Hello+Hi";
		String encodedName = logic.toFilename(originalName);
		verifyAllowedChars(encodedName);
		System.out.println("test_plus: encodedName = '" + encodedName + "'");
		String decodedName = logic.toText(encodedName);
		assertEquals(originalName, decodedName);
	}

	@Test
	public void test_text_star() throws Exception{
		DirNamesLogic logic = new DirNamesLogic();
		String originalName = "Test*";
		String encodedName = logic.toFilename(originalName);
		verifyAllowedChars(encodedName);
		System.out.println("test_plus: encodedName = '" + encodedName + "'");
		String decodedName = logic.toText(encodedName);
		assertEquals(originalName, decodedName);
	}
	
	@Test
	public void test_text_complex() throws Exception{
		DirNamesLogic logic = new DirNamesLogic();
		String originalName = "Hallo! Das ist schön!  (?\\#+1)***~'";
		String encodedName = logic.toFilename(originalName);
		verifyAllowedChars(encodedName);
		System.out.println("test_complex: encodedName = '" + encodedName + "'");
		String decodedName = logic.toText(encodedName);
		assertEquals(originalName, decodedName);
	}
	
	@Test
	public void test_NoteInfo_normal() throws Exception{
		DirNamesLogic logic = new DirNamesLogic();
		NoteInfo originalNoteInfo = new NoteInfo();
		originalNoteInfo.setName("Schöner Name!**");
		originalNoteInfo.setColor("ffccaa");
		String encodedName = logic.toFilename(originalNoteInfo);
		verifyAllowedChars(encodedName);
		NoteInfo decodedNoteInfo = logic.toNoteInfo(encodedName);
		assertEquals(originalNoteInfo.getName(), decodedNoteInfo.getName());
		assertEquals(originalNoteInfo.getColor(), decodedNoteInfo.getColor());
	}

}
