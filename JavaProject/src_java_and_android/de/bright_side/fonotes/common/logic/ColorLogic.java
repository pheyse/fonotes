package de.bright_side.fonotes.common.logic;

import java.util.ArrayList;
import java.util.List;

import generated.fliesenui.dto.IdAndLabelDTO;
import generated.fliesenui.dto.IdAndLabelDTOBuilder;

public class ColorLogic {
	public static String DEFAULT_COLOR = "ffffaa";
	
	public List<IdAndLabelDTO> getColorIDsAndLabels(){
		List<IdAndLabelDTO> result = new ArrayList<>();
		result.add(IdAndLabelDTOBuilder.construct("ffffaa", "yellow"));
		result.add(IdAndLabelDTOBuilder.construct("aaaaff", "blue"));
		result.add(IdAndLabelDTOBuilder.construct("aaffaa", "green"));
		result.add(IdAndLabelDTOBuilder.construct("aaffff", "cyan"));
		result.add(IdAndLabelDTOBuilder.construct("ffaaff", "pink"));
		result.add(IdAndLabelDTOBuilder.construct("ffcc88", "orange"));
		result.add(IdAndLabelDTOBuilder.construct("ffaaaa", "red"));
		result.add(IdAndLabelDTOBuilder.construct("cccccc", "grey"));
		return result;
	}
}
