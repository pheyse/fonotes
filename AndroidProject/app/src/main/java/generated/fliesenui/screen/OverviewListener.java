/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIClientPropertiesDTO;
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewParameterDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public interface OverviewListener{
/*Generated! Do not modify!*/     void onLoaded(OverviewReply reply, FLUIClientPropertiesDTO clientProperties, OverviewParameterDTO parameter);
/*Generated! Do not modify!*/     void onInputDialogResult(OverviewReply reply, String referenceID, String dialogResult);
/*Generated! Do not modify!*/     void onConfirmDialogResult(OverviewReply reply, String referenceID, boolean confirmed);
/*Generated! Do not modify!*/     void onListChooserResult(OverviewReply reply, String referenceID, java.util.List<String> selectedIDs);
/*Generated! Do not modify!*/     void onMenuButtonClicked(OverviewReply reply, OverviewParameterDTO parameter);
/*Generated! Do not modify!*/     void onNotesTableRowClicked(OverviewReply reply, String rowID, OverviewParameterDTO parameter);
/*Generated! Do not modify!*/ }