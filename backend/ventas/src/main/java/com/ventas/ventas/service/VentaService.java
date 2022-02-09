package com.ventas.ventas.service;

import com.ventas.ventas.model.DetalleVenta;
import com.ventas.ventas.model.Producto;
import com.ventas.ventas.model.Venta;
import com.ventas.ventas.repository.ProductoRepository;
import com.ventas.ventas.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VentaService  implements  ICRUDService<Venta>{

    @Autowired
    VentaRepository ventaRepository;
    @Autowired
    ProductoRepository productoRepository;

    @Override
    public List<Venta> findAll() {
        return ventaRepository.findAll();
    }

    @Override
    public Optional<Venta> findById(Long id) {
        return ventaRepository.findById(id);
    }

    @Override
    public Venta create(Venta venta) {
        venta.getDetalleVentaList().forEach(detalleVenta->{
           Optional<Producto> producto = productoRepository.findById(detalleVenta.getProducto().getIdProducto());
            if (producto.isPresent()){
                Double precioUnitario = producto.get().getPrecio();
                Double precioTotal = precioUnitario* detalleVenta.getCantidad().doubleValue();
                detalleVenta.setPrecioUnitario(precioUnitario);
                detalleVenta.setPrecioTotal(precioTotal);
                detalleVenta.setVenta(venta);
            }

        });
        return ventaRepository.save(venta);
    }

    @Override
    public Venta update(Venta venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public void delete(Long id) {
        ventaRepository.deleteById(id);
    }
}
