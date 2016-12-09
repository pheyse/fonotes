package generated.fliesenui.dto;

public class OverviewItemDTOBuilder {
    public static OverviewItemDTO construct(String id, String label, String color){
        OverviewItemDTO result = new OverviewItemDTO();
        result.setId(id);
        result.setLabel(label);
        result.setColor(color);
        return result;
    }
}
