package com.udemy.market.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.udemy.market.productos.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

        Categoria findByNombre(String nombre);

}
