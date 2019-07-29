<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page errorPage="error.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up</title>
<!-- Bootstrap core CSS -->
     
     <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
	<!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet">
</head>
<body>
	<!--navbar-->
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
          <li class="nav-item dropdown">
            <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Sign Up</a>
                    <div class="dropdown-menu">
                        <a href="signUpDoctor" class="dropdown-item">Doctor</a>
                        <a href="signUpPatient" class="dropdown-item">Patient</a>
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
								<img src="https://lh3.googleusercontent.com/8g540BSYIHps3dUywQU09dTIOs2NNLme7Pg0tUjI6KnNm2VYCVFDI_nWZ_FmNboZj4fBucya-dGY2TNjxROMh7xIOAXKQ811bEnpRlcbKB8mBsgdx0EfDFHoXRktIwudg993_XXah7VabMqYFkNmGoR_1PBK5StKHgl0eUPIWdcBmZJfuCOwxFH9g5I0t9f49TRDqsL19s3SNLr8WSgaa2QB8yB98tNp102R4Th6QjNG7IBT0lGv6hDKlO_SSf9zOWcW9bm29CZHczzjH3SCr6hmbu6S9oYR_Hzdl5LVcrNrFEq2URfPA56ZnDKj2KgOVfJSnB8l91X3e-JG39Os3Zb_r7qrxDiS6h-q780sotQGPkg53VIRhusntEP4qqg1WwjWBuDwc1mXj9X-mcSuaOtbca3uztKFFjPBV2FdjCEAbSynCqFZqhNbhlqTaEUs3WG8fxOrkGC6HAV7SnmRIX74n9cUCCwnq79WXz2VwpIfL3nBAtB_ale6Oc_Y5YoiKHcyvTDTf-FDvDRmCUWtuVuaNNNXJJxEn7bQ42VwhfuaBDNHr9NyO1o90VthXUaP_VLovVHZYb6X2dmtxlgbQ9m7K35tgyOjPMFiKpWN_HBkTsGvbTSxxhSL1wcZXvSaGRl81Nn-mGMDS-nqIFV1aMuMRZpc9gliAUd8vly8n6bK2-SmelHT6wrkP3KtVsZZDIcaS4_7FIIm7omi1vwJAcQjsQ=w650-h520-no"
									style="width: 70%">
								<h2 class="py-3">Sign Up Doctor</h2>
								<p>Medico provides you with platform where you get easy access to health related requiremnets and informationp</p>
							</div>
						</div>
					</div>
					<div class="col-md-8 py-5 border">
						<h4 class="pb-4">Please fill with your details</h4>
						
						
						<!-- form starts -->
						<form action="saveDoctor" enctype="multipart/form-data" method="post">
							<div class="form-row">
								<div class="form-group col-md-6">
									<spring:bind path="user.userName">
									Name<input id="Full Name" name="userName" required="required" placeholder="Full Name"
										class="form-control" autocomplete="off" type="text">
									</spring:bind>
								</div>
								<div class="form-group col-md-6">
									<spring:bind path="user.emailId">
									Email Id<input type="email" name="emailId" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required="required" title="8 or more character"
										class="form-control" id="inputEmail4" autocomplete="off" placeholder="Email">
									</spring:bind>
									<!-- ajax response -->
                                     		<div id="ajaxResponse" style="color:red"></div>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<spring:bind path="user.password">
									Password<input id="Password" name="password" autocomplete="off" required="required" placeholder="Password"
										pattern=".{8,}" title="8 or more character"
										class="form-control" type="password">
									</spring:bind>
								</div>
								<div class="form-group col-md-6">
									<spring:bind path="user.contactNo">
									Contact No<input type="text" name="contactNo" autocomplete="off" required="required" class="form-control" id="Contact"
										pattern="^[6-9]\d{9}$" title="plaease enter valid number"
										placeholder="Contact">
									</spring:bind>
									<!-- ajax response -->
                                     		<div id="ajaxResponse3" style="color:red"></div>
								</div>
							</div>


							<div class="form-row">
								<div class="form-group col-md-6">
									<spring:bind path="user.gender">
									Gender<select name="gender" required="required" autocomplete="off" class="form-control">
										<option selected>Gender</option>
										<option value="Male">Male</option>
										<option value="Female">Female</option>
									</select>
									</spring:bind>
								</div>
								<div class="form-group col-md-6">
									<spring:bind path="doctor.currentPost">
									Current post<input id="CurrentPost" name="currentPost" autocomplete="off" required="required"
										placeholder="Current Post" class="form-control" type="text">
									</spring:bind>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<spring:bind path="user.aadharNo">
									Aadhar No<input id="Aadhar" name="aadharNo" required="required" placeholder="Addhar No"
										pattern=".{12}"
										title="plaease enter valid AdharNo and no space between number"
										class="form-control" type="number" autocomplete="off">
									</spring:bind>
									<!-- ajax response -->
                                     		<div id="ajaxResponse2" style="color:red"></div>
								</div>
								<div class="form-group col-md-6">
									<spring:bind path="user.dob">
									Date Of Birth<input type="date" min="1948-01-01" max="1996-12-31" class="form-control" id="dateofbirth"
									name="dob" autocomplete="off"
										placeholder="Dateofbirth">
									</spring:bind>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<spring:bind path="doctor.degree">
							Degree<select id="inputState" name="degree" required="required" class="form-control">
                                                <option selected>Degree</option>
                                                <option value="Bachelor of Medicine,Bachelor of surgery(MBBS)">Bachelor of Medicine,Bachelor of surgery(MBBS) </option>
                                                <option value="Bachelor of Dental Surgery(BDS)"> Bachelor of Dental Surgery(BDS)</option>
                                        		<option value=" Bachelor of Ayurvedic Medicine and Surgery(BAMS)">  Bachelor of Ayurvedic Medicine and Surgery(BAMS) </option>
                                                <option value="Bachelor of Unani Medicine and Surgery(BUMS)"> Bachelor of Unani Medicine and Surgery(BUMS)Hematologists </option>
                                                <option value="Bachelor of Homeopathy Medicine and Surgery(BHMS)"> Bachelor of Homeopathy Medicine and Surgery(BHMS) </option>
                                                <option value="Doctor of Medicine (MD)"> Doctor of Medicine (MD) </option>
                                                <option value="Masters of Surgery (MS)"> Masters of Surgery (MS) </option>
                                                <option value="Diplomate of National Board(DNB)"> Diplomate of National Board(DNB) </option>
                                                <option value="Doctor of Osteopathic Medicine(DO)"> Doctor of Osteopathic Medicine(DO)Allergists/Immunologists </option>
                                                <option value="Doctor of Surgery(DS)"> Doctor of Surgery(DS) </option>
                                                <option value="Other"> Other </option>
                                              </select><!-- required removed required="required" -->
									</spring:bind>
								</div>
								<div class="form-group col-md-6">
									<spring:bind path="uploadFile.fileDegree">
									Degree Image<input id="DegreeImg" name="fileDegree"  accept=".pdf|image/*" required="required" placeholder="Degree"
										class="form-control" autocomplete="off" type="file"><!-- changed  from file to text required removed required="required" -->
									</spring:bind>
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-6">
									<spring:bind path="doctor.license">
									License<input id="License" name="license" required="required" placeholder="License"
										class="form-control" autocomplete="off"  type="text"><!-- required removed required="required" -->
									</spring:bind>
								</div>
								<div class="form-group col-md-6">
									<spring:bind path="uploadFile.fileLicense">
									License Image<input id="LicenseImg" name="fileLicense" accept=".pdf|image/*" required="required" placeholder="License"
										class="form-control" autocomplete="off" type="file"><!-- changed  from file to text required removed required="required" -->
									</spring:bind>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<spring:bind path="doctor.yearsOfExperience">
									Years Of Experience<input id="YearsOfExp" name="yearsOfExperience" min="0" max="50"
										placeholder="Year of Experince" class="form-control" autocomplete="off"
										type="number">
									</spring:bind>
								</div>
								<div class="form-group col-md-3">
									Practice Hours
									<spring:bind path="doctor.practiceHoursStart">
									<input id="ParcticeHours" required="required" name="practiceHoursStart"
										placeholder="Parctice Hours" class="form-control" type="time">
									</spring:bind>
								</div>
								<div class="form-group col-md-3">
									<br/>
									<spring:bind path="doctor.practiceHoursEnd">
									<input id="ParcticeHours" name="practiceHoursEnd"
										placeholder="Parctice Hours" required="required" class="form-control" type="time">
									</spring:bind>
								</div>
							</div>

							<div class="form-row">
								<div class="form-group col-md-6">
									<spring:bind path="doctor.specialization">
									Specialization<select id="inputState" name="specialization" required="required" class="form-control">
                                                <option selected>Specialization</option>
                                                <option value="Dermatologists">Dermatologists </option>
                                                <option value="Family Physicians"> Family Physicians</option>
                                        		<option value="Gastroenterologists"> Gastroenterologists </option>
                                                <option value="Hematologists"> Hematologists </option>
                                                <option value="Neurologists"> Neurologists </option>
                                                <option value="Rheumatologists"> Rheumatologists </option>
                                                <option value="Urologists"> Urologists </option>
                                                <option value="Anesthesiologists"> Anesthesiologists </option>
                                                <option value="Allergists/Immunologists"> Allergists/Immunologists </option>
                                                <option value="Cardiologists"> Cardiologists </option>
                                                <option value="Obstetricians"> Obstetricians </option>
                                                <option value="Gynecologists">Gynecologists </option>
                                                 <option value="Psychiatrists">Psychiatrists </option>
                                                <option value="Other"> Other </option>
                                              </select>
									</spring:bind>
								</div>
								<div class="form-group col-md-6">
									<spring:bind path="doctor.awards">
									Achivements<input id="Awards" name="awards" placeholder="Achivements"
										class="form-control" autocomplete="off" type="text">
									</spring:bind>
								</div>
							</div>
							

							<div class="form-row">
								
								<div class="form-group col-md-6">
									<label>Preferred language</label>
									<div class="checkbox">
						
										<label><input name="prefLanguage" type="checkbox" value="1"> English</label>
									</div>
									<div class="checkbox">
										<label><input name="prefLanguage" type="checkbox" value="3"> Marathi</label>
									</div>
									<div class="checkbox">
										<label><input name="prefLanguage" type="checkbox" value="2"> Hindi</label>
									</div>
									
								</div>
							</div>

							<div class="form-row">
								<div class="form-group">
									<div class="form-group">
										<div class="form-check">
											<input class="form-check-input" type="checkbox" value=""
												id="invalidCheck2" required> <label
												class="form-check-label" for="invalidCheck2"> <small>By
													clicking Submit, you agree to our Terms & Conditions,
													Visitor Agreement and Privacy Policy.</small>
											</label>
										</div>
									</div>

								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-4">
									<input type="submit" value="Sign Up" class="btn btn-danger">
								</div>
								<div class="form-group col-md-4"></div>
								<div class="form-group col-md-4">

									<a href='login_form'><button class="btn btn-primary">Login</button></a>
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
			<p class="m-0 text-center text-white">Copyright &copy; Your
				Website 2019</p>
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
	$(document).ready(function() {
		$('#Aadhar').blur(function() {
			$.ajax({
				url : 'getAadharAjax',
				data : {
					aadhar : $('#Aadhar').val()
				},
				success : function(responseText) {
					$('#ajaxResponse2').text(responseText);
				}
			});
		});
	});
	$(document).ready(function() {
		$('#Contact').blur(function() {
			$.ajax({
				url : 'getContactAjax',
				data : {
					contact : $('#Contact').val()
				},
				success : function(responseText) {
					$('#ajaxResponse3').text(responseText);
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