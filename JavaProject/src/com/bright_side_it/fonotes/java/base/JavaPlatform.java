package com.bright_side_it.fonotes.java.base;

import java.io.File;

import com.bright_side_it.filesystemfacade.facade.FSFFile;
import com.bright_side_it.filesystemfacade.nativefs.NativeFS;
import com.bright_side_it.fonotes.common.base.Platform;

public class JavaPlatform implements Platform{

	@Override
	public File getApplicationDataDir() throws Exception {
		File result = new File("data");
		if (!result.exists()){
			result.mkdirs();
		}
		if (!result.exists()){
			throw new Exception("Could not access or create directory '" + result.getAbsolutePath() + "'");
		}
		return result;
	}

	@Override
	public void handleError(Exception e) {
		e.printStackTrace();
	}

	@Override
	public void startWebServer() {
		throw new RuntimeException("Not implemented");
	}

	@Override
	public void log(String message) {
		System.out.println("Fonotes> " + message);
	}

	@Override
	public FSFFile getApplicationDataFSFDir() throws Exception {
		return new NativeFS().createByPath(getApplicationDataDir().getAbsolutePath());
	}

	@Override
	public long getCurrentTimeMillis() {
		return System.currentTimeMillis();
	}

}
