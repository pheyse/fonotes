/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ import java.util.Collection;
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
/*Generated! Do not modify!*/ public interface MarkdownHelpDisplay{
/*Generated! Do not modify!*/     public void setEventHandler(MarkdownHelpDisplayEventHandler eventHandler);
/*Generated! Do not modify!*/     public void setBackButtonText(String text);
/*Generated! Do not modify!*/     public void setBackButtonVisible(boolean visible);
/*Generated! Do not modify!*/     public void setInfoText(String text);
/*Generated! Do not modify!*/     public void setInfoVisible(boolean visible);
/*Generated! Do not modify!*/     public void setMarkdownHelpTextText(String text);
/*Generated! Do not modify!*/     public void setMarkdownHelpTextVisible(boolean visible);
/*Generated! Do not modify!*/     public void setMarkdownHelpTextBackgroundColor(String color);
/*Generated! Do not modify!*/     public void setBackButtonImageAsset(ImageAsset imageAsset);
/*Generated! Do not modify!*/     public void setParameterDTO(OverviewParameterDTO dto);
/*Generated! Do not modify!*/     public void openScreenAbout(OverviewParameterDTO parameter);
/*Generated! Do not modify!*/     public void openScreenDetails(DetailsParameterDTO parameter);
/*Generated! Do not modify!*/     public void openScreenLogin();
/*Generated! Do not modify!*/     public void openScreenMarkdownHelp(OverviewParameterDTO parameter);
/*Generated! Do not modify!*/     public void openScreenOverview(OverviewParameterDTO parameter);
/*Generated! Do not modify!*/     public void showInputDialog(InputDialogParameters parameters);
/*Generated! Do not modify!*/     public void showConfirmDialog(ConfirmDialogParameters parameters);
/*Generated! Do not modify!*/     public void showListChooser(ListChooserParameters parameters);
/*Generated! Do not modify!*/     public void showMessage(FLUIMessage message);
/*Generated! Do not modify!*/ }