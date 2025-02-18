<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Pokemones</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Pokedex</h1>
		<div class="row">
			<c:forEach items="${respuesta.results}" var="pokemon" >
				<div class="card col-3">
					<h2 class="text-capitalize" >${fn:toLowerCase(pokemon.name)}</h2>
					<a href="/pokemon/${pokemon.name}" class="btn btn-info mb-3" >Ver Detalle</a>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>