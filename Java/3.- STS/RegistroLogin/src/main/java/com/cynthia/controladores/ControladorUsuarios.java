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

import jakarta.validation.Valid;

@Controller
public class ControladorUsuarios {
	
	@Autowired
	private ServicioUsuarios servicioUsuario;
	
	@GetMapping("/")
	public String index(@ModelAttribute("nuevoUsuario") Usuario nuevoUsuario,
					    @ModelAttribute("loginUsuario") LoginUsuario loginUsuario) {
		return "index.jsp";
	}
	
	@PostMapping("/registro")
	public String registro(@Valid @ModelAttribute("nuevoUsuario") Usuario nuevoUsuario,
						   BindingResult result,
						   Model model) {
		
		servicioUsuario.registrar(nuevoUsuario, result);
		
		if(result.hasErrors()) {
			model.addAttribute("loginUsuario", new LoginUsuario());
			return "index.jsp";
		} else {
			return "redirect:/dashboard";
		}
		
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "dashboard.jsp";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("loginUsuario") LoginUsuario loginUsuario,
						BindingResult result,
						Model model) {
		
		Usuario usuarioIntentandoLogin = servicioUsuario.login(loginUsuario, result);
		if(result.hasErrors()) {
			model.addAttribute("nuevoUsuario", new Usuario());
			return "index.jsp";
		} else {
			return "redirect:/dashboard";
		}
		
	}
	
}
