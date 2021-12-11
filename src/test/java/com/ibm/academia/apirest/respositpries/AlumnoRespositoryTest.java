package com.ibm.academia.apirest.respositpries;

import com.ibm.academia.apirest.datos.DatosDummy;
import com.ibm.academia.apirest.entities.Alumno;
import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.respositories.AlumnoRepository;
import com.ibm.academia.apirest.respositories.CarreraRepository;
import com.ibm.academia.apirest.respositories.PersonaRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AlumnoRespositoryTest {
    @Autowired
    @Qualifier("respositorioAlumnos")
    private PersonaRepository alumnoRepository;

    @Autowired
    private CarreraRepository carreraRepository;

    @Test
    @DisplayName("Test: Buscar alumnos por nombre carrera")
    void buscarAlumnoPorNombreCarrera()
    {
        //Given
        Iterable<Persona> personas = alumnoRepository.saveAll(
                Arrays.asList(
                        DatosDummy.alumno01(),
                        DatosDummy.alumno02(),
                        DatosDummy.alumno03())
        );

        Carrera carrera = carreraRepository.save(DatosDummy.carrera01());
        personas.forEach(alumno -> ((Alumno)alumno).setCarrera(carrera));
        alumnoRepository.saveAll(personas);

        //When
        String carreraNombre = "Ingenieria en Sistemas";
        List<Persona> expected =  (List<Persona>) ((AlumnoRepository)alumnoRepository).buscarAlumnoPorNombreCarrera(carreraNombre);

        //Then
        assertThat(expected.size() == 3).isTrue();
    }

}
