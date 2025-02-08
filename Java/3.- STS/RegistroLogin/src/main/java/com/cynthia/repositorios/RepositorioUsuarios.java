package com.cynthia.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cynthia.modelos.Usuario;

@Repository
public interface RepositorioUsuarios extends CrudRepository<Usuario, Long> { //<Clase, Tipo de Dato para id>
	
	Usuario findByEmail(String email); // SELECT * FROM usuarios WHERE email = <email>
	
}
