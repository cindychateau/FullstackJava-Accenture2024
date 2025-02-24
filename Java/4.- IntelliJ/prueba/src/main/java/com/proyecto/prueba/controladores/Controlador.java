package com.proyecto.prueba.controladores;


import com.proyecto.prueba.modelos.Producto;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "IntelliJ es genial!");

        Producto producto = new Producto(1L, "Libreta", "Libreta de espiral");

        return "index.jsp";
    }

    //TODO: Más rutas

}
