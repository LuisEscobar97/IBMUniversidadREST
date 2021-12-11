package com.ibm.academia.apirest.entities;

import com.ibm.academia.apirest.enums.TipoEmpleado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "empleados",schema = "universidad")
//@Table(name = "empleados",schema = "test")
@PrimaryKeyJoinColumn(name = "persona_id")
public class Empleado extends Persona{
    @Column(name = "sueldo")
    private BigDecimal sueldo;

    @Column(name = "tipo_empleado")
    private TipoEmpleado tipoEmpleado;

    @OneToOne(optional = true,cascade = CascadeType.ALL)
    @JoinColumn(name = "pabellon_id",foreignKey = @ForeignKey(name = "FK_PABELLON_ID"))
    private Pabellon pabellon;

    public Empleado(Integer id, String nombre, String apellido, String dni, Direccion direccion,BigDecimal sueldo,TipoEmpleado tipoEmpleado) {
        super(id, nombre, apellido, dni, direccion);
        this.sueldo=sueldo;
        this.tipoEmpleado= tipoEmpleado;
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+ "Empleado{" +
                "sueldo=" + sueldo +
                ", tipoEmpleado=" + tipoEmpleado +
                '}';
    }
}
