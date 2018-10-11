package com.tarea.practica10.servicios;

import com.tarea.practica10.entidades.Alquiler;
import com.tarea.practica10.entidades.Cliente;
import com.tarea.practica10.repositorio.AlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlquilerServices {

    @Autowired
    AlquilerRepository alquilerRepository;

    @Transactional
    public void crearAlquiler(Alquiler alquiler){

        alquilerRepository.save(alquiler);
    }

    public List<Alquiler> listaAlquileres(){

        return alquilerRepository.findAllByPendiente(true);
    }

    public List<Alquiler> alquilerCliente(Cliente cliente){
        return alquilerRepository.findAllByCliente(cliente);
    }


}
