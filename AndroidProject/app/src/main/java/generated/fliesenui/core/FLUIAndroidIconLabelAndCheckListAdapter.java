package generated.fliesenui.core;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import generated.fliesenui.core.FLUIAndroidUtil.SizeUnit;

@TargetApi(8)
public class FLUIAndroidIconLabelAndCheckListAdapter extends ArrayAdapter<Pair<String, Boolean>> {
	public final static double DEFAULT_TEXT_SIZE_IN_CM = 0.2;
	
	private List<Pair<Bitmap, String>> items;
	private Activity activity;
	private static final int ICON_VIEW_ID = 1;
	private static final int LABEL_VIEW_ID = 2;
	public static final int CHECKBOX_VIEW_ID = 3;
	private double maxImageWidthInCM;
	private double maxImageHeightInCM;
	private SortedSet<Integer> checkedPositions;
	private ItemClickListener itemClickListener;
	private boolean noCheckboxForFirstItem;

	private double textSize;

	private SizeUnit textSizeUnit;

	@Deprecated
	//: size unit should either be DIP or explicitly defined
	public FLUIAndroidIconLabelAndCheckListAdapter(Activity activity, List<Pair<Bitmap, String>> items){
		this(activity, items, 0.6, 0.6, DEFAULT_TEXT_SIZE_IN_CM, SizeUnit.CM, new TreeSet<Integer>(), false, null);
	}
	
	@Deprecated
	//: size unit should either be DIP or explicitly defined
	public FLUIAndroidIconLabelAndCheckListAdapter(Activity activity, List<Pair<Bitmap, String>> items, double maxImageWidthInCM
			                                     , double maxImageHeightInCM){
		this(activity, items, maxImageWidthInCM, maxImageHeightInCM, DEFAULT_TEXT_SIZE_IN_CM, SizeUnit.CM, new TreeSet<Integer>(), false, null);
	}
	
	@Deprecated
	//: size unit should either be DIP or explicitly defined
	public FLUIAndroidIconLabelAndCheckListAdapter(Activity activity, List<Pair<Bitmap, String>> items, double maxImageWidthInCM
            , double maxImageHeightInCM, SortedSet<Integer> checkedPositions){
		this(activity, items, maxImageWidthInCM, maxImageHeightInCM, DEFAULT_TEXT_SIZE_IN_CM, SizeUnit.CM, checkedPositions, false, null);
	}

	@Deprecated
	//: size unit should either be DIP or explicitly defined
	public FLUIAndroidIconLabelAndCheckListAdapter(Activity activity, List<Pair<Bitmap, String>> items, double maxImageWidthInCM
			, double maxImageHeightInCM, double textSize, SortedSet<Integer> checkedPositions){
		this(activity, items, maxImageWidthInCM, maxImageHeightInCM, textSize, SizeUnit.CM, checkedPositions, false, null);
	}
	
	public FLUIAndroidIconLabelAndCheckListAdapter(Activity activity, List<Pair<Bitmap, String>> items, double maxImageWidthInCM
			, double maxImageHeightInCM, double textSize, SizeUnit sizeUnit, SortedSet<Integer> checkedPositions){
		this(activity, items, maxImageWidthInCM, maxImageHeightInCM, textSize, sizeUnit, checkedPositions, false, null);
	}
	
	public FLUIAndroidIconLabelAndCheckListAdapter(Activity activity, List<Pair<Bitmap, String>> items, double maxImageWidthInCM
			                                     , double maxImageHeightInCM, double textSize, SizeUnit sizeUnit, SortedSet<Integer> checkedPositions
			                                     , boolean noCheckboxForFirstItem
			                                     , ItemClickListener itemClickListener){
		super(activity, android.R.layout.simple_list_item_1, getItems(items));
		this.items = items;
		this.activity = activity;
		this.maxImageWidthInCM = maxImageWidthInCM;
		this.maxImageHeightInCM = maxImageHeightInCM;
		this.checkedPositions = new TreeSet<Integer>(checkedPositions);
		this.itemClickListener = itemClickListener;
		this.noCheckboxForFirstItem = noCheckboxForFirstItem;
		this.textSize = textSize;
		this.textSizeUnit = sizeUnit;
	}
	
//	public FLUIAndroidIconLabelAndCheckListAdapter(Activity activity, List<Pair<Bitmap, String>> items,
//			double maxImageWidthInCM, double maxImageHeightInCM, double textSizeInCM, SortedSet<Integer> checkedPositions) {
//	}

	@Override
	public int getCount() {
		return items.size();
	}
	
	@Override
	public Pair<String, Boolean> getItem(int position) {
		return new Pair<String, Boolean>(items.get(position).second, null);
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View row = convertView;
		FLUIAndroidImageView imageView = null;
		TextView labelView = null;
		CheckBox checkBox = null;
		if (row == null) {
			LinearLayout panel = new LinearLayout(activity);
			panel.setOrientation(LinearLayout.HORIZONTAL);
			checkBox = new CheckBox(activity);
            //noinspection ResourceType
            checkBox.setId(CHECKBOX_VIEW_ID);
			panel.addView(checkBox);
			imageView = new FLUIAndroidImageView(activity, null, null);
            //noinspection ResourceType
            imageView.setId(ICON_VIEW_ID);
			panel.addView(imageView, (int)FLUIAndroidUtil.getPixelHeightForCM(activity, maxImageWidthInCM), (int)FLUIAndroidUtil.getPixelWidthForCM(activity, maxImageHeightInCM));
			labelView = new TextView(activity);
			
			if (textSizeUnit == SizeUnit.CM) labelView.setTextSize(TypedValue.COMPLEX_UNIT_MM, (float)(textSize * 10));
			else labelView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, (float)textSize);
//			labelView.setTextSize(EasyAndroidGUIUtil.getPixelHeightForCM(activity, 0.2));
			labelView.setPadding((int)FLUIAndroidUtil.getPixelWidthForCM(activity, 0.10)
					, (int)FLUIAndroidUtil.getPixelHeightForCM(activity, 0.1)
					, 0
					, 0);
            //noinspection ResourceType
            labelView.setId(LABEL_VIEW_ID);
			panel.addView(labelView);
			row = panel;
		} else {
			imageView = (FLUIAndroidImageView)row.findViewById(ICON_VIEW_ID);
			labelView = (TextView)row.findViewById(LABEL_VIEW_ID);
			checkBox = (CheckBox)row.findViewById(CHECKBOX_VIEW_ID);
		}
		imageView.setImage(items.get(position).first);
		labelView.setText(items.get(position).second);
		checkBox.setChecked(isChecked(position));
		final String label = items.get(position).second;
		final int finalPosition = position;
		checkBox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (((CheckBox)v).isChecked()) checkedPositions.add(finalPosition);
				else checkedPositions.remove(finalPosition);
//				if (BuildLevel.DEBUG) EasyAndroidLogger.debug("checkedPositions = " + EasyUtil.toString(checkedPositions, "", "", ", "));
			}
		});
		row.setTag(checkBox);
		
		if ((position == 0) && (noCheckboxForFirstItem)) checkBox.setVisibility(View.GONE);
		else checkBox.setVisibility(View.VISIBLE);
		
		row.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (itemClickListener != null) itemClickListener.itemClicked(v, position, label);
			}
		});
		
		return row;
	}
	
	private static List<Pair<String, Boolean>> getItems(Collection<Pair<Bitmap, String>> items) {
		List<Pair<String, Boolean>> result = new ArrayList<Pair<String, Boolean>>();
		for (Pair<Bitmap, String> i: items){
			result.add(new Pair<String, Boolean>(i.second, false));
		}
		return result;
	}
	
	public void toggleChecked(int position){
//		if (BuildLevel.DEBUG) EasyAndroidLogger.debug("pos = " + position);
		if (checkedPositions.contains(position)) checkedPositions.remove(position);
		else checkedPositions.add(position);
//		if (BuildLevel.DEBUG) EasyAndroidLogger.debug("checkedPositions = " + EasyUtil.toString(checkedPositions, "", "", ", "));
	}

	public List<String> getSelectedItems() {
		List<String> result = new ArrayList<String>();
		for (int i: checkedPositions){
			result.add(items.get(i).second);
		}
		return result;
	}

	public List<String> getUnselectedItems() {
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < items.size(); i++){
			if (!checkedPositions.contains(i)) result.add(items.get(i).second);
		}
		return result;
	}
	
	public boolean isChecked(int position) {
		boolean result = checkedPositions.contains(position);
//		if (BuildLevel.DEBUG) EasyAndroidLogger.debug("checked? pos = " + position + " result = " + result);
		return result;
	}
	
	public interface ItemClickListener{
		public void itemClicked(View row, int position, String label);
	}
}
