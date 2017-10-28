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
/*Generated! Do not modify!*/ public class LoginRequest implements FLUIScreenRequest{
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private FLUIRequest request = new FLUIRequest();
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private LoginRequest(){
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIRequest getRequest() {
/*Generated! Do not modify!*/         return request;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private LoginRequest(String actionName, String language){
/*Generated! Do not modify!*/         request = new FLUIRequest();
/*Generated! Do not modify!*/         request.setAction(actionName);
/*Generated! Do not modify!*/         request.setCurrentLanguage(language);
/*Generated! Do not modify!*/         request.setScreenID("login");
/*Generated! Do not modify!*/         request.setParameters(new TreeMap<String, Object>());
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static LoginRequest createOnLoginButtonClickedRequest(String language, String passwordTextFieldText){
/*Generated! Do not modify!*/         LoginRequest resultInstance = new LoginRequest("widgetButtonLoginButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("passwordTextFieldText", passwordTextFieldText);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static LoginRequest createOnLoadedRequest(String language, FLUIClientPropertiesDTO _ClientProperties){
/*Generated! Do not modify!*/         LoginRequest resultInstance = new LoginRequest("onLoaded", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("_ClientProperties", new Gson().toJson(_ClientProperties));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static LoginRequest createOnInputDialogResultRequest(String language){
/*Generated! Do not modify!*/         LoginRequest resultInstance = new LoginRequest("onInputDialogResult", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static LoginRequest createOnConfirmDialogResultRequest(String language){
/*Generated! Do not modify!*/         LoginRequest resultInstance = new LoginRequest("onConfirmDialogResult", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static LoginRequest createOnListChooserResultRequest(String language){
/*Generated! Do not modify!*/         LoginRequest resultInstance = new LoginRequest("onListChooserResult", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }