package com.udemy.market.productos.service;

import java.util.List;

import com.udemy.market.productos.model.Categoria;
import com.udemy.market.productos.model.Producto;

public interface ProductosService {

    List<Categoria> categorias();
    List<Producto> productosByCategoria(int categoria);
    Producto updateInventario(int id, int unidades);
    Producto productoById(int id);
    boolean createCategoria(Categoria categoria);
    boolean createProducto(Producto producto);

}
