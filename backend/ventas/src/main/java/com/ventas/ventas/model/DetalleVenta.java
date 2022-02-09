package com.ventas.ventas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@Entity
public class DetalleVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleVenta;

    private Double precioUnitario;

    private Integer cantidad;

    private Double precioTotal;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private Producto producto;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_venta", nullable = false)
    private Venta venta;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DetalleVenta)) return false;
        DetalleVenta that = (DetalleVenta) o;
        return Objects.equals(getIdDetalleVenta(), that.getIdDetalleVenta());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdDetalleVenta());
    }
}
