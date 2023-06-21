package com.udemy.market.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.market.productos.model.Categoria;
import com.udemy.market.productos.model.Producto;
import com.udemy.market.productos.service.ProductosService;

@RestController
@CrossOrigin("*")
@RequestMapping("market/productos")
public class ProductosController {

    @Autowired
    ProductosService productosService;

    @GetMapping(value="categorias", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Categoria>> categorias() {

        return new ResponseEntity<List<Categoria>>(productosService.categorias(), HttpStatus.OK);

    }

    @GetMapping(value="productos", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Producto>> productosByCategoria(@RequestParam("id") int id) {

        return new ResponseEntity<List<Producto>>(productosService.productosByCategoria(id), HttpStatus.OK);

    }

    @GetMapping(value="producto", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> productoById(@RequestParam("id") int id) {

        return new ResponseEntity<Producto>(productosService.productoById(id), HttpStatus.OK);

    }

    @PutMapping(value="producto")
    public ResponseEntity<Void> updateInventario(@RequestParam("id") int id, @RequestParam("unidades") int unidades) {

        Producto producto = productosService.updateInventario(id, unidades);
        if (producto != null) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_MODIFIED);
        }

    }

    @PostMapping(value="producto", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> createProducto(@RequestBody Producto producto) {

        if (productosService.createProducto(producto) == false) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

    @PostMapping(value="categoria", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Categoria> createCategoria(@RequestBody Categoria categoria) {

        if (productosService.createCategoria(categoria) == false) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }

    }

}
