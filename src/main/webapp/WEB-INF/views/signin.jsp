<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <sec:authorize access="!isAuthenticated()">
		<form action="<c:url value="/j_spring_security_check"></c:url>" method="post">
		 	<input class="input_field" id="j_username" name="j_username" size="20" maxlength="50" type="text" placeholder="Логин" AUTOCOMPLETE="off"/>
			<input class="input_field" id="j_password" name="j_password" size="20" maxlength="50" type="password" placeholder="Пароль" AUTOCOMPLETE="off" />
			<input class="input_submit" type="submit" value="Войти" />
		</form>
	</sec:authorize>