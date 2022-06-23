<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

	<%
		String firstName = (String) request.getAttribute("firstName");
		String email = (String) request.getAttribute("email");
		String gender = (String) request.getAttribute("gender");
	%>



	FirstName :
	<%=firstName%>
	<br> Email :
	<%=email%>
	<br> Gender :
	<%=gender%>
	<br>

</body>
</html>