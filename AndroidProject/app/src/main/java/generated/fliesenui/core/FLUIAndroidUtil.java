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

/**
 * Created by osboxes on 9/27/17.
 */

public class FLUIAndroidUtil {
    public enum SizeUnit {DIP, CM}
    public static final float INCH_TO_CM_FACTOR = 2.54f;
    public static final double DEFAULT_TEXT_SIZE_IN_DIP = 20d;
    private static final SortedSet<Character> SEPARATING_CHARS = getSeparatingChars();

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


}
