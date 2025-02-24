package com.proyecto.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.cynthia.modelos.Pelicula;

@Repository
public interface RepositorioPeliculas extends CrudRepository<Pelicula, Long> {
	
	List<Pelicula> findAll();
	
	List<Pelicula> findAllByOrderByTituloAsc();
	
	List<Pelicula> findAllByOrderByAnioAsc();
	
	List<Pelicula> findByTituloContaining(String palabra);
	
}
