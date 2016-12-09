
var login$controllerReady = false;
var login$logDebugBuffer = "";
var login$parameterDTO;

app.controller("login_Ctrl", function($scope, $mdToast, $mdDialog, $http) {
    login$setInitialValues();
    $scope.http = $http;

    $scope.showMessage = function (message) {
     if (message.typeID == 201){
             $mdToast.show($mdToast.simple().textContent(message.text).hideDelay(3000));
     } else if (message.typeID == 101) {
         $mdDialog.show(
                   $mdDialog.alert()
                     .parent(angular.element(document.querySelector('screenLoginPanel')))
                     .clickOutsideToClose(true)
                     .title(message.title)
                     .textContent(message.text)
                     .ariaLabel('Info Dialog' + message.title + ", " + message.text)
                     .ok('OK')
                 );
     } else if (message.typeID == 102) {
         $mdDialog.show(
                 $mdDialog.alert()
                 .parent(angular.element(document.querySelector('screenLoginPanel')))
                 .clickOutsideToClose(true)
                 .title("WARNING: " + message.title)
                 .textContent(message.text)
                 .ariaLabel('Warning Dialog' + message.title + ", " + message.text)
                 .ok('OK')
         );
     } else if (message.typeID == 103) {
         $mdDialog.show(
                 $mdDialog.alert()
                 .parent(angular.element(document.querySelector('screenLoginPanel')))
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
            var request = login$createRequest("onInputDialogResult");
            request.parameters["referenceID"] = referenceID;
            if (typeof result != "undefined"){
                request.parameters["result"] = result;
                login$executeRequest(request);
            } else {
                request.parameters["result"] = "";
                login$executeRequest(request);
            }
        }, function() {
            var request = login$createRequest("onInputDialogResult");
            request.parameters["referenceID"] = referenceID;
            login$executeRequest(request);
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
            var request = login$createRequest("onConfirmDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["result"] = true;
            login$executeRequest(request);
        }, function() {
            var request = login$createRequest("onConfirmDialogResult");
            request.parameters["referenceID"] = referenceID;
            request.parameters["result"] = false;
            login$executeRequest(request);
        });
    };


    $scope.login_widgetButtonLoginButtonClicked = function () {
        var request = login$createRequest("widgetButtonLoginButtonClicked");
        request.parameters["passwordTextFieldText"] = $scope.login_passwordTextField_propertyText;
        login$executeRequest(request);
    }

    setTimeout(function() {if (("WebBrowser" == browserMode) && (!singlePageApp)){login$executeOnLoadRequest();}}, 0);
    setTimeout(function() {
        if (typeof previewWindow != "undefined") {
            previewWindow.initForPreview();
        } else {
        }
        
        }, 0);

    $scope.imageAssetIDToName = login$createImageAssetIDToNameMap();
    login$controllerReady = true;

});

var login$setInitialValues = function(){
    var scope = angular.element(document.getElementById('screenLoginPanel')).scope();
    scope.login_info_propertyText = "Fonotes - Phone Notes";
    scope.login_info_propertyVisible = true;
    scope.login_passwordTextField_propertyText = "";
    scope.login_passwordTextField_propertyLabel = "Password";
    scope.login_passwordTextField_propertyBackgroundColor = "#ffffff";
    scope.login_passwordTextField_propertyVisible = true;
    scope.login_loginButton_propertyText = "Login";
    scope.login_loginButton_propertyVisible = true;
}

var login$createImageAssetIDToNameMap = function(){
    result = new Object();
    return result;
}

var login$logDebug = function(message){
//	if (login$logDebugBuffer.length > 0){
//		console.log("buffered messages:\n" + login$logDebugBuffer + "\n}");
//	}
//	login$logDebugBuffer = login$logDebugBuffer + message + "\n";
    console.log(message);
}

var login$fromURLParameter = function(urlParameter){
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

login$executeOnLoadRequest = function(){
    var request = login$createRequest("onLoaded");
    request.parameters["_ClientProperties"] = getClientProperties();
    login$executeRequest(request);
}

/** called in JavaFX mode by web view when the screen object has been set. Wait until the Angular JS controller is ready and then call onLoad in the listener*/
login$executeOnLoadWhenControllerIsReady = function(){
    login$logDebug("executeOnLoadWhenControllerIsReady: login$controllerReady = " + login$controllerReady);
    if (login$controllerReady){
        login$logDebug("executeOnLoadWhenControllerIsReady: ready");
        login$executeOnLoadRequest();
        login$logDebug("executeOnLoadWhenControllerIsReady: called onLoaded");
    } else {
        login$logDebug("executeOnLoadWhenControllerIsReady: waiting");
        setTimeout(login$executeOnLoadWhenControllerIsReady(), 200);
    }
}
login$createRequest = function(actionName){
    request = new Object();
    request.action = actionName;
    request.screenID = "login";
    request.parameters = new Object();
    return request;
};

login$executeRequest = function(request){
    //later: add server call and process request here...
    if (browserMode == 'JavaFX'){
        screenManager.onRequest(JSON.stringify(request), null, null);
    } else {
        var scope = angular.element(document.getElementById('screenLoginPanel')).scope();
        scope.http.post("/request", request).then(function (response) {
            if ((response.data != null) && (typeof response.data != "undefined")){
                login$processReply(JSON.stringify(response.data));
            }
        });
    }
};


login$setInfo_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenLoginPanel')).scope();
    scope.$apply(function(){
        scope.login_info_propertyText = text;
    });
};
login$getInfo_widgetText = function(){
    var scope = angular.element(document.getElementById('screenLoginPanel')).scope();
    return scope.login_info_propertyText;
};


login$setPasswordTextField_widgetText = function(text){
    var scope = angular.element(document.getElementById('screenLoginPanel')).scope();
    scope.$apply(function(){
        scope.login_passwordTextField_propertyText = text;
    });
};
login$getPasswordTextField_widgetText = function(){
    var scope = angular.element(document.getElementById('screenLoginPanel')).scope();
    return scope.login_passwordTextField_propertyText;
};



login$initDTOTypeDetailsParameterForPreview = function(index){
    var result = new Object();
    result.noteName = "myNote" + "(" + index + ")";
    result.password = "5678" + "(" + index + ")";
    return result;
};
login$initDTOTypeEditStateForPreview = function(index){
    var result = new Object();
    result.text = "hello" + "(" + index + ")";
    result.inEditMode = true;
    return result;
};
login$initDTOTypeIdAndLabelForPreview = function(index){
    var result = new Object();
    result.id = "1234" + "(" + index + ")";
    result.label = "1234" + "(" + index + ")";
    return result;
};
login$initDTOTypeIdAndLabelListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = login$initDTOTypeIdAndLabelForPreview(0);
    result.items[1] = login$initDTOTypeIdAndLabelForPreview(1);
    result.items[2] = login$initDTOTypeIdAndLabelForPreview(2);
    result.items[3] = login$initDTOTypeIdAndLabelForPreview(3);
    result.items[4] = login$initDTOTypeIdAndLabelForPreview(4);
    result.items[5] = login$initDTOTypeIdAndLabelForPreview(5);
    result.items[6] = login$initDTOTypeIdAndLabelForPreview(6);
    result.items[7] = login$initDTOTypeIdAndLabelForPreview(7);
    result.items[8] = login$initDTOTypeIdAndLabelForPreview(8);
    result.items[9] = login$initDTOTypeIdAndLabelForPreview(9);
    return result;
};
login$initDTOTypeOverviewItemForPreview = function(index){
    var result = new Object();
    result.id = "ID" + "(" + index + ")";
    result.label = "My Notes" + "(" + index + ")";
    result.color = "#ff0000" + "(" + index + ")";
    return result;
};
login$initDTOTypeOverviewListForPreview = function(index){
    var result = new Object();
    result.items = [];
    result.items[0] = login$initDTOTypeOverviewItemForPreview(0);
    result.items[1] = login$initDTOTypeOverviewItemForPreview(1);
    result.items[2] = login$initDTOTypeOverviewItemForPreview(2);
    result.items[3] = login$initDTOTypeOverviewItemForPreview(3);
    result.items[4] = login$initDTOTypeOverviewItemForPreview(4);
    result.items[5] = login$initDTOTypeOverviewItemForPreview(5);
    result.items[6] = login$initDTOTypeOverviewItemForPreview(6);
    result.items[7] = login$initDTOTypeOverviewItemForPreview(7);
    result.items[8] = login$initDTOTypeOverviewItemForPreview(8);
    result.items[9] = login$initDTOTypeOverviewItemForPreview(9);
    return result;
};
login$initDTOTypeOverviewParameterForPreview = function(index){
    var result = new Object();
    result.password = "1234" + "(" + index + ")";
    return result;
};

login$initForPreview = function(){
    console.log('login:executing initForPreview in JS!');
    var scope = angular.element(document.getElementById('screenLoginPanel')).scope();
    setTimeout(function() {scope.$digest();}, 0);
}


var login$findItemWithID = function(scope, variableName, id){
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
var login$openScreen = function(screenToOpen, openParameter){
    if (singlePageApp) {
        setTimeout(function() {openScreenSinglePageApp(screenToOpen, openParameter);}, 0);
    } else {
        login$openScreenMultiPageApp(screenToOpen, openParameter);
    }
}
var login$openScreenMultiPageApp = function(screenToOpen, openParameter){
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

login$processReply = function(jsonString){
    var reply = JSON.parse(jsonString);
    var scope = angular.element(document.getElementById('screenLoginPanel')).scope();
    for (i = 0, len = reply.dtosToSet.length; i < len; i++) {
        var dtoValue = reply.dtoValues[reply.dtosToSet[i]];
        scope[reply.dtosToSet[i]] = dtoValue;
    }
    for (i = 0, len = reply.dtosToSet.length; i < len; i++) {
        var dtoValue = reply.dtoValues[reply.dtosToSet[i]];
    }
    for (i = 0, len = reply.objectsToSetValue.length; i < len; i++) {
        var valueToSet = reply.objectSetValueValues[reply.objectsToSetValue[i]];
        this[reply.objectsToSetValue[i]].setValue(valueToSet);
    }
    for (i = 0, len = reply.variablesToSet.length; i < len; i++) { 
        scope[reply.variablesToSet[i]] = reply.variableValues[reply.variablesToSet[i]];
    }
    for (key in reply.selectBoxSelectedIDs) {
        scope[key] = login$findItemWithID(scope, key, reply.selectBoxSelectedIDs[key]);
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
        login$openScreen(screenToOpen, reply.openParameter);
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