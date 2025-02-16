package com.cynthia.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.cynthia.modelos.Comentario;
import com.cynthia.modelos.Idea;
import com.cynthia.modelos.Usuario;
import com.cynthia.servicios.ServicioComentarios;
import com.cynthia.servicios.ServicioIdeas;
import com.proyecto.cynthia.modelos.Pelicula;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorDashboard {
	
	//Servicios
	@Autowired
	private ServicioIdeas servicioIdeas;
	
	@Autowired
	private ServicioComentarios servicioComentarios;
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session,
							Model model) {
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		List<Idea> ideas = servicioIdeas.todasIdeas();
		model.addAttribute("ideas", ideas);
		
		//Enviamos al usuario con su versión más reciente de BD para revisar sus favoritos!
		Usuario usuarioEnSesion = (Usuario)session.getAttribute("usuarioEnSesion"); //Obteniendo de la sesión el objeto usuario
		Usuario usuario = servicioIdeas.buscarUsuario(usuarioEnSesion.getId());
		model.addAttribute("usuario", usuario);
		
		return "dashboard.jsp";
	}
	
	@GetMapping("/nueva")
	public String nueva(HttpSession session,
						@ModelAttribute("idea") Idea idea) {
		
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		return "nueva.jsp";
		
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid @ModelAttribute("idea") Idea idea,
						BindingResult result,
						HttpSession session) {
		
		if(result.hasErrors()) {
			return "nueva.jsp";
		} else {
			servicioIdeas.guardarIdea(idea);
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/mostrar/{id}")
	public String mostrar(@PathVariable("id") Long id,
						  HttpSession session,
						  Model model,
						  @ModelAttribute("nuevoComentario") Comentario nuevoComentario) {
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		Idea idea = servicioIdeas.buscarIdea(id);
		model.addAttribute("idea", idea);
		
		return "mostrar.jsp";
	}
	
	@PostMapping("/agregarComentario")
	public String guardar(@Valid @ModelAttribute("nuevoComentario") Comentario nuevoComentario,
						BindingResult result,
						HttpSession session,
						Model model) {
		
		/*Queremos que vuelva a aparecer la misma página, por lo tanto hay que consultar a qué idea 
		 se le estaba colocando el comentario, para volver a enviar la idea*/
		Long ideaId = nuevoComentario.getIdea().getId();
		
		if(result.hasErrors()) {
			
			Idea idea = servicioIdeas.buscarIdea(ideaId);
			model.addAttribute("idea", idea);
			
			return "mostrar.jsp";
		} else {
			servicioComentarios.guardarComentario(nuevoComentario);
			return "redirect:/mostrar/"+ideaId;
		}
		
	}
	
	@GetMapping("/meGusta/{usuarioId}/{ideaId}")
	public String meGusta(@PathVariable("usuarioId") Long usuarioId,
			   			   @PathVariable("ideaId") Long ideaId,
			   			   HttpSession session) {
		
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		servicioIdeas.meGusta(usuarioId, ideaId);
		
		return "redirect:/dashboard";
	}
	
	@GetMapping("/quitarMeGusta/{usuarioId}/{ideaId}")
	public String quitarMeGusta(@PathVariable("usuarioId") Long usuarioId,
			   			   @PathVariable("ideaId") Long ideaId,
			   			   HttpSession session) {
		
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		servicioIdeas.quitarMeGusta(usuarioId, ideaId);
		
		return "redirect:/dashboard";
	}
	
	@GetMapping("/favoritos")
	public String favoritos(HttpSession session,
						    Model model) {
		/*===== Revisar que el usuario haya iniciado sesión =====*/
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		Usuario usuarioEnSesion = (Usuario)session.getAttribute("usuarioEnSesion"); //Obteniendo de la sesión el objeto usuario
		Usuario usuario = servicioIdeas.buscarUsuario(usuarioEnSesion.getId());
		model.addAttribute("usuario", usuario);
		
		return "favoritos.jsp";
		
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id,
						 @ModelAttribute("idea") Idea idea,
						 Model model, /*Envia info del método al jsp*/
						 HttpSession session) {
		
		/*===== Revisar que el usuario haya iniciado sesión =====*/
		if(session.getAttribute("usuarioEnSesion") == null){
			return "redirect:/";
		}
		
		Idea ideaAEditar = servicioIdeas.buscarIdea(id);
		
		//Double Check: Usuario En sesion es el creador
		Usuario usuarioEnSesion = (Usuario)session.getAttribute("usuarioEnSesion"); //Obteniendo de la sesión el objeto usuario
		if(usuarioEnSesion.getId() !=  ideaAEditar.getCreador().getId()) {
			return "redirect:/dashboard";
		}
		
		
		model.addAttribute("idea", ideaAEditar);
		
		return "editar.jsp";
		
	}
	
	@PutMapping("/actualizar/{id}") //Forzosamente debe llamarse id
	public String actualizar(@Valid @ModelAttribute("idea") Idea idea,
							 BindingResult result /*Mostrar e identificar los errores*/  ) {
		
		if(result.hasErrors()) {
			return "editar.jsp";
		} else {
			
			//ALTO cuidado: los atributos que se refieren a las personas que dieron Me gusta y Comentarios se pierden
			//Hay que volverlos a establecer ;)
			
			Idea ideaConComentariosYLikes = servicioIdeas.buscarIdea(idea.getId());
			
			idea.setComentarios(ideaConComentariosYLikes.getComentarios());
			idea.setUsuariosFav(ideaConComentariosYLikes.getUsuariosFav());
			
			servicioIdeas.guardarIdea(idea);
			return "redirect:/dashboard";
		}	
	}
	
	
}
