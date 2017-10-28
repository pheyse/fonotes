/*Generated! Do not modify!*/ package generated.fliesenui.core;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ import java.io.OutputStream;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.AboutListener;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.DetailsListener;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.LoginListener;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.MarkdownHelpListener;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.OverviewListener;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public interface FLUIScreenManagerInterface {
/*Generated! Do not modify!*/     String onRequest(String requestJSON, String uploadFileName, InputStream uploadFileInputStream);
/*Generated! Do not modify!*/     FLUIScreenManagerListener getListener();
/*Generated! Do not modify!*/     FLUIImageStream getCustomImageStream(String imageStreamID);
/*Generated! Do not modify!*/     FLUIFileStream getFileStream(String fileStreamID);
/*Generated! Do not modify!*/     void writeResource(String relativeLocation, OutputStream outputStream) throws Exception;
/*Generated! Do not modify!*/     String getStartWebPageAsString() throws Exception;
/*Generated! Do not modify!*/     String getResourceAsString(String relativeLocation) throws Exception;
/*Generated! Do not modify!*/     void setAboutPresenter(AboutListener presenter);
/*Generated! Do not modify!*/     void setDetailsPresenter(DetailsListener presenter);
/*Generated! Do not modify!*/     void setLoginPresenter(LoginListener presenter);
/*Generated! Do not modify!*/     void setMarkdownHelpPresenter(MarkdownHelpListener presenter);
/*Generated! Do not modify!*/     void setOverviewPresenter(OverviewListener presenter);
/*Generated! Do not modify!*/ }
/*Generated! Do not modify!*/ 