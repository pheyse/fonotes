package generated.fliesenui.core;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import generated.fliesenui.core.FLUIAndroidUtil.SizeUnit;

public class FLUIAndroidIconAndLabelListAdapter extends ArrayAdapter<String> {
	private static final double DEFAULT_TEXT_SIZE_IN_DIP = 20;
	
	private List<Pair<Bitmap, String>> items;
	private Activity activity;
	private final int ICON_VIEW_ID = 1;
	private final int LABEL_VIEW_ID = 2;
	private double maxImageWidthInCM;
	private double maxImageHeightInCM;
	private double textSize = DEFAULT_TEXT_SIZE_IN_DIP;
	private SizeUnit textSizeUnit = SizeUnit.DIP;

	public FLUIAndroidIconAndLabelListAdapter(Activity activity, List<Pair<Bitmap, String>> items){
		this(activity, items, 0.6, 0.6, DEFAULT_TEXT_SIZE_IN_DIP, SizeUnit.DIP);
	}

	public static FLUIAndroidIconAndLabelListAdapter createWithCheckboxes(Activity activity
															            , List<Pair<Bitmap, String>> items
															            , double maxImageWidthInCM
															            , double maxImageHeightInCM){
		return createWithCheckboxes(activity , items , maxImageWidthInCM, maxImageHeightInCM, DEFAULT_TEXT_SIZE_IN_DIP, SizeUnit.DIP);
	}

	public static FLUIAndroidIconAndLabelListAdapter createWithCheckboxes(Activity activity
			                                , List<Pair<Bitmap, String>> items
			                                , double maxImageWidthInCM
			                                , double maxImageHeightInCM
			                                , double textSize
			                                , SizeUnit textSizeUnit){
		return new FLUIAndroidIconAndLabelListAdapter(android.R.layout.simple_list_item_multiple_choice, activity, items
				       , maxImageWidthInCM, maxImageHeightInCM, textSize, textSizeUnit);
	}
	
	@Deprecated
	//: either DIP should be used or the unit should be explicitly specified 
	public static FLUIAndroidIconAndLabelListAdapter createWithCheckboxes(Activity activity
			                                , List<Pair<Bitmap, String>> items
			                                , double maxImageWidthInCM
			                                , double maxImageHeightInCM
			                                , double textSizeInCM){
		return new FLUIAndroidIconAndLabelListAdapter(android.R.layout.simple_list_item_multiple_choice, activity, items
				       , maxImageWidthInCM, maxImageHeightInCM, textSizeInCM);
	}
	
	@Deprecated
	//: either DIP should be used or the unit should be explicitly specified 
	private FLUIAndroidIconAndLabelListAdapter(int layoutID, Activity activity, List<Pair<Bitmap, String>> items, double maxImageWidthInCM, double maxImageHeightInCM, double textSizeInCM){
		super(activity, layoutID, getStrings(items));
		this.items = items;
		this.activity = activity;
		this.maxImageWidthInCM = maxImageWidthInCM;
		this.maxImageHeightInCM = maxImageHeightInCM;
		this.textSize = textSizeInCM;
		this.textSizeUnit = SizeUnit.CM;
	}
	
	private FLUIAndroidIconAndLabelListAdapter(int layoutID, Activity activity, List<Pair<Bitmap, String>> items, double maxImageWidthInCM
			, double maxImageHeightInCM, double textSize, SizeUnit textSizeUnit){
		super(activity, layoutID, getStrings(items));
		this.items = items;
		this.activity = activity;
		this.maxImageWidthInCM = maxImageWidthInCM;
		this.maxImageHeightInCM = maxImageHeightInCM;
		this.textSize = textSize;
		this.textSizeUnit = textSizeUnit;
	}
	
	
	public FLUIAndroidIconAndLabelListAdapter(Activity activity, List<Pair<Bitmap, String>> items, double maxImageWidthInCM, double maxImageHeightInCM){
		this(activity, items, maxImageWidthInCM, maxImageHeightInCM, DEFAULT_TEXT_SIZE_IN_DIP, SizeUnit.DIP);
	}
	
	@Deprecated
	//: either DIP should be used or the unit should be explicitly specified 
	public FLUIAndroidIconAndLabelListAdapter(Activity activity, List<Pair<Bitmap, String>> items, double maxImageWidthInCM, double maxImageHeightInCM, double textSizeInCM){
		this(activity, items, maxImageWidthInCM, maxImageHeightInCM, textSizeInCM, SizeUnit.CM);
	}
	
	public FLUIAndroidIconAndLabelListAdapter(Activity activity, List<Pair<Bitmap, String>> items, double maxImageWidthInCM
			, double maxImageHeightInCM, double textSize, SizeUnit textSizeUnit){
		super(activity, android.R.layout.simple_list_item_1, getStrings(items));
		this.items = items;
		this.activity = activity;
		this.maxImageWidthInCM = maxImageWidthInCM;
		this.maxImageHeightInCM = maxImageHeightInCM;
		this.textSize = textSize;
		this.textSizeUnit = textSizeUnit;
	}
	
	@Override
	public int getCount() {
		return items.size();
	}
	
	@Override
	public String getItem(int position) {
		return items.get(position).second;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		FLUIAndroidImageView imageView = null;
		TextView labelView = null;
		if (row == null) {
			LinearLayout panel = new LinearLayout(activity);
			panel.setOrientation(LinearLayout.HORIZONTAL);
			imageView = new FLUIAndroidImageView(activity, null, null);
            //noinspection ResourceType
            imageView.setId(ICON_VIEW_ID);
			panel.addView(imageView, (int)FLUIAndroidUtil.getPixelHeightForCM(activity, maxImageWidthInCM), (int)FLUIAndroidUtil.getPixelWidthForCM(activity, maxImageHeightInCM));
			labelView = new TextView(activity);
			
			if (textSizeUnit == SizeUnit.CM) labelView.setTextSize(TypedValue.COMPLEX_UNIT_MM, (float)(textSize * 10));
			else labelView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, (float)textSize);

			
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
		}
		imageView.setImage(items.get(position).first);
		labelView.setText(items.get(position).second);
		return row;
	}
	
	private static List<String> getStrings(Collection<Pair<Bitmap, String>> items) {
		List<String> result = new ArrayList<String>();
		for (Pair<Bitmap, String> i: items){
			result.add(i.second);
		}
		return result;
	}

}