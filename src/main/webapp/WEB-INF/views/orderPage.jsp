<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
Order Page
<c:url value="/basket/order" var="orderUrl"></c:url>
<form:form action="${orderUrl}" method="POST" modelAttribute="Order">
	<form:label path="address">Адрес:</form:label>
	<form:input path="address"/>
	<form:hidden path="user" value="${username}"/>
	<input type="submit" value="Заказать"/> 
</form:form>