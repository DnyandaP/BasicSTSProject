<%@ page errorPage="error.jsp" %>  
<%
	//session.removeAttribute("user");
	session.invalidate();
	response.sendRedirect("login_form");
%>