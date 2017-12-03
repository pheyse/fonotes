/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIString.StringLanguage;
/*Generated! Do not modify!*/ import com.google.gson.Gson;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.CallbackMethodCall;
/*Generated! Do not modify!*/ import generated.fliesenui.core.TextHighlighting;
/*Generated! Do not modify!*/ import generated.fliesenui.core.CursorPos;
/*Generated! Do not modify!*/ import generated.fliesenui.core.ContextAssist;
/*Generated! Do not modify!*/ import generated.fliesenui.core.IDLabelImageAssetList;
/*Generated! Do not modify!*/ import generated.fliesenui.core.IDLabelList;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIReplyAction.ReplyActionType;
/*Generated! Do not modify!*/ import generated.fliesenui.core.InputDialogParameters;
/*Generated! Do not modify!*/ import generated.fliesenui.core.ConfirmDialogParameters;
/*Generated! Do not modify!*/ import generated.fliesenui.core.ListChooserParameters;
/*Generated! Do not modify!*/ import generated.fliesenui.core.IDLabel;
/*Generated! Do not modify!*/ import generated.fliesenui.core.IDLabelImageAsset;
/*Generated! Do not modify!*/ import generated.fliesenui.core.ListChooserItem;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIReplyDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIDisplayController;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIImageAssets.ImageAsset;
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
/*Generated! Do not modify!*/ import generated.fliesenui.dto.DetailsParameterDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.DetailsParameterListDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.EditStateDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.EditStateListDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.IdAndLabelDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.IdAndLabelListDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.IdAndLabelListListDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewItemDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewItemListDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewListDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewListListDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewParameterDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewParameterListDTOBuilder;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class AboutDisplayController implements FLUIDisplayController {
/*Generated! Do not modify!*/     private AboutDisplay display;
/*Generated! Do not modify!*/     private Gson gson = new Gson();
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public AboutDisplayController(AboutDisplay display){
/*Generated! Do not modify!*/         this.display = display;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void processReply(FLUIReplyDTO reply){
/*Generated! Do not modify!*/         String stringValue;
/*Generated! Do not modify!*/         for (String i: reply.getVariablesToSet()){
/*Generated! Do not modify!*/             switch(i.trim()){
/*Generated! Do not modify!*/             case "about_backButton_propertyText":
/*Generated! Do not modify!*/                 display.setBackButtonText((String)reply.getVariableValues().get("about_backButton_propertyText"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "about_backButton_propertyVisible":
/*Generated! Do not modify!*/                 display.setBackButtonVisible((boolean)reply.getVariableValues().get("about_backButton_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "about_info_propertyText":
/*Generated! Do not modify!*/                 display.setInfoText((String)reply.getVariableValues().get("about_info_propertyText"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "about_info_propertyVisible":
/*Generated! Do not modify!*/                 display.setInfoVisible((boolean)reply.getVariableValues().get("about_info_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "about_aboutText_propertyText":
/*Generated! Do not modify!*/                 display.setAboutTextText((String)reply.getVariableValues().get("about_aboutText_propertyText"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "about_aboutText_propertyVisible":
/*Generated! Do not modify!*/                 display.setAboutTextVisible((boolean)reply.getVariableValues().get("about_aboutText_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "about_aboutText_propertyBackgroundColor":
/*Generated! Do not modify!*/                 stringValue = (String)reply.getVariableValues().get("about_aboutText_propertyBackgroundColor");
/*Generated! Do not modify!*/                 if ((stringValue != null) && (!stringValue.isEmpty()) && (stringValue.startsWith("background: "))){
/*Generated! Do not modify!*/                     stringValue = stringValue.substring(12);
/*Generated! Do not modify!*/                 }
/*Generated! Do not modify!*/                 display.setAboutTextBackgroundColor(stringValue);
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         for (String i: reply.getDTOsToSet()){
/*Generated! Do not modify!*/             switch(i.trim()){
/*Generated! Do not modify!*/             case "parameter":
/*Generated! Do not modify!*/                 display.setParameterDTO((OverviewParameterDTO)reply.getDTOValues().get("parameter"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         for (String i: reply.getDTOsToSet()){
/*Generated! Do not modify!*/             switch(i.trim()){
/*Generated! Do not modify!*/             case "parameter":
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/              }
/*Generated! Do not modify!*/          }
/*Generated! Do not modify!*/         if (reply.getMessage() != null){
/*Generated! Do not modify!*/             display.showMessage(reply.getMessage());
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         if (reply.getInputDialogParameters() != null){
/*Generated! Do not modify!*/             display.showInputDialog(reply.getInputDialogParameters());
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (reply.getConfirmDialogParameters() != null){
/*Generated! Do not modify!*/             display.showConfirmDialog(reply.getConfirmDialogParameters());
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (reply.getListChooserParameters() != null){
/*Generated! Do not modify!*/             display.showListChooser(reply.getListChooserParameters());
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         if (reply.getScreenToOpen() != null){
/*Generated! Do not modify!*/             openScreen(reply.getScreenToOpen(), reply.getOpenParameter());
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private CallbackMethodCall readCallbackMethodCall(String callbackDataJSON) {
/*Generated! Do not modify!*/         if (callbackDataJSON == null){
/*Generated! Do not modify!*/             return null;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return gson.fromJson(callbackDataJSON, CallbackMethodCall.class);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private void openScreen(String screenToOpen, Object openParameter) {
/*Generated! Do not modify!*/         switch (screenToOpen){
/*Generated! Do not modify!*/             case "about":
/*Generated! Do not modify!*/                 display.openScreenAbout((OverviewParameterDTO)openParameter);
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details":
/*Generated! Do not modify!*/                 display.openScreenDetails((DetailsParameterDTO)openParameter);
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "login":
/*Generated! Do not modify!*/                 display.openScreenLogin();
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "markdownHelp":
/*Generated! Do not modify!*/                 display.openScreenMarkdownHelp((OverviewParameterDTO)openParameter);
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "overview":
/*Generated! Do not modify!*/                 display.openScreenOverview((OverviewParameterDTO)openParameter);
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }