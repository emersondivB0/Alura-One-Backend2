package com.alura.controller;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.modelo.Topico;
import com.alura.repositorios.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public List<Topico> obtenerTodosLosTopicos() {
        return topicoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Topico obtenerTopicoPorId(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        return topico.orElse(null);
    }

    @PostMapping
    public ResponseEntity<Topico> crearTopico(@RequestBody @Valid Topico topico) {
        Topico nuevoTopico = topicoRepository.save(topico);
        return ResponseEntity.ok(nuevoTopico);
    }

    @PutMapping("/{id}")
    public Topico actualizarTopico(@PathVariable Long id, @RequestBody Topico topico) {
        Optional<Topico> topicoExistente = topicoRepository.findById(id);
        if (topicoExistente.isPresent()) {
            topico.setId(id);
            return topicoRepository.save(topico);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void eliminarTopico(@PathVariable Long id) {
        topicoRepository.deleteById(id);
    }
}
