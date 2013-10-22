<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="registration">

<h3>Регистрация</h3>
<c:url value="/addUser" var="addUserUrl"></c:url>
<form:form action="${addUserUrl}" method="POST" modelAttribute="User">
	<form:input path="username" class="input_field" size="20" maxlength="50" type="text" placeholder="Логин" AUTOCOMPLETE="off" />
	<form:password path="password" class="input_field" size="20" maxlength="50" placeholder="Пароль" AUTOCOMPLETE="off"/>
	<input class="input_submit" type="submit" value="Зарегестрировать" />
</form:form>

</div>

