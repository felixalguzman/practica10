package com.tarea.practica10.controller;

import java.util.List;

import com.tarea.practica10.entidades.Cliente;
import com.tarea.practica10.servicios.ClienteServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * ClientesController
 */
@Controller
public class ClientesController {

    @Autowired
    private ClienteServices clienteServices;

    @RequestMapping("/index/clientes")
    public String clientes(Model model) {
        model.addAttribute("titulo", "Clientes");
        return "/freemarker/clientes";
    }


    @RequestMapping(value = "/clientes/crear", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<List<Cliente>> crearCliente(@RequestBody List<Cliente> clientesList) {

        for (Cliente cliente : clientesList) {

            clienteServices.crearCliente(cliente);

        }

        return new ResponseEntity<>(clientesList, HttpStatus.OK);
    }


    @ResponseBody
    @RequestMapping(value = "/clientes", produces = {"application/json"})
    public List<Cliente> clientes() {
        return clienteServices.listaClientes();
    }

    @ResponseBody
    @RequestMapping(value = "/cliente/{id}", produces = {"application/json"})
    public Cliente buscarCliente(@PathVariable(value = "id") long id) {
        return clienteServices.buscarCliente(id);
    }

    @RequestMapping(value = "/cliente/eliminar/{id}", method = RequestMethod.POST)
    public ResponseEntity<Long> eliminarCliente(@PathVariable(value = "id") long id) {


        Cliente cliente = clienteServices.buscarCliente(id);

        clienteServices.eliminarCliente(cliente);
        

        return new ResponseEntity<>(id, HttpStatus.OK);

    }

}