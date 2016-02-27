jQuery.fn.center = function(params) {
	var options = {
		vertical: true,
		horizontal: true
	};
	op = jQuery.extend(options, params);

	return this.each(function(){
		var cssProp = {position: 'absolute'};

		if(op.vertical) {
			cssProp.top = Math.round(window.screen.availHeight/2) + $(document).scrollTop() - Math.round($(this).height()/2) + 'px';
		}
		if(op.horizontal) {
			cssProp.left = Math.round(window.screen.availWidth/2) + $(document).scrollLeft() - Math.round($(this).width()/2) + 'px';
		}
		$(this).css(cssProp);
   });
};