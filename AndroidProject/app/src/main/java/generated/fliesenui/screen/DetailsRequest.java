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
/*Generated! Do not modify!*/ public class DetailsRequest implements FLUIScreenRequest{
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private FLUIRequest request = new FLUIRequest();
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private DetailsRequest(){
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIRequest getRequest() {
/*Generated! Do not modify!*/         return request;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private DetailsRequest(String actionName, String language){
/*Generated! Do not modify!*/         request = new FLUIRequest();
/*Generated! Do not modify!*/         request.setAction(actionName);
/*Generated! Do not modify!*/         request.setCurrentLanguage(language);
/*Generated! Do not modify!*/         request.setScreenID("details");
/*Generated! Do not modify!*/         request.setParameters(new TreeMap<String, Object>());
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsRequest createOnBackButtonClickedRequest(String language, generated.fliesenui.dto.DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         DetailsRequest resultInstance = new DetailsRequest("widgetButtonBackButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsRequest createOnEditTextButtonClickedRequest(String language, generated.fliesenui.dto.DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         DetailsRequest resultInstance = new DetailsRequest("widgetButtonEditTextButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsRequest createOnEditNameButtonClickedRequest(String language, generated.fliesenui.dto.DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         DetailsRequest resultInstance = new DetailsRequest("widgetButtonEditNameButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsRequest createOnDeleteButtonClickedRequest(String language, generated.fliesenui.dto.DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         DetailsRequest resultInstance = new DetailsRequest("widgetButtonDeleteButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsRequest createOnSaveNoteTextButtonClickedRequest(String language, generated.fliesenui.dto.DetailsParameterDTO parameter, String editNoteTextAreaText){
/*Generated! Do not modify!*/         DetailsRequest resultInstance = new DetailsRequest("widgetButtonSaveNoteTextButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("editNoteTextAreaText", editNoteTextAreaText);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsRequest createOnCancelEditNoteTextButtonClickedRequest(String language, generated.fliesenui.dto.DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         DetailsRequest resultInstance = new DetailsRequest("widgetButtonCancelEditNoteTextButtonClicked", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsRequest createOnAutosaveTimerRequest(String language, generated.fliesenui.dto.DetailsParameterDTO parameter, String editNoteTextAreaText, generated.fliesenui.dto.EditStateDTO editState){
/*Generated! Do not modify!*/         DetailsRequest resultInstance = new DetailsRequest("onAutosaveTimer", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("editNoteTextAreaText", editNoteTextAreaText);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("editState", new Gson().toJson(editState));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsRequest createOnColorSelectBoxChangedRequest(String language, String rowID, generated.fliesenui.dto.DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         DetailsRequest resultInstance = new DetailsRequest("onColorSelectBoxChanged", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("rowID", rowID);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsRequest createOnLoadedRequest(String language, FLUIClientPropertiesDTO _ClientProperties, generated.fliesenui.dto.DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         DetailsRequest resultInstance = new DetailsRequest("onLoaded", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("_ClientProperties", new Gson().toJson(_ClientProperties));
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsRequest createOnBackPressedRequest(String language, generated.fliesenui.dto.DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         DetailsRequest resultInstance = new DetailsRequest("onBackPressed", language);
/*Generated! Do not modify!*/         resultInstance.request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsRequest createOnInputDialogResultRequest(String language){
/*Generated! Do not modify!*/         DetailsRequest resultInstance = new DetailsRequest("onInputDialogResult", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsRequest createOnConfirmDialogResultRequest(String language){
/*Generated! Do not modify!*/         DetailsRequest resultInstance = new DetailsRequest("onConfirmDialogResult", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static DetailsRequest createOnListChooserResultRequest(String language){
/*Generated! Do not modify!*/         DetailsRequest resultInstance = new DetailsRequest("onListChooserResult", language);
/*Generated! Do not modify!*/         return resultInstance;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }