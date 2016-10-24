/**
 * 
 */
var SELECTED_CLASS = "menuitem-selected";

function changeMenuStyle() {
	links = document.getElementById("panelMenu").getElementsByTagName("a");
	for (var i = 0; i < links.length; i++) {
		if (links[i].href.replace("#", "") == window.location) {
			links[i].className += " " + SELECTED_CLASS;
		}
	}
}

$(window).scroll(function() {
	valor_atual = $(document).scrollTop();
	var buttonDiv = $(".listButtonPanel");
	var preButtonDiv = $('.preListButtonPanel');
	if (valor_atual >= 100) {
		preButtonDiv.css("height", buttonDiv.css("height"));
		buttonDiv.addClass("fixedPanel");
	} else {
		buttonDiv.removeClass("fixedPanel");
		preButtonDiv.css("height", "0");
	}
});