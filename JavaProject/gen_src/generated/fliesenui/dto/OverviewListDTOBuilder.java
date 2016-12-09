package generated.fliesenui.dto;

import java.util.List;

public class OverviewListDTOBuilder {
    public static OverviewListDTO construct(List<OverviewItemDTO> items){
        OverviewListDTO result = new OverviewListDTO();
        result.setItems(items);
        return result;
    }
}
