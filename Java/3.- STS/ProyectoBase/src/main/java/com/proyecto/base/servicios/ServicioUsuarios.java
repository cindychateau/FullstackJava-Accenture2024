package com.proyecto.base.servicios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.proyecto.base.modelos.Usuario;
import com.proyecto.base.repositorios.RepositorioUsuarios;

@Service
public class ServicioUsuarios {

	@Autowired
	private RepositorioUsuarios repoUsuarios;
	
	//Método que registra al usuario. 
	//Usuario nuevoUsuario es la instancia de Usuario llenada con el formulario
	public Usuario registrar(Usuario nuevoUsuario, BindingResult result) {
		
		//Comparamos password y confirmación
		String password = nuevoUsuario.getPassword();
		String confirmacion = nuevoUsuario.getConfirmacion();
		if(!password.equals(confirmacion)) {
			result.rejectValue("confirmacion", "Matches", "Password y Confirmación deben ser iguales");
		}
		
		//Revisar que el email no esté registrado
		String email = nuevoUsuario.getEmail();
		Usuario existeUsuario = repoUsuarios.findByEmail(email); //Objeto Usuario o null
		if(existeUsuario != null) {
			result.rejectValue("email", "Unique", "E-mail ya se encuentra registrado.");
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			String passwordHasheado = BCrypt.hashpw(password, BCrypt.gensalt());
			nuevoUsuario.setPassword(passwordHasheado);
			return repoUsuarios.save(nuevoUsuario);
		}
		
	}
	
}
