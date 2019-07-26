<%@page import="com.team.medico.model.User"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="no-cache-store.jsp" %> 
<%@ page errorPage="error.jsp" %>   
<%
	User loggedUser = (User)session.getAttribute("user");
	if(loggedUser !=null && loggedUser.getEmailId()!=null){
	User user  = (User)session.getAttribute("user"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Sign Up</title>
 <link href="${pageContext.request.contextPath}/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
	<!-- Custom styles for this template -->
  <link href="${pageContext.request.contextPath}/resources/css/modern-business.css" rel="stylesheet">
</head>
<body>
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
                            <%=user.getUserName() %>
                       
                            
                            <form action="saveCompleteProfile" method="post">
                                
                                
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                    
                                    <!-- weight -->
                                    <spring:bind path="patient.weight">
                                        <input id="Weight" name="weight" placeholder="weight" class="form-control" required="required" type="number">
                                    </spring:bind>
                                    </div>
                                    <div class="form-group col-md-6">
                                    		<spring:bind path="patient.bloodGroup">
                                              <select id="inputState" name="bloodGroup" required="required" class="form-control">
                                                <option selected>Blood Group</option>
                                                <option value="A+"> A+ </option>
                                                <option value="A-"> A- </option>
                                                <option value="AB+"> AB+ </option>
                                                <option value="AB-"> AB- </option>
                                                <option value="B+"> B+ </option>
                                                <option value="B-"> B- </option>
                                                <option value="O+"> O+ </option>
                                                <option value="O-"> O- </option>
                                                <option value="Other"> Other </option>
                                              </select>
                                           	 </spring:bind>
                                    </div>
                                </div>
                                <div class="form-row">
                                        <div class="form-group col-md-6">
                                        
                                        <!-- current medication -->
                                        <spring:bind path="patient.currentMedication">
                                          <input id="CurrentMediaction" name="currentMedication" placeholder="Current Mediaction" class="form-control" type="text">
                                        </spring:bind>
                                        </div>
                                        <div class="form-group col-md-6">
                                             <spring:bind path="patient.relationshipWithPatient">
                                              <select id="inputState" name="relationshipWithPatient" required="required" class="form-control">
                                                <option selected>Relationship With Patient</option>
                                                <option value="Son"> Son </option>
                                                <option value="Daughter"> Daughter  </option>
                                                <option value="Wife"> Wife </option>
                                                <option value="Husband"> Husband </option>
                                                <option value="Self"> Self </option>
                                                <option value="Other"> Other </option>
                                              </select>
                                             </spring:bind>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                    	 <spring:bind path="patient.maritalStatus">
                                        <select id="MaritialStatus" name="maritalStatus" required="required" class="form-control">
                                            <option selected>Maritial Status</option>
                                            <option value="Married"> Married </option>
                                            <option value="UnMarried"> UnMarried </option>
                                          </select>
                                          </spring:bind>
                                    </div>
                                    <div class="form-group col-md-6">
                                          
                                          <spring:bind path="patient.diet">
                                          <select id="inputState" name="diet" required="required" class="form-control">
                                            <option selected>Diet</option>
                                            <option value="vegan"> Vegan </option>
                                            <option value="Vegetarian"> Vegetarian  </option>
                                            <option value="Non-Vegetarian"> Non-Vegetarian </option>
                                            <option value="Other"> Other </option>
                                          </select>
                                          </spring:bind>
                                </div>
                              </div>
                              <div class="form-row">
                                  <div class="form-group col-md-6">
                                  <spring:bind path="patient.occupation">
                                    <input id="Occupation" name="occupation" placeholder="Occupation" class="form-control" type="text">
                                   </spring:bind>
                                  </div>
                                  </div>
                                  
								<div class="form-row">
                                  <div class="form-group col-md-6">
                                  	<spring:bind path="history.timePeriodMonths">
                                    <input id="timePeriodMonths" name="timePeriodMonths" placeholder="timePeriodMonths" class="form-control" type="number">
                                  	</spring:bind>
                                  </div>
                                  <div class="form-group col-md-6">
                                  	  <spring:bind path="history.previousDoctor">	
                                      <input id="previousDoctor" name="previousDoctor" placeholder="previousDoctor" class="form-control" type="text">
										</spring:bind>                                  
                                  </div>
                              </div>
                              <div class="form-row">
                                  <div class="form-group col-md-6">
                                  	<spring:bind path="history.startMonth">
                                      Initiate Date<input id="startMonth" name="startMonth" placeholder="startMonth" class="form-control" type="date">
                                  	</spring:bind>
                                  </div>
                              </div>
                             
                              <div class="form-row">
                                  <div class="form-group col-md-6">
                                  	<spring:bind path="history.diseaseType">
                                    <input id="diseaseType" name="diseaseType" placeholder="diseaseType" class="form-control" type="text">
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
                                    <input type="submit" value="Submit" class="btn btn-danger">
                                </div>
                                <div class="form-group col-md-4">
                                  
                               </div>
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </section>

</body>
</html>
<% 
	}else{
	response.sendRedirect("logout");	
	}
%>