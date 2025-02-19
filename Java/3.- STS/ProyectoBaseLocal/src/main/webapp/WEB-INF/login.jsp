<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio de Sesión</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<header class="d-flex justify-content-between align-center">
			<h1>Iniciar Sesión</h1>
			<a href="/login">Login</a>
			<a href="/">Registro</a>
		</header>
		<div class="row">
			<form:form action="/iniciarSesion" method="POST" modelAttribute="loginUsuario">
				<div>
					<form:label path="emailLogin">E-mail:</form:label>
					<form:input path="emailLogin" class="form-control" />
					<form:errors path="emailLogin" class="text-danger" />
				</div>
				<div>
					<form:label path="passwordLogin">Password:</form:label>
					<form:password path="passwordLogin" class="form-control" />
					<form:errors path="passwordLogin" class="text-danger" />
				</div>
				<input type="submit" class="btn btn-info mt-3" value="Iniciar Sesión" >
			</form:form>
		</div>
	</div>
</body>
</html>