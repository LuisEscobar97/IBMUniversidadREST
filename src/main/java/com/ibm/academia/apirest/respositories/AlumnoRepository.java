package com.ibm.academia.apirest.respositories;

import com.ibm.academia.apirest.entities.Persona;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("respositorioAlumnos")
public interface AlumnoRepository extends PersonaRepository
{
    @Query("select a from Alumno a join fetch a.carrera c where c.nombre = :parametroCarrera")
    public Iterable<Persona> buscarAlumnoPorNombreCarrera(@Param("parametroCarrera") String nombre);
}
