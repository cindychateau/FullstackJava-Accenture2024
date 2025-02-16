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
			<h2>${idea.texto}</h2>
			<div class="col-6">
				<p><b>Usuario que publicó:</b>${idea.creador.nombre} ${idea.creador.apellido}</p>
				<p><b>Categoría:</b>${idea.categoria}</p>
				<p><b>Detalles:</b>${idea.detalles}</p>
			</div>
			<div class="col-6">
				<p><b>Usuario que dieron Me Gusta:</b></p>
				<ul>
					<c:forEach items="${idea.usuariosFav}" var="usuario">
						<li>${usuario.nombre} ${usuario.apellido}</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="row">
			<h3>Comentarios</h3>
			<c:forEach items="${idea.comentarios}" var="comentario">
				<p><b>${comentario.usuario.nombre}:</b> ${comentario.contenido}</p>
			</c:forEach>
			
			<form:form action="/agregarComentario" method="POST" modelAttribute="nuevoComentario">
				<form:textarea path="contenido" placeholder="Escribe tu comentario..." class="form-control"/>
				<form:errors path="contenido" class="text-danger" />
				<form:hidden path="usuario" value="${usuarioEnSesion.id}" />
				<form:hidden path="idea" value="${idea.id}" />
				<input type="submit" class="btn btn-primary mt-3" value="Enviar" >
			</form:form>
		</div>
	</div>
</body>
</html>