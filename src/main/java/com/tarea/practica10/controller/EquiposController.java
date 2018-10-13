package com.tarea.practica10.controller;

import com.tarea.practica10.entidades.Equipo;
import com.tarea.practica10.servicios.EquipoServices;
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


    @RequestMapping("/index/equipos")
    public String equipos(Model model) {
        model.addAttribute("titulo", "Equipos");
        return "/freemarker/equipos";
    }

    @ResponseBody
    @RequestMapping(value = "/equiposDisponibles", produces = {"application/json"})
    public List<Equipo> equiposDisponibles() {
        return equipoServices.buscarEquiposDisponibles();
    }

    @ResponseBody
    @RequestMapping(value = "/equipos", produces = {"application/json"})
    public List<Equipo> equipos() {
        return equipoServices.buscarEquipos();
    }

    @RequestMapping(value = "/equipo/crear", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<List<Equipo>> crearEquipo(@RequestBody List<Equipo> equipoList) {

        for (Equipo equipo : equipoList) {

            equipoServices.crearEquipo(equipo);
        }

        return new ResponseEntity<>(equipoList, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/equipo/buscar/{id}", method = RequestMethod.GET)
    public Equipo buscarEquipo(@PathVariable(value = "id") long id) {


        return equipoServices.buscarEquipo(id);


    }

    @ResponseBody
    @RequestMapping(value = "/equipo/eliminar/{id}", method = RequestMethod.POST)
    public ResponseEntity<Long> eliminarEquipo(@PathVariable(value = "id") long id) {

        System.out.println("id:  " + id);
        Equipo equipo = equipoServices.buscarEquipo(id);
        equipoServices.eliminarEquipo(equipo);

        return new ResponseEntity<>(id, HttpStatus.OK);

    }


}
