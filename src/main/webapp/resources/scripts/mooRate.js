/*
---
description: mooRate rating widget

license: Free for all.

authors:
- Olivier Refalo

requires:
- core/1.2.4:'*'

provides: [MooRate]
...
*/
var MooRate = new Class({

	Implements : Options,

	options : {
		scale : 5, /* It's a five-star scale. */
		snap : 1, /*
					 * Will snap to the nearest star (can be made a decimal,
					 * too).
					 */
		maxwidth : 150,
/*
 * max rate width in pixels, should be enought to hold the scale. Works with the
 * CSS
 */
		inpercent: true,
		isFractional: true
	},

	initialize : function(selector, options ) {

		this.setOptions(options);

		selector.each(function(el) {
			el.revert = true;
			this.setDefaultRate(el, 0);
			el.addEvents({
						'mouseenter' : function() {
						},
						'mousemove' : function(event) {
							
							var w = event.client.x - el.getPosition().x;
							var span = el.getChildren()[0];
							span.setStyles({'width' : w	});
							
							if (!span.hasClass('clicked')) {
								span.removeClass('curr');
								span.addClass('default');
							}
							
							var x = (w / this.options.maxwidth) * this.options.scale;
							
							if (this.options.inpercent) {
								var v = Math.round(w / this.options.maxwidth * 100);
								if (v < 101)
									el.getNext().innerHTML = v + '%';
							} else {
								if (this.options.isFractional) {
									if (x <= 5 || x >= 0)
										el.getNext().innerHTML = this.formatNumber(x, 2);
								} else {
									el.getNext().innerHTML = Math.round(x);
								}
							}
						}.bind(this),
						'click' : function() {
							var span = el.getChildren()[0];
							var value = el.getNext().innerHTML;
							span.title = parseFloat(value);
							span.addClass('curr');
							if (!span.hasClass('clicked')) {
								span.addClass('clicked');
							}
							el.revert = false;
							el.fireEvent('rated', [el, value]);
						},
						'mouseleave' : function() {
							if (el.revert) {
								var span = el.getChildren()[0];

								var v = parseInt(span.title);

								var w;
								if (this.options.inpercent) {
									w = (v / 100) * this.options.maxwidth;
									el.getNext().innerHTML = v + '%';
								} else {
									w = v * (this.options.maxwidth / this.options.scale);
									el.getNext().innerHTML = v;
								}
								span.setStyles({ 'width' : w });

								if (!span.hasClass('clicked')) {
									span.removeClass('default');
									span.addClass('curr');
								}
							}
							el.revert = true;
						}.bind(this)
					});
		}.bind(this));

	},

	formatNumber : function(myNum, numOfDec) {
		var decimal = 1
		for (i = 1; i <= numOfDec; i++)
			decimal = decimal * 10
		var myFormattedNum = (Math.round(myNum * decimal) / decimal)
				.toFixed(numOfDec)
		return myFormattedNum;
	},

	/* Set the default Rate, it shows in RED!	 */
	setDefaultRate: function(el, value )
	{
		var span = el.getChildren()[0];
		span.set('class','curr');
		
		span.title = value;
		var v = parseInt(span.title);

		var w;
		if (this.options.inpercent) {
			w = (v / 100) * this.options.maxwidth;
			el.getNext().innerHTML = v + '%';
		} else {
			w = v * (this.options.maxwidth / this.options.scale);
			el.getNext().innerHTML = v;
		}
		span.setStyles({ 'width' : w });
	},
	
	/* returns the current rate. Note that if the user did rate yet the method returns the default rate */
	getRate: function(el) {
		var span = el.getChildren()[0];
		return parseInt(span.title);
	}
	
});
