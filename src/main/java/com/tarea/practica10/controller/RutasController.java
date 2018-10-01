package com.tarea.practica10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class RutasController {

    @RequestMapping("/login")
    public String login(Model model, @RequestParam Optional<String> error){
        model.addAttribute("error", error);
        return "/freemarker/login";
    }

    @RequestMapping(value = {"/index", "/"})
    public String index(Model model) {
        
        return "/freemarker/index";
    }

    



}
