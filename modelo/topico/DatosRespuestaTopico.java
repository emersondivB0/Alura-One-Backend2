package com.alura.modelo.topico;

import jakarta.validation.constraints.NotBlank;
import com.alura.modelo.usuario.DatosUsuario;
import com.alura.modelo.curso.DatosCurso;

public record DatosRespuestaTopico(Long id,
                                   @NotBlank
                                   String titulo,
                                   @NotBlank
                                   String mensaje,
                                   DatosUsuario autor,
                                   DatosCurso curso) {
}
