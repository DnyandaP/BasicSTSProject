<%@page import="com.team.medico.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="no-cache-store.jsp" %>  
<%@ page errorPage="error.jsp" %>  
<%
	User loggedUser = (User)session.getAttribute("user");
	if(loggedUser !=null && loggedUser.getEmailId()!=null){
	User user  = (User)session.getAttribute("user"); 
	int i =1;
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<h1>Welcome doctor</h1>
	<h1><%=user.getUserName() %></h1>
	<a href="video">video</a>
	<a href="logout">logout</a>
	<c:forEach items="${bookedAppList}" var="slot">
			<input type="hidden" id="slot<%=i%>" value="${slot.getSlotId()}">
			<h5 >${slot.getSlotId()}</h5>
			<h5>${slot.getPatient().getUser().getUserName()}</h5> 
			<a href="video" id="anchor<%=i%>"></a>
			<%i++;%>
        </c:forEach>
        
        <script type="text/javascript">
        
        setInterval(function(){
        	var slotId = $("#slot1").val();
        	 $.ajax({
        	  url: 'timeElapse',
        	  data : {
        		  slotIdString: slotId
				},
        	  success: function(response){
        		  $('#anchor1').text(response);
        	  }
        	 });
        	}, 5000);
        

        </script>  	
         <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
</body>
</html>
<% 
	}else{
		response.sendRedirect("logout");
	}
 %>