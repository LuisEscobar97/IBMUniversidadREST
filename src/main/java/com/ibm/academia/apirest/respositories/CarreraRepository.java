package com.ibm.academia.apirest.respositories;

import com.ibm.academia.apirest.entities.Carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera,Integer> {

    //@Query("select c from Carrera c where c.cantidadAnios =?1")
    public Iterable<Carrera> findCarrerasByCantidadAnios(Integer cantidadAnios);

    //@Query("select c from Carrera c where c.nombre  like %?1%")
    public Iterable<Carrera> findCarrerasByNombreContains(String nombre);

    //@Query("select c from Carrera c where upper(c.nombre)  like upper(%?1%)")
    public Iterable<Carrera> findCarrerasByNombreContainsIgnoreCase(String nombre);

    //@Query("select c from Carrera c where c.cantidadAnios > ?1 ")
    public Iterable<Carrera> findCarrerasByCantidadAniosAfter(Integer cantidadAnios);

    @Query("Select c from Carrera c join fetch c.profesores p where p.nombre=:parametroNombre and p.apellido=:parametroApellido")
    public Iterable<Carrera> buscarCarrerasPorProfesorNombreYApellido(@Param("parametroNombre")String nombre, @Param("parametroApellido")String apellido);

}
