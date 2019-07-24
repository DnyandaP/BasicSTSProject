<%@page import="com.team.medico.model.User"%>
<%@ include file="no-cache-store.jsp" %> 
<% 
	User user  = (User)session.getAttribute("user");
	if(user.getUserType().equals("patient")){
		response.sendRedirect("welcome");
	}else if(user.getUserType().equals("doctor")){
		//session.setAttribute("emailId", user.getEmailId());
		response.sendRedirect("welcomeDoctor");
 		
	}else{
		response.sendRedirect("welcomeAdmin");
	}
%>
