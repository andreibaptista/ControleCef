/**
 * 
 */
function addUploadListener() {
	document.getElementById("fromFileUp:uploadBtn").onchange = function() {
		document.getElementById("fromFileUp:uploadFile").value = this.value;
	};
}