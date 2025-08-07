package com.negocio.producto_service.usuario.repository;

import com.negocio.producto_service.usuario.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario,Long> {
    boolean usuarioExist(String usuario);

    Optional <Usuario> findByNombre(String nombre);
}
