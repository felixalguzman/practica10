package com.tarea.practica10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RutasController {

    @RequestMapping("/login")
    public String login(Model model){
        return "/freemarker/login";
    }

    @RequestMapping("/index")
    public String index(Model model) {
        
        return "/freemarker/index";
    }


}
