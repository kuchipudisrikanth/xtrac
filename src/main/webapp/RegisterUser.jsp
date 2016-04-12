<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register User</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script>
	$(document).ready(
					function() {
						$("#Submit").click(
										function() {
											var data = {
												"eMail" : $('#email').val(),
												"firstName" : $('#firstName').val(),
												"lastName" : $('#lastName').val(),
												"phoneNumber" : $('#phoneNumber').val()
											}
											$.ajax({
														type : "POST",
														url : "http://localhost:8080/xtrac/webapi/xtrac",
														data : JSON.stringify(data), //now data comes into this function
														contentType : "application/json; charset=utf-8",
														crossDomain : true,
														dataType : "json",
														success : function(data, status,jqXHR) {
															if (data != null) {
																$("#SuccessText").html("<b>Successfully added </b>");
																$('#email').val("");
																$('#firstName').val("");
																$('#lastName').val("");
																$('#phoneNumber').val("");
															} else {
																$("#SuccessText").html("<b>User already added/Pass valid Info</b>");
															}
														},

														error : function(jqXHR,status) {
															//error handler
															console.log(jqXHR);
															alert('fail'+ status.code);
														}
													});
										});
					});
</script>
<body>
<%@ include file= "header.jsp" %>
<br/>
<h1>Register User</h1>
	<br />
	<label for='email'>Email address*:</label>
	<input type='text' name='email' id='email' maxlength="50" />
	<br />
	<label for='firstName'>First Name*:</label>
	<input type='text' name='firstName' id='firstName' maxlength="50" />
	<br />
	<label for='lastName'>Last Name*:</label>
	<input type='text' name='lastName' id='lastName' maxlength="50" />
	<br />
	<label for='phoneNumber'>Phone Number*:</label>
	<input type='text' name='phoneNumber' id='phoneNumber' maxlength="50" />
	<br />
	<input type='button' name='Register' value='Register' id="Submit" />
	<div id="SuccessText"></div>
</body>

</html>