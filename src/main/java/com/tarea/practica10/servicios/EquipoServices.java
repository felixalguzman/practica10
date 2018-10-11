package com.tarea.practica10.servicios;

import com.tarea.practica10.entidades.Equipo;
import com.tarea.practica10.repositorio.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Set<Equipo> buscarEquiposAlquiler(List<String> equipos){

        Set<Equipo> equipoList = new HashSet<>();
        for (String s: equipos){

            String[] parte = s.split(":");

            Equipo equipo = buscarEquipo(Integer.parseInt(parte[0]));
            equipo.setCantidad( equipo.getCantidad() - Integer.parseInt(parte[1]));

            crearEquipo(equipo);
            equipoList.add(equipo);

        }

        return equipoList;
    }
}
