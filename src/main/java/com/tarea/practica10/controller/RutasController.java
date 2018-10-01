package com.tarea.practica10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller("/index")
public class RutasController {

  
    @RequestMapping(value = {"/"})
    public String index(Model model) {

        model.addAttribute("titulo", "Inicio");
        
        return "/freemarker/index";
    }

    



}
