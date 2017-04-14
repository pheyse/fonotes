package com.bright_side_it.fonotes.common.base;

import java.io.File;

import com.bright_side_it.filesystemfacade.facade.FSFFile;

public interface Platform {
	File getApplicationDataDir() throws Exception;
	
	FSFFile getApplicationDataFSFDir() throws Exception;

	void handleError(Exception e);

	void startWebServer();

	void log(String message);
	
	long getCurrentTimeMillis();
}