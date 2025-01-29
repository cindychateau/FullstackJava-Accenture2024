package com.empresa.cynthia.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //Encargada de decir que mi archivo es un controlador. Regresar un archivo JSP
public class ControladorUsuarios {

	@GetMapping("/index")
	public String index(Model model) {
		
		model.addAttribute("titulo", "Estamos integrando Model model");
		
		String usuarios[] = {"Elena de Troya", "Juana de Arco", "Pablo Picasso", "Pedro Paramo"};
		
		model.addAttribute("users", usuarios);
		
		return "index.jsp";
	}
	
	@GetMapping("/peliculas")
	public String peliculas(Model model) {
		String pelis[] = {"Interestellar", "Soul", "NOsferatus"};
		model.addAttribute("peliculasTaquilleras", pelis);
		return "pelis.jsp";
	}
	
}
