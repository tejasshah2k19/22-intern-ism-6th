<%@page import="com.bean.UserBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List User</title>
</head>
<body>

	<%
		ArrayList<UserBean> users = (ArrayList<UserBean>) request.getAttribute("users");
	%>


	<table border="1">
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Gender</th>
		</tr>
		<%
			for (UserBean user : users) {
		%>
		<tr>
			<td><%=user.getUserId()%></td>
			<td><%=user.getFirstName()%></td>
			<td><%=user.getLastName()%></td>
			<td><%=user.getEmail()%></td>
			<td><%=user.getGender()%></td>
		</tr>
		<%
			}
		%>

	</table>

</body>
</html>