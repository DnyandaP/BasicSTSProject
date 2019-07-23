<%@page import="com.team.medico.model.User"%>
<%@ include file="no-cache-store.jsp" %> 
<% 
	User user  = (User)session.getAttribute("user");
	if(user.getUserType().equals("patient")){
		response.sendRedirect("welcome");
	}else if(user.getUserType().equals("doctor")){
 		response.sendRedirect("welcomeDoctor");
	}else{
		response.sendRedirect("welcomeAdmin");
	}
%>
