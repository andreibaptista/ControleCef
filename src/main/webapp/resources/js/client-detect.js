function detectNav() {
	var fail = true;
	if (/Firefox[\/\s](\d+\.\d+)/.test(navigator.userAgent)) {
		var ffversion = new Number(RegExp.$1);
		if (ffversion >= 5) {
			fail = false;
		}
	} else if (ieVersion() >= 9) {
		fail = false;
	} else if (/Chrome[\/\s](\d+\.\d+)/.test(navigator.userAgent)
			&& !/OPR[\/\s](\d+\.\d+)/.test(navigator.userAgent)) {
		var crmversion = new Number(RegExp.$1);
		if (crmversion >= 20) {
			fail = false;
		}
	}
	if (fail) {
		alert(getNavWarnMessage());
	}
	sessionStorage.showAlert = true;
}

function shouldShowAlert() {
	if (typeof (Storage) !== "undefined") {
		return !sessionStorage.showAlert;
	} else {
		return true;
	}
}

function getNavWarnMessage() {
	return "O ControleCef foi desenvolvido para funcionar perfeitamente nos navegadore Internet Explorer 9.0 ou superior, Mozilla Firefox e Google Chrome, portanto a aplicação pode não funcionar corretamente.";
}

function ieVersion() {
	var iev = 0;
	var ieold = (/MSIE (\d+\.\d+);/.test(navigator.userAgent));
	var trident = !!navigator.userAgent.match(/Trident\/7.0/);
	var rv = navigator.userAgent.indexOf("rv:11.0");

	if (ieold)
		iev = new Number(RegExp.$1);
	if (navigator.appVersion.indexOf("MSIE 10") != -1)
		iev = 10;
	if (trident && rv != -1)
		iev = 11;

	return iev;
}