package com.ventas.ventas.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@Entity
@Table(name = "CLIENTES")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

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

    @NotNull
    @NotBlank(message = "El email es obligatorio")
    @Size(min = 10, message = "El email debe ser al menos de 10 caracteres")
    @Email(message = "El email enviado no es un formato valido")
    @Column(name = "EMAIL", nullable = false, length = 150)
    private String email;
}
