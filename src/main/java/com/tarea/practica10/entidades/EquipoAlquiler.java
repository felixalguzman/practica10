package com.tarea.practica10.entidades;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class EquipoAlquiler implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Equipo equipo;


    public EquipoAlquiler() {
    }

    public EquipoAlquiler(Equipo equipo) {
        this.equipo = equipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }
}
