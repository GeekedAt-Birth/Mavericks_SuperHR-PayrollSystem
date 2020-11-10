<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Information</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</head>

<body>
	<nav class="navbar navbar-light bg-light">
		<h3>${user.firstName} ${user.lastName}</h3>
		<form class="form-signin" method="post" action="logout">
			<div class="text-right mb-3">
				<button class="btn btn-primary btn-sm" type="submit">Logout</button>
			</div>
		</form>
	</nav>
	
	
	<table class="table table-striped table-bordered">
		<tr>
			<td>Job Title</td>
			<td><input type="text" value="${job.title}" id="title"></td>
		</tr>
		<tr>
			<td>Pay</td>
			<td>$<input type="text" value="${job.salaryPerDay}" id="pay">/day</td>
		</tr>
		<tr>
			<td>Paid/Pending</td>
			<td>Paid/Pending</td>
		</tr>
		<tr>
			<td>Sick Days</td>
			<td>Sick Days</td>
		</tr>
		<tr>
			<td>Holidays</td>
			<td>Holidays</td>
		</tr>
	</table>
	
	<button type="button" class="btn btn-primary">Save</button>
	
</body>
</html>