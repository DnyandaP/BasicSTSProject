<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page errorPage="error.jsp" %>  
<!DOCTYPE html>
<html>
<head>

 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up</title>
     <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
	<!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet">
</head>
<body>
    <!--navbar-->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-primary fixed-top">
            <div class="container">
              <a class="navbar-brand" href="/medico">Medico</a>
              <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
          <li class="nav-item dropdown">
            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Sign Up</a>
                    <div class="dropdown-menu">
                        <a href="signUpDoctor" class="dropdown-item">Doctor</a>
                        <a href="signUpPatient" class="dropdown-item">Patient</a>
                        <a href="signUpAdmin" class="dropdown-item">Admin</a>
                    </div>
          </li> 
          <li class="nav-item">
            <a class="nav-link" href="login_form">Login</a>
          </li> 
        </ul>
              </div>
            </div>
          </nav>
    <!--navbar-->

    <div class="container">
        <!--Sign UP foam-->
        <section class="testimonial py-5" id="testimonial">
                <div class="container">
                    <div class="row ">
                        <div class="col-md-4 py-5 bg-primary text-white text-center ">
                            <div class=" ">
                                <div class="card-body">
                                    <img src="https://www.google.com/imgres?imgurl=http%3A%2F%2Fpluspng.com%2Fimg-png%2Fpng-hd-doctor-two-doctors-600.png&imgrefurl=http%3A%2F%2Fpluspng.com%2Fpng-hd-doctor-8666.html&docid=HqhuyoA0uatI_M&tbnid=dPX1RVH01H0FOM%3A&vet=10ahUKEwi_u_Wt78zjAhWCNY8KHX9DAQUQMwiNASggMCA..i&w=600&h=315&bih=657&biw=1366&q=doctor%20images%20hd&ved=0ahUKEwi_u_Wt78zjAhWCNY8KHX9DAQUQMwiNASggMCA&iact=mrc&uact=8";
									style="width: 70%">
									
                                    
                                    <h2 class="py-3">Sign Up Admin</h2>
                                    <p>Tation argumentum et usu, dicit viderer evertitur te has. Eu dictas concludaturque usu, facete detracto patrioque an per, lucilius pertinacia eu vel.
           </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-8 py-5 border">
                            <h4 class="pb-4">Please fill with your details</h4>
                            <form action="saveAdmin" method="post">
                                <div class="form-row">
                                    <div class="form-group col-md-6">
									<spring:bind path="user.userName">
									<input id="Full Name" required="required" name="userName" placeholder="Full Name"
										class="form-control" type="text">
									</spring:bind>
								</div>
                                    <div class="form-group col-md-6">
									<spring:bind path="user.emailId">
									<input type="email" name="emailId" required="required"  pattern=".{8,}" title="8 or more character"
										class="form-control" id="inputEmail4" placeholder="Email">
									</spring:bind> 
									<!-- ajax response -->
                                     		<div id="ajaxResponse" style="color:red"></div>                                   
									</div>
                                  </div>
                                
                                  <div class="form-row">
                                    <div class="form-group col-md-6">
									<spring:bind path="user.password">
									<input id="Password" name="password" required="required" placeholder="Password"
										pattern=".{8,}" title="8 or more character"
										class="form-control" type="password">
									</spring:bind>                                    
									</div>
                                    <div class="form-group col-md-6">
									<spring:bind path="user.contactNo">
									<input type="text" name="contactNo" class="form-control" required="required" id="Contact"
										pattern=".{10}" title="plaease enter valid number"
										placeholder="Contact">
									</spring:bind>    
									</div>
                                  </div>

                                
                                  <div class="form-row">
                                    <div class="form-group col-md-6">
                                      <spring:bind path="user.gender">
									<select name="gender" class="form-control">
										<option selected>Gender</option>
										<option value="Male">Male</option>
										<option value="Female">Female</option>
										<option value="Transgender"> Transgender </option>
									</select>
									</spring:bind>
                                    </div>
                                    <div class="form-group col-md-6">
									<spring:bind path="user.dob">
									<input type="date" class="form-control" id="dateofbirth"
									name="dob" required="required"
										placeholder="Dateofbirth">
									</spring:bind>                                    
									</div>
                                   </div>

                                  <div class="form-row">
                                      <div class="form-group col-md-6">
									<spring:bind path="user.aadharNo">
									<input id="Addhar" name="aadharNo" required="required" placeholder="Addhar No"
										pattern=".{18}"
										title="plaease enter valid AdharNo and no space between number"
										class="form-control" type="number">
									</spring:bind>                                      
									</div>
									
                                  </div>

                                

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
                                </div>

                              <div class="form-row">
                                <div class="form-group col-md-4">
                                <input type="submit" value="Sign Up" class="btn btn-danger">
                                    
                                </div>
                                <div class="form-group col-md-4">
                                  
                               </div>
                                <div class="form-group col-md-4">
                                  
                             <a href="login_form"><button type="button" class="btn btn-primary">Sign Up</button></a>
                               </div>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </section>
            
    </div>
    <!-- Footer -->
    <footer class="py-5 bg-dark">
            <div class="container">
              <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
            </div>
    </footer>
     <!-- Ajax -->
    
    <script src="https://code.jquery.com/jquery-1.10.2.js"
	type="text/javascript"></script>
	<script type="text/javascript">
	$(document).ready(function() {
		$('#inputEmail4').blur(function() {
			$.ajax({
				url : 'getEmailAjax',
				data : {
					emailId : $('#inputEmail4').val()
				},
				success : function(responseText) {
					$('#ajaxResponse').text(responseText);
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