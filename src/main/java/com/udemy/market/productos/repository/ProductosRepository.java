package com.udemy.market.productos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.market.productos.model.Producto;

public interface ProductosRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findAllByCategoria(int categoria);
    Producto findByNombre(String nombre);

}
