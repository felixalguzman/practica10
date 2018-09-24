package com.tarea.practica10;

import com.tarea.practica10.config.ConfiguracionSeguridad;
import com.tarea.practica10.entidades.Usuario;
import com.tarea.practica10.servicios.UsuarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Practica10Application {


    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Practica10Application.class, args);


        UsuarioServices usuarioServices = (UsuarioServices) applicationContext.getBean("usuarioServices");
        usuarioServices.crearAdmin();





    }


}
