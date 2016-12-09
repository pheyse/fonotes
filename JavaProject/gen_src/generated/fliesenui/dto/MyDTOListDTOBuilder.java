package generated.fliesenui.dto;

import java.util.List;

public class MyDTOListDTOBuilder {
    public static MyDTOListDTO construct(List<MyDTOItemDTO> items, String myDTOComment){
        MyDTOListDTO result = new MyDTOListDTO();
        result.setItems(items);
        result.setMyDTOComment(myDTOComment);
        return result;
    }
}
