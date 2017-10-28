/*Generated! Do not modify!*/ package generated.fliesenui.core;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ import generated.fliesenui.screen.AboutReply;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.DetailsReply;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.LoginReply;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.MarkdownHelpReply;
/*Generated! Do not modify!*/ import generated.fliesenui.screen.OverviewReply;
/*Generated! Do not modify!*/ import java.util.Collection;
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/ public class FLUIReplyUtil {
/*Generated! Do not modify!*/ 
/*Generated! Do not modify!*/     public static void showInputDialog(FLUIAbstractReplyContainer reply, String referenceID, String title, String textContent, String label, String initialValueText, String okText, String cancelText){
/*Generated! Do not modify!*/         switch (reply.getClass().getName()){
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.AboutReply":
/*Generated! Do not modify!*/             ((AboutReply)reply).showInputDialog(referenceID, title, textContent, label, initialValueText, okText, cancelText);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.DetailsReply":
/*Generated! Do not modify!*/             ((DetailsReply)reply).showInputDialog(referenceID, title, textContent, label, initialValueText, okText, cancelText);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.LoginReply":
/*Generated! Do not modify!*/             ((LoginReply)reply).showInputDialog(referenceID, title, textContent, label, initialValueText, okText, cancelText);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.MarkdownHelpReply":
/*Generated! Do not modify!*/             ((MarkdownHelpReply)reply).showInputDialog(referenceID, title, textContent, label, initialValueText, okText, cancelText);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.OverviewReply":
/*Generated! Do not modify!*/             ((OverviewReply)reply).showInputDialog(referenceID, title, textContent, label, initialValueText, okText, cancelText);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     public static void showConfirmDialog(FLUIAbstractReplyContainer reply, String referenceID, String title, String textContent, String okText, String cancelText){
/*Generated! Do not modify!*/         switch (reply.getClass().getName()){
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.AboutReply":
/*Generated! Do not modify!*/             ((AboutReply)reply).showConfirmDialog(referenceID, title, textContent, okText, cancelText);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.DetailsReply":
/*Generated! Do not modify!*/             ((DetailsReply)reply).showConfirmDialog(referenceID, title, textContent, okText, cancelText);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.LoginReply":
/*Generated! Do not modify!*/             ((LoginReply)reply).showConfirmDialog(referenceID, title, textContent, okText, cancelText);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.MarkdownHelpReply":
/*Generated! Do not modify!*/             ((MarkdownHelpReply)reply).showConfirmDialog(referenceID, title, textContent, okText, cancelText);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.OverviewReply":
/*Generated! Do not modify!*/             ((OverviewReply)reply).showConfirmDialog(referenceID, title, textContent, okText, cancelText);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     public static void showListChooser(FLUIAbstractReplyContainer reply, String referenceID, boolean multiSelect, boolean showFilter, String title, IDLabelImageAssetList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/         switch (reply.getClass().getName()){
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.AboutReply":
/*Generated! Do not modify!*/             ((AboutReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.DetailsReply":
/*Generated! Do not modify!*/             ((DetailsReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.LoginReply":
/*Generated! Do not modify!*/             ((LoginReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.MarkdownHelpReply":
/*Generated! Do not modify!*/             ((MarkdownHelpReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.OverviewReply":
/*Generated! Do not modify!*/             ((OverviewReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     public static void showListChooser(FLUIAbstractReplyContainer reply, String referenceID, boolean multiSelect, boolean showFilter, String title, IDLabelList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/         switch (reply.getClass().getName()){
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.AboutReply":
/*Generated! Do not modify!*/             ((AboutReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.DetailsReply":
/*Generated! Do not modify!*/             ((DetailsReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.LoginReply":
/*Generated! Do not modify!*/             ((LoginReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.MarkdownHelpReply":
/*Generated! Do not modify!*/             ((MarkdownHelpReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.OverviewReply":
/*Generated! Do not modify!*/             ((OverviewReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     public static void showListChooser(FLUIAbstractReplyContainer reply, String referenceID, boolean multiSelect, boolean showFilter, String title, String okText, String cancelText, IDLabelImageAssetList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/         switch (reply.getClass().getName()){
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.AboutReply":
/*Generated! Do not modify!*/             ((AboutReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, okText, cancelText, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.DetailsReply":
/*Generated! Do not modify!*/             ((DetailsReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, okText, cancelText, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.LoginReply":
/*Generated! Do not modify!*/             ((LoginReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, okText, cancelText, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.MarkdownHelpReply":
/*Generated! Do not modify!*/             ((MarkdownHelpReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, okText, cancelText, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.OverviewReply":
/*Generated! Do not modify!*/             ((OverviewReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, okText, cancelText, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/     public static void showListChooser(FLUIAbstractReplyContainer reply, String referenceID, boolean multiSelect, boolean showFilter, String title, String okText, String cancelText, IDLabelList items, Collection<String> selectedIDs){
/*Generated! Do not modify!*/         switch (reply.getClass().getName()){
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.AboutReply":
/*Generated! Do not modify!*/             ((AboutReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, okText, cancelText, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.DetailsReply":
/*Generated! Do not modify!*/             ((DetailsReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, okText, cancelText, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.LoginReply":
/*Generated! Do not modify!*/             ((LoginReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, okText, cancelText, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.MarkdownHelpReply":
/*Generated! Do not modify!*/             ((MarkdownHelpReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, okText, cancelText, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         case "generated.fliesenui.screen.OverviewReply":
/*Generated! Do not modify!*/             ((OverviewReply)reply).showListChooser(referenceID, multiSelect, showFilter, title, okText, cancelText, items, selectedIDs);
/*Generated! Do not modify!*/             break;
/*Generated! Do not modify!*/         }
/*Generated! Do not modify!*/     }
/*Generated! Do not modify!*/ }