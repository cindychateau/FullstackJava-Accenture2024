package com.empresa.cynthia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.cynthia.modelos.Hobby;
import com.empresa.cynthia.modelos.Usuario;
import com.empresa.cynthia.servicios.Servicios;

@RestController //Controlador que genera rutas, regresar explícitamente lo que el método regresa
public class ControladorAPI {
	
	@Autowired
	private Servicios servicio;
	
	@GetMapping("/api/usuarios")
	public ResponseEntity<List<Usuario>> apiMuestraUsuarios() {
		List<Usuario> usuarios = servicio.todosUsuarios();
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}
	
	@GetMapping("/api/hobbies")
	public ResponseEntity<List<Hobby>> apiMuestraHobbies() {
		List<Hobby> hobbies = servicio.todosHobbies();
		return new ResponseEntity<>(hobbies, HttpStatus.UNAUTHORIZED);
	}
	
}
