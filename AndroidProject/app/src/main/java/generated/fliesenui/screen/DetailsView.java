/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import java.util.Map;
/*Generated! Do not modify!*/ import com.google.gson.Gson;
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIScreen;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIRequest;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIAbstractReply;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIString.StringLanguage;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIUtil;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIClientPropertiesDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.dto.IdAndLabelListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.EditStateDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.DetailsParameterDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class DetailsView implements FLUIScreen {
/*Generated! Do not modify!*/     private DetailsListener listener;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public DetailsView(DetailsListener listener) {
/*Generated! Do not modify!*/         this.listener = listener;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public FLUIAbstractReply onFLUIRequest(boolean recordMode, FLUIRequest request, String uploadedFileName, InputStream uploadedFileInputStream) throws Exception{
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
/*Generated! Do not modify!*/         } else if ("widgetButtonEditNameButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onEditNameButtonClicked(reply, gson.fromJson((String)parameters.get("parameter"), DetailsParameterDTO.class));
/*Generated! Do not modify!*/         } else if ("widgetButtonEditTextButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onEditTextButtonClicked(reply, gson.fromJson((String)parameters.get("parameter"), DetailsParameterDTO.class));
/*Generated! Do not modify!*/         } else if ("widgetButtonDeleteButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onDeleteButtonClicked(reply, gson.fromJson((String)parameters.get("parameter"), DetailsParameterDTO.class));
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
/*Generated! Do not modify!*/             listener.onInputDialogResult(reply, (String)parameters.get("referenceID"), (String)parameters.get("result"));
/*Generated! Do not modify!*/         } else if ("onConfirmDialogResult".equals(action)) {
/*Generated! Do not modify!*/             listener.onConfirmDialogResult(reply, (String)parameters.get("referenceID"), (boolean)parameters.get("result"));
/*Generated! Do not modify!*/         } else if ("onListChooserResult".equals(action)) {
/*Generated! Do not modify!*/             listener.onListChooserResult(reply, (String)parameters.get("referenceID"), (java.util.List<String>)parameters.get("selectedIDs"));
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return reply;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public String getID() {
/*Generated! Do not modify!*/         return "details";
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ }