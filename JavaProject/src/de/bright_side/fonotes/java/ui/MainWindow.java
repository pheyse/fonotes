package de.bright_side.fonotes.java.ui;

import de.bright_side.fonotes.common.base.FonotesBase;
import de.bright_side.fonotes.java.base.JavaPlatform;
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
