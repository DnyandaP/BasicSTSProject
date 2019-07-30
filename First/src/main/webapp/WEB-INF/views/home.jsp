<%@page import="com.team.medico.model.Disease"%>
<%@page import="com.team.medico.model.User"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spr"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="no-cache-store.jsp" %>  
<%@ page errorPage="error.jsp" %>  
<!DOCTYPE html>
<html lang="en">

<head>

 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Medico</title>
    <!-- Bootstrap core CSS -->
     <link href="<c:url value="/resources/vendor/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
    <!-- Bootstrap core CSS -->
	<!-- Custom styles for this template -->
  <link href="<c:url value="/resources/css/modern-business.css" />" rel="stylesheet">

</head>

<body>

  <!-- Navigation -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-primary fixed-top">
    <div class="container">
      <a class="navbar-brand" href="/medico">Medico</a>
      <%
		User loggedUser = (User)session.getAttribute("user");
		if(loggedUser !=null && loggedUser.getEmailId()!=null){
		User user  = (User)session.getAttribute("user");
	%>
      <a href="back"><h5 class="text-white mt-2"><%=user.getUserName() %></h5></a>
      <%
	}
      %>
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
                    </div>
          </li> 
          <li class="nav-item">
            <a class="nav-link" href="login_form">Login</a>
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

  <!-- Page Content -->
  <div class="container">
    <!----Sytomas checkar---->
    <section class="testimonial py-5" id="testimonial">
      <div class="container">
          <div class="row ">
              <div class="col-md-4 py-5 bg-primary text-white text-center ">
                  <div class=" ">
                      <div class="card-body">
 									<img src="https://lh3.googleusercontent.com/8g540BSYIHps3dUywQU09dTIOs2NNLme7Pg0tUjI6KnNm2VYCVFDI_nWZ_FmNboZj4fBucya-dGY2TNjxROMh7xIOAXKQ811bEnpRlcbKB8mBsgdx0EfDFHoXRktIwudg993_XXah7VabMqYFkNmGoR_1PBK5StKHgl0eUPIWdcBmZJfuCOwxFH9g5I0t9f49TRDqsL19s3SNLr8WSgaa2QB8yB98tNp102R4Th6QjNG7IBT0lGv6hDKlO_SSf9zOWcW9bm29CZHczzjH3SCr6hmbu6S9oYR_Hzdl5LVcrNrFEq2URfPA56ZnDKj2KgOVfJSnB8l91X3e-JG39Os3Zb_r7qrxDiS6h-q780sotQGPkg53VIRhusntEP4qqg1WwjWBuDwc1mXj9X-mcSuaOtbca3uztKFFjPBV2FdjCEAbSynCqFZqhNbhlqTaEUs3WG8fxOrkGC6HAV7SnmRIX74n9cUCCwnq79WXz2VwpIfL3nBAtB_ale6Oc_Y5YoiKHcyvTDTf-FDvDRmCUWtuVuaNNNXJJxEn7bQ42VwhfuaBDNHr9NyO1o90VthXUaP_VLovVHZYb6X2dmtxlgbQ9m7K35tgyOjPMFiKpWN_HBkTsGvbTSxxhSL1wcZXvSaGRl81Nn-mGMDS-nqIFV1aMuMRZpc9gliAUd8vly8n6bK2-SmelHT6wrkP3KtVsZZDIcaS4_7FIIm7omi1vwJAcQjsQ=w650-h520-no"
									style="width: 70%">             
			             <h2 class="py-3">Symptoms Checker</h2>
                          <p>Medico provides you with platform where you get easy access to health related requiremnets and information
 </p>
                      </div>
                  </div>
              </div>
              <div class="col-md-8 py-5 border">
                  <h4 class="pb-4">Symptoms Checker</h4>
                  <spr:form action="searchResult" modelAttribute="symptom">
                      <div class="form-row">
                          <div class="form-group col-md-12">
                                    
                                <s:bind path="symptom.SymptomsId">
								<spr:select path="SymptomsId" multiple="multiple">
									<c:forEach items="${symptomsList}" var="symp">
										<spr:option value="${symp.getSymptomsId()}">${symp.getSymptomsName()}</spr:option>
									</c:forEach>
								</spr:select>
								</s:bind>
                          </div>
                          
                      </div>
                      <div class="form-row">
                          <button type="submit"   class="btn btn-danger">Search</button>
                      </div>
					  <div  id="Checkar1" class="form-group col-md-12" style="">
                            		
									<%
									Disease disease=(Disease)request.getAttribute("diseaseResult");
									if(disease!=null)
									{
										
									%>
										<h6><%=disease.getDiseaseName().toUpperCase() %></h6>
										<h6><%=disease.getDescription() %></h6>
									<%}
									%>
							
                      </div>
                  </spr:form>
                  <div>
                  	<h6 class="text-danger">
                  		The information on this site is not intended or implied to be a substitute for professional medical advice, diagnosis or treatment. All content, including text, graphics, images and information, contained on or available through this web site is for general information purposes only.
                  		
                  	</h6>
                  </div>
              </div>
          </div>
      </div>
  </section>
  

    <!---End symtoms checkar-->
    <!-- Features Section -->
    <div class="row mb-4">
      <div class="col-lg-6">
        <h2>Medico Business Features</h2>
        <p>Doctor one Step Away</p>
        <ul>
          <li>Doctor consultation</li>
          <li>Video Calling</li>
          <li>Appointment Booking</li>
          <li>Notifying through Email</li>
          <li>Notifying through SMS</li>
        </ul>
        <p>Medico provides you with platform where you get easy access to health related requiremnets and information</p>
      </div>
      <div class="col-lg-6">
        <img class="img-fluid rounded" src="<c:url value="/resources/images/silde4.jpg" />" alt="">
      </div>
    </div>
    <!-- /.row -->

    

    </div>
  <!-- /.container -->

  <!-- Footer -->
  <footer class="py-5 bg-dark">
    <div class="container">
      <p class="m-0 text-center text-white">Copyright &copy; Your Website 2019</p>
    </div>
    <!-- /.container -->
  </footer>

  <!-- Bootstrap core JavaScript -->
  <c:url value="/resources/vendor/jquery/jquery.min.js" var="scrp"/>
  <script src="${scrp}"></script>
  <script src="<c:url value="resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />"></script>

</body>

</html>