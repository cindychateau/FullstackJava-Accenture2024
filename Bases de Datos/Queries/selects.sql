-- Query = Consulta (Instrucción que se manda al servidor para hacer algo específico: Seleccionar, Guardar Registro, Actualizar o borrar)
-- CRUD: Create Read Update Delete
-- SELECT: Seleccionar información de una tabla (READ)

SELECT * FROM usuarios; -- SELECT * FROM <tabla>; -> Seleccionando todas las columnas de una tabla específica

SELECT nombre, edad FROM usuarios; -- SELECT columna1, columna2, columna3 FROM <tabla>; Mostrando columnas específicas

SELECT nombre, edad FROM usuarios WHERE id = 2; -- SELECT columna1, columna2, columna3 FROM <tabla> WHERE <condicional>; "Filtrando" los registros a mostrar

SELECT * FROM usuarios WHERE edad > 20;

SELECT * FROM usuarios WHERE nombre LIKE "Aureliano"; -- LIKE yo hago comparación de texto
SELECT * FROM usuarios WHERE nombre = "Aureliano";

SELECT nombre FROM usuarios WHERE nombre LIKE "Al%"; -- % = comodin. Puede tener cualquier caracter

SELECT nombre FROM usuarios WHERE nombre LIKE "%o";

SELECT * FROM usuarios WHERE nombre LIKE "%e%";

-- && AND: Ambas condicionales deben de cumplirse 
SELECT * FROM usuarios WHERE nombre LIKE "%o" AND edad > 23;

-- || OR: Una u otra condicional se debe cumplir
SELECT * FROM usuarios WHERE nombre LIKE "%o" OR edad > 23;

SELECT * FROM usuarios WHERE nombre LIKE "%o" AND edad > 23 AND nombre LIKE "A%"; -- nombre LIKE "A%o"

SELECT * FROM usuarios WHERE edad > 25 ORDER BY nombre; -- ASC (A-Z), DESC (Z-A)

SELECT * FROM usuarios WHERE edad > 25 ORDER BY edad DESC; -- ASC (1-9999), DESC (9999-1)

SELECT nombre, edad FROM usuarios ORDER BY edad DESC LIMIT 0, 3; -- LIMIT inicio, cantidad
/*
for(int i=0; i < 3; i++) 
*/
-- SELECT columna1, columna2, columna3 FROM <tabla>
-- JOINS
-- WHERE condicional (AND OR)
-- ORDER BY columna1 ASC/DESC
-- LIMIT inicio, cantidad
