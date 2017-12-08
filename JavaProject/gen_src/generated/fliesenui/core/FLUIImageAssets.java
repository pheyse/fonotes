package generated.fliesenui.core;

public class FLUIImageAssets {

public enum ImageAsset {
        BACK("back", "back.png")
      , DELETE("delete", "delete.png")
      , MENU("menu", "menu.png");

        private String id;
        private String filename;

        ImageAsset(String id, String filename) {
            this.id = id;
            this.filename = filename;
        }

        public String getID() {
            return id;
        }

        public String getFilename() {
            return filename;
        }
    }

}
