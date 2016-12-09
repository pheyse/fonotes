/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIClientPropertiesDTO;
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewParameterDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public interface AboutListener{
/*Generated! Do not modify!*/     void onLoaded(AboutReply reply, FLUIClientPropertiesDTO clientProperties, OverviewParameterDTO parameter);
/*Generated! Do not modify!*/     void onInputDialogResult(AboutReply reply, String referenceID, String dialogResult);
/*Generated! Do not modify!*/     void onConfirmDialogResult(AboutReply reply, String referenceID, boolean confirmed);
/*Generated! Do not modify!*/     void onBackButtonClicked(AboutReply reply, OverviewParameterDTO parameter);
/*Generated! Do not modify!*/ }