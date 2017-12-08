package generated.fliesenui.core;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Display;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.WebSettings.ZoomDensity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import static generated.fliesenui.core.FLUIMessage.*;

public class FLUIAndroidUtil {
    public enum SizeUnit {DIP, CM}
    public static final float INCH_TO_CM_FACTOR = 2.54f;
    public static final double DEFAULT_TEXT_SIZE_IN_DIP = 20d;
    private static final SortedSet<Character> SEPARATING_CHARS = getSeparatingChars();

    private static final String DIR_ICON_BASE_64 = "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";
    private static final String FILE_ICON_BASE_64 = "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";
    private static final String DIR_UP_ICON_BASE_64 = "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";


    public interface SelectStringDialogListener{
        void okActionPerformed(String selection);
        void cancelActionPerformed();
    }

    public interface MultiSelectStringDialogListener{
        void okActionPerformed(List<String> selection);
        void cancelActionPerformed();
    }

    public static void showSelectImageAndStringDialog(final Activity activity
            , String title
            , List<Pair<Bitmap, String>> values
            , double maxImageWidthInCM
            , double maxImageHeightInCM
            , double textSize
            , SizeUnit sizeUnit
            , final SelectStringDialogListener listener){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);
        final ListView listView = new ListView(activity);
        listView.setAdapter(new FLUIAndroidIconAndLabelListAdapter(activity, values, maxImageWidthInCM, maxImageHeightInCM, textSize, sizeUnit));
        builder.setView(listView);
        final Dialog dialog = builder.create();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = listView.getItemAtPosition(position);
                dialog.cancel();
                if (item == null) listener.okActionPerformed(null);
                else listener.okActionPerformed("" + item);
            }
        });
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                listener.cancelActionPerformed();
            }
        });
        dialog.show();
    }

    public static void showMultiSelectImageAndStringDialog(final Activity activity
            , String title
            , List<Pair<Bitmap, String>> values
            , Collection<String> preSelectedValues
            , double maxImageWidthInCM
            , double maxImageHeightInCM
            , double textSize
            , SizeUnit sizeUnit
            , boolean showFilter
            , boolean matchCaseInFilter
            , boolean containsMode
            , final MultiSelectStringDialogListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);

        LinearLayout mainPanel = new LinearLayout(activity);
        mainPanel.setOrientation(LinearLayout.VERTICAL);

        Button okButton = new Button(activity);
        okButton.setText("OK");

        final ListView listView = new ListView(activity);
        final SortedSet<String> allSelectedItems = new TreeSet<String>(FLUIUtil.nullValue(preSelectedValues, new TreeSet<String>()));
        FLUIAndroidIconLabelAndCheckListAdapter adapter = null;
        SortedSet<Integer> checkedPositions = createCheckedPositions(values, allSelectedItems);

        adapter = new FLUIAndroidIconLabelAndCheckListAdapter(activity, values, maxImageWidthInCM, maxImageHeightInCM, textSize, sizeUnit, checkedPositions);
        final ReturnableObject<FLUIAndroidIconLabelAndCheckListAdapter> currentCheckListAdapter
                = new ReturnableObject<FLUIAndroidIconLabelAndCheckListAdapter>(adapter);
        listView.setAdapter(adapter);
        listView.setItemsCanFocus(false);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        mainPanel.addView(okButton, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);


        EditText filterText = null;
        if (showFilter){
            filterText = new EditText(activity);

            TextWatcher watcher = createSelectStringDialogFilterTextWatcher(activity
                    , values
                    , maxImageWidthInCM
                    , maxImageHeightInCM
                    , filterText
                    , matchCaseInFilter
                    , containsMode
                    , true
                    , listView
                    , allSelectedItems
                    , currentCheckListAdapter);
            filterText.addTextChangedListener(watcher);
            filterText.setHint("type to filter");
            filterText.setMaxLines(1);
            mainPanel.addView(filterText, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        }
        mainPanel.addView(listView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        builder.setView(mainPanel);
        final Dialog dialog = builder.create();

        okButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                dialog.dismiss();
                if ((currentCheckListAdapter != null) && (currentCheckListAdapter.get() != null)){
                    allSelectedItems.addAll(currentCheckListAdapter.get().getSelectedItems());
                    allSelectedItems.removeAll(currentCheckListAdapter.get().getUnselectedItems());
                }
                listener.okActionPerformed(new ArrayList<String>(allSelectedItems));
            }
        });

        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                listener.cancelActionPerformed();
            }
        });
        dialog.show();
        makeDialogBig(dialog);
    }

    private static SortedSet<Integer> createCheckedPositions(List<Pair<Bitmap, String>> values, SortedSet<String> allSelectedItems) {
        SortedSet<Integer> result = new TreeSet<Integer>();
        for (int i = 0; i < values.size(); i++){
            if (allSelectedItems.contains(values.get(i).second)) result.add(i);
        }
        return result;
    }

    public static Bitmap loadImage(Resources resources, int resourceID) throws Exception {
        InputStream inputStream = null;
        try{
            inputStream = resources.openRawResource(resourceID);
            return BitmapFactory.decodeStream(inputStream);
        } catch (Exception e){
            throw e;
        } finally {
            if (inputStream != null) inputStream.close();
        }
    }

    public static float getPixelHeightForCM(Activity activity, float heightInCM){
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return heightInCM  / INCH_TO_CM_FACTOR * metrics.ydpi;
    }

    public static float getPixelWidthForCM(Activity activity, float widthInCM){
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return widthInCM  / INCH_TO_CM_FACTOR * metrics.xdpi;
    }

    public static float getPixelWidthForCM(Activity activity, double widthInCM){
        return getPixelWidthForCM(activity, (float)widthInCM);
    }

    public static float getPixelHeightForCM(Activity activity, double value) {
        return getPixelHeightForCM(activity, (float)value);
    }


    public static int drawAndWrapTextBelowWithOutline(String text
            , int x
            , int y
            , int maxX
            , int rowHeight
            , Canvas canvas
            , Paint paint
            , FontMetricsInt metrics
            , boolean measureOnly
            , boolean breakWithinWords
            , Integer innerColor
            , Integer outlineColor) {
        return drawAndWrapTextWithOutline(text, x, y + getDrawTextBelowOffset(metrics), maxX, rowHeight, canvas, paint, measureOnly, breakWithinWords, innerColor
                , outlineColor);
    }

    public static int drawAndWrapTextBelowWithOutline(String text
            , int x
            , int y
            , int maxX
            , Canvas canvas
            , Paint paint
            , FontMetricsInt metrics
            , boolean measureOnly
            , boolean breakWithinWords
            , Integer innerColor
            , Integer outlineColor) {
        return drawAndWrapTextWithOutline(text, x, y + getDrawTextBelowOffset(metrics), maxX, + getDrawTextBelowOffset(metrics), canvas, paint, measureOnly, breakWithinWords, innerColor
                , outlineColor);
    }

    public static void drawAndWrapTextBelowWithOutline(String text
            , int x
            , int y
            , int maxX
            , Canvas canvas
            , Paint paint
            , Integer innerColor
            , Integer outlineColor) {
        drawAndWrapTextBelowWithOutline(text, x, y, maxX, canvas, paint, paint.getFontMetricsInt(), false, false, innerColor , outlineColor);
    }

    public static void drawAndWrapTextBelow(String text
            , int x
            , int y
            , int maxX
            , Canvas canvas
            , Paint paint
            , int innerColor){
        FontMetricsInt metrics = paint.getFontMetricsInt();
//		EasyAndroidLogger.debug("metrics.top = " + metrics.top);

        drawAndWrapTextBelowWithOutline(text, x, y, maxX, canvas, paint, metrics, false, false, innerColor, null);
    }

    public static int drawAndWrapTextWithOutline(String text
            , int x
            , int y
            , int maxX
            , int rowHeight
            , Canvas canvas
            , Paint paint
            , boolean measureOnly
            , boolean breakWithinWords
            , Integer innerColor
            , Integer outlineColor) {
//    	EasyAndroidLogger.debug("text = >>" + text + "<<, x = " + x + ", y = " + y + ", maxX = " + maxX + ", rowHeight = " + rowHeight + ", measureOnly = " + measureOnly);
        int height = rowHeight;
        int posX = x;
        List<StringBuilder> items = getItems(text, breakWithinWords);
//    	EasyAndroidLogger.debug("items: " + EasyUtil.toString(items, "\n - >>", "<<", ""));
        int posY = y;
        boolean firstItem = true;

        for (StringBuilder stringBuilderItem: items){
            String i = stringBuilderItem.toString();
            int width = (int) Math.ceil(paint.measureText(i));
            if ("\n".equals(i)){
                posY += rowHeight;
                height += rowHeight;
                posX = x;
            } else if (posX + width <= maxX){ //: item fits in line: draw
                if (!measureOnly) drawTextWithOutline(canvas, paint, posX, posY, innerColor, outlineColor, "" + i);
                posX += width;
            } else if (!" ".equals(i)){ //: line break required
                if (!firstItem){
                    posY += rowHeight;
                    height += rowHeight;
                    posX = x;
                }
                if (posX + width <= maxX){ //: item fits now: draw
                    if (!measureOnly) drawTextWithOutline(canvas, paint, posX, posY, innerColor, outlineColor, "" + i);
                    posX += width;
                } else{ //: draw as many characters as possible and break withn the item
                    for (char c: i.toCharArray()){
                        width = (int) Math.ceil(paint.measureText("" + c));
                        if (posX + width > maxX){
                            posY += rowHeight;
                            height += rowHeight;
                            posX = x;
                        }
                        if (!measureOnly) drawTextWithOutline(canvas, paint, posX, posY, innerColor, outlineColor, "" + c);
                        posX += width;
                    }
                }
            }
            firstItem = false;
        }
        return height;
    }

    public static void drawTextWithOutline(Canvas canvas
            , Paint paint
            , int x
            , int y
            , Integer innerColor
            , Integer outlineColor
            , String text){

//    	EasyAndroidLogger.debug("x = " + x + ", y = " + y + ", text = >>" + text + "<<");

        if ((outlineColor != null) && (outlineColor != Color.TRANSPARENT)){
//    		EasyAndroidLogger.debug("draw outline");
            paint.setColor(outlineColor);
            for (int textOffsetX = -1; textOffsetX <= 1; textOffsetX ++){
                for (int textOffsetY = -1; textOffsetY <= 1; textOffsetY ++){
                    if ((textOffsetX != 0) || (textOffsetY != 0)) canvas.drawText(text, x + textOffsetX, y + textOffsetY, paint);
                }
            }
        }

        if ((innerColor != null) && (innerColor != Color.TRANSPARENT)){
//    		EasyAndroidLogger.debug("draw inside");
            paint.setColor(innerColor);
            canvas.drawText(text, x, y, paint);
        }
    }

    private static List<StringBuilder> getItems(String text, boolean breakWithinWords){
        List<StringBuilder> result = new ArrayList<StringBuilder>();

        if (breakWithinWords){
            for (char i: text.toCharArray()){
                result.add(new StringBuilder("" + i));
            }
            return result;
        }

        StringBuilder currentItem = null;
        for (char i: text.toCharArray()){
//        	EasyAndroidLogger.debug("i = >>" + i + "<<");

            if (currentItem == null){
                if ('\n' == i){
                    result.add(new StringBuilder("\n"));
                    currentItem = null;
                } else {
                    currentItem = new StringBuilder();
                    currentItem.append(i);
                    result.add(currentItem);
                }
            } else if ('\n' == i){
                result.add(new StringBuilder("\n"));
                currentItem = null;
            } else if (SEPARATING_CHARS.contains(i)){
                currentItem.append(i);
                result.add(new StringBuilder(""));
                currentItem = null;
            } else{
                currentItem.append(i);
            }
        }
        return result;
    }

    private static SortedSet<Character> getSeparatingChars() {
        SortedSet<Character> set = new TreeSet<Character>();
        set.add(' ');
        set.add('.');
        set.add(',');
        set.add(';');
        set.add(':');
        set.add('!');
        set.add('?');
        set.add('-');
        set.add('(');
        set.add(')');
        set.add('[');
        set.add(']');
        set.add('{');
        set.add('}');
        set.add('/');
        set.add('+');
        set.add('\\');
        set.add('<');
        set.add('>');
        set.add('=');
        set.add('&');
        set.add('\n');
        return set;
    }

    public static void drawPathWithOutline(Canvas canvas, Path path, int fillColor, int outlineColor){
        Paint paint = new Paint();
        paint.setStyle(Style.FILL);
        paint.setColor(fillColor);
        canvas.drawPath(path, paint);
        paint.setStyle(Style.STROKE);
        paint.setColor(outlineColor);
        canvas.drawPath(path, paint);
    }

    private static TextWatcher createSelectStringDialogFilterTextWatcher(final Activity activity
            , final List<Pair<Bitmap, String>> values
            , final double maxImageWidthInCM
            , final double maxImageHeightInCM
            , EditText filterText
            , final boolean matchCase
            , final boolean containsMode
            , final boolean multiSelect
            , final ListView list
            , final SortedSet<String> allSelectedItems
            , final ReturnableObject<FLUIAndroidIconLabelAndCheckListAdapter>
                                                                                 currentCheckListAdapter) {
        return createSelectStringDialogFilterTextWatcher(activity
                , values
                , maxImageWidthInCM
                , maxImageHeightInCM
                , DEFAULT_TEXT_SIZE_IN_DIP
                , SizeUnit.DIP
                , filterText
                , matchCase
                , containsMode
                , multiSelect
                , list
                , allSelectedItems
                , currentCheckListAdapter);
    }

    private static TextWatcher createSelectStringDialogFilterTextWatcher(final Activity activity
            , final List<Pair<Bitmap, String>> values
            , final double maxImageWidthInCM
            , final double maxImageHeightInCM
            , final double textSize
            , final SizeUnit sizeUnit
            , EditText filterText
            , final boolean matchCase
            , final boolean containsMode
            , final boolean multiSelect
            , final ListView list
            , final SortedSet<String> allSelectedItems
            , final ReturnableObject<FLUIAndroidIconLabelAndCheckListAdapter>
                                                                                 currentCheckListAdapter) {
        return new TextWatcher() {
            private List<Pair<Bitmap, String>> filteredValues = null;
            private List<String> unfilteredItemNames = getStringValues(values, false);
            private List<String> unfilteredItemNamesInUpperCase = getStringValues(values, true);

            private List<String> getStringValues(List<Pair<Bitmap, String>> valuesToProcess, boolean upperCase) {
                List<String> result = new ArrayList<String>();
                for (Pair<Bitmap, String> i: valuesToProcess){
                    if (upperCase) result.add(toUpperCaseIgnoreLocaleProblem(i.second));
                    else result.add(i.second);
                }
                return result;
            }

            public void afterTextChanged(Editable s) {
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            public void onTextChanged(CharSequence text, int start, int before, int count) {
                if (multiSelect){
                    FLUIAndroidIconLabelAndCheckListAdapter adapter = (FLUIAndroidIconLabelAndCheckListAdapter)list.getAdapter();
                    allSelectedItems.addAll(adapter.getSelectedItems());
                    allSelectedItems.removeAll(adapter.getUnselectedItems());
                }

                String filterString = new String("" + text).trim();
                if (filterString.length() == 0) filterString = "*";
                if (!filterString.endsWith("*")) filterString += "*";
                applyFilter(filterString);
            }
            private void applyFilter(String filterString) {
                SortedSet<Integer> checkedPositions = new TreeSet<Integer>();
                filteredValues = new ArrayList<Pair<Bitmap,String>>();
                String useFilterString = filterString;
                if (containsMode){
                    if (!useFilterString.startsWith("*")) useFilterString = "*" + useFilterString;
                    if (!useFilterString.endsWith("*")) useFilterString = useFilterString + "*";
                }
//		    	EasyAndroidLogger.debug("matchCase = " + matchCase + ", useFilterString = >>" + useFilterString + "<<");

                if (matchCase){
                    for (int i = 0; i < unfilteredItemNames.size(); i++){
                        if (FLUIUtil.equalsWithAsterisk(unfilteredItemNames.get(i), useFilterString, true)){
                            filteredValues.add(values.get(i));
                            if (allSelectedItems.contains(values.get(i).second)) checkedPositions.add(filteredValues.size() - 1);
                        }
                    }
                } else {
                    useFilterString = toUpperCaseIgnoreLocaleProblem(useFilterString);
                    for (int i = 0; i < unfilteredItemNamesInUpperCase.size(); i++){
                        if (FLUIUtil.equalsWithAsterisk(unfilteredItemNamesInUpperCase.get(i), useFilterString, true)){
                            filteredValues.add(values.get(i));
                            if (allSelectedItems.contains(values.get(i).second)) checkedPositions.add(filteredValues.size() - 1);
                        }
                    }
                }
                if (multiSelect){
                    FLUIAndroidIconLabelAndCheckListAdapter adapter = null;
                    adapter = new FLUIAndroidIconLabelAndCheckListAdapter(activity, filteredValues, maxImageWidthInCM
                            , maxImageHeightInCM, textSize, sizeUnit, checkedPositions);
                    if (currentCheckListAdapter != null) currentCheckListAdapter.set(adapter);
                    list.setAdapter(adapter);
                } else {
                    list.setAdapter(new FLUIAndroidIconAndLabelListAdapter(activity, filteredValues, maxImageWidthInCM, maxImageHeightInCM));
                }
            }
        };
    }

    @SuppressLint("DefaultLocale")
    private static String toUpperCaseIgnoreLocaleProblem(String string){
        if (string == null) return null;
        return string.toUpperCase();
    }

    public static void makeDialogBig(Dialog dialog){
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.FILL_PARENT;
        lp.height = WindowManager.LayoutParams.FILL_PARENT;
        dialog.getWindow().setAttributes(lp);
    }

    private static int getDrawTextBelowOffset(FontMetricsInt metrics){
        return -metrics.top;
    }

    public static void showSelectImageAndStringDialog(final Activity activity
            , String title
            , List<Pair<Bitmap, String>> values
            , double maxImageWidthInCM
            , double maxImageHeightInCM
            , double textSize
            , SizeUnit sizeUnit
            , boolean showFilter
            , boolean matchCaseInFilter
            , boolean containsMode
            , String initialFilterText
            , final SelectStringDialogListener listener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);
        LinearLayout mainPanel = new LinearLayout(activity);
        mainPanel.setOrientation(LinearLayout.VERTICAL);
        final ListView listView = new ListView(activity);
        listView.setAdapter(new FLUIAndroidIconAndLabelListAdapter(activity, values, maxImageWidthInCM, maxImageHeightInCM));

        EditText filterText = null;
        if (showFilter){
            filterText = new EditText(activity);
            TextWatcher watcher = createSelectStringDialogFilterTextWatcher(activity
                    , values
                    , maxImageWidthInCM
                    , maxImageHeightInCM
                    , textSize
                    , sizeUnit
                    , filterText
                    , matchCaseInFilter
                    , containsMode
                    , false
                    , listView
                    , new TreeSet<String>()
                    , null);
            filterText.addTextChangedListener(watcher);
            filterText.setHint("type to filter");
            filterText.setMaxLines(1);
            if (initialFilterText != null) filterText.setText(initialFilterText);
            mainPanel.addView(filterText, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        }
        mainPanel.addView(listView, new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

        builder.setView(mainPanel);
        final Dialog dialog = builder.create();
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = listView.getItemAtPosition(position);
                dialog.dismiss();
//				dialog.cancel();
                if (item == null) listener.okActionPerformed(null);
                else listener.okActionPerformed("" + item);
            }
        });
        dialog.setOnCancelListener(new OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                listener.cancelActionPerformed();
            }
        });
        if (filterText != null){
            filterText.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getKeyCode() == 111){ //: = KeyEvent.KEYCODE_ESCAPE, available in API level 11
                        dialog.cancel();
                        return true;
                    }
                    return false;
                }
            });
        }
        dialog.show();
        makeDialogBig(dialog);
    }

    public static void showMessageDialog(Context context, int iconID, String title, String message){
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setIcon(iconID);
        alert.show();
    }


    public static void showMessage(Activity activity, FLUIMessage message) {
        if (message == null){
            showMessageDialog(activity, android.R.drawable.ic_dialog_info, "(no message content)", "(no message content)");
            return;
        }
        switch (message.getTypeID()){
            case TYPE_ID_INFO_DIALOG:
                showMessageDialog(activity, android.R.drawable.ic_dialog_info, message.getTitle(), message.getText());
                break;
            case TYPE_ID_ERROR_DIALOG:
                showMessageDialog(activity, android.R.drawable.ic_dialog_alert, message.getTitle(), message.getText());
                break;
            case TYPE_ID_WARNING_DIALOG:
                showMessageDialog(activity, android.R.drawable.ic_dialog_alert, message.getTitle(), message.getText());
                break;
            case TYPE_ID_INFO_TOAST:
                Toast.makeText(activity, message.getTitle(), Toast.LENGTH_LONG);
                break;
            default:
                showMessageDialog(activity, android.R.drawable.ic_dialog_info, message.getTitle(), message.getText());
                break;
        }
    }

    public static int getCursorLine(EditText textEditor) {
        if (textEditor == null){
            return 0;
        }
        String text = textEditor.getText().toString();
        return FLUIUtil.toLine(text, Math.max(textEditor.getSelectionStart(), textEditor.getSelectionEnd()));
    }

    public static int getCursorPosInLine(EditText textEditor) {
        if (textEditor == null){
            return 0;
        }
        String text = textEditor.getText().toString();
        return FLUIUtil.toPosInLine(text, Math.max(textEditor.getSelectionStart(), textEditor.getSelectionEnd()));
    }

    /**
     * @param fileNameFilter may be null. Example: "*.xml"
     */
    public static void showOpenFileDialog(final Activity activity
            , String title
            , File initialDirectory
            , final Collection<String> fileNameFilter
            , final FileDialogListener listener){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(title);
        final ListView listView = new ListView(activity);
        final String UP_DIR_STIRNG = "<UP>";
        final Bitmap dirBitmap = readBitmapFromBase64(DIR_ICON_BASE_64, null);
        final Bitmap fileBitmap = readBitmapFromBase64(FILE_ICON_BASE_64, null);
        final Bitmap upBitmap = readBitmapFromBase64(DIR_UP_ICON_BASE_64, null);
        String state = Environment.getExternalStorageState();
        if (!Environment.MEDIA_MOUNTED.equals(state)) {
            Toast.makeText(activity, "No media card", Toast.LENGTH_LONG);
            listener.selectActionPerformed(null);
            return;
        }
        File currentDir = initialDirectory != null ? initialDirectory : Environment.getExternalStorageDirectory();
        listView.setAdapter(createIconAndLabelListAdapterForFilesAndDirs(activity, currentDir, fileNameFilter, UP_DIR_STIRNG, upBitmap
                , fileBitmap, dirBitmap));
        final TextView pathLabel = new TextView(activity);
        LinearLayout panel = new LinearLayout(activity);
        pathLabel.setText(currentDir.getAbsolutePath());
        panel.setOrientation(LinearLayout.VERTICAL);
        panel.addView(createTextView(activity, "Directory:"), LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        panel.addView(pathLabel, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        panel.addView(listView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        builder.setView(panel);
        final Dialog dialog = builder.create();
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object item = listView.getItemAtPosition(position);
                if (UP_DIR_STIRNG.equals(item)){
                    File selection = new File("" + pathLabel.getText()).getParentFile();
                    if (selection != null){
                        pathLabel.setText(selection.getAbsolutePath());
                        listView.setAdapter(createIconAndLabelListAdapterForFilesAndDirs(activity, selection, fileNameFilter, UP_DIR_STIRNG, upBitmap, fileBitmap, dirBitmap));
                    }
                } else {
                    File selection = new File(new File("" + pathLabel.getText()), "" + item);
                    if (selection.isFile()){
                        dialog.dismiss();
//                        EasyAndroidLogger.debug("calling selectActionPerformed of listener");
                        listener.selectActionPerformed(selection);
                    } else {
                        pathLabel.setText(selection.getAbsolutePath());
                        listView.setAdapter(createIconAndLabelListAdapterForFilesAndDirs(activity, selection, fileNameFilter, UP_DIR_STIRNG, upBitmap, fileBitmap, dirBitmap));
                    }
                }
            }
        });
        dialog.setOnCancelListener(new OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                dialog.dismiss(); //: 2011_08_31
                listener.selectActionPerformed(null);
            }
        });
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface arg0) {
            }
        });
        dialog.show();
    }

    public interface FileDialogListener{
        void selectActionPerformed(File selection);
    }

    public static TextView createTextView(Context context, String text){
        TextView view = new TextView(context);
        view.setText(text);
        return view;
    }

    /**
     *
     * @param base64String a string with the base64 data
     * @return    array with the decrypted data
     * @throws IllegalArgumentException if the input is not valid Base64 encoded data.
     */
    public static byte[] decodeBase64(String base64String) throws Exception {
        char in[] = base64String.toCharArray();

        char[] map1 = new char[64];
        int i=0;
        for (char c='A'; c<='Z'; c++) map1[i++] = c;
        for (char c='a'; c<='z'; c++) map1[i++] = c;
        for (char c='0'; c<='9'; c++) map1[i++] = c;
        map1[i++] = '+'; map1[i++] = '/';

        byte[]    map2 = new byte[128];
        for (i=0; i<map2.length; i++) map2[i] = -1;
        for (i=0; i<64; i++) map2[map1[i]] = (byte)i;


        int iLen = in.length;
        if (iLen%4 != 0) throw new IllegalArgumentException("Length of Base64 encoded input string is not a multiple of 4.");
        while (iLen > 0 && in[iLen-1] == '=') iLen--;
        int oLen = (iLen*3) / 4;
        byte[] out = new byte[oLen];
        int inputIndex = 0;
        int outputIndex = 0;
        while (inputIndex < iLen) {
            int input0 = in[inputIndex++];
            int input1 = in[inputIndex++];
            int input2 = inputIndex < iLen ? in[inputIndex++] : 'A';
            int input3 = inputIndex < iLen ? in[inputIndex++] : 'A';
            if (input0 > 127 || input1 > 127 || input2 > 127 || input3 > 127)
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            int transform0 = map2[input0];
            int transform1 = map2[input1];
            int transform2 = map2[input2];
            int transform3 = map2[input3];
            if (transform0 < 0 || transform1 < 0 || transform2 < 0 || transform3 < 0)
                throw new IllegalArgumentException("Illegal character in Base64 encoded data.");
            int output0 = ( transform0       <<2) | (transform1>>>4);
            int output1 = ((transform1 & 0xf)<<4) | (transform2>>>2);
            int output2 = ((transform2 &   3)<<6) |  transform3;
            out[outputIndex++] = (byte)output0;
            if (outputIndex<oLen) out[outputIndex++] = (byte)output1;
            if (outputIndex<oLen) out[outputIndex++] = (byte)output2; }
        return out;
    }


    private static Bitmap readBitmapFromBase64(String string, Bitmap imageToReturnOnError){
        try{
            byte[] data = decodeBase64(string);
            return BitmapFactory.decodeByteArray(data, 0, data.length);
        } catch (Exception ignored){
        }
        return imageToReturnOnError;
    }

    private static void sortIgnoreCase(List<String> items) {
        Collections.sort(items, new Comparator<String>() {
            @Override
            public int compare(String lhs, String rhs) {
                if (lhs == null) {
                    if (rhs == null) return 0;
                    return -1;
                } else if (rhs == null) return 1;
                int result = lhs.compareToIgnoreCase(rhs);
                if (result == 0) result = lhs.compareTo(rhs);
                return result;
            }
        });
    }
    private static FLUIAndroidIconAndLabelListAdapter createIconAndLabelListAdapterForFilesAndDirs(Activity activity
            , File parentDir
            , Collection<String> fileNameFilters
            , String upLabel
            , Bitmap upImage
            , Bitmap fileImage
            , Bitmap dirImage){
        List<Pair<Bitmap, String>> items = new ArrayList<Pair<Bitmap,String>>();

        List<String> firstItems = new ArrayList<String>();
        List<String> secondItems = new ArrayList<String>();
        String[] parentDirList = parentDir.list();
        if (parentDirList == null) parentDirList = new String[0];
        for (String i: parentDirList){
            if (i.startsWith("_")) firstItems.add(i);
            else secondItems.add(i);

        }
        if ((upLabel != null) && (parentDir.getParentFile() != null)) items.add(new Pair<Bitmap,String>(upImage, upLabel));

        List<String> fileList = new ArrayList<String>();
        sortIgnoreCase(firstItems);
        sortIgnoreCase(secondItems);
        fileList.addAll(firstItems);
        fileList.addAll(secondItems);
        Set<String> fileNameFiltersInUpperCase = new HashSet<String>();
        if (fileNameFilters != null){
            for (String i: fileNameFilters){
                fileNameFiltersInUpperCase.add(toUpperCaseIgnoreLocaleProblem(i));
            }
        }
        for (String i: fileList){
            if (new File(parentDir, i).isFile()){
                if ((fileNameFiltersInUpperCase.isEmpty()) || (equalsAnyWithAsterisk(toUpperCaseIgnoreLocaleProblem(i), fileNameFiltersInUpperCase))){
                    items.add(new Pair<Bitmap,String>(fileImage, i));
                }
            } else items.add(new Pair<Bitmap,String>(dirImage, i));
        }
        return new FLUIAndroidIconAndLabelListAdapter(activity, items);
    }

    public static boolean equalsWithAsterisk(String string, String stringToFind){
        if (stringToFind.replace("*", "").length() == 0) return true;

        int firstAsteriskOccurence = stringToFind.indexOf("*");
        if (firstAsteriskOccurence < 0) return string.equals(stringToFind);

        String firstTokenToSearch = stringToFind.substring(0, firstAsteriskOccurence).replace("*", "");
        String lastTokenToSearch = stringToFind.substring(stringToFind.lastIndexOf("*")).replace("*", "");
        if ((!stringToFind.startsWith("*")) && (!string.startsWith(firstTokenToSearch))) return false;
        if ((!stringToFind.endsWith("*")) && (!string.endsWith(lastTokenToSearch))) return false;


        while(firstTokenToSearch.length() == 0){
            firstAsteriskOccurence = stringToFind.indexOf("*", firstAsteriskOccurence + 1);
            if (firstAsteriskOccurence >= 0) firstTokenToSearch = stringToFind.substring(0, firstAsteriskOccurence).replace("*", "");
            else {
                firstTokenToSearch = stringToFind.replace("*", "");
                return string.endsWith(firstTokenToSearch);
            }
        }

        int occurenceIndex = string.indexOf(firstTokenToSearch);
        while(occurenceIndex >= 0){
            String restOString = string.substring(occurenceIndex + 1);
            String restOfSearchString;
            restOfSearchString = stringToFind.substring(firstAsteriskOccurence); // not +1 to keep leading "*"
            if (equalsWithAsterisk(restOString, restOfSearchString)) return true;
            occurenceIndex = string.indexOf(occurenceIndex + 1);
        }
        return false;
    }

    private static boolean equalsAnyWithAsterisk(String string, Set<String> filter){
        for (String i: filter){
            if (equalsWithAsterisk(string, i)) return true;
        }
        return false;
    }

    public static void setListViewHeightBasedOnChildren(ListView listView, ArrayAdapter listAdapter) {
        if (listAdapter == null) {
            return;
        }

        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
