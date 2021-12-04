package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Carrera;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface CarreraDAO extends GenericoDAO<Carrera>{

    public Iterable<Carrera> findCarrerasByNombreContains(String nombre);
    public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);
    public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);
    public Iterable<Carrera> findCarrerasByProfesorNombreAndApellido(String nombre, String apellido);

}
