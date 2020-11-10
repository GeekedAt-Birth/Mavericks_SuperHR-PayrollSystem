<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</head>

<body>
	<nav class="navbar navbar-light bg-light">
		<h3>Welcome ${user.username}</h3>
		<form class="form-signin" method="post" action="logout">
			<div class="text-right mb-3">
				<button class="btn btn-primary btn-sm" type="submit">Logout</button>
			</div>
		</form>
	</nav>
	<div class="container">
		<div class="row">
			<c:if test="${error!= null}">
				<div class="alert alert-danger" role="alert">${error}</div>
			</c:if>
		</div>
	</div>
	<div class="container m-5 p-5">
		<div class="row">
			<div class="card mr-5" style="width: 18rem;">
				<div class="card-header">Personal Information
					<button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#exampleModal">Update Information</button>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">First Name - ${user.firstName}</li>
					<li class="list-group-item">Last Name - ${user.lastName}</li>
					<li class="list-group-item">Email address - ${user.email}</li>
					<li class="list-group-item">Phone Number - ${user.phoneNumber}</li>
				</ul>
			</div>
			<div class="card" style="width: 18rem;">
				<div class="card-header">Job Information</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">Job Title - ${job.title}</li>
					<li class="list-group-item">Salary Per day - ${job.salaryPerDay}</li>
				</ul>
			</div>
		</div>
	</div>

	<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Update Information</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form:form action="updateEmployeeProfile" method="POST" modelAttribute="user" id="user-update-form">
						<div class="form-group">
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
								<label for="inputPhoneNumber" class="col-sm-3 col-form-label">Phone Number</label>
								<input value="${user.phoneNumber}" class="form-control col-sm-8" type="number" name="phoneNumber" id="inputPhoneNumber">
								<form:errors path="phoneNumber" style="color:red" />
							</div>
						</div>
					</form:form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary"
						onclick="form_submit()">Submit</button>
				</div>
			</div>
		</div>
	</div>
	<script>
		function form_submit() {
			document.getElementById("user-update-form").submit();
		}
	</script>
</html>

