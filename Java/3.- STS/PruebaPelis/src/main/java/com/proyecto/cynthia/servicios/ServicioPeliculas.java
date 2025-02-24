package com.proyecto.cynthia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.cynthia.modelos.Pelicula;
import com.proyecto.cynthia.modelos.Usuario;
import com.proyecto.cynthia.repositorios.RepositorioPeliculas;
import com.proyecto.cynthia.repositorios.RepositorioUsuarios;

@Service
public class ServicioPeliculas {
	
	@Autowired
	private RepositorioPeliculas repoPelis;
	
	@Autowired
	private RepositorioUsuarios repoUsuarios;
	
	public List<Pelicula> todasPelis() {
		return repoPelis.findAll(); //repoPelis.findAllByOrderByTituloAsc();
	}
	
	public Pelicula guardarPeli(Pelicula pelicula) {
		return repoPelis.save(pelicula);
	}
	
	public Pelicula buscarPelicula(Long id) {
		return repoPelis.findById(id).orElse(null);
	}
	
	public void borrarPelicula(Long id) {
		repoPelis.deleteById(id);
	}
	
	public Usuario buscarUsuario(Long id) {
		return repoUsuarios.findById(id).orElse(null);
	}
	
	public void guardarFavoritos(Long usuarioId, Long peliculaId) {
		Usuario miUsuario = buscarUsuario(usuarioId);
		Pelicula miPelicula = buscarPelicula(peliculaId);
		
		miUsuario.getMisFavoritas().add(miPelicula);
		repoUsuarios.save(miUsuario);
	}
	
	public void quitarFavoritos(Long usuarioId, Long peliculaId) {
		Usuario miUsuario = buscarUsuario(usuarioId);
		Pelicula miPelicula = buscarPelicula(peliculaId);
		
		miUsuario.getMisFavoritas().remove(miPelicula);
		repoUsuarios.save(miUsuario);
	}
	
	public List<Pelicula> buscarPeliculaPorTitulo(String palabra) {
		return repoPelis.findByTituloContaining(palabra);
	}
	
}
