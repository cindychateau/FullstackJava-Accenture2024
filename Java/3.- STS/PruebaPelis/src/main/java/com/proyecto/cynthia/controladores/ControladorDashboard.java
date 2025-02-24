package com.proyecto.cynthia.controladores;

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

import com.proyecto.cynthia.modelos.Pelicula;
import com.proyecto.cynthia.modelos.Usuario;
import com.proyecto.cynthia.servicios.ServicioPeliculas;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorDashboard {
	
	//Servicios
	@Autowired
	private ServicioPeliculas sPelis;
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session,
							Model model) {
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		List<Pelicula> peliculas = sPelis.todasPelis();
		
		model.addAttribute("peliculas", peliculas);
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/nuevo")
	public String nuevo(HttpSession session,
						@ModelAttribute("nuevaPelicula") Pelicula nuevaPelicula) {
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		return "nuevo.jsp";
		
	}
	
	@PostMapping("/crear")
	public String crear(@Valid @ModelAttribute("nuevaPelicula") Pelicula nuevaPelicula,
						BindingResult result,
						HttpSession session) {
		
		if(result.hasErrors()) {
			return "nuevo.jsp";
		} else {
			sPelis.guardarPeli(nuevaPelicula);
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/mostrar/{id}")
	public String mostrar(@PathVariable("id") Long id,
						  HttpSession session,
						  Model model) {
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		Pelicula pelicula = sPelis.buscarPelicula(id);
		model.addAttribute("pelicula", pelicula);
		
		Usuario usuarioEnSesion = (Usuario) session.getAttribute("usuarioEnSesion");
		Usuario usuario = sPelis.buscarUsuario(usuarioEnSesion.getId());
		model.addAttribute("usuario", usuario);
		
		return "mostrar.jsp";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id,
						  @ModelAttribute("pelicula") Pelicula pelicula,
						  HttpSession session,
						  Model model) {
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		Pelicula peli = sPelis.buscarPelicula(id);
		
		//Double check de que sea peli creada por el usuario
		Usuario usuarioEnSesion = (Usuario) session.getAttribute("usuarioEnSesion");
		if(usuarioEnSesion.getId() != peli.getCreador().getId()) {
			return "redirect:/dashboard";
		}
		
		model.addAttribute("pelicula", peli);
		
		return "editar.jsp";
	}
	
	@PutMapping("/actualizar/{id}")
	public String actualizar(@Valid @ModelAttribute("pelicula") Pelicula peliculaEditada,
							 BindingResult result,
							 HttpSession session) {
		if(result.hasErrors()) {
			return "editar.jsp";
		} else {
			//Guardar favoritos de nuevo
			sPelis.guardarPeli(peliculaEditada);
			return "redirect:/dashboard";
		}
	}
	
	@DeleteMapping("/borrar/{id}") // localhost:8080/borrar/1
	public String borrar(@PathVariable("id") Long id) { //id = 1
		sPelis.borrarPelicula(id);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/agregarFavorito/{usuarioId}/{peliculaId}")
	public String agregarFavorito(@PathVariable("usuarioId") Long usuarioId,
			   			   @PathVariable("peliculaId") Long peliculaId,
			   			   HttpSession session) {
		
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		sPelis.guardarFavoritos(usuarioId, peliculaId);
		
		return "redirect:/dashboard";
	}
	
	@GetMapping("/quitarFavorito/{usuarioId}/{peliculaId}")
	public String quitarFavorito(@PathVariable("usuarioId") Long usuarioId,
			   			   @PathVariable("peliculaId") Long peliculaId,
			   			   HttpSession session) {
		
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		sPelis.quitarFavoritos(usuarioId, peliculaId);
		
		return "redirect:/dashboard";
	}

	@GetMapping("/buscar")
	public String buscar(@RequestParam(value="palabra") String palabra,
						HttpSession session,
						Model model) {
		
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}

		if(palabra.equals("")) {
			return "redirect:/dashboard";
		}
		
		List<Pelicula> peliculas = sPelis.buscarPeliculaPorTitulo(palabra);
		
		model.addAttribute("peliculas", peliculas);
		
		return "dashboard.jsp";
	}
	
}
