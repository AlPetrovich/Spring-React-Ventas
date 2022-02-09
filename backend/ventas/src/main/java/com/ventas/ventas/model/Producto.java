package com.ventas.ventas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(length = 15)
    private String codigo;

    @Column(length = 150)
    private String nombre;

    private Double precio;

    @ManyToOne
    @JoinColumn(name = "id_tipoProducto", nullable = false)
    private TipoProducto tipoProducto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Producto)) return false;
        Producto producto = (Producto) o;
        return Objects.equals(getIdProducto(), producto.getIdProducto()) && Objects.equals(getCodigo(), producto.getCodigo()) && Objects.equals(getNombre(), producto.getNombre()) && Objects.equals(getPrecio(), producto.getPrecio());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdProducto());
    }
}
