package com.tarea.practica10.controller;

import com.tarea.practica10.entidades.Equipo;
import com.tarea.practica10.entidades.Usuario;
import com.tarea.practica10.servicios.EquipoServices;
import com.tarea.practica10.servicios.ImagenesServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EquiposController {

    @Autowired
    EquipoServices equipoServices;

    @Autowired
    ImagenesServices imagenesServices;

    @RequestMapping("/index/equipos")
    public String equipos(Model model) {
        model.addAttribute("titulo", "Equipos");
        return "/freemarker/equipos";
    }

    @ResponseBody
    @RequestMapping(value = "/equipos", produces = { "application/json" })
    public List<Equipo> equipos() {
        return equipoServices.buscarEquipos();
    }

    @RequestMapping(value = "/equipo/crear", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<List<Equipo>> crearUsuario(@RequestBody List<Equipo> equipoList) {

        for (Equipo equipo: equipoList) {

            equipoServices.crearEquipo(equipo);
        }

        return new ResponseEntity<>(equipoList, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/equipo/eliminar/{id}", method = RequestMethod.POST)
    public ResponseEntity<Long> eliminarEquipo(@PathVariable(value ="id") long id) {

        System.out.println("id:  " + id);
//        equipoServices.e(id);

        return new ResponseEntity<>(id, HttpStatus.OK);

    }
}
