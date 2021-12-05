package com.ibm.academia.apirest.respositories;


import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.enums.Pizarron;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface AulaRepository extends CrudRepository<Aula,Integer> {

    public Iterable<Aula>findAulaByPizarron(Pizarron pizarron);

    //@Query("select a from Aula a join fetch a.pabellon p where p.nombre = :parametroNombrePabellon")
    public Iterable<Aula>findByPabellonNombre(@Param("parametroNombrePabellon") String pabellon);

    public Iterable<Aula>findByNumeroAula(Integer numeroAula);

}
