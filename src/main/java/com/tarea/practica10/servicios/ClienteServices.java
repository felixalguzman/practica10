package com.tarea.practica10.servicios;

import java.util.List;

import com.tarea.practica10.entidades.Cliente;
import com.tarea.practica10.repositorio.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClienteServices
 */
@Service
public class ClienteServices {

    @Autowired
    ClienteRepository clienteRepository;

    @Transactional
    public void crearCliente(Cliente cliente) {

        clienteRepository.save(cliente);
        
    }

    public List<Cliente> listaClientes() {
        
        return clienteRepository.findAll();
    }

    
}