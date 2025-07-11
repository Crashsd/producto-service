package com.negocio.producto_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.negocio.producto_service.model.Color;
@Repository
public interface IColorRepository extends JpaRepository <Color,Long>{

}
