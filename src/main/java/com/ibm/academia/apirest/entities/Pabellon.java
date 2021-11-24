package com.ibm.academia.apirest.entities;

import lombok.*;

import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Pabellon implements Serializable {

    private Integer id;
    private Double temanioMetros;
    private String nombre;
    private Direccion direccion;
    private Date fechaAlta;
    private Date fechaModificacion;

    public Pabellon(Integer id, Double temanioMetros, String nombre, Direccion direccion) {
        this.id = id;
        this.temanioMetros = temanioMetros;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pabellon pabellon = (Pabellon) o;
        return id.equals(pabellon.id) && nombre.equals(pabellon.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre);
    }
}
