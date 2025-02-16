package com.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cynthia.modelos.Idea;

@Repository
public interface RepositorioIdeas extends CrudRepository<Idea, Long> {
	
	List<Idea> findAll();
	
	List<Idea> findAllByOrderByTextoAsc();
	
}
