package com.tarea.practica10.repositorio;

import com.tarea.practica10.entidades.Rol;
import com.tarea.practica10.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {


    Usuario findFirstByRolSetEquals(Set<Rol> rol);
}
