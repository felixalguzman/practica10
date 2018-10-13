package com.tarea.practica10.servicios;

import com.tarea.practica10.entidades.Factura;
import com.tarea.practica10.repositorio.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FacturaServices {

    @Autowired
    FacturaRepository facturaRepository;

    @Transactional
    public void crearFactura(Factura factura){

        facturaRepository.save(factura);
    }

    public List<Factura> listaFacturas(){

        return facturaRepository.findAll();
    }

}
