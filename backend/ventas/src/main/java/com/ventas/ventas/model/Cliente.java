package com.ventas.ventas.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "CLIENTES")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Column(length = 20)
    private String nit;

    @Column(length = 100)
    private String razonSocial;

    @NotNull
    @NotBlank(message = "El email es obligatorio")
    @Size(min = 10, message = "El email debe ser al menos de 10 caracteres")
    @Email(message = "El email enviado no es un formato valido")
    @Column(name = "EMAIL", nullable = false, length = 150)
    private String email;

    //unidireccional xq no tengo id cliente en persona
    @OneToOne
    @JoinColumn(name = "id_persona",nullable = false)
    private Persona persona;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(getIdCliente(), cliente.getIdCliente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCliente());
    }
}
