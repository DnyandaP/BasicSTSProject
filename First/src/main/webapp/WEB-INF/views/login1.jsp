<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spr" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="login__form" >
	<spr:bind path="user.contactNo">
			<input type="text" name="contactNo" value="usersdName">
		</spr:bind>
		<spr:bind path="doctor.license">
			<input type="text" name="license" value="userName">
		</spr:bind><br>
		<input type="submit" value="Login" /><br>
	</form>

</body>
</html>