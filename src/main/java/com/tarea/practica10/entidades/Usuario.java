package com.tarea.practica10.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Usuario implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @OneToMany
    private Set<Rol> rolSet;

    public Usuario() {
    }

    public Usuario(String nombre, Set<Rol> rolSet) {
        this.nombre = nombre;
        this.rolSet = rolSet;
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

    public Set<Rol> getRolSet() {
        return rolSet;
    }

    public void setRolSet(Set<Rol> rolSet) {
        this.rolSet = rolSet;
    }
}