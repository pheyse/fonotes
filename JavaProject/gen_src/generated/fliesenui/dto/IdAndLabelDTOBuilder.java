package generated.fliesenui.dto;

public class IdAndLabelDTOBuilder {
    public static IdAndLabelDTO construct(String id, String label){
        IdAndLabelDTO result = new IdAndLabelDTO();
        result.setId(id);
        result.setLabel(label);
        return result;
    }
}
