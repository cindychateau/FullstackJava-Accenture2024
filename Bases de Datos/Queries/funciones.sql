SELECT * FROM usuarios;
SELECT nombre AS name, edad AS age FROM usuarios;
SELECT SUM(edad) AS sumatoria_edad FROM usuarios;
SELECT AVG(total) AS promedio FROM pedidos;
SELECT COUNT(id) FROM pedidos;
SELECT CONCAT(nombre, edad) FROM usuarios;
SELECT * FROM pedidos;
SELECT YEAR(created_at) AS anio_compra FROM pedidos;