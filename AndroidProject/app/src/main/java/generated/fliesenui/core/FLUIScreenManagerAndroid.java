/*Generated! Do not modify!*/ package generated.fliesenui.core;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import com.google.gson.Gson;
/*Generated! Do not modify!*/ import android.content.Context;
/*Generated! Do not modify!*/ import android.webkit.JavascriptInterface;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIAndroidWebView;
/*Generated! Do not modify!*/ import java.util.Map;
/*Generated! Do not modify!*/ import java.util.List;
/*Generated! Do not modify!*/ import java.util.ArrayList;
/*Generated! Do not modify!*/ import java.util.TreeMap;
/*Generated! Do not modify!*/ import java.io.ByteArrayOutputStream;
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ import java.nio.charset.Charset;
/*Generated! Do not modify!*/ import java.io.OutputStream;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.screen.AboutView;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.AboutListener;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.AboutDisplay;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.AboutDisplayController;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.AboutDisplayEventHandler;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.DetailsView;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.DetailsListener;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.DetailsDisplay;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.DetailsDisplayController;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.DetailsDisplayEventHandler;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.LoginView;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.LoginListener;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.LoginDisplay;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.LoginDisplayController;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.LoginDisplayEventHandler;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.MarkdownHelpView;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.MarkdownHelpListener;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.MarkdownHelpDisplay;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.MarkdownHelpDisplayController;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.MarkdownHelpDisplayEventHandler;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.OverviewView;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.OverviewListener;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.OverviewDisplay;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.OverviewDisplayController;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.OverviewDisplayEventHandler;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class FLUIScreenManagerAndroid implements FLUIScreenManagerInterface{
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static final String FILE_UPLOAD_FORM_REQUEST_PARAMETER_NAME = "requestData";
/*Generated! Do not modify!*/     public static final String FILE_UPLOAD_FORM_FILE_PARAMETER_NAME = "uploadedFile";
/*Generated! Do not modify!*/     private static final String RESOURCE_BASE_DIR = "generated/fliesenui/web";
/*Generated! Do not modify!*/     private static final String TEXT_CHARSET = "UTF-8";
/*Generated! Do not modify!*/     private Context context;
/*Generated! Do not modify!*/     private FLUIAndroidWebView webView;
/*Generated! Do not modify!*/     private boolean singlePageApp = true;
/*Generated! Do not modify!*/     private FLUIScreenManagerListener listener;
/*Generated! Do not modify!*/     private boolean recording = false;
/*Generated! Do not modify!*/     private FLUIActionRecording actionRecording;
/*Generated! Do not modify!*/     private FLUIWebCallHandler fluiWebCallHandler = new FLUIWebCallHandler(this);
/*Generated! Do not modify!*/     private Map<String, FLUIScreen> screenIDToViewMap = new TreeMap<String, FLUIScreen>();
/*Generated! Do not modify!*/     private Map<String, FLUIDisplayController> screenIDToDisplayControllerMap = new TreeMap<String, FLUIDisplayController>();
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private FLUIScreenManagerAndroid() {
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static FLUIScreenManagerAndroid createInstance(Context context, boolean singlePageApp, FLUIScreenManagerListener listener) {
/*Generated! Do not modify!*/         FLUIScreenManagerAndroid result = new FLUIScreenManagerAndroid();
/*Generated! Do not modify!*/         result.context = context;
/*Generated! Do not modify!*/         result.singlePageApp = singlePageApp;
/*Generated! Do not modify!*/         result.listener = listener;
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static FLUIScreenManagerAndroid createInstance(Context context, FLUIScreenManagerListener listener) {
/*Generated! Do not modify!*/         FLUIScreenManagerAndroid result = new FLUIScreenManagerAndroid();
/*Generated! Do not modify!*/         result.context = context;
/*Generated! Do not modify!*/         result.singlePageApp = true;
/*Generated! Do not modify!*/         result.listener = listener;
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static FLUIScreenManagerAndroid createSimpleInstance(Context context) {
/*Generated! Do not modify!*/         FLUIScreenManagerAndroid result = new FLUIScreenManagerAndroid();
/*Generated! Do not modify!*/         result.context = context;
/*Generated! Do not modify!*/         result.singlePageApp = true;
/*Generated! Do not modify!*/         result.listener = new SimpleManagerListener();
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     public void setWebView(FLUIAndroidWebView webView) {
/*Generated! Do not modify!*/         this.webView = webView;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSinglePageApp(boolean singlePageApp) {
/*Generated! Do not modify!*/         this.singlePageApp = singlePageApp;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void startRecording() {
/*Generated! Do not modify!*/         actionRecording = new FLUIActionRecording();
/*Generated! Do not modify!*/         actionRecording.setRequests(new ArrayList<FLUIRequest>());
/*Generated! Do not modify!*/         actionRecording.setReplies(new ArrayList<FLUIReplyDTO>());
/*Generated! Do not modify!*/         recording = true;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void stopRecording() {
/*Generated! Do not modify!*/         recording = false;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIActionRecording getActionRecording() {
/*Generated! Do not modify!*/         return actionRecording;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     public boolean isSinglePageApp() {
/*Generated! Do not modify!*/         return singlePageApp;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setAboutDisplay(AboutDisplay display) {
/*Generated! Do not modify!*/         screenIDToDisplayControllerMap.put("about", new AboutDisplayController(display));
/*Generated! Do not modify!*/         display.setEventHandler(new AboutDisplayEventHandler(this));
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setDetailsDisplay(DetailsDisplay display) {
/*Generated! Do not modify!*/         screenIDToDisplayControllerMap.put("details", new DetailsDisplayController(display));
/*Generated! Do not modify!*/         display.setEventHandler(new DetailsDisplayEventHandler(this));
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setLoginDisplay(LoginDisplay display) {
/*Generated! Do not modify!*/         screenIDToDisplayControllerMap.put("login", new LoginDisplayController(display));
/*Generated! Do not modify!*/         display.setEventHandler(new LoginDisplayEventHandler(this));
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setMarkdownHelpDisplay(MarkdownHelpDisplay display) {
/*Generated! Do not modify!*/         screenIDToDisplayControllerMap.put("markdownHelp", new MarkdownHelpDisplayController(display));
/*Generated! Do not modify!*/         display.setEventHandler(new MarkdownHelpDisplayEventHandler(this));
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setOverviewDisplay(OverviewDisplay display) {
/*Generated! Do not modify!*/         screenIDToDisplayControllerMap.put("overview", new OverviewDisplayController(display));
/*Generated! Do not modify!*/         display.setEventHandler(new OverviewDisplayEventHandler(this));
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIImageStream getCustomImageStream(String imageStreamID) {
/*Generated! Do not modify!*/         return listener.getCustomImageStream(imageStreamID);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIFileStream getFileStream(String fileStreamID) {
/*Generated! Do not modify!*/         return listener.getFileStream(fileStreamID);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIScreenManagerListener getListener() {
/*Generated! Do not modify!*/         return listener;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void handleWebCall(FLUIWebCall webCall, String method, String requestPath) throws Exception {
/*Generated! Do not modify!*/         fluiWebCallHandler.handle(webCall, method, requestPath);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void handleWebUpload(FLUIWebCall webCall, String requestJSON, String uploadFilename, InputStream uploadFileInputStream) throws Exception {
/*Generated! Do not modify!*/         fluiWebCallHandler.handleUpload(webCall, requestJSON, uploadFilename, uploadFileInputStream);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIReplyDTO onScreenRequest(FLUIScreenRequest request, String uploadFileName, InputStream uploadFileInputStream, boolean clearRecordedActions){
/*Generated! Do not modify!*/         String requestJSON = new Gson().toJson(request.getRequest());
/*Generated! Do not modify!*/         String replyJSON = onRequest(requestJSON, uploadFileName, uploadFileInputStream);
/*Generated! Do not modify!*/         FLUIReplyDTO result = new Gson().fromJson(replyJSON, FLUIReplyDTO.class);
/*Generated! Do not modify!*/         if (clearRecordedActions){
/*Generated! Do not modify!*/             result.setRecordedActions(new ArrayList<FLUIReplyAction>());
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openStartScreen() {
/*Generated! Do not modify!*/         String urlSuffix = null;
/*Generated! Do not modify!*/ //        if (object != null){
/*Generated! Do not modify!*/ //            try {
/*Generated! Do not modify!*/ //                urlSuffix = "?parameterDTO=" + FLUIUtil.toURLParameter(object);
/*Generated! Do not modify!*/ //            } catch (Exception e){
/*Generated! Do not modify!*/ //                listener.onError(e);
/*Generated! Do not modify!*/ //            }
/*Generated! Do not modify!*/ //        }
/*Generated! Do not modify!*/         if (singlePageApp){
/*Generated! Do not modify!*/             webView.openScreen("login", "_jfx_app.html", urlSuffix, singlePageApp);
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             webView.openScreen("login", "login_jfx.html", urlSuffix, singlePageApp);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private String getStartWebPageFilename() {
/*Generated! Do not modify!*/         if (singlePageApp){
/*Generated! Do not modify!*/             return "_web_app.html";
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             return "login_web.html";
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public String getStartWebPageAsString() throws Exception{
/*Generated! Do not modify!*/         return getResourceAsString(getStartWebPageFilename());
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public String getResourceAsString(String relativeLocation) throws Exception{
/*Generated! Do not modify!*/         InputStream inputStream = null;
/*Generated! Do not modify!*/         String useRelativeLocation = relativeLocation;
/*Generated! Do not modify!*/         if (!useRelativeLocation.startsWith("/")){
/*Generated! Do not modify!*/             useRelativeLocation = "/" + useRelativeLocation;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         String location = null;
/*Generated! Do not modify!*/         try {
/*Generated! Do not modify!*/             location = RESOURCE_BASE_DIR + useRelativeLocation;
/*Generated! Do not modify!*/             inputStream = inputStream = context.getAssets().open(location);
/*Generated! Do not modify!*/         } catch (Exception e) {
/*Generated! Do not modify!*/             throw new Exception("Could not get internal URI for file with relative location '" + relativeLocation + "'. location = '" + location + "'", e);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         if (inputStream == null){
/*Generated! Do not modify!*/             throw new Exception("Could not get input stream URI for file with relative location '" + relativeLocation + "'. location = '" + location + "'");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
/*Generated! Do not modify!*/         try {
/*Generated! Do not modify!*/             writeAllBytesToStream(inputStream, outputStream);
/*Generated! Do not modify!*/         } catch (Exception e) {
/*Generated! Do not modify!*/             throw e;
/*Generated! Do not modify!*/         } finally {
/*Generated! Do not modify!*/             if (inputStream != null) {
/*Generated! Do not modify!*/                 inputStream.close();
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         
/*Generated! Do not modify!*/         String text = new String(outputStream.toByteArray(), Charset.forName(TEXT_CHARSET));
/*Generated! Do not modify!*/         return text;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void writeResource(String relativeLocation, OutputStream outputStream) throws Exception{
/*Generated! Do not modify!*/         InputStream inputStream = null;
/*Generated! Do not modify!*/         String useRelativeLocation = relativeLocation;
/*Generated! Do not modify!*/         if (!useRelativeLocation.startsWith("/")){
/*Generated! Do not modify!*/             useRelativeLocation = "/" + useRelativeLocation;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         String location = null;
/*Generated! Do not modify!*/         try {
/*Generated! Do not modify!*/             location = RESOURCE_BASE_DIR + useRelativeLocation;
/*Generated! Do not modify!*/             inputStream = inputStream = context.getAssets().open(location);
/*Generated! Do not modify!*/         } catch (Exception e) {
/*Generated! Do not modify!*/             throw new Exception("Could not get internal URI for file with relative location '" + relativeLocation + "'. location = '" + location + "'", e);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         if (inputStream == null){
/*Generated! Do not modify!*/             throw new Exception("Could not get input stream URI for file with relative location '" + relativeLocation + "'. location = '" + location + "'");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         try {
/*Generated! Do not modify!*/             writeAllBytesToStream(inputStream, outputStream);
/*Generated! Do not modify!*/         } catch (Exception e) {
/*Generated! Do not modify!*/             throw e;
/*Generated! Do not modify!*/         } finally {
/*Generated! Do not modify!*/             if (inputStream != null) {
/*Generated! Do not modify!*/                 inputStream.close();
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private void writeAllBytesToStream(InputStream inputStream, OutputStream outputStream) throws Exception {
/*Generated! Do not modify!*/         int readBytes;
/*Generated! Do not modify!*/         byte[] buffer = new byte[4096];
/*Generated! Do not modify!*/         while ((readBytes = inputStream.read(buffer)) > 0) {
/*Generated! Do not modify!*/             outputStream.write(buffer, 0, readBytes);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     public void setAboutPresenter(AboutListener presenter) {
/*Generated! Do not modify!*/         screenIDToViewMap.put("about", new AboutView(presenter));
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setDetailsPresenter(DetailsListener presenter) {
/*Generated! Do not modify!*/         screenIDToViewMap.put("details", new DetailsView(presenter));
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setLoginPresenter(LoginListener presenter) {
/*Generated! Do not modify!*/         screenIDToViewMap.put("login", new LoginView(presenter));
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setMarkdownHelpPresenter(MarkdownHelpListener presenter) {
/*Generated! Do not modify!*/         screenIDToViewMap.put("markdownHelp", new MarkdownHelpView(presenter));
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setOverviewPresenter(OverviewListener presenter) {
/*Generated! Do not modify!*/         screenIDToViewMap.put("overview", new OverviewView(presenter));
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private void reply(String screenID, String replyDTOJSON, FLUIAbstractReply reply) {
/*Generated! Do not modify!*/         try{
/*Generated! Do not modify!*/             FLUIDisplayController displayController = screenIDToDisplayControllerMap.get(screenID);
/*Generated! Do not modify!*/             if (displayController != null){
/*Generated! Do not modify!*/                 displayController.processReply(reply.getReplyDTO());
/*Generated! Do not modify!*/                 return;
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/             if (webView != null){
/*Generated! Do not modify!*/                 webView.executeWithResultString(screenID + "$processReply(\"" + FLUIUtil.reescapeEscapeCharacters(replyDTOJSON) + "\");");
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         } catch (Throwable t){
/*Generated! Do not modify!*/             listener.onError(t);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @JavascriptInterface
/*Generated! Do not modify!*/     public String onRequest(String requestJSON, String uploadFileName, InputStream uploadFileInputStream) {
/*Generated! Do not modify!*/         String replyJSON = null;
/*Generated! Do not modify!*/         try{
/*Generated! Do not modify!*/             FLUIRequest request = new Gson().fromJson(requestJSON, FLUIRequest.class);
/*Generated! Do not modify!*/             if (request == null){
/*Generated! Do not modify!*/                 throw new Exception("request is null, requestJSON = >>" + requestJSON + "<<");
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/             listener.onRequest(request);
/*Generated! Do not modify!*/             FLUIScreen view = screenIDToViewMap.get(request.getScreenID());
/*Generated! Do not modify!*/             FLUIAbstractReply reply = null;
/*Generated! Do not modify!*/             if (view != null){
/*Generated! Do not modify!*/                 reply = view.onFLUIRequest(this, recording, request, uploadFileName, uploadFileInputStream);
/*Generated! Do not modify!*/                 if (reply != null){
/*Generated! Do not modify!*/                     replyJSON = new Gson().toJson(reply.getReplyDTO());
/*Generated! Do not modify!*/                     if (recording){;
/*Generated! Do not modify!*/                         actionRecording.getRequests().add(request);
/*Generated! Do not modify!*/                         actionRecording.getReplies().add(reply.getReplyDTO());
/*Generated! Do not modify!*/                     };
/*Generated! Do not modify!*/                 }
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/             if (replyJSON != null){
/*Generated! Do not modify!*/                 reply(request.getScreenID(), replyJSON, reply);
/*Generated! Do not modify!*/             } else {
/*Generated! Do not modify!*/                 listener.onWarning(new Exception("No presenter defined for screen '" + request.getScreenID() + "'"));
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         } catch (Throwable error){
/*Generated! Do not modify!*/             listener.onError(error);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return replyJSON;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }