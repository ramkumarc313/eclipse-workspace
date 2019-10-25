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
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/table.css">
</head>
<body>
<header style="text-align: center; font-size: 21px">Auto-loading of country details when country is selected from drop-down box.</header><br>
<br><br>
		<form id="countryDetailsForm">
				<select name="country" id="country" required="required">
					<option value="Select Country">Select Country</option>
					<c:forEach items="${countryList}" var="countryList">
						<option value="${countryList.countryName}">${countryList.countryName}</option>
					</c:forEach>
				</select>
				<input type="submit" value="Get Details">
		</form>		
		<div id="loading"></div>
<br><br>
<div class="springajax" style="width:650px; height:400px;">
	<table>
		<tr>
			<td colspan="2">Details of Selected Country</td>
		</tr>
		<tr>
			<td>Code</td>
			<td>
				<div id="countryCode"></div>
			</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>
				<div id="countryName"></div>
			</td>
		</tr>
		<tr>
			<td>Long Name</td>
			<td>
				<div id="longName"></div>
			</td>
		</tr>
		<tr>
			<td>ISO3</td>
			<td>
				<div id="iso3"></div>
			</td>
		</tr>
		<tr>
			<td>Num Code</td>
			<td>
				<div id="numCode"></div>
			</td>
		</tr>
		<tr>
			<td>UN Number</td>
			<td>
				<div id="unNumber"></div>
			</td>
		</tr>
		<tr>
			<td>Calling Code</td>
			<td>
				<div id="callingCode"></div>
			</td>
		</tr>
		<tr>
			<td>CCTLD</td>
			<td>
				<div id="cctld"></div>
			</td>
		</tr>
	</table><br>
</div><br><br>
<div align="center">
	<a href="${pageContext.request.contextPath}/">Go Back to Main Menu</a>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/example2.js"></script>
</body>
</html>
