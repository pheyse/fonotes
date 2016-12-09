/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIClientPropertiesDTO;
/*Generated! Do not modify!*/ import java.io.InputStream;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public interface LoginListener{
/*Generated! Do not modify!*/     void onLoaded(LoginReply reply, FLUIClientPropertiesDTO clientProperties);
/*Generated! Do not modify!*/     void onInputDialogResult(LoginReply reply, String referenceID, String dialogResult);
/*Generated! Do not modify!*/     void onConfirmDialogResult(LoginReply reply, String referenceID, boolean confirmed);
/*Generated! Do not modify!*/     void onLoginButtonClicked(LoginReply reply, String passwordTextFieldText);
/*Generated! Do not modify!*/ }