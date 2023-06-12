CREATE TABLE cursos (
    id BIGINT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(1000),
    fecha_creacion TIMESTAMP NOT NULL,
    autor_id BIGINT NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES usuarios(id)
);