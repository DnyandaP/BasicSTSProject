<%@page import="com.team.medico.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ include file="no-cache-store.jsp" %> 
 <%@ page errorPage="error.jsp" %>      
<%
	User loggedUser = (User)session.getAttribute("user");
	if(loggedUser !=null && loggedUser.getEmailId()!=null){
 	User user  = (User)session.getAttribute("user"); 
 	String token = (String)session.getAttribute("token");
%>

<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Appointment Room</title>
<link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-primary fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/medico/">Medico</a>
	<a href="back"><h5 class="text-white mt-2">Hi <%=user.getUserName() %></h5></a>
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
<!--foam-->
<input id="tokenId" type="hidden" value="<%=token%>">
    <div class="container-fiuld mt-4 mb-4">
          <div class="row">
              <div class="col-12 mt-2 mb-2 text-center">
                  <h1>Video Calling</h1>
              </div>
          </div>
        <div class="row">
            <div class="col-md-3">
                <div>
                  
                </div>
            </div>
            
            <div id="renderer" class="col-md-6" style="border:1px solid black;height: 300px; width: 300px;">
            </div>
            <div class="col-md-3">
                <div>
                    
                </div>
            </div>
        </div>
    </div>

    <div class="container-fiuld">
        <div class="col-12">
            <div class="text-center" style="text-align: center;">
               <p> <button onclick="joinCall()" type="submit" class="btn btn-info">Connect</button>
                <a href="back" type="submit" class="btn btn-info">Back</a></p>
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

<script>    
	var tok = document.getElementById("tokenId").value;
	console.log(tok);
    function onVidyoClientLoaded(status) {
	if (status.state == "READY"){
    VC.CreateVidyoConnector({
		viewId: "renderer",
		viewStyle: "VIDYO_CONNECTORVIEWSTYLE_Default",
		remoteParticipants: 8,
		logFileFilter: "warning info@VidyoClient info@VidyoConnector",
		logFileName: "",
		userData: ""
	}).then(function (vidyoConnector) {

		/*Handle appearance and disappearance of camera devices in the system*/
		vidyoConnector.RegisterLocalCameraEventListener({
		onAdded: function(localCamera) {},
		onRemoved: function(localCamera) {},
		onSelected: function(localCamera) {},
		onStateUpdated: function(localCamera, state) {}
	}).then(function() {
		console.log("RegisterLocalCameraEventListener Success");
	}).catch(function() {
		console.error("RegisterLocalCameraEventListener Failed");
	});

    });

}
    }
function joinCall(){
		
    vidyoConnector.Connect({
			host: "prod.vidyo.io",
			token: tok, //Generated Token
			displayName: "user1", //User Name
			resourceId: "demoroom", //Conference Name
		onSuccess: function () {
			console.log("Sucessfully connected");
		},
		onFailure: function (reason) {
			console.log("Error while connecting ", reason);
		},
		onDisconnected: function (reason) {
			console.log("Disconnected ", reason);
		}
    }).then(function (status) {

    }).catch(function(){
	console.error("sdsf");	
   });
}
		
	</script>

  <!-- Bootstrap core JavaScript -->
  <script src="${pageContext.request.contextPath}/resources/vendor/jquery/jquery.min.js"></script>
  
  <script src="${pageContext.request.contextPath}/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

<script src="https://static.vidyo.io/latest/javascript/VidyoClient/VidyoClient.js?onload=onVidyoClientLoaded&webrtc=true&plugin=false"></script>


</body>

</html>
<% 
	}else{
	response.sendRedirect("logout");	
	}
%>
