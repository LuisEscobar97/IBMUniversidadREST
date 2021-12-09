package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.entities.Profesor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProfesorDAO extends PersonaDAO {


    public Iterable<Persona> findPorfesoresesByNombreCarrera(String nombre);

    public Persona actualizar(Persona profesorEncontrado, Persona profesor);
    public Persona asociarCarreraProfesor(Persona alumno, Carrera carrera);

}
