/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.TextHighlighting;
/*Generated! Do not modify!*/ import generated.fliesenui.core.CursorPos;
/*Generated! Do not modify!*/ import generated.fliesenui.core.ContextAssist;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.dto.DetailsParameterDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewParameterDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public interface CommonSharedReply{
/*Generated! Do not modify!*/     void downloadFile(String fileStreamID);
/*Generated! Do not modify!*/     void openScreenAbout(OverviewParameterDTO parameter);
/*Generated! Do not modify!*/     void openScreenDetails(DetailsParameterDTO parameter);
/*Generated! Do not modify!*/     void openScreenLogin();
/*Generated! Do not modify!*/     void openScreenOverview(OverviewParameterDTO parameter);
/*Generated! Do not modify!*/     void openURL(String url, boolean openInNewWindow);
/*Generated! Do not modify!*/     void setErrorDialog(String title, String text);
/*Generated! Do not modify!*/     void setInfoDialog(String title, String text);
/*Generated! Do not modify!*/     void setInfoToast(String text);
/*Generated! Do not modify!*/     void showConfirmDialog(String referenceID, String title, String textContent, String okText, String cancelText);
/*Generated! Do not modify!*/     void showInputDialog(String referenceID, String title, String textContent, String label, String initialValueText, String okText, String cancelText);
/*Generated! Do not modify!*/ }