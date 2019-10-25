<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- JSTL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- Spring security taglibs--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>
<html>
<head>
	<title>Spring MVC + AJAX Integration</title>
</head>
<body>
	<div align="center">
		<header style="text-align: center; font-size: 21px">Spring MVC + AJAX Integration Examples</header><br>
	</div>
		<a href="${pageContext.request.contextPath}/example1">Example 1 (Auto-loading of cities when state is selected from drop-down box using AJAX)</a><br><br>
		<a href="${pageContext.request.contextPath}/example2">Example 2 (Auto-loading of country details when country is selected from drop-down box using AJAX)</a><br><br>
		<a href="${pageContext.request.contextPath}/example3">Example 3 (Validations in Spring MVC and submitting form using AJAX)</a>		
</body>
</html>
