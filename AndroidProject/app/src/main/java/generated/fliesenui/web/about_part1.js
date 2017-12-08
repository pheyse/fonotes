
var about$controllerReady = false;
var about$logDebugBuffer = "";
var about$parameterDTO;

app.controller("about_Ctrl", function($scope, $mdToast, $mdDialog, $http) {
    about$setInitialValues();
    $scope.http = $http;

    $scope.showMessage = function (message) {
     if (message.typeID == 201){
             $mdToast.show($mdToast.simple().textContent(message.text).hideDelay(3000));
     } else if (message.typeID == 101) {
         $mdDialog.show(
                   $mdDialog.alert()
                     .parent(angular.element(document.querySelector('screenAboutPanel')))
                     .clickOutsideToClose(true)
                     .title(message.title)
                     .textContent(message.text)
                     .ariaLabel('Info Dialog' + message.title + ", " + message.text)
                     .ok('OK')
                 );
     } else if (message.typeID == 102) {
         $mdDialog.show(
                 $mdDialog.alert()
                 .parent(angular.element(document.querySelector('screenAboutPanel')))
                 .clickOutsideToClose(true)
                 .title("WARNING: " + message.title)
                 .textContent(message.text)
                 .ariaLabel('Warning Dialog' + message.title + ", " + message.text)
                 .ok('OK')
         );
     } else if (message.typeID == 103) {
         $mdDialog.show(
                 $mdDialog.alert()
                 .parent(angular.element(document.querySelector('screenAboutPanel')))
                 .clickOutsideToClose(true)
                 .title("ERROR: " + message.title)
                 .textContent(message.text)
                 .ariaLabel('Warning Dialog' + message.title + ", " + message.text)
                 .ok('OK')
         );
     }
    }
    $scope.showInputDialog = function(referenceID, callbackData, title, textContent, label, initialValueText, okText, cancelText) {
        var confirm = $mdDialog.prompt()
          .title(title)
          .textContent(textContent)
          .placeholder(label)
          .ariaLabel(label)
          .initialValue(initialValueText)
          .ok(okText)
          .cancel(cancelText);

        $mdDialog.show(confirm).then(function(result) {
            var request = about$createRequest("onInputDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["callbackData"] = callbackData;
            if (typeof result != "undefined"){
                request.parameters["result"] = result;
                about$executeRequest(request);
            } else {
                request.parameters["result"] = "";
                about$executeRequest(request);
            }
        }, function() {
            var request = about$createRequest("onInputDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["callbackData"] = callbackData;
            about$executeRequest(request);
        });
    };

    $scope.showConfirm = function(referenceID, callbackData, title, textContent, okText, cancelText) {
        var confirm = $mdDialog.confirm()
              .title(title)
              .textContent(textContent)
              .ariaLabel(title)
              .ok(okText)
              .cancel(cancelText);

        $mdDialog.show(confirm).then(function() {
            var request = about$createRequest("onConfirmDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["result"] = true;
            request.parameters["callbackData"] = callbackData;
            about$executeRequest(request);
        }, function() {
            var request = about$createRequest("onConfirmDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["result"] = false;
            request.parameters["callbackData"] = callbackData;
            about$executeRequest(request);
        });
    };

    $scope.showListChooser = function(parameter){
    	$scope.listChooserReferenceID = parameter.referenceID;
    	$scope.listChooserCallbackData = parameter.callbackData;
    	$scope.listChooserTitle = parameter.title;
    	$scope.listChooserMultiselect = parameter.multiSelect;
    	$scope.listChooserShowIcons = parameter.showIcons;
    	$scope.listChooserOKText = parameter.okText;
    	$scope.listChooserCancelText = parameter.cancelText;
    	$scope.listChooserItems = parameter.items;
    	$scope.listChooserShowFilter = parameter.showFilter;
        $scope.listChooserFilter = "";
    	
        $mdDialog.show({
            controller: ListChooserDialogController,
            parent: angular.element(document.body),
            scope: $scope,
            preserveScope: true, 
            clickOutsideToClose:true,
            template:
			     '<md-dialog aria-label="{{listChooserTitle}}" style="width: 80%;height: 80%;">'
               + '  <form ng-cloak style="background-color: grey;">'
               + '    <md-toolbar>'
               + '      <div class="md-toolbar-tools">'
               + '        <h2>{{listChooserTitle}}</h2>'
               + '      </div>'
               + '    </md-toolbar>'
               + '    <md-dialog-content>'
               + '      <div class="md-dialog-content">'
               + '	    <span ng-show="listChooserShowFilter" > '
               + '			<md-input-container class="md-block" flex-gt-sm>'
               + '				<label>Search</label>'
               + '				<input ng-model="listChooserFilter" style="width:99%">'
               + '			  </md-input-container>'
               + '		</span>'
               + '		<table style="width:100%; overflow-y: scroll;">'
               + '			<tr ng-repeat="i in listChooserItems | filter : {\'label\' : listChooserFilter}" '
               + '			    ng-click="listChooser_rowClicked($event, i.id, i)" '
               + '			    style="border-color:#999999;border-bottom-style: solid;border-width: 1px; background-color:{{rowBackgroundColor}}" '
               + '			    layout="row" '
               + '			    layout-wrap="" '
               + '			    ng-init="rowBackgroundColor=\'white\';" '
               + '			    ng-mouseleave="rowHover=false;rowBackgroundColor=\'white\';"'
               + '			    ng-mouseover="rowHover=true;rowBackgroundColor=\'#f3f3f3\';">'
               + '			    <td ng-if="listChooserMultiselect && i.selected"  style="min-height:60px; padding-left:15px; padding-top:15px;"><img src="img/_checkbox_checked.png"   width="20"/></td>'
               + '			    <td ng-if="listChooserMultiselect && !i.selected" style="min-height:60px; padding-left:15px; padding-top:15px;"><img src="img/_checkbox_unchecked.png" width="20"/></td>'
               + '			    <td ng-if="listChooserShowIcons" style="min-height:60px; padding-left:15px; padding-top:15px;"><img ng-src="img/{{imageAssetIDToName[i.imageAssetID]}}" width="40px" height="40px"/></td>'
               + '				<td style="word-wrap: break-word;min-height:60px; padding-left:15px; padding-top:15px;">{{i.label}}</td>'
               + '			</tr>'
               + '		</table>'
               + '      </div>'
               + '    </md-dialog-content>'
               + ''
               + '    <md-dialog-actions layout="row">'
               + '      <span flex></span>'
               + '      <md-button ng-click="cancel();">'
               + '       {{listChooserCancelText}}'
               + '      </md-button>'
               + '      <md-button ng-click="hide();listChooser_okClicked();" ng-visible="listChooserMultiselect">'
               + '        {{listChooserOKText}}'
               + '      </md-button>'
               + '    </md-dialog-actions>'
               + '  </form>'
               + '</md-dialog>'
        })
        .then(function(answer) {
        }, function() {
              $scope.listChooser_cancelled();
        });
    }
      
    function ListChooserDialogController($scope, $mdDialog) {
        $scope.hide = function() {
    	    $mdDialog.hide();
    	};
    	$scope.cancel = function() {
    	    $mdDialog.cancel();
    	};
        $scope.answer = function(answer) {
    	    $mdDialog.hide(answer);
    	};
    	    
    	$scope.listChooser_rowClicked = function (event, itemID, item) {
    	    if (!event.defaultPrevented) {
    	        console.log("clicked row with itemID = " + itemID + ", old selected = " + item.selected);
                if ($scope.listChooserMultiselect){
    	            item.selected = !item.selected;
    	        	console.log("new selected = " + item.selected);
    	        } else if (!$scope.listChooserMultiselect){
    	            //:clear old selection
    	        	for (i = 0; i < $scope.listChooserItems.length; i++){
    	        	    $scope.listChooserItems[i].selected = false;
    	            }
    	            //: select item
        	        item.selected = !item.selected;
        	        	  
    	        	$mdDialog.hide("");
        	        $scope.listChooser_okClicked();        		  
    	        }
    	    }
        };
    } 
      
    $scope.listChooser_okClicked = function () {
        console.log("clicked ok");
        var selectedIDs = [];
	       for (i = 0; i < $scope.listChooserItems.length; i++){
            var item = $scope.listChooserItems[i];
            if (item.selected){
//			    console.log("selected id: " + item.id);
            selectedIDs.push(item.id);
            }
        }
        console.log("selected ids: " + selectedIDs);
        var request = about$createRequest("onListChooserResult");
        request.parameters["referenceID"] = $scope.listChooserReferenceID;
        request.parameters["callbackData"] = $scope.listChooserCallbackData;
        request.parameters["selectedIDs"] = selectedIDs;
        about$executeRequest(request);
    }

    $scope.listChooser_cancelled = function () {
	    console.log("list chooser: cancelled");
        var request = about$createRequest("onListChooserResult");
        request.parameters["referenceID"] = $scope.listChooserReferenceID;
        request.parameters["callbackData"] = $scope.listChooserCallbackData;
        request.parameters["selectedIDs"] = null;
        about$executeRequest(request);
    }
      

    $scope.about_widgetButtonBackButtonClicked = function () {
        try{
            var request = about$createRequest("widgetButtonBackButtonClicked");
            request.parameters["parameter"] = about$getParameter_dto();
            about$executeRequest(request);
        } catch (err){
            console.log("FLUI error in method 'about_widgetButtonBackButtonClicked': " + errorToString(err));
        }
    }

    if (!singlePageApp){
        var queryDict = {}
        location.search.substr(1).split("&").forEach(function(item) {queryDict[item.split("=")[0]] = item.split("=")[1]})
    about$parameterDTO = about$fromURLParameter(queryDict["parameterDTO"]);
        if (typeof about$parameterDTO == "undefined"){
            about$parameterDTO = null;
        } else if (about$parameterDTO != null){
        }
        $scope.parameter = about$parameterDTO;
    }

    setTimeout(function() {if (("WebBrowser" == browserMode) && (!singlePageApp)){about$executeOnLoadRequest();}}, 0);
    setTimeout(function() {
        if (typeof previewWindow != "undefined") {
            previewWindow.initForPreview();
        } else {
        }
        
        }, 0);

    $scope.imageAssetIDToName = about$createImageAssetIDToNameMap();
    about$controllerReady = true;

});

var about$setInitialValues = function(){
    var scope = angular.element(document.getElementById('screenAboutPanel')).scope();
    scope.about_backButton_propertyText = "";
    scope.about_backButton_propertyVisible = true;
    scope.about_info_propertyText = "About Fonotes";
    scope.about_info_propertyVisible = true;
    scope.about_aboutText_propertyText = "...";
    scope.about_aboutText_propertyBackgroundColor = "";
    scope.about_aboutText_propertyVisible = true;
    scope.about_backButton_propertyImageSource = "back.png";
}

var about$createImageAssetIDToNameMap = function(){
    result = new Object();
    result["back"] = "back.png";
    result["delete"] = "delete.png";
    result["menu"] = "menu.png";
    return result;
}

var about$logDebug = function(message){
//	if (about$logDebugBuffer.length > 0){
//		console.log("buffered messages:\n" + about$logDebugBuffer + "\n}");
//	}
//	about$logDebugBuffer = about$logDebugBuffer + message + "\n";
    console.log(message);
}

var about$fromURLParameter = function(urlParameter){
	if (typeof urlParameter != "undefined"){
		if (urlParameter == null){
			return null;
		}
		var objectBase64String = urlParameter.replace(new RegExp("-", 'g'), "+").replace(new RegExp("_", 'g'), "/").replace(new RegExp("~", 'g'), "=");
		var jsonString = atob(objectBase64String);
		return JSON.parse(jsonString);
	} else {
		return null;
	}
}

about$executeOnLoadRequest = function(){
    var request = about$createRequest("onLoaded");
    request.parameters["_ClientProperties"] = getClientProperties();
    request.parameters["parameter"] = about$getParameter_dto();
    about$executeRequest(request);
}

/** called in JavaFX mode by web view when the screen object has been set. Wait until the Angular JS controller is ready and then call onLoad in the listener*/
about$executeOnLoadWhenControllerIsReady = function(){
    about$logDebug("executeOnLoadWhenControllerIsReady: about$controllerReady = " + about$controllerReady);
    if (about$controllerReady){
        about$logDebug("executeOnLoadWhenControllerIsReady: ready");
        about$executeOnLoadRequest();
        about$logDebug("executeOnLoadWhenControllerIsReady: called onLoaded");
    } else {
        about$logDebug("executeOnLoadWhenControllerIsReady: waiting");
        setTimeout(about$executeOnLoadWhenControllerIsReady(), 200);
    }
}
about$createRequest = function(actionName){
    request = new Object();
    request.action = actionName;
    request.currentLanguage = currentLanguage;
    request.screenID = "about";
    request.parameters = new Object();
    return request;
};

about$executeRequest = function(request){
    //later: add server call and process request here...
    if (browserMode == 'JavaFX'){
        screenManager.onRequest(JSON.stringify(request), null, null);
    } else {
        var scope = angular.element(document.getElementById('screenAboutPanel')).scope();
        scope.http.post("/request", request).then(function (response) {
            if ((response.data != null) && (typeof response.data != "undefined")){
                about$processReply(JSON.stringify(response.data));
            }
        });
    }
};


about$setInfo_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenAboutPanel')).scope();
    scope.$apply(function(){
        scope.about_info_propertyText = text;
    });
};
about$getInfo_widgetText = function(){
    var scope = angular.element(document.getElementById('screenAboutPanel')).scope();
    return scope.about_info_propertyText;
};



about_setAboutTextText = function (text){
    target = document.getElementById("about_markdownViewAboutText");
    target.innerHTML = text;
};

about$setParameter_dto = function(jsonString){
    var paramObject = JSON.parse(jsonString);
    var scope = angular.element(document.getElementById('screenAboutPanel')).scope();
    scope.$apply(function(){
        scope.parameter = paramObject;
    });
};
about$getParameter_dto = function(){
    var scope = angular.element(document.getElementById('screenAboutPanel')).scope();
    var result = new Object();
    if (scope.parameter != null){
        result = JSON.parse(JSON.stringify(scope.parameter));
    }
    return JSON.stringify(result);
};

about$initDTOTypeDetailsParameterForPreview = function(index){
    var result = new Object();
    result.noteName = "myNote" + "(" + index + ")";
    result.password = "5678" + "(" + index + ")";
    return result;
};
about$initDTOTypeDetailsParameterListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = about$initDTOTypeDetailsParameterForPreview(0);
    result.items[1] = about$initDTOTypeDetailsParameterForPreview(1);
    result.items[2] = about$initDTOTypeDetailsParameterForPreview(2);
    result.items[3] = about$initDTOTypeDetailsParameterForPreview(3);
    result.items[4] = about$initDTOTypeDetailsParameterForPreview(4);
    result.items[5] = about$initDTOTypeDetailsParameterForPreview(5);
    result.items[6] = about$initDTOTypeDetailsParameterForPreview(6);
    result.items[7] = about$initDTOTypeDetailsParameterForPreview(7);
    result.items[8] = about$initDTOTypeDetailsParameterForPreview(8);
    result.items[9] = about$initDTOTypeDetailsParameterForPreview(9);
    return result;
};
about$initDTOTypeEditStateForPreview = function(index){
    var result = new Object();
    result.text = "hello" + "(" + index + ")";
    result.inEditMode = true;
    return result;
};
about$initDTOTypeEditStateListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = about$initDTOTypeEditStateForPreview(0);
    result.items[1] = about$initDTOTypeEditStateForPreview(1);
    result.items[2] = about$initDTOTypeEditStateForPreview(2);
    result.items[3] = about$initDTOTypeEditStateForPreview(3);
    result.items[4] = about$initDTOTypeEditStateForPreview(4);
    result.items[5] = about$initDTOTypeEditStateForPreview(5);
    result.items[6] = about$initDTOTypeEditStateForPreview(6);
    result.items[7] = about$initDTOTypeEditStateForPreview(7);
    result.items[8] = about$initDTOTypeEditStateForPreview(8);
    result.items[9] = about$initDTOTypeEditStateForPreview(9);
    return result;
};
about$initDTOTypeIdAndLabelForPreview = function(index){
    var result = new Object();
    result.id = "1234" + "(" + index + ")";
    result.label = "1234" + "(" + index + ")";
    return result;
};
about$initDTOTypeIdAndLabelListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = about$initDTOTypeIdAndLabelForPreview(0);
    result.items[1] = about$initDTOTypeIdAndLabelForPreview(1);
    result.items[2] = about$initDTOTypeIdAndLabelForPreview(2);
    result.items[3] = about$initDTOTypeIdAndLabelForPreview(3);
    result.items[4] = about$initDTOTypeIdAndLabelForPreview(4);
    result.items[5] = about$initDTOTypeIdAndLabelForPreview(5);
    result.items[6] = about$initDTOTypeIdAndLabelForPreview(6);
    result.items[7] = about$initDTOTypeIdAndLabelForPreview(7);
    result.items[8] = about$initDTOTypeIdAndLabelForPreview(8);
    result.items[9] = about$initDTOTypeIdAndLabelForPreview(9);
    return result;
};
about$initDTOTypeIdAndLabelListListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = about$initDTOTypeIdAndLabelListForPreview(0);
    result.items[1] = about$initDTOTypeIdAndLabelListForPreview(1);
    result.items[2] = about$initDTOTypeIdAndLabelListForPreview(2);
    result.items[3] = about$initDTOTypeIdAndLabelListForPreview(3);
    result.items[4] = about$initDTOTypeIdAndLabelListForPreview(4);
    result.items[5] = about$initDTOTypeIdAndLabelListForPreview(5);
    result.items[6] = about$initDTOTypeIdAndLabelListForPreview(6);
    result.items[7] = about$initDTOTypeIdAndLabelListForPreview(7);
    result.items[8] = about$initDTOTypeIdAndLabelListForPreview(8);
    result.items[9] = about$initDTOTypeIdAndLabelListForPreview(9);
    return result;
};
about$initDTOTypeOverviewItemForPreview = function(index){
    var result = new Object();
    result.id = "ID" + "(" + index + ")";
    result.label = "My Notes" + "(" + index + ")";
    result.color = "#ff0000" + "(" + index + ")";
    return result;
};
about$initDTOTypeOverviewItemListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = about$initDTOTypeOverviewItemForPreview(0);
    result.items[1] = about$initDTOTypeOverviewItemForPreview(1);
    result.items[2] = about$initDTOTypeOverviewItemForPreview(2);
    result.items[3] = about$initDTOTypeOverviewItemForPreview(3);
    result.items[4] = about$initDTOTypeOverviewItemForPreview(4);
    result.items[5] = about$initDTOTypeOverviewItemForPreview(5);
    result.items[6] = about$initDTOTypeOverviewItemForPreview(6);
    result.items[7] = about$initDTOTypeOverviewItemForPreview(7);
    result.items[8] = about$initDTOTypeOverviewItemForPreview(8);
    result.items[9] = about$initDTOTypeOverviewItemForPreview(9);
    return result;
};
about$initDTOTypeOverviewListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = about$initDTOTypeOverviewItemForPreview(0);
    result.items[1] = about$initDTOTypeOverviewItemForPreview(1);
    result.items[2] = about$initDTOTypeOverviewItemForPreview(2);
    result.items[3] = about$initDTOTypeOverviewItemForPreview(3);
    result.items[4] = about$initDTOTypeOverviewItemForPreview(4);
    result.items[5] = about$initDTOTypeOverviewItemForPreview(5);
    result.items[6] = about$initDTOTypeOverviewItemForPreview(6);
    result.items[7] = about$initDTOTypeOverviewItemForPreview(7);
    result.items[8] = about$initDTOTypeOverviewItemForPreview(8);
    result.items[9] = about$initDTOTypeOverviewItemForPreview(9);
    return result;
};
about$initDTOTypeOverviewListListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = about$initDTOTypeOverviewListForPreview(0);
    result.items[1] = about$initDTOTypeOverviewListForPreview(1);
    result.items[2] = about$initDTOTypeOverviewListForPreview(2);
    result.items[3] = about$initDTOTypeOverviewListForPreview(3);
    result.items[4] = about$initDTOTypeOverviewListForPreview(4);
    result.items[5] = about$initDTOTypeOverviewListForPreview(5);
    result.items[6] = about$initDTOTypeOverviewListForPreview(6);
    result.items[7] = about$initDTOTypeOverviewListForPreview(7);
    result.items[8] = about$initDTOTypeOverviewListForPreview(8);
    result.items[9] = about$initDTOTypeOverviewListForPreview(9);
    return result;
};
about$initDTOTypeOverviewParameterForPreview = function(index){
    var result = new Object();
    result.password = "1234" + "(" + index + ")";
    return result;
};
about$initDTOTypeOverviewParameterListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = about$initDTOTypeOverviewParameterForPreview(0);
    result.items[1] = about$initDTOTypeOverviewParameterForPreview(1);
    result.items[2] = about$initDTOTypeOverviewParameterForPreview(2);
    result.items[3] = about$initDTOTypeOverviewParameterForPreview(3);
    result.items[4] = about$initDTOTypeOverviewParameterForPreview(4);
    result.items[5] = about$initDTOTypeOverviewParameterForPreview(5);
    result.items[6] = about$initDTOTypeOverviewParameterForPreview(6);
    result.items[7] = about$initDTOTypeOverviewParameterForPreview(7);
    result.items[8] = about$initDTOTypeOverviewParameterForPreview(8);
    result.items[9] = about$initDTOTypeOverviewParameterForPreview(9);
    return result;
};

about$initForPreview = function(){
    console.log('about:executing initForPreview in JS!');
    var scope = angular.element(document.getElementById('screenAboutPanel')).scope();
    scope.parameter = about$initDTOTypeOverviewParameterForPreview(0);
    setTimeout(function() {scope.$digest();}, 0);
}


var about$findItemWithID = function(scope, variableName, id){
    var list = null;
    var fieldName = null;
    if (list == null){
        return null;
    }
    var length = list.length;
    for (var i = 0; i < length; i++) {
        if (list[i][fieldName] == id){
            return list[i]; 
        }
    }
    return null;
}
var about$openScreen = function(screenToOpen, openParameter){
    if (singlePageApp) {
        setTimeout(function() {openScreenSinglePageApp(screenToOpen, openParameter);}, 0);
    } else {
        about$openScreenMultiPageApp(screenToOpen, openParameter);
    }
}
var about$openScreenMultiPageApp = function(screenToOpen, openParameter){
    var screenToOpenURL = screenToOpen + "_" + htmlFileSuffix + ".html";
    if (typeof openParameter != "undefined") {
        var jsonString = JSON.stringify(openParameter);
        var base64String = btoa(jsonString);
            var urlParameterString = base64String.replace(new RegExp("\\+", 'g'), "-").replace(new RegExp("/", 'g'), "_").replace(new RegExp("=", 'g'), "~");
            var screenToOpenURL = screenToOpenURL + "?parameterDTO=" + urlParameterString;
            console.log("screenToOpenURL via screenToOpen and openParameter = >>" + screenToOpenURL + "<<");
    }
    window.open(screenToOpenURL, "_self");
}

about$backButtonPressed = function(){
    console.log("Screen about: Back pressed.");
    var $scope = angular.element(document.getElementById('screenAboutPanel')).scope();
    var request = about$createRequest("onBackPressed");
    request.parameters["parameter"] = about$getParameter_dto();
    about$executeRequest(request);
};

about$updateViews = function(){
};

about$processReply = function(jsonString){
    var reply = JSON.parse(jsonString);
    if (typeof reply.languageToSet != "undefined") {
        currentLanguage = reply.languageToSet;
    }
    var scope = angular.element(document.getElementById('screenAboutPanel')).scope();
    for (i = 0, len = reply.dtosToSet.length; i < len; i++) {
        var dtoValue = reply.dtoValues[reply.dtosToSet[i]];
        scope[reply.dtosToSet[i]] = dtoValue;
        if (reply.dtosToSet[i] == 'parameter'){
        }
    }
    for (i = 0, len = reply.dtosToSet.length; i < len; i++) {
        var dtoValue = reply.dtoValues[reply.dtosToSet[i]];
        if (reply.dtosToSet[i] == 'parameter'){
        }
    }
    for (i = 0, len = reply.objectsToSetValue.length; i < len; i++) {
        var valueToSet = reply.objectSetValueValues[reply.objectsToSetValue[i]];
        this[reply.objectsToSetValue[i]].setValue(valueToSet);
    }
    for (i = 0, len = reply.variablesToSet.length; i < len; i++) { 
        scope[reply.variablesToSet[i]] = reply.variableValues[reply.variablesToSet[i]];
    }
    for (key in reply.selectBoxSelectedIDs) {
        scope[key] = about$findItemWithID(scope, key, reply.selectBoxSelectedIDs[key]);
    }

    for (key in reply.markdownViewTexts) {
        if (key == "aboutText"){
            about_setAboutTextText(reply.markdownViewTexts[key]);
        }
    }

    if (reply.message != null){
        scope.showMessage(reply.message);
    }
    for (textEditorName in reply.textHighlighting){
        var lastCursorPos = this[textEditorName].getCursor(); //: clear highlighting
        this[textEditorName].setValue(this[textEditorName].getValue()); //: clear highlighting
        this[textEditorName].setCursor(lastCursorPos); //: clear highlighting
        for (highlightingItemKey in reply.textHighlighting[textEditorName]){
            highlightingItem = reply.textHighlighting[textEditorName][highlightingItemKey];
            this[textEditorName].markText({line:highlightingItem.startLine,ch:highlightingItem.startPosInLine},{line:highlightingItem.endLine,ch:highlightingItem.endPosInLine},{className:highlightingItem.style})
        }
    }
    for (textEditorName in reply.cursorPosValues){
        cursorPosItem = reply.cursorPosValues[textEditorName];
        this[textEditorName].setCursor(cursorPosItem.line, cursorPosItem.posInLine);
        this[textEditorName].focus();
    }

    for (textEditorName in reply.contextAssists){
        contextAssistItem = reply.contextAssists[textEditorName];
        console.log("context assist: contextAssistItem = " + JSON.stringify(contextAssistItem));
        var hintValue = {}
        hintValue.from = {line:contextAssistItem.replaceFrom.line,ch:contextAssistItem.replaceFrom.posInLine};
        hintValue.to = {line:contextAssistItem.replaceTo.line,ch:contextAssistItem.replaceTo.posInLine};
        hintValue.selectedHint = contextAssistItem.selectedItem;
        hintValue.list = [];
        var arrayLength = contextAssistItem.choices.length;
        for (var i = 0; i < arrayLength; i++) {
            var choice = contextAssistItem.choices[i];
            hintValue.list[i] = {displayText: choice.label, text: choice.text}
        }
        console.log("context assist: options = " + JSON.stringify(hintValue));
        this[textEditorName].showHint({hint:function(){return hintValue;}});
    }

    for (key in reply.tableCheckedRowIDs){
        scope[key] = new Object();
        for (i in reply.tableCheckedRowIDs[key]){
            scope[key][reply.tableCheckedRowIDs[key][i]] = true;
        }
    }

    var screenToOpen = reply.screenToOpen;
    if (typeof screenToOpen != "undefined") {
        about$openScreen(screenToOpen, reply.openParameter);
    }
    var urlToOpen = reply.urlToOpen;
    if (typeof urlToOpen != "undefined") {
        if (browserMode == 'JavaFX') {
            webView.openURL(urlToOpen, reply.openURLInNewWindow);
        } else {
            var target = "_self";
            if (reply.openURLInNewWindow){
                target = "_blank";
            }
            window.open(urlToOpen, target);
        }
    }

    var downloadFileStreamID = reply.downloadFileStreamID;
    if (typeof downloadFileStreamID != "undefined") {
        if (browserMode == 'JavaFX') {
            webView.downloadFile(downloadFileStreamID);
        } else {
            window.open("download/" + downloadFileStreamID, "_blank");
        }
    }

    var inputDialogParameters = reply.inputDialogParameters;
    if (typeof inputDialogParameters != "undefined") {
        scope.showInputDialog(inputDialogParameters.referenceID, inputDialogParameters.callbackData, inputDialogParameters.title, inputDialogParameters.textContent, inputDialogParameters.label, inputDialogParameters.initialValueText, inputDialogParameters.okText, inputDialogParameters.cancelText);
    }

    var confirmDialogParameters = reply.confirmDialogParameters;
    if (typeof confirmDialogParameters != "undefined") {
        scope.showConfirm(confirmDialogParameters.referenceID, confirmDialogParameters.callbackData, confirmDialogParameters.title, confirmDialogParameters.textContent, confirmDialogParameters.okText, confirmDialogParameters.cancelText);
    }
    if (typeof reply.listChooserParameters != "undefined") {
        scope.showListChooser(reply.listChooserParameters);
    }
    setTimeout(function() {scope.$digest();about$updateViews();}, 0);

};
