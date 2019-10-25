<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>   
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>  

</head>
<body>
	<center>
		<h2>Carton Booking</h2>
		<form:form method="POST" action="/cargo/saveCarton.html">
			<table>
				<tr>
					<td><form:label path="cartonId">Caron ID:</form:label></td>
					<td><form:input path="cartonId" value="${dscarton.cartonId}"
							readonly="true" /></td>
				</tr>
				<tr>
					<td><form:label path="cartonNo">Carton No:</form:label></td>
					<td><form:input path="cartonNo" value="${dscarton.cartonNo}" /></td>
				</tr>

				<tr>
					<td><form:label path="weight">Weight:</form:label></td>
					<td><form:input path="weight" value="${dscarton.weight}" /></td>
				</tr>
				
				<tr>
					<td><form:label path="itemType">ItemType:</form:label></td>
					<td><form:input path="itemType" value="${dscarton.itemType}" /></td>
				</tr>
				<tr>
					<td><form:label path="dsInvoice.invoiceId">invoiceId:</form:label></td>
					
					 <td>
				   		<form:select path="dsInvoice.invoiceId" cssStyle="width: 150px;">    
							<option value="-1">Select a type</option>
							<c:forEach items="${dsinvoices}" var="dsInvoice">
								<option path="dsInvoice.invoiceNo" value="${dsInvoice.invoiceId}">${dsInvoice.invoiceNo}</option>
							</c:forEach>
						</form:select>
					</td>
				</tr>
				
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="SAVE" /></td>
				</tr>
			</table>
		</form:form>
		<br />
		<c:if test="${!empty dscartons}">
			<table align="center" border="1">
				<tr>
					<th>ID</th>
					<th>CaronNO</th>
					<th>Weight</th>
					<th>ItemType</th>
					<th>Options</th>
					<th>Content</th>
					

				</tr>

				<c:forEach items="${dscartons}" var="dscarton">
					<tr>
						<td><c:out value="${dscarton.cartonId}" /></td>
						<td><c:out value="${dscarton.cartonNo}" /></td>
						<td><c:out value="${dscarton.weight}" /></td>
						<td><c:out value="${dscarton.itemType}" /></td>
						<td><c:out value="${dscarton.dsInvoice.invoiceNo}" /></td>
						
						<td align="center"><a
							href="editCarton.html?cartonId=${dscarton.cartonId}">Edit</a> | <a href="deleteCarton.html?cartonId=${dscarton.cartonId}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<h2>
			<a href="addDsinvoice.html">Adding Invoice</a>
			<a href="addCartonItem.html">Adding Item</a>
			
		</h2>
	</center>
</body>
</html>