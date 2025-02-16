package com.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cynthia.modelos.Comentario;

@Repository
public interface RepositorioComentarios extends CrudRepository<Comentario, Long> {
	
	List<Comentario> findAll();
	
}
