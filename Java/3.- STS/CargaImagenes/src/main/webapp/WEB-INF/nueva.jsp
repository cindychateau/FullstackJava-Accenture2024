<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario de Imagen</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Nueva Imagen</h1>
		<form action="/imagen/cargar" method="POST" enctype="multipart/form-data" >
			<div>
				<label>Imagen:</label>
				<input type="file" accept="image/*" name="imagen" class="form-control" >
			</div>
			<input type="submit" class="btn btn-info mt-3" value="Cargar Imagen" >
		</form>
	</div>
</body>
</html>