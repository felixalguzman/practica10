package com.tarea.practica10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/index")
public class RutasController {

  
    @RequestMapping(value = {"/"})
    public String index(Model model) {

        model.addAttribute("titulo", "Inicio");
        
        return "/freemarker/index";
    }

 

    



}
