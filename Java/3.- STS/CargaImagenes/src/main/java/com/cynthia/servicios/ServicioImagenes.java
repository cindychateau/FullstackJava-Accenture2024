package com.cynthia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynthia.modelos.Imagen;
import com.cynthia.repositorios.RepositorioImagenes;

@Service
public class ServicioImagenes {
	
	@Autowired
	private RepositorioImagenes repositorioImagenes;
	
	public List<Imagen> obtenerImagenes() {
		return repositorioImagenes.findAll();
	}
	
	public Imagen guardarImagen(Imagen nuevaImagen) {
		return repositorioImagenes.save(nuevaImagen);
	}
	
}
