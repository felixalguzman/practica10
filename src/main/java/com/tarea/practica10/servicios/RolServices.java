package com.tarea.practica10.servicios;

import java.util.List;

import com.tarea.practica10.entidades.Rol;
import com.tarea.practica10.repositorio.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * RolServices
 */
@Service
public class RolServices {

    @Autowired
    RolRepository rolRepository;

    @Transactional
    public void crearRol(Rol rol) {
        
        rolRepository.save(rol);
    }

    public List<Rol> listaRoles() {
        
        return rolRepository.findAll();
    }

    
}