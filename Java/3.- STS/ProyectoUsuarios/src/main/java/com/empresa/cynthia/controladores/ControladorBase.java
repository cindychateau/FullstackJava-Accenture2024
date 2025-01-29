package com.empresa.cynthia.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@ - Anotación
@RestController //Indica que el archivo es un controlador, estableciendo rutas
public class ControladorBase {
	
	//NO PUEDO repetir ni la ruta, ni el nombre método (excepción: sobrecarga)
	@GetMapping("/") //Establezco una ruta, que ejecuta el método y muestra lo que tengo en return
	public String home() {
		return "<h1>¡Hola desde Spring!</h1>";
	}
	
	@GetMapping("/muestra")
	public String muestraUsuarios() {
		String usuarios[] = {"Elena de Troya", "Juana de Arco", "Pablo Picasso", "Pedro Páramo"};
		String respuesta = "<ul>";
		for(int i=0; i < usuarios.length; i++) {
			//<li>Juana de Arco</li>
			respuesta += "<li>"+usuarios[i]+"</li>"; //
		}
		respuesta += "</ul>";
		return respuesta;
	}
	
	@GetMapping("/search") // localhost:8080/search?q=sts
	public String buscar(@RequestParam(value="q")String termino) {
		//termino = "sts"
		return "<h1>Estás buscando:"+termino+"</h1>"; // Estás buscando: sts
	}
	
	// localhost:8080/usuarios?id=1
	
	@GetMapping("/hola") // localhost:8080/hola?nombre=Elena
	public String hola(@RequestParam(value="nombre", required=false) String name) {
		if(name == null){
			return "<h2>¡Hola desconocido</h2>";
		}
		return "<h2>¡Hola "+name+"! </h2>"; // ¡Hola Elena!
	}
	
	@GetMapping("/holaConApellido") // localhost:8080/holaConApellido?nombre=Elena&apellido=de Troya
	public String holaConApellido(@RequestParam(value="nombre") String firstName, //firstName = Elena
								  @RequestParam(value="apellido") String lastName) { //lastName= de Troya
		return "Saludos cordiales "+firstName+" "+lastName;
	}
	
	@GetMapping("/hello/{nombre}") // localhost:8080/hello/Elena
	public String hello(@PathVariable("nombre") String name) {
		return "<h1>Hello "+name+"</h1>";
	}
	
	@GetMapping("/hello/{nombre}/{apellido}") // localhost:8080/hello/Elena/De Troya
	public String hello(@PathVariable("nombre") String name,
						@PathVariable("apellido") String lastName) {
		return "<h1>Salutations "+name+ " "+lastName+"</h1>";
	}
	
	// localhost:8080/hello/Elena/De Troya/3
	@GetMapping("/hello/{nombre}/{apellido}/{cantidad}")
	public String hello(@PathVariable("nombre") String name,
						@PathVariable("apellido") String lastName,
						@PathVariable("cantidad") int num) {
		String respuesta = "";
		for(int x=0; x<num; x++) {
			// lista[x]
			respuesta += "<h2>Hello "+name+" "+lastName+"</h2>";
		}
		
		return respuesta;
	}
	
}