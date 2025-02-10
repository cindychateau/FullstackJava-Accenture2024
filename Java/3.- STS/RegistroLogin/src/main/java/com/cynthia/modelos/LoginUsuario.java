package com.cynthia.modelos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

//NO ES una entidad, no está ligada a ninguna tabla
//Objetivo: obtener esa información y almacenarla en una instancia
public class LoginUsuario {
	
	@NotBlank(message="El email es obligatorio.")
	@Email(message="Ingresa un email válido.")
	private String emailLogin;
	
	private String passwordLogin;
	
	public LoginUsuario() {}

	public String getEmailLogin() {
		return emailLogin;
	}

	public void setEmailLogin(String emailLogin) {
		this.emailLogin = emailLogin;
	}

	public String getPasswordLogin() {
		return passwordLogin;
	}

	public void setPasswordLogin(String passwordLogin) {
		this.passwordLogin = passwordLogin;
	}
	
}
