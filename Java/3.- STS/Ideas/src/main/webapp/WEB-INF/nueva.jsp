<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<header class="d-flex justify-content-between align-items-center">
			<h1>¡Bienvenid@ ${usuarioEnSesion.nombre} !</h1>
			
			<a href="/favoritos">Favoritos</a>
			
			<a href="/dashboard">Todas</a>
			
			<a href="/nueva">Agregar</a>
			
			<a href="/logout" class="btn btn-danger">Cerrar Sesión</a>
		</header>
		<div class="row">
			<h2>Agregar Idea</h2>
			<form:form action="/guardar" method="POST" modelAttribute="idea" >
				<div>
					<form:label path="texto">Idea:</form:label>
					<form:input path="texto" class="form-control" />
					<form:errors path="texto" class="text-danger" />
				</div>
				<div>
					<form:label path="categoria">Categoría/Tema:</form:label>
					<form:input path="categoria" class="form-control" />
					<form:errors path="categoria" class="text-danger" />
				</div>
				<div>
					<form:label path="detalles">Detalles:</form:label>
					<form:input path="detalles" class="form-control" />
					<form:errors path="detalles" class="text-danger" />
				</div>
				<form:hidden value="${usuarioEnSesion.id}" path="creador" />
				<input type="submit" class="btn btn-success mt-3" value="Guardar" >
			</form:form>
		</div>
	</div>
</body>
</html>