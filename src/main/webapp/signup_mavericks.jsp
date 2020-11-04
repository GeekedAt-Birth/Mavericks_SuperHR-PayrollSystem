<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/signup.css" rel="stylesheet">
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</head>
<body class="text-center">
		<div class="container">
		
	<form class="form-signin" method="post" action="register">
		<h1 class="h3 mb-3 font-weight-normal">Register Employee</h1>
		
		<c:if test="${error!= null}">
			<div class="alert alert-danger" role="alert">
				${error}
			</div>
		</c:if>
		
		<div class="row">
			<input type="text" id="inputUsername" name="username" class="form-control col-md-5" placeholder="Username" required>  
			<input type="email" id="inputEmail" name="email" class="form-control col-md-5 offset-1" placeholder="Email address" required>
			
			<input type="text" id="inputFName" name="firstName" class="form-control col-md-5" placeholder="First Name" required> 
			<input type="text" id="inputLName" name="lastName" class="form-control col-md-5 offset-1" placeholder="Last Name" required> 
	 	
	 		<input type="number" id="inputPhoneNumber" name="phoneNumber" class="form-control col-md-5" placeholder="Phone Number" required>
 		    
 		    <select id="inputJobId" name="jobId" class="form-control col-md-5 offset-1" required>
			   <c:forEach items="${jobs}" var="job" >
			   		<option value="${job.id}">${job.title}</option>
			   </c:forEach>
		    </select>
 		   
			<input type="password" id="inputPassword" name="password" class="form-control col-md-11" placeholder="Password" required>	 
			<input type="password" id="inputConfirmPassword" name="confirm_password" class="form-control col-md-11" placeholder="Confirm Password" required>
			
			<div class="mx-auto">
				<button class="btn btn-primary btn-block" type="submit">Signup</button>
				<p class="mt-5 mb-3 text-muted text-center">&copy; Mavericks-2020</p>
			</div>
		</div>
	</form>	
	</div>
</html>
