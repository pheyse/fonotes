package generated.fliesenui.dto;

import java.util.List;

public class OverviewItemListDTOBuilder {
    public static OverviewItemListDTO construct(List<OverviewItemDTO> items){
        OverviewItemListDTO result = new OverviewItemListDTO();
        result.setItems(items);
        return result;
    }
}
