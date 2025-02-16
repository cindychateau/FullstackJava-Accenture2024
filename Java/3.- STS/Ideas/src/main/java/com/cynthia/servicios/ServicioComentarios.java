package com.cynthia.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynthia.modelos.Comentario;
import com.cynthia.repositorios.RepositorioComentarios;

@Service
public class ServicioComentarios {
	
	@Autowired
	private RepositorioComentarios repoComentarios;
	
	public Comentario guardarComentario(Comentario nuevoComentario){
		return repoComentarios.save(nuevoComentario);
	}
	
}
