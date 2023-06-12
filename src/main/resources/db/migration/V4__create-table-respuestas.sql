CREATE TABLE respuestas (
    id BIGINT PRIMARY KEY,
    mensaje VARCHAR(1000) NOT NULL,
    topico VARCHAR(255) NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL,
    autor_id BIGINT NOT NULL,
    solucion BOOLEAN NOT NULL,
    FOREIGN KEY (autor_id) REFERENCES usuarios(id)
);