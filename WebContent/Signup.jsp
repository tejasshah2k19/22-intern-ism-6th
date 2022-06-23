<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Signup</h2>

	<form method="post" action="SignupController"> 
		FirstName : <input type="text" name="firstName" /><br> <Br>
		LastName : <input type="text" name="lastName" /><br> <br>
		Email : <input type="text" name="email" /><br> <br>
		Password : <input type="password" name="password" /><br> <br>
		Gender : Male <input type="radio" name="gender" value="male" />
		Female:<input type="radio" name="gender" value="female" />
		<br><br>
		<input type="submit" value="Signup"/>
	</form>

</body>
</html>