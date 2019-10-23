<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
 <link href="webjars/bootstrap/4.0.0/css/bootstrap.min.css"
  rel="stylesheet" />
 <script src="webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="webjars/jquery/3.0.0/jquery.min.js"></script>
</head>
<body>
 <div class="container">
  <form:form modelAttribute="customForm" method="post" action="">
   <div class="form-group">
    Country
    <form:select id="countryId" path="countryId" cssClass="form-control">
     <form:option value="0" label="" />
     <form:options items="${countries}" itemValue="id" itemLabel="name" />
    </form:select>
   </div>
   <div class="form-group">
    City
    <form:select id="cityId" path="cityId" cssClass="form-control">
     <form:option value="0" label="" />
     <form:options items="${cities}" itemValue="id" itemLabel="name" />
    </form:select>
   </div>
  </form:form>

  <script type="text/javascript">
   $(document).ready(function() {
    $("#countryId").change(function() {
      var countryId = $(this).find(":selected").val();
      var json = {
       "countryId" : countryId
      };
 
      $.ajax({
       type : "POST",
       contentType : "application/json",
       url : "/loadCityByCountry",
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
        $('#cityId').html(html);
       },
       error : function(e) {
        alert(e);
       }
      });
    });
   });
  </script>
 </div>
</body>
</html>
