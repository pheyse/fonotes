package com.bright_side_it.fonotes.common.logic;

import generated.fliesenui.dto.IdAndLabelDTO;
import generated.fliesenui.dto.IdAndLabelDTOBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ColorLogic {
	public static final String DEFAULT_COLOR_ID = "yellow";
	public static String DEFAULT_COLOR = "ffffaa";
	
	private static final Map<String, String> COLOR_ID_TO_STRONG_COLOR_HEX_MAP = createColorIDToStrongColorHexMap();
	private static final Map<String, String> COLOR_ID_TO_SOFT_COLOR_HEX_MAP = createColorIDToSoftColorHexMap();
	private static final Map<String, String> COLOR_ID_TO_LABEL_MAP = createColorIDToLabelMap();

	public static final int NUMBER_OF_COLORS = COLOR_ID_TO_LABEL_MAP.values().size();
	
	public List<IdAndLabelDTO> getColorIDsAndLabels(){
		List<IdAndLabelDTO> result = new ArrayList<>();

		result.add(IdAndLabelDTOBuilder.construct("yellow", "yellow"));
		result.add(IdAndLabelDTOBuilder.construct("blue", "blue"));
		result.add(IdAndLabelDTOBuilder.construct("green", "green"));
		result.add(IdAndLabelDTOBuilder.construct("cyan", "cyan"));
		result.add(IdAndLabelDTOBuilder.construct("red", "red"));
		result.add(IdAndLabelDTOBuilder.construct("orange", "orange"));
		result.add(IdAndLabelDTOBuilder.construct("purple", "purple"));
		result.add(IdAndLabelDTOBuilder.construct("white", "white"));
		result.add(IdAndLabelDTOBuilder.construct("grey", "grey"));
		result.add(IdAndLabelDTOBuilder.construct("pink", "pink"));
		return result;
	}
	
	private static Map<String, String> createColorIDToLabelMap() {
		Map<String, String> result = new TreeMap<String, String>();
		for (IdAndLabelDTO i: new ColorLogic().getColorIDsAndLabels()){
			result.put(i.getId(), i.getLabel());
		}
		return result;
	}

	private static Map<String, String> createColorIDToStrongColorHexMap() {
		Map<String, String> result = new TreeMap<String, String>();
		result.put("red", "f88088");
		result.put("orange", "f8a850");
		result.put("blue", "82a3fc");
		result.put("white", "f0f0f0");
		result.put("green", "29b031");
		result.put("blue", "80a0f8");
		result.put("yellow", "f0f001");
		result.put("grey", "c8c8c8");
		result.put("pink", "e514e8");
		result.put("cyan", "14e5e8");
		result.put("purple", "c080e0");
		
		return result;
	}

	private static Map<String, String> createColorIDToSoftColorHexMap() {
		Map<String, String> result = new TreeMap<String, String>();
		result.put("red", "f8e8e8");
		result.put("orange", "f8e8d0");
		result.put("blue", "e8e8f8");
		result.put("white", "f8f8f8");
		result.put("green", "e8f8e8");
		result.put("blue", "e8e8f8");
		result.put("yellow", "f8f0a0");
		result.put("grey", "e8e8e8");
		result.put("pink", "e7a8e8");
		result.put("cyan", "a8e7e8");
		result.put("purple", "d2b6e0");
		
		return result;
	}
	
	public String getColorHexSoftFromColorID(String colorID) {
		String result = COLOR_ID_TO_SOFT_COLOR_HEX_MAP.get(colorID);
		if (result == null){
			result = COLOR_ID_TO_SOFT_COLOR_HEX_MAP.get(DEFAULT_COLOR_ID);
		}
		if (result == null){
			return DEFAULT_COLOR;
		}
		return result;
	}

	public String getColorHexStrongFromColorID(String colorID) {
		String result = COLOR_ID_TO_STRONG_COLOR_HEX_MAP.get(colorID);
		if (result == null){
			result = COLOR_ID_TO_STRONG_COLOR_HEX_MAP.get(DEFAULT_COLOR_ID);
		}
		if (result == null){
			return DEFAULT_COLOR;
		}
		return result;
	}

	
	public String getColorLabel(String colorID) {
		return COLOR_ID_TO_LABEL_MAP.get(colorID);
	}
	
	public String mapOldColorToNew(String oldColor) throws Exception{
		if ("ffffaa".equals(oldColor)){
			return "yellow";
		} else if ("aaaaff".equals(oldColor)){
			return "blue";
		} else if ("aaffaa".equals(oldColor)){
			return "green";
		} else if ("aaffff".equals(oldColor)){
			return "cyan";
		} else if ("ffaaff".equals(oldColor)){
			return "pink";
		} else if ("ffcc88".equals(oldColor)){
			return "orange";
		} else if ("ffaaaa".equals(oldColor)){
			return "red";
		} else if ("cccccc".equals(oldColor)){
			return "grey";
		}
		throw new Exception("Unknown color: '" + oldColor + "'");
	}

}
