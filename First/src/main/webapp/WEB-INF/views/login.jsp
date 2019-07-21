<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spr" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<spr:form action="loginval" modelAttribute="user" >
		User Name : <spr:input path="userName" /><br>
		Password : <spr:password path="password" /><br>
		<input type="submit" value="Login" /><br>
	</spr:form>

</body>
</html>