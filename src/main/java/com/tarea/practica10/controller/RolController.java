package com.tarea.practica10.controller;

import java.util.List;

import com.tarea.practica10.entidades.Rol;
import com.tarea.practica10.servicios.RolServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * RolController
 */
@Controller
public class RolController {

    @Autowired
    RolServices rolServices;

    @RequestMapping(value = "/rol/crear", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Rol> crearRol(@RequestBody Rol rol) {

        rolServices.crearRol(rol);

        return new ResponseEntity<>(rol, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/roles", produces = { "application/json" })
    public List<Rol> roles() {
        return rolServices.listaRoles();
    }
}