package com.alura.modelo.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DatosUsuario(Long id,
                           @NotBlank
                           String nombre,
                           @NotBlank
                           @Email
                           String email,
                           @NotBlank
                           String contraseña) {
}
