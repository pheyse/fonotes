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
/*Generated! Do not modify!*/ public class AboutRequest implements FLUIScreenRequest{
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private FLUIRequest request = new FLUIRequest();
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private AboutRequest(){
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIRequest getRequest() {
/*Generated! Do not modify!*/         return request;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private AboutRequest(String actionName, String language){
/*Generated! Do not modify!*/         request = new FLUIRequest();
/*Generated! Do not modify!*/         request.setAction(actionName);
/*Generated! Do not modify!*/         request.setCurrentLanguage(language);
/*Generated! Do not modify!*/         request.setScreenID("about");
/*Generated! Do not modify!*/         request.setParameters(new TreeMap<String, Object>());
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static AboutRequest createOnBackButtonClickedRequest(String language, generated.fliesenui.dto.OverviewParameterDTO parameter){
/*Generated! Do not modify!*/         AboutRequest resultInstance = new AboutRequest("widgetButtonBackButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static AboutRequest createOnLoadedRequest(String language, FLUIClientPropertiesDTO _ClientProperties, generated.fliesenui.dto.OverviewParameterDTO parameter){
/*Generated! Do not modify!*/         AboutRequest resultInstance = new AboutRequest("onLoaded", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("_ClientProperties", new Gson().toJson(_ClientProperties));
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static AboutRequest createOnBackPressedRequest(String language, generated.fliesenui.dto.OverviewParameterDTO parameter){
/*Generated! Do not modify!*/         AboutRequest resultInstance = new AboutRequest("onBackPressed", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static AboutRequest createOnInputDialogResultRequest(String language){
/*Generated! Do not modify!*/         AboutRequest resultInstance = new AboutRequest("onInputDialogResult", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static AboutRequest createOnConfirmDialogResultRequest(String language){
/*Generated! Do not modify!*/         AboutRequest resultInstance = new AboutRequest("onConfirmDialogResult", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static AboutRequest createOnListChooserResultRequest(String language){
/*Generated! Do not modify!*/         AboutRequest resultInstance = new AboutRequest("onListChooserResult", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }