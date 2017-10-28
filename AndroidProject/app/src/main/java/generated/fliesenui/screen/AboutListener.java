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
/*Generated! Do not modify!*/ public interface AboutListener{
/*Generated! Do not modify!*/     void onLoaded(AboutReply reply, FLUIClientPropertiesDTO clientProperties, OverviewParameterDTO parameter);
/*Generated! Do not modify!*/     void onInputDialogResult(AboutReply reply, String referenceID, String dialogResult);
/*Generated! Do not modify!*/     void onConfirmDialogResult(AboutReply reply, String referenceID, boolean confirmed);
/*Generated! Do not modify!*/     void onListChooserResult(AboutReply reply, String referenceID, java.util.List<String> selectedIDs);
/*Generated! Do not modify!*/     void onBackButtonClicked(AboutReply reply, OverviewParameterDTO parameter);
/*Generated! Do not modify!*/     void onBackPressed(AboutReply reply, OverviewParameterDTO parameter);
/*Generated! Do not modify!*/ }