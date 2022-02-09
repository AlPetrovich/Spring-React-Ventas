package com.ventas.ventas.controller;


import com.ventas.ventas.model.TipoProducto;
import com.ventas.ventas.model.Venta;
import com.ventas.ventas.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/ventas")
public class VentaController {

    @Autowired
    VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> findAll(){
        return ResponseEntity.ok(ventaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Venta> create(@Valid @RequestBody Venta venta){
        return new ResponseEntity<>(ventaService.create(venta), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> findById(@PathVariable("id") Long idVenta){
        return ventaService.findById(idVenta)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Venta> update(@Valid @RequestBody Venta venta){
        return ventaService.findById(venta.getIdVenta())
                .map(p-> ResponseEntity.ok(ventaService.update(venta)))
                .orElseGet(()-> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long idVenta ){
        return ventaService.findById(idVenta)
                .map(p-> {
                    ventaService.delete(idVenta);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }
}
