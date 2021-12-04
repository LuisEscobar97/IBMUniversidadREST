package com.ibm.academia.apirest.respositories;


import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.enums.Pizarron;
import org.springframework.data.repository.CrudRepository;

public interface AulaRepository extends CrudRepository<Aula,Integer> {

    public Iterable<Aula>findAulaByPizarron(Pizarron pizarron);
}
