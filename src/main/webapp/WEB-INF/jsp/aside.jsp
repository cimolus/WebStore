<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<aside>
	<div class="authorithation">
		<h3>Авторизация</h3>
		<sec:authorize access="!isAuthenticated()">
			<form action="<c:url value="/j_spring_security_check"></c:url>" method="post">
		 		<input class="input_field" id="j_username" name="j_username" size="20" maxlength="50" type="text" placeholder="Логин" AUTOCOMPLETE="off"/>
				<input class="input_field" id="j_password" name="j_password" size="20" maxlength="50" type="password" placeholder="Пароль" AUTOCOMPLETE="off" />
				<input class="input_submit" type="submit" value="Войти" />
			</form>
			<a href="<c:url value="/registration"></c:url>" >Регистрация</a>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			Hello, <sec:authentication property="principal.username" /></br>
   			<a href="<c:url value="/logout"/>">Logout</a>
   			<sec:authorize access="hasRole('ROLE_ADMIN')">
   				<br><a href="<c:url value="/admin"></c:url>">Панель администрирования</a>
   			</sec:authorize>
		</sec:authorize>
	</div>	
	
</aside>