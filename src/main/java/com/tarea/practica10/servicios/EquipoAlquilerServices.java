package com.tarea.practica10.servicios;

import com.tarea.practica10.entidades.Equipo;
import com.tarea.practica10.entidades.EquipoAlquiler;
import com.tarea.practica10.repositorio.EquipoAlquilerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class EquipoAlquilerServices {

    @Autowired
    EquipoAlquilerRepository equipoAlquilerRepository;

    @Transactional
    public void crearEquipoAlquiler(EquipoAlquiler equipoAlquiler) {

        equipoAlquilerRepository.save(equipoAlquiler);

    }

    public List<Equipo> obtenerEquiposAlquiler(Set<EquipoAlquiler> equipoAlquilerSet) {

        List<Equipo> equipoList = new ArrayList<>();

        for (EquipoAlquiler equipoAlquiler : equipoAlquilerSet) {

            equipoList.add(equipoAlquiler.getEquipo());

        }

        return equipoList;
    }


    public void devolverEquipo(long id){

        EquipoAlquiler equipoAlquiler = equipoAlquilerRepository.findById(id);
        equipoAlquiler.setDevuelto(!equipoAlquiler.getDevuelto());
        equipoAlquilerRepository.save(equipoAlquiler);

    }
}
