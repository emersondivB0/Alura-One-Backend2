package com.alura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.modelo.topico.Respuesta;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

}