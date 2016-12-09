
var overview$controllerReady = false;
var overview$logDebugBuffer = "";
var overview$parameterDTO;

app.controller("overview_Ctrl", function($scope, $mdToast, $mdDialog, $http) {
    overview$setInitialValues();
    $scope.http = $http;

    $scope.showMessage = function (message) {
     if (message.typeID == 201){
             $mdToast.show($mdToast.simple().textContent(message.text).hideDelay(3000));
     } else if (message.typeID == 101) {
         $mdDialog.show(
                   $mdDialog.alert()
                     .parent(angular.element(document.querySelector('screenOverviewPanel')))
                     .clickOutsideToClose(true)
                     .title(message.title)
                     .textContent(message.text)
                     .ariaLabel('Info Dialog' + message.title + ", " + message.text)
                     .ok('OK')
                 );
     } else if (message.typeID == 102) {
         $mdDialog.show(
                 $mdDialog.alert()
                 .parent(angular.element(document.querySelector('screenOverviewPanel')))
                 .clickOutsideToClose(true)
                 .title("WARNING: " + message.title)
                 .textContent(message.text)
                 .ariaLabel('Warning Dialog' + message.title + ", " + message.text)
                 .ok('OK')
         );
     } else if (message.typeID == 103) {
         $mdDialog.show(
                 $mdDialog.alert()
                 .parent(angular.element(document.querySelector('screenOverviewPanel')))
                 .clickOutsideToClose(true)
                 .title("ERROR: " + message.title)
                 .textContent(message.text)
                 .ariaLabel('Warning Dialog' + message.title + ", " + message.text)
                 .ok('OK')
         );
     }
    }
    $scope.showInputDialog = function(referenceID, title, textContent, label, initialValueText, okText, cancelText) {
        var confirm = $mdDialog.prompt()
          .title(title)
          .textContent(textContent)
          .placeholder(label)
          .ariaLabel(label)
          .initialValue(initialValueText)
          .ok(okText)
          .cancel(cancelText);

        $mdDialog.show(confirm).then(function(result) {
            var request = overview$createRequest("onInputDialogResult");
            request.parameters["referenceID"] = referenceID;
            if (typeof result != "undefined"){
                request.parameters["result"] = result;
                overview$executeRequest(request);
            } else {
                request.parameters["result"] = "";
                overview$executeRequest(request);
            }
        }, function() {
            var request = overview$createRequest("onInputDialogResult");
            request.parameters["referenceID"] = referenceID;
            overview$executeRequest(request);
        });
    };

    $scope.showConfirm = function(referenceID, title, textContent, okText, cancelText) {
        var confirm = $mdDialog.confirm()
              .title(title)
              .textContent(textContent)
              .ariaLabel(title)
              .ok(okText)
              .cancel(cancelText);

        $mdDialog.show(confirm).then(function() {
            var request = overview$createRequest("onConfirmDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["result"] = true;
            overview$executeRequest(request);
        }, function() {
            var request = overview$createRequest("onConfirmDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["result"] = false;
            overview$executeRequest(request);
        });
    };


    $scope.overview_widgetButtonStartWebServerButtonClicked = function () {
        var request = overview$createRequest("widgetButtonStartWebServerButtonClicked");
        overview$executeRequest(request);
    }

    $scope.overview_widgetButtonAboutButtonClicked = function () {
        var request = overview$createRequest("widgetButtonAboutButtonClicked");
        request.parameters["parameter"] = overview$getParameter_dto();
        overview$executeRequest(request);
    }

    $scope.overview_tableNotesTableRowClicked = function (index, event) {
        if (!event.defaultPrevented) {
            var request = overview$createRequest("onNotesTableRowClicked");
            request.parameters["parameter"] = overview$getParameter_dto();
            request.parameters["rowID"] = $scope.items.items[index].id;
            overview$executeRequest(request);
        }
    }
    if (!singlePageApp){
        var queryDict = {}
        location.search.substr(1).split("&").forEach(function(item) {queryDict[item.split("=")[0]] = item.split("=")[1]})
    overview$parameterDTO = overview$fromURLParameter(queryDict["parameterDTO"]);
        if (typeof overview$parameterDTO == "undefined"){
            overview$parameterDTO = null;
        } else if (overview$parameterDTO != null){
        }
        $scope.parameter = overview$parameterDTO;
    }

    setTimeout(function() {if (("WebBrowser" == browserMode) && (!singlePageApp)){overview$executeOnLoadRequest();}}, 0);
    setTimeout(function() {
        if (typeof previewWindow != "undefined") {
            previewWindow.initForPreview();
        } else {
        }
        
        }, 0);

    $scope.imageAssetIDToName = overview$createImageAssetIDToNameMap();
    overview$controllerReady = true;

});

var overview$setInitialValues = function(){
    var scope = angular.element(document.getElementById('screenOverviewPanel')).scope();
    scope.overview_info_propertyText = "Fonotes - Phone Notes";
    scope.overview_info_propertyVisible = true;
    scope.overview_startWebServerButton_propertyText = "Start Web Server";
    scope.overview_startWebServerButton_propertyVisible = false;
    scope.overview_aboutButton_propertyText = "About Fonotes";
    scope.overview_aboutButton_propertyVisible = true;
}

var overview$createImageAssetIDToNameMap = function(){
    result = new Object();
    return result;
}

var overview$logDebug = function(message){
//	if (overview$logDebugBuffer.length > 0){
//		console.log("buffered messages:\n" + overview$logDebugBuffer + "\n}");
//	}
//	overview$logDebugBuffer = overview$logDebugBuffer + message + "\n";
    console.log(message);
}

var overview$fromURLParameter = function(urlParameter){
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

overview$executeOnLoadRequest = function(){
    var request = overview$createRequest("onLoaded");
    request.parameters["_ClientProperties"] = getClientProperties();
    request.parameters["parameter"] = overview$getParameter_dto();
    overview$executeRequest(request);
}

/** called in JavaFX mode by web view when the screen object has been set. Wait until the Angular JS controller is ready and then call onLoad in the listener*/
overview$executeOnLoadWhenControllerIsReady = function(){
    overview$logDebug("executeOnLoadWhenControllerIsReady: overview$controllerReady = " + overview$controllerReady);
    if (overview$controllerReady){
        overview$logDebug("executeOnLoadWhenControllerIsReady: ready");
        overview$executeOnLoadRequest();
        overview$logDebug("executeOnLoadWhenControllerIsReady: called onLoaded");
    } else {
        overview$logDebug("executeOnLoadWhenControllerIsReady: waiting");
        setTimeout(overview$executeOnLoadWhenControllerIsReady(), 200);
    }
}
overview$createRequest = function(actionName){
    request = new Object();
    request.action = actionName;
    request.screenID = "overview";
    request.parameters = new Object();
    return request;
};

overview$executeRequest = function(request){
    //later: add server call and process request here...
    if (browserMode == 'JavaFX'){
        screenManager.onRequest(JSON.stringify(request), null, null);
    } else {
        var scope = angular.element(document.getElementById('screenOverviewPanel')).scope();
        scope.http.post("/request", request).then(function (response) {
            if ((response.data != null) && (typeof response.data != "undefined")){
                overview$processReply(JSON.stringify(response.data));
            }
        });
    }
};


overview$setInfo_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenOverviewPanel')).scope();
    scope.$apply(function(){
        scope.overview_info_propertyText = text;
    });
};
overview$getInfo_widgetText = function(){
    var scope = angular.element(document.getElementById('screenOverviewPanel')).scope();
    return scope.overview_info_propertyText;
};



overview$setItems_dto = function(jsonString){
    var paramObject = JSON.parse(jsonString);
    var scope = angular.element(document.getElementById('screenOverviewPanel')).scope();
    scope.$apply(function(){
        scope.items = paramObject;
    });
};
overview$getItems_dto = function(){
    var scope = angular.element(document.getElementById('screenOverviewPanel')).scope();
    var result = new Object();
    if (scope.items != null){
        result = JSON.parse(JSON.stringify(scope.items));
    }
    return JSON.stringify(result);
};
overview$setParameter_dto = function(jsonString){
    var paramObject = JSON.parse(jsonString);
    var scope = angular.element(document.getElementById('screenOverviewPanel')).scope();
    scope.$apply(function(){
        scope.parameter = paramObject;
    });
};
overview$getParameter_dto = function(){
    var scope = angular.element(document.getElementById('screenOverviewPanel')).scope();
    var result = new Object();
    if (scope.parameter != null){
        result = JSON.parse(JSON.stringify(scope.parameter));
    }
    return JSON.stringify(result);
};

overview$initDTOTypeDetailsParameterForPreview = function(index){
    var result = new Object();
    result.noteName = "myNote" + "(" + index + ")";
    result.password = "5678" + "(" + index + ")";
    return result;
};
overview$initDTOTypeEditStateForPreview = function(index){
    var result = new Object();
    result.text = "hello" + "(" + index + ")";
    result.inEditMode = true;
    return result;
};
overview$initDTOTypeIdAndLabelForPreview = function(index){
    var result = new Object();
    result.id = "1234" + "(" + index + ")";
    result.label = "1234" + "(" + index + ")";
    return result;
};
overview$initDTOTypeIdAndLabelListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = overview$initDTOTypeIdAndLabelForPreview(0);
    result.items[1] = overview$initDTOTypeIdAndLabelForPreview(1);
    result.items[2] = overview$initDTOTypeIdAndLabelForPreview(2);
    result.items[3] = overview$initDTOTypeIdAndLabelForPreview(3);
    result.items[4] = overview$initDTOTypeIdAndLabelForPreview(4);
    result.items[5] = overview$initDTOTypeIdAndLabelForPreview(5);
    result.items[6] = overview$initDTOTypeIdAndLabelForPreview(6);
    result.items[7] = overview$initDTOTypeIdAndLabelForPreview(7);
    result.items[8] = overview$initDTOTypeIdAndLabelForPreview(8);
    result.items[9] = overview$initDTOTypeIdAndLabelForPreview(9);
    return result;
};
overview$initDTOTypeOverviewItemForPreview = function(index){
    var result = new Object();
    result.id = "ID" + "(" + index + ")";
    result.label = "My Notes" + "(" + index + ")";
    result.color = "#ff0000" + "(" + index + ")";
    return result;
};
overview$initDTOTypeOverviewListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = overview$initDTOTypeOverviewItemForPreview(0);
    result.items[1] = overview$initDTOTypeOverviewItemForPreview(1);
    result.items[2] = overview$initDTOTypeOverviewItemForPreview(2);
    result.items[3] = overview$initDTOTypeOverviewItemForPreview(3);
    result.items[4] = overview$initDTOTypeOverviewItemForPreview(4);
    result.items[5] = overview$initDTOTypeOverviewItemForPreview(5);
    result.items[6] = overview$initDTOTypeOverviewItemForPreview(6);
    result.items[7] = overview$initDTOTypeOverviewItemForPreview(7);
    result.items[8] = overview$initDTOTypeOverviewItemForPreview(8);
    result.items[9] = overview$initDTOTypeOverviewItemForPreview(9);
    return result;
};
overview$initDTOTypeOverviewParameterForPreview = function(index){
    var result = new Object();
    result.password = "1234" + "(" + index + ")";
    return result;
};

overview$initForPreview = function(){
    console.log('overview:executing initForPreview in JS!');
    var scope = angular.element(document.getElementById('screenOverviewPanel')).scope();
    scope.items = overview$initDTOTypeOverviewListForPreview(0);
    scope.parameter = overview$initDTOTypeOverviewParameterForPreview(0);
    setTimeout(function() {scope.$digest();}, 0);
}


var overview$findItemWithID = function(scope, variableName, id){
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
var overview$openScreen = function(screenToOpen, openParameter){
    if (singlePageApp) {
        setTimeout(function() {openScreenSinglePageApp(screenToOpen, openParameter);}, 0);
    } else {
        overview$openScreenMultiPageApp(screenToOpen, openParameter);
    }
}
var overview$openScreenMultiPageApp = function(screenToOpen, openParameter){
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

overview$processReply = function(jsonString){
    var reply = JSON.parse(jsonString);
    var scope = angular.element(document.getElementById('screenOverviewPanel')).scope();
    for (i = 0, len = reply.dtosToSet.length; i < len; i++) {
        var dtoValue = reply.dtoValues[reply.dtosToSet[i]];
        scope[reply.dtosToSet[i]] = dtoValue;
        if (reply.dtosToSet[i] == 'items'){
        }
        if (reply.dtosToSet[i] == 'parameter'){
        }
    }
    for (i = 0, len = reply.dtosToSet.length; i < len; i++) {
        var dtoValue = reply.dtoValues[reply.dtosToSet[i]];
        if (reply.dtosToSet[i] == 'items'){
        }
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
        scope[key] = overview$findItemWithID(scope, key, reply.selectBoxSelectedIDs[key]);
    }

    for (key in reply.markdownViewTexts) {
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

    var screenToOpen = reply.screenToOpen;
    if (typeof screenToOpen != "undefined") {
        overview$openScreen(screenToOpen, reply.openParameter);
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
        scope.showInputDialog(inputDialogParameters.referenceID, inputDialogParameters.title, inputDialogParameters.textContent, inputDialogParameters.label, inputDialogParameters.initialValueText, inputDialogParameters.okText, inputDialogParameters.cancelText);
    }

    var confirmDialogParameters = reply.confirmDialogParameters;
    if (typeof confirmDialogParameters != "undefined") {
        scope.showConfirm(confirmDialogParameters.referenceID, confirmDialogParameters.title, confirmDialogParameters.textContent, confirmDialogParameters.okText, confirmDialogParameters.cancelText);
    }
    setTimeout(function() {scope.$digest();}, 0);

};
