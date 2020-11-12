<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Job</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<a class="nav-brand" href="/jobs">Back to Jobs Page</a>
		<form class="form-signin" action="logout">
			<div class="text-right mb-3">
				<button class="btn btn-primary btn-sm " type="submit">Logout</button>
			</div>
		</form>
	</nav>
		<div class="container">
		<form:form action="updateJob" method="POST" modelAttribute="job">
		
			<h1 class="h3 mb-3 font-weight-normal">Update Job ${job.title}</h1>
			<table class="table table-striped table-bordered">
				<tr>
					<td>Title</td>
					<td><input type="text" value="${job.title}" name="title" id="title"/></td>
				</tr>
				<tr>
					<td>Salary Per Day</td>
					<td><input type="text" value="${job.salaryPerDay}" name="salaryPerDay" id="salaryPerDay"/></td>
				</tr>
			</table>
			<button type="submit" class="btn btn-primary">Save</button>
		</form:form>
	</div>
		
	<div class="mx-auto">
		<p class="mt-5 mb-3 text-muted text-center">&copy; Mavericks-2020</p>
	</div>
</body>
</html>