package com.ibm.academia.apirest.controllers;

import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.services.CarreraDAO;
import com.ibm.academia.apirest.services.CarreraDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carreras")
public class CarreraController {
    @Autowired
    CarreraDAO carreraDAO;

    @PostMapping("/save")
    public Carrera save(@RequestBody Carrera carrera){
        return  carreraDAO.guardar(carrera);
    }

    @GetMapping("/profesor")
    public ResponseEntity<Carrera> getCarrerasByProfesores(@RequestParam(name = "nombre")String nombre, @RequestParam(name = "apellido") String apellido){
        List<Carrera>carreras= (List<Carrera>) carreraDAO.findCarrerasByProfesorNombreAndApellido(nombre,apellido);
            if (!carreras.isEmpty()){
                for (Carrera carrera:carreras){
                    return new ResponseEntity<>(carrera, HttpStatus.OK);
                }
            }else{
                return  new ResponseEntity<Carrera>((Carrera) null,HttpStatus.BAD_REQUEST);
            }
            return null;

    }
}
