<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Formulario de Registro</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Formulario de Registro</h1>
				<form action="/registrarUsuario" method="POST" >
					<input type="text" class="form-control" name="nombreUsuario" placeholder="Ingrese su nombre..." >
					<input type="email" class="form-control" name="emailUsuario" placeholder="Ingrese su email...">
					<input type="submit" value="Registrarme" class="btn btn-success">
				</form>
				<div class="text-danger">${error}</div>
			</div>
		</div>
	</div>
</body>
</html>