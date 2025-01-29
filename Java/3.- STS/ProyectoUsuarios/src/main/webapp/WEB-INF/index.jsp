<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Practica</title>
</head>
<body>
	<h1>Bienvenido al mundo de JSP!</h1>
	<h2>${titulo}</h2>
	<ul>
		<!--  {"Elena de Troya", "Juana de Arco", "Pablo Picasso", "Pedro Paramo"} -->
		<c:forEach items="${users}" var="usuario">
			<li>${usuario}</li>
		</c:forEach>
	</ul>
</body>
</html>