package com.empresa.cynthia.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empresa.cynthia.modelos.Usuario;
import com.empresa.cynthia.servicios.Servicios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller //Encargada de decir que mi archivo es un controlador. Regresar un archivo JSP
public class ControladorUsuarios {
	
	@Autowired
	private Servicios serv;

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
	
	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		//Obtener la lista de todos mis usuarios
		List<Usuario> usuarios = serv.todosUsuarios();
		
		//Enviar la lista a mi jsp
		model.addAttribute("usuarios", usuarios);
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(@ModelAttribute("usuario") Usuario usuario) {
		//@ModelAttribute crea un objeto vacío de Usuario y lo manda a nuevo.jsp
		return "nuevo.jsp";
	}
	
	@PostMapping("/crear")
	public String crear(@Valid @ModelAttribute("usuario") Usuario nuevoUsuario, /*@Valid: valida la info del objeto*/
						BindingResult result /*Encargado de revisar los errores*/) {
		
		if(result.hasErrors()) {
			return "nuevo.jsp";
		} else {
			serv.guardarUsuario(nuevoUsuario); //Guardar el objeto usuario que recibimos del formulario
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/mostrar/{id}") // localhost:8080/mostrar/1
	public String mostrar(@PathVariable("id") Long id, /*id = 1*/
						  Model model) { 
		Usuario esteUsuario = serv.buscarUsuario(id); //buscarUsuario(1)
		model.addAttribute("usuario", esteUsuario);
		return "mostrar.jsp";
	}
	
	
}
