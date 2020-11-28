<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Info</title>
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
	<br>
	<div class="container">
		<form:form action="updateEmployeeInfo" method="post"
			modelAttribute="pay">
			<h1 class="h3 mb-3 font-weight-normal">${user.firstName}
				${user.lastName}</h1>
			<h1 class="h3 mb-3 font-weight-normal">Employee ID: ${user.id}</h1>

			<input type="hidden" name="id" id="jobId" value="${job.id}" />
			<input type="hidden" name="payPeriod" id="jobPayPeriod"
				value="${job.payPeriod}" />
			<table class="table table-striped table-bordered">
				<tr>
					<td>Pay Period</td>
					<td><input type="date" name="startDate"
						value="<fmt:formatDate value="${pay.startDate}" pattern="yyyy-MM-dd" />" />
						- <input type="date" name="endDate"
						value="<fmt:formatDate value="${pay.endDate}" pattern="yyyy-MM-dd" />" /></td>
				</tr>
				<tr>
					<td>Job Title</td>
					<td>${job.title}</td>
				</tr>
				<tr>
					<td>Pay</td>
					<td>$${job.salaryPerDay}/day</td>
				</tr>
				<tr>
					<td><label for="inputSickDays">Sick Days</label></td>
					<td><input type="text" value="${pay.sickDays}" name="sickDays"
						id="inputSickDays" /> Days</td>
				</tr>
				<tr>
					<td><label for="inputHolidays">Holidays</label></td>
					<td><input type="text" value="${pay.holidays}" name="holidays"
						id="inputHolidays" /> Days</td>
				</tr>
			</table>
			<button type="submit" class="btn btn-primary">Save</button>
		</form:form>
	</div>

	<br />

	<div class="container">
		<div class="text-right">
			<span style="float: left;" class="h3 mb-3 font-weight-normal">Payment
				Pending</span> <br />
		</div>
		<c:choose>
			<c:when test="${pay.payStatus}">
				<h1>Already paid</h1>
			</c:when>
			<c:otherwise>
				<table class="table table-striped table-responsive">
					<tr>
						<td>Pay Period/# days</td>
						<td>10days</td>
					</tr>
					<tr>
						<td>Pay /day</td>
						<td>$${job.salaryPerDay}</td>
					</tr>
					<tr>
						<td>CPP</td>
						<td>${pay.benefitCPP}%</td>
					</tr>
					<tr>
						<td>EI</td>
						<td>${pay.benefitEI}%</td>
					</tr>
					<tr>
						<td>Income Tax</td>
						<td>${pay.incomeTax}%</td>
					</tr>

					<tr>
						<td>TOTAL PAYMENT</td>
						<td>$${totalPay}</td>
					</tr>
				</table>
				<a href="/processPayment?payId=${pay.id}"><button type="button" class="btn btn-outline-primary">PAY</button></a>
			</c:otherwise>
		</c:choose>
	</div>

	<div class="mx-auto">
		<p class="mt-5 mb-3 text-muted text-center">&copy; Mavericks-2020</p>
	</div>
</body>
</html>