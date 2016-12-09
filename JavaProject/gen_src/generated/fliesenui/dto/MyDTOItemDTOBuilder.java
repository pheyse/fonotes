package generated.fliesenui.dto;

public class MyDTOItemDTOBuilder {
    public static MyDTOItemDTO construct(String myID, String myText, long myValue){
        MyDTOItemDTO result = new MyDTOItemDTO();
        result.setMyID(myID);
        result.setMyText(myText);
        result.setMyValue(myValue);
        return result;
    }
}
