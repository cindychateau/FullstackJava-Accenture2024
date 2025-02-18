package com.empresa.cynthia.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Controller
public class ControladorPokemon {
	
	@GetMapping("/pokemones")
	public String pokemones(Model model) {
		String url = "https://pokeapi.co/api/v2/pokemon?limit=1500";
		RestTemplate restTemplate = new RestTemplate();
		Object respuesta = restTemplate.getForObject(url, Object.class);
		//respuesta.count, respuesta.next, respuesta.results
		
		model.addAttribute("respuesta", respuesta);
		
		return "pokemones.jsp";
		
	}
	
	@GetMapping("/pokemon/{nombrePokemon}")
	public String pokemon(@PathVariable("nombrePokemon") String nombrePokemon,
						  Model model) {
		
		String url = "https://pokeapi.co/api/v2/pokemon/"+nombrePokemon;
		RestTemplate restTemplate = new RestTemplate();
		Object respuesta = restTemplate.getForObject(url, Object.class);
		
		model.addAttribute("pokemon", respuesta);
		
		return "pokemon.jsp";
		
	}
	
}
