<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Usuario</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Nuevo Usuario</h1>
		<form:form action="/crear" method="post" modelAttribute="usuario"  >
			<div>
				<form:label path="nombre" >Nombre:</form:label>
				<form:input class="form-control" path="nombre" placeholder="Ingresa tu nombre.." />
				<form:errors path="nombre" class="text-danger" />
			</div>
			<div>
				<form:label path="apellido">Apellido:</form:label>
				<form:input class="form-control" path="apellido" placeholder="Ingresa tu apellido..." />
				<form:errors path="apellido" class="text-danger" />
			</div>
			<div>
				<form:label path="email">E-mail</form:label>
				<form:input class="form-control" path="email" placeholder="Ingresa tu email" />
				<form:errors path="email" class="text-danger" />
			</div>
			<div>
				<form:label path="salon" >Salón:</form:label>
				<form:select path="salon" class="form-select">
					<c:forEach items="${salones}" var="salon" >
						<form:option value="${salon.id}" >${salon.curso}</form:option>
					</c:forEach>
				</form:select>
			</div>
			<input type="submit" class="btn btn-info mt-3" value="Guardar Usuario">
		</form:form>
	</div>
</body>
</html>