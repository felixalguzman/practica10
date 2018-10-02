package com.tarea.practica10.controller;

import java.util.List;

import com.tarea.practica10.entidades.Rol;
import com.tarea.practica10.entidades.Usuario;
import com.tarea.practica10.servicios.RolServices;
import com.tarea.practica10.servicios.UsuarioServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * UsuariosController
 */
@Controller()
public class UsuariosController {

    @Autowired
    UsuarioServices usuariosServices;

    @Autowired
    RolServices rolServices;

    @RequestMapping("/index/usuarios")
    public String index(Model model) {
        model.addAttribute("titulo", "Usuarios");

        model.addAttribute("roles", rolServices.listaRoles());

        return "/freemarker/usuarios";
    }

    @ResponseBody
    @RequestMapping(value = "/usuarios", produces = { "application/json" })
    public List<Usuario> usuarios() {
        return usuariosServices.obtenerUsuarios();
    }

    @RequestMapping(value = "/usuario/crear", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usuario) {

        usuariosServices.guardarUsuario(usuario);

        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }



}