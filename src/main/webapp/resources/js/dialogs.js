var statusDlgTimer = null;

function showStatusDialog() {
	if (statusDlgTimer === null) {
		statusDlgTimer = setTimeout("statusDialog.show()", 700);
	}
}

function hideStatusDialog() {
	resetTimer();
	statusDialog.hide();
}

function showErrorDialog() {
	resetTimer();
	statusDialog.hide();
	errorDialog.show();
}

function hideErrorDialog() {
	errorDialog.hide();
}

function resetTimer(){
	if (statusDlgTimer !== null) {
		clearTimeout(statusDlgTimer);
		statusDlgTimer = null;
	}
}

function handleDialogHide(dialog, xhr, status, args) {
	if (!args.validationFailed) {
		dialog.hide();
	}
}

function handleDialogShow(dialog, xhr, status, args) {
	if (!args.validationFailed) {
		dialog.show();
	} else {
		$('.ui-dialog-content').animate({
			scrollTop : 0
		}, 'fast');
	}
}