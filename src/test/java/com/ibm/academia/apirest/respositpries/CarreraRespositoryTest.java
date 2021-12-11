package com.ibm.academia.apirest.respositpries;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.entities.Profesor;
import com.ibm.academia.apirest.respositories.AlumnoRepository;
import com.ibm.academia.apirest.respositories.CarreraRepository;
import com.ibm.academia.apirest.respositories.ProfesorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
public class CarreraRespositoryTest {
    @Autowired
    private CarreraRepository carreraRepository;

    @Autowired
    @Qualifier("respositorioProfesores")
    private ProfesorRepository profesorRepository;


    @Test
    @DisplayName("Test: Buscar carreras por nombre profesor")
    void buscarCarrerasPorProfesorNombreYApellido()
    {
        //Given
        Carrera carrera = carreraRepository.save(DatosDummy.carrera01());
        Carrera carrera2 =carreraRepository.save(DatosDummy.carrera02());
        Carrera carrera3= carreraRepository.save(DatosDummy.carrera03());

        List<Carrera>carreras= new ArrayList<>();

        carreras.add(carrera);
        carreras.add(carrera2);
        carreras.add(carrera3);

        Set<Carrera>carrerasSet=carreras.stream().collect(Collectors.toSet());
        Profesor profesor1=(Profesor) DatosDummy.profesor01();
        profesor1.setCarreras(carrerasSet);
        profesorRepository.save(profesor1);
        profesorRepository.save(DatosDummy.profesor02());

        //When
        Iterable<Carrera> carrerasIterable = carreraRepository.buscarCarrerasPorProfesorNombreYApellido("Martin","Lugone");
        List<Carrera>expected= (List<Carrera>) carrerasIterable;
        //Then
        assertThat(expected.isEmpty() == false).isTrue();
    }
}
