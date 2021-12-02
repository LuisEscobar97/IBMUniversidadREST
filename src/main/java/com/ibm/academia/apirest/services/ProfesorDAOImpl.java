package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.respositories.AlumnoReposiotry;
import com.ibm.academia.apirest.respositories.PersonaRepository;
import com.ibm.academia.apirest.respositories.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProfesorDAOImpl extends PersonaDAOImpl implements ProfesorDAO{



    public ProfesorDAOImpl(@Qualifier("respositorioProfesores")PersonaRepository personaRepository) {
        super(personaRepository);
    }


    @Override

    public Iterable<Persona> buscarPorfesoresesPorNombreCarrera(String nombre) {
        return null;//((ProfesorRepository)repository).buscarPorfesoresesPorNombreCarrera(nombre);
    }


}
