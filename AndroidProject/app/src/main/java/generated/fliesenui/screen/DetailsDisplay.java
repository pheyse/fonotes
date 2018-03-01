/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ import java.util.Collection;
/*Generated! Do not modify!*/ import java.util.List;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIString.StringLanguage;
/*Generated! Do not modify!*/ import generated.fliesenui.core.CallbackMethodCall;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIMessage;
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
/*Generated! Do not modify!*/ public interface DetailsDisplay{
/*Generated! Do not modify!*/     public void setEventHandler(DetailsDisplayEventHandler eventHandler);
/*Generated! Do not modify!*/     public void setBackButtonText(String text);
/*Generated! Do not modify!*/     public void setBackButtonVisible(boolean visible);
/*Generated! Do not modify!*/     public void setEditTextButtonText(String text);
/*Generated! Do not modify!*/     public void setEditTextButtonVisible(boolean visible);
/*Generated! Do not modify!*/     public void setEditNameButtonText(String text);
/*Generated! Do not modify!*/     public void setEditNameButtonVisible(boolean visible);
/*Generated! Do not modify!*/     public void setDeleteButtonText(String text);
/*Generated! Do not modify!*/     public void setDeleteButtonVisible(boolean visible);
/*Generated! Do not modify!*/     public void setMenuButtonText(String text);
/*Generated! Do not modify!*/     public void setMenuButtonVisible(boolean visible);
/*Generated! Do not modify!*/     public void setSaveNoteTextButtonText(String text);
/*Generated! Do not modify!*/     public void setSaveNoteTextButtonVisible(boolean visible);
/*Generated! Do not modify!*/     public void setCancelEditNoteTextButtonText(String text);
/*Generated! Do not modify!*/     public void setCancelEditNoteTextButtonVisible(boolean visible);
/*Generated! Do not modify!*/     public void setColorLabelText(String text);
/*Generated! Do not modify!*/     public void setColorLabelVisible(boolean visible);
/*Generated! Do not modify!*/     public void setNoteNameLabelText(String text);
/*Generated! Do not modify!*/     public void setNoteNameLabelVisible(boolean visible);
/*Generated! Do not modify!*/     public void setNoteViewText(String text);
/*Generated! Do not modify!*/     public void setNoteViewVisible(boolean visible);
/*Generated! Do not modify!*/     public void setNoteViewBackgroundColor(String color);
/*Generated! Do not modify!*/     public void setEditNoteTextAreaText(String text);
/*Generated! Do not modify!*/     public void setEditNoteTextAreaVisible(boolean visible);
/*Generated! Do not modify!*/     public void setEditNoteTextAreaBackgroundColor(String color);
/*Generated! Do not modify!*/     public void setEditNoteInfoLabelText(String text);
/*Generated! Do not modify!*/     public void setEditNoteInfoLabelVisible(boolean visible);
/*Generated! Do not modify!*/     public void setColorBarVisible(boolean visible);
/*Generated! Do not modify!*/     public void setViewNoteNameVisible(boolean visible);
/*Generated! Do not modify!*/     public void setButtonBarVisible(boolean visible);
/*Generated! Do not modify!*/     public void setEditNoteButtonBarVisible(boolean visible);
/*Generated! Do not modify!*/     public void setViewNotePanelVisible(boolean visible);
/*Generated! Do not modify!*/     public void setEditNotePanelVisible(boolean visible);
/*Generated! Do not modify!*/     public void setBackButtonImageAsset(ImageAsset imageAsset);
/*Generated! Do not modify!*/     public void setDeleteButtonImageAsset(ImageAsset imageAsset);
/*Generated! Do not modify!*/     public void setMenuButtonImageAsset(ImageAsset imageAsset);
/*Generated! Do not modify!*/     public void setAutosaveTimerActive(boolean active);
/*Generated! Do not modify!*/     public void setColorsDTO(IdAndLabelListDTO dto);
/*Generated! Do not modify!*/     public void setEditStateDTO(EditStateDTO dto);
/*Generated! Do not modify!*/     public void setParameterDTO(DetailsParameterDTO dto);
/*Generated! Do not modify!*/     public void setColorSelectBoxSelectedID(String selectedID);
/*Generated! Do not modify!*/     public void openScreenAbout(OverviewParameterDTO parameter);
/*Generated! Do not modify!*/     public void openScreenDetails(DetailsParameterDTO parameter);
/*Generated! Do not modify!*/     public void openScreenLogin();
/*Generated! Do not modify!*/     public void openScreenMarkdownHelp(OverviewParameterDTO parameter);
/*Generated! Do not modify!*/     public void openScreenOverview(OverviewParameterDTO parameter);
/*Generated! Do not modify!*/     public void showInputDialog(InputDialogParameters parameters);
/*Generated! Do not modify!*/     public void showConfirmDialog(ConfirmDialogParameters parameters);
/*Generated! Do not modify!*/     public void showListChooser(ListChooserParameters parameters);
/*Generated! Do not modify!*/     public void showMessage(FLUIMessage message);
/*Generated! Do not modify!*/     public void downloadFile(String downloadFileStreamID);
/*Generated! Do not modify!*/ }