<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<%
		String emailError = (String) request.getAttribute("emailError");
		String genderError = (String) request.getAttribute("genderError");
		String genderValue = (String) request.getAttribute("genderValue");
	%>

	<h2>Signup</h2>

	<form method="post" action="SignupController">
		FirstName : <input type="text" name="firstName"
			value="${firstNameValue}" /> ${firstNameError} <br> <Br>
		LastName : <input type="text" name="lastName" /><br> <br>
		Email : <input type="text" name="email" value="${emailValue}" />
		<%=emailError == null ? "" : emailError%>
		<br> <br> Password : <input type="password" name="password" /><br>
		<br>
		
		
		 Gender : 
		 
		 
		 Male <input type="radio" name="gender" value="male"   <%=genderValue!=null&&genderValue.equals("male")?"checked":"" %> />
		
		
		Female:<input type="radio" name="gender" value="female" <%=genderValue!=null&&genderValue.equals("female")?"checked":"" %>/> 
		
		
		<span
			class="error"><%=genderError == null ? "" : genderError%></span> <br>
		<br> <input type="submit" value="Signup" />
	</form>

</body>
</html>




















