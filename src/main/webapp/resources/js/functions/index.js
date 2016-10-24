$(function() {

	// ===== Hide/show sidebar =====//
	$('.fullview').click(function() {
		$("body").toggleClass("clean");
		$('#sidebar').toggleClass("hide-sidebar mobile-sidebar");
		$('#content').toggleClass("full-content");
		var showSidebar = localStorage.getItem("showSidebar");
		showSidebar = !$('#sidebar').hasClass('hide-sidebar');
		localStorage.setItem('showSidebar', showSidebar);
	});

	// ===== Hide/show sidebar on resize =====//
	$(window).resize(function() {
		showHideSidebar();
	});

	$(document).ready(function() {
		showHideSidebar();
	});

	// ===== Hide/show sidebar =====//
	function showHideSidebar() {
		var showSidebar = localStorage.getItem("showSidebar");
		if (showSidebar != null) {
			if (showSidebar == "true" && $('#sidebar').hasClass('hide-sidebar')) {
				$("body").toggleClass("clean");
				$('#sidebar').toggleClass("hide-sidebar mobile-sidebar");
				$('#content').toggleClass("full-content");
			} else if (showSidebar == "false"
					&& !$('#sidebar').hasClass('hide-sidebar')) {
				$("body").toggleClass("clean");
				$('#sidebar').toggleClass("hide-sidebar mobile-sidebar");
				$('#content').toggleClass("full-content");
			}
		} else {
			if ($(window).width() > 1024
					&& $('#sidebar').hasClass('hide-sidebar')) {
				$("body").toggleClass("clean");
				$('#sidebar').toggleClass("hide-sidebar mobile-sidebar");
				$('#content').toggleClass("full-content");
			} else if ($(window).width() <= 1024
					&& !$('#sidebar').hasClass('hide-sidebar')) {
				$("body").toggleClass("clean");
				$('#sidebar').toggleClass("hide-sidebar mobile-sidebar");
				$('#content').toggleClass("full-content");
			}
		}
	}

	// ===== Hide/show action tabs =====//
	$('.showmenu').click(function() {
		$('.actions-wrapper').slideToggle(100);
	});

	// ===== Make code pretty =====//

	window.prettyPrint && prettyPrint();

	// ===== Media item hover overlay =====//

	$('.view').hover(function() {
		$(this).children(".view-back").fadeIn(200);
	}, function() {
		$(this).children(".view-back").fadeOut(200);
	});

	// ===== Color picker =====//

	$('#cp1').colorpicker({
		format : 'hex'
	});
	$('#cp2').colorpicker();
	$('#cp3').colorpicker();
	var bodyStyle = $('html')[0].style;
	$('#cp4').colorpicker().on('changeColor', function(ev) {
		bodyStyle.background = ev.color.toHex();
	});

	// ===== Popover =====//

	$('.popover-test').popover({
		placement : 'left'
	}).click(function(e) {
		e.preventDefault()
	});

	$("a[rel=popover]").popover().click(function(e) {
		e.preventDefault()
	})

	// ===== Tags =====//

	$('.tags').tagsInput({
		width : '100%'
	});
	$('.tags-autocomplete').tagsInput({
		width : '100%',
		autocomplete_url : 'tags_autocomplete.html'
	});

	// ===== Tooltips =====//

	$('.tip').tooltip();
	$('.focustip').tooltip({
		'trigger' : 'focus'
	});

	// ===== Fancybox =====//

	$(".lightbox").fancybox({
		'padding' : 2
	});

	// ===== Easy tabs =====//

	$('.sidebar-tabs').easytabs({
		animationSpeed : 150,
		collapsible : false,
		tabActiveClass : "active"
	});

	$('.actions').easytabs({
		animationSpeed : 300,
		collapsible : false,
		tabActiveClass : "current"
	});

	// ===== Make Google maps visible inaide tabs =====//

	function initialize() {
		var mapProp = {
			center : new google.maps.LatLng(-37.814666, 144.982452),
			zoom : 12,
			mapTypeId : google.maps.MapTypeId.ROADMAP
		};
		var map = new google.maps.Map(document.getElementById("google-map"),
				mapProp);

		$('.actions').bind('easytabs:after', function() {
			google.maps.event.trigger(map, 'resize');
			map.setCenter(new google.maps.LatLng(-37.814666, 144.982452));
		});

	}
	;

	// ===== Collapsible plugin for main nav =====//

	$('.expand').collapsible({
		defaultOpen : 'current,third',
		cookieName : 'navAct',
		cssOpen : '',
		cssClose : 'subClosed',
		speed : 200
	});

	// ===== Form elements styling =====//

	$(".ui-datepicker-month, .styled, .dataTables_length select").uniform({
		radioClass : 'choice'
	});

});
