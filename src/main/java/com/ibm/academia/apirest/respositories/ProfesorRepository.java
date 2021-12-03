package com.ibm.academia.apirest.respositories;

import com.ibm.academia.apirest.entities.Persona;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("respositorioProfesores")
public interface ProfesorRepository extends PersonaRepository{

    @Query("select p from Profesor p join fetch p.carreras c where c.nombre = :parametroCarrera")
    public Iterable<Persona> buscarPorfesoresesPorNombreCarrera(@Param("parametroCarrera") String nombre);
}
