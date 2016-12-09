package generated.fliesenui.dto;

public class EditStateDTOBuilder {
    public static EditStateDTO construct(String text, boolean inEditMode){
        EditStateDTO result = new EditStateDTO();
        result.setText(text);
        result.setInEditMode(inEditMode);
        return result;
    }
}
