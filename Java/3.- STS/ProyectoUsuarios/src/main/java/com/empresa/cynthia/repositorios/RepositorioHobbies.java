package com.empresa.cynthia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.empresa.cynthia.modelos.Hobby;

@Repository
public interface RepositorioHobbies extends CrudRepository<Hobby, Long> {
	
	List<Hobby> findAll(); //SELECT * FROM hobbies;
	
}
