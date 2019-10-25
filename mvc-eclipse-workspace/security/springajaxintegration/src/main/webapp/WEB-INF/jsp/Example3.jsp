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
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/table.css">
</head>
<body>
	<header style="text-align: center; font-size: 21px">Validations in Spring MVC and submitting form using AJAX</header>
	<br>

	<form id="validationForm">
		<div class="springajax" style="width: 450px; height: 500px;">
			<table>
				<tr>
					<td colspan="2">Registration Details</td>
				</tr>
				<tr>
					<td>Name</td>
					<td><input type="text" placeholder="FirstName LastName" onblur="checkNameForEmpty()"
						id="name" name="name"
						title="(Must contain only characters and spaces)">&nbsp;<font
						color="red">*</font><br>
						<div style="color: red" id="name_blank_result"></div>
					</td>
				</tr>
				<tr>
					<td>Nick Name</td>
					<td><input type="text" placeholder="" id="nickName"
						name="nickName"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" id="password" name="password" onblur="checkPasswordForEmpty();checkPasswordForWrongPattern()" onkeyup="checkPasswordForWrongPattern()"
						title="(Must contain at least 1 Capital Letter, 1 digit, and 1 special symbol)">&nbsp;<font
						color="red">*</font><br>
						<div style="color: red" id="password_blank_result"></div>
						<div style="color: red" id="password_pattern_result"></div>
					</td>
				</tr>
				<tr>
					<td>Repeat Password</td>
					<td><input type="password" id="repeatPassword" onblur="checkRepeatPasswordForEmpty(); checkRepeatPasswordForEqual()" onkeyup="checkRepeatPasswordForEqual()"
						name="repeatPassword" title="(Must be exactly same as above)">&nbsp;<font
						color="red">*</font><br>
						<div style="color: red" id="repeat_password_blank_result"></div>
						<div style="color: red" id="repeat_password_match_result"></div>
					</td>
				</tr>
				<tr>
					<td>Email ID</td>
					<td><input type="email" id="emailId" name="emailId" onblur="checkEmailIdForEmpty()" onkeyup="checkEmailIdForWrongPattern()"
						placeholder="someone@somedomain.com">&nbsp;<font
						color="red">*</font><br>
						<div style="color: red" id="email_id_blank_result"></div>
						<div style="color: red" id="email_id_pattern_result"></div>
					</td>
				</tr>
				<tr>
					<td>Mobile Number</td>
					<td><input type="text" id="mobileNumber" name="mobileNumber" onblur="checkMobileNumberForEmpty()" onkeyup="checkMobileNumberForWrongPattern()"
						title="(Must contain only 10 digits)" placeholder="0123456789">&nbsp;<font
						color="red">*</font><br>
						<div style="color: red" id="mobile_number_blank_result"></div>
						<div style="color: red" id="mobile_number_pattern_result"></div>
					</td>
				</tr>
				<tr>
					<td>Gender</td>
					<td><input type="radio" name="gender" value="Male">Male&nbsp;&nbsp;&nbsp;
						<input type="radio" name="gender" value="Female">Female <input
						type="radio" name="gender" value="Other">Other
						&nbsp;&nbsp;<font color="red">*</font></td>
				</tr>
				<tr>
					<td>Select State</td>
					<td><select name="state" id="state"
						onblur="getCitiesForSelectedState(); checkStateForEmpty();">
							<option value="Select State">Select State</option>
							<c:forEach items="${stateList}" var="stateList">
								<option value="${stateList.stateName}">${stateList.stateName}</option>
							</c:forEach>
					</select>&nbsp;<font color="red">*</font><br>
					<div style="color: red" id="state_blank_result"></div>
					</td>
				</tr>
				<tr>
					<td>Select City</td>
					<td><select id="city" name="city" onblur="checkCityForEmpty()">
							<option value="Select City">Select City</option>
					</select>&nbsp;<font color="red">*</font><br>
					<div style="color: red" id="city_blank_result"></div>
					</td>
				</tr>
				<tr>
					<td>Postal Code</td>
					<td><input type="text" id="postalCode" name="postalCode" onblur="checkPostalCodeForEmpty()" onkeyup="checkPostalCodeForWrongPattern()"
						placeholder="123456" title="(Must contain only 6 digits)">&nbsp;<font
						color="red">*</font><br>
						<div style="color: red" id="postal_code_blank_result"></div>
						<div style="color: red" id="postal_code_pattern_result"></div>	
					</td>
				</tr>
				<tr>
					<td>Select Country</td>
					<td><select id="country" name="country" onblur="checkCountryForEmpty()">
							<option value="Select Country">Select Country</option>
							<c:forEach items="${countryList}" var="countryList">
								<option value="${countryList.countryName}">${countryList.countryName}</option>
							</c:forEach>
					</select>&nbsp;<font color="red">*</font><br>
					<div style="color: red" id="country_blank_result"></div>
					</td>
				</tr>
			</table>
			<br> &nbsp;&nbsp;&nbsp;<font color="red" size="3px;">*
				Indicates Required Fields.</font>
			<div align="center">
				<input type="submit" value="Submit Details"> <input
					type="reset" value="Clear Form" id="reset" name="reset">
			</div>
			<div id="loading"></div>
		</div>
		<br> <br> <br>
	</form>
	<div align="justify">
		<div id="submitedDetails"></div>
	</div>
	<div align="center">
		<a href="${pageContext.request.contextPath}/">Go Back to Main Menu</a>
	</div>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/example1.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/example3.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>
