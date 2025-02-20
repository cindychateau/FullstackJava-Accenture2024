package com.empresa.cynthia.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.empresa.cynthia.modelos.Hobby;
import com.empresa.cynthia.modelos.Salon;
import com.empresa.cynthia.modelos.Usuario;
import com.empresa.cynthia.repositorios.RepositorioHobbies;
import com.empresa.cynthia.repositorios.RepositorioSalones;
import com.empresa.cynthia.repositorios.RepositorioUsuarios;

@Service //Servicio es el puente entre Repositorio (consultas SQL) y Controlador (rutas y mostrar vistas)
public class Servicios {

	@Autowired
	private RepositorioUsuarios repoUsuarios;
	
	@Autowired
	private RepositorioSalones repoSalones;
	
	@Autowired
	private RepositorioHobbies repoHobbies;
	
	/*
	 	private RepositorioUsuarios repoUsuarios;
 		private RepositorioSalones repoSalones;
		private RepositorioHobbies repoHobbies;
		
		@Autowired
		public Servicios(RepositorioUsuarios repoUsuarios, RepositorioSalones repoSalones, RepositorioHobbies repoHobbies) {
			this.repoUsuarios = repoUsuarios;
			this.repoSalones = repoSalones;
			this.repoHobbies = repoHobbies;
		}

	 */
	
	//Método que me regrese todos los usuarios
	public List<Usuario> todosUsuarios(){
		return repoUsuarios.findAll();
	}
	
	//Método que guarde un usuario. Nuevos registros y Actualizar registros
	public Usuario guardarUsuario(Usuario nuevoUsuario) {
		return repoUsuarios.save(nuevoUsuario);
	}
	
	//Método que busque un usuario en base a su id
	public Usuario buscarUsuario(Long id) {
		return repoUsuarios.findById(id).orElse(null);
	}
	
	public Optional<Usuario> buscarUsuario2(Long id) {
		return repoUsuarios.findById(id);
	}
	
	//Método para borrar usuario en base a su id
	public void borrarUsuario(Long id) {
		repoUsuarios.deleteById(id);
	}
	
	//Método que me regrese todos los salones
	public List<Salon> todosSalones() {
		return repoSalones.findAll();
	}
	
	//Método que me regrese todos los hobbies
	public List<Hobby> todosHobbies() {
		return repoHobbies.findAll();
	}
	
	//Método que me regrese un hobby específico
	public Hobby buscarHobby(Long id) {
		return repoHobbies.findById(id).orElse(null);
	}
	
	//Método que asigne un hobby a un usuario
	public void asignarHobbyAUsuario(Long usuarioId, Long hobbyId) {
		//Obtener el objeto usuario al que le agregamos el hobby
		Usuario miUsuario = buscarUsuario(usuarioId);
		
		//Obtener el objeto hobby que le asignamos
		Hobby miHobby = buscarHobby(hobbyId);
		
		miUsuario.getHobbies().add(miHobby);
		repoUsuarios.save(miUsuario);
		
		//miHobby.getUsuarios().add(miUsuario);
		//repoHobbies.save(miHobby);
		
	}
	
	//Método que quite un hobby de un usuario
	public void quitarHobbyAUsuario(Long usuarioId, Long hobbyId) {
		//Obtener al usuario
		Usuario miUsuario = buscarUsuario(usuarioId);
		
		//Obtener al hobby
		Hobby miHobby = buscarHobby(hobbyId);
		
		miUsuario.getHobbies().remove(miHobby);
		repoUsuarios.save(miUsuario);
	}
	
	//Método que regresa una página específica
	public Page<Usuario> usuarioPorPagina(int numPagina){
		//Numero de Página, Cantidad Registros, Acomodo, Atributo del acomodo
		PageRequest pageRequest = PageRequest.of(numPagina, 2, Sort.Direction.ASC, "nombre");
		return repoUsuarios.findAll(pageRequest);
	}
	
}
