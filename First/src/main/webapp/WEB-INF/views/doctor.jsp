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
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Doctor</title>

  <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet">
</head>

<body>

  <!-- Navigation -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-primary fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/medico/">Medico</a>
      <a href="welcomeDoctor"><h5 class="text-white mt-2"><%=user.getUserName() %></h5></a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="logout">Logout</a>
          </li> 
        </ul>
      </div>
    </div>
  </nav>

  <header>
		    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
		  <ol class="carousel-indicators">
		    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
		    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
		  </ol>
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img class="d-block w-100" src="<c:url value="/resources/images/silde1.jpg" />"  alt="First slide">
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100 col-lg-12" src="<c:url value="/resources/images/silde4.jpg" />" alt="Second slide">
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="<c:url value="/resources/images/silde3.jpg" />" alt="Third slide">
		    </div>
		  </div>
		  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
			</div>
  </header>


    <div class="conatiner">
        <div class="row">
            <div class="col-12 text-center mt-2 mb-2" style="height: 200%;">
                <h1>Today's Appointment</h1>
            </div>
        </div>
        <div class="row">
            <div class="col-11 mr-4 ml-5">
                <table class="table table-bordered">
                    <thead class="thead-light">
                      <tr>
                        <th scope="col">Serial No</th>
                        <th scope="col">Patient Name</th>
                        <th scope="col">Time</th>
                        <th scope="col">Appointment</th>
                      </tr>
                    </thead>
                    <tbody>
			<c:forEach items="${bookedAppList}" var="slot">
			<input type="hidden" id="slot<%=i%>" value="${slot.getSlotId()}">
                      <tr>
                        <th scope="row"><%=i%></th>
                        <td>${slot.getPatient().getUser().getUserName()}</td>
                        <td>${slot.getTimeslot().getStartTime()}</td>
                        <td><a class="btn btn-info" href="welcomeDoctor" id="anchor<%=i%>">Appointment Inactive</a></td>
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
        		  if(response!=""){
            		  $('#anchor1').text(response);
            		  $('#anchor1').attr("href", "video");
            		  }
        	  }
        	 });
        	}, 5000);
        

        </script>  	
        <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  
  <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

</body>

</html>
<% 
	}else{
		response.sendRedirect("logout");
	}
 %>