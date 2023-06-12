CREATE TABLE usuarios (
    id BIGINT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL
);