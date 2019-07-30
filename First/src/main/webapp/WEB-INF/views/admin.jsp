<%@page import="com.team.medico.model.*"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="no-cache-store.jsp" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
	User loggedUser = (User)session.getAttribute("user");
	if(loggedUser !=null && loggedUser.getEmailId()!=null){
	User user  = (User)session.getAttribute("user"); 
%>

<!DOCTYPE html>
<html>
<head>

<style>
table tbody tr:nth-child(even) {
  background-color: #eee;
}
table tbody tr:nth-child(odd) {
 background-color: #fff;
}
.sidenav {
	height: 100%;
	width: 160px;
	position: fixed;
	z-index: 1;
	top: 0;
	left: 0;
	background-color: #104a73;
	overflow-x: hidden;
	padding-top: 20px;
}

.sidenav a {
	padding: 6px 8px 6px 16px;
	text-decoration: none;
	font-size: 25px;
	color: #818181;
	display: block;
}

.sidenav a:hover {
	color: black;
}

.main {
	background-color: #aaaaaa;
	margin-left: 100px; /* Same as the width of the sidenav */
	font-size: 28px; /* Increased text to enable scrolling */
}

.main1 {
	margin-left: 60px; /* Same as the width of the sidenav */
	font-size: 22px; /* Increased text to enable scrolling */
}

@media screen and (max-height: 450px) {
	.sidenav {
		padding-top: 15px;
	}
	.sidenav a {
		font-size: 18px;
	}
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<link rel="stylesheet" href="/css.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
	integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
	crossorigin="anonymous"></script>

<script>
                function my1(){
                    var w= document.getElementById('di1');
                    var x= document.getElementById('di2');
                    var y= document.getElementById('di3');
                    var z= document.getElementById('di4');
                    w.style.display="block";
                    x.style.display="none";
                    y.style.display="none";
                    z.style.display="none";
                }
                function my2(){
                    var w= document.getElementById('di1');
                    var x= document.getElementById('di2');
                    var y= document.getElementById('di3');
                    var z= document.getElementById('di4');
                    w.style.display="none";
                    x.style.display="block";
                    y.style.display="none";
                    z.style.display="none";
                }
                function my3(){
                    var w= document.getElementById('di1');
                    var x= document.getElementById('di2');
                    var y= document.getElementById('di3');
                    var z= document.getElementById('di4');
                    w.style.display="none";
                    x.style.display="none";
                    y.style.display="block";
                    z.style.display="none";
                }
                function my4(){
                    var w= document.getElementById('di1');
                    var x= document.getElementById('di2');
                    var y= document.getElementById('di3');
                    var z= document.getElementById('di4');
                    w.style.display="none";
                    x.style.display="none";
                    y.style.display="none";
                    z.style.display="block";
                }
                function my5(){
                    var w= document.getElementById('di1');
                    var x= document.getElementById('di2');
                    var y= document.getElementById('di3');
                    var z= document.getElementById('di4');
                    w.style.display="none";
                    x.style.display="none";
                    y.style.display="none";
                    z.style.display="none";
                }
</script>

</head>

<body>

	<div class="container-fluid">
		<div class="row">
			<nav
				class="navbar fixed-top navbar-expand-lg navbar-dark bg-primary fixed-top">
				<div class="container">
					<a class="navbar-brand" href="/medico/">Medico</a>
					<button class="navbar-toggler navbar-toggler-right" type="button"
						data-toggle="collapse" data-target="#navbarResponsive"
						aria-controls="navbarResponsive" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarResponsive">
						<ul class="navbar-nav ml-auto">
							<li class="nav-item">
                    			<a class="nav-link" href="welcomeAdmin">Back</a>
                  			</li>
							<li class="nav-item"><a class="nav-link" href="logout">Logout</a>
							</li>
						</ul>
					</div>
				</div>
			</nav>

		</div>


		<div class="row mt-4">
		<!--Adimn Dash Board  -->
			<div class="sidenav" style="width: 20%;">
				<h3 class="ml-4 mt-5 text-white">Admin Dashboard</h3>

				<br>
				<button class="ml-5 btn btn-primary" onclick="my2()">Doctor</button>
				<br>
				<br>
				<button class="ml-5 btn btn-primary" onclick="my3()">Patient</button>
				<br>
				<br>
				<button class="ml-5 btn btn-primary" onclick="my1()">InActive</button>
				<br>
				<br>
			</div>

			<div style="margin-left: 11.5%">




<div id="di1" class="main1"
					style="display: none; margin-left: 40%; margin-top: 10%;">
					
					 
				<%				List<Doctor> doctorList1 = (List<Doctor>)request.getAttribute("doctorList"); 
				
 								List<User> userList = (List<User>)request.getAttribute("userList"); 
				
								if(userList!=null || doctorList1!=null){ 
							%>
							
							<table class="table">
								<thead class="bg-info text-black">
									<tr>
										<th scope="col">Sr.No</th>
										<th scope="col">Name</th>
										<th scope="col">Contact</th>
										<th scope="col">Type_Of_User</th>
										</tr>
								</thead>
								<%
									int j=1;
									for(Doctor doctor : doctorList1){
										if(doctor.getUser().getIsActive()==false){
								%>
								<tbody>
								<tr>
									<td><%=j%></td>
									<td><%=doctor.getUser().getUserName() %></td>
									<td><%=doctor.getUser().getContactNo() %></td>
									<td><%=doctor.getUser().getUserType() %></td>
									
								<%j=j+1;
										}
									}  %>
									</tbody>
							</table>
							<%}
							else{
							%><h1>No Patient to show</h1>

							<%} %>	 
  						 
					</div>





				<div id="di2" class="main1"	style="display: none; margin-left: 20%; margin-top: 7%;">
					<div class="text-danger "><h2>Pending Doctor's Profile</h2></div> 
					<div class="container">
						<div class="row">
							<%
 								List<Doctor> doctorList = (List<Doctor>)request.getAttribute("doctorList"); 
								//Object image=request.getAttribute("image");
								if(doctorList!=null){
									
							%>
							
							<table class="table">
								<thead class="bg-warning">
									<tr>
										<th scope="col">Sr no</th>
										<th scope="col">Doctor Name</th>
										<th scope="col">degree</th>
										<th scope="col">View Doctor</th>
									</tr>
								</thead>
								<tbody>
								<%
									int i=1;
									int count=0;
									for(Doctor doctor : doctorList){
										if(doctor.getStatus().equals("Pending")==true && doctor.getUser().getIsActive()==true){
										//	out.print(doctor.getStatus());
										
								%>
								<tr>
									<td><%=i%></td>

									<td><%=doctor.getUser().getUserName() %></td>
									<td><%=doctor.getDegree() %></td>
									 <td><a href="view_doctor?email=<%=doctor.getEmailId() %>" >view</a></td> 
								</tr>
								<%i=i+1;
								count=1;
										}
										
										}
										if(count!=0){
											
										}
										else{ 
							%><tr><td>No Doctor is Pending</td></tr>

							<%}%>
										</tbody>
							</table>
							<div class="text-success "><h2>Approved Doctors</h2></div> 
							<table class="table">
								<thead class="bg-info">
									<tr>
										<th scope="col">Sr no</th>
										<th scope="col">Doctor Name</th>
										<th scope="col">degree</th>
										<th scope="col">View Doctor</th>
										
									</tr>
								</thead>
	
								<%
									int i1=1;
									int count1=0;
									for(Doctor doctor : doctorList){
										if(doctor.getStatus().equals("Approved")==true){
											//out.print(doctor.getStatus());
											
								%>
								<tbody>
								<tr>
									<td><%=i1%></td>

									<td><%=doctor.getUser().getUserName() %></td>
									<td><%=doctor.getDegree() %></td>
									 <td><a href="view_doctor?email=<%=doctor.getEmailId() %>" >view</a></td> 
								</tr>
								<%i1=i1+1;
								count1=1;
										}
										}  
										
										if(count1!=0){
											
										}
										else{ 
							%><tr><td>No Doctor is Pending</td></tr>

							<%}%>
										</tbody>
							</table>
							
							<%}
							else{
							%><h1>No Doctor to show</h1>

							<%} %>


							
						</div>
					</div>
				</div>
			</div>

			<div id="di3" class="main1"
				style="display: none; margin-left: 15%; margin-top: 5%;">

							<%
 								//List<User> usertList12 = (List<User>) request.getAttribute("userList"); 
				
								if(userList!=null){ 
							%>
							<table class="table">
								<thead class="bg-info text-black">
									<tr>
										<th scope="col">Sr Number</th>
										<th scope="col">Name</th>
										<th scope="col">Gender</th>
										<th scope="col">Delete User</th>
									</tr>
								</thead>
								<tbody>
								<%
									int j=1;
									for(User user1 : userList){
								%>
								
								<tr>
									<td><%=j%></td>
									<td><%=user1.getUserName() %></td>
									<td><%=user1.getGender() %></td>
									<td><a  href="delete_doctor?email=<%=user1.getEmailId() %>" ><button type="button" class="btn btn-danger">Delete</button></a></td>
									<%-- <td><a href="delete_user.htm?userId=<%=u.getUserId() %>" >Delete</a></td>
									<td><a href="select_user.htm?userId=<%=u.getUserId() %>" >Select</a></td> --%>
								</tr>
								<%j++;
									}  %>
									</tbody>
							</table>
							<%}
							else{
							%><h1>No Patient to show</h1>

							<%} %>
			</div>
		</div>

	</div>



</body>
</html>

<% 
	}else{
	response.sendRedirect("logout");	
	}
%>
