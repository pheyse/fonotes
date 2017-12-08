/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import java.util.List;
/*Generated! Do not modify!*/ import java.util.Collection;
/*Generated! Do not modify!*/ import java.util.TreeSet;
/*Generated! Do not modify!*/ import java.util.Set;
/*Generated! Do not modify!*/ import java.util.ArrayList;
/*Generated! Do not modify!*/ import java.util.HashSet;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIAbstractReply;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIUtil;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIString.StringLanguage;
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
/*Generated! Do not modify!*/ import generated.fliesenui.core.BrightMarkdown;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIMarkdownFormatting;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIImageAssets.ImageAsset;
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
/*Generated! Do not modify!*/ public class DetailsReply extends FLUIAbstractReply implements CommonSharedReply {
/*Generated! Do not modify!*/     public DetailsReply(boolean recordMode, StringLanguage currentLanguage) {
/*Generated! Do not modify!*/         super(recordMode, currentLanguage);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     protected String getJSON() {
/*Generated! Do not modify!*/         return gson.toJson(replyDTO);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setBackButtonText(String text){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_backButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("details_backButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("details_backButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setBackButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setBackButtonVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_backButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_backButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setBackButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setEditTextButtonText(String text){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_editTextButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("details_editTextButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("details_editTextButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setEditTextButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setEditTextButtonVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_editTextButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_editTextButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setEditTextButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setEditNameButtonText(String text){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_editNameButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("details_editNameButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("details_editNameButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setEditNameButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setEditNameButtonVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_editNameButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_editNameButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setEditNameButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setDeleteButtonText(String text){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_deleteButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("details_deleteButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("details_deleteButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setDeleteButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setDeleteButtonVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_deleteButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_deleteButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setDeleteButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setMenuButtonText(String text){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_menuButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("details_menuButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("details_menuButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setMenuButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setMenuButtonVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_menuButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_menuButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setMenuButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setColorLabelText(String text){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_colorLabel_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("details_colorLabel_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("details_colorLabel_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setColorLabelText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setColorLabelVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_colorLabel_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_colorLabel_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setColorLabelVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setNoteNameLabelText(String text){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_noteNameLabel_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("details_noteNameLabel_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("details_noteNameLabel_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setNoteNameLabelText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setNoteNameLabelVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_noteNameLabel_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_noteNameLabel_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setNoteNameLabelVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setNoteViewText(String text){
/*Generated! Do not modify!*/         setNoteViewText(text, null);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setNoteViewText(String text, FLUIMarkdownFormatting formatting){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_noteView_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getMarkdownViewTexts().remove("noteView");
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("details_noteView_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             String html = "";
/*Generated! Do not modify!*/             try{
/*Generated! Do not modify!*/                 BrightMarkdown markdown = new BrightMarkdown();
/*Generated! Do not modify!*/                 FLUIUtil.applyFormatting(markdown, formatting);
/*Generated! Do not modify!*/                 html = markdown.createHTML(text);
/*Generated! Do not modify!*/             } catch (Exception e){
/*Generated! Do not modify!*/                 html = "<html><body><p>Error: " + e + "</p><p>text:</p><pre>" + text + "</pre></body></html>";
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/             replyDTO.getMarkdownViewTexts().put("noteView", html);
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("details_noteView_propertyText", html);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setNoteViewText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setNoteViewVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_noteView_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_noteView_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setNoteViewVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ /** @param color background color in format '#aabbcc' or null for transparent/default */
/*Generated! Do not modify!*/     public void setNoteViewBackgroundColor(String color){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_noteView_propertyBackgroundColor");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_noteView_propertyBackgroundColor", color == null ? "" : "background: " + color);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setNoteViewBackgroundColor(" + escapeString(color) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSaveNoteTextButtonText(String text){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_saveNoteTextButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("details_saveNoteTextButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("details_saveNoteTextButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setSaveNoteTextButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setSaveNoteTextButtonVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_saveNoteTextButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_saveNoteTextButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setSaveNoteTextButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setCancelEditNoteTextButtonText(String text){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_cancelEditNoteTextButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("details_cancelEditNoteTextButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("details_cancelEditNoteTextButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setCancelEditNoteTextButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setCancelEditNoteTextButtonVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_cancelEditNoteTextButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_cancelEditNoteTextButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setCancelEditNoteTextButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setEditNoteTextAreaText(String text){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_editNoteTextArea_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("details_editNoteTextArea_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("details_editNoteTextArea_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setEditNoteTextAreaText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setEditNoteTextAreaCursorPos(int pos){
/*Generated! Do not modify!*/         CursorPos cursorPos = new CursorPos();
/*Generated! Do not modify!*/         cursorPos.setPos(pos);
/*Generated! Do not modify!*/         replyDTO.getCursorPosValues().put("details_editNoteTextArea", cursorPos);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setEditNoteTextAreaCursorPos(" + pos + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setEditNoteTextAreaVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_editNoteTextArea_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_editNoteTextArea_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setEditNoteTextAreaVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ /** @param color background color in format '#aabbcc' or null for transparent/default */
/*Generated! Do not modify!*/     public void setEditNoteTextAreaBackgroundColor(String color){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_editNoteTextArea_propertyBackgroundColor");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_editNoteTextArea_propertyBackgroundColor", color == null ? "" : "background: " + color);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setEditNoteTextAreaBackgroundColor(" + escapeString(color) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setEditNoteInfoLabelText(String text){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_editNoteInfoLabel_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("details_editNoteInfoLabel_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("details_editNoteInfoLabel_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setEditNoteInfoLabelText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setEditNoteInfoLabelVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_editNoteInfoLabel_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_editNoteInfoLabel_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setEditNoteInfoLabelVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setColorBarVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_colorBar_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_colorBar_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setColorBarVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setViewNoteNameVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_viewNoteName_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_viewNoteName_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setViewNoteNameVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setButtonBarVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_buttonBar_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_buttonBar_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setButtonBarVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setViewNotePanelVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_viewNotePanel_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_viewNotePanel_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setViewNotePanelVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setEditNotePanelVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_editNotePanel_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_editNotePanel_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setEditNotePanelVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setBackButtonImageAsset(ImageAsset imageAsset){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_backButton_propertyImageSource");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_backButton_propertyImageSource", imageAsset.getFilename());
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.SET_IMAGE_ASSET, "setBackButtonImageAsset(", imageAsset);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setDeleteButtonImageAsset(ImageAsset imageAsset){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_deleteButton_propertyImageSource");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_deleteButton_propertyImageSource", imageAsset.getFilename());
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.SET_IMAGE_ASSET, "setDeleteButtonImageAsset(", imageAsset);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setMenuButtonImageAsset(ImageAsset imageAsset){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_menuButton_propertyImageSource");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_menuButton_propertyImageSource", imageAsset.getFilename());
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.SET_IMAGE_ASSET, "setMenuButtonImageAsset(", imageAsset);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setAutosaveTimerActive(boolean active){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("details_autosaveTimer_active");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("details_autosaveTimer_active", active);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setAutosaveTimerActive(" + active + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setColorsDTO(IdAndLabelListDTO dto){
/*Generated! Do not modify!*/         replyDTO.getDTOsToSet().add("colors");
/*Generated! Do not modify!*/         if (dto == null){
/*Generated! Do not modify!*/             replyDTO.getDTOValues().remove("colors");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getDTOValues().put("colors", dto);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.SET_DTO, "setColorsDTO(", gson.toJson(dto), getClassName(dto));
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setEditStateDTO(EditStateDTO dto){
/*Generated! Do not modify!*/         replyDTO.getDTOsToSet().add("editState");
/*Generated! Do not modify!*/         if (dto == null){
/*Generated! Do not modify!*/             replyDTO.getDTOValues().remove("editState");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getDTOValues().put("editState", dto);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.SET_DTO, "setEditStateDTO(", gson.toJson(dto), getClassName(dto));
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setParameterDTO(DetailsParameterDTO dto){
/*Generated! Do not modify!*/         replyDTO.getDTOsToSet().add("parameter");
/*Generated! Do not modify!*/         if (dto == null){
/*Generated! Do not modify!*/             replyDTO.getDTOValues().remove("parameter");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getDTOValues().put("parameter", dto);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.SET_DTO, "setParameterDTO(", gson.toJson(dto), getClassName(dto));
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setColorSelectBoxSelectedID(String selectedID){
/*Generated! Do not modify!*/         replyDTO.getSelectBoxSelectedIDs().put("details_colorSelectBox_selectedItem", selectedID);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setColorSelectBoxSelectedID(" + escapeString(selectedID) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     public void openScreenAbout(OverviewParameterDTO parameter){
/*Generated! Do not modify!*/         replyDTO.setOpenParameter(parameter);
/*Generated! Do not modify!*/         replyDTO.setScreenToOpen("about");
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.OPEN_SCREEN, "openScreenAbout(", gson.toJson(parameter), getClassName(parameter));
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openScreenDetails(DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         replyDTO.setOpenParameter(parameter);
/*Generated! Do not modify!*/         replyDTO.setScreenToOpen("details");
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.OPEN_SCREEN, "openScreenDetails(", gson.toJson(parameter), getClassName(parameter));
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openScreenLogin(){
/*Generated! Do not modify!*/         replyDTO.setScreenToOpen("login");
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.OPEN_SCREEN, "openScreenLogin(");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openScreenMarkdownHelp(OverviewParameterDTO parameter){
/*Generated! Do not modify!*/         replyDTO.setOpenParameter(parameter);
/*Generated! Do not modify!*/         replyDTO.setScreenToOpen("markdownHelp");
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.OPEN_SCREEN, "openScreenMarkdownHelp(", gson.toJson(parameter), getClassName(parameter));
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openScreenOverview(OverviewParameterDTO parameter){
/*Generated! Do not modify!*/         replyDTO.setOpenParameter(parameter);
/*Generated! Do not modify!*/         replyDTO.setScreenToOpen("overview");
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.OPEN_SCREEN, "openScreenOverview(", gson.toJson(parameter), getClassName(parameter));
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openScreenAbout(String password) {
/*Generated! Do not modify!*/         openScreenAbout(OverviewParameterDTOBuilder.construct(password));
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openScreenDetails(String noteName, String password) {
/*Generated! Do not modify!*/         openScreenDetails(DetailsParameterDTOBuilder.construct(noteName, password));
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openScreenMarkdownHelp(String password) {
/*Generated! Do not modify!*/         openScreenMarkdownHelp(OverviewParameterDTOBuilder.construct(password));
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openScreenOverview(String password) {
/*Generated! Do not modify!*/         openScreenOverview(OverviewParameterDTOBuilder.construct(password));
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public DetailsStringInputDialogOptions showInputDialog(String referenceID, String title, String textContent, String label, String initialValueText, String okText, String cancelText){
/*Generated! Do not modify!*/         InputDialogParameters inputDialogParameters = new InputDialogParameters();
/*Generated! Do not modify!*/         inputDialogParameters.setReferenceID(referenceID);
/*Generated! Do not modify!*/         inputDialogParameters.setTitle(title);
/*Generated! Do not modify!*/         inputDialogParameters.setTextContent(textContent);
/*Generated! Do not modify!*/         inputDialogParameters.setLabel(label);
/*Generated! Do not modify!*/         inputDialogParameters.setInitialValueText(initialValueText);
/*Generated! Do not modify!*/         inputDialogParameters.setOkText(okText);
/*Generated! Do not modify!*/         inputDialogParameters.setCancelText(cancelText);
/*Generated! Do not modify!*/         replyDTO.setInputDialogParameters(inputDialogParameters);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/         	addRecordedAction("showInputDialog(" + escapeString(referenceID) + ", " + escapeString(title) + ", " + escapeString(textContent) 
/*Generated! Do not modify!*/         			+ ", " + escapeString(label) + ", " + escapeString(initialValueText) + ", " + escapeString(okText) 
/*Generated! Do not modify!*/         			+ ", " + escapeString(cancelText)+ ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return new DetailsStringInputDialogOptions(this, inputDialogParameters);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public DetailsConfirmDialogOptions showConfirmDialog(String referenceID, String title, String textContent, String okText, String cancelText){
/*Generated! Do not modify!*/         ConfirmDialogParameters confirmDialogParameters = new ConfirmDialogParameters();
/*Generated! Do not modify!*/         confirmDialogParameters.setReferenceID(referenceID);
/*Generated! Do not modify!*/         confirmDialogParameters.setTitle(title);
/*Generated! Do not modify!*/         confirmDialogParameters.setTextContent(textContent);
/*Generated! Do not modify!*/         confirmDialogParameters.setOkText(okText);
/*Generated! Do not modify!*/         confirmDialogParameters.setCancelText(cancelText);
/*Generated! Do not modify!*/         replyDTO.setConfirmDialogParameters(confirmDialogParameters);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("showConfirmDialog(" + escapeString(referenceID) + ", " + escapeString(title) + ", " + escapeString(textContent) 
/*Generated! Do not modify!*/         			+ ", " + escapeString(okText) + ", " + escapeString(cancelText)+ ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return new DetailsConfirmDialogOptions(this, confirmDialogParameters);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public DetailsListChooserDialogOptions showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, IDLabelImageAssetList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/         return showListChooser(referenceID, multiSelect, showFilter, title, DEFAULT_OK_TEXT, DEFAULT_CANCEL_TEXT, items, selectedIDs);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     
/*Generated! Do not modify!*/     public DetailsListChooserDialogOptions showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, IDLabelList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/         return showListChooser(referenceID, multiSelect, showFilter, title, DEFAULT_OK_TEXT, DEFAULT_CANCEL_TEXT, items, selectedIDs);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     
/*Generated! Do not modify!*/     public DetailsListChooserDialogOptions showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, String okText, String cancelText, IDLabelImageAssetList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/     	ListChooserParameters parameters = createListChooserParameters(referenceID, multiSelect, showFilter, title, okText, cancelText);
/*Generated! Do not modify!*/     	Set<String> selectedIDsSet = new HashSet<String>();
/*Generated! Do not modify!*/     	if (selectedIDs != null){
/*Generated! Do not modify!*/     		selectedIDsSet = new HashSet<String>(selectedIDs);
/*Generated! Do not modify!*/     	}
/*Generated! Do not modify!*/     	List<ListChooserItem> chooserItems = new ArrayList<ListChooserItem>();
/*Generated! Do not modify!*/     	for (IDLabelImageAsset i: items.getItems()){
/*Generated! Do not modify!*/     		chooserItems.add(createItem(i.getID(), i.getLabel(), i.getImageAssetID(), selectedIDsSet.contains(i.getID())));
/*Generated! Do not modify!*/     	}
/*Generated! Do not modify!*/     	parameters.setShowIcons(true);
/*Generated! Do not modify!*/     	parameters.setItems(chooserItems);
/*Generated! Do not modify!*/     	replyDTO.setListChooserParameters(parameters);
/*Generated! Do not modify!*/     	
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.SHOW_LIST_CHOOSER_IMGS, "showListChooser(" + escapeString(referenceID) + ", " + multiSelect + ", " + showFilter + ", " + escapeString(title) 
/*Generated! Do not modify!*/         			+ ", " + escapeString(okText) + ", " + escapeString(cancelText) + ", ", gson.toJson(items), selectedIDs);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         return new DetailsListChooserDialogOptions(this, parameters);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public DetailsListChooserDialogOptions showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, String okText, String cancelText, IDLabelList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/     	ListChooserParameters parameters = createListChooserParameters(referenceID, multiSelect, showFilter, title, okText, cancelText);
/*Generated! Do not modify!*/     	Set<String> selectedIDsSet = new HashSet<String>();
/*Generated! Do not modify!*/     	if (selectedIDs != null){
/*Generated! Do not modify!*/     		selectedIDsSet = new HashSet<String>(selectedIDs);
/*Generated! Do not modify!*/     	}
/*Generated! Do not modify!*/     	List<ListChooserItem> chooserItems = new ArrayList<ListChooserItem>();
/*Generated! Do not modify!*/     	for (IDLabel i: items.getItems()){
/*Generated! Do not modify!*/     		chooserItems.add(createItem(i.getID(), i.getLabel(), null, selectedIDsSet.contains(i.getID())));
/*Generated! Do not modify!*/     	}
/*Generated! Do not modify!*/     	parameters.setShowIcons(false);
/*Generated! Do not modify!*/     	parameters.setItems(chooserItems);
/*Generated! Do not modify!*/     	replyDTO.setListChooserParameters(parameters);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/         	addRecordedAction(ReplyActionType.SHOW_LIST_CHOOSER_TEXTS, "showListChooser(" + escapeString(referenceID) + ", " + multiSelect + ", " + showFilter + ", " + escapeString(title) 
/*Generated! Do not modify!*/         			+ ", " + escapeString(okText) + ", " + escapeString(cancelText) + ", ", gson.toJson(items), selectedIDs);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return new DetailsListChooserDialogOptions(this, parameters);
/*Generated! Do not modify!*/ }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private ListChooserParameters createListChooserParameters(String referenceID, boolean multiSelect, boolean showFilter, String title, String okText, String cancelText) {
/*Generated! Do not modify!*/         ListChooserParameters parameters = new ListChooserParameters();
/*Generated! Do not modify!*/         parameters.setReferenceID(referenceID);
/*Generated! Do not modify!*/         parameters.setMultiSelect(multiSelect);
/*Generated! Do not modify!*/         parameters.setShowFilter(showFilter);
/*Generated! Do not modify!*/         parameters.setTitle(title);
/*Generated! Do not modify!*/         parameters.setOkText(okText);
/*Generated! Do not modify!*/         parameters.setCancelText(cancelText);
/*Generated! Do not modify!*/         return parameters;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private ListChooserItem createItem(String id, String label, String imageAssetID, boolean selected) {
/*Generated! Do not modify!*/         ListChooserItem result = new ListChooserItem();
/*Generated! Do not modify!*/         result.setID(id);
/*Generated! Do not modify!*/         result.setLabel(label);
/*Generated! Do not modify!*/         result.setImageAssetID(imageAssetID);
/*Generated! Do not modify!*/         result.setSelected(selected);
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }