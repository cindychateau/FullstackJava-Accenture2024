package com.empresa.cynthia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.empresa.cynthia.modelos.Usuario;

//CRUD: Create Read Update Delete = Crear Leer Actualizar Borrar
@Repository
public interface RepositorioUsuarios extends JpaRepository<Usuario, Long> { /*Herencia: extends. Interface en la clase: implements*/
	
	//JPA -> Permitir de manera dinámica crear queries
	
	List<Usuario> findAll(); //SELECT * FROM usuarios;
	
	//INSERT INTO usuarios(nombre, apellido...) VALUES (Valores de los atributos de objeto usuario);
	//UPDATE usuarios SET nombre = Valor objeto...
	Usuario save(Usuario nuevoUsuario); // Usuario cynthia = new Usuario(); cynthia.setNombre("Cynthia"); cynthia.setApellido("Castillo");
	
	//CrudRepository: findAll(), findById(id), save(Object objeto), deleteById(id) DELETE FROM usuarios WHERE id = ?
	
	//SELECT * FROM usuarios WHERE email = <email a buscar>
	List<Usuario> findByEmail(String emailABuscar);
	
	List<Usuario> findByApellido(String apellidoABuscar);
	
	//SELECT * FROM usuarios WHERE nombre LIKE "<letras>%";
	List<Usuario> findByNombreStartingWith(String letrasABuscar);
	
}
