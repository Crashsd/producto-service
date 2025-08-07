package com.negocio.producto_service.usuario.repository;

import com.negocio.producto_service.usuario.model.Rol;
import com.negocio.producto_service.usuario.model.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRolRepository extends JpaRepository<Rol,Long> {
     Optional<Rol> findByRol(RoleEnum rol);
}
