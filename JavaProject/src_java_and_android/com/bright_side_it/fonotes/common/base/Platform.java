package com.bright_side_it.fonotes.common.base;

import java.io.File;

public interface Platform {
	File getApplicationDataDir() throws Exception;

	void handleError(Exception e);

	void startWebServer();

	void log(String message);
}