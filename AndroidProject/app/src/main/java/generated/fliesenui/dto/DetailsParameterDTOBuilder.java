package generated.fliesenui.dto;

public class DetailsParameterDTOBuilder {
    public static DetailsParameterDTO construct(String noteName, String password){
        DetailsParameterDTO result = new DetailsParameterDTO();
        result.setNoteName(noteName);
        result.setPassword(password);
        return result;
    }
}
