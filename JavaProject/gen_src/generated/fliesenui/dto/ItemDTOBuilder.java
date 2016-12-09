package generated.fliesenui.dto;

public class ItemDTOBuilder {
    public static ItemDTO construct(String id, String label){
        ItemDTO result = new ItemDTO();
        result.setId(id);
        result.setLabel(label);
        return result;
    }
}
