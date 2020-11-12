<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jobs</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<a class="nav-brand" href="/admin_mavericks">Back to Admin Page</a> 
		<a class="nav-brand" href="/register">Register Employee</a>
		<form class="form-signin" action="logout">
			<div class="text-right mb-3">
				<button class="btn btn-primary btn-sm " type="submit">Logout</button>
			</div>
		</form>
	</nav>
	
	<c:if test="${message!= null}">
		<div class="alert alert-danger" role="alert">${message}</div>
	</c:if>
	
	<div class="container">
		<form action="/editJob" method="post">
			<h1 class="h3 mb-3 font-weight-normal">Jobs</h1>
			<table class="table table-striped table-bordered">
				<tr>
					<td>Job ID</td>
					<td>Title</td>
					<td>SalaryPerDay</td>
					<td>Edit</td>
					<td>Delete</td>
				</tr>
				<c:forEach var="job" items="${jobs}">
					<tr>
						<td>${job.id}</td>
						<td>${job.title}</td>
						<td>${job.salaryPerDay}</td>
						<td><a href="/updateJob?id=${job.id}">Edit</a></td>
						<td><a href="/deleteJob?id=${job.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	
	<h1 class="h3 mb-3 font-weight-normal">Add Job</h1>
	<form:form action="/createJob" method="post" modelAttribute="job">
		<table class="table table-striped table-bordered">
			<tr>
				<td>Title</td>
				<td><form:input type="text" path="title"/></td>
			</tr>
			<tr>
				<td>SalaryPerDay</td>
				<td><form:input type="text" path="salaryPerDay"/>/day</td>
			</tr>
		</table>
		<form:button type="submit" class="btn btn-primary">Save</form:button>
	</form:form>
	
	<div class="mx-auto">
		<p class="mt-5 mb-3 text-muted text-center">&copy; Mavericks-2020</p>
	</div>
</body>
</html>