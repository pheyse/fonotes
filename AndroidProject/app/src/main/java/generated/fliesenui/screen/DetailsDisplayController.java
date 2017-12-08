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
/*Generated! Do not modify!*/ public class DetailsDisplayController implements FLUIDisplayController {
/*Generated! Do not modify!*/     private DetailsDisplay display;
/*Generated! Do not modify!*/     private Gson gson = new Gson();
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public DetailsDisplayController(DetailsDisplay display){
/*Generated! Do not modify!*/         this.display = display;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void processReply(FLUIReplyDTO reply){
/*Generated! Do not modify!*/         String stringValue;
/*Generated! Do not modify!*/         for (String i: reply.getVariablesToSet()){
/*Generated! Do not modify!*/             switch(i.trim()){
/*Generated! Do not modify!*/             case "details_backButton_propertyText":
/*Generated! Do not modify!*/                 display.setBackButtonText((String)reply.getVariableValues().get("details_backButton_propertyText"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_backButton_propertyVisible":
/*Generated! Do not modify!*/                 display.setBackButtonVisible((boolean)reply.getVariableValues().get("details_backButton_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_editTextButton_propertyText":
/*Generated! Do not modify!*/                 display.setEditTextButtonText((String)reply.getVariableValues().get("details_editTextButton_propertyText"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_editTextButton_propertyVisible":
/*Generated! Do not modify!*/                 display.setEditTextButtonVisible((boolean)reply.getVariableValues().get("details_editTextButton_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_editNameButton_propertyText":
/*Generated! Do not modify!*/                 display.setEditNameButtonText((String)reply.getVariableValues().get("details_editNameButton_propertyText"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_editNameButton_propertyVisible":
/*Generated! Do not modify!*/                 display.setEditNameButtonVisible((boolean)reply.getVariableValues().get("details_editNameButton_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_deleteButton_propertyText":
/*Generated! Do not modify!*/                 display.setDeleteButtonText((String)reply.getVariableValues().get("details_deleteButton_propertyText"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_deleteButton_propertyVisible":
/*Generated! Do not modify!*/                 display.setDeleteButtonVisible((boolean)reply.getVariableValues().get("details_deleteButton_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_menuButton_propertyText":
/*Generated! Do not modify!*/                 display.setMenuButtonText((String)reply.getVariableValues().get("details_menuButton_propertyText"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_menuButton_propertyVisible":
/*Generated! Do not modify!*/                 display.setMenuButtonVisible((boolean)reply.getVariableValues().get("details_menuButton_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_colorLabel_propertyText":
/*Generated! Do not modify!*/                 display.setColorLabelText((String)reply.getVariableValues().get("details_colorLabel_propertyText"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_colorLabel_propertyVisible":
/*Generated! Do not modify!*/                 display.setColorLabelVisible((boolean)reply.getVariableValues().get("details_colorLabel_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_noteNameLabel_propertyText":
/*Generated! Do not modify!*/                 display.setNoteNameLabelText((String)reply.getVariableValues().get("details_noteNameLabel_propertyText"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_noteNameLabel_propertyVisible":
/*Generated! Do not modify!*/                 display.setNoteNameLabelVisible((boolean)reply.getVariableValues().get("details_noteNameLabel_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_noteView_propertyText":
/*Generated! Do not modify!*/                 display.setNoteViewText((String)reply.getVariableValues().get("details_noteView_propertyText"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_noteView_propertyVisible":
/*Generated! Do not modify!*/                 display.setNoteViewVisible((boolean)reply.getVariableValues().get("details_noteView_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_saveNoteTextButton_propertyText":
/*Generated! Do not modify!*/                 display.setSaveNoteTextButtonText((String)reply.getVariableValues().get("details_saveNoteTextButton_propertyText"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_saveNoteTextButton_propertyVisible":
/*Generated! Do not modify!*/                 display.setSaveNoteTextButtonVisible((boolean)reply.getVariableValues().get("details_saveNoteTextButton_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_cancelEditNoteTextButton_propertyText":
/*Generated! Do not modify!*/                 display.setCancelEditNoteTextButtonText((String)reply.getVariableValues().get("details_cancelEditNoteTextButton_propertyText"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_cancelEditNoteTextButton_propertyVisible":
/*Generated! Do not modify!*/                 display.setCancelEditNoteTextButtonVisible((boolean)reply.getVariableValues().get("details_cancelEditNoteTextButton_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_editNoteTextArea_propertyText":
/*Generated! Do not modify!*/                 display.setEditNoteTextAreaText((String)reply.getVariableValues().get("details_editNoteTextArea_propertyText"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_editNoteTextArea_propertyVisible":
/*Generated! Do not modify!*/                 display.setEditNoteTextAreaVisible((boolean)reply.getVariableValues().get("details_editNoteTextArea_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_editNoteInfoLabel_propertyText":
/*Generated! Do not modify!*/                 display.setEditNoteInfoLabelText((String)reply.getVariableValues().get("details_editNoteInfoLabel_propertyText"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_editNoteInfoLabel_propertyVisible":
/*Generated! Do not modify!*/                 display.setEditNoteInfoLabelVisible((boolean)reply.getVariableValues().get("details_editNoteInfoLabel_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_colorBar_propertyVisible":
/*Generated! Do not modify!*/                 display.setColorBarVisible((boolean)reply.getVariableValues().get("details_colorBar_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_viewNoteName_propertyVisible":
/*Generated! Do not modify!*/                 display.setViewNoteNameVisible((boolean)reply.getVariableValues().get("details_viewNoteName_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_buttonBar_propertyVisible":
/*Generated! Do not modify!*/                 display.setButtonBarVisible((boolean)reply.getVariableValues().get("details_buttonBar_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_viewNotePanel_propertyVisible":
/*Generated! Do not modify!*/                 display.setViewNotePanelVisible((boolean)reply.getVariableValues().get("details_viewNotePanel_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_editNotePanel_propertyVisible":
/*Generated! Do not modify!*/                 display.setEditNotePanelVisible((boolean)reply.getVariableValues().get("details_editNotePanel_propertyVisible"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_autosaveTimer_active":
/*Generated! Do not modify!*/                 display.setAutosaveTimerActive((boolean)reply.getVariableValues().get("details_autosaveTimer_active"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_noteView_propertyBackgroundColor":
/*Generated! Do not modify!*/                 stringValue = (String)reply.getVariableValues().get("details_noteView_propertyBackgroundColor");
/*Generated! Do not modify!*/                 if ((stringValue != null) && (!stringValue.isEmpty()) && (stringValue.startsWith("background: "))){
/*Generated! Do not modify!*/                     stringValue = stringValue.substring(12);
/*Generated! Do not modify!*/                 }
/*Generated! Do not modify!*/                 display.setNoteViewBackgroundColor(stringValue);
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "details_editNoteTextArea_propertyBackgroundColor":
/*Generated! Do not modify!*/                 stringValue = (String)reply.getVariableValues().get("details_editNoteTextArea_propertyBackgroundColor");
/*Generated! Do not modify!*/                 if ((stringValue != null) && (!stringValue.isEmpty()) && (stringValue.startsWith("background: "))){
/*Generated! Do not modify!*/                     stringValue = stringValue.substring(12);
/*Generated! Do not modify!*/                 }
/*Generated! Do not modify!*/                 display.setEditNoteTextAreaBackgroundColor(stringValue);
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         for (String i: reply.getDTOsToSet()){
/*Generated! Do not modify!*/             switch(i.trim()){
/*Generated! Do not modify!*/             case "colors":
/*Generated! Do not modify!*/                 display.setColorsDTO((IdAndLabelListDTO)reply.getDTOValues().get("colors"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "editState":
/*Generated! Do not modify!*/                 display.setEditStateDTO((EditStateDTO)reply.getDTOValues().get("editState"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             case "parameter":
/*Generated! Do not modify!*/                 display.setParameterDTO((DetailsParameterDTO)reply.getDTOValues().get("parameter"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         for (String i: reply.getDTOsToSet()){
/*Generated! Do not modify!*/             switch(i.trim()){
/*Generated! Do not modify!*/             case "colors":
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/             case "editState":
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/             case "parameter":
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/              }
/*Generated! Do not modify!*/          }        for (String i: reply.getSelectBoxSelectedIDs().keySet()){
/*Generated! Do not modify!*/             switch(i.trim()){
/*Generated! Do not modify!*/             case "details_colorSelectBox_selectedItem":
/*Generated! Do not modify!*/                 display.setColorSelectBoxSelectedID((String)reply.getSelectBoxSelectedIDs().get("details_colorSelectBox_selectedItem"));
/*Generated! Do not modify!*/                 break;
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
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