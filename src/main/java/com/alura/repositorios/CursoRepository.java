package com.alura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
