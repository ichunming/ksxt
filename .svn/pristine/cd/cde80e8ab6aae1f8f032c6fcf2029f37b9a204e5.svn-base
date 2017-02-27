var isAndroid = (navigator.userAgent.indexOf('Android') > 0);

var callAppApi = function(parameters) {
	var iframe = document.createElement('iframe');
	iframe.setAttribute('src', "app-api://"+parameters);
	document.documentElement.appendChild(iframe);
	iframe.parentNode.removeChild(iframe);
	iframe = null;
}

function clearScanResult() {
	if (isAndroid) {
		NativeObject.funClearScanResult();
	} else {
		callAppApi("appApiClearScanResult(0)");
	}
}

function openScanView() {
	if (isAndroid) {
		NativeObject.funOpenScanActivity(1);
	} else {
		callAppApi("appApiOpenScanView(1)");
	}
}

function openScanView4Depot() {
	if (isAndroid) {
		NativeObject.funOpenScanActivity(2);
	} else {
		callAppApi("appApiOpenScanView(2)");
	}
}
