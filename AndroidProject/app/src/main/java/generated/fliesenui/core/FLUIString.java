/*Generated! Do not modify!*/ package generated.fliesenui.core;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import java.util.Map;
/*Generated! Do not modify!*/ import java.util.HashMap;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class FLUIString{
/*Generated! Do not modify!*/     private static final Map<String, String> STRINGS = createStringsMap();
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static String getString(StringLanguage language, StringID id){
/*Generated! Do not modify!*/         String result = STRINGS.get(language + ":" + id);
/*Generated! Do not modify!*/         if (result == null){
/*Generated! Do not modify!*/             result = STRINGS.get("DEFAULT:" + id);
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return result;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     /** @param formatArgs are used just like in String.format */
/*Generated! Do not modify!*/     public static String getString(StringLanguage language, StringID id, Object... formatArgs){
/*Generated! Do not modify!*/         String result = getString(language, id);
/*Generated! Do not modify!*/         if (result == null){
/*Generated! Do not modify!*/             return null;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/         return String.format(result, formatArgs);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static String getString(FLUIAbstractReply reply, StringID id){
/*Generated! Do not modify!*/         return getString(reply.getCurrentLanguage(), id);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     /** @param formatArgs are used just like in String.format */
/*Generated! Do not modify!*/     public static String getString(FLUIAbstractReply reply, StringID id, Object... formatArgs){
/*Generated! Do not modify!*/         return getString(reply.getCurrentLanguage(), id, formatArgs);
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public enum StringLanguage{}
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public enum StringID{
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     private static Map<String, String> createStringsMap(){
/*Generated! Do not modify!*/         Map<String, String> m = new HashMap<String, String>();
/*Generated! Do not modify!*/         return m;
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ }
/*Generated! Do not modify!*/ 