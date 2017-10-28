package generated.fliesenui.dto;

import java.util.List;

public class DetailsParameterListDTOBuilder {
    public static DetailsParameterListDTO construct(List<DetailsParameterDTO> items){
        DetailsParameterListDTO result = new DetailsParameterListDTO();
        result.setItems(items);
        return result;
    }
}
