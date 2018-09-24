package com.tarea.practica10.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RutasController {

    @RequestMapping("/")
    public String login(Model model){
        return "/thymeleaf/login";
    }
}
