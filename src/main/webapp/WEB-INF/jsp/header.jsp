<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<header class="boxShadow">
	<div class="logo"><img src="<c:url value="/resources/images/logo.jpg" ></c:url>"/></div>
	<nav id="dock">
		<div class="dock-container">
			<a class="dock-item" href="<c:url value="/basket/getproducts"></c:url>"><span>Корзина</span><img src="<c:url value="/resources/images/dock/basket.jpg" ></c:url>" alt="Корзина" /></a> 
			<a class="dock-item" href="<c:url value="/"></c:url>"><span>Домой</span><img src="<c:url value="/resources/images/dock/home.png" ></c:url>" alt="Домой" /></a> 
			<a class="dock-item" href="<c:url value="/get/product/"></c:url>"><span>Все товары</span><img src="<c:url value="/resources/images/dock/portfolio.png" ></c:url>" alt="Все товары" /></a> 
			<a class="dock-item" href="<c:url value="/search/page"></c:url>"><span>Поиск</span><img src="<c:url value="/resources/images/dock/search.png" ></c:url>" alt="Поиск" /></a> 
			<a class="dock-item" href="<c:url value="/faq"></c:url>"><span>FAQ</span><img src="<c:url value="/resources/images/dock/faq.jpg" ></c:url>" alt="FAQ" /></a> 
			<a class="dock-item" href="#"><span>Отправить письмо</span><img src="<c:url value="/resources/images/dock/email.png" ></c:url>" alt="send" /></a> 
			<a class="dock-item" href="#"><span>RSS</span><img src="<c:url value="/resources/images/dock/rss.png" ></c:url>" alt="RSS" /></a> 
		</div>
	</nav>
</header>

