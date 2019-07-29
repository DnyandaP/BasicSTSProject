<%@page import="java.util.List"%>
<%@page import="com.team.medico.model.*"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<style>
body {font-family: Arial, Helvetica, sans-serif;}

#myImg {
  border-radius: 5px;
  cursor: pointer;
  transition: 0.3s;
}

#myImg:hover {opacity: 0.9;
captionText.innerHTML = "click here";}

#myImg2:hover {opacity: 0.9;
captionText.innerHTML = "click here";}

/* The Modal (background) */
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.9); /* Black w/ opacity */
}

/* Modal Content (image) */
.modal-content {
  margin: auto;
  display: block;
  width: 80%;
  max-width: 700px;
}

/* Caption of Modal Image */
#caption {
  margin: auto;
  display: block;
  width: 80%;
  max-width: 700px;
  text-align: center;
  color: #ccc;
  padding: 10px 0;
  height: 150px;
}

/* Add Animation */
.modal-content, #caption {  
  -webkit-animation-name: zoom;
  -webkit-animation-duration: 0.6s;
  animation-name: zoom;
  animation-duration: 0.6s;
}

@-webkit-keyframes zoom {
  from {-webkit-transform:scale(0)} 
  to {-webkit-transform:scale(1)}
}

@keyframes zoom {
  from {transform:scale(0)} 
  to {transform:scale(1)}
}

/* The Close Button */
.close {
  position: absolute;
  top: 60px;
  right: 35px;
 
  font-size: 50px;
  font-weight: bold;
  transition: 0.9s;
  color: white;
  background-color: red;
}

.close:hover,
.close:focus {
  color: #bbb;
 
  font-size: 70px;
  cursor: pointer;
  background-color: white;
  color: red;
}

/* 100% Image Width on Smaller Screens */
@media only screen and (max-width: 700px){
  .modal-content {
    width: 100%;
  }
}
</style>
</head>
<body>
		
		<nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-primary fixed-top">
            <div class="container">
              <a class="navbar-brand" href="index.html">Medico</a>
              <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                  
                  <li class="nav-item">
                    <a class="nav-link" href="login.html">Logout</a>
                  </li> 
                </ul>
              </div>
            </div>
          </nav>
							<%
 								Doctor doctor = (Doctor)request.getAttribute("doctorList"); 
												
							%>
							
			<div class="container">
        <!--Sign UP foam-->
        <section class="testimonial py-5 mt-4" id="testimonial">
                <div class="container">
                    <div class="row ">
                        <div class="col-md-4 py-5 bg-primary text-white text-center ">
                            <div class=" ">
                                <div class="card-body">
                                    <img src="http://www.ansonika.com/mavia/img/registration_bg.svg" style="width:30%">
                                    <h2 class="py-3">Admin Approvals</h2>
                                    <p></p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-8 py-5 border">
                            <h4 class="pb-4">Admin Approvals</h4>
                            <form>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                            Name<input value="<%=doctor.getUser().getUserName() %>"  id="Full Name"  name="userName"  placeholder="Name" class="form-control" type="text" readonly>
                                    </div>
                                    <div class="form-group col-md-6">
                                      Degree<input value="<%=doctor.getDegree() %>" type="text" class="form-control" id="inputEmail4" placeholder="Degree" readonly>
                                    </div>
                                  </div>
                                
                                  <div class="form-row">
                                    <div class="form-group col-md-6">
                                            CurrentPost<input  value="<%=doctor.getCurrentPost() %>" type="text" class="form-control" id="CurrentPost" placeholder="CurrentPost" readonly>
                                    </div>
                                  </div>

                                  <div class="form-row">
                                        <div class="form-group col-md-6">
                                                Specialization<input  value="<%=doctor.getSpecialization() %>" id="Specialization" name="Specialization" placeholder="Specialization" class="form-control" type="text" readonly>
                                        </div>
                                        <div class="form-group col-md-6">
                                                Awards<input  value="<%=doctor.getAwards() %>" type="text" class="form-control" id="Awards" placeholder="Awards" readonly>
                                        </div>
                                  </div>

                                  <div class="form-row">
                                        <div class="form-group col-md-6 text-center font-weight-bold">
                                                Degree Image
                                        </div>
                                        <div class="form-group col-md-6 text-center font-weight-bold">
                                                License Image
                                        </div>
                                 </div>   

                                 <div class="form-row">
                                        <div class="form-group col-6">
                                               <img id="myImg" src="data:image/jpeg;base64,${degree}" alt="..." width="300" height="300">
                                            </div>
                                        <div class="form-group col-6">
                                            <img id="myImg2" src="data:image/jpeg;base64,${license}" alt="..." width="300" height="300">
                                        </div>
                                </div>   
<!-- 
                                <div class="form-row">
                                    <div class="form-group">
                                        <div class="form-group">
                                            <div class="form-check">
                                              <input class="form-check-input" type="checkbox" value="" id="invalidCheck2" required>
                                              <label class="form-check-label" for="invalidCheck2">
                                                <small>By clicking Submit, you agree to our Terms & Conditions, Visitor Agreement and Privacy Policy.</small>
                                              </label>
                                            </div>
                                          </div>
                                
                                      </div>
                                </div> -->

                              <div class="form-row">
                                <div class="form-group col-md-4">
                                    <a  href="approve_doctor?email=<%=doctor.getEmailId() %>" ><button type="button" class="btn btn-primary">Approve</button></a>
                                      <a  href="delete_doctor?email=<%=doctor.getEmailId() %>" ><button type="button" class="btn btn-danger">Delete</button></a>
                              </div>
                               
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </section>
            
    </div>				
<%--  <img id="myImg" src="data:image/jpeg;base64,${degree}" alt="..." width="400" height="400">
<img id="myImg2" src="data:image/jpeg;base64,${license}" alt="..." width="400" height="400">
<a  href="approve_doctor?email=<%=doctor.getEmailId() %>" >Approved</a>
<a  href="delete_doctor?email=<%=doctor.getEmailId() %>" >Delete</a> 
 --%>
<!-- The Modal -->
<div id="myModal" class="modal">
  <span class="close">&times;</span>
  <img class="modal-content" id="img01" height="100%">
  <div id="caption"></div>
</div>


<script>
// Get the modal
var modal = document.getElementById("myModal");


// Get the image and insert it inside the modal - use its "alt" text as a caption
var img = document.getElementById("myImg");
var img2 = document.getElementById("myImg2");
var modalImg = document.getElementById("img01");
var captionText = document.getElementById("caption");
img.onclick = function(){
  modal.style.display = "block";
  modalImg.src = this.src;
  //captionText.innerHTML = name;
}
img2.onclick = function(){
	  modal.style.display = "block";
	  modalImg.src = this.src;
	  //captionText.innerHTML = name;
	}

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on <span> (x), close the modal
span.onclick = function() { 
  modal.style.display = "none";
}
</script>
</body>
</html>
