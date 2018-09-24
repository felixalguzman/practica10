package com.tarea.practica10.servicios;

import com.tarea.practica10.entidades.Rol;
import com.tarea.practica10.entidades.Usuario;
import com.tarea.practica10.repositorio.RolRepository;
import com.tarea.practica10.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    //Para encriptar la información.
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Transactional
    public void crearAdmin(){

        Rol rol =new Rol("ROLE_ADMIN");
        rolRepository.save(rol);


        Usuario admin = new Usuario();
        admin.setNombre("admin");
        admin.setUsuario("admin");
        admin.setPassword(bCryptPasswordEncoder.encode("admin"));
        admin.setActivo(true);
        admin.setRolSet(new HashSet<>(Arrays.asList(rol)));

        usuarioRepository.save(admin);
    }
}
