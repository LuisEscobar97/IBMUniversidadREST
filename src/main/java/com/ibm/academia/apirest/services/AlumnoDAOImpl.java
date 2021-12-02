package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.respositories.AlumnoReposiotry;
import com.ibm.academia.apirest.respositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class AlumnoDAOImpl extends PersonaDAOImpl implements AlumnoDAO{

    @Autowired
    public AlumnoDAOImpl(@Qualifier("respositorioAlumnos")PersonaRepository personaRepository){
        super(personaRepository);
    }

    @Override
    public Iterable<Persona> buscarAlumnoPorNombreCarrera(String nombre) {
        return ((AlumnoReposiotry)repository).buscarAlumnoPorNombreCarrera(nombre);
    }
}
