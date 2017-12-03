/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ import java.util.Collection;
/*Generated! Do not modify!*/ import java.util.List;
/*Generated! Do not modify!*/ import java.util.Map;
/*Generated! Do not modify!*/ import java.util.Set;
/*Generated! Do not modify!*/ import java.util.Timer;
/*Generated! Do not modify!*/ import java.util.TimerTask;
/*Generated! Do not modify!*/ import java.util.TreeMap;
/*Generated! Do not modify!*/ import java.util.ArrayList;
/*Generated! Do not modify!*/ import java.util.Arrays;
/*Generated! Do not modify!*/ import java.util.Collection;
/*Generated! Do not modify!*/ import java.util.HashMap;
/*Generated! Do not modify!*/ import java.util.HashSet;
/*Generated! Do not modify!*/ import android.graphics.Bitmap;
/*Generated! Do not modify!*/ import android.graphics.Typeface;
/*Generated! Do not modify!*/ import android.text.Editable;
/*Generated! Do not modify!*/ import android.util.Pair;
/*Generated! Do not modify!*/ import android.content.Context;
/*Generated! Do not modify!*/ import android.view.View;
/*Generated! Do not modify!*/ import android.view.ViewGroup;
/*Generated! Do not modify!*/ import android.view.Gravity;
/*Generated! Do not modify!*/ import android.graphics.Color;
/*Generated! Do not modify!*/ import android.widget.AdapterView;
/*Generated! Do not modify!*/ import android.widget.CompoundButton;
/*Generated! Do not modify!*/ import android.widget.Button;
/*Generated! Do not modify!*/ import android.widget.ListView;
/*Generated! Do not modify!*/ import android.widget.ImageButton;
/*Generated! Do not modify!*/ import android.widget.LinearLayout;
/*Generated! Do not modify!*/ import android.widget.TextView;
/*Generated! Do not modify!*/ import android.widget.EditText;
/*Generated! Do not modify!*/ import android.widget.Spinner;
/*Generated! Do not modify!*/ import android.widget.CheckBox;
/*Generated! Do not modify!*/ import android.widget.ImageView;
/*Generated! Do not modify!*/ import android.widget.ArrayAdapter;
/*Generated! Do not modify!*/ import android.widget.RelativeLayout;
/*Generated! Do not modify!*/ import android.widget.Toast;
/*Generated! Do not modify!*/ import android.widget.ScrollView;
/*Generated! Do not modify!*/ import android.webkit.WebView;
/*Generated! Do not modify!*/ import android.text.TextWatcher;
/*Generated! Do not modify!*/ import android.util.TypedValue;
/*Generated! Do not modify!*/ import android.app.AlertDialog;
/*Generated! Do not modify!*/ import android.app.Activity;
/*Generated! Do not modify!*/ import android.content.DialogInterface;
/*Generated! Do not modify!*/ import android.text.InputType;
/*Generated! Do not modify!*/ import android.graphics.drawable.Drawable;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import com.bright_side_it.fonotes.R; //read from Manifest file in Android project
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import com.google.gson.Gson;
/*Generated! Do not modify!*/ import java.io.File;
/*Generated! Do not modify!*/ import java.io.FileInputStream;
/*Generated! Do not modify!*/ import java.io.IOException;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIString.StringLanguage;
/*Generated! Do not modify!*/ import generated.fliesenui.core.TextHighlighting;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIMessage;
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
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIClientPropertiesDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIImageAssets.ImageAsset;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIAndroidResourceUtil;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIAndroidUtil;
/*Generated! Do not modify!*/ import generated.fliesenui.core.BrightMarkdown;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIDisplayManager;
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
/*Generated! Do not modify!*/ public class OverviewAndroidDisplay extends LinearLayout implements OverviewDisplay{
/*Generated! Do not modify!*/     private Activity activity;
/*Generated! Do not modify!*/     private Context context;
/*Generated! Do not modify!*/     private FLUIDisplayManager displayManager;
/*Generated! Do not modify!*/     private OverviewDisplayEventHandler eventHandler;
/*Generated! Do not modify!*/     private boolean screenActive = false;
/*Generated! Do not modify!*/     private float density = 1f;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private TextView labelColorFilterInfoText;
/*Generated! Do not modify!*/     private TextView labelInfo;
/*Generated! Do not modify!*/     private Button textButtonMenuButton;
/*Generated! Do not modify!*/     private ImageButton imageButtonMenuButton;
/*Generated! Do not modify!*/     private ListView tableNotesTable;
/*Generated! Do not modify!*/     private TextView labelSortInfoText;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private RelativeLayout layoutContainerTopContainer;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private LinearLayout layoutBarSortInfoBar;
/*Generated! Do not modify!*/     private LinearLayout layoutBarColorFilterInfoBar;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private OverviewListDTO dtoItems = null;
/*Generated! Do not modify!*/     private OverviewParameterDTO dtoParameter = null;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public OverviewAndroidDisplay(final Activity activity, FLUIDisplayManager displayManager){
/*Generated! Do not modify!*/         super(activity);
/*Generated! Do not modify!*/         this.context = activity;
/*Generated! Do not modify!*/         this.activity = activity;
/*Generated! Do not modify!*/         this.displayManager = displayManager;
/*Generated! Do not modify!*/         this.density = activity.getResources().getDisplayMetrics().density;
/*Generated! Do not modify!*/         LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
/*Generated! Do not modify!*/         setOrientation(LinearLayout.VERTICAL);
/*Generated! Do not modify!*/         addView(createView(), params);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setScreenActive(boolean active) {
/*Generated! Do not modify!*/         screenActive = active;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onResume() {
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onPause() {
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onBackPressed() {
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setEventHandler(OverviewDisplayEventHandler eventHandler){
/*Generated! Do not modify!*/         this.eventHandler = eventHandler;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onLoaded(FLUIClientPropertiesDTO clientProperties, OverviewParameterDTO parameter){
/*Generated! Do not modify!*/         layoutBarSortInfoBar.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         layoutBarColorFilterInfoBar.setVisibility(View.GONE);
/*Generated! Do not modify!*/         layoutContainerTopContainer.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         eventHandler.onLoaded(clientProperties, parameter);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public View createView(){
/*Generated! Do not modify!*/         Drawable drawable = null;
/*Generated! Do not modify!*/         TextWatcher watcher = null;
/*Generated! Do not modify!*/         LinearLayout.LayoutParams paramsMatchMatch = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
/*Generated! Do not modify!*/         LinearLayout.LayoutParams paramsMatchWrap = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
/*Generated! Do not modify!*/         LinearLayout.LayoutParams paramsWrapMatch = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
/*Generated! Do not modify!*/         LinearLayout.LayoutParams paramsWrapWrap = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
/*Generated! Do not modify!*/         float imageButtonSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_MM, 8, getResources().getDisplayMetrics());
/*Generated! Do not modify!*/         LinearLayout.LayoutParams paramsImageButton = new LinearLayout.LayoutParams((int)imageButtonSize, (int)imageButtonSize);
/*Generated! Do not modify!*/         LinearLayout topView = new LinearLayout(context);
/*Generated! Do not modify!*/         topView.setOrientation(LinearLayout.VERTICAL);
/*Generated! Do not modify!*/         layoutContainerTopContainer = new RelativeLayout(context);
/*Generated! Do not modify!*/         int layoutContainerTopContainerPositionTop = View.generateViewId();
/*Generated! Do not modify!*/         int layoutContainerTopContainerPositionCenter = View.generateViewId();
/*Generated! Do not modify!*/         LinearLayout bar1 = new LinearLayout(context);
/*Generated! Do not modify!*/         bar1.setOrientation(LinearLayout.VERTICAL);
/*Generated! Do not modify!*/         LinearLayout cell2 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell2.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         LinearLayout container4 = new LinearLayout(context);
/*Generated! Do not modify!*/         container4.setOrientation(LinearLayout.VERTICAL);
/*Generated! Do not modify!*/         LinearLayout bar3 = new LinearLayout(context);
/*Generated! Do not modify!*/         bar3.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         LinearLayout cell4 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell4.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         bar3.addView(cell4, new LayoutParams(0, LayoutParams.MATCH_PARENT, 0.05f));
/*Generated! Do not modify!*/         LinearLayout cell5 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell5.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         labelInfo = new TextView(context);
/*Generated! Do not modify!*/         labelInfo.setText("Fonotes - Phone Notes");
/*Generated! Do not modify!*/         labelInfo.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
/*Generated! Do not modify!*/         labelInfo.setTypeface(labelInfo.getTypeface(), Typeface.BOLD);
/*Generated! Do not modify!*/         cell5.addView(labelInfo, paramsMatchWrap);
/*Generated! Do not modify!*/         bar3.addView(cell5, new LayoutParams(0, LayoutParams.MATCH_PARENT, 0.75f));
/*Generated! Do not modify!*/         LinearLayout cell6 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell6.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         textButtonMenuButton = new Button(context);
/*Generated! Do not modify!*/         imageButtonMenuButton = new ImageButton(context);
/*Generated! Do not modify!*/         textButtonMenuButton.setText("Menu");
/*Generated! Do not modify!*/         imageButtonMenuButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         textButtonMenuButton.setOnClickListener(new View.OnClickListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onClick(View view) {
/*Generated! Do not modify!*/                 eventHandler.onMenuButtonClicked(getParameterDTO());
/*Generated! Do not modify!*/             };
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         imageButtonMenuButton.setOnClickListener(new View.OnClickListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onClick(View view) {
/*Generated! Do not modify!*/                 eventHandler.onMenuButtonClicked(getParameterDTO());
/*Generated! Do not modify!*/             };
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         cell6.addView(textButtonMenuButton, paramsMatchWrap);
/*Generated! Do not modify!*/         cell6.addView(imageButtonMenuButton, paramsImageButton);
/*Generated! Do not modify!*/         bar3.addView(cell6, new LayoutParams(0, LayoutParams.MATCH_PARENT, 0.2f));
/*Generated! Do not modify!*/         container4.addView(bar3, paramsMatchWrap);
/*Generated! Do not modify!*/         layoutBarSortInfoBar = new LinearLayout(context);
/*Generated! Do not modify!*/         layoutBarSortInfoBar.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         LinearLayout cell7 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell7.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         layoutBarSortInfoBar.addView(cell7, new LayoutParams(0, LayoutParams.MATCH_PARENT, 0.05f));
/*Generated! Do not modify!*/         LinearLayout cell8 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell8.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         labelSortInfoText = new TextView(context);
/*Generated! Do not modify!*/         labelSortInfoText.setText("");
/*Generated! Do not modify!*/         cell8.addView(labelSortInfoText, paramsMatchWrap);
/*Generated! Do not modify!*/         layoutBarSortInfoBar.addView(cell8, new LayoutParams(0, LayoutParams.MATCH_PARENT, 0.95f));
/*Generated! Do not modify!*/         container4.addView(layoutBarSortInfoBar, paramsMatchWrap);
/*Generated! Do not modify!*/         layoutBarColorFilterInfoBar = new LinearLayout(context);
/*Generated! Do not modify!*/         layoutBarColorFilterInfoBar.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         LinearLayout cell9 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell9.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         layoutBarColorFilterInfoBar.addView(cell9, new LayoutParams(0, LayoutParams.MATCH_PARENT, 0.05f));
/*Generated! Do not modify!*/         LinearLayout cell10 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell10.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         labelColorFilterInfoText = new TextView(context);
/*Generated! Do not modify!*/         labelColorFilterInfoText.setText("");
/*Generated! Do not modify!*/         cell10.addView(labelColorFilterInfoText, paramsMatchWrap);
/*Generated! Do not modify!*/         layoutBarColorFilterInfoBar.addView(cell10, new LayoutParams(0, LayoutParams.MATCH_PARENT, 0.95f));
/*Generated! Do not modify!*/         container4.addView(layoutBarColorFilterInfoBar, paramsMatchWrap);
/*Generated! Do not modify!*/         cell2.addView(container4, paramsMatchWrap);
/*Generated! Do not modify!*/         bar1.addView(cell2, paramsMatchWrap);
/*Generated! Do not modify!*/         layoutContainerTopContainer.addView(bar1, paramsWrapWrap);
/*Generated! Do not modify!*/         bar1.setId(layoutContainerTopContainerPositionTop);
/*Generated! Do not modify!*/         ((RelativeLayout.LayoutParams)bar1.getLayoutParams()).addRule(RelativeLayout.ALIGN_PARENT_TOP);
/*Generated! Do not modify!*/         LinearLayout bar11 = new LinearLayout(context);
/*Generated! Do not modify!*/         bar11.setOrientation(LinearLayout.VERTICAL);
/*Generated! Do not modify!*/         LinearLayout cell12 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell12.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         bar11.addView(cell12, paramsMatchWrap);
/*Generated! Do not modify!*/         LinearLayout cell13 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell13.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         RelativeLayout tablePanelNotesTable = new RelativeLayout(context);
/*Generated! Do not modify!*/         EditText tableFilterNotesTable = new EditText(context);
/*Generated! Do not modify!*/         int tableFilterNotesTableID = View.generateViewId();
/*Generated! Do not modify!*/         tableFilterNotesTable.setId(tableFilterNotesTableID);
/*Generated! Do not modify!*/         watcher = new TextWatcher() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void afterTextChanged(Editable s) {
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void beforeTextChanged(CharSequence s, int start, int count, int after) {
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onTextChanged(CharSequence text, int start, int before, int count) {
/*Generated! Do not modify!*/                 ((TableNotesTableAdapter) tableNotesTable.getAdapter()).onFilterTextChanged("" + text);
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         };
/*Generated! Do not modify!*/         tableFilterNotesTable.addTextChangedListener(watcher);
/*Generated! Do not modify!*/         tableFilterNotesTable.setHint("type to filter");
/*Generated! Do not modify!*/         tableFilterNotesTable.setMaxLines(1);
/*Generated! Do not modify!*/         tablePanelNotesTable.addView(tableFilterNotesTable);
/*Generated! Do not modify!*/         ((RelativeLayout.LayoutParams)tableFilterNotesTable.getLayoutParams()).addRule(RelativeLayout.ALIGN_PARENT_TOP);
/*Generated! Do not modify!*/         ((RelativeLayout.LayoutParams)tableFilterNotesTable.getLayoutParams()).addRule(RelativeLayout.ALIGN_PARENT_LEFT);
/*Generated! Do not modify!*/         ((RelativeLayout.LayoutParams)tableFilterNotesTable.getLayoutParams()).addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
/*Generated! Do not modify!*/         tableNotesTable = new ListView(context);
/*Generated! Do not modify!*/         tableNotesTable.setAdapter(new TableNotesTableAdapter(activity));
/*Generated! Do not modify!*/         tablePanelNotesTable.addView(tableNotesTable);
/*Generated! Do not modify!*/         ((RelativeLayout.LayoutParams)tableNotesTable.getLayoutParams()).addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
/*Generated! Do not modify!*/         ((RelativeLayout.LayoutParams)tableNotesTable.getLayoutParams()).addRule(RelativeLayout.BELOW, tableFilterNotesTableID);
/*Generated! Do not modify!*/         ((RelativeLayout.LayoutParams)tableNotesTable.getLayoutParams()).addRule(RelativeLayout.ALIGN_PARENT_LEFT);
/*Generated! Do not modify!*/         ((RelativeLayout.LayoutParams)tableNotesTable.getLayoutParams()).addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
/*Generated! Do not modify!*/         cell13.addView(tablePanelNotesTable, paramsMatchWrap);
/*Generated! Do not modify!*/         bar11.addView(cell13, paramsMatchWrap);
/*Generated! Do not modify!*/         layoutContainerTopContainer.addView(bar11, paramsWrapWrap);
/*Generated! Do not modify!*/         bar11.setId(layoutContainerTopContainerPositionCenter);
/*Generated! Do not modify!*/         ((RelativeLayout.LayoutParams)bar11.getLayoutParams()).addRule(RelativeLayout.BELOW, layoutContainerTopContainerPositionTop);
/*Generated! Do not modify!*/         topView.addView(layoutContainerTopContainer, paramsMatchWrap);
/*Generated! Do not modify!*/         return topView;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private OverviewListDTO getItemsDTO(){
/*Generated! Do not modify!*/         OverviewListDTO result = dtoItems;
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     private OverviewParameterDTO getParameterDTO(){
/*Generated! Do not modify!*/         OverviewParameterDTO result = dtoParameter;
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     private String toStringOrNull(CharSequence charSequence){
/*Generated! Do not modify!*/         if (charSequence == null){
/*Generated! Do not modify!*/             return null;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return charSequence.toString();
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setInfoText(String text){
/*Generated! Do not modify!*/         labelInfo.setText(text);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setInfoVisible(boolean visible){
/*Generated! Do not modify!*/         labelInfo.setVisibility(visible ? View.VISIBLE: View.GONE);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setMenuButtonText(String text){
/*Generated! Do not modify!*/         textButtonMenuButton.setText(text);
/*Generated! Do not modify!*/         if ((textButtonMenuButton.getVisibility() == View.GONE) && (imageButtonMenuButton.getVisibility() == View.GONE)){
/*Generated! Do not modify!*/             return; //: both buttons are invisible, nothing to do
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if ((text == null) || (text.isEmpty())){
/*Generated! Do not modify!*/             textButtonMenuButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonMenuButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             textButtonMenuButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/             imageButtonMenuButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setMenuButtonVisible(boolean visible){
/*Generated! Do not modify!*/         if (!visible){
/*Generated! Do not modify!*/             textButtonMenuButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonMenuButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             return;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if ((textButtonMenuButton.getText() == null) || (textButtonMenuButton.getText().toString().isEmpty())){
/*Generated! Do not modify!*/             textButtonMenuButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonMenuButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             textButtonMenuButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/             imageButtonMenuButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setSortInfoTextText(String text){
/*Generated! Do not modify!*/         labelSortInfoText.setText(text);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setSortInfoTextVisible(boolean visible){
/*Generated! Do not modify!*/         labelSortInfoText.setVisibility(visible ? View.VISIBLE: View.GONE);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setColorFilterInfoTextText(String text){
/*Generated! Do not modify!*/         labelColorFilterInfoText.setText(text);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setColorFilterInfoTextVisible(boolean visible){
/*Generated! Do not modify!*/         labelColorFilterInfoText.setVisibility(visible ? View.VISIBLE: View.GONE);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setSortInfoBarVisible(boolean visible){
/*Generated! Do not modify!*/         layoutBarSortInfoBar.setVisibility(visible ? View.VISIBLE: View.GONE);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setColorFilterInfoBarVisible(boolean visible){
/*Generated! Do not modify!*/         layoutBarColorFilterInfoBar.setVisibility(visible ? View.VISIBLE: View.GONE);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setTopContainerVisible(boolean visible){
/*Generated! Do not modify!*/         layoutContainerTopContainer.setVisibility(visible ? View.VISIBLE: View.GONE);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setItemsDTO(OverviewListDTO dto){
/*Generated! Do not modify!*/         dtoItems = dto;
/*Generated! Do not modify!*/         ((TableNotesTableAdapter) tableNotesTable.getAdapter()).setItems(dto.getItems());
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setParameterDTO(OverviewParameterDTO dto){
/*Generated! Do not modify!*/         dtoParameter = dto;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void openScreenAbout(OverviewParameterDTO parameter){
/*Generated! Do not modify!*/         displayManager.openScreenAbout(parameter);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void openScreenDetails(DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         displayManager.openScreenDetails(parameter);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void openScreenLogin(){
/*Generated! Do not modify!*/         displayManager.openScreenLogin();
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void openScreenMarkdownHelp(OverviewParameterDTO parameter){
/*Generated! Do not modify!*/         displayManager.openScreenMarkdownHelp(parameter);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void openScreenOverview(OverviewParameterDTO parameter){
/*Generated! Do not modify!*/         displayManager.openScreenOverview(parameter);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void showInputDialog(final InputDialogParameters parameters){
/*Generated! Do not modify!*/         AlertDialog.Builder builder = new AlertDialog.Builder(context);
/*Generated! Do not modify!*/         builder.setTitle(parameters.getTitle());
/*Generated! Do not modify!*/         LinearLayout mainPanel = new LinearLayout(context);
/*Generated! Do not modify!*/         int margin = (int) (context.getResources().getDisplayMetrics().density * 10);
/*Generated! Do not modify!*/         mainPanel.setPadding(margin, margin, margin, margin);
/*Generated! Do not modify!*/         mainPanel.setOrientation(LinearLayout.VERTICAL);
/*Generated! Do not modify!*/         TextView textContentView = new TextView(context);
/*Generated! Do not modify!*/         if ((parameters.getTextContent() != null) && (!parameters.getTextContent().isEmpty())){
/*Generated! Do not modify!*/             textContentView.setText(parameters.getTextContent());
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         mainPanel.addView(textContentView, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
/*Generated! Do not modify!*/         LinearLayout inputPanel = new LinearLayout(context);
/*Generated! Do not modify!*/         inputPanel.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         mainPanel.addView(inputPanel, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
/*Generated! Do not modify!*/         TextView labelView = new TextView(context);
/*Generated! Do not modify!*/         if ((parameters.getLabel() != null) && (!parameters.getLabel().isEmpty())){
/*Generated! Do not modify!*/             labelView.setText(parameters.getLabel() + "  ");
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         inputPanel.addView(labelView, new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
/*Generated! Do not modify!*/         final EditText input = new EditText(context);
/*Generated! Do not modify!*/         input.setInputType(InputType.TYPE_CLASS_TEXT);
/*Generated! Do not modify!*/         inputPanel.addView(input, new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
/*Generated! Do not modify!*/         builder.setView(mainPanel);
/*Generated! Do not modify!*/         if (parameters.getInitialValueText() != null){
/*Generated! Do not modify!*/             input.setText(parameters.getInitialValueText());
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         builder.setPositiveButton(parameters.getOkText(), new DialogInterface.OnClickListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onClick(DialogInterface dialogInterface, int i) {
/*Generated! Do not modify!*/                 eventHandler.onInputDialogResult(parameters, input.getText().toString());
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         builder.setNegativeButton(parameters.getCancelText(), new DialogInterface.OnClickListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onClick(DialogInterface dialogInterface, int i) {
/*Generated! Do not modify!*/                 eventHandler.onInputDialogResult(parameters, null);
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onCancel(DialogInterface dialogInterface) {
/*Generated! Do not modify!*/                 eventHandler.onInputDialogResult(parameters, null);
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         AlertDialog dialog = builder.show();
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void showConfirmDialog(final ConfirmDialogParameters parameters){
/*Generated! Do not modify!*/         AlertDialog.Builder builder = new AlertDialog.Builder(context);
/*Generated! Do not modify!*/         builder.setTitle(parameters.getTitle());
/*Generated! Do not modify!*/         builder.setPositiveButton(parameters.getOkText(), new DialogInterface.OnClickListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onClick(DialogInterface dialogInterface, int i) {
/*Generated! Do not modify!*/                 eventHandler.onConfirmDialogResult(parameters, true);
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         builder.setNegativeButton(parameters.getCancelText(), new DialogInterface.OnClickListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onClick(DialogInterface dialogInterface, int i) {
/*Generated! Do not modify!*/                 eventHandler.onConfirmDialogResult(parameters, false);
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onCancel(DialogInterface dialogInterface) {
/*Generated! Do not modify!*/                 eventHandler.onConfirmDialogResult(parameters, false);
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         AlertDialog dialog = builder.show();
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void showListChooser(final ListChooserParameters parameters) {
/*Generated! Do not modify!*/         List<Pair<Bitmap, String>> values = createListChooserValues(parameters.getItems(), parameters.isShowIcons());
/*Generated! Do not modify!*/         int iconSize = 1;
/*Generated! Do not modify!*/         if (!parameters.isShowIcons()){
/*Generated! Do not modify!*/             iconSize = 0;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if (parameters.isMultiSelect()){
/*Generated! Do not modify!*/             Collection<String> selection = readSelectedItems(parameters.getItems());
/*Generated! Do not modify!*/             FLUIAndroidUtil.showMultiSelectImageAndStringDialog(activity, parameters.getTitle(), values, selection, iconSize, iconSize, 0.3
/*Generated! Do not modify!*/                     , FLUIAndroidUtil.SizeUnit.CM, parameters.isShowFilter(), false, true, new FLUIAndroidUtil.MultiSelectStringDialogListener() {
/*Generated! Do not modify!*/                         @Override
/*Generated! Do not modify!*/                         public void okActionPerformed(List<String> selection) {
/*Generated! Do not modify!*/                             eventHandler.onListChooserResult(parameters, convertLabelsToIDs(parameters.getItems(), selection));
/*Generated! Do not modify!*/                         }
/*Generated! Do not modify!*/                         @Override
/*Generated! Do not modify!*/                         public void cancelActionPerformed() {
/*Generated! Do not modify!*/                             eventHandler.onListChooserResult(parameters, null);
/*Generated! Do not modify!*/                         }
/*Generated! Do not modify!*/                     });
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             FLUIAndroidUtil.showSelectImageAndStringDialog(activity, parameters.getTitle(), values, iconSize, iconSize, 0.3, FLUIAndroidUtil.SizeUnit.CM
/*Generated! Do not modify!*/                     , parameters.isShowFilter(), false, true, null, new FLUIAndroidUtil.SelectStringDialogListener() {
/*Generated! Do not modify!*/                 @Override
/*Generated! Do not modify!*/                 public void okActionPerformed(String selection) {
/*Generated! Do not modify!*/                     eventHandler.onListChooserResult(parameters, convertLabelsToIDs(parameters.getItems(), Arrays.asList(selection)));
/*Generated! Do not modify!*/                 }
/*Generated! Do not modify!*/                 @Override
/*Generated! Do not modify!*/                 public void cancelActionPerformed() {
/*Generated! Do not modify!*/                     eventHandler.onListChooserResult(parameters, null);
/*Generated! Do not modify!*/                 }
/*Generated! Do not modify!*/             });
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private Collection<String> readSelectedItems(List<ListChooserItem> items) {
/*Generated! Do not modify!*/         Set<String> result = new HashSet<>();
/*Generated! Do not modify!*/         for (ListChooserItem i : items){
/*Generated! Do not modify!*/             if (i.isSelected()){
/*Generated! Do not modify!*/                 result.add(i.getID());
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private List<Pair<Bitmap, String>> createListChooserValues(List<ListChooserItem> items, boolean showIcons) {
/*Generated! Do not modify!*/         List<Pair<Bitmap, String>> result = new ArrayList<>();
/*Generated! Do not modify!*/         Map<String, Bitmap> bitmapCache = new HashMap<>();
/*Generated! Do not modify!*/         for (ListChooserItem i : items){
/*Generated! Do not modify!*/             Bitmap bitmap = null;
/*Generated! Do not modify!*/             if ((showIcons) && (i.getImageAssetID() != null)){
/*Generated! Do not modify!*/                 if (bitmapCache.containsKey(i.getImageAssetID())){
/*Generated! Do not modify!*/                     bitmap = bitmapCache.get(i.getImageAssetID());
/*Generated! Do not modify!*/                 } else {
/*Generated! Do not modify!*/                     try{
/*Generated! Do not modify!*/                         int id = FLUIAndroidResourceUtil.getResourceIDForImageAssetID(i.getImageAssetID());
/*Generated! Do not modify!*/                         bitmap = FLUIAndroidUtil.loadImage(activity.getResources(), id);
/*Generated! Do not modify!*/                     } catch (Exception e){
/*Generated! Do not modify!*/                         //: if the image cannot be loaded, don't crash but skip the image
/*Generated! Do not modify!*/                         e.printStackTrace();
/*Generated! Do not modify!*/                     }
/*Generated! Do not modify!*/                     bitmapCache.put(i.getImageAssetID(), bitmap);
/*Generated! Do not modify!*/                 }
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/             result.add(new Pair<Bitmap, String>(bitmap, i.getLabel()));
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private List<String> convertLabelsToIDs(List<ListChooserItem> items, List<String> selection) {
/*Generated! Do not modify!*/         List<String> result = new ArrayList<>();
/*Generated! Do not modify!*/         if (selection == null){
/*Generated! Do not modify!*/             return null;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         Map<String, String> labelToIDMap = new HashMap<>();
/*Generated! Do not modify!*/         for (ListChooserItem i: items){
/*Generated! Do not modify!*/             labelToIDMap.put(i.getLabel(), i.getID());
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         for (String i: selection){
/*Generated! Do not modify!*/             result.add(labelToIDMap.get(i));
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void showMessage(FLUIMessage message) {
/*Generated! Do not modify!*/         FLUIAndroidUtil.showMessage(activity, message);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private class TableNotesTableAdapter extends ArrayAdapter<String> {
/*Generated! Do not modify!*/         private List<OverviewItemDTO> items;
/*Generated! Do not modify!*/         private List<OverviewItemDTO> filteredItems;
/*Generated! Do not modify!*/         private String currentFilter = null;
/*Generated! Do not modify!*/         private float scale;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         public TableNotesTableAdapter(Activity activity){
/*Generated! Do not modify!*/             super(activity, android.R.layout.simple_list_item_1, new ArrayList<String>());
/*Generated! Do not modify!*/             scale = activity.getResources().getDisplayMetrics().density;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         @SuppressWarnings("ResourceType")
/*Generated! Do not modify!*/         public View getView(int position, View convertView, ViewGroup parent) {
/*Generated! Do not modify!*/             View row = convertView;
/*Generated! Do not modify!*/             Bitmap bitmap;
/*Generated! Do not modify!*/             LayoutParams layoutParams;
/*Generated! Do not modify!*/             TextView rowHeightTextView;
/*Generated! Do not modify!*/             TextView column1Item1;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/             if (row == null) {
/*Generated! Do not modify!*/                 LinearLayout panel = new LinearLayout(activity);
/*Generated! Do not modify!*/                 panel.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/                 rowHeightTextView = new TextView(activity);
/*Generated! Do not modify!*/                 panel.addView(rowHeightTextView, new LayoutParams(0, (int)(scale * 40), 0f));
/*Generated! Do not modify!*/                 LinearLayout cell = null;
/*Generated! Do not modify!*/                 column1Item1 = new TextView(activity);
/*Generated! Do not modify!*/                 column1Item1.setId(1);
/*Generated! Do not modify!*/                 layoutParams = new LayoutParams(0, LayoutParams.WRAP_CONTENT, 0.95f);
/*Generated! Do not modify!*/                 layoutParams.setMargins(0, (int)(scale * 3f), 0, (int)(scale * 3f));
/*Generated! Do not modify!*/                 panel.addView(column1Item1, layoutParams);
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/                 row = panel;
/*Generated! Do not modify!*/             } else {
/*Generated! Do not modify!*/                 column1Item1 = (TextView)row.findViewById(1);
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/             OverviewItemDTO item = null;
/*Generated! Do not modify!*/             if (filteredItems != null){
/*Generated! Do not modify!*/                 item = filteredItems.get(position);
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/             final OverviewItemDTO finalItem = item;
/*Generated! Do not modify!*/             column1Item1.setText(item.getLabel());
/*Generated! Do not modify!*/             row.setOnClickListener(new OnClickListener() {
/*Generated! Do not modify!*/                 @Override
/*Generated! Do not modify!*/                 public void onClick(View view) {
/*Generated! Do not modify!*/                     eventHandler.onNotesTableRowClicked(finalItem.getId(), getParameterDTO());
/*Generated! Do not modify!*/                 }
/*Generated! Do not modify!*/             });
/*Generated! Do not modify!*/             String colorString = item.getColor();
/*Generated! Do not modify!*/             if (colorString != null){
/*Generated! Do not modify!*/                 row.setBackgroundColor(Color.parseColor(colorString));
/*Generated! Do not modify!*/             } else {
/*Generated! Do not modify!*/                 row.setBackgroundColor(Color.WHITE);
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/             return row;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         @Override
/*Generated! Do not modify!*/         public int getCount() {
/*Generated! Do not modify!*/             if (filteredItems == null){
/*Generated! Do not modify!*/                 return 0;
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/             return filteredItems.size();
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         @Override
/*Generated! Do not modify!*/         public String getItem(int position) {
/*Generated! Do not modify!*/             return filteredItems.get(position).getId();
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         public void setItems(List<OverviewItemDTO> items) {
/*Generated! Do not modify!*/             this.items = items;
/*Generated! Do not modify!*/             applyFilter();
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         public void onFilterTextChanged(String filterText) {
/*Generated! Do not modify!*/             currentFilter = filterText;
/*Generated! Do not modify!*/             applyFilter();
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         private void applyFilter() {
/*Generated! Do not modify!*/             filteredItems = items;
/*Generated! Do not modify!*/             if ((currentFilter == null) || (currentFilter.isEmpty())){
/*Generated! Do not modify!*/                 filteredItems = items;
/*Generated! Do not modify!*/                 notifyDataSetChanged();
/*Generated! Do not modify!*/                 FLUIAndroidUtil.setListViewHeightBasedOnChildren(tableNotesTable, this);
/*Generated! Do not modify!*/                 return;
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/             String useFilter = currentFilter.toLowerCase();
/*Generated! Do not modify!*/             List<OverviewItemDTO> result = new ArrayList<>();
/*Generated! Do not modify!*/             for (OverviewItemDTO i: items){
/*Generated! Do not modify!*/                 StringBuilder itemText = new StringBuilder();
/*Generated! Do not modify!*/                 itemText.append(i.getLabel() + "\t");
/*Generated! Do not modify!*/                 if (itemText.toString().toLowerCase().contains(useFilter)){
/*Generated! Do not modify!*/                     result.add(i);
/*Generated! Do not modify!*/                 }
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/             filteredItems = result;
/*Generated! Do not modify!*/             notifyDataSetChanged();
/*Generated! Do not modify!*/             FLUIAndroidUtil.setListViewHeightBasedOnChildren(tableNotesTable, this);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }