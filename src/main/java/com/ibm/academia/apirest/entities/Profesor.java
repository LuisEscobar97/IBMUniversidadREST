package com.ibm.academia.apirest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "profesores",schema = "universidad")
//@Table(name = "profesores",schema = "test")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Profesor extends Persona{

    @NotNull(message = "No puede ser nulo")
    @Positive(message = "El valor debe ser mayor a 0")
    @Column(name = "sueldo")
    private BigDecimal sueldo;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(name = "profesor_carrera", schema = "universidad",
            joinColumns =@JoinColumn(name = "profesor_id")
            ,inverseJoinColumns = @JoinColumn(name = "carrera_id"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "profesores"})
    private Set<Carrera>carreras;


    public Profesor(Integer id, String nombre, String apellido, String dni, Direccion direccion, BigDecimal sueldo) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo=sueldo;
    }

    @Override
    public String toString() {
        return super.toString()+"\tProfesor{" +
                "sueldo=" + sueldo +
                '}';
    }
}
