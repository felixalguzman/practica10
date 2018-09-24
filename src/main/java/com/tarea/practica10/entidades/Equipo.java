package com.tarea.practica10.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Equipo implements Serializable {


    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private int tarifa;

    private String foto;

    private String familia;

    private String subFamilia;

    @ManyToOne
    private Alquiler alquiler;

    public Equipo() {
    }

    public Equipo(String nombre, int tarifa, String foto, String familia, String subFamilia, Alquiler alquiler) {
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.foto = foto;
        this.familia = familia;
        this.subFamilia = subFamilia;
        this.alquiler = alquiler;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTarifa() {
        return tarifa;
    }

    public void setTarifa(int tarifa) {
        this.tarifa = tarifa;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public String getSubFamilia() {
        return subFamilia;
    }

    public void setSubFamilia(String subFamilia) {
        this.subFamilia = subFamilia;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }
}
