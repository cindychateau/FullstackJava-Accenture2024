<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mostrar Peli - ${pelicula.titulo}</title>
<!-- BOOTSTRAP -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<!-- FONT AWESOME (iconos) -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css" integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
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
			<h2>${pelicula.titulo}</h2>
			<div class="card mb-3">
			  <div class="row g-0">
			    <div class="col-md-4">
			      <img src="${pelicula.urlImagen}" class="img-fluid rounded-start" alt="pelicula">
			    </div>
			    <div class="col-md-8">
			      <div class="card-body">
			        <p class="card-text">Director: ${pelicula.director}</p>
			        <p class="card-text"><small class="text-body-secondary">Año: ${pelicula.anio}</small></p>
			        <p class="card-text">Usuario creador: ${pelicula.creador.nombre}</p>
			        <p class="card-text">Sinopsis: ${pelicula.sinopsis}</p>
			      </div>
			    </div>
			  </div>
			  <div class="card-footer text-end">
			    <!-- Agregar a Fav -->
			    <c:if test="${not usuario.pelisFavoritas.contains(pelicula)}" >
			    	<a href="/agregarFavoritos/${usuario.id}/${pelicula.id}" ><i class="fa-regular fa-heart"></i></a>
			    </c:if>
			    
			    <c:if test="${usuario.pelisFavoritas.contains(pelicula)}" >
			    	<a href="/quitarFavoritos/${usuario.id}/${pelicula.id}" ><i class="fa-solid fa-heart"></i></a>
			    </c:if>
			  
			  </div>
			</div>
		</div>
		<div class="row">
			<div class="card mb-3">
				<h5 class="card-title">Usuarios que la tienen en favoritos</h5>
				<ul>
					<c:forEach items="${pelicula.usuarios}" var="usuarioFav">
						<li>${usuarioFav.nombre} ${usuarioFav.apellido}</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>