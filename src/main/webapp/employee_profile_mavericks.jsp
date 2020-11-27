<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
					<li class="list-group-item">Salary Per day -
						${job.salaryPerDay}</li>
				</ul>
			</div>
			<div class="card" style="width: 18rem;">
				<div class="card-header">Pay Information</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item">Holidays - ${pay.holidays}</li>
					<li class="list-group-item">Sick Days - ${pay.sickDays}</li>
					<li class="list-group-item">Last Pay Date - <fmt:formatDate
							value="${pay.endDate}" pattern="yyyy-MM-dd" /></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container m-5 p-5">
		<div class="card border-dark">
			<div class="card-header">
				<h4>
					Leave Applications
					<button style="float: right;" type="button"
						class="btn btn-outline-info" data-toggle="modal"
						data-target="#exampleModal">Leave Application Form</button>
				</h4>
			</div>
			<div class="row">
				<c:forEach var="leave" items="${leaveForms}">
					<div class="card-body">
						<div class="card bg-info border-dark">
							<h6 class="card-header text-white">Application Status:
								${leave.applicationStatus}</h6>
							<ul class="list-group list-group-flush ">
								<li class="list-group-item">Start Date: <fmt:formatDate
										value="${leave.startDate}" pattern="yyyy-MM-dd" /></li>
								<li class="list-group-item">End Date: <fmt:formatDate
										value="${leave.endDate}" pattern="yyyy-MM-dd" /></li>
								<li class="list-group-item">Reason: ${leave.reason}</li>
								<li class="list-group-item">Leave type: ${leave.leaveType}</li>
							</ul>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>


	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Leave
						Application Form</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form:form action="leaveApplication" method="POST"
						modelAttribute="leave" id="leaveApplication-form">
						<div class="form-group">
							<div class="form-group row">
								<h6>
									EmployeeID: ${user.id}<br> <br>Username:
									${user.username}
								</h6>
							</div>
							<div class="form-group row">
								<label for="inputStartDate" class="col-sm-2 col-form-label">Select
									Start Date:</label> <input type="date" name="startDate"
									class="form-control col-sm-8" id="inputStartDate" onchange = "setMinEndDate()" required>
								<form:errors path="startDate" style="color:red" />
							</div>
							<div class="form-group row">
								<label for="inputEndDate" class="col-sm-2 col-form-label">Select
									End Date:</label> <input type="date" name="endDate"
									class="form-control col-sm-8" id="inputEndDate"  required>
								<form:errors path="endDate" style="color:red" />
							</div>

							<div class="form-group row">
								<div class="col-sm-2">Check Leave Type:</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" name="leaveType"
										type="checkbox" value="sick days" id="inputSickDay"
										onchange="uncheck(this)"> <label
										class="form-check-label" for="inputSickDay">Sick Day</label>
									<form:errors path="leaveType" style="color:red" />
								</div>
								<div class="form-check form-check-inline">
									<input class="form-check-input" name="leaveType"
										type="checkbox" value="holidays" id="inputHoliday"
										onchange="uncheck(this)"> <label
										class="form-check-label" for="inputHoliday">Holiday</label>
									<form:errors path="leaveType" style="color:red" />
								</div>
							</div>

							<div class="form-group row">
								<label for="inputReason" class="col-sm-2 col-form-label">Reason
									For Leave:</label>
								<textarea class="form-control col-sm-8" name="reason"
									id="inputReason" required></textarea>
								<form:errors path="reason" style="color:red" />
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
			document.getElementById("leaveApplication-form").submit();
		}
		function uncheck(obj) {
			var check = document.getElementsByClassName("form-check-input");
			for (var i = 0; i < check.length; i++) {
				check[i].checked = false;
			}
			obj.checked = true;
		}
		function setMinEndDate(){
			document.getElementById("inputEndDate").min = document.getElementById("inputStartDate").value;
		}
	</script>
</html>

