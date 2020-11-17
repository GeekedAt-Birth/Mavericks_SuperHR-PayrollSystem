<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My Profile</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</head>

<body>
	<nav class="navbar navbar-light bg-light">
	<br>
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
				<div class="card-header">Personal Information</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">First Name - ${user.firstName}</li>
					<li class="list-group-item">Last Name - ${user.lastName}</li>
					<li class="list-group-item">Email address - ${user.email}</li>
					<li class="list-group-item">Phone Number - ${user.phoneNumber}</li>
				</ul>
			</div>
			<div class="card mr-5" style="width: 18rem;">
				<div class="card-header">Job Information</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">Job Title - ${job.title}</li>
					<li class="list-group-item">Salary Per day - ${job.salaryPerDay}</li>
				</ul>
			</div>
			<div class="card" style="width: 18rem;">
				<div class="card-header">Pay Information</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">Holidays - ${pay.holidays}</li>
					<li class="list-group-item">Sick Days - ${pay.sickDays}</li>
					<li class="list-group-item">Last Pay Date - <fmt:formatDate value="${pay.endDate}" pattern="yyyy-MM-dd" /></li>
				</ul>
			</div>
		</div>
	</div>
</html>

