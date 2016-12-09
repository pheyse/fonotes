
var details$controllerReady = false;
var details$logDebugBuffer = "";
var details$parameterDTO;

app.controller("details_Ctrl", function($scope, $mdToast, $mdDialog, $http) {
    details$setInitialValues();
    $scope.http = $http;

    $scope.showMessage = function (message) {
     if (message.typeID == 201){
             $mdToast.show($mdToast.simple().textContent(message.text).hideDelay(3000));
     } else if (message.typeID == 101) {
         $mdDialog.show(
                   $mdDialog.alert()
                     .parent(angular.element(document.querySelector('screenDetailsPanel')))
                     .clickOutsideToClose(true)
                     .title(message.title)
                     .textContent(message.text)
                     .ariaLabel('Info Dialog' + message.title + ", " + message.text)
                     .ok('OK')
                 );
     } else if (message.typeID == 102) {
         $mdDialog.show(
                 $mdDialog.alert()
                 .parent(angular.element(document.querySelector('screenDetailsPanel')))
                 .clickOutsideToClose(true)
                 .title("WARNING: " + message.title)
                 .textContent(message.text)
                 .ariaLabel('Warning Dialog' + message.title + ", " + message.text)
                 .ok('OK')
         );
     } else if (message.typeID == 103) {
         $mdDialog.show(
                 $mdDialog.alert()
                 .parent(angular.element(document.querySelector('screenDetailsPanel')))
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
            var request = details$createRequest("onInputDialogResult");
            request.parameters["referenceID"] = referenceID;
            if (typeof result != "undefined"){
                request.parameters["result"] = result;
                details$executeRequest(request);
            } else {
                request.parameters["result"] = "";
                details$executeRequest(request);
            }
        }, function() {
            var request = details$createRequest("onInputDialogResult");
            request.parameters["referenceID"] = referenceID;
            details$executeRequest(request);
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
            var request = details$createRequest("onConfirmDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["result"] = true;
            details$executeRequest(request);
        }, function() {
            var request = details$createRequest("onConfirmDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["result"] = false;
            details$executeRequest(request);
        });
    };


    $scope.details_widgetButtonBackButtonClicked = function () {
        var request = details$createRequest("widgetButtonBackButtonClicked");
        request.parameters["parameter"] = details$getParameter_dto();
        details$executeRequest(request);
    }

    $scope.details_widgetButtonEditNameButtonClicked = function () {
        var request = details$createRequest("widgetButtonEditNameButtonClicked");
        request.parameters["parameter"] = details$getParameter_dto();
        details$executeRequest(request);
    }

    $scope.details_widgetButtonEditTextButtonClicked = function () {
        var request = details$createRequest("widgetButtonEditTextButtonClicked");
        request.parameters["parameter"] = details$getParameter_dto();
        details$executeRequest(request);
    }

    $scope.details_widgetButtonDeleteButtonClicked = function () {
        var request = details$createRequest("widgetButtonDeleteButtonClicked");
        request.parameters["parameter"] = details$getParameter_dto();
        details$executeRequest(request);
    }

    $scope.details_widgetButtonSaveNoteTextButtonClicked = function () {
        var request = details$createRequest("widgetButtonSaveNoteTextButtonClicked");
        request.parameters["parameter"] = details$getParameter_dto();
        request.parameters["editNoteTextAreaText"] = $scope.details_editNoteTextArea_propertyText;
        details$executeRequest(request);
    }

    $scope.details_widgetButtonCancelEditNoteTextButtonClicked = function () {
        var request = details$createRequest("widgetButtonCancelEditNoteTextButtonClicked");
        request.parameters["parameter"] = details$getParameter_dto();
        details$executeRequest(request);
    }

    if (!singlePageApp){
        var queryDict = {}
        location.search.substr(1).split("&").forEach(function(item) {queryDict[item.split("=")[0]] = item.split("=")[1]})
    details$parameterDTO = details$fromURLParameter(queryDict["parameterDTO"]);
        if (typeof details$parameterDTO == "undefined"){
            details$parameterDTO = null;
        } else if (details$parameterDTO != null){
        }
        $scope.parameter = details$parameterDTO;
    }

    details_setColorSelectBoxSelectedID = function(selectedID){
        var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
        scope.details_colorSelectBox_selectedItem = details$findItemWithID(scope, "details_colorSelectBox_selectedItem", selectedID);
    }

    details_getColorSelectBoxSelectedID = function(){
        var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
        return (typeof scope.details_colorSelectBox_selectedItem == "undefined") ? null : scope.details_colorSelectBox_selectedItem.id;
    }

    $scope.details_colorSelectBox_changed = function (id){
        var request = details$createRequest("onColorSelectBoxChanged");
        request.parameters["rowID"] = id;
        request.parameters["parameter"] = details$getParameter_dto();
        details$executeRequest(request);
    }
    setTimeout(function() {if (("WebBrowser" == browserMode) && (!singlePageApp)){details$executeOnLoadRequest();}}, 0);
    setTimeout(function() {
        if (typeof previewWindow != "undefined") {
            previewWindow.initForPreview();
        } else {
        }
        
        }, 0);

    $scope.imageAssetIDToName = details$createImageAssetIDToNameMap();
    details$timerAutosaveTimer();
    details$controllerReady = true;

});

var details$setInitialValues = function(){
    var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
    scope.details_backButton_propertyText = "Back to overview";
    scope.details_backButton_propertyVisible = true;
    scope.details_noteNameLabel_propertyText = "My Note 123";
    scope.details_noteNameLabel_propertyVisible = true;
    scope.details_colorLabel_propertyText = "Note Color:";
    scope.details_colorLabel_propertyVisible = true;
    scope.details_editNameButton_propertyText = "Edit name";
    scope.details_editNameButton_propertyVisible = true;
    scope.details_editTextButton_propertyText = "Edit text";
    scope.details_editTextButton_propertyVisible = true;
    scope.details_deleteButton_propertyText = "Delete note";
    scope.details_deleteButton_propertyVisible = true;
    scope.details_null_propertyVisible = true;
    scope.details_noteView_propertyText = "My note text";
    scope.details_noteView_propertyBackgroundColor = "#ffffff";
    scope.details_noteView_propertyVisible = true;
    scope.details_saveNoteTextButton_propertyText = "Save";
    scope.details_saveNoteTextButton_propertyVisible = true;
    scope.details_cancelEditNoteTextButton_propertyText = "Cancel";
    scope.details_cancelEditNoteTextButton_propertyVisible = true;
    scope.details_editNoteTextArea_propertyText = "my note text";
    scope.details_editNoteTextArea_propertyBackgroundColor = "#ffffff";
    scope.details_editNoteTextArea_propertyVisible = true;
    scope.details_editNoteInfoLabel_propertyText = "";
    scope.details_editNoteInfoLabel_propertyVisible = true;
    scope.details_autosaveTimer_active = false;
    scope.details_colorBar_propertyVisible = true;
    scope.details_buttonBar_propertyVisible = true;
    scope.details_viewNoteName_propertyVisible = true;
    scope.details_viewNotePanel_propertyVisible = true;
    scope.details_editNotePanel_propertyVisible = false;
}

var details$createImageAssetIDToNameMap = function(){
    result = new Object();
    return result;
}

var details$logDebug = function(message){
//	if (details$logDebugBuffer.length > 0){
//		console.log("buffered messages:\n" + details$logDebugBuffer + "\n}");
//	}
//	details$logDebugBuffer = details$logDebugBuffer + message + "\n";
    console.log(message);
}

var details$fromURLParameter = function(urlParameter){
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

details$executeOnLoadRequest = function(){
    var request = details$createRequest("onLoaded");
    request.parameters["_ClientProperties"] = getClientProperties();
    request.parameters["parameter"] = details$getParameter_dto();
    details$executeRequest(request);
}

/** called in JavaFX mode by web view when the screen object has been set. Wait until the Angular JS controller is ready and then call onLoad in the listener*/
details$executeOnLoadWhenControllerIsReady = function(){
    details$logDebug("executeOnLoadWhenControllerIsReady: details$controllerReady = " + details$controllerReady);
    if (details$controllerReady){
        details$logDebug("executeOnLoadWhenControllerIsReady: ready");
        details$executeOnLoadRequest();
        details$logDebug("executeOnLoadWhenControllerIsReady: called onLoaded");
    } else {
        details$logDebug("executeOnLoadWhenControllerIsReady: waiting");
        setTimeout(details$executeOnLoadWhenControllerIsReady(), 200);
    }
}
details$createRequest = function(actionName){
    request = new Object();
    request.action = actionName;
    request.screenID = "details";
    request.parameters = new Object();
    return request;
};

details$executeRequest = function(request){
    //later: add server call and process request here...
    if (browserMode == 'JavaFX'){
        screenManager.onRequest(JSON.stringify(request), null, null);
    } else {
        var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
        scope.http.post("/request", request).then(function (response) {
            if ((response.data != null) && (typeof response.data != "undefined")){
                details$processReply(JSON.stringify(response.data));
            }
        });
    }
};


details$setNoteNameLabel_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
    scope.$apply(function(){
        scope.details_noteNameLabel_propertyText = text;
    });
};
details$getNoteNameLabel_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
    return scope.details_noteNameLabel_propertyText;
};


details$setColorLabel_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
    scope.$apply(function(){
        scope.details_colorLabel_propertyText = text;
    });
};
details$getColorLabel_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
    return scope.details_colorLabel_propertyText;
};


details$setEditNoteTextArea_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
    scope.$apply(function(){
        scope.details_editNoteTextArea_propertyText = text;
    });
};
details$getEditNoteTextArea_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
    return scope.details_editNoteTextArea_propertyText;
};


details$setEditNoteInfoLabel_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
    scope.$apply(function(){
        scope.details_editNoteInfoLabel_propertyText = text;
    });
};
details$getEditNoteInfoLabel_widgetText = function(){
    var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
    return scope.details_editNoteInfoLabel_propertyText;
};



details_setNoteViewText = function (text){
    var converter = new showdown.Converter();
    converter.setOption('tables', 'true');
    converter.setOption('literalMidWordUnderscores', 'true');
    html = converter.makeHtml(text);
    target = document.getElementById("details_markdownViewNoteView");
    target.innerHTML = html;
};

details$setColors_dto = function(jsonString){
    var paramObject = JSON.parse(jsonString);
    var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
    scope.$apply(function(){
        scope.colors = paramObject;
    });
};
details$getColors_dto = function(){
    var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
    var result = new Object();
    if (scope.colors != null){
        result = JSON.parse(JSON.stringify(scope.colors));
    }
    return JSON.stringify(result);
};
details$setEditState_dto = function(jsonString){
    var paramObject = JSON.parse(jsonString);
    var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
    scope.$apply(function(){
        scope.editState = paramObject;
    });
};
details$getEditState_dto = function(){
    var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
    var result = new Object();
    if (scope.editState != null){
        result = JSON.parse(JSON.stringify(scope.editState));
    }
    return JSON.stringify(result);
};
details$setParameter_dto = function(jsonString){
    var paramObject = JSON.parse(jsonString);
    var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
    scope.$apply(function(){
        scope.parameter = paramObject;
    });
};
details$getParameter_dto = function(){
    var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
    var result = new Object();
    if (scope.parameter != null){
        result = JSON.parse(JSON.stringify(scope.parameter));
    }
    return JSON.stringify(result);
};

details$initDTOTypeDetailsParameterForPreview = function(index){
    var result = new Object();
    result.noteName = "myNote" + "(" + index + ")";
    result.password = "5678" + "(" + index + ")";
    return result;
};
details$initDTOTypeEditStateForPreview = function(index){
    var result = new Object();
    result.text = "hello" + "(" + index + ")";
    result.inEditMode = true;
    return result;
};
details$initDTOTypeIdAndLabelForPreview = function(index){
    var result = new Object();
    result.id = "1234" + "(" + index + ")";
    result.label = "1234" + "(" + index + ")";
    return result;
};
details$initDTOTypeIdAndLabelListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = details$initDTOTypeIdAndLabelForPreview(0);
    result.items[1] = details$initDTOTypeIdAndLabelForPreview(1);
    result.items[2] = details$initDTOTypeIdAndLabelForPreview(2);
    result.items[3] = details$initDTOTypeIdAndLabelForPreview(3);
    result.items[4] = details$initDTOTypeIdAndLabelForPreview(4);
    result.items[5] = details$initDTOTypeIdAndLabelForPreview(5);
    result.items[6] = details$initDTOTypeIdAndLabelForPreview(6);
    result.items[7] = details$initDTOTypeIdAndLabelForPreview(7);
    result.items[8] = details$initDTOTypeIdAndLabelForPreview(8);
    result.items[9] = details$initDTOTypeIdAndLabelForPreview(9);
    return result;
};
details$initDTOTypeOverviewItemForPreview = function(index){
    var result = new Object();
    result.id = "ID" + "(" + index + ")";
    result.label = "My Notes" + "(" + index + ")";
    result.color = "#ff0000" + "(" + index + ")";
    return result;
};
details$initDTOTypeOverviewListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = details$initDTOTypeOverviewItemForPreview(0);
    result.items[1] = details$initDTOTypeOverviewItemForPreview(1);
    result.items[2] = details$initDTOTypeOverviewItemForPreview(2);
    result.items[3] = details$initDTOTypeOverviewItemForPreview(3);
    result.items[4] = details$initDTOTypeOverviewItemForPreview(4);
    result.items[5] = details$initDTOTypeOverviewItemForPreview(5);
    result.items[6] = details$initDTOTypeOverviewItemForPreview(6);
    result.items[7] = details$initDTOTypeOverviewItemForPreview(7);
    result.items[8] = details$initDTOTypeOverviewItemForPreview(8);
    result.items[9] = details$initDTOTypeOverviewItemForPreview(9);
    return result;
};
details$initDTOTypeOverviewParameterForPreview = function(index){
    var result = new Object();
    result.password = "1234" + "(" + index + ")";
    return result;
};

details$initForPreview = function(){
    console.log('details:executing initForPreview in JS!');
    var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
    scope.colors = details$initDTOTypeIdAndLabelListForPreview(0);
    scope.editState = details$initDTOTypeEditStateForPreview(0);
    scope.parameter = details$initDTOTypeDetailsParameterForPreview(0);
    setTimeout(function() {scope.$digest();}, 0);
}


var details$timerAutosaveTimer = function(){
    setTimeout(function() {
        var $scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
        if ((!singlePageApp) || ($scope.visible)){
            if ($scope.details_autosaveTimer_active) {
                var request = details$createRequest("onAutosaveTimer");
                request.parameters["parameter"] = details$getParameter_dto();
                request.parameters["editNoteTextAreaText"] = $scope.details_editNoteTextArea_propertyText;
                request.parameters["editState"] = details$getEditState_dto();
               details$executeRequest(request);
            }
        }
        details$timerAutosaveTimer();
    }, 5000);
}
var details$findItemWithID = function(scope, variableName, id){
    var list = null;
    var fieldName = null;
    if (variableName == "details_colorSelectBox_selectedItem"){
        list = scope.colors.items;
        fieldName = "id";
    }
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
var details$openScreen = function(screenToOpen, openParameter){
    if (singlePageApp) {
        setTimeout(function() {openScreenSinglePageApp(screenToOpen, openParameter);}, 0);
    } else {
        details$openScreenMultiPageApp(screenToOpen, openParameter);
    }
}
var details$openScreenMultiPageApp = function(screenToOpen, openParameter){
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

details$processReply = function(jsonString){
    var reply = JSON.parse(jsonString);
    var scope = angular.element(document.getElementById('screenDetailsPanel')).scope();
    for (i = 0, len = reply.dtosToSet.length; i < len; i++) {
        var dtoValue = reply.dtoValues[reply.dtosToSet[i]];
        scope[reply.dtosToSet[i]] = dtoValue;
        if (reply.dtosToSet[i] == 'colors'){
        }
        if (reply.dtosToSet[i] == 'editState'){
        }
        if (reply.dtosToSet[i] == 'parameter'){
        }
    }
    for (i = 0, len = reply.dtosToSet.length; i < len; i++) {
        var dtoValue = reply.dtoValues[reply.dtosToSet[i]];
        if (reply.dtosToSet[i] == 'colors'){
        }
        if (reply.dtosToSet[i] == 'editState'){
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
        scope[key] = details$findItemWithID(scope, key, reply.selectBoxSelectedIDs[key]);
    }

    for (key in reply.markdownViewTexts) {
        if (key == "noteView"){
            details_setNoteViewText(reply.markdownViewTexts[key]);
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

    var screenToOpen = reply.screenToOpen;
    if (typeof screenToOpen != "undefined") {
        details$openScreen(screenToOpen, reply.openParameter);
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