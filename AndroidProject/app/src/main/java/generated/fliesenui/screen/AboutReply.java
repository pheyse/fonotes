/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import java.util.List;
/*Generated! Do not modify!*/ import java.util.Collection;
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
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.dto.DetailsParameterDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewParameterDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class AboutReply extends FLUIAbstractReply {
/*Generated! Do not modify!*/     public AboutReply(boolean recordMode, StringLanguage currentLanguage) {
/*Generated! Do not modify!*/         super(recordMode, currentLanguage);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     protected String getJSON() {
/*Generated! Do not modify!*/         return gson.toJson(replyDTO);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setInfoText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("about_info_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("about_info_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("about_info_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setInfoText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setInfoVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("about_info_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("about_info_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setInfoVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setBackButtonText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("about_backButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("about_backButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("about_backButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setBackButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setBackButtonVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("about_backButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("about_backButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setBackButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setAboutTextText(String text) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("about_aboutText_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getMarkdownViewTexts().remove("aboutText");
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("about_aboutText_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getMarkdownViewTexts().put("aboutText", text);
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("about_aboutText_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setAboutTextText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setAboutTextVisible(boolean visible) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("about_aboutText_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("about_aboutText_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setAboutTextVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ /** @param color background color in format '#aabbcc' or null for transparent/default */
/*Generated! Do not modify!*/     public void setAboutTextBackgroundColor(String color) {
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("about_aboutText_propertyBackgroundColor");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("about_aboutText_propertyBackgroundColor", color == null ? "" : "background: " + color);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setAboutTextBackgroundColor(" + escapeString(color) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setParameterDTO(OverviewParameterDTO dto) {
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
/*Generated! Do not modify!*/     public void openScreenAbout(OverviewParameterDTO parameter) {
/*Generated! Do not modify!*/         replyDTO.setOpenParameter(parameter);
/*Generated! Do not modify!*/         replyDTO.setScreenToOpen("about");
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.OPEN_SCREEN, "openScreenAbout(", gson.toJson(parameter), getClassName(parameter));
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openScreenDetails(DetailsParameterDTO parameter) {
/*Generated! Do not modify!*/         replyDTO.setOpenParameter(parameter);
/*Generated! Do not modify!*/         replyDTO.setScreenToOpen("details");
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.OPEN_SCREEN, "openScreenDetails(", gson.toJson(parameter), getClassName(parameter));
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openScreenLogin() {
/*Generated! Do not modify!*/         replyDTO.setScreenToOpen("login");
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.OPEN_SCREEN, "openScreenLogin(");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void openScreenOverview(OverviewParameterDTO parameter) {
/*Generated! Do not modify!*/         replyDTO.setOpenParameter(parameter);
/*Generated! Do not modify!*/         replyDTO.setScreenToOpen("overview");
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.OPEN_SCREEN, "openScreenOverview(", gson.toJson(parameter), getClassName(parameter));
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }