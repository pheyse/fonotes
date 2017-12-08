/*Generated! Do not modify!*/ package generated.fliesenui.screen;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import java.util.Collection;
/*Generated! Do not modify!*/ import java.util.Map;
/*Generated! Do not modify!*/ import java.util.TreeMap;
/*Generated! Do not modify!*/ import java.util.List;
/*Generated! Do not modify!*/ import com.google.gson.Gson;
/*Generated! Do not modify!*/ import com.google.gson.GsonBuilder;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.core.CallbackMethodCall;
/*Generated! Do not modify!*/ import generated.fliesenui.core.ListChooserParameters;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.DetailsReply;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.DetailsParameterDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.DetailsParameterListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.EditStateDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.EditStateListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.IdAndLabelDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.IdAndLabelListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.IdAndLabelListListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewItemDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewItemListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewListListDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewParameterDTO;
/*Generated! Do not modify!*/ import generated.fliesenui.dto.OverviewParameterListDTO;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class DetailsListChooserDialogOptions{
/*Generated! Do not modify!*/      private DetailsReply reply;
/*Generated! Do not modify!*/      private ListChooserParameters dialogParameters;
/*Generated! Do not modify!*/      protected Gson gson = new GsonBuilder().create();
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/      protected DetailsListChooserDialogOptions(DetailsReply reply, ListChooserParameters dialogParameters){
/*Generated! Do not modify!*/          this.reply = reply;
/*Generated! Do not modify!*/          this.dialogParameters = dialogParameters;
/*Generated! Do not modify!*/      }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public void withCallbackMenu(DetailsParameterDTO parameter){
/*Generated! Do not modify!*/         CallbackMethodCall methodCall = new CallbackMethodCall();
/*Generated! Do not modify!*/         methodCall.setCallbackMethodIndex(0);
/*Generated! Do not modify!*/         Map<String, Object> params = new TreeMap<String, Object>();
/*Generated! Do not modify!*/         params.put("parameter", gson.toJson(parameter));
/*Generated! Do not modify!*/         methodCall.setParameterValues(params);
/*Generated! Do not modify!*/         if (dialogParameters == null){
/*Generated! Do not modify!*/             return;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         dialogParameters.setCallbackData(gson.toJson(methodCall));
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }