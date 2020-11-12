<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<a class="nav-brand" href="/register">Register Employee</a>
		<form class="form-signin" action="logout">
			<div class="text-right mb-3">
				<button class="btn btn-primary btn-sm " type="submit">Logout</button>
			</div>
		</form>
	</nav>
	<div class="container">
		<form action="/employee" method="post">
			<h1 class="h3 mb-3 font-weight-normal">Admin Profile</h1>
			<c:if test="${ message != null }" >
				<div class="alert alert-success" role="alert">${message}</div>
			 </c:if>
			<table class="table table-striped table-bordered">
				<tr>
					<td>Employee ID</td>
					<td>First Name</td>
					<td>Last Name</td>
					<td>Job ID</td>
					<td>Update</td>
					<td>Delete</td>
				</tr>
				<c:forEach var="user" items="${users}">
					<tr>
						<td><a href="/employee?userId=${user.id}">${user.id}</a></td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.jobId}</td>
						<td><a href="/updateEmployee/?userId=${user.id}">Update</a></td>
						<td><a href="/deleteEmployee/?userId=${user.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
		
	<div class="mx-auto">
		<p class="mt-5 mb-3 text-muted text-center">&copy; Mavericks-2020</p>
	</div>
</body>
</html>