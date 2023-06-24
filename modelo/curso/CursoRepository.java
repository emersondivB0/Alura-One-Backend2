package com.alura.modelo.curso;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alura.modelo.curso.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

}
