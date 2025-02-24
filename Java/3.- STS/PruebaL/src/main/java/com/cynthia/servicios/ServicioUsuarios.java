package com.cynthia.servicios;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.cynthia.modelos.LoginUsuario;
import com.cynthia.modelos.Usuario;
import com.cynthia.repositorios.RepositorioUsuarios;

@Service
public class ServicioUsuarios {
	
	@Autowired
	private RepositorioUsuarios repoUsuarios;
	
	public Usuario registrar(Usuario nuevoUsuario, BindingResult result) {
		
		//Comparar las contraseñas
		String password = nuevoUsuario.getPassword();
		String confirm = nuevoUsuario.getConfirmacion();
		if(!password.equals(confirm)) {
			//SI no son iguales
			//path, clave, mensaje
			result.rejectValue("confirmacion", "Matches", "Password and confirmation don't match");
		}
		
		//Revisar que el email no esté registrado
		String email = nuevoUsuario.getEmail();
		Usuario userExist = repoUsuarios.findByEmail(email); //Objeto de User o null
		if(userExist != null) {
			//El correo ya está registrado
			result.rejectValue("email", "Unique", "E-mail already exists");
		}
		
		//Si existe error, regreso null
		if(result.hasErrors()) {
			return null;
		} else {
			//NO HAY ERRORES
			//Hashear contraseña
			String passHash = BCrypt.hashpw(password, BCrypt.gensalt());
			nuevoUsuario.setPassword(passHash); //Establecemos el password hasheado
			return repoUsuarios.save(nuevoUsuario);
		}
		
	}
	
	public Usuario login(LoginUsuario loginUsuario, BindingResult result) {
		
		String email = loginUsuario.getEmailLogin();
		Usuario userExist = repoUsuarios.findByEmail(email); //Objeto de User o null
		if(userExist == null) {
			//El correo no está registrado
			result.rejectValue("emailLogin", "Unique", "E-mail no registrado");
		} else {
			if(! BCrypt.checkpw(loginUsuario.getPasswordLogin(), userExist.getPassword())) {
				result.rejectValue("emailLogin", "Matches", "Credenciales incorrectas!");
			}
		}
		
		if(result.hasErrors()) {
			return null;
		} else {
			return userExist;
		}
		
	}
	
	
}
