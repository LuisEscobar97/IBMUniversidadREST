package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProfesorDAO extends PersonaDAO {


    public Iterable<Persona> findPorfesoresesByNombreCarrera(String nombre);

}
