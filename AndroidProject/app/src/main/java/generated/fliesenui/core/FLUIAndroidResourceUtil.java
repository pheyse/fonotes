/*Generated! Do not modify!*/ package generated.fliesenui.core;
/*Generated! Do not modify!*/ import generated.fliesenui.core.FLUIImageAssets.ImageAsset;
/*Generated! Do not modify!*/ import com.bright_side_it.fonotes.R; //read from Manifest file in Android project
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class FLUIAndroidResourceUtil {
/*Generated! Do not modify!*/     public static int getResourceIDForImageAssetID(String imageAssetID) throws Exception{
/*Generated! Do not modify!*/         switch (imageAssetID){
/*Generated! Do not modify!*/             case "back":
/*Generated! Do not modify!*/                 return R.drawable.flui_generated_back;
/*Generated! Do not modify!*/             case "delete":
/*Generated! Do not modify!*/                 return R.drawable.flui_generated_delete;
/*Generated! Do not modify!*/             case "menu":
/*Generated! Do not modify!*/                 return R.drawable.flui_generated_menu;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         throw new Exception("No image resource for image asset id '" + imageAssetID + "'");
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static int getResourceIDOrZeroForImageAssetID(String imageAssetID){
/*Generated! Do not modify!*/         try{
/*Generated! Do not modify!*/             return getResourceIDForImageAssetID(imageAssetID);
/*Generated! Do not modify!*/         } catch (Exception e){
/*Generated! Do not modify!*/             return 0; // is imageView.setImageResource(0) is called, the image is cleared
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }