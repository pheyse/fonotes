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
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewParameterDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class OverviewView implements FLUIScreen {
/*Generated! Do not modify!*/     private OverviewListener listener;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public OverviewView(OverviewListener listener) {
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
/*Generated! Do not modify!*/         OverviewReply reply = new OverviewReply(recordMode, currentLanguage);
/*Generated! Do not modify!*/         if ("widgetButtonMenuButtonClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onMenuButtonClicked(reply, gson.fromJson((String)parameters.get("parameter"), OverviewParameterDTO.class));
/*Generated! Do not modify!*/         } else if ("onNotesTableRowClicked".equals(action)) {
/*Generated! Do not modify!*/             listener.onNotesTableRowClicked(reply, (String)parameters.get("rowID"), gson.fromJson((String)parameters.get("parameter"), OverviewParameterDTO.class));
/*Generated! Do not modify!*/         } else if ("onLoaded".equals(action)) {
/*Generated! Do not modify!*/             listener.onLoaded(reply, gson.fromJson((String)parameters.get("_ClientProperties"), FLUIClientPropertiesDTO.class), gson.fromJson((String)parameters.get("parameter"), OverviewParameterDTO.class));
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
/*Generated! Do not modify!*/         return "overview";
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ }