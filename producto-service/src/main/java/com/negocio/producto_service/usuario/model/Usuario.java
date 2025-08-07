package com.negocio.producto_service.usuario.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;
    private String nombre;
    private String contrasenia;
    private String email;

    private String telefono;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Rol> roles;


    public Usuario(String nombre, String contrasenia, String telefono, String email, Set<Rol> roles) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.telefono = telefono;
        this.email = email;
        this.roles = roles;
    }
}
