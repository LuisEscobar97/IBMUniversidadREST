package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Persona;

import java.util.Optional;

public interface AlumnoDAO extends PersonaDAO{

    public Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombre);
}
