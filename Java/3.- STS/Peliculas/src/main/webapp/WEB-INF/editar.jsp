<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> <!-- Me permite mostrar errores en las ediciones --> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Peli</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<header class="d-flex justify-content-between align-items-center">
			<h1>¡Bienvenid@ ${usuarioEnSesion.nombre} !</h1>
			
			<a href="/favoritos" >Favoritos</a>
			
			<a href="/dashboard">Pelis</a>
			
			<a href="/nuevo">Agregar</a>
			
			<a href="/logout" class="btn btn-danger">Cerrar Sesión</a>
		</header>
		<div class="row">
			<h2>Editar Película</h2>
			<form:form action="/actualizar/${pelicula.id}" method="POST" modelAttribute="pelicula" >
				<input type="hidden" name="_method" value="PUT" > <!-- Sobreescribo el método: PUT -->
				<div>
					<form:label path="titulo">Título:</form:label>
					<form:input path="titulo" class="form-control" />
					<form:errors path="titulo" class="text-danger" />
				</div>
				<div>
					<form:label path="anio">Año:</form:label>
					<form:input path="anio" class="form-control" />
					<form:errors path="anio" class="text-danger" />
				</div>
				<div>
					<form:label path="director">Director:</form:label>
					<form:input path="director" class="form-control" />
					<form:errors path="director" class="text-danger" />
				</div>
				<div>
					<form:label path="urlImagen">URL Imagen:</form:label>
					<form:input path="urlImagen" class="form-control" />
					<form:errors path="urlImagen" class="text-danger" />
				</div>
				<div>
					<form:label path="sinopsis">Sinopsis:</form:label>
					<form:textarea path="sinopsis" class="form-control" />
					<form:errors path="sinopsis" class="text-danger" />
				</div>
				<form:hidden path="creador" value="${usuarioEnSesion.id}" />
				<input type="submit" class="btn btn-success mt-3" value="Guardar" >
			</form:form>
			<form action="/borrar/${pelicula.id}" method="POST" >
				<input type="hidden" name="_method" value="DELETE" >
				<input type="submit" value="Borrar" class="btn btn-danger" >
			</form>
		</div>
	</div>
</body>
</html>