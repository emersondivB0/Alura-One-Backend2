package com.alura.modelo.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosCurso(Long id,
                         @NotBlank
                         String nombre,
                         @NotBlank
                         String categoria) {
}
