package com.ibm.academia.apirest.respositories;

import com.ibm.academia.apirest.entities.Persona;
import com.ibm.academia.apirest.enums.TipoEmpleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("respositorioEmpelados")
public interface EmpleadoRepository extends PersonaRepository{

    @Query("Select e From Empleado e where e.tipoEmpleado=:parametroTipoEmpleado")
    Iterable<Persona> findEmpleadoByTipoEmpleado(@Param("parametroTipoEmpleado")TipoEmpleado tipoEmpleado);
}
