<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Libros</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6">
				<h1>Libros</h1>
				<!-- listaLibros = [ {"Odisea": "Homero"}, {"Don Quijote de la Mancha": "Cervantes"}...  ] -->
				<c:forEach items="${listaLibros}" var="libro">
					<h3>${libro.key} - ${libro.value}</h3>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>