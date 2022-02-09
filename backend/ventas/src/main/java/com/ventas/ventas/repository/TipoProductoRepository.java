package com.ventas.ventas.repository;

import com.ventas.ventas.model.TipoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoProductoRepository  extends JpaRepository<TipoProducto, Long> {
}
