<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign UP</title>
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>


<!-- Custom styles for this template -->
<link href="css/modern-business.css" rel="stylesheet">
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
                    <a class="nav-link" href="login.html">Login</a>
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
                                    <h2 class="py-3">Sign Up Patient</h2>
                                    <p>Tation argumentum et usu, dicit viderer evertitur te has. Eu dictas concludaturque usu, facete detracto patrioque an per, lucilius pertinacia eu vel.
           </p>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-8 py-5 border">
                            <h4 class="pb-4">Please fill with your details</h4>
                            <form>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                      <spring:bind path="user.userName">
									<input id="Full Name" name="userName" placeholder="Full Name"
										class="form-control" type="text">
									</spring:bind>
                                    </div>
                                    <div class="form-group col-md-6">
                                      <spring:bind path="user.emailId">
									<input type="email" name="emailId" pattern=".{8,}" title="8 or more character"
										class="form-control" id="inputEmail4" placeholder="Email">
									</spring:bind>
                                    </div>
                                </div>
                                
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                     <spring:bind path="user.password">
									<input id="Password" name="password" placeholder="Password"
										pattern=".{8,}" title="8 or more character"
										class="form-control" type="password">
									</spring:bind>
                                    </div>
                                    <div class="form-group col-md-6">
                                     <spring:bind path="user.aadharNo">
									<input id="Addhar" name="aadharNo" placeholder="Addhar No"
										pattern=".{18}"
										title="plaease enter valid AdharNo and no space between number"
										class="form-control" type="number">
									</spring:bind>
                                    </div>
                                </div>

                                <div class="form-row">
                                    <div class="form-group col-md-4">
                                        <input id="Weight" name="Weight" placeholder="Weight" class="form-control" required="required" type="number">
                                    </div>
                                    <div class="form-group col-md-4">
                                              <select id="inputState" class="form-control">
                                                <option selected>Blood Group</option>
                                                <option> A+ </option>
                                                <option> AB </option>
                                                <option> B+ </option>
                                                <option> O+ </option>
                                              </select>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <input id="dob" name="dob" placeholder="date of Birth" class="form-control" required="required" type="date">
                                    </div>
                                </div>
                                <div class="form-row">
                                        <div class="form-group col-md-6">
                                          <input id="CurrentMediaction" name="CurrentMediaction" placeholder="Current Mediaction" class="form-control" type="text">
                                        </div>
                                        <div class="form-group col-md-6">
                                              
                                              <select id="inputState" class="form-control">
                                                <option selected>Relationship With Patient</option>
                                                <option> Son </option>
                                                <option> Daughter  </option>
                                                <option> Wife </option>
                                                <option> 3 </option>
                                              </select>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <select id="MaritialStatus" class="form-control">
                                            <option selected>Maritial Status</option>
                                            <option value="Married"> Married </option>
                                            <option value="UnMarried"> UnMarried </option>
                                          </select>
                                    </div>
                                    <div class="form-group col-md-6">
                                          
                                          <select id="inputState" class="form-control">
                                            <option selected>Diet</option>
                                            <option> Vegan </option>
                                            <option> 1  </option>
                                            <option> 2 </option>
                                            <option> 3 </option>
                                          </select>
                                </div>
                              </div>
                              <div class="form-row">
                                  <div class="form-group col-md-6">
                                    <input id="Occupation" name="Occupation" placeholder="Occupation" class="form-control" type="text">
                                  </div>
                                  <div class="form-group col-md-6">
                                      <input id="Conatact" name="Conatact" placeholder="Conatact" class="form-control" type="number">
                                    </div>
                                  </div>
                                  <div class="form-row">
								
								<div class="form-group col-md-6">
									<label>Preferred language</label>
									<div class="checkbox">
						
										<label><input name="prefLanguage" type="checkbox" value="English">English</label>
									</div>
									<div class="checkbox">
										<label><input name="prefLanguage" type="checkbox" value="Marathi">Marathi</label>
									</div>
									<div class="checkbox">
										<label><input name="prefLanguage" type="checkbox" value="Hindi">Hindi</label>
									</div>
									
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
                                    <button type="button" class="btn btn-danger">Sign Up</button>
                                </div>
                                <div class="form-group col-md-4">
                                  
                               </div>
                                <div class="form-group col-md-4">
                                  <button type="button" class="btn btn-primary">Login</button>
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
</body>
</html>