package com.empresa.cynthia.controladores;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller //Encargada de decir que mi archivo es un controlador. Regresar un archivo JSP
public class ControladorUsuarios {

	@GetMapping("/index")
	public String index(Model model) {
		//Model model -> enviar valores al jsp
		
		model.addAttribute("titulo", "Estamos integrando Model model");
		
		String usuarios[] = {"Elena de Troya", "Juana de Arco", "Pablo Picasso", "Pedro Paramo"};
		
		model.addAttribute("users", usuarios);
		
		return "index.jsp";
	}
	
	@GetMapping("/peliculas")
	public String peliculas(Model model) {
		String pelis[] = {"Interestellar", "Soul", "NOsferatus"};
		model.addAttribute("peliculasTaquilleras", pelis);
		
		ArrayList<String> otraLista = new ArrayList<String>();
		
		return "pelis.jsp";
	}
	
	//Formularios tienen 3 rutas
	
	//Ruta 1: Muestra el Formulario
	@GetMapping("/formulario")
	public String formulario() {
		return "formulario.jsp";
	}
	
	//Ruta 2: Recibe la información
	@PostMapping("/registrarUsuario")
	public String registrar(@RequestParam(value="nombreUsuario") String nombre,
							@RequestParam(value="emailUsuario") String email,
							HttpSession session, /*Permite guardar información sesión*/
							RedirectAttributes flash /*Permite enviar errores*/) {
		System.out.println("Nombre: "+nombre);
		System.out.println("Email:"+email);
		
		//Validar la info
		if(nombre.equals("") || email.equals("")) {
			flash.addFlashAttribute("error", "Todos los datos son obligatorios");
			return "redirect:/formulario"; 
		}
		
		session.setAttribute("username", nombre);
		session.setAttribute("email", email);
		
		return "redirect:/bienvenida";
	}
	
	//Ruta 3: Redirección
	@GetMapping("/bienvenida")
	public String bienvenida() {
		return "bienvenida.jsp";
	}
	
}
