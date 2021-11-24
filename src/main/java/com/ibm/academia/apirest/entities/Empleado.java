package com.ibm.academia.apirest.entities;

import com.ibm.academia.apirest.enums.TipoEmpleado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
public class Empleado extends Persona{

    private BigDecimal sueldo;
    private TipoEmpleado tipoEmpleado;

    public Empleado(Integer id, String nombre, String apellido, String dni, Direccion direccion,BigDecimal sueldo,TipoEmpleado tipoEmpleado) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo=sueldo;
        this.tipoEmpleado= tipoEmpleado;
    }

}
