package generated.fliesenui.core;

import java.util.List;
import generated.fliesenui.dto.DetailsParameterDTO;
import generated.fliesenui.dto.DetailsParameterListDTO;
import generated.fliesenui.dto.EditStateDTO;
import generated.fliesenui.dto.EditStateListDTO;
import generated.fliesenui.dto.IdAndLabelDTO;
import generated.fliesenui.dto.IdAndLabelListDTO;
import generated.fliesenui.dto.IdAndLabelListListDTO;
import generated.fliesenui.dto.OverviewItemDTO;
import generated.fliesenui.dto.OverviewItemListDTO;
import generated.fliesenui.dto.OverviewListDTO;
import generated.fliesenui.dto.OverviewListListDTO;
import generated.fliesenui.dto.OverviewParameterDTO;
import generated.fliesenui.dto.OverviewParameterListDTO;
import generated.fliesenui.dto.DetailsParameterDTOBuilder;
import generated.fliesenui.dto.DetailsParameterListDTOBuilder;
import generated.fliesenui.dto.EditStateDTOBuilder;
import generated.fliesenui.dto.EditStateListDTOBuilder;
import generated.fliesenui.dto.IdAndLabelDTOBuilder;
import generated.fliesenui.dto.IdAndLabelListDTOBuilder;
import generated.fliesenui.dto.IdAndLabelListListDTOBuilder;
import generated.fliesenui.dto.OverviewItemDTOBuilder;
import generated.fliesenui.dto.OverviewItemListDTOBuilder;
import generated.fliesenui.dto.OverviewListDTOBuilder;
import generated.fliesenui.dto.OverviewListListDTOBuilder;
import generated.fliesenui.dto.OverviewParameterDTOBuilder;
import generated.fliesenui.dto.OverviewParameterListDTOBuilder;

public class FLUIOpenScreenException extends Exception{
    private static final long serialVersionUID = 8717985705740152615L;
    private String screenID;
    private Object parameterDTO;

    public String getScreenID(){
        return screenID;
    }

    public Object getParameterDTO(){
        return parameterDTO;
    }

    private FLUIOpenScreenException(){
    }

    public static FLUIOpenScreenException createOpenScreenAboutException(OverviewParameterDTO screenParameter){
        FLUIOpenScreenException result = new FLUIOpenScreenException();
        result.screenID = "about";
        result.parameterDTO = screenParameter;
        return result;
    }

    public static FLUIOpenScreenException createOpenScreenAboutException(String password){
        return createOpenScreenAboutException(OverviewParameterDTOBuilder.construct(password));
    }


    public static FLUIOpenScreenException createOpenScreenDetailsException(DetailsParameterDTO screenParameter){
        FLUIOpenScreenException result = new FLUIOpenScreenException();
        result.screenID = "details";
        result.parameterDTO = screenParameter;
        return result;
    }

    public static FLUIOpenScreenException createOpenScreenDetailsException(String noteName, String password){
        return createOpenScreenDetailsException(DetailsParameterDTOBuilder.construct(noteName, password));
    }


    public static FLUIOpenScreenException createOpenScreenLoginException(){
        FLUIOpenScreenException result = new FLUIOpenScreenException();
        result.screenID = "login";
        return result;
    }

    public static FLUIOpenScreenException createOpenScreenMarkdownHelpException(OverviewParameterDTO screenParameter){
        FLUIOpenScreenException result = new FLUIOpenScreenException();
        result.screenID = "markdownHelp";
        result.parameterDTO = screenParameter;
        return result;
    }

    public static FLUIOpenScreenException createOpenScreenMarkdownHelpException(String password){
        return createOpenScreenMarkdownHelpException(OverviewParameterDTOBuilder.construct(password));
    }


    public static FLUIOpenScreenException createOpenScreenOverviewException(OverviewParameterDTO screenParameter){
        FLUIOpenScreenException result = new FLUIOpenScreenException();
        result.screenID = "overview";
        result.parameterDTO = screenParameter;
        return result;
    }

    public static FLUIOpenScreenException createOpenScreenOverviewException(String password){
        return createOpenScreenOverviewException(OverviewParameterDTOBuilder.construct(password));
    }


}
