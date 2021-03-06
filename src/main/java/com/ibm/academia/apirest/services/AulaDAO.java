package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Aula;
import com.ibm.academia.apirest.enums.Pizarron;

public interface AulaDAO extends GenericoDAO<Aula>{

    public Iterable<Aula>findAulaByPizarron(Pizarron pizarron);

    public Iterable<Aula>findByPabellon(String pabellon);

    public Iterable<Aula>findByNumeroAula(Integer numeroAula);
}
