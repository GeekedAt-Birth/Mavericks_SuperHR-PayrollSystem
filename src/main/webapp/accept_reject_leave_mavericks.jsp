<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Forms</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</head>
<body>
	<nav class="navbar navbar-light bg-light">
		<a class="nav-brand" href="/admin_mavericks">Back to Admin Page</a> <a
			class="nav-brand" href="/register">Register Employee</a> <a
			class="nav-brand" href="/jobs">Manage Jobs</a>
		<form class="form-signin" action="logout">
			<div class="text-right mb-3">
				<button class="btn btn-primary btn-sm" type="submit">Logout</button>
			</div>
		</form>
	</nav>
	<div class="container">
		<br>
		<h1 class="h3 mb-3 font-weight-normal">Leave Forms</h1>
	</div>
	<br />
	<div class="container">
		<form:form name="leaveForm" modelAttribute="leave" action="/processLeave">
			<h5>Pending Leave Forms</h5>
			<c:forEach var="pending" items="${pending}">
				<table class="table table-striped table-bordered">
					<tr>
						<td>Employee ID</td>
						<td>${pending.employeeId}</td>
					</tr>
					<tr>
						<td>Start Date</td>
						<td>${pending.startDate}</td>
					</tr>
					<tr>
						<td>End Date</td>
						<td>${pending.endDate}</td>
					</tr>
					<tr>
						<td>Days</td>
						<td>${pending.days}</td>
					</tr>
					<tr>
						<td>Reason</td>
						<td>${pending.reason}</td>
					</tr>
					<tr>
						<td>Leave Type</td>
						<td>${pending.leaveType}</td>
					</tr>
					<tr>
						<td>Application ID</td>
						<td>${pending.id}</td>
					</tr>
					<tr>
						<td><button type="submit" class="btn btn-sm" style="background-color:red; color:white" formaction="/processLeave?id=${pending.id}" name="applicationStatus" value="reject">Reject</button></td>
						<td><button type="submit" class="btn btn-sm" style="background-color:green; color:white" formaction="/processLeave?id=${pending.id}" name="applicationStatus" value="approve">Approve</button></td>
					</tr>
				</table>
			</c:forEach>
		</form:form>
	</div>
	<br />
	<div class="container">
		<h5 style="color: green">Accepted Leave Forms</h5>
		<c:forEach var="accepted" items="${accepted}">
			<table class="table table-striped table-bordered">
				<tr>
					<td>Employee ID</td>
					<td>${accepted.employeeId}</td>
				</tr>
				<tr>
					<td>Start Date</td>
					<td>${accepted.startDate}</td>
				</tr>
				<tr>
					<td>End Date</td>
					<td>${accepted.endDate}</td>
				</tr>
				<tr>
					<td>Days</td>
					<td>${accepted.days}</td>
				</tr>
				<tr>
					<td>Reason</td>
					<td>${accepted.reason}</td>
				</tr>
				<tr>
					<td>Leave Type</td>
					<td>${accepted.leaveType}</td>
				</tr>
				<tr>
					<td>Application ID</td>
					<td>${accepted.id}</td>
				</tr>
			</table>
		</c:forEach>
	</div>
	<br />
	<div class="container">
		<h5 style="color: red">Rejected Leave Forms</h5>
		<c:forEach var="rejected" items="${rejected}">
			<table class="table table-striped table-bordered">
				<tr>
					<td>Employee ID</td>
					<td>${rejected.employeeId}</td>
				</tr>
				<tr>
					<td>Start Date</td>
					<td>${rejected.startDate}</td>
				</tr>
				<tr>
					<td>End Date</td>
					<td>${rejected.endDate}</td>
				</tr>
				<tr>
					<td>Days</td>
					<td>${rejected.days}</td>
				</tr>
				<tr>
					<td>Reason</td>
					<td>${rejected.reason}</td>
				</tr>
				<tr>
					<td>Leave Type</td>
					<td>${rejected.leaveType}</td>
				</tr>
				<tr>
					<td>Application ID</td>
					<td>${rejected.id}</td>
				</tr>
			</table>
		</c:forEach>
	</div>
	<div class="mx-auto">
		<p class="mt-5 mb-3 text-muted text-center">&copy; Mavericks-2020</p>
	</div>
</body>
</html>