$( document ).ready(function() {
    
    $("#group1-Next").click(function(){
    	$("#slides").animate({
    		left: "-=598px"
    	}, 1000, function() {
    		//animate success
    	});
    });
    
    $("#group1-Prev").click(function(){
    	$("#slides").animate({
    		left: "+=598px"
    	}, 1000, function() {
    		//animate success
    	});
    });
    
    $("#slides").ready(function() {
    	$.ajax({type: "GET", url: "http://localhost:8080/webstore/get/product/rating/8", async: false,
    		success: function(text) {
    			$("#slides").append(text);
    		}});
    });
});
