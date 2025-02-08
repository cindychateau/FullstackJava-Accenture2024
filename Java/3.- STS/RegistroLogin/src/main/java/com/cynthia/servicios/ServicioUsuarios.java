package com.cynthia.servicios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.cynthia.modelos.Usuario;
import com.cynthia.repositorios.RepositorioUsuarios;

@Service
public class ServicioUsuarios {
	
	@Autowired
	private RepositorioUsuarios repoUsuarios;
	
	
	//Método que me guarde el nuevo registro del usuario
	public Usuario registrar(Usuario nuevoUsuario, BindingResult result) {
		
		//Comparar las contraseñas
		String password = nuevoUsuario.getPassword();
		String confirmacion = nuevoUsuario.getConfirmacion();
		if(!password.equals(confirmacion)) {
			//SI NO SO IGUALES
			result.rejectValue("confirmacion", "Matches", "Los passwords no coinciden."); //path(atributo), clave, mensaje
		}
		
		//Revisar que el email no esté registrado
		String email = nuevoUsuario.getEmail();
		Usuario existeUsuario = repoUsuarios.findByEmail(email); //Objeto Usuario o null
		if(existeUsuario != null) {
			//El correo ya existe en mi BD
			result.rejectValue("email", "Unique", "El correo ya está registrado.");
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			//NO HAY ERRORES
			//Hasheando contraseña
			String passwordHasheado = BCrypt.hashpw(password, BCrypt.gensalt() );
			nuevoUsuario.setPassword(passwordHasheado); //Establezco el password hasheado
			
			//Guardando el usuario 
			return repoUsuarios.save(nuevoUsuario);
		}
		
		
	}
	
}
