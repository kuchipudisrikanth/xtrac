<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Registered Applications</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	<script type="text/javascript" src="http://cdn.datatables.net/t/dt/dt-1.10.11/datatables.min.js"></script>
<script>
	$(document).ready(function() {
						$("#Submit").click(
										function() {
											var data = {
												"eMail" : $('#email').val(),
												        }
											var geturl = "http://localhost:8080/xtrac/webapi/xtrac/"+ $('#email').val();
											$("#SuccessText").empty();
											$.ajax({
												        type : "GET",
														url : geturl,
														data : JSON.stringify(data),//now data comes into this function
														contentType : "application/json; charset=utf-8",
														crossDomain : true,
														dataType : "json",
														success : function(data, status,jqXHR) {
															if (data != null) {
																myfunction(data);
															} else {
																$("#SuccessText").html("<b>Invalid user</b>");
															}
														},

														error : function(jqXHR,status) {
															//error handler
															console.log(jqXHR);
															alert('fail'+ status.code);
														}
													});
										});
						function myfunction(user) {
												$('#SuccessText').empty();
												$('#SuccessText').append('EmailId:<b>'+ user.eMail+ '<b>&nbsp;&nbsp;&nbsp;');
							      				$('#SuccessText').append('<input type="button", name="DeleteUser" value="Delete User" id="Delete" onclick="deleteUser()"/><br/>');
												$('#SuccessText').append('FirstName:<b>'+ user.firstName+ '</b><br/>');
												$('#SuccessText').append('LastName:<b>'+ user.lastName+ '<b><br/>');
												$('#SuccessText').append('PhNumber:<b>'+ user.phoneNumber+ '<b><br/><br/>');
											
						}
					});
	function deleteUser() {
		var geturl = "http://localhost:8080/xtrac/webapi/xtrac/"+$('#email').val();
		$.ajax({
			type : "DELETE",
			url : geturl,
			data : null,//now data comes into this function
			contentType : "application/json; charset=utf-8",
			crossDomain : true,
			dataType : "json",
			success : function(data, status, jqXHR) {
				alert("Successfully Deleted");
				location.reload();
			},

			error : function(jqXHR, status) {
				//error handler
				console.log(jqXHR);
				alert('fail' + status.code);
			}
		});
	}
</script>
<body>
<%@ include file= "header.jsp" %>
<br/>
<h1> View User Details</h1>
	<br />
	<label for='email'>Email address*:</label>
	<input type='text' name='email' id='email' maxlength="50" />
	<br />
	<input type='button' name='Submit' value='Submit' id="Submit" />
	<div id="SuccessText"></div>
</body>

</html>