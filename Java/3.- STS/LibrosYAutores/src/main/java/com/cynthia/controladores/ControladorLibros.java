package com.cynthia.controladores;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/libros")
public class ControladorLibros {
	
	private static HashMap<String, String> listaLibros = new HashMap<String, String>();
	
	public ControladorLibros() {
		listaLibros.put("Odisea", "Homero");	
		listaLibros.put("Don Quijote de la Mancha", "Miguel de Cervantes");
		listaLibros.put("El Código Da Vinci", "Dan Brown");		
		listaLibros.put("Alicia en el país de las maravillas", "Lewis Carroll");
		listaLibros.put("El Hobbit", "J.R.R. Tolkien");	
		listaLibros.put("El alquimista", "Paulo Coelho");	
	}
	
	@GetMapping("")
	public String obtenerTodosLosLibros(Model model) {
		model.addAttribute("listaLibros", listaLibros);
		return "libros.jsp";
	}
	
	@GetMapping("/{nombre}") // localhost:8080/libros/Odisea
	public String obtenerInformacionDeLibro(@PathVariable("nombre") String nombreLibro,
											Model model) {
		
		if(listaLibros.containsKey(nombreLibro)){
			String autor = listaLibros.get(nombreLibro); //Obtengo el autor en base a la llave
			model.addAttribute("mensaje", autor+" - "+nombreLibro);
		} else {
			model.addAttribute("mensaje", "El libro no se encuentra en nuestra lista.");
		}
		
		return "detalleLibro.jsp";
		
	}
	
	@GetMapping("/formulario")
	public String formularioLibro() {
		return "formularioLibros.jsp";
	}
	

}
