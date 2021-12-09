package com.ibm.academia.apirest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "alumnos",schema = "universidad")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Alumno extends Persona {

   @ManyToOne(optional = true,cascade = {CascadeType.PERSIST,CascadeType.MERGE},fetch = FetchType.LAZY)
   @JsonIgnoreProperties({"hibernateLazyInitializer", "alumnos"})
    private Carrera carrera;
    public Alumno(Integer id, String nombre, String apellido, String dni, Direccion direccion) {
        super(id, nombre, apellido, dni, direccion);
    }
}
