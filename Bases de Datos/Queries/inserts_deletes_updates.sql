SELECT * FROM usuarios;

-- INSERT: Crear un nuevo registro en una tabla (CREATE)
INSERT INTO usuarios (nombre, edad, direccion_id) VALUES ("Juana", 30, 3); -- INSERT INTO <tabla> (columna1, columna2, columna3) VALUES (valor1, valor2, valor3);

-- DELETE: Eliminar un registro (DELETE)
DELETE FROM usuarios WHERE id = 9; 

-- UPDATE: actualiza un registro
UPDATE usuarios SET edad = 31 WHERE id = 8;
UPDATE usuarios SET nombre = "Juanita", edad = 32 WHERE id = 8;