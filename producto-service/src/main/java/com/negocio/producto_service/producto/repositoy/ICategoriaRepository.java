package com.negocio.producto_service.producto.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.negocio.producto_service.producto.model.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository<Categoria,Long> {

    Categoria findByNombre(String nombre);
}
