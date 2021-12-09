package com.ibm.academia.apirest.controllers;

import com.ibm.academia.apirest.entities.Alumno;
import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.entities.Profesor;
import com.ibm.academia.apirest.exceptions.BadClassException;
import com.ibm.academia.apirest.exceptions.BadRequestException;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.services.AlumnoDAO;
import com.ibm.academia.apirest.services.CarreraDAO;
import com.ibm.academia.apirest.services.ProfesorDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/profesores")
public class ProfesorController {

    @Autowired
    private ProfesorDAO profesorDAO;

    @Autowired
    private CarreraDAO carreraDao;

    @PostMapping
    public ResponseEntity<?> guardarProfesor(@Valid @RequestBody Persona persona, BindingResult result){

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
        Profesor profesorGuardado = (Profesor) profesorDAO.guardar(persona);

        return new ResponseEntity<Profesor>( profesorGuardado, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<?>obtenerTodosProfesor(){

        List<Persona> lsiatProfesor= (List<Persona>) profesorDAO.buscarTodos();
        if (lsiatProfesor.isEmpty())
            throw new BadRequestException("No hay Profesor dados de alta en la base de datos");

        return new ResponseEntity<List<Persona>>( lsiatProfesor,HttpStatus.OK);

    }

    @GetMapping("/profesor")
    public ResponseEntity<?> obtnerProfesorPorId(@RequestParam(name = "id")Integer id){
        Optional<Persona> profesorEncontrado= profesorDAO.buscarPorID(id);
        if (!profesorEncontrado.isPresent())
            throw new BadRequestException(String.format("El Profesor con ID: %d no existe",id));
        if (!(profesorEncontrado.get() instanceof Profesor))
            throw new BadClassException("La Profesor que esta buscando no es un Profesor");

        return new ResponseEntity<Profesor>((Profesor) profesorEncontrado.get(),HttpStatus.OK);
    }

    @DeleteMapping("/e")
    public ResponseEntity<?> eliminarProfesor(@RequestParam(name = "id")Integer id){

        Optional<Persona> profesorEncontrado =profesorDAO.buscarPorID(id);
        Map<String, Object> respuesta = new HashMap<String, Object>();

        if (!profesorEncontrado.isPresent())
            throw new BadRequestException(String.format("El Profesor con ID: %d no existe",id));
        if (!(profesorEncontrado.get() instanceof Profesor))
            throw new BadClassException("La persona que desea eliminar no es un Profesor");

        profesorDAO.eliminarPorId(id);
        respuesta.put("OK", "Profesor ID: " + id + " eliminado exitosamente{"+profesorEncontrado.get().toString()+"}");

        return new ResponseEntity<Map<String, Object>>(respuesta,HttpStatus.ACCEPTED);
    }

    @PutMapping("/upd/profesorId")
    public ResponseEntity<?> actualizarProfesor(@RequestParam(name = "id")Integer id, @RequestBody Persona alumno)
    {
        Optional<Persona> oAlumno = profesorDAO.buscarPorID(id);

        if(!oAlumno.isPresent())
            throw new NotFoundException(String.format("El Profesor con ID %d no existe", id));
        if (!(oAlumno.get() instanceof Profesor))
            throw new BadClassException("La persona que desea modificar no es un professor");

        Persona alumnoActualizado = ((ProfesorDAO)profesorDAO).actualizar(oAlumno.get(), alumno);
        return new ResponseEntity<Persona>(alumnoActualizado, HttpStatus.OK);
    }

    @PutMapping("/profesorId/{profesorId}/carrera/{carreraId}")
    public ResponseEntity<?> asignarCarreraProfesor(@PathVariable Integer carreraId, @PathVariable Integer profesorId)
    {
        Optional<Persona> oProfesor = profesorDAO.buscarPorID(profesorId);
        if(!oProfesor.isPresent())
            throw new NotFoundException(String.format("Profesor con id %d no existe", profesorId));
        if (!(oProfesor.get() instanceof Profesor))
            throw new BadClassException("La persona que desea modificar no es un profesor");

        Optional<Carrera> oCarrera = carreraDao.buscarPorID(carreraId);
        if(!oCarrera.isPresent())
            throw new NotFoundException(String.format("Carrera con id %d no existe", carreraId));

        Persona alumno = ((ProfesorDAO)profesorDAO).asociarCarreraProfesor(oProfesor.get(), oCarrera.get());

        return new ResponseEntity<Persona>(alumno, HttpStatus.OK);
    }
}
