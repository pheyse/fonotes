package generated.fliesenui.core;

import java.io.InputStream;

public interface FLUIScreen {

	String getID();
	
	FLUIAbstractReply onFLUIRequest(FLUIScreenManagerInterface manager, boolean recordMode, FLUIRequest request, String uploadedFileName, InputStream uploadedFileInputStream) throws Exception;
}
