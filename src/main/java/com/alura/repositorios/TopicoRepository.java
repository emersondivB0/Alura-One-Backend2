package com.alura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
