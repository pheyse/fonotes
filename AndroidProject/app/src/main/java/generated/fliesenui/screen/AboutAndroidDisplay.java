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
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIScreenManagerAndroid;
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
/*Generated! Do not modify!*/ public class AboutAndroidDisplay extends LinearLayout implements AboutDisplay{
/*Generated! Do not modify!*/     private Activity activity;
/*Generated! Do not modify!*/     private Context context;
/*Generated! Do not modify!*/     private FLUIDisplayManager displayManager;
/*Generated! Do not modify!*/     private FLUIScreenManagerAndroid screenManager;
/*Generated! Do not modify!*/     private AboutDisplayEventHandler eventHandler;
/*Generated! Do not modify!*/     private boolean screenActive = false;
/*Generated! Do not modify!*/     private float density = 1f;
/*Generated! Do not modify!*/     private float xdpi = 1f;
/*Generated! Do not modify!*/     private float ydpi = 1f;
/*Generated! Do not modify!*/     private static final double CM_TO_INCH_FACTOR = 0.393701;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private WebView markdownViewAboutText;
/*Generated! Do not modify!*/     private Button textButtonBackButton;
/*Generated! Do not modify!*/     private ImageButton imageButtonBackButton;
/*Generated! Do not modify!*/     private TextView labelInfo;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private OverviewParameterDTO dtoParameter = null;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public AboutAndroidDisplay(final Activity activity, FLUIDisplayManager displayManager, FLUIScreenManagerAndroid screenManager){
/*Generated! Do not modify!*/         super(activity);
/*Generated! Do not modify!*/         this.context = activity;
/*Generated! Do not modify!*/         this.activity = activity;
/*Generated! Do not modify!*/         this.displayManager = displayManager;
/*Generated! Do not modify!*/         this.screenManager = screenManager;
/*Generated! Do not modify!*/         this.density = activity.getResources().getDisplayMetrics().density;
/*Generated! Do not modify!*/         this.xdpi = activity.getResources().getDisplayMetrics().xdpi;
/*Generated! Do not modify!*/         this.ydpi = activity.getResources().getDisplayMetrics().ydpi;
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
/*Generated! Do not modify!*/         eventHandler.onBackPressed(getParameterDTO());
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void setEventHandler(AboutDisplayEventHandler eventHandler){
/*Generated! Do not modify!*/         this.eventHandler = eventHandler;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void onLoaded(FLUIClientPropertiesDTO clientProperties, OverviewParameterDTO parameter){
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
/*Generated! Do not modify!*/         LinearLayout container0 = new LinearLayout(context);
/*Generated! Do not modify!*/         container0.setOrientation(LinearLayout.VERTICAL);
/*Generated! Do not modify!*/         LinearLayout bar2 = new LinearLayout(context);
/*Generated! Do not modify!*/         bar2.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         LinearLayout cell3 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell3.setOrientation(LinearLayout.HORIZONTAL);
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
/*Generated! Do not modify!*/         cell3.addView(textButtonBackButton, paramsMatchWrap);
/*Generated! Do not modify!*/         cell3.addView(imageButtonBackButton, paramsImageButton);
/*Generated! Do not modify!*/         bar2.addView(cell3, new LayoutParams(0, LayoutParams.MATCH_PARENT, 0.15f));
/*Generated! Do not modify!*/         LinearLayout cell4 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell4.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         labelInfo = new TextView(context);
/*Generated! Do not modify!*/         labelInfo.setText("About Fonotes");
/*Generated! Do not modify!*/         labelInfo.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30.0f);
/*Generated! Do not modify!*/         labelInfo.setTypeface(labelInfo.getTypeface(), Typeface.BOLD);
/*Generated! Do not modify!*/         cell4.addView(labelInfo, paramsMatchWrap);
/*Generated! Do not modify!*/         bar2.addView(cell4, new LayoutParams(0, LayoutParams.MATCH_PARENT, 0.85f));
/*Generated! Do not modify!*/         container0.addView(bar2, paramsMatchWrap);
/*Generated! Do not modify!*/         LinearLayout bar5 = new LinearLayout(context);
/*Generated! Do not modify!*/         bar5.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         LinearLayout cell6 = new LinearLayout(context);
/*Generated! Do not modify!*/         cell6.setOrientation(LinearLayout.HORIZONTAL);
/*Generated! Do not modify!*/         markdownViewAboutText = new WebView(context);
/*Generated! Do not modify!*/         try{
/*Generated! Do not modify!*/             markdownViewAboutText.loadData(new BrightMarkdown().createHTML("..."), "text/html; charset=utf-8", "UTF-8");
/*Generated! Do not modify!*/         } catch (Exception ignored){
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         cell6.addView(markdownViewAboutText, paramsMatchWrap);
/*Generated! Do not modify!*/         bar5.addView(cell6, paramsMatchMatch);
/*Generated! Do not modify!*/         container0.addView(bar5, paramsMatchWrap);
/*Generated! Do not modify!*/         topView.addView(container0, paramsMatchWrap);
/*Generated! Do not modify!*/         ScrollView topScrollView = new ScrollView(context);
/*Generated! Do not modify!*/         topScrollView.setBackgroundColor(Color.TRANSPARENT);
/*Generated! Do not modify!*/         topScrollView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
/*Generated! Do not modify!*/         topScrollView.addView(topView);
/*Generated! Do not modify!*/         return topScrollView;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
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
/*Generated! Do not modify!*/     public void setAboutTextText(String text){
/*Generated! Do not modify!*/         markdownViewAboutText.loadDataWithBaseURL("same://ur/l/tat/does/not/work", text, "text/html; charset=utf-8", "UTF-8", null);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setAboutTextVisible(boolean visible){
/*Generated! Do not modify!*/         markdownViewAboutText.setVisibility(visible ? View.VISIBLE: View.GONE);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setAboutTextBackgroundColor(String color){
/*Generated! Do not modify!*/         if ((color == null) || (color.isEmpty())){
/*Generated! Do not modify!*/         markdownViewAboutText.setBackgroundColor(Color.WHITE);
/*Generated! Do not modify!*/             return;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         try{
/*Generated! Do not modify!*/             markdownViewAboutText.setBackgroundColor(Color.parseColor(color));
/*Generated! Do not modify!*/         } catch (Exception e){
/*Generated! Do not modify!*/             new Exception("Could not read color '" + color + "'").printStackTrace();
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void setBackButtonImageAsset(ImageAsset imageAsset){
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
/*Generated! Do not modify!*/     @Override
/*Generated! Do not modify!*/     public void downloadFile(String downloadFileStreamID) {
/*Generated! Do not modify!*/         FLUIAndroidUtil.downloadFile(activity, screenManager, downloadFileStreamID);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ }