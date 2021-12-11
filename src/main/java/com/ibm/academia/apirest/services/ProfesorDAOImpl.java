package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.entities.Profesor;
import com.ibm.academia.apirest.respositories.PersonaRepository;
import com.ibm.academia.apirest.respositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO{



    public ProfesorDAOImpl(@Qualifier("respositorioProfesores")PersonaRepository personaRepository) {
        super(personaRepository);
    }


    @Override

    public Iterable<Persona> findPorfesoresesByNombreCarrera(String nombre) {
        return ((ProfesorRepository)repository).buscarPorfesoresesPorNombreCarrera(nombre);
    }



    @Override
    public Persona actualizar(Persona profesorEncontrado, Persona profesor) {
        Persona profesorActulizado = null;
        profesorEncontrado.setNombre(profesor.getNombre());
        profesorEncontrado.setApellido(profesor.getApellido());
        profesorEncontrado.setDireccion(profesor.getDireccion());
        ((Profesor)profesorEncontrado).setSueldo(((Profesor)profesor).getSueldo());
        profesorActulizado = repository.save(profesorEncontrado);
        return profesorActulizado;
    }

    @Override
    public Persona asociarCarreraProfesor(Persona profesor, Carrera carrera) {
        Set<Carrera> carrerasProfesor=((Profesor)profesor).getCarreras();
        carrerasProfesor.add(carrera);
        ((Profesor)profesor).setCarreras(carrerasProfesor);
        return repository.save(profesor);
    }


}
