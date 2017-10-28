package generated.fliesenui.dto;

import java.util.List;

public class EditStateListDTOBuilder {
    public static EditStateListDTO construct(List<EditStateDTO> items){
        EditStateListDTO result = new EditStateListDTO();
        result.setItems(items);
        return result;
    }
}
