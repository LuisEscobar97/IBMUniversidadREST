package com.ibm.academia.apirest.respositories;

import com.ibm.academia.apirest.entities.Pabellon;
import org.springframework.data.repository.CrudRepository;

public interface PabellonRepository extends CrudRepository<Pabellon,Integer> {

    public Iterable<Pabellon>findByDireccionLocalidString(String localidad);

    public Iterable<Pabellon> findByNombre(String nombre);

}
