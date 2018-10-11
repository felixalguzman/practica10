package com.tarea.practica10.controller;

import com.tarea.practica10.entidades.Alquiler;
import com.tarea.practica10.entidades.Cliente;
import com.tarea.practica10.entidades.Equipo;
import com.tarea.practica10.servicios.AlquilerParametro;
import com.tarea.practica10.servicios.AlquilerServices;
import com.tarea.practica10.servicios.ClienteServices;
import com.tarea.practica10.servicios.EquipoServices;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

@Controller
public class AlquilerController {

    @Autowired
    AlquilerServices alquilerServices;

    @Autowired
    ClienteServices clienteServices;

    @Autowired
    EquipoServices equipoServices;


    @RequestMapping("/index/alquileres")
    public String alquileres(Model model) {
        model.addAttribute("titulo", "Alquileres");
        return "/freemarker/alquileres";
    }

    @ResponseBody
    @RequestMapping(value = "/alquileres", produces = {"application/json"})
    public List<Alquiler> alquileres() {
        return alquilerServices.listaAlquileres();
    }


    @RequestMapping(value = "/alquiler/crear", method = RequestMethod.POST,  consumes = "application/json")
    public ResponseEntity<List<AlquilerParametro>> crearAlquiler(@RequestBody List<AlquilerParametro> alquilerParametroList) {

        Alquiler alquiler = new Alquiler();
        AlquilerParametro alquilerParametro = alquilerParametroList.get(0);
        System.out.println(""+ alquilerParametro.getFechaEntrega());

        Cliente cliente = clienteServices.buscarCliente(Integer.parseInt(alquilerParametro.getCliente()));
        Set<Equipo> equipoList = equipoServices.buscarEquiposAlquiler(alquilerParametro.getEquipos());

        alquiler.setCliente(cliente);
        alquiler.setPendiente(true);
        alquiler.setEquipoSet(equipoList);
        alquiler.setFecha(Date.valueOf(LocalDate.now()));
        Date fechaEntrega;
        try {

            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
            java.util.Date date = sdf1.parse(alquilerParametro.getFechaEntrega());
            fechaEntrega = new java.sql.Date(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();

            fechaEntrega = Date.valueOf(LocalDate.now().plusDays(1));
        }

        alquiler.setFechaEntrega(fechaEntrega);

        Calendar calendarHoy = Calendar.getInstance();
        calendarHoy.setTime(java.util.Date.from(Instant.now()));

        Calendar calendarEntrega = Calendar.getInstance();
        calendarEntrega.setTime(fechaEntrega);

        DateTime dateTime = new DateTime(calendarHoy);
        DateTime dateTimeFin = new DateTime(fechaEntrega);


        int days = Days.daysBetween(dateTime, dateTimeFin).getDays();


        alquiler.setCosto(10*days*4);
//
//
        alquilerServices.crearAlquiler(alquiler);


        return new ResponseEntity<>(alquilerParametroList, HttpStatus.OK);

    }

}
