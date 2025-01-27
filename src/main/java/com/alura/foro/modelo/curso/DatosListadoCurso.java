package com.alura.foro.modelo.curso;

public record DatosListadoCurso(Long id, String nombre, String descripcion) {
    public DatosListadoCurso(Curso curso) {
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
