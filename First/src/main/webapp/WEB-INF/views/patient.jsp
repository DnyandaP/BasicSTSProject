<%@page import="com.team.medico.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="no-cache-store.jsp" %>  
<%
	User loggedUser = (User)session.getAttribute("user");
	if(loggedUser !=null && loggedUser.getEmailId()!=null){
	User user  = (User)session.getAttribute("user"); 
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome User</h1>
	<h1><%=user.getUserName() %></h1>
	<a href="video">video</a>
	<a href="logout">logout</a>
</body>
</html>
<% 
	}else{
	response.sendRedirect("logout");	
	}
%>