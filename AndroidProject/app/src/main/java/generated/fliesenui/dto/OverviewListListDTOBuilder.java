package generated.fliesenui.dto;

import java.util.List;

public class OverviewListListDTOBuilder {
    public static OverviewListListDTO construct(List<OverviewListDTO> items){
        OverviewListListDTO result = new OverviewListListDTO();
        result.setItems(items);
        return result;
    }
}
