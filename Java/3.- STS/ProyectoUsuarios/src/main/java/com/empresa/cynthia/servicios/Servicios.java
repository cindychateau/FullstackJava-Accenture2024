package com.empresa.cynthia.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.cynthia.modelos.Usuario;
import com.empresa.cynthia.repositorios.RepositorioUsuarios;

@Service //Servicio es el puente entre Repositorio (consultas SQL) y Controlador (rutas y mostrar vistas)
public class Servicios {

	@Autowired
	private RepositorioUsuarios repoUsuarios;
	
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
	
	//Método para borrar usuario en base a su id
	public void borrarUsuario(Long id) {
		repoUsuarios.deleteById(id);
	}
	
	
}
