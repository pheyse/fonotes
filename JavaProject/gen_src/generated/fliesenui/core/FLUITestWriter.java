package generated.fliesenui.core;

import com.google.gson.Gson;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Set;
import java.util.HashSet;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.io.OutputStream;

import generated.fliesenui.dto.DetailsParameterDTO;
import generated.fliesenui.dto.EditStateDTO;
import generated.fliesenui.dto.IdAndLabelDTO;
import generated.fliesenui.dto.IdAndLabelListDTO;
import generated.fliesenui.dto.OverviewItemDTO;
import generated.fliesenui.dto.OverviewListDTO;
import generated.fliesenui.dto.OverviewParameterDTO;

public class FLUITestWriter{
    private int dtoIndex = 0;
    private int listIndex = 0;
    private Gson gson = new Gson();
    private Set<String> declaredCreateStepDTOMethods = new HashSet<String>();

    public StringBuilder writeRequest(int step, FLUIRequest requestData) throws Exception{
        StringBuilder result = new StringBuilder();
        String requestClassName = Character.toUpperCase(requestData.getScreenID().charAt(0)) + requestData.getScreenID().substring(1) + "Request";
        result.append(requestClassName + " request = ");
        if (requestData.getScreenID().equals("about")){
            result.append(requestClassName + "." + createScreenAboutFactoryMethod(step, requestData) + ";");
        } else if (requestData.getScreenID().equals("details")){
            result.append(requestClassName + "." + createScreenDetailsFactoryMethod(step, requestData) + ";");
        } else if (requestData.getScreenID().equals("login")){
            result.append(requestClassName + "." + createScreenLoginFactoryMethod(step, requestData) + ";");
        } else if (requestData.getScreenID().equals("overview")){
            result.append(requestClassName + "." + createScreenOverviewFactoryMethod(step, requestData) + ";");
        } else {
            throw new Exception("Unknown screen id: '" + requestData.getScreenID() + "'");
        }
        return result;
    }

    public StringBuilder writeCreateDTOMethods(int step, FLUIRequest requestData) throws Exception{
        StringBuilder result = new StringBuilder();
        if (requestData.getScreenID().equals("about")){
            result.append(createScreenAboutDTOMethods(step, requestData));
        } else if (requestData.getScreenID().equals("details")){
            result.append(createScreenDetailsDTOMethods(step, requestData));
        } else if (requestData.getScreenID().equals("login")){
            result.append(createScreenLoginDTOMethods(step, requestData));
        } else if (requestData.getScreenID().equals("overview")){
            result.append(createScreenOverviewDTOMethods(step, requestData));
        } else {
            throw new Exception("Unknown screen id: '" + requestData.getScreenID() + "'");
        }
        return result;
    }
    public StringBuilder createSetDTODetailsParameterDTO(String indent, String prefix, int loopDepth, String currentDTOName, DetailsParameterDTO dto){
         StringBuilder result = new StringBuilder();
         String dtoName;
         String listName;
         result.append(indent + prefix + ".setNoteName(" + quoteIfNotNull((String)dto.getNoteName()) + ");\n");
         result.append(indent + prefix + ".setPassword(" + quoteIfNotNull((String)dto.getPassword()) + ");\n");
         return result;
    }

    public StringBuilder createSetDTOEditStateDTO(String indent, String prefix, int loopDepth, String currentDTOName, EditStateDTO dto){
         StringBuilder result = new StringBuilder();
         String dtoName;
         String listName;
         result.append(indent + prefix + ".setText(" + quoteIfNotNull((String)dto.getText()) + ");\n");
         result.append(indent + prefix + ".setInEditMode(" + dto.getInEditMode() + ");\n");
         return result;
    }

    public StringBuilder createSetDTOIdAndLabelDTO(String indent, String prefix, int loopDepth, String currentDTOName, IdAndLabelDTO dto){
         StringBuilder result = new StringBuilder();
         String dtoName;
         String listName;
         result.append(indent + prefix + ".setId(" + quoteIfNotNull((String)dto.getId()) + ");\n");
         result.append(indent + prefix + ".setLabel(" + quoteIfNotNull((String)dto.getLabel()) + ");\n");
         return result;
    }

    public StringBuilder createSetDTOIdAndLabelListDTO(String indent, String prefix, int loopDepth, String currentDTOName, IdAndLabelListDTO dto){
         StringBuilder result = new StringBuilder();
         String dtoName;
         String listName;
         listName = "list" + getNextListIndex();
         result.append("\n");
         if (dto.getItems() != null){
             result.append(indent + "List<IdAndLabelDTO> " + listName + " = new ArrayList<IdAndLabelDTO>();\n");
             result.append(indent + prefix + ".setItems(" + listName + ");\n");
             for (IdAndLabelDTO i : dto.getItems()){
                 dtoName = "dto" + getNextDTOIndex();
                 result.append("\n");                 result.append(indent + "IdAndLabelDTO " + dtoName + " = new IdAndLabelDTO();\n");
                 result.append(indent + listName + ".add(" + dtoName + ");\n");
                 result.append(createSetDTOIdAndLabelDTO(indent, dtoName, loopDepth + 1, dtoName, i));
                 result.append("\n");             }
         } else {
             result.append(indent + prefix + ".setItems(null);\n");
         }
         return result;
    }

    public StringBuilder createSetDTOOverviewItemDTO(String indent, String prefix, int loopDepth, String currentDTOName, OverviewItemDTO dto){
         StringBuilder result = new StringBuilder();
         String dtoName;
         String listName;
         result.append(indent + prefix + ".setId(" + quoteIfNotNull((String)dto.getId()) + ");\n");
         result.append(indent + prefix + ".setLabel(" + quoteIfNotNull((String)dto.getLabel()) + ");\n");
         result.append(indent + prefix + ".setColor(" + quoteIfNotNull((String)dto.getColor()) + ");\n");
         return result;
    }

    public StringBuilder createSetDTOOverviewListDTO(String indent, String prefix, int loopDepth, String currentDTOName, OverviewListDTO dto){
         StringBuilder result = new StringBuilder();
         String dtoName;
         String listName;
         listName = "list" + getNextListIndex();
         result.append("\n");
         if (dto.getItems() != null){
             result.append(indent + "List<OverviewItemDTO> " + listName + " = new ArrayList<OverviewItemDTO>();\n");
             result.append(indent + prefix + ".setItems(" + listName + ");\n");
             for (OverviewItemDTO i : dto.getItems()){
                 dtoName = "dto" + getNextDTOIndex();
                 result.append("\n");                 result.append(indent + "OverviewItemDTO " + dtoName + " = new OverviewItemDTO();\n");
                 result.append(indent + listName + ".add(" + dtoName + ");\n");
                 result.append(createSetDTOOverviewItemDTO(indent, dtoName, loopDepth + 1, dtoName, i));
                 result.append("\n");             }
         } else {
             result.append(indent + prefix + ".setItems(null);\n");
         }
         return result;
    }

    public StringBuilder createSetDTOOverviewParameterDTO(String indent, String prefix, int loopDepth, String currentDTOName, OverviewParameterDTO dto){
         StringBuilder result = new StringBuilder();
         String dtoName;
         String listName;
         result.append(indent + prefix + ".setPassword(" + quoteIfNotNull((String)dto.getPassword()) + ");\n");
         return result;
    }

    public StringBuilder createSetDTOObjectCode(String indent, String prefix, int loopDepth, String currentDTOName, Object dto, String className){
        if (className.equals("DetailsParameterDTO")){
            return createSetDTODetailsParameterDTO(indent, prefix, loopDepth, currentDTOName, (DetailsParameterDTO) dto);
        } else if (className.equals("EditStateDTO")){
            return createSetDTOEditStateDTO(indent, prefix, loopDepth, currentDTOName, (EditStateDTO) dto);
        } else if (className.equals("IdAndLabelDTO")){
            return createSetDTOIdAndLabelDTO(indent, prefix, loopDepth, currentDTOName, (IdAndLabelDTO) dto);
        } else if (className.equals("IdAndLabelListDTO")){
            return createSetDTOIdAndLabelListDTO(indent, prefix, loopDepth, currentDTOName, (IdAndLabelListDTO) dto);
        } else if (className.equals("OverviewItemDTO")){
            return createSetDTOOverviewItemDTO(indent, prefix, loopDepth, currentDTOName, (OverviewItemDTO) dto);
        } else if (className.equals("OverviewListDTO")){
            return createSetDTOOverviewListDTO(indent, prefix, loopDepth, currentDTOName, (OverviewListDTO) dto);
        } else if (className.equals("OverviewParameterDTO")){
            return createSetDTOOverviewParameterDTO(indent, prefix, loopDepth, currentDTOName, (OverviewParameterDTO) dto);
        }
        return null;
    }
    public Object createDTOInstanceByClassName(String className){
        if (className.equals("DetailsParameterDTO")){
            return new DetailsParameterDTO();
        } else if (className.equals("EditStateDTO")){
            return new EditStateDTO();
        } else if (className.equals("IdAndLabelDTO")){
            return new IdAndLabelDTO();
        } else if (className.equals("IdAndLabelListDTO")){
            return new IdAndLabelListDTO();
        } else if (className.equals("OverviewItemDTO")){
            return new OverviewItemDTO();
        } else if (className.equals("OverviewListDTO")){
            return new OverviewListDTO();
        } else if (className.equals("OverviewParameterDTO")){
            return new OverviewParameterDTO();
        }
        return null;
    }
    private String createScreenAboutFactoryMethod(int step, FLUIRequest requestData) throws Exception{
        Map<String, Object> p = requestData.getParameters();
        if (requestData.getAction().equals("widgetButtonBackButtonClicked")){
            return "createOnBackButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Parameter())";
        } else if (requestData.getAction().equals("onLoaded")){
            return "createOnLoadedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1_ClientProperties(), createStep" + step + "DTO2Parameter())";
        } else if (requestData.getAction().equals("onBackPressed")){
            return "createOnBackPressedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Parameter())";
        } else if (requestData.getAction().equals("onInputDialogResult")){
            return "createOnInputDialogResultRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("referenceID")) + ", " + quoteIfNotNull((String)p.get("result")) + ")";
        } else if (requestData.getAction().equals("onConfirmDialogResult")){
            return "createOnConfirmDialogResultRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("referenceID")) + ", " + p.get("result") + ")";
        } else if (requestData.getAction().equals("onListChooserResult")){
            return "createOnListChooserResultRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("referenceID")) + ", " + toStringList((List<String>)p.get("selectedIDs")) + ")";
        } else {
            throw new Exception("Unexpected action: '" + requestData.getAction() + "'");
        }
    }

    private String createScreenDetailsFactoryMethod(int step, FLUIRequest requestData) throws Exception{
        Map<String, Object> p = requestData.getParameters();
        if (requestData.getAction().equals("widgetButtonBackButtonClicked")){
            return "createOnBackButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Parameter())";
        } else if (requestData.getAction().equals("widgetButtonEditNameButtonClicked")){
            return "createOnEditNameButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Parameter())";
        } else if (requestData.getAction().equals("widgetButtonEditTextButtonClicked")){
            return "createOnEditTextButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Parameter())";
        } else if (requestData.getAction().equals("widgetButtonDeleteButtonClicked")){
            return "createOnDeleteButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Parameter())";
        } else if (requestData.getAction().equals("widgetButtonSaveNoteTextButtonClicked")){
            return "createOnSaveNoteTextButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Parameter(), " + quoteIfNotNull((String)p.get("editNoteTextAreaText")) + ")";
        } else if (requestData.getAction().equals("widgetButtonCancelEditNoteTextButtonClicked")){
            return "createOnCancelEditNoteTextButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Parameter())";
        } else if (requestData.getAction().equals("onAutosaveTimer")){
            return "createOnAutosaveTimerRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Parameter(), " + quoteIfNotNull((String)p.get("editNoteTextAreaText")) + ", createStep" + step + "DTO2EditState())";
        } else if (requestData.getAction().equals("onColorSelectBoxChanged")){
            return "createOnColorSelectBoxChangedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("rowID")) + ", createStep" + step + "DTO1Parameter())";
        } else if (requestData.getAction().equals("onLoaded")){
            return "createOnLoadedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1_ClientProperties(), createStep" + step + "DTO2Parameter())";
        } else if (requestData.getAction().equals("onBackPressed")){
            return "createOnBackPressedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Parameter())";
        } else if (requestData.getAction().equals("onInputDialogResult")){
            return "createOnInputDialogResultRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("referenceID")) + ", " + quoteIfNotNull((String)p.get("result")) + ")";
        } else if (requestData.getAction().equals("onConfirmDialogResult")){
            return "createOnConfirmDialogResultRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("referenceID")) + ", " + p.get("result") + ")";
        } else if (requestData.getAction().equals("onListChooserResult")){
            return "createOnListChooserResultRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("referenceID")) + ", " + toStringList((List<String>)p.get("selectedIDs")) + ")";
        } else {
            throw new Exception("Unexpected action: '" + requestData.getAction() + "'");
        }
    }

    private String createScreenLoginFactoryMethod(int step, FLUIRequest requestData) throws Exception{
        Map<String, Object> p = requestData.getParameters();
        if (requestData.getAction().equals("widgetButtonLoginButtonClicked")){
            return "createOnLoginButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("passwordTextFieldText")) + ")";
        } else if (requestData.getAction().equals("onLoaded")){
            return "createOnLoadedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1_ClientProperties())";
        } else if (requestData.getAction().equals("onInputDialogResult")){
            return "createOnInputDialogResultRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("referenceID")) + ", " + quoteIfNotNull((String)p.get("result")) + ")";
        } else if (requestData.getAction().equals("onConfirmDialogResult")){
            return "createOnConfirmDialogResultRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("referenceID")) + ", " + p.get("result") + ")";
        } else if (requestData.getAction().equals("onListChooserResult")){
            return "createOnListChooserResultRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("referenceID")) + ", " + toStringList((List<String>)p.get("selectedIDs")) + ")";
        } else {
            throw new Exception("Unexpected action: '" + requestData.getAction() + "'");
        }
    }

    private String createScreenOverviewFactoryMethod(int step, FLUIRequest requestData) throws Exception{
        Map<String, Object> p = requestData.getParameters();
        if (requestData.getAction().equals("widgetButtonMenuButtonClicked")){
            return "createOnMenuButtonClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1Parameter())";
        } else if (requestData.getAction().equals("onNotesTableRowClicked")){
            return "createOnNotesTableRowClickedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("rowID")) + ", createStep" + step + "DTO1Parameter())";
        } else if (requestData.getAction().equals("onLoaded")){
            return "createOnLoadedRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", createStep" + step + "DTO1_ClientProperties(), createStep" + step + "DTO2Parameter())";
        } else if (requestData.getAction().equals("onInputDialogResult")){
            return "createOnInputDialogResultRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("referenceID")) + ", " + quoteIfNotNull((String)p.get("result")) + ")";
        } else if (requestData.getAction().equals("onConfirmDialogResult")){
            return "createOnConfirmDialogResultRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("referenceID")) + ", " + p.get("result") + ")";
        } else if (requestData.getAction().equals("onListChooserResult")){
            return "createOnListChooserResultRequest(" + quoteIfNotNull(requestData.getCurrentLanguage()) + ", " + quoteIfNotNull((String)p.get("referenceID")) + ", " + toStringList((List<String>)p.get("selectedIDs")) + ")";
        } else {
            throw new Exception("Unexpected action: '" + requestData.getAction() + "'");
        }
    }

    private StringBuilder createScreenAboutDTOMethods(int step, FLUIRequest requestData) throws Exception{
        StringBuilder result = new StringBuilder();
        if (requestData.getAction().equals("widgetButtonBackButtonClicked")){
            result.append(createScreenAboutDTO1MethodForActionWidgetButtonBackButtonClicked(step, requestData));
        } else if (requestData.getAction().equals("onLoaded")){
            result.append(createScreenAboutDTO1MethodForActionOnLoaded(step, requestData));
            result.append(createScreenAboutDTO2MethodForActionOnLoaded(step, requestData));
        } else if (requestData.getAction().equals("onBackPressed")){
            result.append(createScreenAboutDTO1MethodForActionOnBackPressed(step, requestData));
        } else if (requestData.getAction().equals("onInputDialogResult")){
        } else if (requestData.getAction().equals("onConfirmDialogResult")){
        } else if (requestData.getAction().equals("onListChooserResult")){
        } else {
            throw new Exception("Unexpected action: '" + requestData.getAction() + "'");
        }
        return result;
    }

    private StringBuilder createScreenDetailsDTOMethods(int step, FLUIRequest requestData) throws Exception{
        StringBuilder result = new StringBuilder();
        if (requestData.getAction().equals("widgetButtonBackButtonClicked")){
            result.append(createScreenDetailsDTO1MethodForActionWidgetButtonBackButtonClicked(step, requestData));
        } else if (requestData.getAction().equals("widgetButtonEditNameButtonClicked")){
            result.append(createScreenDetailsDTO1MethodForActionWidgetButtonEditNameButtonClicked(step, requestData));
        } else if (requestData.getAction().equals("widgetButtonEditTextButtonClicked")){
            result.append(createScreenDetailsDTO1MethodForActionWidgetButtonEditTextButtonClicked(step, requestData));
        } else if (requestData.getAction().equals("widgetButtonDeleteButtonClicked")){
            result.append(createScreenDetailsDTO1MethodForActionWidgetButtonDeleteButtonClicked(step, requestData));
        } else if (requestData.getAction().equals("widgetButtonSaveNoteTextButtonClicked")){
            result.append(createScreenDetailsDTO1MethodForActionWidgetButtonSaveNoteTextButtonClicked(step, requestData));
        } else if (requestData.getAction().equals("widgetButtonCancelEditNoteTextButtonClicked")){
            result.append(createScreenDetailsDTO1MethodForActionWidgetButtonCancelEditNoteTextButtonClicked(step, requestData));
        } else if (requestData.getAction().equals("onAutosaveTimer")){
            result.append(createScreenDetailsDTO1MethodForActionOnAutosaveTimer(step, requestData));
            result.append(createScreenDetailsDTO2MethodForActionOnAutosaveTimer(step, requestData));
        } else if (requestData.getAction().equals("onColorSelectBoxChanged")){
            result.append(createScreenDetailsDTO1MethodForActionOnColorSelectBoxChanged(step, requestData));
        } else if (requestData.getAction().equals("onLoaded")){
            result.append(createScreenDetailsDTO1MethodForActionOnLoaded(step, requestData));
            result.append(createScreenDetailsDTO2MethodForActionOnLoaded(step, requestData));
        } else if (requestData.getAction().equals("onBackPressed")){
            result.append(createScreenDetailsDTO1MethodForActionOnBackPressed(step, requestData));
        } else if (requestData.getAction().equals("onInputDialogResult")){
        } else if (requestData.getAction().equals("onConfirmDialogResult")){
        } else if (requestData.getAction().equals("onListChooserResult")){
        } else {
            throw new Exception("Unexpected action: '" + requestData.getAction() + "'");
        }
        return result;
    }

    private StringBuilder createScreenLoginDTOMethods(int step, FLUIRequest requestData) throws Exception{
        StringBuilder result = new StringBuilder();
        if (requestData.getAction().equals("widgetButtonLoginButtonClicked")){
        } else if (requestData.getAction().equals("onLoaded")){
            result.append(createScreenLoginDTO1MethodForActionOnLoaded(step, requestData));
        } else if (requestData.getAction().equals("onInputDialogResult")){
        } else if (requestData.getAction().equals("onConfirmDialogResult")){
        } else if (requestData.getAction().equals("onListChooserResult")){
        } else {
            throw new Exception("Unexpected action: '" + requestData.getAction() + "'");
        }
        return result;
    }

    private StringBuilder createScreenOverviewDTOMethods(int step, FLUIRequest requestData) throws Exception{
        StringBuilder result = new StringBuilder();
        if (requestData.getAction().equals("widgetButtonMenuButtonClicked")){
            result.append(createScreenOverviewDTO1MethodForActionWidgetButtonMenuButtonClicked(step, requestData));
        } else if (requestData.getAction().equals("onNotesTableRowClicked")){
            result.append(createScreenOverviewDTO1MethodForActionOnNotesTableRowClicked(step, requestData));
        } else if (requestData.getAction().equals("onLoaded")){
            result.append(createScreenOverviewDTO1MethodForActionOnLoaded(step, requestData));
            result.append(createScreenOverviewDTO2MethodForActionOnLoaded(step, requestData));
        } else if (requestData.getAction().equals("onInputDialogResult")){
        } else if (requestData.getAction().equals("onConfirmDialogResult")){
        } else if (requestData.getAction().equals("onListChooserResult")){
        } else {
            throw new Exception("Unexpected action: '" + requestData.getAction() + "'");
        }
        return result;
    }

    private StringBuilder createScreenAboutDTO1MethodForActionWidgetButtonBackButtonClicked(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        OverviewParameterDTO dto = gson.fromJson((String)requestData.getParameters().get("parameter"), OverviewParameterDTO.class);
        String declaration = "private OverviewParameterDTO createStep" + step + "DTO1Parameter()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        OverviewParameterDTO result = new OverviewParameterDTO();\n");
        result.append(createSetDTOOverviewParameterDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenAboutDTO1MethodForActionOnLoaded(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        FLUIClientPropertiesDTO dto = gson.fromJson((String)requestData.getParameters().get("_ClientProperties"), FLUIClientPropertiesDTO.class);
        String declaration = "private FLUIClientPropertiesDTO createStep" + step + "DTO1_ClientProperties()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        FLUIClientPropertiesDTO result = new FLUIClientPropertiesDTO();\n");
        result.append(createSetDTOFLUIClientPropertiesDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenAboutDTO2MethodForActionOnLoaded(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        OverviewParameterDTO dto = gson.fromJson((String)requestData.getParameters().get("parameter"), OverviewParameterDTO.class);
        String declaration = "private OverviewParameterDTO createStep" + step + "DTO2Parameter()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        OverviewParameterDTO result = new OverviewParameterDTO();\n");
        result.append(createSetDTOOverviewParameterDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenAboutDTO1MethodForActionOnBackPressed(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        OverviewParameterDTO dto = gson.fromJson((String)requestData.getParameters().get("parameter"), OverviewParameterDTO.class);
        String declaration = "private OverviewParameterDTO createStep" + step + "DTO1Parameter()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        OverviewParameterDTO result = new OverviewParameterDTO();\n");
        result.append(createSetDTOOverviewParameterDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsDTO1MethodForActionWidgetButtonBackButtonClicked(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        DetailsParameterDTO dto = gson.fromJson((String)requestData.getParameters().get("parameter"), DetailsParameterDTO.class);
        String declaration = "private DetailsParameterDTO createStep" + step + "DTO1Parameter()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        DetailsParameterDTO result = new DetailsParameterDTO();\n");
        result.append(createSetDTODetailsParameterDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsDTO1MethodForActionWidgetButtonEditNameButtonClicked(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        DetailsParameterDTO dto = gson.fromJson((String)requestData.getParameters().get("parameter"), DetailsParameterDTO.class);
        String declaration = "private DetailsParameterDTO createStep" + step + "DTO1Parameter()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        DetailsParameterDTO result = new DetailsParameterDTO();\n");
        result.append(createSetDTODetailsParameterDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsDTO1MethodForActionWidgetButtonEditTextButtonClicked(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        DetailsParameterDTO dto = gson.fromJson((String)requestData.getParameters().get("parameter"), DetailsParameterDTO.class);
        String declaration = "private DetailsParameterDTO createStep" + step + "DTO1Parameter()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        DetailsParameterDTO result = new DetailsParameterDTO();\n");
        result.append(createSetDTODetailsParameterDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsDTO1MethodForActionWidgetButtonDeleteButtonClicked(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        DetailsParameterDTO dto = gson.fromJson((String)requestData.getParameters().get("parameter"), DetailsParameterDTO.class);
        String declaration = "private DetailsParameterDTO createStep" + step + "DTO1Parameter()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        DetailsParameterDTO result = new DetailsParameterDTO();\n");
        result.append(createSetDTODetailsParameterDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsDTO1MethodForActionWidgetButtonSaveNoteTextButtonClicked(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        DetailsParameterDTO dto = gson.fromJson((String)requestData.getParameters().get("parameter"), DetailsParameterDTO.class);
        String declaration = "private DetailsParameterDTO createStep" + step + "DTO1Parameter()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        DetailsParameterDTO result = new DetailsParameterDTO();\n");
        result.append(createSetDTODetailsParameterDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsDTO1MethodForActionWidgetButtonCancelEditNoteTextButtonClicked(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        DetailsParameterDTO dto = gson.fromJson((String)requestData.getParameters().get("parameter"), DetailsParameterDTO.class);
        String declaration = "private DetailsParameterDTO createStep" + step + "DTO1Parameter()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        DetailsParameterDTO result = new DetailsParameterDTO();\n");
        result.append(createSetDTODetailsParameterDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsDTO1MethodForActionOnAutosaveTimer(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        DetailsParameterDTO dto = gson.fromJson((String)requestData.getParameters().get("parameter"), DetailsParameterDTO.class);
        String declaration = "private DetailsParameterDTO createStep" + step + "DTO1Parameter()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        DetailsParameterDTO result = new DetailsParameterDTO();\n");
        result.append(createSetDTODetailsParameterDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsDTO2MethodForActionOnAutosaveTimer(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        EditStateDTO dto = gson.fromJson((String)requestData.getParameters().get("editState"), EditStateDTO.class);
        String declaration = "private EditStateDTO createStep" + step + "DTO2EditState()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        EditStateDTO result = new EditStateDTO();\n");
        result.append(createSetDTOEditStateDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsDTO1MethodForActionOnColorSelectBoxChanged(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        DetailsParameterDTO dto = gson.fromJson((String)requestData.getParameters().get("parameter"), DetailsParameterDTO.class);
        String declaration = "private DetailsParameterDTO createStep" + step + "DTO1Parameter()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        DetailsParameterDTO result = new DetailsParameterDTO();\n");
        result.append(createSetDTODetailsParameterDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsDTO1MethodForActionOnLoaded(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        FLUIClientPropertiesDTO dto = gson.fromJson((String)requestData.getParameters().get("_ClientProperties"), FLUIClientPropertiesDTO.class);
        String declaration = "private FLUIClientPropertiesDTO createStep" + step + "DTO1_ClientProperties()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        FLUIClientPropertiesDTO result = new FLUIClientPropertiesDTO();\n");
        result.append(createSetDTOFLUIClientPropertiesDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsDTO2MethodForActionOnLoaded(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        DetailsParameterDTO dto = gson.fromJson((String)requestData.getParameters().get("parameter"), DetailsParameterDTO.class);
        String declaration = "private DetailsParameterDTO createStep" + step + "DTO2Parameter()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        DetailsParameterDTO result = new DetailsParameterDTO();\n");
        result.append(createSetDTODetailsParameterDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenDetailsDTO1MethodForActionOnBackPressed(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        DetailsParameterDTO dto = gson.fromJson((String)requestData.getParameters().get("parameter"), DetailsParameterDTO.class);
        String declaration = "private DetailsParameterDTO createStep" + step + "DTO1Parameter()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        DetailsParameterDTO result = new DetailsParameterDTO();\n");
        result.append(createSetDTODetailsParameterDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenLoginDTO1MethodForActionOnLoaded(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        FLUIClientPropertiesDTO dto = gson.fromJson((String)requestData.getParameters().get("_ClientProperties"), FLUIClientPropertiesDTO.class);
        String declaration = "private FLUIClientPropertiesDTO createStep" + step + "DTO1_ClientProperties()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        FLUIClientPropertiesDTO result = new FLUIClientPropertiesDTO();\n");
        result.append(createSetDTOFLUIClientPropertiesDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenOverviewDTO1MethodForActionWidgetButtonMenuButtonClicked(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        OverviewParameterDTO dto = gson.fromJson((String)requestData.getParameters().get("parameter"), OverviewParameterDTO.class);
        String declaration = "private OverviewParameterDTO createStep" + step + "DTO1Parameter()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        OverviewParameterDTO result = new OverviewParameterDTO();\n");
        result.append(createSetDTOOverviewParameterDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenOverviewDTO1MethodForActionOnNotesTableRowClicked(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        OverviewParameterDTO dto = gson.fromJson((String)requestData.getParameters().get("parameter"), OverviewParameterDTO.class);
        String declaration = "private OverviewParameterDTO createStep" + step + "DTO1Parameter()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        OverviewParameterDTO result = new OverviewParameterDTO();\n");
        result.append(createSetDTOOverviewParameterDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenOverviewDTO1MethodForActionOnLoaded(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        FLUIClientPropertiesDTO dto = gson.fromJson((String)requestData.getParameters().get("_ClientProperties"), FLUIClientPropertiesDTO.class);
        String declaration = "private FLUIClientPropertiesDTO createStep" + step + "DTO1_ClientProperties()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        FLUIClientPropertiesDTO result = new FLUIClientPropertiesDTO();\n");
        result.append(createSetDTOFLUIClientPropertiesDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createScreenOverviewDTO2MethodForActionOnLoaded(int step, FLUIRequest requestData){
        StringBuilder result = new StringBuilder();
        OverviewParameterDTO dto = gson.fromJson((String)requestData.getParameters().get("parameter"), OverviewParameterDTO.class);
        String declaration = "private OverviewParameterDTO createStep" + step + "DTO2Parameter()";
        if (declaredCreateStepDTOMethods.contains(declaration)){
            return result;
        }
        declaredCreateStepDTOMethods.add(declaration);
        result.append("    " + declaration + "{\n");
        result.append("        OverviewParameterDTO result = new OverviewParameterDTO();\n");
        result.append(createSetDTOOverviewParameterDTO("        ", "result", 0, "result", dto));
        result.append("        return result;\n");
        result.append("    }\n");
        result.append("\n");
        return result;
    }

    private StringBuilder createSetDTOFLUIClientPropertiesDTO(String indent, String prefix, int loopDepth, String currentDTOName, FLUIClientPropertiesDTO dto){
         StringBuilder result = new StringBuilder();
         result.append(indent + prefix + ".setUserAgent(" + quoteIfNotNull(dto.getUserAgent()) + ");\n");
         result.append(indent + prefix + ".setNavigatorLanguage(" + quoteIfNotNull(dto.getNavigatorLanguage()) + ");\n");
         result.append(indent + prefix + ".setScreenAvailableWidthInPixels(" + dto.getScreenAvailableWidthInPixels() + ");\n");
         result.append(indent + prefix + ".setScreenAvailableHeightInPixels(" + dto.getScreenAvailableHeightInPixels() + ");\n");
         result.append(indent + prefix + ".setScreenWidthInPixels(" + dto.getScreenWidthInPixels() + ");\n");
         result.append(indent + prefix + ".setScreenHeightInPixels(" + dto.getScreenHeightInPixels() + ");\n");
         result.append(indent + prefix + ".setWindowInnerWidthInPixels(" + dto.getWindowInnerWidthInPixels() + ");\n");
         result.append(indent + prefix + ".setWindowInnerHeightInPixels(" + dto.getWindowInnerHeightInPixels() + ");\n");
         result.append(indent + prefix + ".setPixelHeightPerCM(" + dto.getPixelHeightPerCM() + ");\n");
         result.append(indent + prefix + ".setPixelWidthPerCM(" + dto.getPixelWidthPerCM() + ");\n");
         result.append(indent + prefix + ".setPixelHeightPerInch(" + dto.getPixelHeightPerInch() + ");\n");
         result.append(indent + prefix + ".setPixelWidthPerInch(" + dto.getPixelWidthPerInch() + ");\n");
         result.append(indent + prefix + ".setScreenWidthInCM(" + dto.getScreenWidthInCM() + ");\n");
         result.append(indent + prefix + ".setScreenHeightInCM(" + dto.getScreenHeightInCM() + ");\n");
         result.append(indent + prefix + ".setScreenWidthInInch(" + dto.getScreenWidthInInch() + ");\n");
         result.append(indent + prefix + ".setScreenHeightInInch(" + dto.getScreenHeightInInch() + ");\n");
         result.append(indent + prefix + ".setScreenDiagonalInInch(" + dto.getScreenDiagonalInInch() + ");\n");
         result.append(indent + prefix + ".setErrorMessage(" + quoteIfNotNull(dto.getErrorMessage()) + ");\n");
         return result;
    }

    public StringBuilder generateImports(){
        StringBuilder result = new StringBuilder();
        result.append("import generated.fliesenui.dto.DetailsParameterDTO;\n");
        result.append("import generated.fliesenui.dto.EditStateDTO;\n");
        result.append("import generated.fliesenui.dto.IdAndLabelDTO;\n");
        result.append("import generated.fliesenui.dto.IdAndLabelListDTO;\n");
        result.append("import generated.fliesenui.dto.OverviewItemDTO;\n");
        result.append("import generated.fliesenui.dto.OverviewListDTO;\n");
        result.append("import generated.fliesenui.dto.OverviewParameterDTO;\n");
        result.append("import generated.fliesenui.screen.AboutRequest;\n");
        result.append("import generated.fliesenui.screen.AboutReply;\n");
        result.append("import generated.fliesenui.screen.DetailsRequest;\n");
        result.append("import generated.fliesenui.screen.DetailsReply;\n");
        result.append("import generated.fliesenui.screen.LoginRequest;\n");
        result.append("import generated.fliesenui.screen.LoginReply;\n");
        result.append("import generated.fliesenui.screen.OverviewRequest;\n");
        result.append("import generated.fliesenui.screen.OverviewReply;\n");
         return result;
    }

    public StringBuilder generateSetPresenterStubs(){
        StringBuilder result = new StringBuilder();
        result.append("        screenManager.setAboutPresenter(/* TODO: Add presenter About*/);\n");
        result.append("        screenManager.setDetailsPresenter(/* TODO: Add presenter Details*/);\n");
        result.append("        screenManager.setLoginPresenter(/* TODO: Add presenter Login*/);\n");
        result.append("        screenManager.setOverviewPresenter(/* TODO: Add presenter Overview*/);\n");
         return result;
    }

    private int getNextDTOIndex(){
        return ++dtoIndex;
    }

    private int getNextListIndex(){
        return ++listIndex;
    }

    private String quoteIfNotNull(String string){
        if (string == null){
            return "null";
        }
        return "\"" + string + "\"";
    }

    private String toStringList(List<String> list){
        StringBuilder result = new StringBuilder();
        if (list == null){
            return "null";
        }
        result.append("Arrays.asList(");
        boolean first = true;
        for (String i: list){
            if (first){
                first = false;
            } else {
                result.append(", ");
            }
            if (i == null){
                result.append("null");
            } else {
                result.append("\"" + i + "\"");
            }
        }
        result.append(")");
        return result.toString();
    }

}