/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import java.util.Map;
/*Generated! Do not modify!*/ import com.google.gson.Gson;
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIScreen;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIRequest;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIAbstractReply;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIScreenManagerInterface;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIString.StringLanguage;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIUtil;
/*Generated! Do not modify!*/ import generated.fliesenui.core.CallbackMethodCall;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIOpenScreenException;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIClientPropertiesDTO;
/*Generated! Do not modify!*/ 
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
/*Generated! Do not modify!*/ public class DetailsView implements FLUIScreen {
/*Generated! Do not modify!*/     private DetailsListener listener;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public DetailsView(DetailsListener listener) {
/*Generated! Do not modify!*/         this.listener = listener;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIAbstractReply onFLUIRequest(FLUIScreenManagerInterface manager, boolean recordMode, FLUIRequest request, String uploadedFileName, InputStream uploadedFileInputStream) throws Exception{
/*Generated! Do not modify!*/         Map<String, Object> parameters = request.getParameters();
/*Generated! Do not modify!*/         String action = request.getAction();
/*Generated! Do not modify!*/         StringLanguage currentLanguage = null;
/*Generated! Do not modify!*/         try{
/*Generated! Do not modify!*/             currentLanguage = StringLanguage.valueOf(request.getCurrentLanguage());
/*Generated! Do not modify!*/         } catch (Exception ignored){
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         Gson gson = new Gson();
/*Generated! Do not modify!*/         DetailsReply reply = new DetailsReply(recordMode, currentLanguage);
/*Generated! Do not modify!*/         if ("widgetButtonBackButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onBackButtonClicked(reply, gson.fromJson((String)parameters.get("parameter"), DetailsParameterDTO.class));
/*Generated! Do not modify!*/         } else if ("widgetButtonEditTextButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onEditTextButtonClicked(reply, gson.fromJson((String)parameters.get("parameter"), DetailsParameterDTO.class));
/*Generated! Do not modify!*/         } else if ("widgetButtonEditNameButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onEditNameButtonClicked(reply, gson.fromJson((String)parameters.get("parameter"), DetailsParameterDTO.class));
/*Generated! Do not modify!*/         } else if ("widgetButtonDeleteButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onDeleteButtonClicked(reply, gson.fromJson((String)parameters.get("parameter"), DetailsParameterDTO.class));
/*Generated! Do not modify!*/         } else if ("widgetButtonMenuButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onMenuButtonClicked(reply, gson.fromJson((String)parameters.get("parameter"), DetailsParameterDTO.class));
/*Generated! Do not modify!*/         } else if ("widgetButtonSaveNoteTextButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onSaveNoteTextButtonClicked(reply, gson.fromJson((String)parameters.get("parameter"), DetailsParameterDTO.class), (String)parameters.get("editNoteTextAreaText"));
/*Generated! Do not modify!*/         } else if ("widgetButtonCancelEditNoteTextButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onCancelEditNoteTextButtonClicked(reply, gson.fromJson((String)parameters.get("parameter"), DetailsParameterDTO.class));
/*Generated! Do not modify!*/         } else if ("onAutosaveTimer".equals(action)) {
/*Generated! Do not modify!*/             listener.onAutosaveTimer(reply, gson.fromJson((String)parameters.get("parameter"), DetailsParameterDTO.class), (String)parameters.get("editNoteTextAreaText"), gson.fromJson((String)parameters.get("editState"), EditStateDTO.class));
/*Generated! Do not modify!*/         } else if ("onColorSelectBoxChanged".equals(action)) {
/*Generated! Do not modify!*/             listener.onColorSelectBoxChanged(reply, (String)parameters.get("rowID"), gson.fromJson((String)parameters.get("parameter"), DetailsParameterDTO.class));
/*Generated! Do not modify!*/         } else if ("onLoaded".equals(action)) {
/*Generated! Do not modify!*/             listener.onLoaded(reply, gson.fromJson((String)parameters.get("_ClientProperties"), FLUIClientPropertiesDTO.class), gson.fromJson((String)parameters.get("parameter"), DetailsParameterDTO.class));
/*Generated! Do not modify!*/         } else if ("onBackPressed".equals(action)) {
/*Generated! Do not modify!*/             listener.onBackPressed(reply, gson.fromJson((String)parameters.get("parameter"), DetailsParameterDTO.class));
/*Generated! Do not modify!*/         } else if ("onInputDialogResult".equals(action)) {
/*Generated! Do not modify!*/             onStringInputDialogResult(reply, action, parameters);
/*Generated! Do not modify!*/         } else if ("onConfirmDialogResult".equals(action)) {
/*Generated! Do not modify!*/             onConfirmDialogResult(reply, action, parameters);
/*Generated! Do not modify!*/         } else if ("onListChooserResult".equals(action)) {
/*Generated! Do not modify!*/             onListChooserDialogResult(reply, action, parameters);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return reply;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private void onConfirmDialogResult(DetailsReply reply, String action, Map<String, Object> parameters){
/*Generated! Do not modify!*/         String callbackDataString = (String)parameters.get("callbackData");
/*Generated! Do not modify!*/         String referenceID = (String)parameters.get("referenceID");
/*Generated! Do not modify!*/         boolean result = (boolean)parameters.get("result");
/*Generated! Do not modify!*/         if (callbackDataString == null){
/*Generated! Do not modify!*/             listener.onConfirmDialogResult(reply, referenceID, result);
/*Generated! Do not modify!*/             return;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         Gson gson = new Gson();
/*Generated! Do not modify!*/         CallbackMethodCall callback = gson.fromJson(callbackDataString, CallbackMethodCall.class);
/*Generated! Do not modify!*/         Map<String, Object> callbackMethodParameters = callback.getParameterValues();
/*Generated! Do not modify!*/         switch (callback.getCallbackMethodIndex()) {
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     
/*Generated! Do not modify!*/     private void onStringInputDialogResult(DetailsReply reply, String action, Map<String, Object> parameters){
/*Generated! Do not modify!*/         String callbackDataString = (String)parameters.get("callbackData");
/*Generated! Do not modify!*/         String referenceID = (String)parameters.get("referenceID");
/*Generated! Do not modify!*/         String result = (String)parameters.get("result");
/*Generated! Do not modify!*/         if (callbackDataString == null){
/*Generated! Do not modify!*/             listener.onInputDialogResult(reply, referenceID, result);
/*Generated! Do not modify!*/             return;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         Gson gson = new Gson();
/*Generated! Do not modify!*/         CallbackMethodCall callback = gson.fromJson(callbackDataString, CallbackMethodCall.class);
/*Generated! Do not modify!*/         Map<String, Object> callbackMethodParameters = callback.getParameterValues();
/*Generated! Do not modify!*/         switch (callback.getCallbackMethodIndex()) {
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     
/*Generated! Do not modify!*/     private void onListChooserDialogResult(DetailsReply reply, String action, Map<String, Object> parameters){
/*Generated! Do not modify!*/         String callbackDataString = (String)parameters.get("callbackData");
/*Generated! Do not modify!*/         String referenceID = (String)parameters.get("referenceID");
/*Generated! Do not modify!*/         java.util.List<String> result = (java.util.List<String>)parameters.get("selectedIDs");
/*Generated! Do not modify!*/         if (callbackDataString == null){
/*Generated! Do not modify!*/             listener.onListChooserResult(reply, referenceID, result);
/*Generated! Do not modify!*/             return;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         Gson gson = new Gson();
/*Generated! Do not modify!*/         CallbackMethodCall callback = gson.fromJson(callbackDataString, CallbackMethodCall.class);
/*Generated! Do not modify!*/         Map<String, Object> callbackMethodParameters = callback.getParameterValues();
/*Generated! Do not modify!*/         switch (callback.getCallbackMethodIndex()) {
/*Generated! Do not modify!*/         case 0:
/*Generated! Do not modify!*/             listener.onListChooserMenu(reply, result, gson.fromJson((String)callbackMethodParameters.get("parameter"), DetailsParameterDTO.class));
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public String getID() {
/*Generated! Do not modify!*/         return "details";
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     private void setOpenScreen(DetailsReply reply, FLUIOpenScreenException exception){
/*Generated! Do not modify!*/         switch (exception.getScreenID()) {
/*Generated! Do not modify!*/         case "about":
/*Generated! Do not modify!*/             reply.openScreenAbout((OverviewParameterDTO)exception.getParameterDTO());
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "details":
/*Generated! Do not modify!*/             reply.openScreenDetails((DetailsParameterDTO)exception.getParameterDTO());
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "login":
/*Generated! Do not modify!*/             reply.openScreenLogin();
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "markdownHelp":
/*Generated! Do not modify!*/             reply.openScreenMarkdownHelp((OverviewParameterDTO)exception.getParameterDTO());
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "overview":
/*Generated! Do not modify!*/             reply.openScreenOverview((OverviewParameterDTO)exception.getParameterDTO());
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ }