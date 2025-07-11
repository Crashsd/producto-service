package com.negocio.producto_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.negocio.producto_service.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

    
}
