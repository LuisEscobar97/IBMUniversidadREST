package com.ibm.academia.apirest.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@Getter
@Setter
public class Profesesor extends Persona{

    private BigDecimal sueldo;


    public Profesesor(Integer id, String nombre, String apellido, String dni, Direccion direccion,BigDecimal sueldo) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo=sueldo;
    }
}
