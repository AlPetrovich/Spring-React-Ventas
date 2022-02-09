package com.ventas.ventas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
public class TipoProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoProducto;

    @Column(length = 15)
    private String codigo;

    @Column(length =150)
    private String nombre;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TipoProducto)) return false;
        TipoProducto that = (TipoProducto) o;
        return Objects.equals(getIdTipoProducto(), that.getIdTipoProducto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdTipoProducto());
    }
}
