package com.tarea.practica10.repositorio;

import com.tarea.practica10.entidades.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByNombre(String nombre);
    List<Cliente> findAllByActivo(Boolean aBoolean);
    Cliente findById(long id);
}