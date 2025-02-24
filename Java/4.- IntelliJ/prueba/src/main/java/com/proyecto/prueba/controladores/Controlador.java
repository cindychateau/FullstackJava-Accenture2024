package com.proyecto.prueba.controladores;


import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "IntelliJ es genial!");
        return "index.jsp";
    }

}
