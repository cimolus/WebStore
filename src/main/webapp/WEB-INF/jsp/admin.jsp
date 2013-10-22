<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<table>
	<tr>
		<td>Пользователь</td>
		<td>Пароль</td>
		<td>Активен</td>
	</tr>
	<c:forEach var="user" items="${users}">
	<tr>
		<td><c:out value="${user.getUsername()}"></c:out></td>
		<td><c:out value="${user.getPassword()}"></c:out></td>
		<td><c:out value="${user.isActive()}"></c:out></td>
	</tr>
	</c:forEach>
</table>
