package com.negocio.producto_service.usuario.repository;

import com.negocio.producto_service.usuario.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolRepository extends JpaRepository<Rol,Long> {
}
