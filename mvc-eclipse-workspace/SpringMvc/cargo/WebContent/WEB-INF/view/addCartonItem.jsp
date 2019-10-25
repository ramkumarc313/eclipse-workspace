<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title></head>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>  

<body>
	<center>
		<h2>Carton Booking</h2>
		<form:form method="POST" action="/cargo/saveCartonItem.html">
			<table>
				<tr>
					<td><form:label path="cartonItemid">CaronItem ID:</form:label></td>
					<td><form:input path="cartonItemid" value="${dscartonItem.cartonItemid}"
							readonly="true" /></td>
				</tr>
				<tr>
					<td><form:label path="cartonItemName">ItemName No:</form:label></td>
					<td><form:input path="cartonItemName" value="${dscartonItem.cartonItemName}" /></td>
				</tr>

				<tr>
					<td><form:label path="quantity">Quantity:</form:label></td>
					<td><form:input path="quantity" value="${dscartonItem.quantity}" /></td>
				</tr>
				
				<tr>
					<td><form:label path="goodsValue">Value:</form:label></td>
					<td><form:input path="goodsValue" value="${dscartonItem.goodsValue}" /></td>
				</tr>
				
				<tr>
					<td><form:label path="dsCarton.cartonId">cartonid:</form:label></td>
					
					 <td>
				   		<form:select path="dsCarton.cartonId" cssStyle="width: 150px;">    
							<option value="-1">Select a type</option>
							<c:forEach items="${dscartons}" var="dsCarton">
								<option path="dsCarton.cartonNo" value="${dsCarton.cartonId}">${dsCarton.cartonNo}</option>
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
		<c:if test="${!empty dscartonitems}">
			<table align="center" border="1">
				<tr>
					<th>ID</th>
					<th>item</th>
					<th>Quantity</th>
					<th>goodsvalue</th>
					<th>Content</th>
					

				</tr>

				<c:forEach items="${dscartonitems}" var="dscartonItem">
					<tr>
						<td><c:out value="${dscartonItem.cartonItemid}" /></td>
						<td><c:out value="${dscartonItem.cartonItemName}" /></td>
						<td><c:out value="${dscartonItem.quantity}" /></td>
						<td><c:out value="${dscartonItem.goodsValue}" /></td>
						
						<td align="center"><a
							href="editCartonItem.html?cartonItemid=${dscartonItem.cartonItemid}">Edit</a> | <a href="deleteCartonItem.html?cartonItemid=${dscartonItem.cartonItemid}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<h2>
			<a href="addDsinvoice.html">Adding Invoice</a>
			<a href="addCarton.html">Adding Carton</a>
			
		</h2>
	</center>

</body>
</html>