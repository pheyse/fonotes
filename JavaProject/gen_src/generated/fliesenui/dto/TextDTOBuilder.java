package generated.fliesenui.dto;

public class TextDTOBuilder {
    public static TextDTO construct(String text){
        TextDTO result = new TextDTO();
        result.setText(text);
        return result;
    }
}
