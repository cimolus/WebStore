<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:forEach var="product" items="${products}">    
	<a href="<c:url value="/get/product/${product.getId()}"></c:url>" >
		<div class="productBox boxShadow">
			<img src="${product.getImages().get(0).getImageUrl()}" alt="Картинка"/>
			<p>${product.getName()}</p>
			<p>${product.getPrice()}</p>
		</div>
	</a>
</c:forEach>