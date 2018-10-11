package com.tarea.practica10.servicios;

import com.tarea.practica10.entidades.Equipo;
import com.tarea.practica10.repositorio.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EquipoServices {

    @Autowired
    EquipoRepository equipoRepository;

    @Transactional
    public void crearEquipo(Equipo equipo){

        equipoRepository.save(equipo);

    }

    @Transactional
    public void eliminarEquipo(Equipo equipo){

        equipo.setActivo(false);
        equipoRepository.save(equipo);

    }

    public Equipo buscarEquipo(long id){

        return equipoRepository.findById(id);
    }

    public List<Equipo> buscarEquipos(){

        return equipoRepository.findAll();
    }

    public List<Equipo> buscarEquiposDisponibles(){

        return equipoRepository.findAllByActivoOrderByDisponibleDesc(true);
    }
}
