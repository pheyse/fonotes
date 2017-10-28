package generated.fliesenui.dto;

import java.util.List;

public class IdAndLabelListListDTOBuilder {
    public static IdAndLabelListListDTO construct(List<IdAndLabelListDTO> items){
        IdAndLabelListListDTO result = new IdAndLabelListListDTO();
        result.setItems(items);
        return result;
    }
}
