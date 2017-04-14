/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import java.util.Collection;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIString.StringLanguage;
/*Generated! Do not modify!*/ import generated.fliesenui.core.TextHighlighting;
/*Generated! Do not modify!*/ import generated.fliesenui.core.CursorPos;
/*Generated! Do not modify!*/ import generated.fliesenui.core.ContextAssist;
/*Generated! Do not modify!*/ import generated.fliesenui.core.IDLabelImageAssetList;
/*Generated! Do not modify!*/ import generated.fliesenui.core.IDLabelList;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIImageAssets.ImageAsset;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.dto.DetailsParameterDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewParameterDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public interface CommonSharedReply{
/*Generated! Do not modify!*/     StringLanguage getCurrentLanguage();
/*Generated! Do not modify!*/     void downloadFile(String fileStreamID);
/*Generated! Do not modify!*/     void openScreenAbout(OverviewParameterDTO parameter);
/*Generated! Do not modify!*/     void openScreenDetails(DetailsParameterDTO parameter);
/*Generated! Do not modify!*/     void openScreenLogin();
/*Generated! Do not modify!*/     void openScreenOverview(OverviewParameterDTO parameter);
/*Generated! Do not modify!*/     void openURL(String url, boolean openInNewWindow);
/*Generated! Do not modify!*/     void setErrorDialog(String title, String text);
/*Generated! Do not modify!*/     void setInfoDialog(String title, String text);
/*Generated! Do not modify!*/     void setInfoToast(String text);
/*Generated! Do not modify!*/     void setLanguage(StringLanguage language);
/*Generated! Do not modify!*/     void showConfirmDialog(String referenceID, String title, String textContent, String okText, String cancelText);
/*Generated! Do not modify!*/     void showInputDialog(String referenceID, String title, String textContent, String label, String initialValueText, String okText, String cancelText);
/*Generated! Do not modify!*/     void showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, IDLabelImageAssetList items, Collection<String> selectedIDs);
/*Generated! Do not modify!*/     void showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, IDLabelList items, Collection<String> selectedIDs);
/*Generated! Do not modify!*/     void showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, String okText, String cancelText, IDLabelImageAssetList items, Collection<String> selectedIDs);
/*Generated! Do not modify!*/     void showListChooser(String referenceID, boolean multiSelect, boolean showFilter, String title, String okText, String cancelText, IDLabelList items, Collection<String> selectedIDs);
/*Generated! Do not modify!*/ }