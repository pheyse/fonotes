/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIClientPropertiesDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIScreenManagerInterface;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIRequest;
/*Generated! Do not modify!*/ import generated.fliesenui.core.ConfirmDialogParameters;
/*Generated! Do not modify!*/ import generated.fliesenui.core.InputDialogParameters;
/*Generated! Do not modify!*/ import generated.fliesenui.core.ListChooserParameters;
/*Generated! Do not modify!*/ import java.util.List;
/*Generated! Do not modify!*/ import java.util.TreeMap;
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ import com.google.gson.Gson;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.DetailsParameterDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.DetailsParameterListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.EditStateDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.EditStateListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.IdAndLabelDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.IdAndLabelListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.IdAndLabelListListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewItemDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewItemListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewListListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewParameterDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewParameterListDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class DetailsDisplayEventHandler{
/*Generated! Do not modify!*/     private FLUIScreenManagerInterface screenManager;
/*Generated! Do not modify!*/     private String currentLanguage;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public DetailsDisplayEventHandler(FLUIScreenManagerInterface screenManager){
/*Generated! Do not modify!*/         this.screenManager = screenManager;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private FLUIRequest createRequest(String action){
/*Generated! Do not modify!*/         FLUIRequest result = new FLUIRequest();
/*Generated! Do not modify!*/         result.setScreenID("details");
/*Generated! Do not modify!*/         result.setCurrentLanguage(currentLanguage);
/*Generated! Do not modify!*/         result.setAction(action);
/*Generated! Do not modify!*/         result.setParameters(new TreeMap<String, Object>());
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setCurrentLanguage(String currentLanguage){
/*Generated! Do not modify!*/         this.currentLanguage = currentLanguage;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onLoaded(FLUIClientPropertiesDTO clientProperties, DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         FLUIRequest request = createRequest("onLoaded");
/*Generated! Do not modify!*/         request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         request.getParameters().put("_ClientProperties", new Gson().toJson(clientProperties));
/*Generated! Do not modify!*/         String requestJSON = new Gson().toJson(request);
/*Generated! Do not modify!*/         screenManager.onRequest(requestJSON, null, null);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onBackButtonClicked(DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         FLUIRequest request = createRequest("widgetButtonBackButtonClicked");
/*Generated! Do not modify!*/         request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         screenManager.onRequest(new Gson().toJson(request), null, null);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onEditTextButtonClicked(DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         FLUIRequest request = createRequest("widgetButtonEditTextButtonClicked");
/*Generated! Do not modify!*/         request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         screenManager.onRequest(new Gson().toJson(request), null, null);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onEditNameButtonClicked(DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         FLUIRequest request = createRequest("widgetButtonEditNameButtonClicked");
/*Generated! Do not modify!*/         request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         screenManager.onRequest(new Gson().toJson(request), null, null);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onDeleteButtonClicked(DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         FLUIRequest request = createRequest("widgetButtonDeleteButtonClicked");
/*Generated! Do not modify!*/         request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         screenManager.onRequest(new Gson().toJson(request), null, null);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onSaveNoteTextButtonClicked(DetailsParameterDTO parameter, String editNoteTextAreaText){
/*Generated! Do not modify!*/         FLUIRequest request = createRequest("widgetButtonSaveNoteTextButtonClicked");
/*Generated! Do not modify!*/         request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         request.getParameters().put("editNoteTextAreaText", editNoteTextAreaText);
/*Generated! Do not modify!*/         screenManager.onRequest(new Gson().toJson(request), null, null);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onCancelEditNoteTextButtonClicked(DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         FLUIRequest request = createRequest("widgetButtonCancelEditNoteTextButtonClicked");
/*Generated! Do not modify!*/         request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         screenManager.onRequest(new Gson().toJson(request), null, null);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onColorSelectBoxChanged(String selectedID, DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         FLUIRequest request = createRequest("onColorSelectBoxChanged");
/*Generated! Do not modify!*/         request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         request.getParameters().put("rowID", selectedID);
/*Generated! Do not modify!*/         screenManager.onRequest(new Gson().toJson(request), null, null);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onAutosaveTimer(DetailsParameterDTO parameter, String editNoteTextAreaText, EditStateDTO editState){
/*Generated! Do not modify!*/         FLUIRequest request = createRequest("onAutosaveTimer");
/*Generated! Do not modify!*/         request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         request.getParameters().put("editNoteTextAreaText", editNoteTextAreaText);
/*Generated! Do not modify!*/         request.getParameters().put("editState", new Gson().toJson(editState));
/*Generated! Do not modify!*/         screenManager.onRequest(new Gson().toJson(request), null, null);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onBackPressed(DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         FLUIRequest request = createRequest("onBackPressed");
/*Generated! Do not modify!*/         request.getParameters().put("parameter", new Gson().toJson(parameter));
/*Generated! Do not modify!*/         screenManager.onRequest(new Gson().toJson(request), null, null);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onInputDialogResult(InputDialogParameters parameters, String result){
/*Generated! Do not modify!*/         FLUIRequest request = createRequest("onInputDialogResult");
/*Generated! Do not modify!*/         request.getParameters().put("callbackData", parameters.getCallbackData());
/*Generated! Do not modify!*/         request.getParameters().put("referenceID", parameters.getReferenceID());
/*Generated! Do not modify!*/         request.getParameters().put("result", result);
/*Generated! Do not modify!*/         String requestJSON = new Gson().toJson(request);
/*Generated! Do not modify!*/         screenManager.onRequest(requestJSON, null, null);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onConfirmDialogResult(ConfirmDialogParameters parameters, boolean result){
/*Generated! Do not modify!*/         FLUIRequest request = createRequest("onConfirmDialogResult");
/*Generated! Do not modify!*/         request.getParameters().put("callbackData", parameters.getCallbackData());
/*Generated! Do not modify!*/         request.getParameters().put("referenceID", parameters.getReferenceID());
/*Generated! Do not modify!*/         request.getParameters().put("result", result);
/*Generated! Do not modify!*/         String requestJSON = new Gson().toJson(request);
/*Generated! Do not modify!*/         screenManager.onRequest(requestJSON, null, null);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onListChooserResult(ListChooserParameters parameters, List<String> selectedIDs){
/*Generated! Do not modify!*/         FLUIRequest request = createRequest("onListChooserResult");
/*Generated! Do not modify!*/         request.getParameters().put("callbackData", parameters.getCallbackData());
/*Generated! Do not modify!*/         request.getParameters().put("referenceID", parameters.getReferenceID());
/*Generated! Do not modify!*/         request.getParameters().put("selectedIDs", selectedIDs);
/*Generated! Do not modify!*/         String requestJSON = new Gson().toJson(request);
/*Generated! Do not modify!*/         screenManager.onRequest(requestJSON, null, null);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }