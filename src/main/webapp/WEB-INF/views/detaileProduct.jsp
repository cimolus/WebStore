<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

		<title>E-shop</title>
		<link href='http://fonts.googleapis.com/css?family=Libre+Baskerville|Arapey' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Style.css" ></c:url>">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/ImageGallery.css" ></c:url>">
		<script type="text/javascript" src="<c:url value="/resources/scripts/jquery-1.9.1.min.js" ></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/resources/scripts/fisheye-iutil.min.js" ></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/resources/scripts/dock-example1.js" ></c:url>"></script>
		<link rel="stylesheet" href="<c:url value="/resources/css/mooRate.css" ></c:url>" />
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/mootools/1.2.4/mootools-yui-compressed.js"></script>
		<script type="text/javascript" src="<c:url value="/resources/scripts/mooRate.js" ></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/resources/scripts/modal.js" ></c:url>"></script>
		<script>
			window.addEvent('domready', function() {
				var rating = new MooRate($$('.moorate'));
				rating.setDefaultRate($('myrating2'), "95%");
				var eventHandler = function(target, value) {};
				$('myrating2').addEvent('rated', eventHandler);
			});
		</script>
				<h2 class="productName"><c:out value="${product.getName()}"></c:out></h2>
				<p class="description"><c:out value="${product.getDescription()}"></c:out></p>
				<div class="imagesContainer">
					<c:forEach var="image" items="${product.getImages()}">
						<img src="<c:url value="${image.getImageUrl()}"></c:url>" />
					</c:forEach>
				</div>
				<p class="detaileDescription"><c:out value="${product.getDetaileDescription()}"></c:out></p>
				<div class="price"><c:out value="${product.getPrice()}"></c:out></div>
				
				<div class="moorate_container" >
   					<div id="myrating2" class="moorate" title="Оцените!">
    					<span class="curr" title="0" style="width:0;"></span>
    				</div>
   					<div class="mooratelabel">0%</div>
				</div>
				
				<c:if test="${!basket.containsProduct(product.getId())}">
					<form action="<c:url value="/basket/add/${product.getId()}"></c:url>">
						<button class="addToBasketButton" type="submit">В корзину</button>
					</form>
				</c:if>
				<c:if test="${basket.containsProduct(product.getId())}">
					<form action="<c:url value="/basket/delete/${product.getId()}"></c:url>">
						<button class="addToBasketButton" type="submit">Из корзины</button>
					</form>
				</c:if>
				<hr>
				<h5>Оставить комментарий</h5>
				<sec:authorize access="isAuthenticated()">
					<c:url value="/product/${product.getId()}/addComment" var="commentUrl"></c:url>
					<form:form method="POST" modelAttribute="Comment" action="${commentUrl}" class="commentForm" AUTOCOMPLETE="off" >
						<form:input class="commentTextForm" path="text"/>
						<input class="submitComment" type="submit" value="Оставить комментарий">
					</form:form>
				</sec:authorize>
				<sec:authorize access="!isAuthenticated()">
					Комментарии могут оставлять только зарегестрированные пользователи!
				</sec:authorize>
				
				<hr>
				<c:forEach var="comment" items="${product.getComments()}">
					<div class="commentContainer">
						<h5 class="author"><c:out value="${comment.getAuthor()}"></c:out></h5>
						<div class="text"><c:out value="${comment.getText()}"></c:out></div>
					</div>
				</c:forEach>