package com.negocio.producto_service.producto.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.negocio.producto_service.producto.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {
@Query("SELECT p FROM Producto p WHERE p.nombre = :nombre ")
    List <Producto> findByNombre(Long id_producto);

    
}
