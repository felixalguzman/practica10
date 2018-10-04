package com.tarea.practica10.repositorio;

import com.tarea.practica10.entidades.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByNombre(String nombre);
}