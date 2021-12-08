package com.ibm.academia.apirest.controllers;

import com.ibm.academia.apirest.entities.Carrera;
import com.ibm.academia.apirest.exceptions.BadRequestException;
import com.ibm.academia.apirest.exceptions.NotFoundException;
import com.ibm.academia.apirest.services.CarreraDAO;
import com.ibm.academia.apirest.services.CarreraDAOImpl;
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
@RequestMapping("/carreras")
public class CarreraController {
    @Autowired
    CarreraDAO carreraDAO;

    @PostMapping("/guardar")
    public ResponseEntity<?> guardarCarrera(@Valid @RequestBody Carrera carrera, BindingResult result)
    {
        Map<String, Object> validaciones = new HashMap<String, Object>();
        if(result.hasErrors()){
            List<String> listaErrores = result.getFieldErrors()
                    .stream()
                    .map(errores -> "Campo: '" + errores.getField() + "' " + errores.getDefaultMessage())
                    .collect(Collectors.toList());
            validaciones.put("Lista Errores", listaErrores);
            return new ResponseEntity<Map<String, Object>>(validaciones, HttpStatus.BAD_REQUEST);
        }
        Carrera carreraGuardada = carreraDAO.guardar(carrera);
        return new ResponseEntity<Carrera>(carreraGuardada, HttpStatus.CREATED);
    }

    @GetMapping("/profesores")
    public ResponseEntity<?> getCarrerasByProfesores(@RequestParam(name = "nombre")String nombre, @RequestParam(name = "apellido") String apellido){
        List<Carrera>carreras= (List<Carrera>) carreraDAO.findCarrerasByProfesorNombreAndApellido(nombre,apellido);
           if (carreras.isEmpty())
              throw  new BadRequestException("No hay carreras asociadas a al porfesor se");
            return new ResponseEntity<List<Carrera>>(carreras,HttpStatus.OK);
    }

    @GetMapping("/lista/carreras")
    public ResponseEntity<?> buscarTodas(){
        List<Carrera>carreras= (List<Carrera>) carreraDAO.buscarTodos();
        if (carreras.isEmpty())
            throw  new BadRequestException("No hay carreras en la base de datos");

        return new ResponseEntity<List<Carrera>>(carreras,HttpStatus.OK);
    }

    @GetMapping("/carrera")
    public ResponseEntity<?>busccarCarreraPorId(@RequestParam(name = "id")Integer id){
        Optional<Carrera>  carrera=  carreraDAO.buscarPorID(id);
        if (!carrera.isPresent())
            throw new BadRequestException(String.format("La carrera con ID: %d no existe",id));

        return new ResponseEntity<Carrera>(carrera.get(),HttpStatus.OK);
    }

    @DeleteMapping("/carrera/e")
    public ResponseEntity<?> eliminarCarrera(@RequestParam(name = "id")Integer id){
        Map<String, Object> respuesta = new HashMap<String, Object>();

        Optional<Carrera>  carrera=  carreraDAO.buscarPorID(id);
        if (!carrera.isPresent())
            throw new BadRequestException(String.format("La carrera con ID: %d no existe",id));

        carreraDAO.eliminarPorId(id);
        respuesta.put("OK", "Carrera ID: " + id + " eliminada exitosamente{"+carrera.get().toString()+"}");
        return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.ACCEPTED);
    }

    @PutMapping("/upd/carreraId/{carreraId}")
    public ResponseEntity<?> actualizarCarrera(@PathVariable Integer carreraId, @RequestBody Carrera carrera)
    {
        Optional<Carrera> oCarrera = carreraDAO.buscarPorID(carreraId);

        if(!oCarrera.isPresent())
            throw new NotFoundException(String.format("La carrera con ID: %d no existe", carreraId));

        Carrera carreraActualizada = carreraDAO.actualizar(oCarrera.get(), carrera);

        return new ResponseEntity<Carrera>(carreraActualizada, HttpStatus.OK);
    }


}
