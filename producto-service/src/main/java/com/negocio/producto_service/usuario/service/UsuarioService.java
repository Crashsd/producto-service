package com.negocio.producto_service.usuario.service;

import com.negocio.producto_service.usuario.dto.UsuarioDTO;
import com.negocio.producto_service.usuario.exceptions.UserExistException;
import com.negocio.producto_service.usuario.exceptions.UserNotFoundException;
import com.negocio.producto_service.usuario.model.Rol;
import com.negocio.producto_service.usuario.model.RoleEnum;
import com.negocio.producto_service.usuario.model.Usuario;
import com.negocio.producto_service.usuario.repository.IRolRepository;
import com.negocio.producto_service.usuario.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UsuarioService implements IUsuarioService {
    @Autowired
    private IUsuarioRepository repoUsuario;
    private IRolRepository repoRol;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<Usuario> getUsuarios() {
        return repoUsuario.findAll();
    }

    @Override
    public String saveUsuario(UsuarioDTO usuarioDTO) throws UserExistException {
        if(repoUsuario.usuarioExist(usuarioDTO.getUsuario())){
            throw new UserExistException("Este nombre de nombre ya existe intente con otro");
        }
        Set<Rol> roles = usuarioDTO.getRoles().stream()
                .map(rol -> repoRol.findByRol(RoleEnum.valueOf(rol))
                        .orElseGet(() -> {
                            Rol nuevoRol = new Rol(RoleEnum.valueOf(rol));
                            return repoRol.save(nuevoRol);
                        }))
                .collect(Collectors.toSet());

        Usuario nuevoUsuario= new Usuario(
                usuarioDTO.getUsuario(),
               passwordEncoder.encode(usuarioDTO.getContrasenia()),
                usuarioDTO.getEmail(),
                usuarioDTO.getTelefono(),
                roles);

        repoUsuario.save(nuevoUsuario);



        return "El nombre fue guardado con exito";
    }

    @Override
    public String deleteUsuario(Long id_usuario) {
        repoUsuario.deleteById(id_usuario);
        return "Usuario eliminado con exito";
    }

    @Override
    public UsuarioDTO getusuario(Long id_usuario) throws UserNotFoundException {
        Usuario usuario = repoUsuario.findById(id_usuario).orElseThrow(() -> new UserNotFoundException("El nombre con el id :" + id_usuario + "no fue encontrado"));
        UsuarioDTO dto = new UsuarioDTO();
        dto.setUsuario(usuario.getNombre());
        dto.setEmail(usuario.getEmail());
        dto.setTelefono(usuario.getTelefono());
        dto.setRoles(usuario.getRoles().stream().map(rol -> rol.getERol().name()).collect(Collectors.toSet()));

        return dto;
    }


}
