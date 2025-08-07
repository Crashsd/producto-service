package com.negocio.producto_service.usuario.service;

import com.negocio.producto_service.usuario.dto.UsuarioDTO;
import com.negocio.producto_service.usuario.model.Usuario;

import java.util.List;

public interface IUsuarioService {

    public List<Usuario> getUsuarios();

    public String saveUsuario(UsuarioDTO usuarioDTO);

    public String deleteUsuario(Long id_usuario);

    public UsuarioDTO getusuario(Long id_usuario);
}
