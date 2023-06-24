package com.alura.modelo.topico;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String mensaje,
        String fecha_creacion,
        String estatus_topico,
        String autor,
        String curso
) {
    public DatosListadoTopico(Topico topico){
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getfechaCreacion().toString(),
                topico.getStatus().toString(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre());
    }
}
