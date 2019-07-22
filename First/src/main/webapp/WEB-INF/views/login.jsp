<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login Foam</title>
    <!-- Bootstrap core CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
    
    <!--navbar-->
    <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-primary fixed-top">
            <div class="container">
              <a class="navbar-brand" href="index.html">Medico</a>
              <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarResponsive">
                <ul class="navbar-nav ml-auto">
                  <li class="nav-item">
                    <a class="nav-link" href="signup.html">Sign Up</a>
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
                                        <img src="https://lh3.googleusercontent.com/8g540BSYIHps3dUywQU09dTIOs2NNLme7Pg0tUjI6KnNm2VYCVFDI_nWZ_FmNboZj4fBucya-dGY2TNjxROMh7xIOAXKQ811bEnpRlcbKB8mBsgdx0EfDFHoXRktIwudg993_XXah7VabMqYFkNmGoR_1PBK5StKHgl0eUPIWdcBmZJfuCOwxFH9g5I0t9f49TRDqsL19s3SNLr8WSgaa2QB8yB98tNp102R4Th6QjNG7IBT0lGv6hDKlO_SSf9zOWcW9bm29CZHczzjH3SCr6hmbu6S9oYR_Hzdl5LVcrNrFEq2URfPA56ZnDKj2KgOVfJSnB8l91X3e-JG39Os3Zb_r7qrxDiS6h-q780sotQGPkg53VIRhusntEP4qqg1WwjWBuDwc1mXj9X-mcSuaOtbca3uztKFFjPBV2FdjCEAbSynCqFZqhNbhlqTaEUs3WG8fxOrkGC6HAV7SnmRIX74n9cUCCwnq79WXz2VwpIfL3nBAtB_ale6Oc_Y5YoiKHcyvTDTf-FDvDRmCUWtuVuaNNNXJJxEn7bQ42VwhfuaBDNHr9NyO1o90VthXUaP_VLovVHZYb6X2dmtxlgbQ9m7K35tgyOjPMFiKpWN_HBkTsGvbTSxxhSL1wcZXvSaGRl81Nn-mGMDS-nqIFV1aMuMRZpc9gliAUd8vly8n6bK2-SmelHT6wrkP3KtVsZZDIcaS4_7FIIm7omi1vwJAcQjsQ=w650-h520-no" style="width:90%">
                                        <h2 class="py-3">Login In</h2>
                                        <p>Tation argumentum et usu, dicit viderer evertitur te has. Eu dictas concludaturque usu, facete detracto patrioque an per, lucilius pertinacia eu vel.
               </p>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-8 py-5 border">
                                <h4 class="pb-4">Login Page</h4>
                                <!-- form -->
                                <form:form action="login__form" modelAttribute="user" method="post">
                                    <div class="form-row">
                                        <div class="form-group col-md-12">
                                        
                                        <spring:message text="Email Address" var='emailIdPlace' />
                                          <form:input path="emailId" class="form-control" id="inputEmail4" placeholder="${emailIdPlace}"/>
                                     		<!-- ajax response -->
                                     		<div id="ajaxResponse" style="color:red"></div>
                                        </div>
                                        <div class="form-group col-md-12">
                                       <spring:message text="Password" var='passwordPlace' />
                                          <form:password path="password" class="form-control"  placeholder="${passwordPlace}"/>
                                        </div>
                                      </div>
                                      <!-- wrong password -->
										<div style="color:red">${message}</div>
                                    <div class="form-row">
                                        <input type="submit" value="login" class="btn btn-danger">
                                    </div>
                                </form:form>
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
				url : 'getEmail',
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

</body>
</html>