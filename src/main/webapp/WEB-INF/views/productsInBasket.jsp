<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<c:forEach var="product" items="${products}" >
	<div class="productInBasket">
		<img src="<c:url value="${product.getImages().get(0).getImageUrl()}"></c:url>" />
		<c:out value="${product.getName()}"></c:out>
		<c:out value="${product.getPrice()}"></c:out>
	</div>
</c:forEach>

<button> <a href="<c:url value="/basket/orderPage"></c:url>">Заказать</a> </button>