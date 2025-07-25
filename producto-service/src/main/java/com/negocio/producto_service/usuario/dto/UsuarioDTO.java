package com.negocio.producto_service.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    @NotBlank
    private String usuario;
    @NotBlank
    private String contrasenia;

    @Email(message = "Email invalido.")
    private String email;

    @NotBlank
    private String telefono;

    @NotNull
    private Set<String> roles;
}
