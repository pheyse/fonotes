package com.bright_side_it.fonotes.java.ui;

import com.bright_side_it.fonotes.common.base.FonotesBase;
import com.bright_side_it.fonotes.java.base.JavaPlatform;

import generated.fliesenui.core.FLUIApplication;
import generated.fliesenui.core.FLUIScreenManager;
import javafx.stage.Stage;

public class MainWindow extends FLUIApplication {

	public MainWindow() {
		super("Fonotes", 1000, 500, createScreenManager());
	}

	@Override
	public void onStart(Stage stage) {
	}
	
	private static FLUIScreenManager createScreenManager() {
		FLUIScreenManager screenManager = FLUIScreenManager.createSimpleInstance();
		JavaPlatform platform = new JavaPlatform();
		FonotesBase.setAllPresenters(screenManager, platform, null, false);
		return screenManager;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
