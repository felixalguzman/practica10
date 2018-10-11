package com.tarea.practica10.repositorio;

import com.tarea.practica10.entidades.Alquiler;
import com.tarea.practica10.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Long> {

    Alquiler findById(long id);

    List<Alquiler> findAllByCliente(Cliente cliente);

    List<Alquiler> findAllByPendienteOrderByFechaEntregaDesc(Boolean aBoolean);

}
