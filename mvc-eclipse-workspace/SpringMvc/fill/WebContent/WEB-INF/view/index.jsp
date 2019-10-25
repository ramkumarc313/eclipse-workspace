<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script src="http://code.jquery.com/jquery-1.10.1.min.js"></script>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    </head>
    
    
    <script type="text/javascript">
$(document).ready(function() { 
	$('#countryId').change( 
			function() {
				$.getJSON('${countryList}', {
					stateName : $(this).val(),
					ajax : 'true'	       

				}, function(data) {
					alert("ram");
					var html = '<option value="">City</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						
						html += '<option value="' + data[i].countryId + '">'
								+ data[i].countryName + '</option>';
					}
					html += '</option>';

					$('#stateId').html(html);
				});
			});
});
</script>

<script type="text/javascript">
	$(document).ready(
			function() {
				$.getJSON('${loadStates}', {
					ajax : 'true'
				}, function(data) {
					alert("ram");
					var html = '<option value="">State</option>';
					var len = data.length;
					for ( var i = 0; i < len; i++) {
						html += '<option value="' + data[i].stateId + '">'
								+ data[i].stateName + '</option>';
					}
					html += '</option>';

					$('#countryId').html(html);
				});
			});
</script>

<script type="text/javascript">
	$(document).ready(function(){
		$("#stateId").change(onSelectChange);
	});

	function onSelectChange() {
		alert("ram");
		var selected = $("#stateId option:selected");		
		var output = "";
		if(selected.val() != 0){
			output = "You selected City " + selected.text();
		}
		$("#output").html(output);
	}
</script>
    
  
    <body>

        <h3>Countries</h3>

        <table class="data">
            
            <tr>
                <td>Country-Name</td>
                <td>
                    <select id="countryId" path="countryId">
                        <option value="">Select Country</option> 
                        <c:forEach items="${countryList}" var="country">
                            <option   value="${country.countryId}"  >${country.countryName}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td>State-Name</td>
                <td>
                    <select  id="stateId" path="stateId">
                        <option value="">Select State</option> 
                    </select>
                </td>
            </tr>                    
        </table>
    </body>
</html>

