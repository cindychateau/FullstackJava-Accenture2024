package com.proyecto.base.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.base.modelos.Usuario;
import com.proyecto.base.servicios.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {
	
	@Autowired
	private ServicioUsuarios sUsuarios;
	
	@GetMapping("/")
	public String index(@ModelAttribute("nuevoUsuario") Usuario nuevoUsuario) {
		return "index.jsp";
	}
	
	@PostMapping("/registro")
	public String registro(@Valid @ModelAttribute("nuevoUsuario") Usuario nuevoUsuario,
						   BindingResult result,
						   HttpSession session) {
		sUsuarios.registrar(nuevoUsuario, result);
		
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			//Guardo al nuevo usuario en sesión
			session.setAttribute("usuarioEnSesion", nuevoUsuario);
			return "redirect:/dashboard";
		}
		
	}
	
}
