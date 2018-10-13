package com.tarea.practica10.repositorio;

import com.tarea.practica10.entidades.Equipo;
import com.tarea.practica10.entidades.EquipoAlquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoAlquilerRepository extends JpaRepository<EquipoAlquiler, Long> {

    EquipoAlquiler findById(long id);
    EquipoAlquiler findByEquipo(Equipo equipo);

}
