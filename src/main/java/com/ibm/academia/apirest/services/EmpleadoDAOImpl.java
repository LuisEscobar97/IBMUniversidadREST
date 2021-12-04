package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.enums.TipoEmpleado;
import com.ibm.academia.apirest.respositories.EmpleadoRepository;
import com.ibm.academia.apirest.respositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.UsesSunMisc;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpleadoDAOImpl extends PersonaDAOImpl implements EmpleadoDAO {


    @Autowired
    public EmpleadoDAOImpl(@Qualifier("respositorioEmpelados")PersonaRepository personaRepository) {
        super(personaRepository);
    }


    @Override
    public Iterable<Persona> findEmpleadoByTipoEmpleado(TipoEmpleado tipoEmpleado) {
        return ((EmpleadoRepository)repository).findEmpleadoByTipoEmpleado(tipoEmpleado);
    }
}
