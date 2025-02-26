package com.cynthia.controladores;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cynthia.modelos.Imagen;
import com.cynthia.servicios.ServicioImagenes;

@Controller
public class ControladorImagenes {
	
	@Autowired
	private ServicioImagenes servicioImagenes;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Imagen> listaImagenes = servicioImagenes.obtenerImagenes();
		model.addAttribute("listaImagenes", listaImagenes);
		return "index.jsp";
	}
	
	@GetMapping("/imagen/nueva")
	public String nueva() {
		return "nueva.jsp";
	}
	
	//Método para guardar la imagen
	@PostMapping("/imagen/cargar")
	public String cargarImagen(@RequestParam("imagen") MultipartFile archivo) throws IOException {
		
		if(archivo.isEmpty()) {
			return "redirect:/imagen/nueva";
		}
		
		/*Establece la ruta y el nombre de la imagen*/
		//String nombreImagen = archivo.getOriginalFilename();
		//String nombreImagen = new Date().toString() +"_"+ archivo.getOriginalFilename();
		String nombreImagen = UUID.randomUUID().toString()+"_"+ archivo.getOriginalFilename(); //.getContentType();
		String rutaBase = "/Users/cynthia/Desktop/imagenesJava/";
		String rutaCompleta = rutaBase + nombreImagen;
		
		/*Guardar en base de datos la ruta y el nombre*/
		Imagen nuevaImagen = new Imagen(rutaCompleta, nombreImagen);
		servicioImagenes.guardarImagen(nuevaImagen);
		
		/*Guarda la imagen en la carpeta*/
		archivo.transferTo(new File(rutaCompleta));
		
		return "redirect:/";
		
	}
	
}
