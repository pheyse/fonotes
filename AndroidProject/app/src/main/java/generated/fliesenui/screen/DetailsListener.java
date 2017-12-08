/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIClientPropertiesDTO;
/*Generated! Do not modify!*/ import java.util.List;
/*Generated! Do not modify!*/ import java.io.InputStream;
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
/*Generated! Do not modify!*/ public interface DetailsListener{
/*Generated! Do not modify!*/     void onLoaded(DetailsReply reply, FLUIClientPropertiesDTO clientProperties, DetailsParameterDTO parameter);
/*Generated! Do not modify!*/     void onInputDialogResult(DetailsReply reply, String referenceID, String dialogResult);
/*Generated! Do not modify!*/     void onConfirmDialogResult(DetailsReply reply, String referenceID, boolean confirmed);
/*Generated! Do not modify!*/     void onListChooserResult(DetailsReply reply, String referenceID, java.util.List<String> selectedIDs);
/*Generated! Do not modify!*/     void onBackButtonClicked(DetailsReply reply, DetailsParameterDTO parameter);
/*Generated! Do not modify!*/     void onEditTextButtonClicked(DetailsReply reply, DetailsParameterDTO parameter);
/*Generated! Do not modify!*/     void onEditNameButtonClicked(DetailsReply reply, DetailsParameterDTO parameter);
/*Generated! Do not modify!*/     void onDeleteButtonClicked(DetailsReply reply, DetailsParameterDTO parameter);
/*Generated! Do not modify!*/     void onMenuButtonClicked(DetailsReply reply, DetailsParameterDTO parameter);
/*Generated! Do not modify!*/     void onSaveNoteTextButtonClicked(DetailsReply reply, DetailsParameterDTO parameter, String editNoteTextAreaText);
/*Generated! Do not modify!*/     void onCancelEditNoteTextButtonClicked(DetailsReply reply, DetailsParameterDTO parameter);
/*Generated! Do not modify!*/     void onAutosaveTimer(DetailsReply reply, DetailsParameterDTO parameter, String editNoteTextAreaText, EditStateDTO editState);
/*Generated! Do not modify!*/     void onColorSelectBoxChanged(DetailsReply reply, String itemID, DetailsParameterDTO parameter);
/*Generated! Do not modify!*/     void onBackPressed(DetailsReply reply, DetailsParameterDTO parameter);
/*Generated! Do not modify!*/     void onListChooserMenu(DetailsReply reply, java.util.List<String> selectedIDs, DetailsParameterDTO parameter);
/*Generated! Do not modify!*/ }