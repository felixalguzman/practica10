package com.tarea.practica10.servicios;

import com.tarea.practica10.entidades.EquipoAlquiler;
import com.tarea.practica10.repositorio.EquipoAlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EquipoAlquilerServices {

    @Autowired
    EquipoAlquilerRepository equipoAlquilerRepository;

    @Transactional
    public void crearEquipoAlquiler(EquipoAlquiler equipoAlquiler){

        equipoAlquilerRepository.save(equipoAlquiler);

    }
}
