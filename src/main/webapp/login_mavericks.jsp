<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<link href="/css/bootstrap.min.css" rel="stylesheet">
<link href="/css/signup.css" rel="stylesheet">
<script src="/js/jquery-1.11.1.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
</head>
<body class="text-center">
	<form class="form-signin" method="post" action="login">
		<h1 class="h3 mb-3 font-weight-normal">Login</h1>
		
		<c:if test="${error!= null}">
			<div class="alert alert-danger" role="alert">
				${error}
			</div>
		</c:if>
		
		<label for="inputUsername" class="sr-only">Username</label> 
		<input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus> 
		
		<label for="inputPassword" class="sr-only">Password</label> 
		<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
		
		<button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
		<p class="mt-5 mb-3 text-muted">&copy; Mavericks-2020</p>
	</form>	
</html>
