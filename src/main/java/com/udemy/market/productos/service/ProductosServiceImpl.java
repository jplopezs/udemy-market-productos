package com.udemy.market.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.market.productos.model.Categoria;
import com.udemy.market.productos.model.Producto;
import com.udemy.market.productos.repository.CategoriasRepository;
import com.udemy.market.productos.repository.ProductosRepository;

@Service
public class ProductosServiceImpl implements ProductosService {

    @Autowired
    CategoriasRepository categoriasRepository;

    @Autowired
    ProductosRepository productosRepository;

    @Override
    public List<Categoria> categorias() {

        return categoriasRepository.findAll();

    }

    @Override
    public List<Producto> productosByCategoria(int categoria) {

        return productosRepository.findAllByCategoria(categoria);

    }

    @Override
    public Producto updateInventario(int id, int unidades) {

        Producto producto = productoById(id);
        if (producto != null && producto.getInventario() > unidades) {
            producto.setInventario(producto.getInventario() - unidades);
            productosRepository.save(producto);
            return producto;
        }
        return null;

    }

    @Override
    public Producto productoById(int id) {

        return productosRepository.findById(id).orElse(null);

    }

    @Override
    public boolean createCategoria(Categoria categoria) {

        if (categoriasRepository.findByNombre(categoria.getNombre()) != null) {
            return false;
        }

        categoriasRepository.save(categoria);
        return true;

    }
    
    @Override
    public boolean createProducto(Producto producto) {

        if (productosRepository.findByNombre(producto.getNombre()) != null) {
            return false;
        }

        if (categoriasRepository.findById(producto.getCategoria()) == null) {
            return false;
        } 

        productosRepository.save(producto);
        return true;

    }

}
