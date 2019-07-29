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
	int i = 1;
%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>

</head>
<body>
<h1>Welcome User</h1>
	<h1><%=user.getUserName() %></h1>
	<a href="logout">logout</a>
	<a href="video">video</a>
	<a href="completeProfile">complete Profile</a>
	<form action="bookAppointment" method="post">
    Select a Category:&nbsp;
    <select name="category" id="dropdownlist1">
    	<option value="">Specialization</option>
    	 <c:forEach items="${spec}" var="Specialization">
            <option value="${Specialization}">${Specialization}</option>
        </c:forEach>
    </select>
    <br/><br/>
     <select id="dropdownlist2">
     <option value="">Doctor</option>
            
    </select>
    <br/><br/>
     <select name="timeslotId" id="dropdownlist3">
      <option value="">TimeSlot</option>
            
    </select>
    <br/><br/>
    <input type="submit" value="Book" />
</form>
	
	<a href="bookAppointment">Book Appointment</a>
	
	<c:forEach items="${appList}" var="app">
			<input type="hidden" id="slot<%=i%>" value="${app.getSlotId()}">
			<h5 >${app.getSlotId()}</h5>
			<h5>${app.getTimeslot().getDoctor().getUser().getUserName()}</h5> 
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
        
        $(document).ready(function() {

        $('#dropdownlist1').change(function() {
        $.ajax({
        url : 'getDoctorList',
        data : {
        spec : $('#dropdownlist1 option:selected').val()
        },
        success : function(responseJson) {
        var $select = $('#dropdownlist2');
        var obj = JSON.parse(responseJson);
                        $.each(obj, function( index, value ) {
                           $("<option>").val(value.emailId).text(value.user.userName).appendTo($select);
        });
        }
        });
        });
        });

        $(document).ready(function() {

        $('#dropdownlist2').change(function() {
        $.ajax({
        url : 'getTimeList',
        data : {
        emailId : $('#dropdownlist2 option:selected').val()
        },
        success : function(responseJson) {
        var $select = $('#dropdownlist3');
        var obj = JSON.parse(responseJson);
                        $.each(obj, function( index, value ) {
                           $("<option>").val(value.slotId).text(value.startTime).appendTo($select);
                           
        });
        }
        });
        });
        });

        </script>  	
</body>
</html>
<% 
	}else{
	response.sendRedirect("logout");	
	}
%>