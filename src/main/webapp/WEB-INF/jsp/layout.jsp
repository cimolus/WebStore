<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>E-shop</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/Style.css" ></c:url>">
		<script type="text/javascript" src="<c:url value="/resources/scripts/jquery-1.9.1.min.js" ></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/resources/scripts/fisheye-iutil.min.js" ></c:url>"></script>
		<script type="text/javascript" src="<c:url value="/resources/scripts/dock-example1.js" ></c:url>"></script>
	</head>
	<body>
		<tiles:insertAttribute name="header" />
		<div class="container boxShadow">
			<tiles:insertAttribute name="aside" />
			<section>
				<tiles:insertAttribute name="body" />
			</section>
		</div>
		<tiles:insertAttribute name="footer" />
	</body>
</html>