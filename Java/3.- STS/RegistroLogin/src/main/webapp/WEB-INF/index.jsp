<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro y Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h2>Registrar</h2>
				<form:form action="/registro" method="POST" modelAttribute="nuevoUsuario" >
					<div>
						<form:label path="nombre" >Nombre:</form:label>
						<form:input path="nombre" class="form-control" />
						<form:errors path="nombre" class="text-danger" />
					</div>
					<div>
						<form:label path="apellido" >Apellido:</form:label>
						<form:input path="apellido" class="form-control" />
						<form:errors path="apellido" class="text-danger" />
					</div>
					<div>
						<form:label path="email" >Email:</form:label>
						<form:input path="email" class="form-control" />
						<form:errors path="email" class="text-danger" />
					</div>
					<div>
						<form:label path="password" >Password:</form:label>
						<form:password path="password" class="form-control" />
						<form:errors path="password" class="text-danger" />
					</div>
					<div>
						<form:label path="confirmacion" >Conf. Password:</form:label>
						<form:password path="confirmacion" class="form-control" />
						<form:errors path="confirmacion" class="text-danger" />
					</div>
					<input type="submit" class="btn btn-primary mt-3" value="Registrarme" >
				</form:form>
			</div>
			<div class="col-6">
				<h2>Iniciar Sesión</h2>
				<form:form action="/login" method="POST" modelAttribute="loginUsuario" >
					<div>
						<form:label path="emailLogin" >E-mail:</form:label>
						<form:input path="emailLogin" class="form-control" />
						<form:errors path="emailLogin" class="text-danger" />
					</div>
					<div>
						<form:label path="passwordLogin" >Password:</form:label>
						<form:password path="passwordLogin" class="form-control" />
						<form:errors path="passwordLogin" class="text-danger" />
					</div>
					<input type="submit" class="btn btn-info mt-3" value="Iniciar Sesión" >
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>