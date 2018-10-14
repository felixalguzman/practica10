package com.tarea.practica10.controller;

import com.tarea.practica10.entidades.Alquiler;
import com.tarea.practica10.entidades.Cliente;
import com.tarea.practica10.entidades.Equipo;
import com.tarea.practica10.entidades.EquipoAlquiler;
import com.tarea.practica10.servicios.*;
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
import java.util.*;

@Controller
public class AlquilerController {

    @Autowired
    AlquilerServices alquilerServices;

    @Autowired
    ClienteServices clienteServices;

    @Autowired
    EquipoServices equipoServices;

    @Autowired
    EquipoAlquilerServices equipoAlquilerServices;


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


    @RequestMapping(value = "/alquiler/crear", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<List<AlquilerParametro>> crearAlquiler(@RequestBody List<AlquilerParametro> alquilerParametroList) {

        Alquiler alquiler = new Alquiler();
        AlquilerParametro alquilerParametro = alquilerParametroList.get(0);
        System.out.println("" + alquilerParametro.getFechaEntrega());

        int cant = 0;
        for(String s: alquilerParametro.getEquipos()){
            String[] parte = s.split(":");

            cant += Integer.parseInt(parte[1]);
        }
        Cliente cliente = clienteServices.buscarCliente(Integer.parseInt(alquilerParametro.getCliente()));
        Set<EquipoAlquiler> equipoAlquiler = equipoServices.buscarEquiposAlquiler(alquilerParametro.getEquipos());
        alquiler.setCantidadEquipos(cant);
        alquiler.setCliente(cliente);
        alquiler.setPendiente(true);

        alquiler.setEquipoAlquiler(equipoAlquiler);
        alquiler.setFecha(Date.valueOf(LocalDate.now()));
        Date fechaEntrega;
        try {

            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-mm-dd");
            sdf1.setLenient(false);
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


        alquiler.setCosto(10 * days * 4);

        alquilerServices.crearAlquiler(alquiler);


        return new ResponseEntity<>(alquilerParametroList, HttpStatus.OK);

    }


    @ResponseBody
    @RequestMapping(value = "/alquiler/buscar/{id}", method = RequestMethod.GET)
    public Alquiler buscarAlquiler(@PathVariable(value = "id") long id){

        return alquilerServices.buscarAlquiler(id);
    }

    @ResponseBody
    @RequestMapping(value = "/reporte/alquiler", produces = {"application/json"})
    public List<Map<Long, Long>> reporteCliente(){

        return alquilerServices.reporteAlquiler();
    }

    @ResponseBody
    @RequestMapping(value = "/reporte/equipos", produces = {"application/json"})
    public  List<Map<String, Map.Entry<String, Boolean>>> reporteEquipos(){

        return alquilerServices.reporteEquipos();
    }


    @RequestMapping(value = "/index/alquiler/reportes", method = RequestMethod.GET)
    public String reportesAlquileres(){

        return "/freemarker/reportes";
    }

    @ResponseBody
    @RequestMapping(value = "/alquiler/devolver/{id}", method = RequestMethod.POST)
    public ResponseEntity<Long> devolverEquipo(@PathVariable(value = "id") long id) {



        equipoAlquilerServices.devolverEquipo(id);

        return new ResponseEntity<>(id, HttpStatus.OK);

    }

}
