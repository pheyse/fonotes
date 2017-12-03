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
/*Generated! Do not modify!*/ public class DetailsAndroidDisplay extends LinearLayout implements DetailsDisplay{
/*Generated! Do not modify!*/     private Activity activity;
/*Generated! Do not modify!*/     private Context context;
/*Generated! Do not modify!*/     private FLUIDisplayManager displayManager;
/*Generated! Do not modify!*/     private DetailsDisplayEventHandler eventHandler;
/*Generated! Do not modify!*/     private boolean screenActive = false;
/*Generated! Do not modify!*/     private float density = 1f;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private Timer autosaveTimerTimer;
/*Generated! Do not modify!*/     private TimerTask autosaveTimerTimerTask;
/*Generated! Do not modify!*/     private boolean autosaveTimerTimerActive = false;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private Button textButtonBackButton;
/*Generated! Do not modify!*/     private ImageButton imageButtonBackButton;
/*Generated! Do not modify!*/     private Button textButtonCancelEditNoteTextButton;
/*Generated! Do not modify!*/     private ImageButton imageButtonCancelEditNoteTextButton;
/*Generated! Do not modify!*/     private TextView labelColorLabel;
/*Generated! Do not modify!*/     private Spinner selectBoxColorSelectBox;
/*Generated! Do not modify!*/     private Button textButtonDeleteButton;
/*Generated! Do not modify!*/     private ImageButton imageButtonDeleteButton;
/*Generated! Do not modify!*/     private Button textButtonEditNameButton;
/*Generated! Do not modify!*/     private ImageButton imageButtonEditNameButton;
/*Generated! Do not modify!*/     private TextView labelEditNoteInfoLabel;
/*Generated! Do not modify!*/     private EditText textAreaEditNoteTextArea;
/*Generated! Do not modify!*/     private Button textButtonEditTextButton;
/*Generated! Do not modify!*/     private ImageButton imageButtonEditTextButton;
/*Generated! Do not modify!*/     private TextView labelNoteNameLabel;
/*Generated! Do not modify!*/     private WebView markdownViewNoteView;
/*Generated! Do not modify!*/     private Button textButtonSaveNoteTextButton;
/*Generated! Do not modify!*/     private ImageButton imageButtonSaveNoteTextButton;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private LinearLayout layoutContainerEditNotePanel;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private LinearLayout layoutBarButtonBar;
/*Generated! Do not modify!*/     private LinearLayout layoutBarViewNotePanel;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private LinearLayout layoutCellColorBar;
/*Generated! Do not modify!*/     private LinearLayout layoutCellViewNoteName;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private IdAndLabelListDTO dtoColors = null;
/*Generated! Do not modify!*/     private EditStateDTO dtoEditState = null;
/*Generated! Do not modify!*/     private DetailsParameterDTO dtoParameter = null;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private Map<Integer, String> colorSelectBoxPosToIDMap = new TreeMap<Integer, String>();
/*Generated! Do not modify!*/     private Map<String, Integer> colorSelectBoxIDToPosMap = new TreeMap<String, Integer>();
/*Generated! Do not modify!*/     private boolean colorSelectBoxItemUpdateFinished = true;
/*Generated! Do not modify!*/     public DetailsAndroidDisplay(final Activity activity, FLUIDisplayManager displayManager){
/*Generated! Do not modify!*/         super(activity);
/*Generated! Do not modify!*/         this.context = activity;
/*Generated! Do not modify!*/         this.activity = activity;
/*Generated! Do not modify!*/         this.displayManager = displayManager;
/*Generated! Do not modify!*/         this.density = activity.getResources().getDisplayMetrics().density;
/*Generated! Do not modify!*/         LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
/*Generated! Do not modify!*/         setOrientation(LinearLayout.VERTICAL);
/*Generated! Do not modify!*/         addView(createView(), params);
/*Generated! Do not modify!*/         autosaveTimerTimerTask = new TimerTask(){
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void run(){
/*Generated! Do not modify!*/                 if ((screenActive) && (autosaveTimerTimerActive)){
/*Generated! Do not modify!*/                     activity.runOnUiThread(new Runnable(){
/*Generated! Do not modify!*/                         @Override
/*Generated! Do not modify!*/                         public void run(){
/*Generated! Do not modify!*/                             eventHandler.onAutosaveTimer(getParameterDTO(), toStringOrNull(textAreaEditNoteTextArea.getText()), getEditStateDTO());
/*Generated! Do not modify!*/                         }
/*Generated! Do not modify!*/                     });
/*Generated! Do not modify!*/                 }
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/         };
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setScreenActive(boolean active) {
/*Generated! Do not modify!*/         screenActive = active;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onResume() {
/*Generated! Do not modify!*/         autosaveTimerTimer = new Timer();
/*Generated! Do not modify!*/         autosaveTimerTimer.scheduleAtFixedRate(autosaveTimerTimerTask, 0, 5000);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onPause() {
/*Generated! Do not modify!*/         autosaveTimerTimer.cancel();
/*Generated! Do not modify!*/         autosaveTimerTimer = null;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onBackPressed() {
/*Generated! Do not modify!*/         eventHandler.onBackPressed(getParameterDTO());
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setEventHandler(DetailsDisplayEventHandler eventHandler){
/*Generated! Do not modify!*/         this.eventHandler = eventHandler;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onLoaded(FLUIClientPropertiesDTO clientProperties, DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         layoutCellColorBar.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         layoutCellViewNoteName.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         layoutBarButtonBar.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         layoutBarViewNotePanel.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         layoutContainerEditNotePanel.setVisibility(View.GONE);
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
/*Generated! Do not modify!*/         RelativeLayout container0 = new RelativeLayout(context);
/*Generated! Do not modify!*/         int container0PositionTop = View.generateViewId();
/*Generated! Do not modify!*/         int container0PositionCenter = View.generateViewId();
/*Generated! Do not modify!*/         LinearLayout bar2 = new LinearLayout(context);
/*Generated! Do not modify!*/         bar2.setOrientation(LinearLayout.VERTICAL);
/*Generated! Do not modify!*/         LinearLayout cell3 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell3.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         LinearLayout container5 = new LinearLayout(context);
/*Generated! Do not modify!*/         container5.setOrientation(LinearLayout.VERTICAL);
/*Generated! Do not modify!*/         layoutBarButtonBar = new LinearLayout(context);
/*Generated! Do not modify!*/         layoutBarButtonBar.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         LinearLayout cell4 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell4.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         textButtonBackButton = new Button(context);
/*Generated! Do not modify!*/         imageButtonBackButton = new ImageButton(context);
/*Generated! Do not modify!*/         textButtonBackButton.setText("");
/*Generated! Do not modify!*/         drawable = getResources().getDrawable(R.drawable.flui_generated_back);
/*Generated! Do not modify!*/         drawable.setBounds(0, 0, 72, 72);
/*Generated! Do not modify!*/         imageButtonBackButton.setImageResource(R.drawable.flui_generated_back);
/*Generated! Do not modify!*/         textButtonBackButton.setCompoundDrawables(drawable, null, null, null);
/*Generated! Do not modify!*/         imageButtonBackButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
/*Generated! Do not modify!*/         imageButtonBackButton.setAdjustViewBounds(true);
/*Generated! Do not modify!*/         textButtonBackButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         textButtonBackButton.setOnClickListener(new View.OnClickListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onClick(View view) {
/*Generated! Do not modify!*/                 eventHandler.onBackButtonClicked(getParameterDTO());
/*Generated! Do not modify!*/             };
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         imageButtonBackButton.setOnClickListener(new View.OnClickListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onClick(View view) {
/*Generated! Do not modify!*/                 eventHandler.onBackButtonClicked(getParameterDTO());
/*Generated! Do not modify!*/             };
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         cell4.addView(textButtonBackButton, paramsWrapWrap);
/*Generated! Do not modify!*/         cell4.addView(imageButtonBackButton, paramsImageButton);
/*Generated! Do not modify!*/         textButtonEditTextButton = new Button(context);
/*Generated! Do not modify!*/         imageButtonEditTextButton = new ImageButton(context);
/*Generated! Do not modify!*/         textButtonEditTextButton.setText("Edit text");
/*Generated! Do not modify!*/         imageButtonEditTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         textButtonEditTextButton.setOnClickListener(new View.OnClickListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onClick(View view) {
/*Generated! Do not modify!*/                 eventHandler.onEditTextButtonClicked(getParameterDTO());
/*Generated! Do not modify!*/             };
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         imageButtonEditTextButton.setOnClickListener(new View.OnClickListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onClick(View view) {
/*Generated! Do not modify!*/                 eventHandler.onEditTextButtonClicked(getParameterDTO());
/*Generated! Do not modify!*/             };
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         cell4.addView(textButtonEditTextButton, paramsWrapWrap);
/*Generated! Do not modify!*/         cell4.addView(imageButtonEditTextButton, paramsImageButton);
/*Generated! Do not modify!*/         textButtonEditNameButton = new Button(context);
/*Generated! Do not modify!*/         imageButtonEditNameButton = new ImageButton(context);
/*Generated! Do not modify!*/         textButtonEditNameButton.setText("Edit name");
/*Generated! Do not modify!*/         imageButtonEditNameButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         textButtonEditNameButton.setOnClickListener(new View.OnClickListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onClick(View view) {
/*Generated! Do not modify!*/                 eventHandler.onEditNameButtonClicked(getParameterDTO());
/*Generated! Do not modify!*/             };
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         imageButtonEditNameButton.setOnClickListener(new View.OnClickListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onClick(View view) {
/*Generated! Do not modify!*/                 eventHandler.onEditNameButtonClicked(getParameterDTO());
/*Generated! Do not modify!*/             };
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         cell4.addView(textButtonEditNameButton, paramsWrapWrap);
/*Generated! Do not modify!*/         cell4.addView(imageButtonEditNameButton, paramsImageButton);
/*Generated! Do not modify!*/         textButtonDeleteButton = new Button(context);
/*Generated! Do not modify!*/         imageButtonDeleteButton = new ImageButton(context);
/*Generated! Do not modify!*/         textButtonDeleteButton.setText("");
/*Generated! Do not modify!*/         drawable = getResources().getDrawable(R.drawable.flui_generated_delete);
/*Generated! Do not modify!*/         drawable.setBounds(0, 0, 72, 72);
/*Generated! Do not modify!*/         imageButtonDeleteButton.setImageResource(R.drawable.flui_generated_delete);
/*Generated! Do not modify!*/         textButtonDeleteButton.setCompoundDrawables(drawable, null, null, null);
/*Generated! Do not modify!*/         imageButtonDeleteButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
/*Generated! Do not modify!*/         imageButtonDeleteButton.setAdjustViewBounds(true);
/*Generated! Do not modify!*/         textButtonDeleteButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         textButtonDeleteButton.setOnClickListener(new View.OnClickListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onClick(View view) {
/*Generated! Do not modify!*/                 eventHandler.onDeleteButtonClicked(getParameterDTO());
/*Generated! Do not modify!*/             };
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         imageButtonDeleteButton.setOnClickListener(new View.OnClickListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onClick(View view) {
/*Generated! Do not modify!*/                 eventHandler.onDeleteButtonClicked(getParameterDTO());
/*Generated! Do not modify!*/             };
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         cell4.addView(textButtonDeleteButton, paramsWrapWrap);
/*Generated! Do not modify!*/         cell4.addView(imageButtonDeleteButton, paramsImageButton);
/*Generated! Do not modify!*/         layoutBarButtonBar.addView(cell4, paramsMatchMatch);
/*Generated! Do not modify!*/         container5.addView(layoutBarButtonBar, paramsMatchWrap);
/*Generated! Do not modify!*/         LinearLayout bar5 = new LinearLayout(context);
/*Generated! Do not modify!*/         bar5.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         LinearLayout cell6 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell6.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         bar5.addView(cell6, new LayoutParams(0, LayoutParams.MATCH_PARENT, 0.05f));
/*Generated! Do not modify!*/         layoutCellColorBar = new LinearLayout(context);
/*Generated! Do not modify!*/         layoutCellColorBar.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         labelColorLabel = new TextView(context);
/*Generated! Do not modify!*/         labelColorLabel.setText("Note Color:");
/*Generated! Do not modify!*/         layoutCellColorBar.addView(labelColorLabel, paramsWrapWrap);
/*Generated! Do not modify!*/         selectBoxColorSelectBox = new Spinner(context);
/*Generated! Do not modify!*/         selectBoxColorSelectBox.setMinimumHeight((int)(density * 35));
/*Generated! Do not modify!*/         selectBoxColorSelectBox.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
/*Generated! Do not modify!*/                 if (!colorSelectBoxItemUpdateFinished){
/*Generated! Do not modify!*/                     return;
/*Generated! Do not modify!*/                 }
/*Generated! Do not modify!*/                 eventHandler.onColorSelectBoxChanged(colorSelectBoxPosToIDMap.get(position), getParameterDTO());
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onNothingSelected(AdapterView<?> parentView) {
/*Generated! Do not modify!*/                 if (!colorSelectBoxItemUpdateFinished){
/*Generated! Do not modify!*/                     return;
/*Generated! Do not modify!*/                 }
/*Generated! Do not modify!*/                 eventHandler.onColorSelectBoxChanged(null, getParameterDTO());
/*Generated! Do not modify!*/             }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         layoutCellColorBar.addView(selectBoxColorSelectBox, paramsWrapWrap);
/*Generated! Do not modify!*/         bar5.addView(layoutCellColorBar, new LayoutParams(0, LayoutParams.MATCH_PARENT, 0.95f));
/*Generated! Do not modify!*/         container5.addView(bar5, paramsMatchWrap);
/*Generated! Do not modify!*/         LinearLayout bar7 = new LinearLayout(context);
/*Generated! Do not modify!*/         bar7.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         layoutCellViewNoteName = new LinearLayout(context);
/*Generated! Do not modify!*/         layoutCellViewNoteName.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         labelNoteNameLabel = new TextView(context);
/*Generated! Do not modify!*/         labelNoteNameLabel.setText("My Note 123");
/*Generated! Do not modify!*/         labelNoteNameLabel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0f);
/*Generated! Do not modify!*/         labelNoteNameLabel.setTypeface(labelNoteNameLabel.getTypeface(), Typeface.BOLD);
/*Generated! Do not modify!*/         layoutCellViewNoteName.addView(labelNoteNameLabel, paramsMatchWrap);
/*Generated! Do not modify!*/         bar7.addView(layoutCellViewNoteName, paramsMatchMatch);
/*Generated! Do not modify!*/         container5.addView(bar7, paramsMatchWrap);
/*Generated! Do not modify!*/         LinearLayout bar8 = new LinearLayout(context);
/*Generated! Do not modify!*/         bar8.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         LinearLayout cell9 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell9.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/     TextView cellItemWithoutID10WithClassBasicWidgetAndTypeSPACE = new TextView(context);
/*Generated! Do not modify!*/     cellItemWithoutID10WithClassBasicWidgetAndTypeSPACE.setMinimumHeight(30);
/*Generated! Do not modify!*/         cell9.addView(cellItemWithoutID10WithClassBasicWidgetAndTypeSPACE, paramsMatchWrap);
/*Generated! Do not modify!*/         bar8.addView(cell9, paramsMatchMatch);
/*Generated! Do not modify!*/         container5.addView(bar8, paramsMatchWrap);
/*Generated! Do not modify!*/         cell3.addView(container5, paramsMatchWrap);
/*Generated! Do not modify!*/         bar2.addView(cell3, paramsMatchWrap);
/*Generated! Do not modify!*/         container0.addView(bar2, paramsWrapWrap);
/*Generated! Do not modify!*/         bar2.setId(container0PositionTop);
/*Generated! Do not modify!*/         ((RelativeLayout.LayoutParams)bar2.getLayoutParams()).addRule(RelativeLayout.ALIGN_PARENT_TOP);
/*Generated! Do not modify!*/         LinearLayout bar11 = new LinearLayout(context);
/*Generated! Do not modify!*/         bar11.setOrientation(LinearLayout.VERTICAL);
/*Generated! Do not modify!*/         LinearLayout cell12 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell12.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         LinearLayout container14 = new LinearLayout(context);
/*Generated! Do not modify!*/         container14.setOrientation(LinearLayout.VERTICAL);
/*Generated! Do not modify!*/         layoutBarViewNotePanel = new LinearLayout(context);
/*Generated! Do not modify!*/         layoutBarViewNotePanel.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         LinearLayout cell13 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell13.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         markdownViewNoteView = new WebView(context);
/*Generated! Do not modify!*/         try{
/*Generated! Do not modify!*/             markdownViewNoteView.loadData(new BrightMarkdown().createHTML("My note text"), "text/html; charset=utf-8", "UTF-8");
/*Generated! Do not modify!*/         } catch (Exception ignored){
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         cell13.addView(markdownViewNoteView, paramsMatchWrap);
/*Generated! Do not modify!*/         layoutBarViewNotePanel.addView(cell13, paramsMatchMatch);
/*Generated! Do not modify!*/         container14.addView(layoutBarViewNotePanel, paramsMatchWrap);
/*Generated! Do not modify!*/         LinearLayout bar14 = new LinearLayout(context);
/*Generated! Do not modify!*/         bar14.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         LinearLayout cell15 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell15.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         layoutContainerEditNotePanel = new LinearLayout(context);
/*Generated! Do not modify!*/         layoutContainerEditNotePanel.setOrientation(LinearLayout.VERTICAL);
/*Generated! Do not modify!*/         layoutContainerEditNotePanel.setVisibility(View.GONE);
/*Generated! Do not modify!*/         LinearLayout bar16 = new LinearLayout(context);
/*Generated! Do not modify!*/         bar16.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         LinearLayout cell17 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell17.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         textButtonSaveNoteTextButton = new Button(context);
/*Generated! Do not modify!*/         imageButtonSaveNoteTextButton = new ImageButton(context);
/*Generated! Do not modify!*/         textButtonSaveNoteTextButton.setText("Save");
/*Generated! Do not modify!*/         imageButtonSaveNoteTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         textButtonSaveNoteTextButton.setOnClickListener(new View.OnClickListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onClick(View view) {
/*Generated! Do not modify!*/                 eventHandler.onSaveNoteTextButtonClicked(getParameterDTO(), toStringOrNull(textAreaEditNoteTextArea.getText()));
/*Generated! Do not modify!*/             };
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         imageButtonSaveNoteTextButton.setOnClickListener(new View.OnClickListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onClick(View view) {
/*Generated! Do not modify!*/                 eventHandler.onSaveNoteTextButtonClicked(getParameterDTO(), toStringOrNull(textAreaEditNoteTextArea.getText()));
/*Generated! Do not modify!*/             };
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         cell17.addView(textButtonSaveNoteTextButton, paramsWrapWrap);
/*Generated! Do not modify!*/         cell17.addView(imageButtonSaveNoteTextButton, paramsImageButton);
/*Generated! Do not modify!*/         textButtonCancelEditNoteTextButton = new Button(context);
/*Generated! Do not modify!*/         imageButtonCancelEditNoteTextButton = new ImageButton(context);
/*Generated! Do not modify!*/         textButtonCancelEditNoteTextButton.setText("Cancel");
/*Generated! Do not modify!*/         imageButtonCancelEditNoteTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         textButtonCancelEditNoteTextButton.setOnClickListener(new View.OnClickListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onClick(View view) {
/*Generated! Do not modify!*/                 eventHandler.onCancelEditNoteTextButtonClicked(getParameterDTO());
/*Generated! Do not modify!*/             };
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         imageButtonCancelEditNoteTextButton.setOnClickListener(new View.OnClickListener() {
/*Generated! Do not modify!*/             @Override
/*Generated! Do not modify!*/             public void onClick(View view) {
/*Generated! Do not modify!*/                 eventHandler.onCancelEditNoteTextButtonClicked(getParameterDTO());
/*Generated! Do not modify!*/             };
/*Generated! Do not modify!*/         });
/*Generated! Do not modify!*/         cell17.addView(textButtonCancelEditNoteTextButton, paramsWrapWrap);
/*Generated! Do not modify!*/         cell17.addView(imageButtonCancelEditNoteTextButton, paramsImageButton);
/*Generated! Do not modify!*/         bar16.addView(cell17, paramsMatchMatch);
/*Generated! Do not modify!*/         layoutContainerEditNotePanel.addView(bar16, paramsMatchWrap);
/*Generated! Do not modify!*/         LinearLayout bar18 = new LinearLayout(context);
/*Generated! Do not modify!*/         bar18.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         LinearLayout cell19 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell19.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         textAreaEditNoteTextArea = new EditText(context);
/*Generated! Do not modify!*/         textAreaEditNoteTextArea.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_MULTI_LINE);
/*Generated! Do not modify!*/         textAreaEditNoteTextArea.setText("my note text");
/*Generated! Do not modify!*/         cell19.addView(textAreaEditNoteTextArea, paramsMatchWrap);
/*Generated! Do not modify!*/         bar18.addView(cell19, paramsMatchMatch);
/*Generated! Do not modify!*/         layoutContainerEditNotePanel.addView(bar18, paramsMatchWrap);
/*Generated! Do not modify!*/         LinearLayout bar20 = new LinearLayout(context);
/*Generated! Do not modify!*/         bar20.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         LinearLayout cell21 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell21.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         labelEditNoteInfoLabel = new TextView(context);
/*Generated! Do not modify!*/         labelEditNoteInfoLabel.setText("");
/*Generated! Do not modify!*/         cell21.addView(labelEditNoteInfoLabel, paramsMatchWrap);
/*Generated! Do not modify!*/         bar20.addView(cell21, paramsMatchMatch);
/*Generated! Do not modify!*/         layoutContainerEditNotePanel.addView(bar20, paramsMatchWrap);
/*Generated! Do not modify!*/         cell15.addView(layoutContainerEditNotePanel, paramsMatchWrap);
/*Generated! Do not modify!*/         bar14.addView(cell15, paramsMatchMatch);
/*Generated! Do not modify!*/         container14.addView(bar14, paramsMatchWrap);
/*Generated! Do not modify!*/         cell12.addView(container14, paramsMatchWrap);
/*Generated! Do not modify!*/         bar11.addView(cell12, paramsMatchWrap);
/*Generated! Do not modify!*/         container0.addView(bar11, paramsWrapWrap);
/*Generated! Do not modify!*/         bar11.setId(container0PositionCenter);
/*Generated! Do not modify!*/         ((RelativeLayout.LayoutParams)bar11.getLayoutParams()).addRule(RelativeLayout.BELOW, container0PositionTop);
/*Generated! Do not modify!*/         topView.addView(container0, paramsMatchWrap);
/*Generated! Do not modify!*/         return topView;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private IdAndLabelListDTO getColorsDTO(){
/*Generated! Do not modify!*/         IdAndLabelListDTO result = dtoColors;
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     private EditStateDTO getEditStateDTO(){
/*Generated! Do not modify!*/         EditStateDTO result = dtoEditState;
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     private DetailsParameterDTO getParameterDTO(){
/*Generated! Do not modify!*/         DetailsParameterDTO result = dtoParameter;
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
/*Generated! Do not modify!*/     public void setBackButtonText(String text){
/*Generated! Do not modify!*/         textButtonBackButton.setText(text);
/*Generated! Do not modify!*/         if ((textButtonBackButton.getVisibility() == View.GONE) && (imageButtonBackButton.getVisibility() == View.GONE)){
/*Generated! Do not modify!*/             return; //: both buttons are invisible, nothing to do
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if ((text == null) || (text.isEmpty())){
/*Generated! Do not modify!*/             textButtonBackButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonBackButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             textButtonBackButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/             imageButtonBackButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setBackButtonVisible(boolean visible){
/*Generated! Do not modify!*/         if (!visible){
/*Generated! Do not modify!*/             textButtonBackButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonBackButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             return;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if ((textButtonBackButton.getText() == null) || (textButtonBackButton.getText().toString().isEmpty())){
/*Generated! Do not modify!*/             textButtonBackButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonBackButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             textButtonBackButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/             imageButtonBackButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setEditTextButtonText(String text){
/*Generated! Do not modify!*/         textButtonEditTextButton.setText(text);
/*Generated! Do not modify!*/         if ((textButtonEditTextButton.getVisibility() == View.GONE) && (imageButtonEditTextButton.getVisibility() == View.GONE)){
/*Generated! Do not modify!*/             return; //: both buttons are invisible, nothing to do
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if ((text == null) || (text.isEmpty())){
/*Generated! Do not modify!*/             textButtonEditTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonEditTextButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             textButtonEditTextButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/             imageButtonEditTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setEditTextButtonVisible(boolean visible){
/*Generated! Do not modify!*/         if (!visible){
/*Generated! Do not modify!*/             textButtonEditTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonEditTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             return;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if ((textButtonEditTextButton.getText() == null) || (textButtonEditTextButton.getText().toString().isEmpty())){
/*Generated! Do not modify!*/             textButtonEditTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonEditTextButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             textButtonEditTextButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/             imageButtonEditTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setEditNameButtonText(String text){
/*Generated! Do not modify!*/         textButtonEditNameButton.setText(text);
/*Generated! Do not modify!*/         if ((textButtonEditNameButton.getVisibility() == View.GONE) && (imageButtonEditNameButton.getVisibility() == View.GONE)){
/*Generated! Do not modify!*/             return; //: both buttons are invisible, nothing to do
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if ((text == null) || (text.isEmpty())){
/*Generated! Do not modify!*/             textButtonEditNameButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonEditNameButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             textButtonEditNameButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/             imageButtonEditNameButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setEditNameButtonVisible(boolean visible){
/*Generated! Do not modify!*/         if (!visible){
/*Generated! Do not modify!*/             textButtonEditNameButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonEditNameButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             return;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if ((textButtonEditNameButton.getText() == null) || (textButtonEditNameButton.getText().toString().isEmpty())){
/*Generated! Do not modify!*/             textButtonEditNameButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonEditNameButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             textButtonEditNameButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/             imageButtonEditNameButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setDeleteButtonText(String text){
/*Generated! Do not modify!*/         textButtonDeleteButton.setText(text);
/*Generated! Do not modify!*/         if ((textButtonDeleteButton.getVisibility() == View.GONE) && (imageButtonDeleteButton.getVisibility() == View.GONE)){
/*Generated! Do not modify!*/             return; //: both buttons are invisible, nothing to do
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if ((text == null) || (text.isEmpty())){
/*Generated! Do not modify!*/             textButtonDeleteButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonDeleteButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             textButtonDeleteButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/             imageButtonDeleteButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setDeleteButtonVisible(boolean visible){
/*Generated! Do not modify!*/         if (!visible){
/*Generated! Do not modify!*/             textButtonDeleteButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonDeleteButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             return;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if ((textButtonDeleteButton.getText() == null) || (textButtonDeleteButton.getText().toString().isEmpty())){
/*Generated! Do not modify!*/             textButtonDeleteButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonDeleteButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             textButtonDeleteButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/             imageButtonDeleteButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setColorLabelText(String text){
/*Generated! Do not modify!*/         labelColorLabel.setText(text);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setColorLabelVisible(boolean visible){
/*Generated! Do not modify!*/         labelColorLabel.setVisibility(visible ? View.VISIBLE: View.GONE);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setNoteNameLabelText(String text){
/*Generated! Do not modify!*/         labelNoteNameLabel.setText(text);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setNoteNameLabelVisible(boolean visible){
/*Generated! Do not modify!*/         labelNoteNameLabel.setVisibility(visible ? View.VISIBLE: View.GONE);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setNoteViewText(String text){
/*Generated! Do not modify!*/         markdownViewNoteView.loadData(text, "text/html; charset=utf-8", "UTF-8");
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setNoteViewVisible(boolean visible){
/*Generated! Do not modify!*/         markdownViewNoteView.setVisibility(visible ? View.VISIBLE: View.GONE);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setNoteViewBackgroundColor(String color){
/*Generated! Do not modify!*/         if ((color == null) || (color.isEmpty())){
/*Generated! Do not modify!*/         markdownViewNoteView.setBackgroundColor(Color.WHITE);
/*Generated! Do not modify!*/             return;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         try{
/*Generated! Do not modify!*/             markdownViewNoteView.setBackgroundColor(Color.parseColor(color));
/*Generated! Do not modify!*/         } catch (Exception e){
/*Generated! Do not modify!*/             new Exception("Could not read color '" + color + "'").printStackTrace();
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setSaveNoteTextButtonText(String text){
/*Generated! Do not modify!*/         textButtonSaveNoteTextButton.setText(text);
/*Generated! Do not modify!*/         if ((textButtonSaveNoteTextButton.getVisibility() == View.GONE) && (imageButtonSaveNoteTextButton.getVisibility() == View.GONE)){
/*Generated! Do not modify!*/             return; //: both buttons are invisible, nothing to do
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if ((text == null) || (text.isEmpty())){
/*Generated! Do not modify!*/             textButtonSaveNoteTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonSaveNoteTextButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             textButtonSaveNoteTextButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/             imageButtonSaveNoteTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setSaveNoteTextButtonVisible(boolean visible){
/*Generated! Do not modify!*/         if (!visible){
/*Generated! Do not modify!*/             textButtonSaveNoteTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonSaveNoteTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             return;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if ((textButtonSaveNoteTextButton.getText() == null) || (textButtonSaveNoteTextButton.getText().toString().isEmpty())){
/*Generated! Do not modify!*/             textButtonSaveNoteTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonSaveNoteTextButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             textButtonSaveNoteTextButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/             imageButtonSaveNoteTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setCancelEditNoteTextButtonText(String text){
/*Generated! Do not modify!*/         textButtonCancelEditNoteTextButton.setText(text);
/*Generated! Do not modify!*/         if ((textButtonCancelEditNoteTextButton.getVisibility() == View.GONE) && (imageButtonCancelEditNoteTextButton.getVisibility() == View.GONE)){
/*Generated! Do not modify!*/             return; //: both buttons are invisible, nothing to do
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if ((text == null) || (text.isEmpty())){
/*Generated! Do not modify!*/             textButtonCancelEditNoteTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonCancelEditNoteTextButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             textButtonCancelEditNoteTextButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/             imageButtonCancelEditNoteTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setCancelEditNoteTextButtonVisible(boolean visible){
/*Generated! Do not modify!*/         if (!visible){
/*Generated! Do not modify!*/             textButtonCancelEditNoteTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonCancelEditNoteTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             return;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         if ((textButtonCancelEditNoteTextButton.getText() == null) || (textButtonCancelEditNoteTextButton.getText().toString().isEmpty())){
/*Generated! Do not modify!*/             textButtonCancelEditNoteTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/             imageButtonCancelEditNoteTextButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             textButtonCancelEditNoteTextButton.setVisibility(View.VISIBLE);
/*Generated! Do not modify!*/             imageButtonCancelEditNoteTextButton.setVisibility(View.GONE);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setEditNoteTextAreaText(String text){
/*Generated! Do not modify!*/         textAreaEditNoteTextArea.setText(text);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setEditNoteTextAreaVisible(boolean visible){
/*Generated! Do not modify!*/         textAreaEditNoteTextArea.setVisibility(visible ? View.VISIBLE: View.GONE);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setEditNoteTextAreaBackgroundColor(String color){
/*Generated! Do not modify!*/         if ((color == null) || (color.isEmpty())){
/*Generated! Do not modify!*/         textAreaEditNoteTextArea.setBackgroundColor(Color.WHITE);
/*Generated! Do not modify!*/             return;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         try{
/*Generated! Do not modify!*/             textAreaEditNoteTextArea.setBackgroundColor(Color.parseColor(color));
/*Generated! Do not modify!*/         } catch (Exception e){
/*Generated! Do not modify!*/             new Exception("Could not read color '" + color + "'").printStackTrace();
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setEditNoteInfoLabelText(String text){
/*Generated! Do not modify!*/         labelEditNoteInfoLabel.setText(text);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setEditNoteInfoLabelVisible(boolean visible){
/*Generated! Do not modify!*/         labelEditNoteInfoLabel.setVisibility(visible ? View.VISIBLE: View.GONE);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setColorBarVisible(boolean visible){
/*Generated! Do not modify!*/         layoutCellColorBar.setVisibility(visible ? View.VISIBLE: View.GONE);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setViewNoteNameVisible(boolean visible){
/*Generated! Do not modify!*/         layoutCellViewNoteName.setVisibility(visible ? View.VISIBLE: View.GONE);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setButtonBarVisible(boolean visible){
/*Generated! Do not modify!*/         layoutBarButtonBar.setVisibility(visible ? View.VISIBLE: View.GONE);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setViewNotePanelVisible(boolean visible){
/*Generated! Do not modify!*/         layoutBarViewNotePanel.setVisibility(visible ? View.VISIBLE: View.GONE);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setEditNotePanelVisible(boolean visible){
/*Generated! Do not modify!*/         layoutContainerEditNotePanel.setVisibility(visible ? View.VISIBLE: View.GONE);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setBackButtonImageAsset(ImageAsset imageAsset){
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setDeleteButtonImageAsset(ImageAsset imageAsset){
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setAutosaveTimerActive(boolean active){
/*Generated! Do not modify!*/         autosaveTimerTimerActive = active;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setColorsDTO(IdAndLabelListDTO dto){
/*Generated! Do not modify!*/         dtoColors = dto;
/*Generated! Do not modify!*/         List<IdAndLabelDTO> dtoItemsOfColorSelectBox = null;
/*Generated! Do not modify!*/         if (dto != null){
/*Generated! Do not modify!*/             dtoItemsOfColorSelectBox = dto.getItems();
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         colorSelectBoxItemUpdateFinished = false;
/*Generated! Do not modify!*/         colorSelectBoxIDToPosMap = createColorSelectBoxIDToPosMap(dtoItemsOfColorSelectBox);
/*Generated! Do not modify!*/         colorSelectBoxPosToIDMap = createColorSelectBoxPosToIDMap(dtoItemsOfColorSelectBox);
/*Generated! Do not modify!*/         selectBoxColorSelectBox.setAdapter(new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, colorSelectBoxCreateLabels(dtoItemsOfColorSelectBox)));
/*Generated! Do not modify!*/         colorSelectBoxItemUpdateFinished = true;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setEditStateDTO(EditStateDTO dto){
/*Generated! Do not modify!*/         dtoEditState = dto;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setParameterDTO(DetailsParameterDTO dto){
/*Generated! Do not modify!*/         dtoParameter = dto;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setColorSelectBoxSelectedID(String selectedID){
/*Generated! Do not modify!*/         colorSelectBoxItemUpdateFinished = false;
/*Generated! Do not modify!*/         if (selectedID == null){
/*Generated! Do not modify!*/             selectBoxColorSelectBox.setSelection(-1);
/*Generated! Do not modify!*/             colorSelectBoxItemUpdateFinished = true;
/*Generated! Do not modify!*/             return;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         Integer pos = colorSelectBoxIDToPosMap.get(selectedID);
/*Generated! Do not modify!*/         if (pos != null){
/*Generated! Do not modify!*/             selectBoxColorSelectBox.setSelection(pos);
/*Generated! Do not modify!*/         } else {
/*Generated! Do not modify!*/             selectBoxColorSelectBox.setSelection(-1);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         colorSelectBoxItemUpdateFinished = true;
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
/*Generated! Do not modify!*/     private Map<String, Integer> createColorSelectBoxIDToPosMap(List<IdAndLabelDTO> items){
/*Generated! Do not modify!*/         Map<String, Integer> result = new TreeMap<String, Integer>();
/*Generated! Do not modify!*/         if (items == null){
/*Generated! Do not modify!*/             return result;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         int pos = 0;
/*Generated! Do not modify!*/         for (IdAndLabelDTO i: items){
/*Generated! Do not modify!*/             result.put(i.getId(), pos);
/*Generated! Do not modify!*/             pos++;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private Map<Integer, String> createColorSelectBoxPosToIDMap(List<IdAndLabelDTO> items){
/*Generated! Do not modify!*/         Map<Integer, String> result = new TreeMap<Integer, String>();
/*Generated! Do not modify!*/         if (items == null){
/*Generated! Do not modify!*/             return result;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         int pos = 0;
/*Generated! Do not modify!*/         for (IdAndLabelDTO i: items){
/*Generated! Do not modify!*/             result.put(pos, i.getId());
/*Generated! Do not modify!*/             pos++;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private List<String> colorSelectBoxCreateLabels(List<IdAndLabelDTO> items){
/*Generated! Do not modify!*/         List<String> result = new ArrayList<String>();
/*Generated! Do not modify!*/         if (items == null){
/*Generated! Do not modify!*/             return result;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         for (IdAndLabelDTO i: items){
/*Generated! Do not modify!*/             result.add(i.getLabel());
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }