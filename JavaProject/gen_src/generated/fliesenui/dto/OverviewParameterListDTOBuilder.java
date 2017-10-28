package generated.fliesenui.dto;

import java.util.List;

public class OverviewParameterListDTOBuilder {
    public static OverviewParameterListDTO construct(List<OverviewParameterDTO> items){
        OverviewParameterListDTO result = new OverviewParameterListDTO();
        result.setItems(items);
        return result;
    }
}
