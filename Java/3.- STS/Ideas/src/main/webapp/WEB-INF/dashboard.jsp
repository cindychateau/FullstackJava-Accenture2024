<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
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
			<table class="table table-striped">
				<thead>
					<tr>
						<th>Idea</th>
						<th>Detalle</th>
						<th>Modificar</th>
						<th>Me Gusta</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${ideas}" var="idea" >
						<tr>
							<td>${idea.texto}</td>
							<td><a href="/mostrar/${idea.id}">Ver</a></td>
							<td>
								<c:if test="${idea.creador.id == usuarioEnSesion.id}">
									<a href="/editar/${idea.id}" >Editar</a>
								</c:if>
							</td>
							<td>
								<c:if test="${not idea.usuariosFav.contains(usuario)}">
							    	<a href="/meGusta/${usuarioEnSesion.id}/${idea.id}"><i class="far fa-heart"></i></a>
							    </c:if>
							    <c:if test="${idea.usuariosFav.contains(usuario)}">
							    	<a href="/quitarMeGusta/${usuarioEnSesion.id}/${idea.id}"><i class="fas fa-heart"></i></a>
							    </c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>