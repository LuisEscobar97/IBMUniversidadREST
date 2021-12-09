package com.ibm.academia.apirest.controllers;

import com.ibm.academia.apirest.entities.Alumno;
import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.exceptions.BadClassException;
import com.ibm.academia.apirest.exceptions.BadRequestException;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.services.AlumnoDAO;
import com.ibm.academia.apirest.services.CarreraDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/alumnos")
public class AllumnoController {
    @Autowired
    private AlumnoDAO alumnoDAO;

    @Autowired
    private CarreraDAO carreraDao;

    @PostMapping
    public ResponseEntity<?>guardarAlumno(@Valid @RequestBody Persona persona, BindingResult result){

        Map<String, Object> validaciones = new HashMap<String, Object>();
        if (result.hasErrors())
        {
            List<String> listaErrores = result.getFieldErrors()
                    .stream()
                    .map(errores -> "Campo: '" + errores.getField() + "' " + errores.getDefaultMessage())
                    .collect(Collectors.toList());
        validaciones.put("Lista Errores", listaErrores);
        return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
        }

        Alumno alumnoGuardado = (Alumno) alumnoDAO.guardar(persona);

        return new ResponseEntity<Alumno>( alumnoGuardado, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<?>obtenerTodosAlumnos(){

            List<Persona> lsiatAlumnos= (List<Persona>) alumnoDAO.buscarTodos();
            if (lsiatAlumnos.isEmpty())
                throw new BadRequestException("No hay alumnos dados de alta en la base de datos");

            return new ResponseEntity<List<Persona>>( lsiatAlumnos,HttpStatus.OK);


    }

    @GetMapping("/alumno")
    public ResponseEntity<?> obtnerAlumnoPorId(@RequestParam(name = "id")Integer id){
        Optional<Persona> alumnoEncontrado= alumnoDAO.buscarPorID(id);
        if (!alumnoEncontrado.isPresent())
            throw new BadRequestException(String.format("El alumno con ID: %d no existe",id));
        if (!(alumnoEncontrado.get() instanceof Alumno))
            throw new BadClassException("La persona que esta buscando no es un alumno");

        return new ResponseEntity<Alumno>((Alumno) alumnoEncontrado.get(),HttpStatus.OK);
    }

    @DeleteMapping("/e")
    public ResponseEntity<?> eliminarAlumnos(@RequestParam(name = "id")Integer id){

        Optional<Persona> alumnoencontrado =alumnoDAO.buscarPorID(id);
        Map<String, Object> respuesta = new HashMap<String, Object>();

        if (!alumnoencontrado.isPresent())
            throw new BadRequestException(String.format("El alumno con ID: %d no existe",id));
        if (!(alumnoencontrado.get() instanceof Alumno))
            throw new BadClassException("La persona que desea eliminar no es un alumno");

        alumnoDAO.eliminarPorId(id);
        respuesta.put("OK", "Alumno ID: " + id + " eliminado exitosamente{"+alumnoencontrado.get().toString()+"}");

        return new ResponseEntity<Map<String, Object>>(respuesta,HttpStatus.ACCEPTED);
    }

    @PutMapping("/upd/alumnoId")
    public ResponseEntity<?> actualizarAlumno(@RequestParam(name = "id")Integer id, @RequestBody Persona alumno)
    {
        Optional<Persona> oAlumno = alumnoDAO.buscarPorID(id);

        if(!oAlumno.isPresent())
            throw new NotFoundException(String.format("El alumno con ID %d no existe", id));
        if (!(oAlumno.get() instanceof Alumno))
            throw new BadClassException("La persona que desea modificar no es un alumno");

        Persona alumnoActualizado = ((AlumnoDAO)alumnoDAO).actualizar(oAlumno.get(), alumno);
        return new ResponseEntity<Persona>(alumnoActualizado, HttpStatus.OK);
    }

    @PutMapping("/alumnoId/{alumnoId}/carrera/{carreraId}")
    public ResponseEntity<?> asignarCarreraAlumno(@PathVariable Integer carreraId, @PathVariable Integer alumnoId)
    {
        Optional<Persona> oAlumno = alumnoDAO.buscarPorID(alumnoId);
        if(!oAlumno.isPresent())
            throw new NotFoundException(String.format("Alumno con id %d no existe", alumnoId));
        if (!(oAlumno.get() instanceof Alumno))
            throw new BadClassException("La persona que desea modificar no es un alumno");

        Optional<Carrera> oCarrera = carreraDao.buscarPorID(carreraId);
        if(!oCarrera.isPresent())
            throw new NotFoundException(String.format("Carrera con id %d no existe", carreraId));

        Persona alumno = ((AlumnoDAO)alumnoDAO).asociarCarreraAlumno(oAlumno.get(), oCarrera.get());

        return new ResponseEntity<Persona>(alumno, HttpStatus.OK);
    }
}
