<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee Information</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>

</head>
<body>
	<nav class="navbar navbar-light bg-light">
	<a class="nav-brand" href="/admin_mavericks">Back to Admin Page</a> <a
		class="nav-brand" href="/register">Register Employee</a>
	<form class="form-signin" action="logout">
		<div class="text-right mb-3">
			<button class="btn btn-primary btn-sm " type="submit">Logout</button>
		</div>
	</form>
	</nav>
	<div class="container">
		<form:form action="updateEmployeeInformation" method="POST" modelAttribute="user" id="user-update-form">
		<h1 class="h3 mb-3 font-weight-normal">Update Employee Information</h1>
		 <div class="form-group">
		 <div class="form-group row">
				<label for="inputUserId" class="col-sm-3 col-form-label">UserID</label> 
				<input value="${user.id}" class="form-control col-sm-8" type="text" name="id" id="inputUserId" readonly>
				<form:errors path="id" style="color:red" />
			</div>
		 	<div class="form-group row">
				<label for="inputUserName" class="col-sm-3 col-form-label">Username</label> 
				<input value="${user.username}" class="form-control col-sm-8" type="text" name="username" id="inputUserName">
				<form:errors path="username" style="color:red" />
			</div>
			<div class="form-group row">
				<label for="inputFirstName" class="col-sm-3 col-form-label">First Name</label> 
				<input value="${user.firstName}" class="form-control col-sm-8" type="text" name="firstName" id="inputFirstName">
				<form:errors path="firstName" style="color:red" />
			</div>

			<div class="form-group row">
				<label for="inputLastName" class="col-sm-3 col-form-label">Last Name</label>
				<input value="${user.lastName}" class="form-control col-sm-8" type="text" name="lastName" id="inputLastName">
				<form:errors path="lastName" style="color:red" />
			</div>

			<div class="form-group row">
				<label for="inputEmail" class="col-sm-3 col-form-label">Email Address</label>
				<input value="${user.email}" class="form-control col-sm-8" type="email" name="email" id="inputEmail">
				<form:errors path="email" style="color:red" />
			</div>
			<div class="form-group row">
				<label for="inputPassword" class="col-sm-3 col-form-label">Password</label> 
				<input value="${user.password}" class="form-control col-sm-8" type="password" name="password" id="inputPassword">
				<form:errors path="password" style="color:red" />
			</div>
			<div class="form-group row">
				<label for="inputConfirmPassword" class="col-sm-3 col-form-label">Confirm Password</label> 
				<input value="${user.confirm_password}" class="form-control col-sm-8" type="password" name="confirm_password" id="inputConfirmPassword">
				<form:errors path="confirm_password" style="color:red" />
			</div>

			<div class="form-group row">
				<label for="inputPhoneNumber" class="col-sm-3 col-form-label">Phone Number</label>
				<input value="${user.phoneNumber}" class="form-control col-sm-8" type="number" name="phoneNumber" id="inputPhoneNumber">
				<form:errors path="phoneNumber" style="color:red" />
			</div>
			<div class="form-group row">
			<label for="inputJobId" class="col-sm-3 col-form-label">Update Job</label>
			 <select id="inputJobId" name="jobId" class="form-control col-md-5 offset-1" required>
			   <c:forEach items="${jobs}" var="job" >
			   		<option value="${job.id}" >${job.title}</option>
			   </c:forEach>
		    </select>
		    </div>
			
			<button type="submit" class="btn btn-primary">Update</button>		
		</div>
	</form:form>
</div>
<div class="mx-auto">
		<p class="mt-5 mb-3 text-muted text-center">&copy; Mavericks-2020</p>
</div>

</body>
</html>