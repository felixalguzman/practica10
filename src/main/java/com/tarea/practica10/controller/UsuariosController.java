package com.tarea.practica10.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import com.tarea.practica10.entidades.Usuario;
import com.tarea.practica10.servicios.RolServices;
import com.tarea.practica10.servicios.UsuarioServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    @RequestMapping("/index/usuarios")
    public String usuarios(Model model) {
        model.addAttribute("titulo", "Usuarios");
        return "/freemarker/usuarios";
    }

    @ResponseBody
    @RequestMapping(value = "/usuarios", produces = { "application/json" })
    public List<Usuario> usuarios() {
        return usuariosServices.obtenerUsuarios();
    }

    @RequestMapping(value = "/usuario/crear", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<List<Usuario>> crearUsuario(@RequestBody List<Usuario> usuarioList) {

        for (Usuario usuario : usuarioList) {
            
            usuario.setPassword(bCryptPasswordEncoder.encode(usuario.getPassword()));
            usuariosServices.guardarUsuario(usuario);
        }

        return new ResponseEntity<>(usuarioList, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/usuario/eliminar/{id}", method = RequestMethod.POST)
    public ResponseEntity<Long> eliminarUsuario(@PathVariable(value ="id") long id) {

        System.out.println("id:  " + id);
        usuariosServices.eliminarUsuario(id);

        return new ResponseEntity<>(id, HttpStatus.OK);
   
    }



}