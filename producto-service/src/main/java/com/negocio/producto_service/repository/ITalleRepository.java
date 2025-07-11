package com.negocio.producto_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.negocio.producto_service.model.Talle;
@Repository
public interface ITalleRepository extends JpaRepository <Talle,Long> {

    Talle findByNombre(String nombre);
}
