package generated.fliesenui.dto;

import java.util.List;

public class IdAndLabelListDTOBuilder {
    public static IdAndLabelListDTO construct(List<IdAndLabelDTO> items){
        IdAndLabelListDTO result = new IdAndLabelListDTO();
        result.setItems(items);
        return result;
    }
}
