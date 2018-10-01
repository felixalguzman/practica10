package com.tarea.practica10.controller;

import java.util.List;

import com.tarea.practica10.entidades.Usuario;
import com.tarea.practica10.servicios.UsuarioServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * UsuariosController
 */
@Controller()
public class UsuariosController {

    @Autowired
    UsuarioServices usuariosServices;

    @RequestMapping("/index/usuarios")
    public String  index(Model model) {
        model.addAttribute("titulo", "Usuarios");

        return "/freemarker/usuarios";
    }

    @ResponseBody
    @RequestMapping(value = "/usuarios", produces = {"application/json"})
    public List<Usuario> usuarios(){
        return usuariosServices.obtenerUsuarios();
    }

    
}