/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIClientPropertiesDTO;
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.DetailsParameterDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.EditStateDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public interface DetailsListener{
/*Generated! Do not modify!*/     void onLoaded(DetailsReply reply, FLUIClientPropertiesDTO clientProperties, DetailsParameterDTO parameter);
/*Generated! Do not modify!*/     void onInputDialogResult(DetailsReply reply, String referenceID, String dialogResult);
/*Generated! Do not modify!*/     void onConfirmDialogResult(DetailsReply reply, String referenceID, boolean confirmed);
/*Generated! Do not modify!*/     void onBackButtonClicked(DetailsReply reply, DetailsParameterDTO parameter);
/*Generated! Do not modify!*/     void onEditNameButtonClicked(DetailsReply reply, DetailsParameterDTO parameter);
/*Generated! Do not modify!*/     void onEditTextButtonClicked(DetailsReply reply, DetailsParameterDTO parameter);
/*Generated! Do not modify!*/     void onDeleteButtonClicked(DetailsReply reply, DetailsParameterDTO parameter);
/*Generated! Do not modify!*/     void onSaveNoteTextButtonClicked(DetailsReply reply, DetailsParameterDTO parameter, String editNoteTextAreaText);
/*Generated! Do not modify!*/     void onCancelEditNoteTextButtonClicked(DetailsReply reply, DetailsParameterDTO parameter);
/*Generated! Do not modify!*/     void onAutosaveTimer(DetailsReply reply, DetailsParameterDTO parameter, String editNoteTextAreaText, EditStateDTO editState);
/*Generated! Do not modify!*/     void onColorSelectBoxChanged(DetailsReply reply, String itemID, DetailsParameterDTO parameter);
/*Generated! Do not modify!*/ }