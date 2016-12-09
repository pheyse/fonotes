package generated.fliesenui.dto;

import java.util.List;

public class MyDTOListDTO {
    private List<MyDTOItemDTO> items;
    private String myDTOComment;

    public List<MyDTOItemDTO> getItems(){
        return items;
    }

    public void setItems(List<MyDTOItemDTO> items){
        this.items = items;
    }

    public String getMyDTOComment(){
        return myDTOComment;
    }

    public void setMyDTOComment(String myDTOComment){
        this.myDTOComment = myDTOComment;
    }

}
