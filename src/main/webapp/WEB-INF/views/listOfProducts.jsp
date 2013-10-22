<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:forEach var="product" items="${products}">
	<article>
		<img src="<c:url value="${product.getImages().get(0).getImageUrl()}" ></c:url>"/>
		<div class="content">
			<h3><c:out value="${product.getName()}" ></c:out></h3>
			<p class="description"><c:out value="${product.getDescription()}"></c:out></p>
			<h6>Price: <c:out value="${product.getPrice()}"></c:out></h6>
			<a class="detailed" href="<c:url value="/get/product/${product.getId()}" ></c:url>">Подробнее</a>
		</div>
	</article>
</c:forEach>