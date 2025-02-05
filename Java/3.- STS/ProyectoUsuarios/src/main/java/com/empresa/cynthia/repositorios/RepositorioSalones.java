package com.empresa.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.empresa.cynthia.modelos.Salon;

@Repository
public interface RepositorioSalones extends CrudRepository<Salon, Long> {
	
	/* Create: save(objeto)
	 * Read: findAll(), findById(id), 
	 * Update: save(objeto)
	 * Delete: deleteById(id)*/
	
	List<Salon> findAll(); // SELECT * FROM salones
	
}
