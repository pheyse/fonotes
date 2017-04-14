package com.bright_side_it.fonotes.common.base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.bright_side_it.filesystemfacade.facade.FSFFile;

public class FileUtil {
	private static final String ENCODING = "UTF-8";

	public static void writeFile(FSFFile file, String text, boolean append) throws Exception{
		Writer out = null;
		try{
			out = new BufferedWriter(new OutputStreamWriter(file.getOutputStream(append), ENCODING));
			out.append(text);
			out.flush();
		} catch (Exception e){
			throw e;
		} finally {
			if (out != null){
				out.close();
			}
		}
	}

	public static void writeFile(FSFFile file, String text) throws Exception{
		writeFile(file, text, false);
	}

	public static String readFile(FSFFile file) throws Exception{
	    StringBuilder result = new StringBuilder();
	    BufferedReader in = null;
	    try {
	    	in = new BufferedReader(new InputStreamReader(file.getInputStream(), ENCODING));
	    	String line;
	    	while ((line = in.readLine()) != null) {
	    		result.append(line);
	    		result.append("\n");
			}
	    } catch (Exception e){
	    	throw e;
	    } finally {
	    	in.close();
	    }
	    return result.toString();
	}

	
	
	
	
	public static void writeFile(File file, String text) throws Exception{
		writeFile(file, text, false);
	}
	
	public static void writeFile(File file, String text, boolean append) throws Exception{
		Writer out = null;
		try{
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), ENCODING));
			out.append(text);
			out.flush();
		} catch (Exception e){
			throw e;
		} finally {
			if (out != null){
				out.close();
			}
		}
	}
	
	public static String readFile(File file) throws Exception{
	    StringBuilder result = new StringBuilder();
	    BufferedReader in = null;
	    try {
	    	in = new BufferedReader(new InputStreamReader(new FileInputStream(file), ENCODING));
	    	String line;
	    	while ((line = in.readLine()) != null) {
	    		result.append(line);
	    		result.append("\n");
			}
	    } catch (Exception e){
	    	throw e;
	    } finally {
	    	in.close();
	    }
	    return result.toString();
	}
	

	

}
