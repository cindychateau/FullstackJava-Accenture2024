<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pokemon</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="card col-6">
				<h1>${pokemon.name}</h1>
				<h3>Peso: ${pokemon.weight}</h3>
				<h3>Altura: ${pokemon.height}</h3>
				<img src="${pokemon.sprites.front_default}" class="img-fluid" alt="${pokemon.name}" >
			</div>
		</div>
	</div>
</body>
</html>