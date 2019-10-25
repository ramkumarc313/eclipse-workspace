<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
<script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>

<script type="text/javascript">
   $(document).ready(function() {
    $("#deliverySateId").change(function() {
      var deliverySateId = $(this).find(":selected").val();
      var json = {
       "deliverySateId" : deliverySateId

      };
 
      $.ajax({
       type : "POST",
       contentType : "application/json",
       url : "/districts",
       data : JSON.stringify(json),
       dataType : 'json',
       cache : false,
       timeout : 600000,
       success : function(data) {
        var html = '';
        var len = data.length;
        html += '<option value="0"></option>';
        for (var i = 0; i < len; i++) {
         html += '<option value="' + data[i].id + '">'
           + data[i].name
           + '</option>';
        }
        html += '</option>';
        $('#districtId').html(html);
       },
       error : function(e) {
        alert(e);
       }
      });
    });
   });
  </script>



<body>
	<center>
		<h2>HAWB BOOKING</h2>
		<form:form method="POST" action="/cargo/saveInvoice.html">
			<table class="data">
				<tr>
					<td><form:label path="invoiceId">Invoice ID:</form:label></td>
					<td><form:input path="invoiceId" readonly="true" /></td>
				</tr>
				<tr>
					<td><form:label path="invoiceNo">Invoice No:</form:label></td>
					<td><form:input path="invoiceNo"
							value="${dsInvoice.invoiceNo}" /></td>
				</tr>
				<tr>
					<td><form:label path="shipperName">Shipper Name:</form:label></td>
					<td><form:input path="shipperName"
							value="${dsInvoice.shipperName}" /></td>
				</tr>
				<tr>
					<td><form:label path="shipperAddress">Shipper Address:</form:label></td>
					<td><form:input path="shipperAddress"
							value="${dsInvoice.shipperAddress}" /></td>
				</tr>

				<tr>
					<td><form:label path="shipperMobile">Shipper Mobile:</form:label></td>
					<td><form:input path="shipperMobile"
							value="${dsInvoice.shipperMobile}" /></td>
				</tr>
				<tr>
					<td><form:label path="receiverName">Receiver Name:</form:label></td>
					<td><form:input path="receiverName"
							value="${dsInvoice.receiverName}" /></td>
				</tr>
				<tr>
					<td><form:label path="receiverAddress">Receiver Address:</form:label></td>
					<td><form:input path="receiverAddress"
							value="${dsInvoice.receiverAddress}" /></td>
				</tr>
				<tr>
					<td><form:label path="receiverMobile">Receiver Mobile:</form:label></td>
					<td><form:input path="receiverMobile"
							value="${dsInvoice.receiverMobile}" /></td>
				</tr>
				<tr>
					<td><form:label path="dsState.deliverySateId">DeliveryState:</form:label></td>

					<td><form:select id="deliverySateId"
							path="dsState.deliverySateId" name="deliverySateId"
							cssStyle="width: 150px;">
							<option value="-1">Select a type</option>
							<c:forEach items="${dsStates}" var="dsState">
								<option path="dsState.deliveryStateName"
									value="${dsState.deliverySateId}">${dsState.deliveryStateName}</option>
							</c:forEach>
						</form:select></td>

				</tr>

				<tr>

					<td><form:select id="districtId" path="district.districtName"
							name="districtId" cssStyle="width: 150px;">
							<option value="-1">Select a type</option>
							<c:forEach items="${districtId}" var="district">
								<option path="district.districtName"
									value="${district.districtName}">${district.districtName}</option>
							</c:forEach>
						</form:select></td>

				</tr>

				<tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="SAVE" /></td>
				</tr>
			</table>
		</form:form>
		<br />
		<c:if test="${!empty dsinvoices}">
			<table align="center" border="1">
				<tr>
					<th>Invoice ID</th>
					<th>Invoice NO</th>
					<th>Options</th>
				</tr>

				<c:forEach items="${dsinvoices}" var="dsInvoice">
					<tr>
						<td><c:out value="${dsInvoice.invoiceId}" /></td>
						<td><c:out value="${dsInvoice.invoiceNo}" /></td>
						<td><c:out value="${dsInvoice.shipperName}" /></td>
						<td><c:out value="${dsInvoice.shipperAddress}" /></td>
						<td><c:out value="${dsInvoice.shipperMobile}" /></td>
						<td><c:out value="${dsInvoice.receiverName}" /></td>
						<td><c:out value="${dsInvoice.receiverAddress}" /></td>
						<td><c:out value="${dsInvoice.dsState.deliveryStateName}" /></td>

						<td align="center"><a
							href="editInvoice.html?invoiceId=${dsInvoice.invoiceId}">Edit</a>
							| <a href="deleteInvoice.html?invoiceId=${dsInvoice.invoiceId}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<h2>
			<a href="addCarton.html">Adding Carton</a>
		</h2>
	</center>
</body>
</html>