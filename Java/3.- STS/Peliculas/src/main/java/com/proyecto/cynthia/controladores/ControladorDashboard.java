package com.proyecto.cynthia.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.cynthia.modelos.Pelicula;
import com.proyecto.cynthia.servicios.ServicioPeliculas;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorDashboard {
	
	//Servicios
	@Autowired
	private ServicioPeliculas servicioPelis;
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		//Generar la lista con las pelis
		//Enviar esa lista a dashboard
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(@ModelAttribute("nuevaPeli") Pelicula nuevaPeli, /*Genero objeto vacío de peli para llenar con form:form*/
						HttpSession session /*Permite acceder a la sesión*/) {
		
		/*===== Revisar que el usuario haya iniciado sesión =====*/
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		return "nuevo.jsp";
	}
	
	@PostMapping("/crear")
	public String crear(@Valid @ModelAttribute("nuevaPeli") Pelicula nuevaPeli,
						BindingResult result) {
		
		if(result.hasErrors()) {
			return "nuevo.jsp";
		
		} else {
			servicioPelis.guardarPeli(nuevaPeli);
			return "redirect:/dashboard";
		}
		
	}
	
}