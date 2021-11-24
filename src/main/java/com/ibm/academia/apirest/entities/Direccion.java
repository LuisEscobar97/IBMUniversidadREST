package com.ibm.academia.apirest.entities;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Direccion implements Serializable {
    private String calle;
    private String numero;
    private String codigoPostal;
    private String departamento;
    private String piso;
    private String localidString;

}
