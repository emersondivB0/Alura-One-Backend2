package com.alura.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.modelo.curso.Curso;
import com.alura.modelo.curso.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @GetMapping
    public List<Curso> obtenerTodosLosCursos() {
        return cursoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Curso obtenerCursoPorId(@PathVariable Long id) {
        Optional<Curso> curso = cursoRepository.findById(id);
        return curso.orElse(null);
    }

    @PostMapping
    public Curso crearCurso(@RequestBody Curso curso) {
        return cursoRepository.save(curso);
    }

    @PutMapping("/{id}")
    public Curso actualizarCurso(@PathVariable Long id, @RequestBody Curso curso) {
        Optional<Curso> cursoExistente = cursoRepository.findById(id);
        if (cursoExistente.isPresent()) {
            curso.setId(id);
            return cursoRepository.save(curso);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarCurso(@PathVariable Long id) {
        cursoRepository.deleteById(id);
    }
}
