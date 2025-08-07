package com.negocio.producto_service.config;

import com.negocio.producto_service.usuario.model.Usuario;
import com.negocio.producto_service.usuario.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomerDetailService implements UserDetailsService {

    @Autowired
    private  IUsuarioRepository repoUsuario;

    @Override
    public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
        Usuario usuario=repoUsuario.findByNombre(nombre)
                .orElseThrow(()->new UsernameNotFoundException("Usuario no encontrado"));


        return new org.springframework.security.core.userdetails.User(
                usuario.getNombre(),
                usuario.getContrasenia(),
                usuario.getRoles().stream()
                        .map(rol -> new SimpleGrantedAuthority("ROL_"+rol.getERol().name()))
                        .toList()
        );
    }
}
