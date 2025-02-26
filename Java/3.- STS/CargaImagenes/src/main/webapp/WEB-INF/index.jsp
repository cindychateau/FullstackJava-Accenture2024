<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Imágenes</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Imágenes</h1>
		<a href="/imagen/nueva" class="btn btn-success mb-3" >Nueva Imagen</a>
		<div class="row">
			<c:forEach items="${listaImagenes}" var="imagen" >
				<img src="/imagenes/${imagen.nombre}" class="img-fluid col-3 img-thumbnail" >
			</c:forEach>
		</div>
	</div>
</body>
</html>