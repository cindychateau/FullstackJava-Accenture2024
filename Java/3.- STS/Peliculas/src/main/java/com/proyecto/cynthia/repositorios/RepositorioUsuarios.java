package com.proyecto.cynthia.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.cynthia.modelos.Usuario;

@Repository //Encargados de hacer las consultas en mis tablas
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long> { //<Clase, TipoDeDatoId>
	//CrudRepository: Interface que ya tiene funciones de CRUD
	//Create: save()
	//Read: findAll() findById()
	//Update: save()
	//Delete: deleteById()
	
	Usuario findByEmail(String email); //SELECT * FROM usuarios WHERE email = <email>
	
}
