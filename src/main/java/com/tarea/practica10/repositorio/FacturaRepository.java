package com.tarea.practica10.repositorio;

import com.tarea.practica10.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {

    Factura findById(long id);

}
