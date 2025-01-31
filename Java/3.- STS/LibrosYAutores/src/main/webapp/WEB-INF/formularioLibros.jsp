<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Formulario</h1>
		<form action="/libros/procesa" method="POST">
			<input class="form-control" name="autor" placeholder="Ingresa autor." >
			<input class="form-control" name="libro" placeholder="Ingresa Libro.">
			<input type="submit" class="btn btn-success" value="Ingresar">
		</form>
	</div>
</body>
</html>