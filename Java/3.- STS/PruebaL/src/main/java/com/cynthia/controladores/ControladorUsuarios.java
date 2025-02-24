package com.cynthia.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cynthia.modelos.LoginUsuario;
import com.cynthia.modelos.Usuario;
import com.cynthia.servicios.ServicioUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {
	
	@Autowired
	private ServicioUsuarios serv;
	
	@GetMapping("/")
	public String index(@ModelAttribute("nuevoUsuario") Usuario nuevoUsuario,
						@ModelAttribute("loginUsuario") LoginUsuario loginUsuario) {
		return "index.jsp";
	}
	
	@PostMapping("/registro")
	public String registro(@Valid @ModelAttribute("nuevoUsuario") Usuario nuevoUsuario,
						   BindingResult result,
						   HttpSession session,
						   Model model) {
		serv.registrar(nuevoUsuario, result);
		
		if(result.hasErrors()) {
			model.addAttribute("loginUsuario", new LoginUsuario());
			return "index.jsp";
		} else {
			//Guardo al nuevo usuario en sesión
			session.setAttribute("usuarioEnSesion", nuevoUsuario);
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session) {
		//Validación de que el usuario inició sesión
		Usuario userTemp = (Usuario) session.getAttribute("usuarioEnSesion"); //Obj User o null
		if(userTemp == null) {
			return "redirect:/";
		}
		
		return "dashboard.jsp";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario,
						BindingResult result,
						Model model,
						HttpSession session) {
		
		Usuario usuario = serv.login(loginUsuario, result);
		if(result.hasErrors()) {
			model.addAttribute("nuevoUsuario", new Usuario());
			return "index.jsp";
		}
		
		session.setAttribute("usuarioEnSesion", usuario);
		return "redirect:/dashboard";
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_session");
		return "redirect:/";
	}
}
