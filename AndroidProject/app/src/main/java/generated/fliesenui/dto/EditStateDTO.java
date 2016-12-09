package generated.fliesenui.dto;

public class EditStateDTO {
    private String text;
    private boolean inEditMode;

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public boolean getInEditMode(){
        return inEditMode;
    }

    public void setInEditMode(boolean inEditMode){
        this.inEditMode = inEditMode;
    }

}
