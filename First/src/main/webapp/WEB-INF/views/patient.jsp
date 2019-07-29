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
<html lang="en">

<head>

 <meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>

  
<title>Patient</title>

  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
	<!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet">
</head>

<body>

  <!-- Navigation -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-primary fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/medico/">Medico</a>
      <h5 class="text-white mt-2"><%=user.getUserName() %></h5>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="btn btn-info" href="completeProfile">Complete Profile</a>
            </li> 
          <li class="nav-item">
            <a class="nav-link" href="logout">Logout</a>
          </li> 
        </ul>
      </div>
    </div>
  </nav>
<!--foam-->
    <div class="container-fiuld mt-4 mb-4">
          <div class="row">
              <div class="col-12 mt-2 mb-2 text-center">
                  <h1>Appointment Booking</h1>
              </div>
          </div>
        <div class="row">
            <div class="col-md-4">
                <div>
                  
                </div>
            </div>
            
            <div class="col-md-4" style="border:1px solid black;">
                <div>
                    <form action="bookAppointment" method="post">
                        <div class="form-group">
                          <label for="dropdownlist1">Specialization</label>
                          <select class="form-control" id="dropdownlist1">
                              <option value="">Specialization</option>
    	 			<c:forEach items="${spec}" var="Specialization">
            				<option value="${Specialization}">${Specialization}</option>
        			</c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                          <label for="dropdownlist2">Doctor</label>
                          <select class="form-control" id="dropdownlist2">
                            <option value="">Doctor</option>
                          </select>
                        </div>
                        <div class="form-group">
                            <label for="dropdownlist3">Time Slot For Video Call</label>
                            <select class="form-control" name="timeslotId" id="dropdownlist3">
                              <option>Time Slot</option>
                            </select>
                        </div>
                        <div class="form-group">
 				<input type="submit" value="Book" class="btn btn-info" />
                        </div>
                      </form>
                </div>
              </div>
            <div class="col-md-4">
                <div>
                    
                </div>
            </div>
        </div>
    </div>

    <div class="conatiner">
        <div class="row">
            <div class="col-12 text-center mt-2 mb-2" style="height: 200%;">
                <h1>Booked Appointments</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-11 mr-3 ml-5">
                <table class="table table-bordered mr-3 ml-3">
                    <thead class="thead-light">
                      <tr>
                        <th scope="col">#</th>
                        <th scope="col">Doctor</th>
                        <th scope="col">Time</th>
                        <th scope="col">Appointment</th>
                      </tr>
                    </thead>
                    <tbody>
			<c:forEach items="${appList}" var="app">
			<input type="hidden" id="slot<%=i%>" value="${app.getSlotId()}">
                      <tr>
                        <th scope="row"><%=i%></th>
                        <td>${app.getTimeslot().getDoctor().getUser().getUserName()}</td>
                        <td>${app.getTimeslot().getStartTime()}</td>
                        <td><a class="btn btn-info" href="video" id="anchor<%=i%>">Start Appointment</a></td>
                      </tr>
			<%i++;%>
			</c:forEach>
                    </tbody>
                  </table>
            </div>
        </div>
    </div>

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
    </div>
    <!-- /.container -->
  </footer>

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

   <!-- Bootstrap core JavaScript -->
   <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  
  <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>

</html>
<% 
	}else{
	response.sendRedirect("logout");	
	}
%>
