package com.tarea.practica10.controller;

import com.tarea.practica10.entidades.Alquiler;
import com.tarea.practica10.entidades.Equipo;
import com.tarea.practica10.servicios.AlquilerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AlquilerController {

    @Autowired
    AlquilerServices alquilerServices;

    @RequestMapping("/index/alquileres")
    public String alquileres(Model model) {
        model.addAttribute("titulo", "Alquileres");
        return "/freemarker/alquileres";
    }

    @ResponseBody
    @RequestMapping(value = "/alquileres", produces = {"application/json"})
    public List<Alquiler> alquileres() {
        return alquilerServices.listaAlquileres();
    }

}
