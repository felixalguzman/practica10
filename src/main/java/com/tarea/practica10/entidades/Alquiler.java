package com.tarea.practica10.entidades;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

@Entity
public class Alquiler implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private Date fecha;

    private Date fechaEntrega;

    @OneToOne
    private Cliente cliente;

    @OneToMany
    private Set<Equipo> equipoSet;

    private int costo;

    public Alquiler() {
    }

    public Alquiler(Date fecha, Date fechaEntrega, Cliente cliente, Set<Equipo> equipoSet, int costo) {
        this.fecha = fecha;
        this.fechaEntrega = fechaEntrega;
        this.cliente = cliente;
        this.equipoSet = equipoSet;
        this.costo = costo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Set<Equipo> getEquipoSet() {
        return equipoSet;
    }

    public void setEquipoSet(Set<Equipo> equipoSet) {
        this.equipoSet = equipoSet;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
}
