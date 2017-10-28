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
/*Generated! Do not modify!*/ public class MarkdownHelpReply extends FLUIAbstractReply {
/*Generated! Do not modify!*/     public MarkdownHelpReply(boolean recordMode, StringLanguage currentLanguage) {
/*Generated! Do not modify!*/         super(recordMode, currentLanguage);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     protected String getJSON() {
/*Generated! Do not modify!*/         return gson.toJson(replyDTO);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setBackButtonText(String text){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("markdownHelp_backButton_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("markdownHelp_backButton_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("markdownHelp_backButton_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setBackButtonText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setBackButtonVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("markdownHelp_backButton_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("markdownHelp_backButton_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setBackButtonVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setInfoText(String text){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("markdownHelp_info_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("markdownHelp_info_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("markdownHelp_info_propertyText", text);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setInfoText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setInfoVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("markdownHelp_info_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("markdownHelp_info_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setInfoVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setMarkdownHelpTextText(String text){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("markdownHelp_markdownHelpText_propertyText");
/*Generated! Do not modify!*/         if (text == null) {
/*Generated! Do not modify!*/             replyDTO.getMarkdownViewTexts().remove("markdownHelpText");
/*Generated! Do not modify!*/             replyDTO.getVariableValues().remove("markdownHelp_markdownHelpText_propertyText");
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             String html = "";
/*Generated! Do not modify!*/             try{
/*Generated! Do not modify!*/                 html = new BrightMarkdown().createHTML(text);
/*Generated! Do not modify!*/             } catch (Exception e){
/*Generated! Do not modify!*/                 html = "<html><body><p>Error: " + e + "</p><p>text:</p><pre>" + text + "</pre></body></html>";
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/             replyDTO.getMarkdownViewTexts().put("markdownHelpText", html);
/*Generated! Do not modify!*/             replyDTO.getVariableValues().put("markdownHelp_markdownHelpText_propertyText", html);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setMarkdownHelpTextText(" + escapeString(text) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setMarkdownHelpTextVisible(boolean visible){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("markdownHelp_markdownHelpText_propertyVisible");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("markdownHelp_markdownHelpText_propertyVisible", visible);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setMarkdownHelpTextVisible(" + visible + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ /** @param color background color in format '#aabbcc' or null for transparent/default */
/*Generated! Do not modify!*/     public void setMarkdownHelpTextBackgroundColor(String color){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("markdownHelp_markdownHelpText_propertyBackgroundColor");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("markdownHelp_markdownHelpText_propertyBackgroundColor", color == null ? "" : "background: " + color);
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction("setMarkdownHelpTextBackgroundColor(" + escapeString(color) + ");");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setBackButtonImageAsset(ImageAsset imageAsset){
/*Generated! Do not modify!*/         replyDTO.getVariablesToSet().add("markdownHelp_backButton_propertyImageSource");
/*Generated! Do not modify!*/         replyDTO.getVariableValues().put("markdownHelp_backButton_propertyImageSource", imageAsset.getFilename());
/*Generated! Do not modify!*/         if (recordMode){
/*Generated! Do not modify!*/             addRecordedAction(ReplyActionType.SET_IMAGE_ASSET, "setBackButtonImageAsset(", imageAsset);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setParameterDTO(OverviewParameterDTO dto){
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
/*Generated! Do not modify!*/     public MarkdownHelpStringInputDialogOptions showInputDialog(String referenceID, String title, String textContent, String label, String initialValueText, String okText, String cancelText){
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
/*Generated! Do not modify!*/         return new MarkdownHelpStringInputDialogOptions(this, inputDialogParameters);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public MarkdownHelpConfirmDialogOptions showConfirmDialog(String referenceID, String title, String textContent, String okText, String cancelText){
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
/*Generated! Do not modify!*/         return new MarkdownHelpConfirmDialogOptions(this, confirmDialogParameters);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public MarkdownHelpListChooserDialogOptions showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, IDLabelImageAssetList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/         return showListChooser(referenceID, multiSelect, showFilter, title, DEFAULT_OK_TEXT, DEFAULT_CANCEL_TEXT, items, selectedIDs);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     
/*Generated! Do not modify!*/     public MarkdownHelpListChooserDialogOptions showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, IDLabelList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/         return showListChooser(referenceID, multiSelect, showFilter, title, DEFAULT_OK_TEXT, DEFAULT_CANCEL_TEXT, items, selectedIDs);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     
/*Generated! Do not modify!*/     public MarkdownHelpListChooserDialogOptions showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, String okText, String cancelText, IDLabelImageAssetList items, Collection<String> selectedIDs){
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
/*Generated! Do not modify!*/         return new MarkdownHelpListChooserDialogOptions(this, parameters);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public MarkdownHelpListChooserDialogOptions showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, String okText, String cancelText, IDLabelList items, Collection<String> selectedIDs){
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
/*Generated! Do not modify!*/         return new MarkdownHelpListChooserDialogOptions(this, parameters);
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