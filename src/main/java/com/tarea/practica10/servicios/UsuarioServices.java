package com.tarea.practica10.servicios;

import com.tarea.practica10.entidades.Rol;
import com.tarea.practica10.entidades.Usuario;
import com.tarea.practica10.repositorio.RolRepository;
import com.tarea.practica10.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UsuarioServices implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    //Para encriptar la información.
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    /**
     * Funcion para crear administrador
     */
    @Transactional
    public void crearAdmin() {

        if (buscarAdmin()) {

            Rol rol = new Rol("ROLE_ADMIN");
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

    private boolean buscarAdmin() {

        Usuario usuario = usuarioRepository.findByNombreAndPassword("admin",bCryptPasswordEncoder.encode("admin") );
        return usuario != null;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = usuarioRepository.findByUsuario(username);

        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        for (Rol role : user.getRolSet()) {
            roles.add(new SimpleGrantedAuthority(role.getNombre()));
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);

        return new org.springframework.security.core.userdetails.User(user.getUsuario(), user.getPassword(), user.isActivo(), true, true, true, grantedAuthorities);
    }
}
