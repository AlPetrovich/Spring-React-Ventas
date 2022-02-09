package com.ventas.ventas.controller;



import com.ventas.ventas.model.Persona;
import com.ventas.ventas.model.Producto;
import com.ventas.ventas.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @GetMapping
    public ResponseEntity<List<Producto>> findAll(){
        return ResponseEntity.ok(productoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Producto> create(@Valid @RequestBody Producto producto){
        return new ResponseEntity<>(productoService.create(producto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable("id") Long idProducto){
        return productoService.findById(idProducto)
                .map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Producto> update(@Valid @RequestBody Producto producto){
        return productoService.findById(producto.getIdProducto())
                .map(p-> ResponseEntity.ok(productoService.update(producto)))
                .orElseGet(()-> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long idProducto ){
        return productoService.findById(idProducto)
                .map(p-> {
                    productoService.delete(idProducto);
                    return ResponseEntity.ok().build();
                })
                .orElseGet(()-> ResponseEntity.notFound().build());
    }



}
