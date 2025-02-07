package com.empresa.cynthia.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.empresa.cynthia.modelos.Hobby;
import com.empresa.cynthia.modelos.Salon;
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
	
	//NOFUNCIONA
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
	public String nuevo(@ModelAttribute("usuario") Usuario usuario,
						Model model) {
		
		List<Salon> salones = serv.todosSalones(); //Obtengo de la bd todos los salones
		model.addAttribute("salones", salones);
		
		//@ModelAttribute crea un objeto vacío de Usuario y lo manda a nuevo.jsp
		return "nuevo.jsp";
	}
	
	@PostMapping("/crear")
	public String crear(@Valid @ModelAttribute("usuario") Usuario nuevoUsuario, /*@Valid: valida la info del objeto*/
						BindingResult result, /*Encargado de revisar los errores*/
						Model model) {
		
		if(result.hasErrors()) {
			List<Salon> salones = serv.todosSalones(); //Obtengo de la bd todos los salones
			model.addAttribute("salones", salones);
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
	
	@DeleteMapping("/borrar/{id}") // localhost:8080/borrar/1
	public String borrar(@PathVariable("id") Long id) { //id = 1
		serv.borrarUsuario(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/editar/{id}") // localhost:8080/editar/1
	public String editar(@PathVariable("id") Long id,
						 @ModelAttribute("usuario") Usuario usuario, /*Crea objeto vacío y lo envía a jsp*/
						 Model model /*Envía información de método a jsp*/ ) {
		
		//Obtener el objeto de usuario a editar
		Usuario esteUsuario = serv.buscarUsuario(id);
		model.addAttribute("usuario", esteUsuario); //Sobrescribiendo el usuario vacío
		
		List<Salon> salones = serv.todosSalones(); //Obtengo la lista de salones de bd
		model.addAttribute("salones", salones); //Envio a jsp
		
		return "editar.jsp";
	}
	
	@PutMapping("/actualizar/{id}") //IMPORTANTE: debe llamarse id. Para asignarlo al objeto de ModelAttribute
	public String actualizar(@Valid @ModelAttribute("usuario") Usuario usuarioEditado,
							BindingResult result,
							Model model) {
		
		if(result.hasErrors()) {
			List<Salon> salones = serv.todosSalones(); //Obtengo la lista de salones de bd
			model.addAttribute("salones", salones); //Envio a jsp
			return "editar.jsp";
		} else {
			serv.guardarUsuario(usuarioEditado);
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/asignar/{id}") 
	public String asignar(@PathVariable("id") Long id,
						  Model model) { 
		//Buscar el usuario al cual le asigno los hobbies
		Usuario esteUsuario = serv.buscarUsuario(id);
		model.addAttribute("usuario", esteUsuario);
		
		//Lista de hobbies
		List<Hobby> hobbies = serv.todosHobbies();
		model.addAttribute("hobbies", hobbies);
		
		return "asignar.jsp";
	}
	
	@GetMapping("/asignarHobby/{usuarioId}/{hobbyId}")
	public String asignarHobby(@PathVariable("usuarioId") Long usuarioId,
							   @PathVariable("hobbyId") Long hobbyId) {
		
		//Invocar a un método que me asigne el hobby a un usuario
		serv.asignarHobbyAUsuario(usuarioId, hobbyId);
		
		return "redirect:/dashboard"; // "redirect:/asignar/"+usuarioId
		
	}
	
	@GetMapping("/quitarHobby/{usuarioId}/{hobbyId}")
	public String quitarHobby(@PathVariable("usuarioId") Long usuarioId,
							  @PathVariable("hobbyId") Long hobbyId) {
		
		//Invocar a un método que quite el hobby de un usuario
		serv.quitarHobbyAUsuario(usuarioId, hobbyId);
		
		return "redirect:/asignar/"+usuarioId;
		
	}
	
	
}
