package com.cynthia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cynthia.modelos.Imagen;

@Repository
public interface RepositorioImagenes extends JpaRepository<Imagen, Long> {
	
}
