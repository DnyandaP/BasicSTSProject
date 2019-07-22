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
	<h1><%=user.getUserName() %></h1>

	<script>    
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
			token: 'cHJvdmlzaW9uAGRueUA4NWFiYWYudmlkeW8uaW8ANjM3MzA2OTAxNjYAADZhMjgxYTllNjdjN2YzZmI0MDJjYTBjNTQ4NjZkNWQ5YmJkOTI5YTE0YmE2Y2ZiZDEyMjdmMWFjYWQ0OTUxYmI1MzkyMmI1ODkzYjcwMTJmY2NkYTU4MDIwYmQ2NWU3Ng', //Generated Token
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
	<div id="renderer" style="position: absolute; top: 41px; left: 3px; bottom: -23px; z-index: 99; height: 300px; width: 300px;"></div>
	<button onclick="joinCall()">Connect</button>
	<script src="https://static.vidyo.io/latest/javascript/VidyoClient/VidyoClient.js?onload=onVidyoClientLoaded&webrtc=true&plugin=false"></script>
</body>
</html>
<% 
	}else{
	response.sendRedirect("logout");	
	}
%>