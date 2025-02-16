package com.cynthia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cynthia.modelos.Idea;
import com.cynthia.modelos.Usuario;
import com.cynthia.repositorios.RepositorioIdeas;
import com.cynthia.repositorios.RepositorioUsuarios;

@Service
public class ServicioIdeas {
	
	@Autowired
	private RepositorioIdeas repoIdeas;
	
	@Autowired
	private RepositorioUsuarios repoUsuarios;
	
	public List<Idea> todasIdeas() {
		return repoIdeas.findAllByOrderByTextoAsc();
	}
	
	public Idea guardarIdea(Idea nuevaIdea) {
		return repoIdeas.save(nuevaIdea);
	}
	
	public Idea buscarIdea(Long id) {
		return repoIdeas.findById(id).orElse(null);
	}
	
	public void borrarIdea(Long id) {
		repoIdeas.deleteById(id);
	}
	
	public Usuario buscarUsuario(Long id) {
		return repoUsuarios.findById(id).orElse(null);
	}
	
	public void meGusta(Long usuarioId, Long ideaId) {
		Usuario miUsuario = buscarUsuario(usuarioId);
		Idea miIdea = buscarIdea(ideaId);
		
		miUsuario.getMisFavoritas().add(miIdea);
		repoUsuarios.save(miUsuario);
	}
	
	public void quitarMeGusta(Long usuarioId, Long ideaId) {
		Usuario miUsuario = buscarUsuario(usuarioId);
		Idea miIdea = buscarIdea(ideaId);
		
		miUsuario.getMisFavoritas().remove(miIdea);
		repoUsuarios.save(miUsuario);
	}
	
}
