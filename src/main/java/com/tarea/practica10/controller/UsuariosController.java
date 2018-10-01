package com.tarea.practica10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * UsuariosController
 */
@Controller()
public class UsuariosController {


    @RequestMapping("/index/usuarios")
    public String  index(Model model) {
        model.addAttribute("titulo", "Usuarios");

        return "/freemarker/usuarios";
    }

    
}