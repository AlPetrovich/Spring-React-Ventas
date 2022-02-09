package com.ventas.ventas.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "el nombre es obligatorio")
    @Size(min = 3, max = 70, message = "El nombre debe ser >3 y <70")
    @Column(name = "NOMBRES", nullable = false, length = 70)
    private String nombres;

    @NotNull(message = "El apellido no puede ser nulo")
    @NotBlank(message = "el apellido es obligatorio")
    @Size(min = 3, max = 150, message = "El apellido debe ser >3 y <150")
    @Column(name = "APELLIDOS", nullable = false, length = 70)
    private String apellidos;

    @Size(max = 150, message = "La direccion no debe superar los 150 caracteres")
    @Column(name = "DIRECCION", nullable = true, length = 150)
    private String direccion;

    @Size(min = 8, message = "El telefono debe tener al menos 8 digitos")
    @Column(name = "TELEFONO", nullable = true, length = 20)
    private String telefono;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona persona = (Persona) o;
        return Objects.equals(getIdPersona(), persona.getIdPersona());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdPersona());
    }
}
