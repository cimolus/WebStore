<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <c:url value="/get/product/rating/8" var="requestForSlides"></c:url>
    	<script type="text/javascript" src="<c:url value="/resources/scripts/slider.js" ></c:url>"></script>
				<div class="slider boxShadow" >
					<div class="controlPanel boxShadow" id="leftPanel"><a class="group1-Prev" id="group1-Prev"></a></div>
					<div class="slide" id="slide"> 
						<div class="slides" id="slides" >
						</div>
					</div>
					<div class="controlPanel boxShadow" id="rightPanel"><a class="group1-Next" id="group1-Next"></a></div>
				</div>	