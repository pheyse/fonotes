/*Generated! Do not modify!*/ package generated.fliesenui.core;
/*Generated! Do not modify!*/ import android.os.Bundle;
/*Generated! Do not modify!*/ import android.support.v7.app.ActionBar;
/*Generated! Do not modify!*/ import android.support.v7.app.AppCompatActivity;
/*Generated! Do not modify!*/ import android.view.View;
/*Generated! Do not modify!*/ import android.view.ViewGroup;
/*Generated! Do not modify!*/ import android.view.Window;
/*Generated! Do not modify!*/ import android.widget.LinearLayout;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.DetailsParameterDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.DetailsParameterDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.DetailsParameterListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.DetailsParameterListDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.EditStateDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.EditStateDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.EditStateListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.EditStateListDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.IdAndLabelDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.IdAndLabelDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.IdAndLabelListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.IdAndLabelListDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.IdAndLabelListListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.IdAndLabelListListDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewItemDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewItemDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewItemListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewItemListDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewListDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewListListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewListListDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewParameterDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewParameterDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewParameterListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewParameterListDTOBuilder;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.AboutAndroidDisplay;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.DetailsAndroidDisplay;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.LoginAndroidDisplay;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.MarkdownHelpAndroidDisplay;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.OverviewAndroidDisplay;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public abstract class FLUIAndroidDisplayActivity extends AppCompatActivity implements FLUIDisplayManager {
/*Generated! Do not modify!*/     private LinearLayout mainLayout;
/*Generated! Do not modify!*/     private ViewGroup.LayoutParams screenParams;
/*Generated! Do not modify!*/     private FLUIClientPropertiesDTO clientProperties;
/*Generated! Do not modify!*/     private String activeScreenID = null;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private AboutAndroidDisplay aboutDisplay;
/*Generated! Do not modify!*/     private DetailsAndroidDisplay detailsDisplay;
/*Generated! Do not modify!*/     private LoginAndroidDisplay loginDisplay;
/*Generated! Do not modify!*/     private MarkdownHelpAndroidDisplay markdownHelpDisplay;
/*Generated! Do not modify!*/     private OverviewAndroidDisplay overviewDisplay;
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     protected void onCreate(Bundle savedInstanceState) {
/*Generated! Do not modify!*/         try{
/*Generated! Do not modify!*/             super.onCreate(savedInstanceState);
/*Generated! Do not modify!*/             fluiOnCreate(savedInstanceState);
/*Generated! Do not modify!*/             getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
/*Generated! Do not modify!*/             ActionBar actionBar = getSupportActionBar();
/*Generated! Do not modify!*/             if (actionBar != null){
/*Generated! Do not modify!*/                 getSupportActionBar().hide();
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/             FLUIScreenManagerAndroid screenManager = fluiCreateScreenManager();
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/             aboutDisplay = new AboutAndroidDisplay(this, this);
/*Generated! Do not modify!*/             screenManager.setAboutDisplay(aboutDisplay);
/*Generated! Do not modify!*/             detailsDisplay = new DetailsAndroidDisplay(this, this);
/*Generated! Do not modify!*/             screenManager.setDetailsDisplay(detailsDisplay);
/*Generated! Do not modify!*/             loginDisplay = new LoginAndroidDisplay(this, this);
/*Generated! Do not modify!*/             screenManager.setLoginDisplay(loginDisplay);
/*Generated! Do not modify!*/             markdownHelpDisplay = new MarkdownHelpAndroidDisplay(this, this);
/*Generated! Do not modify!*/             screenManager.setMarkdownHelpDisplay(markdownHelpDisplay);
/*Generated! Do not modify!*/             overviewDisplay = new OverviewAndroidDisplay(this, this);
/*Generated! Do not modify!*/             screenManager.setOverviewDisplay(overviewDisplay);
/*Generated! Do not modify!*/             mainLayout = createMainLayout();
/*Generated! Do not modify!*/             setContentView(mainLayout);
/*Generated! Do not modify!*/         } catch (Throwable t){
/*Generated! Do not modify!*/              fluiOnError(t);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     protected abstract FLUIScreenManagerAndroid fluiCreateScreenManager();
/*Generated! Do not modify!*/     protected abstract void fluiOnCreate(Bundle savedInstanceState);
/*Generated! Do not modify!*/     protected abstract void fluiOnResume() throws Throwable;
/*Generated! Do not modify!*/     protected abstract void fluiOnError(Throwable throwable);
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private LinearLayout createMainLayout() {
/*Generated! Do not modify!*/         LinearLayout result = new LinearLayout(this);
/*Generated! Do not modify!*/         screenParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
/*Generated! Do not modify!*/         result.addView(loginDisplay, screenParams);
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     protected void onResume() {
/*Generated! Do not modify!*/         try {
/*Generated! Do not modify!*/             super.onResume();
/*Generated! Do not modify!*/             fluiOnResume();
/*Generated! Do not modify!*/             if (activeScreenID == null){
/*Generated! Do not modify!*/                 clientProperties = new FLUIClientPropertiesDTO();
/*Generated! Do not modify!*/                 loginDisplay.onLoaded(clientProperties);
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         aboutDisplay.onResume();
/*Generated! Do not modify!*/         detailsDisplay.onResume();
/*Generated! Do not modify!*/         loginDisplay.onResume();
/*Generated! Do not modify!*/         markdownHelpDisplay.onResume();
/*Generated! Do not modify!*/         overviewDisplay.onResume();
/*Generated! Do not modify!*/         } catch (Throwable t){
/*Generated! Do not modify!*/             fluiOnError(t);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     protected void onPause() {
/*Generated! Do not modify!*/         try {
/*Generated! Do not modify!*/         aboutDisplay.onPause();
/*Generated! Do not modify!*/         detailsDisplay.onPause();
/*Generated! Do not modify!*/         loginDisplay.onPause();
/*Generated! Do not modify!*/         markdownHelpDisplay.onPause();
/*Generated! Do not modify!*/         overviewDisplay.onPause();
/*Generated! Do not modify!*/             super.onPause();
/*Generated! Do not modify!*/         } catch (Throwable t){
/*Generated! Do not modify!*/             fluiOnError(t);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void onBackPressed() {
/*Generated! Do not modify!*/         if ("about".equals(activeScreenID)){
/*Generated! Do not modify!*/             aboutDisplay.onBackPressed();
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if ("details".equals(activeScreenID)){
/*Generated! Do not modify!*/             detailsDisplay.onBackPressed();
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if ("login".equals(activeScreenID)){
/*Generated! Do not modify!*/             loginDisplay.onBackPressed();
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if ("markdownHelp".equals(activeScreenID)){
/*Generated! Do not modify!*/             markdownHelpDisplay.onBackPressed();
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if ("overview".equals(activeScreenID)){
/*Generated! Do not modify!*/             overviewDisplay.onBackPressed();
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private void setMainLayoutView(View view){
/*Generated! Do not modify!*/         if(mainLayout.getChildCount() > 0){
/*Generated! Do not modify!*/             mainLayout.removeAllViews();
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         mainLayout.addView(view, screenParams);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void openScreenAbout(OverviewParameterDTO parameter){
/*Generated! Do not modify!*/         setAllScreensInactive();
/*Generated! Do not modify!*/         activeScreenID = "about";
/*Generated! Do not modify!*/         aboutDisplay.setParameterDTO(parameter);
/*Generated! Do not modify!*/         setMainLayoutView(aboutDisplay);
/*Generated! Do not modify!*/         aboutDisplay.onLoaded(clientProperties, parameter);
/*Generated! Do not modify!*/         aboutDisplay.setScreenActive(true);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void openScreenDetails(DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         setAllScreensInactive();
/*Generated! Do not modify!*/         activeScreenID = "details";
/*Generated! Do not modify!*/         detailsDisplay.setParameterDTO(parameter);
/*Generated! Do not modify!*/         setMainLayoutView(detailsDisplay);
/*Generated! Do not modify!*/         detailsDisplay.onLoaded(clientProperties, parameter);
/*Generated! Do not modify!*/         detailsDisplay.setScreenActive(true);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void openScreenLogin(){
/*Generated! Do not modify!*/         setAllScreensInactive();
/*Generated! Do not modify!*/         activeScreenID = "login";
/*Generated! Do not modify!*/         setMainLayoutView(loginDisplay);
/*Generated! Do not modify!*/         loginDisplay.onLoaded(clientProperties);
/*Generated! Do not modify!*/         loginDisplay.setScreenActive(true);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void openScreenMarkdownHelp(OverviewParameterDTO parameter){
/*Generated! Do not modify!*/         setAllScreensInactive();
/*Generated! Do not modify!*/         activeScreenID = "markdownHelp";
/*Generated! Do not modify!*/         markdownHelpDisplay.setParameterDTO(parameter);
/*Generated! Do not modify!*/         setMainLayoutView(markdownHelpDisplay);
/*Generated! Do not modify!*/         markdownHelpDisplay.onLoaded(clientProperties, parameter);
/*Generated! Do not modify!*/         markdownHelpDisplay.setScreenActive(true);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void openScreenOverview(OverviewParameterDTO parameter){
/*Generated! Do not modify!*/         setAllScreensInactive();
/*Generated! Do not modify!*/         activeScreenID = "overview";
/*Generated! Do not modify!*/         overviewDisplay.setParameterDTO(parameter);
/*Generated! Do not modify!*/         setMainLayoutView(overviewDisplay);
/*Generated! Do not modify!*/         overviewDisplay.onLoaded(clientProperties, parameter);
/*Generated! Do not modify!*/         overviewDisplay.setScreenActive(true);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setAllScreensInactive(){
/*Generated! Do not modify!*/         aboutDisplay.setScreenActive(false);
/*Generated! Do not modify!*/         detailsDisplay.setScreenActive(false);
/*Generated! Do not modify!*/         loginDisplay.setScreenActive(false);
/*Generated! Do not modify!*/         markdownHelpDisplay.setScreenActive(false);
/*Generated! Do not modify!*/         overviewDisplay.setScreenActive(false);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ }