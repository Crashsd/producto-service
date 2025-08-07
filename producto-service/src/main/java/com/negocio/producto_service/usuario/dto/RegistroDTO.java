package com.negocio.producto_service.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Set;

public class RegistroDTO {
    @Email
    private String email;
    @NotBlank
    private String telefono;

    private Set <String> roles;
}
