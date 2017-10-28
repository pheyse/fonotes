/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import java.util.Map;
/*Generated! Do not modify!*/ import java.util.TreeMap;
/*Generated! Do not modify!*/ import com.google.gson.Gson;
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIScreen;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIRequest;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIScreenRequest;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIAbstractReply;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIString.StringLanguage;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIClientPropertiesDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class MarkdownHelpRequest implements FLUIScreenRequest{
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private FLUIRequest request = new FLUIRequest();
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private MarkdownHelpRequest(){
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIRequest getRequest() {
/*Generated! Do not modify!*/         return request;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private MarkdownHelpRequest(String actionName, String language){
/*Generated! Do not modify!*/         request = new FLUIRequest();
/*Generated! Do not modify!*/         request.setAction(actionName);
/*Generated! Do not modify!*/         request.setCurrentLanguage(language);
/*Generated! Do not modify!*/         request.setScreenID("markdownHelp");
/*Generated! Do not modify!*/         request.setParameters(new TreeMap<String, Object>());
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static MarkdownHelpRequest createOnBackButtonClickedRequest(String language, generated.fliesenui.dto.OverviewParameterDTO parameter){
/*Generated! Do not modify!*/         MarkdownHelpRequest resultInstance = new MarkdownHelpRequest("widgetButtonBackButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static MarkdownHelpRequest createOnLoadedRequest(String language, FLUIClientPropertiesDTO _ClientProperties, generated.fliesenui.dto.OverviewParameterDTO parameter){
/*Generated! Do not modify!*/         MarkdownHelpRequest resultInstance = new MarkdownHelpRequest("onLoaded", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("_ClientProperties", new Gson().toJson(_ClientProperties));
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static MarkdownHelpRequest createOnBackPressedRequest(String language, generated.fliesenui.dto.OverviewParameterDTO parameter){
/*Generated! Do not modify!*/         MarkdownHelpRequest resultInstance = new MarkdownHelpRequest("onBackPressed", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static MarkdownHelpRequest createOnInputDialogResultRequest(String language){
/*Generated! Do not modify!*/         MarkdownHelpRequest resultInstance = new MarkdownHelpRequest("onInputDialogResult", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static MarkdownHelpRequest createOnConfirmDialogResultRequest(String language){
/*Generated! Do not modify!*/         MarkdownHelpRequest resultInstance = new MarkdownHelpRequest("onConfirmDialogResult", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static MarkdownHelpRequest createOnListChooserResultRequest(String language){
/*Generated! Do not modify!*/         MarkdownHelpRequest resultInstance = new MarkdownHelpRequest("onListChooserResult", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }