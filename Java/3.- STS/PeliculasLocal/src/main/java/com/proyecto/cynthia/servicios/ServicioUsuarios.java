package com.proyecto.cynthia.servicios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.proyecto.cynthia.modelos.LoginUsuario;
import com.proyecto.cynthia.modelos.Usuario;
import com.proyecto.cynthia.repositorios.RepositorioUsuarios;

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
	
	//Método que revise las credenciales de inicio de sesión
	public Usuario login(LoginUsuario datosInicioDeSesion, BindingResult result) {
		
		//Revisamos que exista el correo
		String email = datosInicioDeSesion.getEmailLogin();
		Usuario existeUsuario = repoUsuarios.findByEmail(email); //Objeto Usuario o null
		if(existeUsuario == null) {
			//El email no está registrado
			result.rejectValue("emailLogin", "Unique", "E-mail no registrado");
		} else {
			//Si la contraseña coincide
			if(! BCrypt.checkpw(datosInicioDeSesion.getPasswordLogin(), existeUsuario.getPassword())) {
				//NO COINCIDEN
				result.rejectValue("passwordLogin", "Matches", "Password incorrecto");
			}
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			return existeUsuario;
		}
		
	}
	
}
