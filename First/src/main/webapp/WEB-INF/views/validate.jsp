<%@page import="com.team.medico.model.User"%>
<%@ include file="no-cache-store.jsp" %> 
<% 
	User user  = (User)session.getAttribute("user");
	if(user.getUserType().equals("patient")){
		response.sendRedirect("welcome");
	}else{
 		response.sendRedirect("welcomeDoctor");
	}
%>
